<template>
    <div class="container">
      <h4>게시글 목록</h4>
      <hr />
      <table>
        <tr>
          <th>번호</th>
          <th>제목</th>
          <th>작성자</th>
          <th>조회수</th>
          <th>등록일</th>
        </tr>
        <tr v-for="board in paginatedBoards" :key="board.id">
          <td>{{ board.id }}</td>
          <td>
            <RouterLink :to="`/group/${groupId}/board/${board.id}`">{{ board.title }}</RouterLink>
          </td>
          <td>{{ board.writer }}</td>
          <td>{{ board.viewCnt }}</td>
          <td>{{ board.regDate }}</td>
        </tr>
      </table>
  
      <!-- 검색창 -->
      <div class="search-container">
        <select v-model="searchFilter" class="search-filter">
          <option value="title">제목</option>
          <option value="writer">작성자 이름</option>
          <option value="nickname">작성자 닉네임</option>
        </select>
        <div class="search-input-container">
          <input type="text" v-model="searchQuery" placeholder="Search..." class="search-input" />
          <button @click="performSearch" class="search-button">🔍</button>
        </div>
        <RouterLink :to="{ name: 'boardCreate', params: { groupId: groupId } }" class="create-board-button">
          게시글 작성
        </RouterLink>
      </div>
  
      <!-- 페이지네이션 -->
      <div class="pagination">
        <button @click="goToFirstPage">&laquo;</button>
        <button @click="goToPreviousPage">&lsaquo;</button>
        <button v-for="page in visiblePages" :key="page" @click="setPage(page)" :class="{ active: currentPage === page }">
          {{ page }}
        </button>
        <button @click="goToNextPage">&rsaquo;</button>
        <button @click="goToLastPage">&raquo;</button>
      </div>
    </div>
  </template>
  
  <script setup>
  import { ref, computed, onMounted } from 'vue'
  import { useRouter } from 'vue-router'
  
  const router = useRouter()
  const groupId = 1 // 이 부분은 실제 그룹 ID로 대체해야 합니다.
  
  const currentPage = ref(1)
  const pageSize = 10
  const boards = ref([])
  const searchQuery = ref('')
  const searchFilter = ref('title')
  
  const generateBoardData = function (numberOfBoards) {
    const boardList = []
    for (let i = 1; i <= numberOfBoards; i++) {
      boardList.push({
        id: i,
        title: `Title ${i}`,
        writer: `Writer ${Math.floor(Math.random() * 100) + 1}`,
        nickname: `Nickname ${Math.floor(Math.random() * 100) + 1}`,
        viewCnt: Math.floor(Math.random() * 1000),
        regDate: new Date().toLocaleString(),
      })
    }
    return boardList
  }
  
  onMounted(() => {
    boards.value = generateBoardData(50)
  })
  
  const filteredBoards = computed(() => {
    if (!searchQuery.value) {
      return boards.value
    }
    return boards.value.filter(board => {
      return board[searchFilter.value].toLowerCase().includes(searchQuery.value.toLowerCase())
    })
  })
  
  const totalPages = computed(() => {
    return Math.ceil(filteredBoards.value.length / pageSize)
  })
  
  const paginatedBoards = computed(() => {
    const start = (currentPage.value - 1) * pageSize
    const end = start + pageSize
    return filteredBoards.value.slice(start, end)
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
  
    return pages
  })
  
  const setPage = page => {
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
  
  const performSearch = () => {
    currentPage.value = 1 // 검색 시 페이지를 첫 페이지로 이동
  }
  </script>
  
  <style scoped>
  .container {
    max-width: 800px; /* 박스의 최대 너비 */
    margin: 0 auto;
    padding: 20px;
  }
  
  table {
    width: 100%;
    border-collapse: collapse;
    margin-bottom: 20px;
  }
  
  th, td {
    border: 1px solid #ccc;
    padding: 8px;
    text-align: left;
  }
  
  th {
    background-color: #f4f4f4;
  }
  
  .search-container {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 20px;
  }
  
  .search-filter {
    width: 20%;
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 4px;
  }
  
  .search-input-container {
    position: relative;
    width: 60%;
  }
  
  .search-input {
    width: 100%;
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 4px;
  }
  
  .search-button {
    position: absolute;
    right: 0;
    top: 0;
    height: 100%;
    background: none;
    border: none;
    cursor: pointer;
    font-size: 16px;
  }
  
  .create-board-button {
    padding: 8px 16px;
    border: none;
    border-radius: 5px;
    background-color: #4CAF50;
    color: white;
    cursor: pointer;
    text-decoration: none;
    text-align: center;
    display: inline-block;
  }
  
  .create-board-button:hover {
    background-color: #45a049;
  }
  
  .pagination {
    display: flex;
    justify-content: center;
    gap: 5px;
    margin-bottom: 20px;
  }
  
  .pagination button {
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
  