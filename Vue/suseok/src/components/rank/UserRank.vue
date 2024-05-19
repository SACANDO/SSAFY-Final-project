<script setup>
import { ref } from 'vue';
import UserList from '../user/UserList.vue';

const searchQuery = ref('');
const searchFilter = ref('id'); // 기본 필터는 'id'

const performSearch = () => {
  // 검색 로직을 여기에 구현
  console.log(`검색 실행 - 필터: ${searchFilter.value}, 쿼리: ${searchQuery.value}`)
}
</script>

<template>
  <h3>UserRank</h3>
  <div class="user-list-container">
    <UserList :users="users" :search-query="searchQuery" :search-filter="searchFilter" />
  </div>
  <div class="search-container">
    <!-- 필터 선택 드롭다운 메뉴 -->
    <select v-model="searchFilter" class="search-filter">
      <option value="id">ID</option>
      <option value="nickname">닉네임</option>
      <option value="name">이름</option>
    </select>
    <!-- 검색 입력란 -->
    <input type="text" v-model="searchQuery" placeholder="Search users..." />
    <!-- 돋보기 아이콘 버튼 -->
    <button @click="performSearch" class="search-button">🔍</button>
  </div>
</template>

<style scoped>
.user-list-container {
  margin: 20px auto;
  padding: 20px;
  width: 600px;
  background-color: #f4f4f4;
  border: 1px solid #ccc;
  border-radius: 20px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  display: flex;
  flex-direction: column;
}

.search-container {
  margin: 10px auto;
  width: 550px;
  position: relative;
  display: flex;
  align-items: center; /* 중앙 정렬 */
}

.search-filter {
  margin-right: 5px;
  font-size: 16px;
  border: 1px solid #ccc;
  border-radius: 5px;
  padding: 5px 5px;
  height: 37px;
}

input[type='text'] {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
}

.search-button {
  position: absolute;
  right: 10px;
  top: 46%;
  transform: translateY(-50%);
  background: none;
  border: none;
  cursor: pointer;
  font-size: 16px;
}
</style>
