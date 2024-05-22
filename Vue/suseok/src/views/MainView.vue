<template>
  <div>
    로그인 화면
    <MyLog />
    <br>
    <ProfilePicture />
  </div>
</template>

<script setup>

import { onMounted, ref } from 'vue'
import { useUserStore } from '@/stores/user';
import { useMainStore } from '@/stores/main';
import ProfilePicture from '@/components/user/ProfilePicture.vue';
import MyLog from './MyLog.vue';

const userStore = useUserStore();
const token = ref('')
onMounted(() => {
  token.value = sessionStorage.getItem('accessToken')
  userStore.accessToken = token.value

  console.log(userStore.accessToken)
})
</script>

<style scoped></style>