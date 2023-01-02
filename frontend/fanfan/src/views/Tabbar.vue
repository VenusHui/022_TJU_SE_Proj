<template>
    <div class="top">
        <router-view></router-view>
    </div>
    <div class="tabbar">
        <van-tabbar v-model="activeName" route active-color="#e23c13">
            <van-tabbar-item to="/more" icon="apps-o">More</van-tabbar-item>
            <van-tabbar-item to="/home" icon="home-o" :dot="homedotflag">Home</van-tabbar-item>
            <van-tabbar-item to="/liked" icon="like-o">Liked</van-tabbar-item>
        </van-tabbar>
    </div>
</template>

<script>
export default {
    data() {
        return {
            homedotflag: true,
            activeName: 'home',
        }
    },
    setup() {
        return {
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