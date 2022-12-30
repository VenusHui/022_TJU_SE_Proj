<template>
    <div style="wwidth:100% height:100%">
        <div style="margin: 10px;">
            <div class="logotitle logocolor" style="margin-left: 10px;">
                <b>Liked</b>
            </div>
        </div>
        <div class="likedlist">
            <nut-list :listData="likeditems" height="100" container-height="1000" @scroll-bottom="handleScroll">
                <template v-slot:default="{ item }">
                    <LikedCard :imgUrl="item.url" :name="item.name"></LikedCard>
                </template>
            </nut-list>
        </div>
    </div>
</template>

<script>
import { onMounted, reactive, toRefs } from 'vue';
import LikedCard from '@/components/LikedCard.vue';
export default {
    components: {
        LikedCard,
    },
    data() {
    },
    setup() {
        const state = reactive({
            likeditems:[ {
                    name: '团子',
                    url: 'http://m.qpic.cn/psc?/V52GkrG44dJy6U3B701r1clpAh3TUGbg/ruAMsa53pVQWN7FLK88i5iun53s.f1wnujnx0VaGVMfsEDLlX3CydS08FyVnL7jY51bqg0tiQiBCpUak5jMKYihuYZyLROc2zstEa*65BTY!/b&bo=UwY4BAAAAAABF1k!&rf=viewer_4'
                },
                {
                    name: '牛肉',
                    url: '../assets/dish2.jpg'
                },
                {
                    name: '小丸子',
                    url: '../assets/dish3.jpg'
                },
                {
                    name: '牛肉',
                    url: '../assets/dish2.jpg'
                },
                {
                    name: '小丸子',
                    url: '../assets/dish3.jpg'
                },
                {
                    name: '牛肉',
                    url: '../assets/dish2.jpg'
                },
                {
                    name: '小丸子',
                    url: '../assets/dish3.jpg'
                }                
            ]
        });
        const handleScroll = () => {
            let arr = new Array(
                {
                    name: '牛肉',
                    url: '../assets/dish2.jpg'
                },
                {
                    name: '小丸子',
                    url: '../assets/dish3.jpg'
                });
            state.likeditems = state.likeditems.concat(arr);
        };
        return { ...toRefs(state), handleScroll };
    },
}
</script>

<style>
.likedlist {
    padding: 10px;
    width: 100%;
    height: 100%;
}

.boxradius {
    border-radius: 3%;
}

/* .likeditem {
    width: 45%;
    height: 260px;
    margin: 5px;
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
} */
</style>