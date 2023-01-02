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
        <nut-textarea rows="5" v-model="text" limit-show max-length="50" placeholder="这次用餐的体验如何呢？请写下你宝贵的建议吧！" />
        <div style="font-size:13px;color: gray;margin: 10px 0;">用餐评分</div>
        <div style="display:flex;">
            <div style="color:gray; font-size: 18px;margin-right: 10px;">{{ rate.toPrecision(2) }}</div>
            <nut-rate active-color="#FFC800" allow-half v-model="rate" />
        </div>
    </div>
    <div style="padding:10px 30px">
        <nut-button size="large" type="primary" @click="ConfirmComment">确定</nut-button>
    </div>
</template>

<script>
import { ref } from 'vue';
export default {
    setup() {
        const text = ref('');
        const rate = ref(5.0);
        return { text, rate };
    },
    methods: {
        JumpBack() {
            this.$router.back()
        },
        ConfirmLogin() { }
    },
};
</script>

<style>

</style>