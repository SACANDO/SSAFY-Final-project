import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'
import { useRouter } from 'vue-router'

const REST_API = `http://localhost:8000`

export const useUserStore = defineStore('user', () => {

  const accessToken = ref('')
  const loginUser = ref({})
  const router = useRouter()

  const login = function(userInfo) {
    axios.post('/login', userInfo)
    .then((response) => {
      accessToken.value = response.data.accessToken

      loginUser.value = {...userInfo, name: response.data.name}

      const redirect = router.currentRoute.value.query.redirect
      router.push(redirect)
    })
    .catch((error) => {
      alert('아이디 또는 비밀번호가 틀렸습니다.')
    })
  }

  const logout = function() {
    // accessToken을 지우면 로그아웃이 되는 것
    // 백으로 로그아웃 요청을 보낸 후 사용자에 대한 정보를 리셋
    accessToken.value = ''
    loginUser.value = {}
  }

  // 
  const loadMainPageInfo = function() {
    
    if (!accessToken.value) {
      return
    }

    // 로그인에 성공해서 MainPage가 렌더링 될 때
    // /record/my로 내 기록을 요청함
    // 내 기록을 받아와서 기록에 따라 현재 나의 뱃지를 보여줌
    // /user로 내 정보를 요청함
    // 내 정보에서 프로필 사진을 가져와서 보여줌
    Promise.all([
      axios.get({name: 'myRecord'}),
      axios.get({name: 'UserView'})
    ])
    .then((response) => {
      // 기록을 가지고 뱃지 계산 & 프로필 사진 출력
    })
    .catch((error) => {
      // 에러를 처리하는 로직
    })


    // 여러 개의 요청을 보낼 일이 있으면 Promise.all
    // Promise.all([])
  }

  return { accessToken, loginUser, router, login, logout, loadMainPageInfo }
})
