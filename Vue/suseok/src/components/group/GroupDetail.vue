<script setup>
import { ref, computed } from 'vue'
import { useRouter, RouterLink, RouterView, useRoute } from 'vue-router'
import { useGroupStore } from '@/stores/group'
import GroupMemberRank from '../rank/GroupMemberRank.vue'

const store = useGroupStore()
const router = useRouter()
const route = useRoute()

const joinGroup = function() {
  store.joinGroup(route.params.groupId)
}

// 게시판 페이지인지 여부를 확인하는 계산 속성
const isBoardPage = computed(() => {
  return route.name === 'board'
})
</script>

<template>
  <RouterLink :to="{name: 'groupDetail', params: {groupId: route.params.groupId }}"></RouterLink>
  <div class="group-actions">
    <RouterLink :to="{ name: 'board', params: { groupId: route.params.groupId } }" class="action-button">게시판</RouterLink>
    <button @click="joinGroup" class="action-button join-group-button">그룹 가입하기</button>
  </div>
  <!-- 게시판 페이지가 아닌 경우에만 GroupMemberRank 표시 -->
  <GroupMemberRank v-if="!isBoardPage" />
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
