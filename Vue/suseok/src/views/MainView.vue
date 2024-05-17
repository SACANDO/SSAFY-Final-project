<!-- 
  전 : 햄버거, LoginView, SignupView
  후 : 햄버거, 내 로그(뱃지들), 마이 페이지(프사)
 -->

<template>
  <main>
    <h2>MainView</h2>
    <!-- 로그인 전 -->
    <RouterLink v-if="!store.accessToken" :to="{name: 'loginView'}">Login</RouterLink> | 
    <RouterLink v-if="!store.accessToken" :to="{name: 'signupView'}">Signup</RouterLink>
    <!-- 로그인 후 -->
    <!-- 공통 -->
    <ProfilePicture />
    <!-- <RouterLink :to="{name: }"> -->
  </main>
  <RouterView />
</template>

<script setup>
import ProfilePicture from '@/components/user/ProfilePicture.vue'
import { onMounted } from 'vue';

const store = 

onMounted(() => {
  store.loadMainPageInfo()
})

</script>
