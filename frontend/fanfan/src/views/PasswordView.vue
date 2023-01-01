<template>
    <div class="topBar">
        <div class="back" @click="JumpBack()">
            <nut-icon name="left" size="15px"></nut-icon>
        </div>
    </div>
    <div class="password">
        <nut-cell-group title="修改密码" desc="新密码由8~20位大小写字母、数字及下划线组成">
            <nut-input 
                label="新密码" 
                placeholder="请输入新密码" 
                v-model="state.password1" 
                type="password"
            >
            </nut-input>
            <nut-input 
                label="确认密码" 
                placeholder="请再次输入新密码"
                v-model="state.password2"
                type="password"
            >
            </nut-input>
            <nut-cell title=" ">
                <template v-slot:link>
                    <nut-button type="primary" @click="Save()">保存</nut-button>
                </template>
            </nut-cell>
        </nut-cell-group>
    </div>
</template>

<script>
import { reactive } from 'vue';
export default {
    setup() {
        const state = reactive({
            password1: '',
            password2: '',
        })
        return { state }
    },
    methods: {
        JumpBack() {
            this.$router.back();
        },
        Save() {
            this.$router.back();
        }
    }
}
</script>

<style>
.topBar {
    margin: 20px;
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.password {
    margin: 20px;
}
</style>