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
            this.$router.push('/fanfan');
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