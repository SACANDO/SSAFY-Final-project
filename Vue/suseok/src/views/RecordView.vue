<script setup>
import BadgeLog from '@/components/record/BadgeLog.vue';
import MyRecord from '@/components/record/MyRecord.vue';
import RecentRecord from '@/components/record/RecentRecord.vue';
import { useRoute, useRouter } from 'vue-router'


const router = useRouter()

const my = function() {
    router.push({name: 'myRecord'})
}
const recent = function() {
    router.push({name: 'recentRecord'})
}
const badge = function() {
    router.push({name: 'badgeLog'})
}

</script>

<template>
    <div class="container">
        <div>
            <h2>RecordView</h2>
            <button class="btn" @click="my">나의 기록</button>
            <button class="btn" @click="recent">나의 활동</button>
            <button class="btn" @click="badge">나의 뱃지</button>
        </div>
        <RouterView />
    </div>
</template>

<style scoped>
.container {
    margin: 20px auto;
    padding: 20px;
    width: 600px;
    background-color: rgba(255, 255, 255, 0.9);
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    display: flex;
    flex-direction: column;
}

.btn {
    margin-right: 10px;
    margin-bottom: 10px;
    padding: 15px 30px; /* 더 큰 버튼 크기 */
    font-size: 18px; /* 버튼 텍스트 크기 */
}
</style>
