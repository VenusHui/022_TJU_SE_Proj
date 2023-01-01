<template>
    <div class="likeditem boxradius" @click="JumpDetail" :style="{ 'background-image': 'url(' + imgUrl + ')' }">
        <div class="likedinfobox boxradius">
            <div style="color: white;margin-bottom: 5px;">
                {{ name }}
            </div>
            <div class="likedicon">
                <img v-if="true" src="../assets/fander-icon-white.png" style="height:30px;margin-right:5px;" />
                <img v-if="false" src="../assets/fander-icon-red.png" style="height:30px;margin-right:5px;" />
                <nut-icon v-if="true" name="addfollow" color="white" size="20px"></nut-icon>
                <nut-icon v-if="false" name="heart" color="red" size="20px"></nut-icon>
            </div>
        </div>
    </div>
</template>

<script>    
export default {
    name: 'LikedCard',
    props: {
        name: String,
        imgUrl: String
    },
    methods: {
        JumpDetail() {
            this.$router.push('/detail')
        }
    }
}
</script>

<style>
.boxradius {
    border-radius: 3%;
}

.likeditem {
    width: 100%;
    height: 260px;
    /* background-image: url("../assets/dish6.jpg"); */
    background-size: cover;
    background-position: center center;
    display: flex;
    align-items: flex-end;
}

.likedinfobox {
    height: 40%;
    width: 100%;
    padding: 0 10px 10px 10px;
    background: linear-gradient(360deg, rgba(36, 31, 0, 1) 0%, rgba(255, 255, 255, 0) 100%);
    display: flex;
    justify-content: space-between;
    align-items: flex-end;
}
</style>