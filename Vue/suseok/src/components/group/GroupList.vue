<script setup>
import { ref, computed, onMounted } from 'vue'
import { useRouter } from 'vue-router'
import { useMainStore } from '@/stores/main'
import { useGroupStore } from '@/stores/group'

const groupStore = useGroupStore()
const router = useRouter()

const currentPage = ref(1)
const pageSize = 10

// onMounted에서 그룹 데이터를 불러옵니다.
onMounted(() => {
  groupStore.getGroups()
})

const totalPages = computed(() => {
  return Math.ceil(groupStore.groups.length / pageSize);
})

const paginatedGroups = computed(() => {
  const start = (currentPage.value - 1) * pageSize
  const end = start + pageSize
  return groupStore.groups.slice(start, end)
})

const visiblePages = computed(() => {
  let pages = []
  let startPage = Math.max(1, currentPage.value - 2)
  let endPage = Math.min(totalPages.value, currentPage.value + 2)

  if (startPage === 1) {
    endPage = Math.min(5, totalPages.value)
  } else if (endPage === totalPages.value) {
    startPage = Math.max(1, totalPages.value - 4)
  }

  if (totalPages.value < 5) {
    startPage = 1
    endPage = totalPages.value;
  }

  for (let i = startPage; i <= endPage; i++) {
    pages.push(i)
  }

  return pages
})

const setPage = function(page) {
  currentPage.value = page
}

const goToFirstPage = function() {
  currentPage.value = 1
}

const goToLastPage = () => {
  currentPage.value = totalPages.value;
}

const goToNextPage = () => {
  if (currentPage.value < totalPages.value) {
    currentPage.value++
  }
}

const goToPreviousPage = () => {
  if (currentPage.value > 1) {
    currentPage.value--
  }
}

const joinGroup = function(groupId) {
  groupStore.joinGroup(groupId)
}
</script>

<template>
<div class="container">
  <!-- 정렬 버튼 -->
  <div class="sort-buttons">
    <button @click="sortByPace">페이스</button>
    <button @click="sortByFrequency">빈도</button>
    <button @click="sortByDistance">누적거리</button>
  </div>
  <!-- 그룹 목록 -->
  <div>
    <div class="group-item header">
      <div class="rank">랭킹</div>
      <div class="name">이름</div>
      <div class="record">기록</div>
    </div>
    <div v-for="(group, index) in paginatedGroups" :key="group.groupId" class="group-item">
      <div class="rank">{{ (currentPage - 1) * pageSize + index + 1 }}위</div>
      <RouterLink :to="{ name: 'groupDetail', params: { groupId: group.groupId } }" class="name">{{ group.groupName }}</RouterLink>
      <div class="record">{{ group.groupPace }}</div>
      <button @click="joinGroup(group.groupId)" class="join-button">가입하기</button>
    </div>
  </div>
  <!-- 페이지네이션 -->
  <div class="pagination">
    <button @click="goToFirstPage">&laquo;</button>
    <button @click="goToPreviousPage">&lsaquo;</button>
    <button v-for="page in visiblePages" :key="page" @click="setPage(page)" :class="{ 'active': currentPage === page }">
      {{ page }}
    </button>
    <button @click="goToNextPage">&rsaquo;</button>
    <button @click="goToLastPage">&raquo;</button>
  </div>
</div>
</template>

<style scoped>
.container {
  max-width: 800px; /* 박스의 최대 너비 유지 */
  margin: 0 auto;
  padding: 20px;
}

.sort-buttons {
  display: flex;
  gap: 10px;
  margin-bottom: 20px;
}

.sort-buttons button {
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
  background-color: #f4f4f4;
  cursor: pointer;
}

.group-item {
  display: grid;
  grid-template-columns: 50px 150px 150px 100px auto;
  align-items: center;
  margin-bottom: 10px;
}

.header {
  font-weight: bold;
}

.rank {
  width: 50px;
}

.name {
  text-align: left;
}

.record {
  text-align: left;
}

.join-button {
  padding: 5px 10px;
  border: none;
  border-radius: 5px;
  background-color: #4CAF50;
  color: white;
  cursor: pointer;
}

.join-button:hover {
  background-color: #45a049;
}

.pagination {
  margin-top: 20px;
  text-align: center;
}

.pagination button {
  margin: 0 2px;
  padding: 5px 10px;
  border: 1px solid #ccc;
  background-color: #f4f4f4;
  cursor: pointer;
}

.pagination .active {
  background-color: #666;
  color: white;
}
</style>
