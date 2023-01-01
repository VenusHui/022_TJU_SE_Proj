<template>
    <div class="likeditem boxradius" @click="JumpDetail" :style="{ 'background-image': 'url(' + imgUrl + ')' }">
        <div class="likedinfobox boxradius">
            <div style="color: white;">
                {{ name }}
            </div>
            <div class="likedicon">
                <nut-icon name="heart-fill" size="25px" color="red" style="margin-right:5px"></nut-icon>
                <img src="../assets/fander-icon.png" style="height:30px" />
                <!-- <nut-icon name="star" size="20px" color="white"></nut-icon> -->
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