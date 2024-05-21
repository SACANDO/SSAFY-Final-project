<template>
    <div>
        <button @click ="getStrava">click</button>
    </div>
</template>

<script setup>

import { useStravaStore } from '@/stores/strava'
const store = useStravaStore();

const getStrava= function () {
    store.getActivityLaps()
}
</script>

<style scoped>

</style>