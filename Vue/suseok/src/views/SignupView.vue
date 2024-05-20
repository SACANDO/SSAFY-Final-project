<template>
  <div class="signup-container gowun-dodum-regular">
    <h1>회 원 가 입</h1>
    <form @submit.prevent="submitForm" class="signup-form">
      <!-- 아이디 입력란과 중복 확인 버튼 -->
      <div class="input-group with-button">
        <input type="text" id="username" v-model="form.userId" placeholder="아이디" required>
        <button @click.prevent="checkId" class="check-button">중복확인</button>
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
      <!-- 주소 입력란 -->
      <div class="input-group long-input with-button">
        <input type="text" id="postalCode" v-model="form.postalCode" placeholder="우편번호" required readonly>
        <button @click.prevent="openPostalCodeSearch" class="check-button">우편번호 검색</button>
      </div>
      <div class="input-group long-input">
        <input type="text" id="address" v-model="form.address" placeholder="주소" required readonly>
      </div>
      <div class="input-group long-input">
        <input type="text" id="detailedAddress" v-model="form.detailedAddress" placeholder="상세주소" required>
      </div>
      <button type="submit" class="signup-button">회원가입</button>
    </form>

    <!-- 우편번호 검색 모달 -->
    <div v-if="isPostalCodeSearchOpen" class="modal">
      <div class="modal-content">
        <span class="close" @click="closePostalCodeSearch">&times;</span>
        <h2>우편번호 검색</h2>
        <input type="text" v-model="postalCodeSearchQuery" placeholder="예) 판교역로 166, 분당 주공, 백현동 532">
        <button @click="searchPostalCode">검색</button>
        <div class="tip">
          <p>아래와 같은 조합으로 검색을 하시면 더욱 정확한 결과가 검색됩니다.</p>
          <ul>
            <li>도로명 + 건물번호: <span>예) 판교역로 166, 제주 첨단로 242</span></li>
            <li>지역명(동/리) + 번지: <span>예) 백현동 532, 제주 영평동 2181</span></li>
            <li>지역명(동/리) + 건물명(아파트명): <span>예) 판교역로 166, 제주 첨단로 242</span></li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { useUserStore } from '@/stores/user'
import { ref, computed } from 'vue'

const store = useUserStore()

const form = ref({
  userId: '',
  nickname: '',
  password: '',
  confirmPassword: '',
  email: '',
  name: '',
  gender: '',
  phone: '',
  postalCode: '',
  address: '',
  detailedAddress: ''
})

const submitForm = function() {
  if (isPasswordMatch.value) {
    console.log('Form submitted:', form.value)

    const newUser = {
      userId: form.value.userId,
      userPwd: form.value.password,
      userName: form.value.name,
      userNick: form.value.nickname,
      email: form.value.email,
      createdAt: new Date(),
      updatedAt: new Date(),
      address: `${form.value.address} ${form.value.detailedAddress}`,
      img: '', // 사용자가 업로드한 이미지가 있을 경우 여기에 설정
      phone: form.value.phone,
      exposure: true // 기본값 설정, 필요에 따라 수정
    };
    store.signup(newUser); // 회원가입 요청
  } else {
    console.log('Passwords do not match')
  }
}

// Mockup address search function
const mockSearchPostalCode = (postalCode) => {
  // 이 부분을 실제 주소 검색 API와 통합해야 합니다.
  return `Sample Address for postal code ${postalCode}`
}

const postalCodeSearchQuery = ref('')
const isPostalCodeSearchOpen = ref(false)

const setGender = function(gender) {
  form.gender = gender
}

const isPasswordMatch = computed(() => form.value.password === form.value.confirmPassword)
const isConfirmPasswordFilled = computed(() => form.value.confirmPassword !== '')
const showPasswordMismatchWarning = computed(() => isConfirmPasswordFilled.value && !isPasswordMatch.value)

// store에 있는 checkId 함수를 실행
const checkId = function() {
  store.checkId(form.value.userId)
  .then((exists) => {
    if (exists) {
      alert('이미 사용 중인 아이디입니다.');
      store.isIdChecked = false; // 아이디 중복확인 실패 시 false
    } else {
      alert('사용 가능한 아이디입니다.');
      store.isIdChecked = true; // 아이디 중복확인 성공 시 true
    }
  })
  .catch((error) => {
    console.error(error);
    store.isIdChecked = false; // 오류 발생 시 false
  });
}

const checkNickname = function() {
  store.checkNickname(form.value.nickname)
  .then((exists) => {
    if (exists) {
      alert('이미 사용 중인 닉네임입니다.');
    } else {
      alert('사용 가능한 닉네임입니다.');
    }
  })
  .catch((error) => {
    console.error(error);
  });
}

const openPostalCodeSearch = function() {
  isPostalCodeSearchOpen.value = true
}

const closePostalCodeSearch = function() {
  isPostalCodeSearchOpen.value = false
}

const searchPostalCode = function() {
  const postalCode = postalCodeSearchQuery.value
  if (postalCode) {
    form.value.postalCode = postalCode;
    form.value.address = mockSearchPostalCode(postalCode)
    closePostalCodeSearch()
  } else {
    alert('우편번호를 입력해주세요.')
  }
}

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

/* 모달 스타일 */
.modal {
  display: flex;
  justify-content: center;
  align-items: center;
  position: fixed;
  z-index: 1;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  overflow: auto;
  background-color: rgb(0, 0, 0);
  background-color: rgba(0, 0, 0, 0.4);
}

.modal-content {
  background-color: #fefefe;
  margin: 15% auto;
  padding: 20px;
  border: 1px solid #888;
  width: 80%;
  max-width: 500px;
  border-radius: 10px;
}

.close {
  color: #aaa;
  float: right;
  font-size: 28px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: black;
  text-decoration: none;
  cursor: pointer;
}

.tip {
  margin-top: 20px;
}

.tip p {
  font-weight: bold;
}

.tip ul {
  list-style: none;
  padding-left: 0;
}

.tip li {
  margin-bottom: 10px;
}

.tip span {
  color: #555;
  font-style: italic;
}
</style>