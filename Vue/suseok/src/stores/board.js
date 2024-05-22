import { ref } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'

const REST_BOARD_API = `http://localhost:8080/group`

export const useBoardStore = defineStore('board', () => {

  const board = ref({})
  const boardList = ref([])

  const getBoardList = function (groupId) {
    axios.get(`${REST_BOARD_API}/${groupId}/board`)
      .then((response) => {
        boardList.value = response.data
      })
      .catch((error) => {
        console.log(error)
      })
  }

  const createBoard = (form) => {

    console.log(form)
    console.log(form.groupId)
    console.log(form.title)
    console.log(form.content)
    console.log(sessionStorage.getItem('accessToken'))

    axios.post(
      `${REST_BOARD_API}/${form.groupId}/board`,
      {
        groupId: form.groupId,
        title: form.title,
        content: form.content,
        img: form.img,
        notice: form.notice
      },
      {
        headers: {
          Authorization: `Bearer ${sessionStorage.getItem('accessToken')}`,
          userId: form.writerId
        }
      }
      
    )
      .then(response => {
        if (response.status === 201) {
          console.log('Board created successfully:', response.data)
          // 생성된 게시글을 상태에 추가하는 등의 작업 수행 가능
        } else {
         
          console.error('Failed to create board:', response)
        }
      })
      .catch(error => {
        console.log(error)
        console.error('Error creating board:', error)
      })
  }

  // console.log(board)
  // axios({
  //     url: `${REST_BOARD_API}/${groupId}/board/createBoard`,
  //     method: 'POST',
  //     data: board
  // })
  // .then(() => {   // 게시글 등록 성공
  //     // 작성한 게시글이 보이도록 boardDetail페이지로 이동
  //     router.push({name: 'boardDetail', params: {groupId: board.groupId, boardId: board.id}})
  // })
  // .catch((error) => { // 게시글 등록 실패
  //     console.log(error)
  // })   

  const updateBoard = function () {
    axios.put(REST_BOARD_API, board.value)
      .then(() => {   // 게시글 업데이트 성공
        // 작성한 게시글이 보이도록 boardDetail페이지로 이동
        router.push({ name: 'boardDetail', params: { groupId: board.value.groupId, boardId: board.value.id } })
      })
      .catch((error) => { // 게시글 업데이트 실패
        console.log(error)
      })
  }

  const deleteBoard = function (groupId, boardId, userId) {
    // setUserIdHeader(userId)
    axios.delete(`${REST_BOARD_API}/${groupId}/board/${boardId}`)
      .then(() => {
        router.push({ name: 'boardList', params: { groupId } })
      })
  }

  const detailBoard = function (groupId, boardId) {
    // setUserIdHeader(userId)
    axios.get(`${REST_BOARD_API}/${groupId}/board/${boardId}`)
      .then((response) => {
        board.value = response.data
      })
      .catch((error) => {
        console.log(error)
      })
  }

  const getBoard = function (boardId) {
    axios.get(`${REST_BOARD_API}/${boardId}`)
      .then((response) => {
        board.value = response.data
      })
      .catch((error) => {
        console.log(error)
      })
  }

  return {
    board, boardList, getBoardList, createBoard, updateBoard, deleteBoard,
    detailBoard, getBoard
  }
})
