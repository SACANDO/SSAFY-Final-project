<template>
    <div id="app">
        <TheHeaderNav />
    </div>
    <div>
        <TheHamburgerButton />
        <br>
        <br>
        <RouterView />
  
        
    </div>
</template>
  
<script setup>
import TheHamburgerButton from './components/common/TheHamburgerButton.vue';
import TheHeaderNav from './components/common/TheHeaderNav.vue';



</script>

<style>
.gowun-dodum-regular {
    font-family: "Gowun Dodum", sans-serif;
    font-weight: 400;
    font-style: normal;
}


#app {
    /* font-family: Avenir, Helvetica, Arial, sans-serif; */
    font-family: "Gowun Dodum", sans-serif;
    font-weight: 400;
    font-style: normal;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;

}
</style>


