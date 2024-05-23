<script setup>
import ProfilePicture from '@/components/user/ProfilePicture.vue';
import { useUserStore } from '@/stores/user';
import { onMounted, ref } from 'vue';

const user = ref({})
const store = useUserStore()

onMounted(() => {
    store.myPage()
    .then((response) => {
        user.value = response
        console.log("MYPAGE user : ", user)
        console.log("MYPAGE user.value : ", user.value)
        console.log("MYPAGE user.value.data : ", user.value.data)
        console.log("MYPAGE user.value.data.userName : ", user.value.data.userName)
        console.log("MYPAGE response : ", response)
        console.log("MYPAGE response.data : ", response.data)
    })
})
</script>

<template>
    <div>
        <h2>My Page</h2>
        <ProfilePicture />
        <div class="user-info-box">
            <div class="user-info">
                <p>{{ user.data }}</p>
                <!-- <p>{{ user.data.userName }}</p>
                <p>{{ user.data.userSeq }}</p>
                <p>{{ user.data.userId }}</p> -->
                <!-- <p><strong>Name:</strong> {{ user.value.data?.userName }}</p>
                <p><strong>Nickname:</strong> {{ user.value.data?.userNick }}</p>
                <p><strong>Email:</strong> {{ user.value.data?.email }}</p>
                <p><strong>Address:</strong> {{ user.value.data?.address }}</p>
                <p><strong>Phone:</strong> {{ user.value.data?.phone }}</p> -->
            </div>
        </div>
    </div>
</template>

<style scoped>
.user-info-box {
    margin-top: 20px;
    padding: 20px;
    background-color: rgba(255, 255, 255, 0.9);
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    border-radius: 10px;
    width: 100%;
    max-width: 600px;
    margin: 20px auto;
}

.user-info {
    text-align: left;
}

.user-info p {
    margin: 5px 0;
}
</style>

<!-- <p>{{ user.data.userName }}</p>
<p>{{ user.data.userId }}</p>
<p>{{ user.data.userNick }}</p>
<p>{{ user.data }}</p> -->
<!-- <p><strong>Name:</strong> {{ user.data.userName }}</p>
<p><strong>Nickname:</strong> {{ user.data.userNick }}</p>
<p><strong>Email:</strong> {{ user.data.email }}</p>
<p><strong>Address:</strong> {{ user.data.address }}</p>
<p><strong>Phone:</strong> {{ user.data.phone }}</p> -->
<!-- 다른 필요한 정보들 -->