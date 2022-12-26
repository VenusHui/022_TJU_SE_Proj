<!-- 登录页面 -->
<template>
  <div class="framebox">
    <div class="iconbox">
      <h1 style="font-size:60px;color:white;">Fander</h1>
    </div>
    <div class="inputbox">
      <nut-input class="inputraw" label="" placeholder="Student ID" max-length="7" v-model="state.number"
        type="number" />
      <nut-input class="inputraw" label="" placeholder="Password" v-model="state.password" type="password" />
    </div>
    <div class="confirmbutton">
      <nut-button size="large" type="primary" @click="ConfirmLogin">确认</nut-button>
    </div>
    <div class="slogan">
      <p>slogan place holder</p>
    </div>
  </div>
</template>

<script>
import { reactive } from 'vue';
export default {
  methods: {
    ConfirmLogin() {
      this.$router.push('/tabbarViews')
    }
  },
  setup() {
    const state = reactive({
      number: '',
      password: '',
    });
    return {
      state
    };
  }
}
</script>
<style scoped>
.framebox {
  background: linear-gradient(360deg, #f5cc45, #f5b01c, #e23c13);
  width: 100%;
  height: 100%;
  display: flex;
  /* justify-content: center; */
  flex-direction: column;
  /* align-items: center; */
}

.iconbox {
  display: flex;
  justify-content: center;
}

.inputbox {
  display: flex;
  flex-direction: column;
  background: #fcfcfc07;
}

.inputraw {
  background-color: rgba(255, 255, 255, 0);
}

.confirmbutton {
  margin-top: 20px;
  align-self: center;
  width: 80%;
}
</style>