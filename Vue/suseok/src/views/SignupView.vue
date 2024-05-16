<template>
    <div class="signup-container gowun-dodum-regular">
      <h1>회 원 가 입</h1>
      <form @submit.prevent="submitForm" class="signup-form">
        <!-- 아이디 입력란과 중복 확인 버튼 -->
        <div class="input-group with-button">
          <input type="text" id="username" v-model="form.username" placeholder="아이디" required>
          <button @click.prevent="checkUsername" class="check-button">중복확인</button>
        </div>
        <!-- 비밀번호 입력란 -->
        <div class="input-group long-input">
          <input type="password" id="password" v-model="form.password" placeholder="비밀번호" required>
        </div>
        <!-- 비밀번호 확인 입력란 -->
        <div class="input-group long-input">
          <input type="password" id="confirmPassword" v-model="form.confirmPassword" placeholder="비밀번호 확인" :class="{ 'input-error': showPasswordMismatchWarning }" required>
        </div>
        <!-- 비밀번호 불일치 경고 문구 -->
        <div v-if="showPasswordMismatchWarning" class="warning-text">비밀번호가 일치하지 않습니다</div>
        <!-- 이메일 입력란 -->
        <div class="input-group long-input">
          <input type="email" id="email" v-model="form.email" placeholder="이메일" required>
        </div>
        <!-- 닉네임 입력란과 중복 확인 버튼 -->
        <div class="input-group with-button">
          <input type="text" id="nickname" v-model="form.nickname" placeholder="닉네임" required>
          <button @click.prevent="checkNickname" class="check-button">중복확인</button>
        </div>
        <!-- 이름과 성별 선택 -->
        <div class="input-group name-gender">
          <input type="text" id="name" v-model="form.name" placeholder="이름" required>
          <div class="gender-select">
            <label for="male" :class="{ 'selected': form.gender === 'male' }" @click="setGender('male')">남자</label>
            <div class="gender-divider"></div>
            <label for="female" :class="{ 'selected': form.gender === 'female' }" @click="setGender('female')">여자</label>
          </div>
        </div>
        <!-- 휴대전화 번호 입력란 -->
        <div class="input-group long-input">
          <input type="text" id="phone" v-model="form.phone" placeholder="휴대전화번호" required>
        </div>
        <button type="submit" class="signup-button">회원가입</button>
      </form>
    </div>
  </template>
  
  <script setup>
  import { ref, computed } from 'vue';
  
  const form = ref({
    username: '',
    nickname: '',
    password: '',
    confirmPassword: '',
    email: '',
    name: '',
    gender: '',
    phone: ''
  });
  
  const setGender = (gender) => {
    form.gender = gender;
  };
  
  const isPasswordMatch = computed(() => form.value.password === form.value.confirmPassword);
  const isConfirmPasswordFilled = computed(() => form.value.confirmPassword !== '');
  const showPasswordMismatchWarning = computed(() => isConfirmPasswordFilled.value && !isPasswordMatch.value);
  
  const checkUsername = () => {
    console.log('Checking username:', form.value.username);
    // 여기에 실제 중복 검사 로직 구현
  };
  
  const checkNickname = () => {
    console.log('Checking nickname:', form.value.nickname);
    // 여기에 실제 중복 검사 로직 구현
  };
  
  const submitForm = () => {
    if (isPasswordMatch.value) {
      console.log('Form submitted:', form.value);
    } else {
      console.log('Passwords do not match');
    }
  };
  </script>
  
  <style scoped>
  .signup-container {
    max-width: 500px;
    margin: 50px auto;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
    background-color: #feffed;
  }
  
  .input-group {
    display: flex;
    align-items: center;
    margin-bottom: 10px;
    font-family: "Gowun Dodum", sans-serif;
    font-weight: 400;
    font-style: normal;
  }
  
  .input-group.with-button {
    justify-content: space-between;
  }
  
  .input-group.with-button input {
    flex: 1 1 65%; /* Adjusted this percentage to make the input slightly narrower */
    margin-right: 10px; /* Added margin-right to create space between input and button */
  }
  
  .check-button {
    flex: 1 1 35%; /* Adjusted this percentage to make the button slightly wider */
    padding: 8px 15px;
    background-color: #ffe697;
    color: darkslategray;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-family: "Gowun Dodum", sans-serif;
    font-weight: 400;
    font-style: normal;
  }
  
  .check-button:hover {
    background-color: #fadb74;
  }
  
  .long-input input {
    width: 100%;
  }
  
  .name-gender {
    display: flex;
    justify-content: space-between;
    align-items: center;
  }
  
  .name-gender input[type="text"] {
    width: 50%;
  }
  
  /* 성별 선택 칸 스타일은 수정하지 않습니다 */
  .gender-select {
    display: flex;
    align-items: center;
    border: 1px solid #ccc;
    border-radius: 5px;
    background-color: #ccc;
    flex: 0 1 200px;
    height: 33.5px;
    overflow: hidden;
  }
  
  .gender-select label {
    flex: 1;
    text-align: center;
    padding: 10px 20px;
    cursor: pointer;
    background-color: #f4f4f4;
    color: #333;
    transition: background-color 0.3s, color 0.3s;
  }
  
  .gender-select label.selected {
    background-color: #4CAF50;
    color: white;
  }
  
  .gender-divider {
    width: 1px;
    background-color: #ccc;
  }
  
  input[type="text"],
  input[type="password"],
  input[type="email"],
  .signup-button {
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 4px;
    font-family: "Gowun Dodum", sans-serif;
    font-weight: 400;
    font-style: normal;
  }
  
  .input-error {
    border-color: red;
  }
  
  .signup-button {
    width: 100%;
    background-color: #ffe697;
    color: darkslategray;
    cursor: pointer;
  }
  
  .signup-button:hover {
    background-color: #fadb74;
  }
  
  .warning-text {
    color: red;
    text-align: left;
    font-size: 12px;
    margin-left: 2px;
    margin-bottom: 20px;
  }
  
  input::placeholder {
    color: #aaa;
  }
  </style>
  