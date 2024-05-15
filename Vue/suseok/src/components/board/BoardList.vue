<template>
    <div>
        <h4>게시글 목록</h4>
        <hr>
        <table>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>조회수</th>
                <th>등록일</th>
            </tr>
            <tr v-for="board in store.boardList" :key="board.id">
                <td>{{ board.id }}</td>
                <td>
                    <!-- groupId or group.id -->
                    <!-- boardId or board.id -->
                    <RouterLink :to="`/group/${groupId}/board/${board.id}`">{{ board.title }}</RouterLink>
                </td>
                <td>{{ board.writer }}</td>
                <td>{{ board.viewCnt }}</td>
                <td>{{ board.regDate }}</td>
            </tr>
        </table>

        <BoardSearchInput />
    </div>
</template>

<script setup>
import { useBoardStore } from '@/stores/board';
import { onMounted } from 'vue';


const store = useBoardStore()
onMounted(() => {
    store.getBoardList()
})
</script>

<style scoped></style>