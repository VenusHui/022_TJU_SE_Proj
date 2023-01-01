<template>
    <div style="width:100%;height:100%;">
        <div class="likedtopbox">
            <div class="logotitle logocolor" style="margin-left: 10px;margin-right: 20px;">
                <b>Liked</b>
            </div>
        </div>
        <div style="margin-top:10px">
            <nut-list :listData="likeditems" height="260" container-height="600" @scroll-bottom="likedhandleScroll">
                <template v-slot:default="{ item }">
                    <nut-row class="row" type="flex" justify="center" gutter="10">
                        <nut-col :span="11">
                            <LikedCard :name="item.left.name" :imgUrl="item.left.url"></LikedCard>
                        </nut-col>
                        <nut-col :span="11">
                            <LikedCard :name="item.right.name" :imgUrl="item.right.url"></LikedCard>
                        </nut-col>
                    </nut-row>
                </template>
            </nut-list>
        </div>
    </div>
</template>

<script>
import { reactive, toRefs } from 'vue';
import LikedCard from '@/components/LikedCard.vue';
export default {
    components: {
        LikedCard,
    },
    setup() {
        const state = reactive({
            likeditems: [
                {
                    left: {
                        name: '无骨凤爪',
                        url: 'https://th.bing.com/th/id/OIP.QlzawUNOCC48hH-1paUAygHaLH?pid=ImgDet&rs=1'
                    },
                    right: {
                        name: '蒸包',
                        url: 'https://img.zcool.cn/community/01a1e759be4dbda8012075340dcb6f.jpg@1280w_1l_2o_100sh.jpg'
                    }
                },
                {
                    left: {
                        name: '沙拉',
                        url: 'https://img.zcool.cn/community/0107ca5b0d69e4a8012181b0f47e48.jpg@1280w_1l_2o_100sh.jpg'
                    },
                    right: {
                        name: '红烧肉',
                        url: 'https://img.zcool.cn/community/0185765ad628a8a801213867f67a04.jpg@1280w_1l_2o_100sh.jpg'
                    }
                },
                {
                    left: {
                        name: '无骨凤爪',
                        url: 'https://th.bing.com/th/id/OIP.QlzawUNOCC48hH-1paUAygHaLH?pid=ImgDet&rs=1'
                    },
                    right: {
                        name: '蒸包',
                        url: 'https://img.zcool.cn/community/01a1e759be4dbda8012075340dcb6f.jpg@1280w_1l_2o_100sh.jpg'
                    }
                },
                {
                    left: {
                        name: '沙拉',
                        url: 'https://img.zcool.cn/community/0107ca5b0d69e4a8012181b0f47e48.jpg@1280w_1l_2o_100sh.jpg'
                    },
                    right: {
                        name: '红烧肉',
                        url: 'https://img.zcool.cn/community/0185765ad628a8a801213867f67a04.jpg@1280w_1l_2o_100sh.jpg'
                    }
                },
                {
                    left: {
                        name: '无骨凤爪',
                        url: 'https://th.bing.com/th/id/OIP.QlzawUNOCC48hH-1paUAygHaLH?pid=ImgDet&rs=1'
                    },
                    right: {
                        name: '蒸包',
                        url: 'https://img.zcool.cn/community/01a1e759be4dbda8012075340dcb6f.jpg@1280w_1l_2o_100sh.jpg'
                    }
                },
                {
                    left: {
                        name: '沙拉',
                        url: 'https://img.zcool.cn/community/0107ca5b0d69e4a8012181b0f47e48.jpg@1280w_1l_2o_100sh.jpg'
                    },
                    right: {
                        name: '红烧肉',
                        url: 'https://img.zcool.cn/community/0185765ad628a8a801213867f67a04.jpg@1280w_1l_2o_100sh.jpg'
                    }
                },
            ]
        });
        const likedhandleScroll = () => {
            console.log("already added new array");
            let arr = new Array(
                {
                    left: {
                        name: '无骨凤爪',
                        url: 'https://th.bing.com/th/id/OIP.QlzawUNOCC48hH-1paUAygHaLH?pid=ImgDet&rs=1'
                    },
                    right: {
                        name: '蒸包',
                        url: 'https://img.zcool.cn/community/01a1e759be4dbda8012075340dcb6f.jpg@1280w_1l_2o_100sh.jpg'
                    }
                },
                {
                    left: {
                        name: '沙拉',
                        url: 'https://img.zcool.cn/community/0107ca5b0d69e4a8012181b0f47e48.jpg@1280w_1l_2o_100sh.jpg'
                    },
                    right: {
                        name: '红烧肉',
                        url: 'https://img.zcool.cn/community/0185765ad628a8a801213867f67a04.jpg@1280w_1l_2o_100sh.jpg'
                    }
                },
                );
            state.likeditems = state.likeditems.concat(arr);
        };
        return { ...toRefs(state), likedhandleScroll };
    },
}
</script>

<style>
.likedtopbox {
    padding: 10px;
    height: 50px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    background-color: white;
}

.boxradius {
    border-radius: 3%;
}
</style>