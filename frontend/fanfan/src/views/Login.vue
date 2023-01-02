<!-- 登录页面 -->
<template>
  <div class="framebox">
    <div class="login-box">
      <h1 style="font-size:60px;color:white;">Fander</h1>
      <nut-tabs v-model="loginChoice" >
        <nut-tabpane title="BY USER NAME" style="background-color:transparent;">
          <form>
            <div class="user-box">
              <input type="text" v-model="userName" name="" required="">
              <label>User Name</label>
            </div>
            <div class="user-box">
              <input type="password" v-model="passwordName" name="" required="">
              <label>Password</label>
            </div>
          </form>
        </nut-tabpane>
        <nut-tabpane title="BY STUDENT ID" style="background-color:transparent;">
          <form>
            <div class="user-box">
              <input type="text" v-model="studentId" name="" required="">
              <label>Student ID</label>
            </div>
            <div class="user-box">
              <input type="password" v-model="passwordId" name="" required="">
              <label>Password</label>
            </div>
          </form>
        </nut-tabpane>
      </nut-tabs>
      

    </div>
    <div class="bottom">
      <div class="confirmbutton">
        <nut-button size="large" type="primary" @click="ConfirmLogin">Confirm</nut-button>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
import { Toast } from '@nutui/nutui';
export default {
  data(){
    return{
      studentId:'',
      passwordId:'',
      passwordName:'',
      userName:'',
      loginChoice:'0',
    }
  },
  methods: {
    ConfirmLogin() {
      // 注册或登录

      if(this.loginChoice=='0')
      {
        // 用username登录
        console.log('0 username 登录')
        axios({
          method: 'post',
          params: {
            filter:'userName'
          },
          data: {
            userName: this.userName,
            password: this.passwordName,
          },
          headers: {'Content-Type': 'multipart/form-data'},
          url: 'http://124.220.158.211:7000/users/token/',
        }).then((res) => {
          console.log('result', res)
          if(res.data.code==201){
            // 未注册 因为是username登录所以不注册

          }
          else if(res.data.code==200)
          {
            // 登录成功
            localStorage.setItem("token", res.data.data.token)
            localStorage.setItem("userId", res.data.data.userId)
            
            this.$router.push('/home')
          }

        }, error => {
          console.log('错误', error.message)
        })
      } else {
        // 用studentid登录
        console.log('1 studentid 登录')
        axios({
          method: 'post',
          params: {
            filter: 'studentId'
          },
          data: {
            studentId: this.studentId,
            password: this.passwordId,
          },
          headers: { 'Content-Type': 'multipart/form-data' },
          url: 'http://124.220.158.211:7000/users/token/',
        }).then((res) => {
          console.log('result', res.data.code)

          if (res.data.code == 201) {
            // 未注册 id登录所以用id注册
            axios({
              method: 'post',
              data: {
                userName: this.studentId + '同学',
                studentId : this.studentId,
                password: this.passwordId,
              },
              headers: { 'Content-Type': 'multipart/form-data' },
              url: 'http://124.220.158.211:7000/users/',
            }).then((res) => {
              
              if(res.data.code==200){
                // 登录成功
                localStorage.setItem("token", res.data.data.token)
                localStorage.setItem("userId", res.data.data.userId)

                this.$router.push('/home')
              }
            }, error => {
              console.log('错误', error.message)
            })
          }
          else if(res.data.code==200)
          {
            // 登录成功
            localStorage.setItem("token", res.data.data.token)
            localStorage.setItem("userId", res.data.data.userId)
            
            this.$router.push('/home')
          }
        }, error => {
          console.log('错误', error.message)
        })
      }
    }
  },

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
  padding: 30px;
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
  font-size: 20px;
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


::v-deep .nut-tabs__titles{
  background-color: transparent;
}

::v-deep .nut-tabs__titles-item{
  color:#fff;
}
</style>