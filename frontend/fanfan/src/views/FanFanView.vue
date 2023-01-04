<template>
    <nut-navbar style="margin-bottom:0;" @on-click-back="JumpBack()">
        <template #content>
            <div class="" style="font-size:18px;color: black;">饭饭</div>
        </template>
        <template #left>
            <nut-icon name="left" size="15px"></nut-icon>
        </template>
    </nut-navbar>
    <nut-tabs v-model="state.tab1value">
        <nut-tabpane title="待评价">
            <div class="CardToComment" v-for="(item, index) in this.ListToComment" :key="index">
                <nut-card :img-url="item.imgUrl" :title="item.title" :price="item.price"
                    :shopName="item.shopName">
                    <!-- <template #prolist>
                        <nut-tag color="#E9E9E9" textColor="#999999" plain>微辣</nut-tag>
                    </template> -->
                    <template #origin>
                    </template>
                    <template #shop-tag>
                        <nut-rate active-color="#FFC800" v-model="item.rate" readonly spacing="10" style="height:20px" />
                        <div style="color: gray;font-size: small;">{{ item.rate }}</div>
                    </template>
                    <template #footer>
                        <div class="customize">
                            <nut-button type="mini" @click="Comment()">评价</nut-button>
                        </div>
                    </template>
                </nut-card>
            </div>
        </nut-tabpane>
        <nut-tabpane title="已评价">
            <div class="ListCommented" v-for="(item, index) in this.ListCommented" :key="index">
                <nut-card :img-url="item.imgUrl" :title="item.title" :price="item.price"
                    :shopName="item.shopName" >
                    <!-- <template #prolist>
                        <nut-tag color="#E9E9E9" textColor="#999999" plain>微辣</nut-tag>
                    </template> -->
                    <template #origin>
                    </template>
                    <template #shop-tag>
                        <nut-rate active-color="#FFC800" v-model="item.rate" readonly spacing="10" style="height:20px" />
                        <div style="color: gray;font-size: small;">{{ item.rate }}</div>
                    </template>
                    <template #footer>
                        <div class="customize">
                            <nut-button type="mini" @click="Comment()">评价</nut-button>
                        </div>
                    </template>
                </nut-card>
            </div>
        </nut-tabpane>
    </nut-tabs>
</template>

<script>
import axios from 'axios';
import { reactive } from 'vue';
export default {
    setup() {
        const state = reactive({
            tab1value: '0',
            list: [{
                imgUrl:
                    'http://rntej2yad.hd-bkt.clouddn.com/assets/dish12.jpg',
                title: '咕噜肉',
                shopName: '大食堂一楼',
                price: 5,
                rate:4.5
            }]
        });
        return { state };
    },
    methods: {
        JumpBack() {
            this.$router.back();
        },
        Comment() {
            this.$router.push('/commentedit')
        }
    },
    data() {
        return {
            ListToComment : [
                {
                imgUrl: 'http://rntej2yad.hd-bkt.clouddn.com/assets/dish12.jpg',
                title: '咕噜肉',
                shopName: '大食堂一楼',
                price: 5,
                rate: 4.5,
                },
                {
                imgUrl: 'http://rntej2yad.hd-bkt.clouddn.com/assets/dish01.jpg',
                title: '蔬菜沙拉',
                shopName: '大食堂二楼',
                price: 0.99,
                rate: 3.5,
                },
                {
                imgUrl: 'http://rntej2yad.hd-bkt.clouddn.com/assets/dish11.jpg',
                title: '无骨凤爪',
                shopName: '小食堂一楼',
                price: 0.99,
                rate: 3.5,
                },                
            ],
            ListCommented : []
        }
    },
    mounted() {
        // axios({
        //     method: 'get',
        //     headers: { 'Authorization': 'Bearer ' + localStorage.token },
        //     url: '',
        // }).then((res) => {
        //     this.$data.ListToComment = null;
        // }, error => {
        //     console.log("错误", error.message)
        // })

        // axios({
        //     method: 'get',
        //     headers: { 'Authorization': 'Bearer ' + localStorage.token },
        //     url: '',
        // }).then((res) => {
        //     this.$data.ListCommented = null;
        // }, error => {
        //     console.log("错误", error.message)
        // })
    }
}
</script>

<style>
.container {
    margin: 20px;
    display: flex;
    justify-content: flex-start;
}

.basic {
    margin-top: 20px;
    font-size: 10px;
}

.nut-card{
    padding-bottom:5%;
}
</style>