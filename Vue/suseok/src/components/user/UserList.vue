<script setup>
import { ref, computed } from 'vue'
import { useRouter } from 'vue-router'
import { useMainStore } from '@/stores/main'

const users = ref([...Array(200).keys()].map(id => ({ id: id + 1, name: `User${id + 1}`, nickname: `nickname${id + 1}`, record: `record${id + 1}` })))
const currentPage = ref(1)
const pageSize = 10
const store = useMainStore()
const router = useRouter()

const totalPages = computed(() => {
  return Math.ceil(users.value.length / pageSize);
})

const paginatedUsers = computed(() => {
  const start = (currentPage.value - 1) * pageSize;
  const end = start + pageSize;
  return users.value.slice(start, end);
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
    endPage = totalPages.value
  }

  for (let i = startPage; i <= endPage; i++) {
    pages.push(i)
  }

  return pages;
})

const setPage = (page) => {
  currentPage.value = page
}

const goToFirstPage = () => {
  currentPage.value = 1
}

const goToLastPage = () => {
  currentPage.value = totalPages.value
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

// 정렬 버튼 클릭 핸들러
const sortByPace = () => {
  console.log('Sort by Pace');
  // 페이스 기준으로 정렬 로직 구현
}

const sortByFrequency = () => {
  console.log('Sort by Frequency');
  // 빈도 기준으로 정렬 로직 구현
}

const sortByDistance = () => {
  console.log('Sort by Distance');
  // 누적 거리 기준으로 정렬 로직 구현
}

const addRival = function(userId) {
  if (!store.accessToken) {
    router.push('/login');
  } else {
    store.addRival(userId);
  }
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
    <!-- 사용자 목록 -->
    <div>
      <div class="user-item header">
        <div class="rank">랭킹</div>
        <div class="name">이름</div>
        <div class="nickname">닉네임</div>
        <div class="record">기록</div>
      </div>
      <div v-for="(user, index) in paginatedUsers" :key="user.id" class="user-item">
        <div class="rank">{{ (currentPage - 1) * pageSize + index + 1 }}위</div>
        <RouterLink :to="{ name: 'compareRank', params: { rivalId: user.id } }" class="name">{{ user.name }}</RouterLink>
        <div class="nickname">{{ user.nickname }}</div>
        <div class="record">{{ user.record }}</div>
        <button @click="addRival(user.id)">라이벌 등록</button>
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
  max-width: 800px; /* 박스의 최대 너비 */
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

.user-item {
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

.nickname {
  text-align: left;
}

.record {
  text-align: left;
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
