<template>
  <main>
    <h2>MainView</h2>
    <!-- 로그인 전 -->
    <div v-if="!store.accessToken">
      <RouterLink :to="{ name: 'loginView' }">Login</RouterLink> |
      <RouterLink :to="{ name: 'signupView' }">Signup</RouterLink>
    </div>
    <!-- 로그인 후 -->
    <div v-else class="user-info">
      <MyLog />
      <ProfilePicture />
    </div>
    <RouterLink :to="{name: 'createGroup'}">그룹 생성하기</RouterLink>
  </main>
</template>

<script setup>
import ProfilePicture from '@/components/user/ProfilePicture.vue'
import { useMainStore } from '@/stores/main'
import { onMounted } from 'vue'
import MyLog from './MyLog.vue';

const store = useMainStore()

onMounted(() => {
  store.loadMainPageInfo()
})
</script>

<style scoped>
.user-info {
  display: flex;
  align-items: center;
  justify-content: flex-end; /* Align the user info to the right */
  margin-top: 20px;
}

.user-info span {
  margin-left: 10px;
  font-size: 18px;
  color: #333;
}
</style>
