<template>
    <van-popup class="popup" v-model:show="show">
        <div style="font-size: 25px;margin-bottom: 10px;display: flex;align-items: center;">
            <nut-icon name="star-fill" color="#FFC800" size="30px"></nut-icon>
            <b style="margin:5px"> 干饭人!!干饭魂 </b>
            <nut-icon name="star-fill" color="#FFC800" size="30px"></nut-icon>
        </div>
        <LikedCard :name="name" :imgUrl="imgUrl" :readonly="true">
        </LikedCard>
        <nut-button @click="JumpFan" style="margin-top:10px;" type="primary" color="#e23c13">
            ╰ 速速饭饭 ╯</nut-button>
    </van-popup>
</template>

<script>
import LikedCard from '@/components/LikedCard.vue';
import axios from 'axios';
export default {
    name: 'FanPop',
    data() {
        return {
            show: true,
        }
    },
    components: {
        LikedCard,
    },
    props: {
        name: String,
        imgUrl: String,
    },
    methods: {
        JumpFan() {
            // axios({//调用饭饭接口
            //     method: 'post',
            //     headers: { 'Authorization': 'Bearer ' + localStorage.token },
            //     url: `http://124.220.158.211:7000/users/${localStorage.userId}/`,
            // }).then((res) => {
            //     console.log('饭饭成功');
            // }, error => {
            //     console.log('错误', error.message)
            // })
            this.$router.push('/fanfan');//跳转至饭饭添加评论界面
        }
    },
}
</script>

<style>
.popup {
    height: 60%;
    width: 70%;
    background-color: rgba(5, 119, 220, 0);
    color: white;
    padding: 10px;
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
}
</style>