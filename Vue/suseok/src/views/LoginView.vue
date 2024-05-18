<!-- 
    findId, findPwd, SignupView, kakao & naver & google Login
 -->
<template>
  <div class="login-container">
    <h1>로그인</h1>
    <form @submit.prevent="login" class="login-form">
      <div class="input-group">
        <input type="text" id="id" v-model="user.userId" placeholder="아이디" required>
      </div>
      <div class="input-group">
        <input type="password" id="password" v-model="user.userPwd" placeholder="비밀번호" required>
      </div>
      <button type="submit" class="login-button">로그인</button>
    </form>
    <div class="links">
      <router-link to="/find-id">아이디 찾기</router-link> |
      <router-link to="/find-password">비밀번호 찾기</router-link> |
      <router-link to="/signup">회원가입</router-link>
    </div>
    <div class="social-login">
      <button @click="loginWithKakao" class="social-button kakao">카카오 로그인</button>
      <button @click="loginWithNaver" class="social-button naver">네이버 로그인</button>
      <button @click="loginWithGoogle" class="social-button google">구글 로그인</button>
    </div>
  </div>
</template>

<script setup>
import { useUserStore } from '@/stores/user';
import { ref } from 'vue'

const store = useUserStore()

const user = ref({
  userId: '',
  userPwd: ''
})

const login = function () {
  store.login(user.value)
}

const loginWithKakao = function () {
  console.log('Logging in with Kakao')
  // 여기에 카카오 로그인 로직 구현
}

const loginWithNaver = function () {
  console.log('Logging in with Naver')
  // 여기에 네이버 로그인 로직 구현
}

const loginWithGoogle = function () {
  console.log('Logging in with Google')
  // 여기에 구글 로그인 로직 구현
}
</script>

<style scoped>
.login-container {
  max-width: 400px;
  margin: 50px auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  background-color: #f9f9f9;
  text-align: center;
}

.input-group {
  display: flex;
  flex-direction: column;
  margin-bottom: 10px;
}

.input-group input {
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

.login-button {
  width: 100%;
  padding: 10px;
  border: none;
  border-radius: 4px;
  background-color: #4CAF50;
  color: white;
  cursor: pointer;
}

.login-button:hover {
  background-color: #45a049;
}

.links {
  margin: 20px 0;
}

.links a {
  color: #4CAF50;
  text-decoration: none;
}

.links a:hover {
  text-decoration: underline;
}

.social-login {
  display: flex;
  flex-direction: column;
  gap: 10px;
  margin-top: 20px;
}

.social-button {
  width: 100%;
  padding: 10px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  color: white;
}

.kakao {
  background-color: #FEE500;
  color: #3C1E1E;
}

.naver {
  background-color: #1EC800;
}

.google {
  background-color: #DB4437;
}
</style>