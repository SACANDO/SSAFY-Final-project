<script setup>
</script>

<template>
    <div>
        <!-- 
            <RouterLink :to="{name: groupDetail, params: {groupId: 'groupId'}}">Group</RouterLink>
            이런식으로 넘겨야겠지?
        -->
        <RouterLink :to="{name: groupDetail}">Group1</RouterLink>
        <br>
        <RouterLink :to="{name: groupDetail}">Group2</RouterLink>
        <br>
        <RouterLink :to="{name: groupDetail}">Group3</RouterLink>
    </div>
</template>

<style scoped>
</style>