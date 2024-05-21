import { ref } from 'vue';
import { defineStore } from 'pinia';
import axios from 'axios';

export const useStravaStore = defineStore('strava', () => {
  const accessToken = "102d5542239f5cf6daf1cc1c35d8757fc7840acc";
  const activityId = 127006; // 활동 ID

  const getActivityLaps = () => {
    axios.get(`https://www.strava.com/api/v3/activities/${activityId}/laps`, {
      headers: {
        'Authorization': `Bearer ${accessToken}`
      }
    })
    .then(response => {
      console.log('API 호출 성공. 반환된 데이터: ', response.data);
    })
    .catch(error => {
      console.error('API 호출 오류: ', error);
    });
  };

  return { getActivityLaps };
});
