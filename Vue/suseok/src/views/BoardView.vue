<script setup>
import BoardCreate from '@/components/board/BoardCreate.vue';
import BoardList from '@/components/board/BoardList.vue';
import { useRoute } from 'vue-router'

const route = useRoute()
</script>

<template>
    <BoardList />
    <p>{{  }}</p>
    <!-- <RouterLink :to="{ name: 'boardCreate', params: { groupId: route.params.groupId } }" class="create-board-button">
        게시글 작성
    </RouterLink> -->
    <!-- <RouterView /> -->
</template>

<style scoped>
</style>