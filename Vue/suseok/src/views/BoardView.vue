<script setup>
import BoardCreate from '@/components/board/BoardCreate.vue';
import BoardList from '@/components/board/BoardList.vue';

</script>

<template>
    <BoardList />
    <BoardCreate />
    <RouterView />
</template>

<style scoped>
</style>