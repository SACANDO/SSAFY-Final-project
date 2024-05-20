import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'
import { useRouter } from 'vue-router'

const REST_API = `http://localhost:8080/user`

export const useUserStore = defineStore('user', () => {
  const router = useRouter()

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
    return axios.get(`${REST_API}/signup/${userId}`, userId)
    .then((response) => {
      console.log(response)
      return response.data.exists
    })
    .catch((error) => {
      console.error(error)
      return false
    })
  }

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

  return { router, signup, checkId, checkNickname }
})
