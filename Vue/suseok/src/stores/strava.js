import { defineStore } from 'pinia';
import axios from 'axios';
import { ref } from 'vue';

export const useStravaStore = defineStore('strava', () => {

  const accessToken = ref('');
  const activities = ref([]); // activities 상태 추가

  const setAccessToken = (token) => {
    accessToken.value = token;
  };

  const fetchAccessToken = (code) => {
    const clientId = 127006;
    const clientSecret = '523508331437e9d48157b17a37d2cde118a953b8';
    const url = 'https://www.strava.com/oauth/token';

    const data = {
      client_id: clientId,
      client_secret: clientSecret,
      code: code,
      grant_type: 'authorization_code',
    };

    return axios.post(url, data)
      .then(response => {
        setAccessToken(response.data.access_token);
        console.log("Access token fetched successfully:", response);
        // 액세스 토큰을 가져온 후 런닝 활동 데이터를 가져옴
        return fetchRunningActivities(response.data.access_token);
      })
      .then(() => {
        // 요약 정보를 서버로 전송
        return sendSummaryToServer();
      })
      .catch(error => {
        console.error('Error fetching access token or activities:', error.response ? error.response.data : error.message);
      });
  };

  const fetchRunningActivities = (token, perPage = 10) => {
    console.log(token)
    return axios.get('https://www.strava.com/api/v3/athlete/activities', {
      headers: {
        Authorization : `Bearer ${token}`
      },
      params: {
        per_page: perPage
      }
    })
      .then(response => {
        // 런닝 활동만 필터링
        const runningActivities = response.data.filter(activity => activity.type === 'Run');
        return Promise.all(runningActivities.map(activity => fetchLaps(activity.id, token)));
      })
      .then(() => {
        saveToLocalStorage();
      })
      .catch(error => {
        // console.log()
        console.error('Error fetching activities:', error.response ? error.response.data : error.message);
      });
  };

  const fetchLaps = (activityId, token) => {
    return axios.get(`https://www.strava.com/api/v3/activities/${activityId}/laps`, {
      headers: {
        'Authorization': `Bearer ${token}`
      }
    })
      .then(response => {
        // 랩 데이터를 모두 받아와서 배열로 저장
        const laps = response.data.map(lap => ({
          date: lap.start_date,
          distance: lap.distance,
          runTime: lap.elapsed_time,
          pace: lap.elapsed_time / lap.distance,
          userSeq: null, // 실제 userSeq 값으로 변경
          averageSpeed: lap.average_speed
        }));
        activities.value.push(...laps);
      })
      .catch(error => {
        console.error('Error fetching laps:', error.response ? error.response.data : error.message);
      });
  };

  const saveToLocalStorage = () => {
    localStorage.setItem('activities', JSON.stringify(activities.value));
  };

  const loadFromLocalStorage = () => {
    const data = localStorage.getItem('activities');
    if (data) {
      activities.value = JSON.parse(data);
    }
  };

  const sendSummaryToServer = () => {
    const totalDistance = activities.value.reduce((sum, lap) => sum + lap.distance, 0);
    const totalRunTime = activities.value.reduce((sum, lap) => sum + lap.runTime, 0);
    const count = activities.value.length;
    const highestPace = Math.max(...activities.value.map(lap => lap.averageSpeed));
    const pace = totalDistance > 0 ? totalRunTime / totalDistance : 0;

    const userSeq = 1; // 실제 userSeq 값을 사용
    const payload = {
      user_seq: userSeq,
      frequency: count,
      total_distance: totalDistance,
      highest_pace: highestPace,
      updated_at: new Date().toISOString()
    };

    const userId = sessionStorage.getItem('userId'); // sessionStorage에서 userId 가져오기

    return axios.post('http://localhost:8080/records', payload, {
      headers: {
        'Authorization': `Bearer ${accessToken.value}`,
        'userId': userId
      }
    })
      .then(() => {
        console.log('Data sent to server successfully');
        console.log(localStorage.getItem('activities'))
      })
      .catch(error => {
        console.error('Error sending data to server:', error.response ? error.response.data : error.message);
      });
  };

  return { 
    sendSummaryToServer, 
    loadFromLocalStorage, 
    fetchLaps, 
    saveToLocalStorage, 
    fetchRunningActivities, 
    fetchAccessToken, 
    setAccessToken, 
    accessToken, 
    activities 
  };
});
