import { createRouter, createWebHistory } from 'vue-router'
import MainView from '@/views/MainView.vue'
import LoginView from '@/views/LoginView.vue'
import GroupView from '@/views/GroupView.vue'
import RankView from '@/views/RankView.vue'
import RecordView from '@/views/RecordView.vue'
import UserView from '@/views/UserView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),

  routes: [
    {
      path: "/",
      name: "main",
      component: MainView
    },
    { // LoginView
      path: "/login",
      name: "loginView",
      component: LoginView,
      children: [
        {
          path: "findId",
          name: LATER,
          component: LATER
        },
        {
          path: "findPwd",
          name: LATER,
          component: LATER
        },
        {
          path: "naver",
          name: LATER,
          component: LATER
        },
        {
          path: "google",
          name: LATER,
          component: LATER
        },
        {
          path: "kakao",
          name: LATER,
          component: LATER
        }
      ]
    },
    { // RecordView
      path: "/record",
      name: "recordView",
      component: RecordView,
      children: [
        { // 없어도 될듯
          path: "",
          name: "startRecording",
          component: LATER
        },
        { // 없어도 될듯
          path: "",
          name: "endRecording"
        },
        {
          path: "recent",
          name: "recentRecord",
          component: RecentRecord
        },
        {
          path: "my",
          name: "myRecord",
          component: MyRecord
        },
        {
          path: "badge",
          name: "badgeLog",
          component: BadgeLog,
          children: [
            { // 디테일이 왜 필요하더라?
              path: "detail",
              name: "badgeLogDetail",
              component: BadgeLogDetail
            }
          ]
        },        
      ]
    },
    { // RankView
      path: "/rank",
      name: "rank",
      component: RankView,
      children: [
        {
          path: "",
          name: "userRank",
          component: UserRank
        },
        { // 라우터가 필요한가??
          // 페이지 내에서 나와 관련된 사람만 필터링 할 수 있으면 필요없을듯
          path: "my",
          name: "myRivalRank",
          component: RivalRank
        },
        {
          path: "group",
          name: "groupRank",
          component: GroupRank
        },
        { // 마찬가지로 라우터가 필요한가?
          path: "group/my",
          name: "myGroupRank",
          component: MyGroupRank
        },
        {
          path: "group/:groupId",
          name: "groupMemberRank",
          component: GroupMemberRank
        },
      ]
    },
    { // GroupView
      path: "/group/:groupId",
      name: "group",
      component: GroupView,
      children: [
        { // GroupDetail component가 따로 있는 이유는??
          path: "",
          name: "groupDetail",
          component: GroupDetail
        },
        {
          path: "update",
          name: "groupUpdate",
          component: GroupUpdate
        },
        { // 없어도 될듯
          path: "그룹탈퇴"
        },
        { // 없어도 될듯
          path: "멤버강퇴"
        },
        {
          path: "board",
          name: "Board",
          component: BoardView,
          children: [
            {
              path: "",
              name: "BoardList",
              component: BoardList
            },
            {
              path: "create",
              name: "boardCreate",
              component: BoardCreate
            },
            {
              path: "update",
              name: "boardUpdate",
              component: BoardUpdate
            },
            { // 없어도 될듯
              path: "delete",
              name: "boardDelete",
              component: BoardDelete
            },
            { // 없어도 될듯
              path: "search",
              name: "boardSearch",
              component: BoardSearch
            },
            { // 게시글보기
              path: ":boardId",
              name: "boardDetail",
              component: BoardDetail
            },
            { // 없어도 될듯
              path: ":boardId/reply",
              name: "replyCreate",
              component: replyCreate
            },
            { // 없어도 될듯
              path: ":boardId/reply",
              name: "replyDetele",
              component: replyDelete
            }
          ]
        }
      ]
    },
    { // 마이페이지에는 userId가 필요없나??
      path: "/user",
      name: 사용자,
      component: UserView,
      children: [
        { // 내 정보 수정
          path: "update",
          name: "userUpdate",
          component: UserUpdate
        },
        { // 없어도 될듯
          path: "delete",
          name: "userDelete",
          component: UserDelete
        },
        { // 라이벌 등록 버튼 클릭
          // 유저를 찾아서 등록하는거라면 없어도 될듯??
          path: "add/:rivalSeq",
          name: "addRival",
          component: AddRival
        }
      ]
    },
  ]
})

export default router
