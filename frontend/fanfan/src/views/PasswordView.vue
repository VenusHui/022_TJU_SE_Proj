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
                v-model="password1" 
                type="password"
            >
            </nut-input>
            <nut-input 
                label="确认密码" 
                placeholder="请再次输入新密码"
                v-model="password2"
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
import axios from 'axios';
export default {
    data()
    {
        return{
            password1: '',
            password2: '',
        }
    },
    setup() {
    },
    methods: {
        JumpBack() {
            this.$router.back();
        },
        Save() {
            axios({
                method: 'put',
                headers: { 'Authorization': 'Bearer ' + localStorage.token,
                            'Content-Type': 'multipart/form-data'},
                params: {
                    userId: localStorage.userId
                },
                data: {
                    newPassword: this.password2,
                },
                url: `http://124.220.158.211:7000/users/${localStorage.userId}/password/`,
            }).then((res) => {
                console.log('user info:', res.data)
            }, error => {
                console.log('错误', error.message)
            })
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