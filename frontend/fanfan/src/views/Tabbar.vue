<template>
    <div class="top">
        <router-view></router-view>
    </div>
    <div class="tabbar">
        <nut-tabbar :bottom="true" :safe-area-inset-bottom="true" @tab-switch="tabSwitch" v-model:visible="activeName"
            unactive-color="#7d7e80" active-color="#e23c13">
            <nut-tabbar-item to="/more" tab-title="more" name="category" icon="category"></nut-tabbar-item>
            <nut-tabbar-item to="/home" tab-title="home" name="home" icon="home" :dot="homedotflag"></nut-tabbar-item>
            <nut-tabbar-item to="/liked" tab-title="liked" name="cart" icon="heart"></nut-tabbar-item>
        </nut-tabbar>
    </div>
</template>

<script>
import { ref } from 'vue';
export default {
    data() {
        return {
            homedotflag: true,
            activeName: 'home',
        }
    },
    setup() {
        // const activeName = ref("home");
        function tabSwitch(item, index) {
            console.log('item:', item, 'index:', index);
            this.activeName = index;
        }
        return {
            tabSwitch,
            // activeName,
        };
    },
}
</script>

<style>
.top {
    max-height: calc(100% - 50px);
    height: calc(100% - 50px);
}

.tabbar {
    display: flex;
    height: 50px;
}

.nut-tabbar-bottom {
    position: absolute;
}
</style>