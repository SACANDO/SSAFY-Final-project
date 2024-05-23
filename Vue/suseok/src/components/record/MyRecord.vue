<template>
  <div class="my-record">
    <!-- 나의 페이스 -->
    <div class="section">
      <h3>나의 페이스</h3>
      <canvas id="pace-graph"></canvas>
    </div>

    <!-- 빈도 -->
    <div class="section">
      <h3>빈도</h3>
      <div id="frequency-calendar"></div>
    </div>

    <!-- 누적거리 -->
    <div class="section">
      <h3>누적거리</h3>
      <canvas id="distance-graph"></canvas>
    </div>
  </div>
</template>

<script setup>
import { onMounted } from 'vue';
import { Calendar } from '@fullcalendar/core';
import dayGridPlugin from '@fullcalendar/daygrid';
import Chart from 'chart.js/auto';

onMounted(() => {
  // 페이스 그래프
  const paceCtx = document.getElementById('pace-graph').getContext('2d');
  new Chart(paceCtx, {
    type: 'line',
    data: {
      labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
      datasets: [{
        label: 'Pace',
        data: [65, 59, 80, 81, 56, 55, 40],
        fill: false,
        borderColor: 'rgb(75, 192, 192)',
        tension: 0.1
      }]
    }
  });

  // 누적거리 그래프
  const distanceCtx = document.getElementById('distance-graph').getContext('2d');
  new Chart(distanceCtx, {
    type: 'bar',
    data: {
      labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
      datasets: [{
        label: 'Distance',
        data: [65, 59, 80, 81, 56, 55, 40],
        backgroundColor: 'rgba(75, 192, 192, 0.2)',
        borderColor: 'rgb(75, 192, 192)',
        borderWidth: 1
      }]
    }
  });

  // 빈도 달력
  const calendarEl = document.getElementById('frequency-calendar');
  const calendar = new Calendar(calendarEl, {
    plugins: [dayGridPlugin],
    initialView: 'dayGridMonth',
    events: [
      { title: 'Event 1', date: '2023-05-01' },
      { title: 'Event 2', date: '2023-05-02' }
    ]
  });
  calendar.render();
});
</script>

<style scoped>
.my-record {
  /* 스타일 추가 */
}

.section {
  margin-bottom: 20px;
}

.graph {
  width: 100%;
  height: 300px; /* 그래프 컨테이너의 높이 설정 */
  background-color: #f9f9f9; /* 그래프 컨테이너의 배경색 설정 */
  border: 1px solid #ddd; /* 그래프 컨테이너의 테두리 설정 */
  border-radius: 8px; /* 그래프 컨테이너의 모서리 둥글게 설정 */
  display: flex;
  align-items: center;
  justify-content: center;
}

.calendar {
  width: 100%;
  height: 300px; /* 달력 컨테이너의 높이 설정 */
  background-color: #f9f9f9; /* 달력 컨테이너의 배경색 설정 */
  border: 1px solid #ddd; /* 달력 컨테이너의 테두리 설정 */
  border-radius: 8px; /* 달력 컨테이너의 모서리 둥글게 설정 */
  display: flex;
  align-items: center;
  justify-content: center;
}
</style>