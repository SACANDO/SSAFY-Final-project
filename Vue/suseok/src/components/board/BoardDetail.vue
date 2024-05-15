<!-- 게시글 수정, 삭제, 댓글  -->
<template>
    <div>
        <h4>게시글 상세</h4>
        <hr>
        <div>{{ store.board.title }}</div>
        <div>{{ store.board.writer }}</div>
        <div>{{ store.board.regDate }}</div>
        <div>{{ store.board.viewCnt }}</div>
        <div>{{ store.board.content }}</div>

        <button @click="deleteBoard">삭제</button>
        <button @click="updateBoard">수정</button>
    </div>
</template>

<script setup>
// 게시글 상세 페이지로 이동했을 때 
// 해당 게시글에 대한 정보를 바로 띄우기 위해 onMounted필요
// 해당 게시글에 대한 정보는 route를 이용해서 board.id를 가져오면 된다.
import { useBoardStore } from '@/stores/board';
import { onMounted } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import axios from 'axios'

const store = useBoardStore()
const route = useRoute()
const router = useRouter()

onMounted(() => {
    store.getBoard(route.params.id)
})

const deleteBoard = function() {
    axios.deleteBoard(`http://localhost:8000/group/${route.params.id}`)
    .then(() => {
        router.push({name: 'boardList'})
    })
    .catch((error) => {
        console.log(error)
    })
}

const updateBoard = function() {
    router.push({name: 'boardUpdate'})
}

</script>

<style scoped>
</style>