<script setup>
import BadgeLog from '@/components/record/BadgeLog.vue';
import MyRecord from '@/components/record/MyRecord.vue';
import RecentRecord from '@/components/record/RecentRecord.vue';

</script>

<template>
    <h2>RecordView</h2>
    <MyRecord />

    <br>
    <RecentRecord>RecentRecord</RecentRecord>
    <br>
    <BadgeLog>BadgeLog</BadgeLog>
</template>

<style scoped>
</style>