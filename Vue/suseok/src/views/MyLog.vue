<script setup>
</script>

<template>
    <div>
        <h3>MyLog</h3>
        <div class="image-container">
            <img src="https://via.placeholder.com/150" alt="Image 1" />
            <img src="https://via.placeholder.com/150" alt="Image 2" />
            <img src="https://via.placeholder.com/150" alt="Image 3" />
        </div>
    </div>
</template>

<style scoped>
.image-container {
    display: flex;
    flex-direction: column;
}

.image-container img {
    margin: 10px 0;
    align-self: flex-start;
}
</style>