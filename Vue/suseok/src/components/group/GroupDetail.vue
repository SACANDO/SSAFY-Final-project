<script setup>
import { ref } from 'vue'
import { useRouter, RouterLink } from 'vue-router'
import { useMainStore } from '@/stores/main'
import GroupMemberRank from '../rank/GroupMemberRank.vue'

const store = useMainStore()
const router = useRouter()

const joinGroup = function() {
  if (!store.accessToken) {
    router.push('/login')
  } else {
    // 그룹 가입 로직을 여기에 구현
    console.log('그룹에 가입되었습니다.')
    // 그룹 가입 API 호출 예시
    // axios.post(`/group/${groupId}/join`, {}, {
    //   headers: { Authorization: `Bearer ${store.accessToken}` }
    // }).then((response) => {
    //   console.log(response.data)
    // }).catch((error) => {
    //   console.error(error)
    // })
  }
}
</script>

<template>
  <h3>GroupDetail</h3>
  <div class="group-actions">
    <RouterLink :to="{ name: 'board' }" class="action-button">게시판</RouterLink>
    <button @click="joinGroup" class="action-button join-group-button">그룹 가입하기</button>
  </div>
  <GroupMemberRank />
  <RouterView />
</template>

<style scoped>
.group-actions {
  margin-bottom: 20px;
  text-align: right;
}

.action-button {
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  background-color: #4CAF50;
  color: white;
  cursor: pointer;
  text-decoration: none;
  display: inline-block;
}

.action-button:hover {
  background-color: #45a049;
}
</style>
