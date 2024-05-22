<script setup>
import BadgeLog from '@/components/record/BadgeLog.vue';
import RecentRecord from '@/components/record/RecentRecord.vue';

</script>

<template>
    <h2>RecordView</h2>
    <RouterLink :to="{name: 'myRecord'}">MyRecord</RouterLink>
    <br>
    <RecentRecord>RecentRecord</RecentRecord>
    <br>
    <BadgeLog>BadgeLog</BadgeLog>
</template>

<style scoped>
</style>