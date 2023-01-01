<template>
    <div class="topBar">
        <div class="menuback" @click="JumpBack()">
            <nut-icon name="left" size="15px"></nut-icon>
        </div>
        <div class="settings" @click="">
            <nut-icon name="setting" size="15px"></nut-icon>
        </div>
    </div>
    <div class="container">
        <div class="image">
            <nut-avatar
                size="large"
                icon="https://img12.360buyimg.com/imagetools/jfs/t1/143702/31/16654/116794/5fc6f541Edebf8a57/4138097748889987.png"
            ></nut-avatar>
        </div>
        <div class="basic">
            <div style="margin-bottom: 3px;">昵称： 烫烫烫</div>
            <div style="margin-top: 3px;">学号： 205XXXX</div>
        </div>
    </div>
    <div class="info">
        <nut-cell-group title="个人信息">
            <nut-cell title="年级" desc="大三"></nut-cell>
            <nut-cell title="学院" desc="软件学院"></nut-cell>
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
export default {
    setup() {
        const value1 = ref(5);
        const value2 = ref(5);
        const value3 = ref(3);
        const value4 = ref(5);
        return { value1, value2, value3, value4 }
    },
    methods: {
        JumpBack() {
            this.$router.back()
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

.container {
    margin: 20px;
    background-color: white;
    display: flex;
    justify-content: space-around;
}

.image {
    margin: 20px;
}

.basic {
    margin-top: 30px;
    margin-right: 60px;
}

.info {
    margin: 20px;
}
</style>