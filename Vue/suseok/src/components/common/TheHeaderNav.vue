<template>
    <div id="container">
        <header>
            <nav>
                <RouterLink to="/">Running Mate</RouterLink>
            </nav>
        </header>
    </div>
</template>

<script setup>
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