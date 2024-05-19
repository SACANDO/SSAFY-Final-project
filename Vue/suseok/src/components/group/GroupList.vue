<script setup>
import { ref, computed } from 'vue'
import { useRouter } from 'vue-router'
import { useMainStore } from '@/stores/main'

const store = useMainStore()
const router = useRouter()

const groups = ref([
  { id: 1, name: 'Group A', record: '10:00:00' },
  { id: 2, name: 'Group B', record: '09:45:00' },
  { id: 3, name: 'Group C', record: '11:30:00' },
  { id: 4, name: 'Group D', record: '08:20:00' },
  { id: 5, name: 'Group E', record: '09:55:00' },
  { id: 6, name: 'Group F', record: '07:50:00' },
  { id: 7, name: 'Group G', record: '12:10:00' },
  { id: 8, name: 'Group H', record: '10:25:00' },
  { id: 9, name: 'Group I', record: '08:55:00' },
  { id: 10, name: 'Group J', record: '09:15:00' },
  { id: 11, name: 'Group K', record: '10:05:00' },
  { id: 12, name: 'Group L', record: '11:50:00' },
  { id: 13, name: 'Group M', record: '12:30:00' },
  { id: 14, name: 'Group N', record: '08:45:00' },
  { id: 15, name: 'Group O', record: '07:30:00' },
  { id: 16, name: 'Group P', record: '09:25:00' },
  { id: 17, name: 'Group Q', record: '10:40:00' },
  { id: 18, name: 'Group R', record: '11:20:00' },
  { id: 19, name: 'Group S', record: '08:15:00' },
  { id: 20, name: 'Group T', record: '07:55:00' },
])

const currentPage = ref(1)
const pageSize = 10

const totalPages = computed(() => {
  return Math.ceil(groups.value.length / pageSize);
})

const paginatedGroups = computed(() => {
  const start = (currentPage.value - 1) * pageSize;
  const end = start + pageSize;
  return groups.value.slice(start, end);
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

const joinGroup = (groupId) => {
  if (!store.accessToken) {
    router.push('/login');
  } else {
    // 그룹 가입 로직을 여기에 구현
    console.log(`그룹 ${groupId}에 가입되었습니다.`);
    // 그룹 가입 API 호출 예시
    // axios.post(`/group/${groupId}/join`, {}, {
    //   headers: { Authorization: `Bearer ${store.accessToken}` }
    // }).then((response) => {
    //   console.log(response.data);
    // }).catch((error) => {
    //   console.error(error);
    // });
  }
};
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
    <div v-for="(group, index) in paginatedGroups" :key="group.id" class="group-item">
      <div class="rank">{{ (currentPage - 1) * pageSize + index + 1 }}위</div>
      <RouterLink :to="{ name: 'groupDetail', params: { groupId: group.id } }" class="name">{{ group.name }}</RouterLink>
      <div class="record">{{ group.record }}</div>
      <button @click="joinGroup(group.id)" class="join-button">가입하기</button>
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
