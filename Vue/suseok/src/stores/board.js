import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

const REST_BOARD_API = `http://localhost:8000/group/`

const axiosInstance = axios.create({
    baseURL: REST_BOARD_API,
    headers: {
        'Content-type': 'application/json'
    }
})

export const useBoardStore = defineStore('board', () => {

    const board = ref({})
    const boardList = ref([])

    // params에서 groupId, userId 두개 받을 수 있나?
    const createBoard = function(groupId, board, userId) {
        // setUserIdHeader(userId)
        axiosInstance.post(`${groupId}/board`, board)
        .then(() => {
            router.push({name: 'boardDetail', params: {groupId, userId}})
        })
        .catch((error) => {
            console.log(error)
        })
    }
    
    // updateBoard에서 boardData가 필요가 없었던 것 같은데 확인해보기
    const updateBoard = function(groupId, boardId, boardData, userId) {
        // setUserIdHeader(userId)
        axiosInstance.put(`${groupId}/board/${boardId}`, boardData, {params: {groupId: groupId, userId: userId}})
        .then(() => {
            router.push({name: 'boardDetail', params: {groupId, userId}})
        })
        .catch((error) => {
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

  return { board, boardList, createBoard, updateBoard, deleteBoard, detailBoard }
})
