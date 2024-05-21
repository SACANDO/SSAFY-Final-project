<template>
  <div>
    <button @click="authorize">Test용</button>
  </div>
</template>

<script setup>
import { useStravaStore } from '@/stores/strava';
import { useRoute, useRouter } from 'vue-router';


const stravaStore = useStravaStore();
const route = useRoute();
const router = useRouter();

const clientId = 127006;
const redirectUri = 'http://localhost:5173/strava-callback'; // 이 URL은 리디렉션 URI로 설정해야 합니다.

const authorize = () => {

  const authorizationUrl = `https://www.strava.com/oauth/authorize?client_id=${clientId}&response_type=code&redirect_uri=${redirectUri}&scope=read,activity:read_all,activity:write`;
  window.location.href = authorizationUrl;

  
};
const code = route.query.code;
  if (code) {
    stravaStore.fetchAccessToken(code).then(() => {
      router.push('/'); // 인증 후 메인 페이지로 리디렉션
    });
  }

</script>