import { ref } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'

const REST_GROUP_API = `http://localhost:8080/group`

export const useGroupStore = defineStore('group', () => {
    const groups = ref([])

    const getGroups = async function () {
        try {
            const response = await axios.get(REST_GROUP_API)
            groups.value = response.data
        } catch (error) {
            console.error('Error fetching groups:', error)
        }
    }

    const createGroup = function () {
        axios.post(REST_GROUP_API, {
            headers: {
                Authorization: `Bearer ${accessToken.value}`,
            },
        })
    }

    const deleteGroup = function () {
        // 그룹 삭제 로직
    }

    const updateGroup = function() {
        // 그룹 업데이트 로직
    }

    return { groups, getGroups, createGroup, deleteGroup, updateGroup }
})
