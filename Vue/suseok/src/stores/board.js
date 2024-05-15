import { ref } from 'vue'
import { defineStore } from 'pinia'

const REST_BOARD_API = `http://localhost:8000/group/`

export const useBoardStore = defineStore('board', () => {

    const board = ref({})
    const boardList = ref([])

    const createBoard = function(board) {
        axios({
            url: REST_BOARD_API,
            method: 'POST',
            data: board
        })
        .then(() => {   // 게시글 등록 성공
            // 작성한 게시글이 보이도록 boardDetail페이지로 이동
            router.push({name: 'boardDetail', params: {groupId, userId}})
        })
        .catch((error) => { // 게시글 등록 실패
            console.log(error)
        })   
    }

    const updateBoard = function() {
        axios.put(REST_BOARD_API, board.value)
        .then(() => {   // 게시글 업데이트 성공
            // 작성한 게시글이 보이도록 boardDetail페이지로 이동
            router.push({name: 'boardDetail', params: {groupId, userId}})
        })
        .catch((error) => { // 게시글 업데이트 실패
            console.log(error)
        })
    }

    const deleteBoard = function(groupId, boardId, userId) {
        // setUserIdHeader(userId)
        axiosInstance.delete(`${groupId}/board/${boardId}`)
        .then(() => {
            router.push({name: 'boardList', params: {groupId}})
        })
    }

    const detailBoard = function(groupId, boardId) {
        // setUserIdHeader(userId)
        axiosInstance.get()
    }

    const getBoard = function(boardId) {
        axios.get(`${REST_BOARD_API}/{boardId}`)
        .then((response) => {
            board.value = response.date
        })
        .catch((error) => {
            console.log(error)
        })
    }

  return { board, boardList, createBoard, updateBoard, deleteBoard, detailBoard, getBoard }
})
