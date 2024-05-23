<template>
    <div class="recent-activities">
        <h2>나의 최근 활동</h2>
        <div class="activity-container" v-for="activity in recentActivities" :key="activity.date">
            <div class="activity-box">
                <div class="activity-details">
                    <span><strong>날짜</strong></span>
                    <span><strong>거리</strong></span>
                    <span><strong>시간</strong></span>
                    <span><strong>페이스</strong></span>
                </div>
                <div class="activity-details">
                    <span>{{ activity.date }}</span>
                    <span>{{ activity.distance }}</span>
                    <span>{{ activity.time }}</span>
                    <span>{{ activity.pace }}</span>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
import { ref } from 'vue';

// 최근 활동 데이터
const recentActivities = ref([
    { date: '2024-05-20', distance: '5km', time: '30 minutes', pace: '6:00/km' },
    { date: '2024-05-18', distance: '3km', time: '20 minutes', pace: '6:40/km' },
    { date: '2024-05-15', distance: '7km', time: '45 minutes', pace: '6:25/km' }
]);
</script>

<style scoped>
.recent-activities {
    background-color: rgb(2, 21, 30, 0.8);
    border-radius: 10px;
    color: white;
    margin-top: 20px;
}

.activity-container {
    display: flex;
    justify-content: center;
    /* 가운데 정렬을 위한 설정 */
    margin-bottom: 20px;
}

.activity-box {
    border: 1px solid #ccc;
    border-radius: 5px;
    padding: 15px;
    /* 패딩을 늘림 */
    width: 90%;
    display: flex;
    flex-direction: column;
}

.activity-details {
    display: flex;
    justify-content: space-between;
    margin-bottom: 10px;
}

.activity-details span {
    margin-right: 10px;
}
</style>
