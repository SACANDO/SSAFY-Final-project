<!-- 
    전 : 그룹 디테일, 내 그룹(on/off 버튼) >> 로그인 페이지 , 그룹 가입하기 >> 로그인 페이지
    후 : 그룹 디테일, 내 그룹(on/off 버튼), 그룹 가입하기
 -->
<!-- 
    전 : 유저 디테일, 내 라이벌(on/off 버튼) >> 로그인 페이지, 라이벌 등록 >> 로그인 페이지
    후 : 유저 디테일, 내 라이벌(on/off 버튼), 라이벌 등록
 -->
 <script setup>
 import GroupList from '../group/GroupList.vue'
 
 const performSearch = () => {
     // performSearch 함수에 검색 로직 구현
     console.log("검색 실행:", searchQuery.value)
 }
 </script>
 
 <template>
     <h3>GroupRank</h3>
     <!-- 여기에 GroupDetail구현 -->
     <div class="group-list-container">
         <GroupList :search-query="searchQuery" />
     </div>
     <!-- 검색 입력란 추가 -->
     <div class="search-container">
         <input type="text" v-model="searchQuery" placeholder="Search groups..." />
         <!-- 돋보기 아이콘 버튼 추가 -->
         <button @click="performSearch" class="search-button">🔍</button>
     </div>
 </template>
 
 <style scoped>
 .group-list-container {
     margin: 20px auto;
     padding: 20px;
     width: 50%; /* 또는 특정 크기 */
     background-color: #f4f4f4; /* 백그라운드 색상 설정 */
     border: 1px solid #ccc; /* 테두리 설정 */
     border-radius: 20px;
     box-shadow: 0 2px 5px rgba(0,0,0,0.1); /* 그림자 효과 */
     display: flex;
     justify-content: center;
     flex-direction: column;
 }
 .search-container {
     margin: 10px auto;
     width: 52%;
     position: relative;
     display: flex;
     justify-content: center;
 }
 input[type="text"] {
     width: 100%;
     padding: 10px;
     border: 1px solid #ccc;
     border-radius: 5px;
 }
 .search-button {
    position: absolute;
    right: 10px;
    top: 46%;
    transform: translateY(-50%);
    background: none;
    border: none;
    cursor: pointer;
    font-size: 16px; /* 아이콘 크기 조절 */
}
 </style>