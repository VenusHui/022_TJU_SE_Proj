<template>
    <nut-navbar style="margin-bottom:0;" @on-click-back="JumpBack()">
        <template #content>
            <div class="" style="font-size:18px;color: black;">编辑评论</div>
        </template>
        <template #left>
            <nut-icon name="left" size="15px"></nut-icon>
        </template>
    </nut-navbar>
    <div style="padding: 10px;">
        <div style="font-size:13px;color: gray;margin: 10px 0;">用餐评价</div>
        <nut-textarea rows="5" v-model=text limit-show max-length="50" placeholder="这次用餐的体验如何呢？请写下你宝贵的建议吧！" />
        <div style="font-size:13px;color: gray;margin: 10px 0;">用餐评分</div>
        <div style="display:flex;">
            <div style="color:gray; font-size: 18px;margin-right: 10px;">{{ rate.toPrecision(2) }}</div>
            <nut-rate active-color="#FFC800" allow-half v-model=rate />
        </div>
    </div>
    <div style="padding:10px 30px">
        <nut-button size="large" type="primary" @click="ConfirmComment">确定</nut-button>
    </div>
</template>

<script>
import axios from 'axios';
export default {
    data(){
        return{
            text:'',
            rate:0,
            dishId:'63b30dfa12bc4b4c97604f4e',
        }
    },
    setup() {
    },
    methods: {
        JumpBack() {
            this.$router.back()
        },
        ConfirmComment() { 

            console.log(this.text, this.rate);
            
            // 需要前一个页面传入dishId------------------------------------------
            axios({
                method: 'post',
                headers: { 'Authorization': 'Bearer ' + localStorage.token },
                // url:  `http://124.220.158.211:7000/dishes/${this.dishId}/comments/`,
                params:{
                    userId: localStorage.userId,
                    context: this.text,
                    score: this.rate
                }
            }).then((res) => {
                console.log('comment info:', res)
                // 成功后跳转回原来的位置-------------------------

            }, error => {
                console.log('错误', error.message)
            })

            
        }
    },
};
</script>

<style>

</style>