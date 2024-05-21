import { ref } from 'vue'
import { defineStore } from 'pinia'
import { useMainStore } from './main'
import axios from 'axios'
import { useRouter } from 'vue-router'

const REST_GROUP_API = `http://localhost:8080/group`

export const useGroupStore = defineStore('group', () => {

    const groups = ref([])
    const mainStore = useMainStore()
    const router = useRouter()

    const getGroups = function () {
        axios.get(REST_GROUP_API)
            .then(response => {
                groups.value = response.data
            })
            .catch(error => {
                console.error('Error fetching groups:', error)
            })
    }

    const getAllGroups = function () {
        axios.get(REST_GROUP_API)
            .then(response => {
                groups.value = response.data
            })
            .catch(error => {
                console.error('Error fetching all groups:', error)
            })
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

    const updateGroup = function () {
        // 그룹 업데이트 로직
    }

    const joinGroup = function(groupId) {
        if (!sessionStorage.getItem('accessToken')) {
            router.push({name: 'loginView'})
            // router.push({ name: 'loginView', query: { redirect: `/group/join/${groupId}` } });
        } else {
            joinGroupRequest(groupId);
        }
    }

    const joinGroupRequest = function(groupId) {
        axios.get(`/group/join/${groupId}`, {
            headers: { Authorization: `Bearer ${sessionStorage.getItem('accessToken')}` }
        }).then((response) => {
            alert(`그룹 ${groupId}에 가입되었습니다.`)
            console.log(response.data);
        }).catch((error) => {
            console.error(error);
        });
    }

    return {
        groups, getGroups, getAllGroups, createGroup, deleteGroup, updateGroup,
        joinGroup, joinGroupRequest
    }
})
