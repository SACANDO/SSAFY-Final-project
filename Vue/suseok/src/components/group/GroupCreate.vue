<script setup>
import { ref } from 'vue'
import { useGroupStore } from '@/stores/group'
import { useMainStore } from '@/stores/main'

const store = useGroupStore()
const mainStore = useMainStore()

const group = ref({
  groupName: '',
  goalPace: '',
  goalFrequency: '',
  goalTotalDistance: '',
  conPace: '',
  conFrequency: '',
  conTotalDistance: '',
})

const submitForm = function () {
  console.log("GROUPCREATE main : ", mainStore.loginUser.userId)
  store.createGroup(group.value)
}
</script>

<template>
  <div class="container">
    <h2>그룹 생성하기</h2>
    <br>
    <form @submit.prevent="submitForm">
      <div>
        <label for="groupName">그룹명 : </label>
        <input id="groupName" v-model="group.groupName" required />
      </div>
      <div>
        <label for="goalPace">목표 Pace : </label>
        <input id="goalPace" v-model="group.goalPace" />
      </div>
      <div>
        <label for="goalFrequency">목표 Frequency</label>
        <input id="goalFrequency" v-model="group.goalFrequency" />
      </div>
      <div>
        <label for="goalTotalDistance">목표 Total distance</label>
        <input id="goalTotalDistance" v-model="group.goalTotalDistance" />
      </div>
      <div>
        <label for="conPace">최소 Pace : </label>
        <input id="conPace" v-model="group.conPace" />
      </div>
      <div>
        <label for="conFrequency">최소 Frequency : </label>
        <input id="conFrequency" v-model="group.conFrequency" />
      </div>
      <div>
        <label for="conTotalDistance">최소 Total Distance : </label>
        <input id="conTotalDistance" v-model="group.conTotalDistance" />
      </div>
      <button type="submit">그룹 생성하기</button>
    </form>
  </div>
</template>
  
<style scoped>
.container {
  width: 80%;
  max-width: 800px;
  margin: 20px auto;
  padding: 20px;
  background-color: rgba(255, 255, 255, 0.9);
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
  border-radius: 10px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center; /* 세로 중간 정렬 */
}

form {
  display: flex;
  flex-direction: column;
  width: 100%; /* 폼의 너비를 부모 컨테이너에 맞춤 */
  height: 100%; /* 폼의 높이를 부모 컨테이너에 맞춤 */
}

div {
  display: flex;
  flex-direction: row;
  align-items: center;
  margin-bottom: 10px;
}

label {
  font-weight: bold;
  margin-right: 10px; /* 레이블과 입력 필드 간의 여백 추가 */
}

input {
  width: calc(100% - 20px); /* 부모 컨테이너의 너비에서 20px을 뺀 값으로 설정 */
  max-width: 300px; /* 모든 입력 필드의 고정된 최대 너비 설정 */
  padding: 5px;
  border: 1px solid #ccc;
  border-radius: 4px;
  justify-content: center;
}

button {
  width: 40%;
  margin: 5% 45%;
  padding: 10px;
  border: none;
  border-radius: 4px;
  background-color: #4CAF50;
  color: white;
  cursor: pointer;
}

button:hover {
  background-color: #45a049;
}
</style>
