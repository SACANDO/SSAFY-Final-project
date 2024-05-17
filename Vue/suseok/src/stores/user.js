import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import { useRouter } from 'vue-router'

const REST_BOARD_API = `http://localhost:8000`

export const useUserStore = defineStore('user', () => {

  const accessToken = ref('')
  const loginUser = ref({})
  const router = useRouter()

  const login = function(userInfo) {
    axios.post('/login', userInfo)
    .then((response) => {
      accessToken.value = response.data.accessToken

      loginUser.value = {...userInfo, name: response.data.name}
      router.push()
    })
  }

  const logout = function() {
    // accessToken을 지우면 로그아웃이 되는 것
    accessToken.value = ''
    loginUser.value = {}
  }

  return { accessToken, loginUser, router, login, logout }
})
