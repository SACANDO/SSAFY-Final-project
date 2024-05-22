<!-- <template>
    <div class="board-create-container">
      <h1>게시글 작성</h1>
      <form @submit.prevent="submitForm" class="board-create-form">
        <div class="input-group">
          <label for="title">제목</label>
          <input type="text" id="title" v-model="form.title" placeholder="제목을 입력하세요" required>
        </div>
        <div class="input-group">
          <label for="content">내용</label>
          <textarea id="content" v-model="form.content" placeholder="내용을 입력하세요" required></textarea>
        </div>
        <button type="submit" class="submit-button">등록</button>
      </form>
    </div>
  </template>
  
  <script setup>
  import { ref } from 'vue'
  import { useBoardStore } from '@/stores/board'
  
  const store = useBoardStore()
  
  const form = ref({
    title: '',
    content: ''
  })
  
  const submitForm = function() {
    console.log('Form submitted:', form.value)
    store.createBoard(form.value)
  }
  </script>
  
  <style scoped>
  .board-create-container {
    max-width: 600px;
    margin: 50px auto;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
    background-color: #f9f9f9;
  }
  
  .input-group {
    display: flex;
    flex-direction: column;
    margin-bottom: 15px;
  }
  
  .input-group label {
    margin-bottom: 5px;
    font-weight: bold;
  }
  
  .input-group input,
  .input-group textarea {
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 4px;
    width: 100%;
    resize: vertical;
  }
  
  .submit-button {
    width: 100%;
    padding: 10px;
    border: none;
    border-radius: 4px;
    background-color: #4CAF50;
    color: white;
    cursor: pointer;
  }
  
  .submit-button:hover {
    background-color: #45a049;
  }
  </style>
-->

<template>
  <div class="board-create-container">
    <h1>게시글 작성</h1>
    <form @submit.prevent="submitForm" class="board-create-form">
      <div class="input-row">
        <div class="input-group medium-input">
          <input type="text" id="title" v-model="form.title" placeholder="제목" required>
        </div>
      </div>
      <div class="input-group">
        <label for="content" class="content-label">글 내용 작성</label>
        <textarea id="content" v-model="form.content" placeholder="글 내용 작성" required></textarea>
      </div>
      <div class="button-row">
        <button type="button" class="attach-button">사진 첨부하기</button>
        <button type="submit" class="submit-button">작성완료</button>
      </div>
    </form>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useBoardStore } from '@/stores/board'
import { useMainStore } from '@/stores/main' // 사용자의 정보를 가져오는 스토어
import { useRoute } from 'vue-router';

const route = useRoute()
const boardStore = useBoardStore()
const mainStore = useMainStore() // 사용자 스토어 인스턴스

const userId = ref(mainStore.loginUser.userId)  // 현재 사용자의 ID
const userName = ref(mainStore.loginUser.userName) // 현재 사용자의 이름 가져오기

const form = ref({
  groupId: route.params.groupId,
  writerId: sessionStorage.getItem('userId'),
  title: '',
  content: '',
  img: '',
  notice: false
})

const submitForm = function() {


  boardStore.createBoard(form.value)
}
</script>

<style scoped>
.board-create-container {
  max-width: 800px;
  margin: 50px auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  background-color: #f9f9f9;
}

.input-row {
  display: flex;
  justify-content: space-between;
  margin-bottom: 15px;
}

.input-group {
  display: flex;
  flex-direction: column;
  margin-right: 10px;
}

.input-group:last-child {
  margin-right: 0;
}

.medium-input {
  flex: 1.5; /* 제목 input 박스의 크기를 중간까지만 오게 설정 */
}

.small-input {
  flex: 0.5; /* 작성자 input 박스의 크기를 절반으로 설정 */
}

.input-group label {
  margin-bottom: 5px;
  font-weight: bold;
}

.content-label {
  align-self: flex-start; /* label을 왼쪽에 정렬 */
}

.input-group input {
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
  width: 96.8%;
  resize: vertical;
}

.input-group textarea {
  margin-bottom: 10px;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
  width: 98%;
  resize: vertical;
}

.input-group textarea {
  height: 150px; /* 내용 입력 박스의 높이를 더 크게 설정 */
}

.input-group input[readonly] {
  background-color: #e9e9e9;
}

.button-row {
  display: flex;
  justify-content: space-between;
}

.attach-button {
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
  background-color: #e9e9e9;
  cursor: pointer;
}

.submit-button {
  padding: 10px 20px;
  border: none;
  border-radius: 4px;
  background-color: #4CAF50;
  color: white;
  cursor: pointer;
}

.submit-button:hover {
  background-color: #45a049;
}
</style>