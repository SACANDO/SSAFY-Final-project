<script setup>
</script>

<template>
    <div>
        <RouterLink :to="{name: userDetail}">User1 <- 클릭하면 Detail페이지로 이동</RouterLink>
        <br>
        <RouterLink :to="{name: userDetail}">User2</RouterLink>
        <br>
        <RouterLink :to="{name: userDetail}">User3</RouterLink>
        <br>
        <p>10명의 사람이 노출되고 그 이상은 다음 페이지에서 볼 수 있도록</p>
    </div>
</template>

<style scoped>
</style>