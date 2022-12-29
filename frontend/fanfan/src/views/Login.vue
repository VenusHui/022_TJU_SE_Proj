<!-- 登录页面 -->
<template>
  <!-- <div class="framebox">
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
  </div> -->
  <div class="framebox">
    <div class="login-box">
      <h1 style="font-size:60px;color:white;">Fander</h1>
      <form>
        <div class="user-box">
          <input type="text" name="" required="">
          <label>Student ID</label>
        </div>
        <div class="user-box">
          <input type="password" name="" required="">
          <label>Password</label>
        </div>
      </form>
    </div>
    <div class="bottom">

      <div class="confirmbutton">
        <nut-button size="large" type="primary" @click="ConfirmLogin">Confirm</nut-button>
      </div>
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
  margin: 10%;
}

.inputraw {
  background-color: rgba(255, 255, 255, 0);
}

.confirmbutton {
  margin-top: 20px;
  align-self: center;
  width: 80%;
}

.bottom {
  width: 100%;
  height: 20%;
  margin-left: 10%;
  align-self: flex-end;
  padding-bottom: 10%;
}




.login-box {
  position: absolute;
  top: 35%;
  left: 50%;
  width: 100%;
  padding: 40px;
  transform: translate(-50%, -50%);
  box-sizing: border-box;

}

.login-box h2 {
  margin: 0 0 30px;
  padding: 0;
  color: #fff;
  text-align: center;
}

.login-box .user-box {
  position: relative;
}

.login-box .user-box input {
  width: 100%;
  padding: 10px 0;
  font-size: 16px;
  color: #fff;
  margin-bottom: 30px;
  border: none;
  border-bottom: 1px solid #fff;
  outline: none;
  background: transparent;
}

.login-box .user-box label {
  position: absolute;
  top: 0;
  left: 0;
  padding: 10px 0;
  font-size: 16px;
  color: #fff;
  pointer-events: none;
  transition: .5s;
}

.login-box .user-box input:focus~label,
.login-box .user-box input:valid~label {
  top: -20px;
  left: 0;
  color: #ffffff;
  font-size: 12px;
}
</style>