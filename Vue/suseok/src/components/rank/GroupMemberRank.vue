<script setup>
import { useRoute } from 'vue-router';

const route = useRoute()
</script>

<template>
  <div class="container">
   <div class="group-actions">
    <!-- <div class="center-link"> -->
      <RouterLink :to="{name: 'groupDetail', params: {groupId: route.params.groupId }}" class="action-button">Group {{ route.params.groupId }}</RouterLink>
    
      <RouterLink :to="{ name: 'boardList', params: { groupId: route.params.groupId } }" class="action-button">게시판</RouterLink>
      <button @click="joinGroup" class="action-button join-group-button">그룹 가입하기</button>
   
  </div>
 <div>
    <h3>Group Member Rank</h3>
    <h3>Group Member Rank</h3>
    <h3>Group Member Rank</h3>
    <h3>Group Member Rank</h3>
    <h3>Group Member Rank</h3>
    <h3>Group Member Rank</h3>
 </div>
</div>
</template>

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

.group-actions {
  margin-bottom: 20px;
  display: flex;
  justify-content: center;
  align-items: center;
  position: relative;
  gap : 20px;
}

.center-link {
  position: absolute;
  left: 50%;
  transform: translateX(-50%);
}


.action-button {
  padding: 10px 20px;
  border: none;

  background-color: rgba(108, 117, 125, 0.5);
  color: white;
  cursor: pointer;
  text-decoration: none;
  display: inline-block;
}

.action-button:hover {
  background-color: #565e64;
}
</style>