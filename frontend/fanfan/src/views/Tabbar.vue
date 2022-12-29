<template>
    <div class="top">
        <router-view></router-view>
    </div>
    <div class="tabbar">
        <nut-tabbar bottom @tab-switch="tabSwitch" v-model:visible="activeName">
            <nut-tabbar-item to="/more" tab-title="more" name="category" icon="category"></nut-tabbar-item>
            <nut-tabbar-item to="/main" tab-title="Home" name="home" icon="home"></nut-tabbar-item>
            <nut-tabbar-item to="/liked" tab-title="Liked" name="cart" icon="heart"></nut-tabbar-item>
        </nut-tabbar>
    </div>
</template>

<script>
import { ref } from 'vue';
export default {
    setup() {
        const activeName = ref("home");
        function tabSwitch(item, index) {
            console.log('item:', item, 'index:', index);
        }
        return {
            tabSwitch,
            activeName,
        };
    },
}
</script>

<style>
.top{
    height:calc(100% - 50px);
}
.tabbar{
    display: flex;
    height:50px;
}
</style>