<!-- <script setup>
</script>

<template>
    <div>
        
            <RouterLink :to="{name: groupDetail, params: {groupId: 'groupId'}}">Group</RouterLink>
            이런식으로 넘겨야겠지?
        
        <RouterLink :to="{name: groupDetail}">Group1 클릭하면 해당 그룹 Detail페이지로 이동</RouterLink>
        <br>
        <RouterLink :to="{name: groupDetail}">Group2</RouterLink>
        <br>
        <RouterLink :to="{name: groupDetail}">Group3</RouterLink>
    </div>
</template>

<style scoped>
</style> -->

<script setup>
import { ref, computed } from 'vue';
import { RouterLink } from 'vue-router';

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
]);

const currentPage = ref(1);
const pageSize = 10;

const totalPages = computed(() => {
  return Math.ceil(groups.value.length / pageSize);
});

const paginatedGroups = computed(() => {
  const start = (currentPage.value - 1) * pageSize;
  const end = start + pageSize;
  return groups.value.slice(start, end);
});

const visiblePages = computed(() => {
  let pages = [];
  let startPage = Math.max(1, currentPage.value - 2);
  let endPage = Math.min(totalPages.value, currentPage.value + 2);

  if (startPage === 1) {
    endPage = Math.min(5, totalPages.value);
  } else if (endPage === totalPages.value) {
    startPage = Math.max(1, totalPages.value - 4);
  }

  if (totalPages.value < 5) {
    startPage = 1;
    endPage = totalPages.value;
  }

  for (let i = startPage; i <= endPage; i++) {
    pages.push(i);
  }

  return pages;
});

const setPage = (page) => {
  currentPage.value = page;
};

const goToFirstPage = () => {
  currentPage.value = 1;
};

const goToLastPage = () => {
  currentPage.value = totalPages.value;
};

const goToNextPage = () => {
  if (currentPage.value < totalPages.value) {
    currentPage.value++;
  }
};

const goToPreviousPage = () => {
  if (currentPage.value > 1) {
    currentPage.value--;
  }
};

// 정렬 버튼 클릭 핸들러
const sortByPace = () => {
  console.log('Sort by Pace');
  // 페이스 기준으로 정렬 로직 구현
};

const sortByFrequency = () => {
  console.log('Sort by Frequency');
  // 빈도 기준으로 정렬 로직 구현
};

const sortByDistance = () => {
  console.log('Sort by Distance');
  // 누적 거리 기준으로 정렬 로직 구현
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
      <p class="name">{{ group.name }}</p>
      <!-- <RouterLink :to="{ name: 'groupDetail', params: { groupId: group.id } }" class="name">{{ group.name }}</RouterLink> -->
      <div class="record">{{ group.record }}</div>
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
  max-width: 800px; /* 박스의 최대 너비 줄이기 */
  margin: 0 auto;
  margin-left: 0px;
  padding: 20px; /* 안쪽 여백 줄이기 */
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
  margin-left: 57px;
}

.record {
  text-align: left;
}

.pagination {
  margin-top: 20px;
  margin-left: 10%;
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
