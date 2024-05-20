import { ref } from 'vue';
import { defineStore } from 'pinia';
import axios from 'axios';
import { useRouter } from 'vue-router';

const REST_API = `http://localhost:8080/user`;

export const useUserStore = defineStore('user', () => {
  const router = useRouter();
  const accessToken = ref('');
  const isIdChecked = ref(false);
  const users = ref([]); // Array to store user information

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
    return axios.get(`${REST_API}/signup/cn/${userId}`) // 경로 수정
      .then((response) => {
        return response.status === 200 // HTTP 상태 코드로 아이디 중복 여부 확인
      })
      .catch((error) => {
        console.log(error)
        return false
      })
  }
  
  // const checkId = function(userId) {
  //   return axios.get(`${REST_API}/signup/ci/${userId}`)
  //     .then((response) => {
  //       console.log(response)
  //       return response.data.exists
  //     })
  //     .catch((error) => {
  //       console.log(error);
  //       return false
  //     })
  // }

  const checkNickname = function(nickname) {
    return axios.get(`${REST_API}/check-nickname`, {
      params: { nickname }
    })
      .then((response) => {
        return response.data.exists
      })
      .catch((error) => {
        console.log(error)
        return false
      })
  }

  const addRival = function(rivalId) {
    if (!accessToken.value) {
      router.push({ name: 'loginView' }); // 로그인 페이지로 이동
      return;
    }
    axios.post(`${REST_API}/add/${rivalId}`, {}, {
      headers: { Authorization: `Bearer ${accessToken.value}` }
    })
    .then((response) => {
      if (response.status === 200) {
        console.log(response.status);
        alert('라이벌로 등록되었습니다.');
      }
    })
    .catch((error) => {
      console.log(error);
      alert('라이벌 등록에 실패했습니다.');
    });
  };

  const getAllUsers = function() {
    return axios.get(REST_API, 
      // { headers: { Authorization: `Bearer ${accessToken.value}` } }
      )
    .then((response) => {
      users.value = response.data;
    })
    .catch((error) => {
      console.log(error);
    });
  };

  return { 
    router, 
    signup, 
    checkId, 
    checkNickname,
    addRival,
    getAllUsers,
    users,
    isIdChecked,
    accessToken
  };
});
