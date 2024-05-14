<!-- 
    전 : 유저, 그룹은 상관없음. 내 로그 >> 로그인 페이지
    후 : 유저, 그룹, 내 로그
    사이드바 디자인은 천천히 
 -->
 <template>
    <div>
      <button class="hamburger" @click="toggleSidebar">☰</button>
      <div :class="['sidebar', { 'is-open': isSidebarOpen }]">
        <ul>
          <li><a href="#">여기는 유저 보기 1</a></li>
          <li><a href="#">여기는 그룹 보기</a></li>
          <li><a href="#">여기는 나의 로그</a></li>
        </ul>
      </div>
    </div>
  </template>
  
  <script setup>
  import { ref } from 'vue';
  //import 유저 보기, 그룹 보기, 나의 로그
  
  const isSidebarOpen = ref(false);
  
  const toggleSidebar = () => {
    isSidebarOpen.value = !isSidebarOpen.value;
  };
  </script>
  
  <style scoped>
  .hamburger {
    font-size: 30px;
    border: none;
    background: none;
    cursor: pointer;
    position: fixed;
    top: 20px;
    left: 20px;
    z-index: 1000;
  }
  
  .sidebar {
    position: fixed;
    top: 0;
    left: 0;
    width: 0;
    height: 100%;
    background-color: #2c3e50;
    overflow-x: hidden;
    transition: 0.5s;
    padding-top: 60px;
  }
  
  .sidebar.is-open {
    width: 250px; /* chatgpt.com 사이드바 크기 */
  }
  
  .sidebar ul {
    list-style-type: none;
    padding: 0;
  }
  
  .sidebar ul li {
    padding: 8px 16px;
    text-align: left;
  }
  
  .sidebar ul li a {
    color: #ecf0f1;
    text-decoration: none;
    font-size: 25px;
    display: block;
    transition: 0.3s;
  }
  
  .sidebar ul li a:hover {
    color: #f1c40f;
  }
  </style>
  