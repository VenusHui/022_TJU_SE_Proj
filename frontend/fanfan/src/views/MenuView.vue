<template>
    <div>
        <div class="menutopbox">
            <div class="menuback" style="margin-right: 20px;" @click="JumpBack">
                <nut-icon name="left" size="15px"></nut-icon>
            </div>
            <div class="menutitle" style="font-size:25px">菜单</div>
        </div>
        <div class="menulist" style="margin-top: 10px;background-color: white;">
            <nut-list :listData="menuresults" height="125" container-height="1000" @scroll-bottom="menuhandleScroll">
                <template v-slot:default="{ item }">
                    <nut-card :img-url="item.imgUrl" :title="item.title" :price="item.price"
                        :shopName="item.shopName" @click="JumpDetail">
                        <template #prolist>
                            <nut-tag color="#E9E9E9" textColor="#999999" plain>微辣</nut-tag>
                        </template>
                        <template #origin>
                        </template>
                        <template #shop-tag>
                            <nut-rate  active-color="#FFC800" v-model="item.rate" readonly spacing="10" style="height:20px" />
                            <div style="color: gray;font-size: small;">{{ item.rate }}</div>
                        </template>
                    </nut-card>
                </template>
            </nut-list>
        </div>
    </div>
</template>

<script>
import { reactive, toRefs } from 'vue';
export default {
    setup() {
        const state = reactive({
            menuresults: [
                {
                    imgUrl: 'https://th.bing.com/th/id/OIP.QlzawUNOCC48hH-1paUAygHaLH?pid=ImgDet&rs=1',
                    title: '无骨凤爪',
                    price: 20,
                    rate: 4.8,
                    shopName: '大食堂一楼',
                },
                {
                    imgUrl: 'https://th.bing.com/th/id/OIP.QlzawUNOCC48hH-1paUAygHaLH?pid=ImgDet&rs=1',
                    title: '无骨凤爪',
                    price: 20,
                    rate: 4.8,
                    shopName: '大食堂一楼',
                },
                {
                    imgUrl: 'https://th.bing.com/th/id/OIP.QlzawUNOCC48hH-1paUAygHaLH?pid=ImgDet&rs=1',
                    title: '无骨凤爪',
                    price: 20,
                    rate: 4.8,
                    shopName: '大食堂一楼',
                },
                {
                    imgUrl: 'https://th.bing.com/th/id/OIP.QlzawUNOCC48hH-1paUAygHaLH?pid=ImgDet&rs=1',
                    title: '无骨凤爪',
                    price: 20,
                    rate: 4.8,
                    shopName: '大食堂一楼',
                },
                {
                    imgUrl: 'https://th.bing.com/th/id/OIP.QlzawUNOCC48hH-1paUAygHaLH?pid=ImgDet&rs=1',
                    title: '无骨凤爪',
                    price: 20,
                    rate: 4.8,
                    shopName: '大食堂一楼',
                },
                {
                    imgUrl: 'https://th.bing.com/th/id/OIP.QlzawUNOCC48hH-1paUAygHaLH?pid=ImgDet&rs=1',
                    title: '无骨凤爪',
                    price: 20,
                    rate: 4.8,
                    shopName: '大食堂一楼',
                },
            ]
        });
        const menuhandleScroll = () => {
            let arr = new Array(
                {
                    imgUrl: 'https://th.bing.com/th/id/OIP.QlzawUNOCC48hH-1paUAygHaLH?pid=ImgDet&rs=1',
                    title: '无骨凤爪',
                    price: 20,
                    rate: 4.8,
                    shopName: '大食堂一楼',
                },
            );
            state.menuresults = state.menuresults.concat(arr);
        };
        return { ...toRefs(state), menuhandleScroll };
    },
    methods: {
        JumpDetail() {
            this.$router.push('/detail')
        },
        JumpBack() {
            this.$router.back()
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
</style>