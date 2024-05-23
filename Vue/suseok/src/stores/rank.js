import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'

const REST_RANK_API = `http://localhost:8080/rank`

export const useRankStore = defineStore('rank', () => {

    const users = ref([])
    const user = ref([])

    const sortByHighestPace = function () {

        axios.get(`${REST_RANK_API}/user`, {
            params: { con: 'highest_pace' }
        })
            .then((response) => {
                users.value = response.data
            })
            .catch((error) => {
                console.log(error);
            });
    }

    const sortByFrequency = function () {

        axios.get(`${REST_RANK_API}/user`, {
            params: { con: 'frequency' }
        })
            .then((response) => {
                users.value = response.data
            })
            .catch((error) => {
                console.log(error);
            });
    }

    const sortByTotalDistance = function () {

        axios.get(`${REST_RANK_API}/user`, {
            params: { con: 'total_distance' }
        })
            .then((response) => {
                users.value = response.data
            })
            .catch((error) => {
                console.log(error);
            });
    }

    const myRR = function () {
        axios.get('http://localhost:8080/myRR', {
           headers : {
            Authorization : `${sessionStorage.getItem('accessToken')}`,
            userId : sessionStorage.getItem('userId')
           }
        })
            .then((response) => {
                user.value = response.data
            })
            .catch((error) => {
                console.log(error);
            });
    }



    return { myRR, sortByHighestPace, users, sortByFrequency, sortByTotalDistance }
},
    {
        persist: true
    })
