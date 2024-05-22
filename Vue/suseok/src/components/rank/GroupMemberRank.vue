<script setup>
import { useRoute } from 'vue-router';

const route = useRoute()
</script>

<template>
   <div class="group-actions">
    <div class="center-link">
      <RouterLink :to="{name: 'groupDetail', params: {groupId: route.params.groupId }}">Group {{ route.params.groupId }}</RouterLink>
    </div>
    <div class="action-buttons">
      <RouterLink :to="{ name: 'boardList', params: { groupId: route.params.groupId } }" class="action-button">게시판</RouterLink>
      <button @click="joinGroup" class="action-button join-group-button">그룹 가입하기</button>
    </div>
  </div>
 <div>
    <h3>Group Member Rank</h3>
    <h3>Group Member Rank</h3>
    <h3>Group Member Rank</h3>
    <h3>Group Member Rank</h3>
    <h3>Group Member Rank</h3>
    <h3>Group Member Rank</h3>
 </div>
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