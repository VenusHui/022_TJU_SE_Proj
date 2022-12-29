<template>
    <div>
        <div style="margin: 10px;">
            <div class="logotitle logocolor" style="margin-left: 10px;">
                <b>Liked</b>
            </div>
            </div>
            <div class="likedlist">
                <div class="likeditem boxradius" @click="JumpDetail">
                    <div class="likedinfobox boxradius">
                        <div style="color: white;">
                            团子
                        </div>
                        <div class="likedicon">
                            <nut-icon name="heart" size="20px" color="white"></nut-icon>
                        </div>
                    </div>
                </div>
                <div class="likeditem boxradius" @click="JumpDetail">
                    <div class="likedinfobox boxradius">
                        <div style="color: white;">
                            团子
                        </div>
                        <div class="likedicon">
                            <nut-icon name="heart" size="20px" color="white"></nut-icon>
                        </div>
                    </div>
                </div>
                <div class="likeditem boxradius" @click="JumpDetail">
                    <div class="likedinfobox boxradius">
                        <div style="color: white;">
                            团子
                        </div>
                        <div class="likedicon">
                            <nut-icon name="heart" size="20px" color="white"></nut-icon>
                        </div>
                    </div>
                </div>
            </div>
    </div>
</template>

<script>
export default {
    setup() {

    },
    methods: {
        JumpDetail() {
            this.$router.push('/detail')
        }
    }
}
</script>

<style>
.likedlist {
    padding: 10px;
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    width: 100%;
}

.boxradius {
    border-radius: 3%;
}

.likeditem {
    width: 45%;
    height: 260px;
    margin: 5px;
    background-image: url("../assets/dish6.jpg");
    background-size: auto 100%;
    background-position: center center;
    display: flex;
    align-items: flex-end;
}

.likedinfobox {
    height: 25%;
    width: 100%;
    background: linear-gradient(360deg, rgba(36, 31, 0, 1) 0%, rgba(255, 255, 255, 0) 100%);
    display: flex;
    justify-content: space-around;
    align-items: center;
}
</style>