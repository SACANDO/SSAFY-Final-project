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
      // console.log(response)
      // console.log(response.data.accessToken)
      // console.log(response.data)
      sessionStorage.setItem('accessToken', response.data.accessToken)
      sessionStorage.setItem('userId', response.data.userId)

      const token = response.data['accessToken'].split('.')
      // console.log("token[0] : " + token[0])
      let id = JSON.parse(atob(token[1]))['id']
      // console.log("id : " + id)
      loginUser.value = { ...user, name: response.data.name }
      const redirect = router.currentRoute.value.query.redirect || '/'
      router.push(redirect)
    })
    .catch((error) => {
      console.log(error)
      alert('아이디 또는 비밀번호가 틀렸습니다.')
    })
  }

  const logout = function() {
    sessionStorage.removeItem('accessToken')
    sessionStorage.removeItem('userId')
    // axios.delete(`${REST_API}/logout`, {
    //   headers: {
    //     userId: loginUser.value.userId
    //   },
    // })
    // .then((response) => {
    //   // 로그아웃 성공 시 localStorage에서 데이터 제거
    //   console.log('로그아웃 성공')
    //   sessionStorage.removeItem('accessToken') // 토큰 제거 (예시)
    //   sessionStorage.removeItem('userId'); // 사용자 데이터 제거 (예시)
    //   // 로그아웃 후 리디렉션 또는 추가 작업
    //   // window.location.href = '/login'; // 로그인 페이지로 리디렉션 (예시)
    // })
    // .catch(error => {
    //   console.error('로그아웃 중 오류 발생:', error)
    //   // 오류 처리
    // })
  }
  

  const loadMainPageInfo = function() {
    if (!accessToken.value) {
      return
    }

    Promise.all([
      axios.get(`${REST_API}/myLog`, {
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

  // 카카오, 네이버, 구글 로그인 구현


  return { accessToken, loginUser, router, login, logout, loadMainPageInfo, }
})
