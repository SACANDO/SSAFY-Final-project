<template>
    <div id="container">
        <header>
            <nav>
                <RouterLink to="/">Running Mate</RouterLink>
                <StravaAuth />
            </nav>
        </header>
    </div>
</template>

<script setup>
import { useMainStore } from '@/stores/main'
import StravaAuth from '@/views/StravaAuth.vue';
import { onMounted, ref } from 'vue'

const token = ref(false)
token.value = sessionStorage.getItem('accessToken')

// const store = useMainStore()
// const token = ref('')

// onMounted(() => {
//   token.value = sessionStorage.getItem('accessToken')
//   // console.log(token.value)
// })

</script>

<style scoped>
#container {
    text-align: center;
}

nav {
    margin-top : 25px;
}

nav a {
    font-weight: bold;
    font-size: 30px;
    text-decoration: none;
    color: black;
}

nav a.router-link-exact-active {
    color: #42b983
}
</style>