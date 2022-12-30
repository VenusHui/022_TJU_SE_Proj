<template>
    <div class="likeditem boxradius" @click="JumpDetail">
        <!-- <img class="boxradius" :src="imgUrl" style="object-fit: cover;margin-left:10px; width: 90px;height: 90px;" /> -->
        <img class="boxradius" src="../assets/dish3.jpg" style="object-fit: cover;margin-left:10px;width: 90px;  height: 90px;" />
        <div class="likedinfobox boxradius">
            <div style="color: black; font-size: 20px;">
                {{ name }}
            </div>
            <div>
                <nut-icon name="heart-fill" size="40px" color="red" style="margin-right:20px"></nut-icon>
                <nut-icon name="star-fill-n" size="40px" color="yellow"></nut-icon>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: 'IndexBlock',
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
    width: 98%;
    height: 100px;
    background: rgb(226, 60, 19);
    background: linear-gradient(270deg, rgba(226, 60, 19, 1) 0%, rgba(255, 255, 255, 1) 61%);
    display: flex;
    align-items: center;
}

.likedinfobox {
    width: 100%;
    display: flex;
    justify-content: space-around;
    align-items: center;
}
</style>