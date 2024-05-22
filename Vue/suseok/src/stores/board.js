import { ref } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'
import { useRoute, useRouter } from 'vue-router'

const REST_BOARD_API = `http://localhost:8080/group`

export const useBoardStore = defineStore('board', () => {
  
  const router = useRouter()
  const route = useRoute()
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
          Authorization: `${sessionStorage.getItem('accessToken')}`,
          userId: form.writerId
        }
      }
    )
    .then(response => {
      if (response.status === 201) {
        const id = response.data.id;
        const boardData = {
          groupId: form.groupId,
          id: id,
          title: form.title,
          content: form.content,
          img: form.img,
          notice: form.notice
        };
  
        console.log("userId : ", form.writerId)
        console.log("typeof : ", typeof(form.id))

        // 게시글 상세 페이지로 GET 요청
        axios.get(`${REST_BOARD_API}/${form.groupId}/board/${id}`, {
          headers: {
            Authorization: `${sessionStorage.getItem('accessToken')}`,
            userId: form.writerId
          }
        })
        .then(detailResponse => {
          console.log("게시글 상세 페이지")
          console.log('Board details:', detailResponse.data);
          
          // 게시글 상세 페이지로 이동
          router.push({
            name: 'boardDetail',
            params: {
              groupId: form.groupId,
              id : id
            }
          });
        })
        .catch(detailError => {
          console.log("게시글 상세 페이지 실패")
          console.error('Error fetching board details:', detailError);
        });
      } else {
        console.error('Failed to create board:', response);
      }
    })
    .catch(error => {
      console.log(error);
      console.error('Error creating board:', error);
    });
  };
  
  

  // const createBoard = (form) => {

  //   axios.post(
  //     `${REST_BOARD_API}/${form.groupId}/board`,
  //     {
  //       groupId: form.groupId,
  //       title: form.title,
  //       content: form.content,
  //       img: form.img,
  //       notice: form.notice
  //     },
  //     {
  //       headers: {
  //         Authorization: `${sessionStorage.getItem('accessToken')}`,
  //         userId: form.writerId
  //       }
  //     }
  //   )
  //     .then(response => {
  //       if (response.status === 201) {
  //         const boardId = response.data.boardId
  //         // console.log(response.data)
  //         router.push({
  //           name: 'boardDetail',
  //           params: {
  //             groupId: form.groupId,
  //             boardId: boardId
  //           }
  //         })
  //       } else {
  //         console.error('Failed to create board:', response)
  //       }
  //     })
  //     .catch(error => {
  //       console.log(error)
  //       console.error('Error creating board:', error)
  //     })
  // }

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
