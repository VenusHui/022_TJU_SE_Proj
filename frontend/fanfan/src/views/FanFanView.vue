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
            <nut-card :img-url="state.list[0].imgUrl" :title="state.list[0].title" :price="state.list[0].price"
                :shopName="state.list[0].shopName">
                <!-- <template #prolist>
                    <nut-tag color="#E9E9E9" textColor="#999999" plain>微辣</nut-tag>
                </template> -->
                <template #origin>
                </template>
                <template #shop-tag>
                    <nut-rate active-color="#FFC800" v-model="state.list[0].rate" readonly spacing="10" style="height:20px" />
                    <div style="color: gray;font-size: small;">{{ state.list[0].rate }}</div>
                </template>
                <template #footer>
                    <div class="customize">
                        <nut-button type="mini" @click="Comment()">评价</nut-button>
                    </div>
                </template>
            </nut-card>
        </nut-tabpane>
        <nut-tabpane title="已评价">
            <nut-card :img-url="state.list[0].imgUrl" :title="state.list[0].title" :price="state.list[0].price"
                :shopName="state.list[0].shopName">
                <!-- <template #prolist>
                    <nut-tag color="#E9E9E9" textColor="#999999" plain>微辣</nut-tag>
                </template> -->
                <template #origin>
                </template>
                <template #shop-tag>
                    <nut-rate active-color="#FFC800" v-model="state.list[0].rate" readonly spacing="10" style="height:20px" />
                    <div style="color: gray;font-size: small;">{{ state.list[0].rate }}</div>
                </template>
                <template #footer>
                    <div class="customize">
                        <nut-button type="mini" @click="Comment()">评价</nut-button>
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