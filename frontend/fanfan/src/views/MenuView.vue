<template>
    <div>
        <div class="menutopbox">
            <div style="margin-right: 20px;" @click="JumpBack">
                <nut-icon name="left" size="15px"></nut-icon>
            </div>
            <div style="font-size:25px">{{ title }}</div>
        </div>
        <div style="margin-top: 10px;background-color: white;padding:10px 0 10px 10px;">
            <nut-list :listData="menuresults" height="125" container-height="1000" @scroll-bottom="menuhandleScroll">
                <template v-if="menuresults" v-slot:default="{ item }">
                    <nut-card :img-url="item.photoUrl" :title="item.dishName" :price="item.price"
                        :shopName="item.position" @click="JumpDetail(item.dishId)">
                        <template #origin>
                        </template>
                        <template #shop-tag>
                            <nut-rate active-color="#FFC800" v-model="item.score" readonly spacing="10"
                                style="height:20px" />
                            <div style="color: gray;font-size: small;">{{ item.score }} ({{ item.comments == null ? 0 :
        item.comments.length
                                }})</div>
                        </template>
                    </nut-card>
                </template>
            </nut-list>
        </div>
    </div>
</template>

<script>
import { reactive, toRefs } from 'vue';
import axios from 'axios';
export default {
    data() {
        return {
            menuresults: [],
            title: '',
        }
    },
    setup() {

    },
    methods: {
        JumpDetail(dishId) {
            this.$router.push({ path: "/detail", query: { dishId: dishId } });
        },
        JumpBack() {
            this.$router.back()
        }
    },
    mounted() {
        // console.log(this.$route.query, 7777);
        // this.dishId = this.$route.query.dishId;
        // this.$route.query.position
        // get dishes 
        if (this.$route.query.kind == 'position') {
            this.title = this.$route.query.param;
            axios({
                method: 'get',
                headers: { 'Authorization': 'Bearer ' + localStorage.token },
                url: 'http://124.220.158.211:7000/dishes/',
                params: {
                    filter: 'position',
                    value: this.$route.query.param
                }
            }).then((res) => {
                console.log('dish info:', res)
                this.menuresults = res.data.data.dishes.content
                // this.$data.cards = res.data.data.dishes;
            }, error => {
                console.log('错误', error.message)
            })
        }
        if (this.$route.query.kind == 'name') {
            this.title = '搜索';
            axios({
                method: 'get',
                headers: { 'Authorization': 'Bearer ' + localStorage.token },
                url: 'http://124.220.158.211:7000/dishes/',
                params: {
                    filter: 'dishName',
                    value: this.$route.query.param
                }
            }).then((res) => {
                console.log('dish info:', res)
                this.menuresults = res.data.data.dishes.content
                // this.$data.cards = res.data.data.dishes;
            }, error => {
                console.log('错误', error.message)
            })
        }
    }
}
</script>

<style>
.menutopbox {
    padding: 20px;
    display: flex;
    justify-content: flex-start;
    align-items: center;
    background-color: white;
}

/* .nut-card .nut-card__left>img{
    width: auto;  
    height: auto;  
    min-width: 100%;
    max-width: 100%;  
    min-height: 100%;
} */
</style>