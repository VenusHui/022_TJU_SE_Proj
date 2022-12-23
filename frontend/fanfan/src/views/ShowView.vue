<!-- 开屏页面 -->
<template>
    <div class="flexbox">
        <div class="top">
            <h1 style="font-size:60px;color:white;">Fander</h1>
        </div>
        <div class="bottom">
            <div style="padding-bottom:5%">
                <nut-button size="large" type="primary" @click="JumpRegister">创建账户</nut-button>
            </div>
            <nut-button size="large" type="primary" plain @click="JumpLogin">登录</nut-button>
        </div>

    </div>
</template>

<script>


export default {
    data() {

    },
    methods: {
        JumpRegister(){
            this.$router.push('/register')
        },
        JumpLogin(){
            this.$router.push('/login')
        }
    }
}
</script>

<style scoped>
.flexbox {
    background: linear-gradient(360deg, #f5cc45, #f5b01c, #e23c13);
    width: 100%;
    height: 100%;
    display: flex;
    justify-content: center;
    /* align-items: center; */
}

.bottom {
    width: 80%;
    height: 20%;
    margin-left: 10%;
    align-self: flex-end;
    padding-bottom: 10%;
}

.top {
    width: 100%;
    height: 40%;
    display: flex;
    justify-content: center;
    align-self: flex-start;
    padding-top: 30%;
}
</style>
