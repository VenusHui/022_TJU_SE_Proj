<template>
    <div style="padding:10px">
        <div class="detailpagetopbox">
            <div style="margin-right: 20px;"><nut-icon name="left" size="15px" @click="JumpBack"></nut-icon></div>
            <div style="font-size:25px">菜品详情</div>
        </div>
        <div class="detailbox" style="margin-bottom: 10px;">
            <div class="detailtopbox">
                <div class="detailinfobox marginbottom">
                    <div class="marginbottom" style="font-size:28px">
                        章鱼小丸子
                    </div>
                    <div style="display: flex; font-size: small;">
                        <div style="margin-right:20px">小食堂二楼</div>
                        <div style="margin-right:20px">￥20</div>
                        <div style="display: flex;align-items: center;">
                            <nut-icon name="star-fill" color="" size="10px" style="margin-right:5px"></nut-icon>
                            <div>4.5</div>
                        </div>
                    </div>
                    <div style="display: flex; font-size: small;">
                        <div style="margin:5px;">
                            <nut-tag color="#E9E9E9" textColor="#999999" plain>微辣</nut-tag>
                        </div>
                        <div style="margin:5px;">
                            <nut-tag color="#E9E9E9" textColor="#999999" plain>微辣</nut-tag>
                        </div>
                        <div style="margin:5px;">
                            <nut-tag color="#E9E9E9" textColor="#999999" plain>微辣</nut-tag>
                        </div>
                    </div>
                </div>
                <div>
                    <img v-if="false" src="../assets/fander-icon-black.png" style="height:40px;margin-right:20px" />
                    <img v-if="true" src="../assets/fander-icon-red.png" style="height:40px;margin-right:20px" />
                    <nut-icon v-if="true" name="addfollow" color="black" size="30px"></nut-icon>
                    <nut-icon v-if="false" name="heart" color="red" size="30px"></nut-icon>
                </div>
            </div>
            <img style="height: 25%;width: 100%;border-radius: 3%;" src="../assets/dish4.jpg" />
        </div>
        <div class="detailbox">
            <div class="marginbottom" style="font-size: 20px;">
                用户评价(103)
            </div>
            <div class="commentitem marginbottom">
                <div class="commentleftbox">
                    <nut-avatar size="normal" style="margin-right:0"
                        icon="https://img12.360buyimg.com/imagetools/jfs/t1/143702/31/16654/116794/5fc6f541Edebf8a57/4138097748889987.png">
                    </nut-avatar>
                    <div style="font-size: small;width: 65px;display: flex;justify-content: center;">
                        同济大美壹
                    </div>
                </div>
                <div class="commentrightbox">
                    <div>
                        <nut-rate active-color="#FFC800" v-model="value" readonly />
                    </div>
                    <nut-ellipsis direction="end" expandText="展开" collapseText="收起" rows="3"
                        content="NutUI3.0上线后我们研发团队也在不断的优化、测试、使用、迭代 Vue3 的相关组件，但是在跨端小程序的开发过程中，发现没有合适的组件库可以支持多端开发。为了填补这一空白，同时为了优化开发者体验，让 NutUI 能够为更多的开发者带来便利，我们决定在 NutUI 中增加小程序多端适配的能力。"></nut-ellipsis>
                </div>
            </div>
            <div class="commentitem marginbottom">
                <div class="commentleftbox">
                    <nut-avatar size="normal" style="margin-right:0"
                        icon="https://img12.360buyimg.com/imagetools/jfs/t1/143702/31/16654/116794/5fc6f541Edebf8a57/4138097748889987.png">
                    </nut-avatar>
                    <div style="font-size: small;width: 65px;display: flex;justify-content: center;">
                        同济大
                    </div>
                </div>
                <div class="commentrightbox">
                    <div>
                        <nut-rate active-color="#FFC800" v-model="value" readonly />
                    </div>
                    <nut-ellipsis direction="end" expandText="展开" collapseText="收起" rows="3"
                        content="NutUI3.0上线后我们研发团队也在不断的优化、测试、使用、迭代 Vue3 的相关组件，但是在跨端小程序的开发过程中，发现没有合适的组件库可以支持多端开发。为了填补这一空白，同时为了优化开发者体验，让 NutUI 能够为更多的开发者带来便利，我们决定在 NutUI 中增加小程序多端适配的能力。"></nut-ellipsis>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import { ref } from 'vue';
export default {
    setup() {
        const value = ref(3);
        return { value }
    },
    methods: {
        JumpBack() {
            this.$router.back();
        }
    }
}
</script>

<style>
.detailpagetopbox {
    padding: 20px;
    display: flex;
    justify-content: flex-start;
    align-items: center;
}

.detailbox {
    background-color: white;
    padding: 20px;
    border-radius: 3%;
}

.marginbottom {
    margin-bottom: 10px;
}

.detailtopbox {
    display: flex;
    align-items: center;
    justify-content: space-between;
}

.commentitem {
    display: flex;
    align-items: flex-start;
    margin: 30px 0px;
}

.commentleftbox {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-right: 10px;
}

.commentrightbox {
    font-size: small;
}
</style>