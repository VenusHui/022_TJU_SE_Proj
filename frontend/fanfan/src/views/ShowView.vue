<!-- 开屏页面 -->
<template>
    <div class="flexbox">
        <div class="top">
            <h1 style="font-size:60px;color:white;">Fander</h1>
        </div>
        <div class="bottom">
            <!-- <div class="tip">
                <p>click to LOG IN!!</p>
            </div> -->
            <nut-button class="loginbutton" size="large" type="primary" plain @click="JumpLogin">CLick here to Log in!</nut-button>
        </div>
    </div>
</template>

<script>
export default {
    data() {

    },
    methods: {
        JumpLogin(){
            this.$router.push('/login');
        },
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
.tip{
    color: white;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-content: center ;
}
.loginbutton{
    background-color:#e23c12;
    color: white;
}
</style>
