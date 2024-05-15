<script setup>
</script>

<template>
    <div>
        <!-- 
            <RouterLink :to="{name: groupDetail, params: {groupId: 'groupId'}}">Group</RouterLink>
            이런식으로 넘겨야겠지?
        -->
        <RouterLink :to="{name: groupDetail}">Group1 <- 클릭하면 해당 그룹 Detail페이지로 이동</RouterLink>
        <br>
        <RouterLink :to="{name: groupDetail}">Group2</RouterLink>
        <br>
        <RouterLink :to="{name: groupDetail}">Group3</RouterLink>
    </div>
</template>

<style scoped>
</style>