<template>
    <div class="framebox">
        <div class="menutopbox">
            <div class="menuback" style="margin-top:5px"><nut-icon name="left" size="20px"></nut-icon></div>
            <div class="menutitle" style="font-size:20px">菜单</div>
        </div>
        <div class="menubodybox">
            <div class="menuitem" @click="JumpDetail">
                <nut-card :img-url="state.imgUrl" :title="state.title" :price="state.price"
                    :shopName="state.shopName">
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
                        <div class="customize">评分</div>
                    </template>
                </nut-card>
            </div>
            <div class="menuitem">
                <nut-card :img-url="state.imgUrl" :title="state.title" :price="state.price" :shopName="state.shopName">
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
                        <div class="customize">评分</div>
                    </template>
                </nut-card>
            </div>
        </div>
    </div>
</template>

<script>
import { reactive } from 'vue';
export default {
    setup() {
        const state = reactive({
            imgUrl:
                '//img10.360buyimg.com/n2/s240x240_jfs/t1/210890/22/4728/163829/6163a590Eb7c6f4b5/6390526d49791cb9.jpg!q70.jpg',
            title: '阳澄湖大闸蟹',
            shopName: '二楼',
            price: 100,
        });
        return {
            state
        };
    },
    methods: {
        JumpDetail() {
            this.$router.push('/detail')
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
}

.menuitem {
    margin: 10px;
    padding: 10px;
    border-radius: 3%;
    background-color: white;
}
</style>