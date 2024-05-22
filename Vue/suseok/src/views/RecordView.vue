<script setup>
import BadgeLog from '@/components/record/BadgeLog.vue';
import MyRecord from '@/components/record/MyRecord.vue';
import RecentRecord from '@/components/record/RecentRecord.vue';

</script>

<template>
    <div class="container">
        <h2>RecordView</h2>
        <MyRecord />
        <br>
        <RecentRecord>RecentRecord</RecentRecord>
        <br>
        <BadgeLog>BadgeLog</BadgeLog>
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
</style>