import { ref } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'
import { useRouter } from 'vue-router'

const REST_API = `http://localhost:8080`

export const useMainStore = defineStore('main', () => {
  const accessToken = ref('')
  const loginUser = ref({})
  const router = useRouter()

  const login = function(user) {
    axios.post(`${REST_API}/login`, {
      userId: user.userId,
      userPwd: user.userPwd
    })
    .then((response) => {
      accessToken.value = response.data.accessToken
      loginUser.value = { ...user, userNick: response.data.userNick }
      const redirect = router.currentRoute.value.query.redirect || '/'
      router.push(redirect)
    })
    .catch((error) => {
      console.log(error)
      alert('아이디 또는 비밀번호가 틀렸습니다.')
    })
  }

  const logout = function() {
    axios.delete(`${REST_API}/logout`, {
      headers: {
        Authorization: `Bearer ${accessToken.value}`,
      },
    })
    accessToken.value = ''
    loginUser.value = {}
  }

  const loadMainPageInfo = function() {
    if (!accessToken.value) {
      return
    }

    Promise.all([
      axios.get(`${REST_API}/record/my`, {
        headers: {
          Authorization: `Bearer ${accessToken.value}`
        }
      }),
      axios.get(`${REST_API}/user`, {
        headers: {
          Authorization: `Bearer ${accessToken.value}`
        }
      })
    ])
    .then((response) => {
      // 기록을 가지고 뱃지 계산 & 프로필 사진 출력
    })
    .catch((error) => {
      console.log(error)
    })
  }

  return { login, logout, loadMainPageInfo, accessToken, loginUser }
})
