<template>
    <nut-navbar @on-click-back="JumpBack()" title="我的饭饭">
        <template #left>
            <nut-icon name="left" size="15px"></nut-icon>
        </template>
    </nut-navbar>
    <div class="container">
        <nut-avatar
            size="large"
            icon="https://img12.360buyimg.com/imagetools/jfs/t1/143702/31/16654/116794/5fc6f541Edebf8a57/4138097748889987.png"
        >
        </nut-avatar>
        <div class="basic">
            <div style="margin-bottom: 3px;">昵称： 烫烫烫</div>
            <div style="margin-top: 3px;">学号： 205XXXX</div>
        </div>
    </div>
    <nut-tabs v-model="state.tab1value">
        <nut-tabpane title="待评价">
            <nut-card :img-url="state.list[0].imgUrl" :title="state.list[0].title" :price="state.list[0].price" :shopName="state.list[0].shopName">
                <template #prolist>
                    <div class="customize">不辣</div>
                </template>
                <!-- <template #price>
                    <div class="customize">价格</div>
                </template> -->
                <template #origin>
                    <div class="customize"></div>
                </template>
                <template #shop-tag>
                    <div class="customize">大食堂二楼</div>
                </template>
                <template #footer>
                    <div class="customize">
                        <nut-button type="primary" @click="Comment()">评价</nut-button>
                    </div>
                </template>
            </nut-card>
            <nut-card :img-url="state.list[1].imgUrl" :title="state.list[1].title" :price="state.list[1].price" :shopName="state.list[1].shopName">
                <template #prolist>
                    <div class="customize">不辣</div>
                </template>
                <!-- <template #price>
                    <div class="customize">价格</div>
                </template> -->
                <template #origin>
                    <div class="customize"></div>
                </template>
                <template #shop-tag>
                    <div class="customize">大食堂二楼</div>
                </template>
                <template #footer>
                    <div class="customize">
                        <nut-button type="primary" @click="Comment()">评价</nut-button>
                    </div>
                </template>
            </nut-card>
            <nut-card :img-url="state.list[2].imgUrl" :title="state.list[2].title" :price="state.list[2].price" :shopName="state.list[2].shopName">
                <template #prolist>
                    <div class="customize">不辣</div>
                </template>
                <!-- <template #price>
                    <div class="customize">价格</div>
                </template> -->
                <template #origin>
                    <div class="customize"></div>
                </template>
                <template #shop-tag>
                    <div class="customize">大食堂二楼</div>
                </template>
                <template #footer>
                    <div class="customize">
                        <nut-button type="primary" @click="Comment()">评价</nut-button>
                    </div>
                </template>
            </nut-card>
            <nut-card :img-url="state.list[3].imgUrl" :title="state.list[3].title" :price="state.list[3].price" :shopName="state.list[3].shopName">
                <template #prolist>
                    <div class="customize">不辣</div>
                </template>
                <!-- <template #price>
                    <div class="customize">价格</div>
                </template> -->
                <template #origin>
                    <div class="customize"></div>
                </template>
                <template #shop-tag>
                    <div class="customize">大食堂二楼</div>
                </template>
                <template #footer>
                    <div class="customize">
                        <nut-button type="primary" @click="Comment()">评价</nut-button>
                    </div>
                </template>
            </nut-card>
        </nut-tabpane>
        <nut-tabpane title="已评价">
            <nut-card :img-url="state.list[0].imgUrl" :title="state.list[0].title" :price="state.list[0].price" :shopName="state.list[0].shopName">
                <template #prolist>
                    <div class="customize">不辣</div>
                </template>
                <!-- <template #price>
                    <div class="customize">价格</div>
                </template> -->
                <template #origin>
                    <div class="customize"></div>
                </template>
                <template #shop-tag>
                    <div class="customize">大食堂二楼</div>
                </template>
                <template #footer>
                    <div class="customize">
                        <nut-button type="primary" @click="Comment()">查看</nut-button>
                    </div>
                </template>
            </nut-card>
        </nut-tabpane>
    </nut-tabs>
</template>

<script>
import { reactive } from 'vue';
export default {
    setup() {
        const state = reactive({
            tab1value: '0',
            list: [{
                imgUrl:
                    '//img10.360buyimg.com/n2/s240x240_jfs/t1/210890/22/4728/163829/6163a590Eb7c6f4b5/6390526d49791cb9.jpg!q70.jpg',
                title: '阳澄湖大闸蟹',
                shopName: '二楼',
                price: 100,
            },{
                imgUrl:
                    '//img10.360buyimg.com/n2/s240x240_jfs/t1/210890/22/4728/163829/6163a590Eb7c6f4b5/6390526d49791cb9.jpg!q70.jpg',
                title: '阳澄湖大闸蟹',
                shopName: '二楼',
                price: 100,
            },{
                imgUrl:
                    '//img10.360buyimg.com/n2/s240x240_jfs/t1/210890/22/4728/163829/6163a590Eb7c6f4b5/6390526d49791cb9.jpg!q70.jpg',
                title: '阳澄湖大闸蟹',
                shopName: '二楼',
                price: 100,
            },{
                imgUrl:
                    '//img10.360buyimg.com/n2/s240x240_jfs/t1/210890/22/4728/163829/6163a590Eb7c6f4b5/6390526d49791cb9.jpg!q70.jpg',
                title: '阳澄湖大闸蟹',
                shopName: '二楼',
                price: 100,
            }]
        });
        return { state };
    },
    methods: {
        JumpBack() {
            this.$router.back();
        },
        Comment() {

        }
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
</style>