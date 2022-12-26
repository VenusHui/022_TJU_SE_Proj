<template>
    <div class="framebox">
        <div class="menutopbox">
            <div class="menuback" style="margin-top:5px"><nut-icon name="left" size="20px"></nut-icon></div>
            <div class="menutitle" style="font-size:20px">菜单</div>
        </div>
        <div class="bodybox">
            <div class="menu">
                <!-- <nut-card :img-url="assets/dish2.jpg" :title="state.title" :price="state.price" :vipPrice="state.vipPrice"
                    :shopDesc="state.shopDesc" :delivery="state.delivery" :shopName="state.shopName">
                </nut-card> -->
            </div>
        </div>
    </div>
</template>

<script>
// import { reactive } from 'vue';
// export default {
//     setup() {
//         const state = reactive({
//             imgUrl:'/src/assets/dish2.jpg',
//             title: '活蟹】湖塘煙雨 阳澄湖大闸蟹公4.5两 母3.5两 4对8只 鲜活生鲜螃蟹现货水产礼盒海鲜水',
//             price: '388',
//             vipPrice: '378',
//             shopDesc: '自营',
//             delivery: '厂商配送',
//             shopName: '阳澄湖大闸蟹自营店>'
//         });
//         return {
//             state
//         };
//     }
// }
</script>

<style>
.menutopbox {
    padding: 20px;
    display: flex;
    justify-content: flex-start;
    align-items: center;
}
</style>