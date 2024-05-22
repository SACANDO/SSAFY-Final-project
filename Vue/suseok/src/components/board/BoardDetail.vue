<template>
  <div class="board-detail-container">
    <h1 class="board-title">{{ board.title }}</h1>
    <div v-if="board.img" class="board-image-container">
      <img :src="board.img" alt="Board Image" class="board-image" />
    </div>
    <div class="board-content">
      <p>{{ board.content }}</p>
    </div>
    <p v-if="board.notice" class="board-notice">Notice: This is an important board.</p>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { useRoute } from 'vue-router';
import axios from 'axios';

const route = useRoute();
const board = ref({});

const fetchBoardDetail = () => {
  const { groupId, id } = route.params;
  axios.get(`http://localhost:8080/group/${groupId}/board/${id}`, {
    headers: {
      Authorization: `${sessionStorage.getItem('accessToken')}`,
      userId: sessionStorage.getItem('userId')
    }
  })
  .then(response => {
    board.value = response.data;
  })
  .catch(error => {
    console.error('Error fetching board details:', error);
  });
};

onMounted(fetchBoardDetail);
</script>

<style scoped>
.board-detail-container {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
  border: 1px solid #ddd;
  border-radius: 8px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  background-color: #fff;
}

.board-title {
  font-size: 28px;
  font-weight: bold;
  margin-bottom: 20px;
  color: #333;
}

.board-image-container {
  text-align: center;
  margin-bottom: 20px;
}

.board-image {
  max-width: 100%;
  height: auto;
  border-radius: 8px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.board-content {
  font-size: 18px;
  line-height: 1.6;
  color: #555;
  margin-bottom: 20px;
}

.board-notice {
  padding: 10px;
  background-color: #ffefc1;
  border: 1px solid #ffd700;
  border-radius: 4px;
  font-weight: bold;
  color: #a67c00;
}
</style>
