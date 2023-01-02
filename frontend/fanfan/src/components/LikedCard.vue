<template>
    <div class="likeditem boxradius" :style="{ 'background-image': 'url(' + imgUrl + ')' }">
        <div v-if="readonly" class="blackmask boxradius"
            style="display: flex;align-items: flex-end;justify-content: center;">
            <div style="color: white;font-size: 35px;padding-bottom:3px ;">
                {{ name }}
            </div>
        </div>
        <div v-else class="blackmask boxradius" style="display: flex;flex-direction: column;align-items: flex-end;">
            <div @click="JumpDetail" style="height:100%;width:100%;"></div>
            <div class="boxradius" style="width: 100%;display: flex;justify-content: space-between;">
                <div style="color: white;font-size: 20px;display: flex;padding:0 0 10px 10px;">
                    {{ name }}
                </div>
                <div style="padding-right: 5px;">
                    <div @click="UpdateLiked" style="width: 30px;height: 30px;">
                        <nut-icon v-if="!isliked" name="addfollow" color="white" size="25px"></nut-icon>
                        <nut-icon v-if="isliked" name="heart-fill" color="red" size="30px"></nut-icon>
                    </div>
                </div>
            </div>
        </div>
        <!-- <div class="blackmask boxradius">
            <div v-if="readonly == false" @click="JumpDetail" style="height:100%;width:100%;"></div>
            <div v-if="readonly" style="color: white;font-size: 35px;">
                {{ name }}
            </div>
            <div v-else class="boxradius" style="width: 100%;display: flex;justify-content: space-between;">
                <div style="color: white;font-size: 20px;display: flex;padding:0 0 10px 10px;">
                    {{ name }}
                </div>
                <div style="padding-right: 5px;">
                    <div @click="UpdateLiked" style="width: 30px;height: 30px;">
                        <nut-icon v-if="!isliked" name="addfollow" color="white" size="25px"></nut-icon>
                        <nut-icon v-if="isliked" name="heart-fill" color="red" size="30px"></nut-icon>
                    </div>
                </div>
            </div>
        </div> -->
    </div>
</template>

<script>
export default {
    name: 'LikedCard',
    data() {
        return {
            isliked: true,
        }
    },
    props: {
        name: String,
        imgUrl: String,
        readonly: {
            type: Boolean,
            default: false,
        },
    },
    methods: {
        JumpDetail() {
            this.$router.push('/detail')
        },
        FanDish() {
            // 后端更新fan的数据
        },
        UpdateLiked() {
            this.isliked = !this.isliked;
            // 后端更新liked数据
        },
    }
}
</script>

<style>
.boxradius {
    border-radius: 3%;
}

.likeditem {
    min-width: 150px;
    width: 100%;
    height: 260px;
    background-size: cover;
    background-position: center center;
    display: flex;
    align-items: flex-end;
}

.blackmask {
    height: 100%;
    width: 100%;
    background: rgb(0, 0, 0);
    background: linear-gradient(0deg, rgba(36, 31, 0, 1) 0%, rgba(255, 255, 255, 0) 40%);
}
</style>