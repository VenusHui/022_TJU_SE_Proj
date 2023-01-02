<template>
    <div class="topBar">
        <div class="menuback" @click="JumpBack()">
            <nut-icon name="left" size="15px"></nut-icon>
        </div>
        <nut-popover v-model:visible="visible.lightTheme" location="bottom-end">
            <template #reference>
                <nut-icon name="setting" size="15px"></nut-icon>
            </template>
            <template #content>
                <div class="options" style="width: 76px;">
                    <div @click="RevisePassword" style="margin: 10px;">修改密码</div>
                    <div @click="ReviseInfo" style="margin: 10px;">修改信息</div>
                </div>
            </template>
        </nut-popover>
    </div>
    <div class="container">
        <div class="image">
            <nut-avatar
                size="large"
                :icon=avatar
            ></nut-avatar>
        </div>
        <div style="width:180px">
            <div style="margin-bottom: 3px;">昵称： {{userName}}</div>
            <div style="margin-bottom: 3px;">学号： {{studentId}}</div>
            <div style="">余额： 50￥</div>
        </div>
    </div>
    <div class="info">
        <nut-cell-group title="个人信息">
            <nut-cell title="年级" :desc= grade ></nut-cell>
            <nut-cell title="学院" :desc= institute ></nut-cell>
        </nut-cell-group>
        <nut-cell-group title="口味偏好">
            <nut-cell title="地区" desc="不限"></nut-cell>
            <nut-cell title="酸">
                <template v-slot:link>
                    <nut-rate active-color="yellow" v-model="value1" readonly />
                </template>
            </nut-cell>
            <nut-cell title="甜">
                <template v-slot:link>
                    <nut-rate active-color="pink" v-model="value2" readonly />
                </template>
            </nut-cell>
            <nut-cell title="麻">
                <template v-slot:link>
                    <nut-rate active-color="green" v-model="value3" readonly />
                </template>
            </nut-cell>
            <nut-cell title="辣">
                <template v-slot:link>
                    <nut-rate active-color="red" v-model="value4" readonly />
                </template>
            </nut-cell>
        </nut-cell-group>
        <div style="margin: 20px;"><nut-cell-group title="" desc=""></nut-cell-group></div>
    </div>
</template>

<script>
import { ref } from 'vue';
import axios from 'axios';
export default {
    data() {
        return{
            userName:'',
            studentId:'',
            avatar:'',
            value1:0, 
            value2:0, 
            value3:0, 
            value4:0,
            lightTheme: false,
            grade:'',
            institute:''
        }
    },
    setup() {
        const visible = ref({
            lightTheme: false,
        })
        return { visible }
    },
    methods: {
        JumpBack() {
            this.$router.back()
        },
        RevisePassword() {
            this.$router.push('/revisePassword')
        },
        ReviseInfo() {
            this.$router.push('/reviseInfo')
        }
    },
    mounted(){

        axios({
            method: 'get',
            headers: { 'Authorization': 'Bearer ' + localStorage.token },
            url: `http://124.220.158.211:7000/users/${localStorage.userId}/`,
        }).then((res) => {
            console.log('user info:',  res.data)
            this.$data.avatar = res.data.data.user.avatar;
            this.$data.studentId = res.data.data.user.studentId;
            this.$data.userName = res.data.data.user.userName;
            this.$data.grade = res.data.data.user.grade;
            this.$data.institute = res.data.data.user.institute;
        }, error => {
            console.log('错误', error.message)
        })
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

.container {
    margin: 20px;
    background-color: white;
    display: flex;
    justify-content: space-around;
    align-items: center;
}

.image {
    margin: 20px;
}

.info {
    margin: 20px;
}

.nut-icon__img{
    object-fit: cover;
}
</style>