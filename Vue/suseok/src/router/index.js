import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),

  // views랑 components랑 구분해서 components는 나중에 지우기

  routes: [
    {
      path: "/",
      name: main,
      component: MainView
    },
    { // LoginView
      path: "/login",
      name: LATER,
      component: LoginView,
      children: [
        {
          path: "findId",
          name: LATER,
          compoenet: LATER
        },
        {
          path: "findPwd",
          name: LATER,
          compoenet: LATER
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
      name: 기록시작 & 종료,
      component: LATER,
      children: [
        {
          path: "recent",
          name: 최근활동,
          component: LATER
        },
        {
          path: "my",
          name: 내로그,
          component: LATER
        },
        {
          path: "badge",
          name: 뱃지,
          component: LATER
        },        
      ]
    },
    { // RankView
    },
    { // GroupView
      path: "/group",
      name: 그룹,
      component: LATER,
      children: [
        {
          path: ":groupId",
          name: 그룹가입,
          component: LATER
        },
        {
          path: ":groupId",
          name: 그룹수정,
          component: LATER
        },
        {
          path: ":groupId",
          name: 그룹탈퇴,
          component: LATER
        },
        {
          path: ":groupId/:boardId",
          name: 게시글상세,
          component: LATER
        },
        {
          path: ":groupId/:boardId",
          name: 게시글수정,
          component: LATER
        },
        {
          path: ":groupId/:boardId",
          name: 게시글작성,
          component: LATER
        },
        {
          path: ":groupId/:boardId",
          name: 게시글삭제,
          component: LATER
        },  // 여기에서 댓글은 또 children으로 들어가야하나??
      ]
    },
    {
      path: "/user",
      name: 사용자,
      component: LATER
    },
    {
      path: "/signup",
      name: 회원가입,
      component: LATER
    },
    {
      path: "/search/user, /search/group, /logout"
    }
  ]
})

export default router
