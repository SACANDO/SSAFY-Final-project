<template>
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
  
  const boardStore = useBoardStore()
  
  const form = ref({
    title: '',
    content: ''
  })
  
  const submitForm = function() {
    console.log('Form submitted:', form.value)
    boardStore.createBoard(form.value)
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
  