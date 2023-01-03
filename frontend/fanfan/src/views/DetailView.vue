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
                        {{ dishname }}
                    </div>
                    <div style="display: flex; font-size: small;">
                        <div style="margin-right:20px">{{ this.place }}</div>
                        <div style="margin-right:20px">￥{{ this.price }}</div>
                        <div style="display: flex;align-items: center;">
                            <nut-icon name="star-fill" color="" size="10px" style="margin-right:5px"></nut-icon>
                            <div>4.5</div>
                        </div>
                    </div>
                    <div style="display: flex; font-size: small;color:grey; padding-top:4%">
                        <!-- <div style="margin:5px;">
                            <nut-tag color="#E9E9E9" textColor="#999999" plain>微辣</nut-tag>
                        </div>
                        <div style="margin:5px;">
                            <nut-tag color="#E9E9E9" textColor="#999999" plain>微辣</nut-tag>
                        </div>
                        <div style="margin:5px;">
                            <nut-tag color="#E9E9E9" textColor="#999999" plain>微辣</nut-tag>
                        </div> -->
                        {{ description }}
                    </div>
                </div>
                <div style="display: flex;">
                    <img @click="showPopup" src="../assets/fander-icon-black.png"
                        style="height:40px;margin-right:10px" />
                    <FanPop v-if="show" :name="dishname" :imgUrl="dishimg"></FanPop>
                    <div @click="UpdateLiked">
                        <nut-icon v-if="isliked" name="heart-fill" color="red" size="40px"></nut-icon>
                        <nut-icon v-else name="addfollow" color="black" size="40px"></nut-icon>
                    </div>
                </div>
            </div>
            <img style="height: 250px;width: 100%;border-radius: 3%;object-fit:cover;" :src="dishimg" />
        </div>
        <div class="detailbox">
            <div class="marginbottom" style="font-size: 20px;">
                用户评价({{ comments.length }})
            </div>
            <!-- <li v-for="(item,index) in topbook " :key="item.bookName"> -->
            <div v-for="(item) in comments" :key="item._id" class="commentitem marginbottom">
                <div class="commentleftbox">
                    <nut-avatar size="normal" style="margin-right:0"
                    icon="my">
                    </nut-avatar>
                    <div style="font-size: small;width: 65px;display: flex;justify-content: center;">
                        {{item.userName}}
                    </div>
                </div>
                <div class="commentrightbox">
                    <div>
                        <nut-rate active-color="#FFC800" v-model="item.score" readonly />
                        <!-- {{ item.commentDate}} -->
                    </div>
                    <nut-ellipsis direction="end" expandText="展开" collapseText="收起" rows="3"
                        :content=item.context></nut-ellipsis>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import { ref } from 'vue';
import LikedCard from '@/components/LikedCard.vue';
import FanPop from '@/components/FanPop.vue';
import axios from 'axios';
export default {
    components: {
        LikedCard,
        FanPop,
    },
    data() {
        return {
            dishname: '',
            dishimg: '',
            isliked: true,
            place:'',
            price:'',
            dishId:'',
            description:'',
            comments:[
                {
                
                }
            ]
        }
    },
    mounted(){
        // console.log(this.$route.query, 7777);
        this.dishId = this.$route.query.dishId;
        axios({
            method: 'get',
            headers: { 'Authorization': 'Bearer ' + localStorage.token },
            url: `http://124.220.158.211:7000/dishes/${this.dishId}/`,
        }).then((res) => {
            console.log('dish info:', res.data.data.dish)
            this.dishimg = res.data.data.dish.photoUrl
            this.dishname = res.data.data.dish.dishName
            this.place = res.data.data.dish.position
            this.description = res.data.data.dish.description
            this.$data.comments =res.data.data.dish.comments
            this.price = res.data.data.dish.price
        }, error => {
            console.log('错误', error.message)
        })
    },
    setup() {
        const value = ref(3);//评分的值
        const show = ref(false);//饭饭成功遮罩层标志
        const showPopup = () => {
            show.value = true;
        };
        return {
            value,
            show,
            showPopup,
        };
    },
    methods: {
        JumpBack() {
            this.$router.back();
        },
        UpdateLiked() {
            this.isliked = !this.isliked;
            console.log('update the liked info')
            // 后端更新liked数据
        },
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


.popup {
    height: 60%;
    width: 70%;
    background-color: rgba(5, 119, 220, 0);
    color: white;
    padding: 10px;
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
}

.nut-icon__img{
  object-fit: cover;
}
</style>