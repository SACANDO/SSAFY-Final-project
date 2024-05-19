<script setup>
import BoardCreate from '@/components/board/BoardCreate.vue';
import BoardList from '@/components/board/BoardList.vue';

</script>

<template>
    <BoardList />
    <RouterLink :to="{name: BoardCreate}">글쓰기</RouterLink>
    <BoardCreate />
    <!-- <RouterView /> -->
</template>

<style scoped>
</style>