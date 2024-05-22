<script setup>
import { ref, computed } from 'vue'
import { useRouter, RouterLink, RouterView, useRoute } from 'vue-router'
import { useGroupStore } from '@/stores/group'
import GroupMemberRank from '../rank/GroupMemberRank.vue'
import BoardCreate from '../board/BoardCreate.vue';
import BoardView from '@/views/BoardView.vue';
import BoardDetail from '../board/BoardDetail.vue';

const store = useGroupStore()
const router = useRouter()
const route = useRoute()

const joinGroup = function() {
  store.joinGroup(route.params.groupId)
}

// 게시판 페이지인지 여부를 확인하는 계산 속성
const isBoardPage = computed(() => {
  return route.name
})
</script>

<template>
  <div class="group-actions">
    <div class="center-link">
      <RouterLink :to="{name: 'groupDetail', params: {groupId: route.params.groupId }}">Group {{ route.params.groupId }}</RouterLink>
    </div>
    <div class="action-buttons">
      <RouterLink :to="{ name: 'board', params: { groupId: route.params.groupId } }" class="action-button">게시판</RouterLink>
      <button @click="joinGroup" class="action-button join-group-button">그룹 가입하기</button>
    </div>
  </div>
  
  <GroupMemberRank v-if="'groupDetail' === isBoardPage" />
  <BoardCreate v-if="'boardCreate' === isBoardPage" />
  <BoardView v-if="'board' === isBoardPage" />
  <BoardDetail v-if="'boardDetail' === isBoardPage" />
  
</template>

<style scoped>
.group-actions {
  margin-bottom: 20px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  position: relative;
}

.center-link {
  position: absolute;
  left: 50%;
  transform: translateX(-50%);
}

.action-buttons {
  display: flex;
  gap: 10px; /* 요소 간의 간격 */
  margin-left: auto; /* 오른쪽 정렬 */
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
