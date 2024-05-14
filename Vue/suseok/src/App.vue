<template>
    <div id="app">
        <TheHeaderNav />
    </div>
    <div>
        <TheHamburgerButton />
        <RouterView />
    </div>
</template>
  
<script setup>
import TheHamburgerButton from './components/common/TheHamburgerButton.vue';
import TheHeaderNav from './components/common/TheHeaderNav.vue';
</script>
  
<style>
#app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
}
</style>
  