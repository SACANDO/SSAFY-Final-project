import { ref } from 'vue';
import { defineStore } from 'pinia';
import axios from 'axios';
import { useRouter } from 'vue-router';

const REST_API = `http://localhost:8080/user`;

export const useUserStore = defineStore('user', () => {
  const router = useRouter();
  const accessToken = ref('');
  const isIdChecked = ref(false);

  const signup = function(newUser) {
    if (!isIdChecked.value) {
      alert('아이디 중복확인을 해주세요.');
      return;
    }
    axios.post(`${REST_API}/signup`, newUser)
      .then((response) => {
        if (response.status === 201) {
          alert('회원 가입에 성공했습니다.');
          router.push('/login');
        }
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const checkId = function(userId) {
    return axios.get(`${REST_API}/signup/ci/${userId}`)
      .then((response) => {
        return response.data.exists;
      })
      .catch((error) => {
        console.log(error);
        return false;
      });
  };

  const checkNickname = function(nickname) {
    return axios.get(`${REST_API}/check-nickname`, {
      params: { nickname }
    })
      .then((response) => {
        return response.data.exists;
      })
      .catch((error) => {
        console.log(error);
        return false;
      });
  };

  const addRival = function(rivalId) {
    return axios.post(`${REST_API}/add/${rivalId}`, {}, {
      headers: { Authorization: `Bearer ${accessToken.value}` }
    })
    .then((response) => {
      if (response.status === 200) {
        alert('라이벌로 등록되었습니다.');
      }
    })
    .catch((error) => {
      console.log(error);
      alert('라이벌 등록에 실패했습니다.');
    });
  };

  return { 
    router, 
    signup, 
    checkId, 
    checkNickname,
    addRival,
    isIdChecked,
    accessToken
  };
});
