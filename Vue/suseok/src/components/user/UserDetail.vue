<template>
    <div class="comparison-container">
      <h2>기록 비교</h2>
      <div class="record-grid">
        <div class="user-column">
          <h3>나의 기록</h3>
        </div>
        <div class="user-column">
          <h3>상대방의 기록</h3>
        </div>
  
        <div class="record-item">
          <span class="label">페이스:</span> <span class="value">{{ myRecord.pace }}</span>
        </div>
        <div class="record-item">
          <span class="value">{{ rivalRecord.pace }}</span>
        </div>
  
        <div class="record-item">
          <span class="label">빈도:</span> <span class="value">{{ myRecord.frequency }}</span>
        </div>
        <div class="record-item">
          <span class="value">{{ rivalRecord.frequency }}</span>
        </div>
  
        <div class="record-item">
          <span class="label">누적거리:</span> <span class="value">{{ myRecord.totalDistance }}</span>
        </div>
        <div class="record-item">
          <span class="value">{{ rivalRecord.totalDistance }}</span>
        </div>
      </div>
    </div>
  </template>
  
  <script setup>
  import { ref, onMounted } from 'vue'
  import { useRoute } from 'vue-router'
  import axios from 'axios'
  import { useUserStore } from '@/stores/user'
  
  const myRecord = ref({})
  const rivalRecord = ref({})
  const route = useRoute()
  const store = useUserStore()
  
  const fetchRecords = function() {
    axios.get(`http://localhost:8080/record/my`, {
      headers: {
        Authorization: `Bearer ${store.accessToken}`,
      },
    })
    .then((response) => {
      myRecord.value = response.data
      return axios.get(`http://localhost:8080/user/${route.params.rivalId}/record`, {
        headers: {
          Authorization: `Bearer ${store.accessToken}`,
        },
      })
    })
    .then((response) => {
      rivalRecord.value = response.data;
    })
    .catch((error) => {
      console.error('Failed to fetch records:', error)
    })
  }
  
  onMounted(() => {
    fetchRecords();
  });
  </script>
  
  <style scoped>
  .comparison-container {
    max-width: 800px;
    margin: 0 auto;
    padding: 20px;
    background-color: #f9f9f9;
    border: 1px solid #ccc;
    border-radius: 5px;
  }
  
  .record-grid {
    display: grid;
    grid-template-columns: 1fr 1fr;
    gap: 10px;
    margin-top: 20px;
  }
  
  .user-column {
    text-align: center;
    font-weight: bold;
  }
  
  .record-item {
    display: flex;
    justify-content: space-between;
    padding: 10px;
    background-color: #fff;
    border: 1px solid #ccc;
    border-radius: 5px;
  }
  
  .label {
    font-weight: bold;
  }
  
  .value {
    margin-left: 10px;
  }
  </style>
  