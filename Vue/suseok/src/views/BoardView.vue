<script setup>
import BoardCreate from '@/components/board/BoardCreate.vue';
import BoardList from '@/components/board/BoardList.vue';

</script>

<template>
    <BoardList />
    <!-- <RouterLink :to="{ name: 'boardCreate', params: { groupId: groupId } }" class="create-board-button">
        게시글 작성
    </RouterLink> -->
    <!-- <RouterView /> -->
</template>

<style scoped>
</style>