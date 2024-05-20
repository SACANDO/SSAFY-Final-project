<template>
    <div id="container">
        <header>
            <nav>
                <RouterLink to="/">Running Mate</RouterLink>
                <div v-if="store.accessToken">하이요</div>
            </nav>
        </header>
    </div>
</template>

<script setup>
import { useMainStore } from '@/stores/main'

const store = useMainStore()

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