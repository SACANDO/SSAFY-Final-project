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
    axios.post(`${REST_API}/signup`, newUser)
    .then((response) => {
      if (response.status === 201) {
        alert('회원 가입에 성공했습니다.') // 성공 메시지 출력
        router.push({name: 'loginView'})
      }
    })
    .catch((error) => {
      console.log(error)
    })
  }

  const checkId = function(userId) {
    return axios.get(`${REST_API}/signup/ci/${userId}`)
  }

  const checkNick = function(nickname) {
    return axios.get(`${REST_API}/signup/cn/${nickname}`)
  }

  const addRival = function(userId, rivalId) {
    console.log(userId, rivalId)
    console.log(sessionStorage.getItem('accessToken'))
    if (!sessionStorage.getItem('accessToken')) {
      router.push({ name: 'loginView' }) // 로그인 페이지로 이동
      return
    }
    axios.get(`${REST_API}/add/${rivalId}`, {
      headers: { Authorization: `${sessionStorage.getItem('accessToken')}`,
    userId: userId }
    })
    .then((response) => {
      if (response.status === 200) {
        console.log(response.status)
        alert('라이벌로 등록되었습니다.')
      }
    })
    .catch((error) => {
      console.log(error);
      alert('라이벌 등록에 실패했습니다.')
    })
  }

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

  return { router, signup, checkId, checkNick, addRival, getAllUsers, users,
    isIdChecked, accessToken, }
})
