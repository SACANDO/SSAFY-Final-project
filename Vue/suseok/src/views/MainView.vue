<template>
  <div class="container">
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

<style scoped>

.container {
  margin: 20px auto;
  padding: 20px;
  width: 600px;
  background-color: rgba(255,255,255,0.9);
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  display: flex;
  flex-direction: column;
}
</style>