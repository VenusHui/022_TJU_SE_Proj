<template>
    <div style="width:100%;height:100%;">
        <div class="likedtopbox">
            <div class="logotitle logocolor" style="margin-left: 10px;margin-right: 20px;">
                <b>Liked</b>
            </div>
        </div>
        <div style="margin-top:10px">
            <!-- <nut-list :listData="likeditems" height="260" container-height="530"> -->
            <nut-list :listData="likedlist" height="260" container-height="530">
                <template v-slot:default="{ index, item }">
                    <nut-row v-if="index % 2 == 0" class="row" type="flex" justify="center" gutter="10">
                        <nut-col :span="11">
                            <LikedCard :name="item.name" :imgUrl="item.url"></LikedCard>
                        </nut-col>
                        <nut-col :span="11">
                            <LikedCard :name="likedlist[index + 1].name" :imgUrl="likedlist[index + 1].url"></LikedCard>
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
import axios from 'axios'
export default {
    components: {
        LikedCard,
    },
    data() {
        return {
            likedlist: [
                {
                    name: '无骨凤爪',
                    url: 'https://th.bing.com/th/id/OIP.QlzawUNOCC48hH-1paUAygHaLH?pid=ImgDet&rs=1',
                },
                {
                    name: '蒸包',
                    url: 'https://img.zcool.cn/community/01a1e759be4dbda8012075340dcb6f.jpg@1280w_1l_2o_100sh.jpg'
                },
            ],
            likeditems: [
                {
                    left: {
                        name: '无骨凤爪',
                        url: 'https://th.bing.com/th/id/OIP.QlzawUNOCC48hH-1paUAygHaLH?pid=ImgDet&rs=1',
                    },
                    right: {
                        name: '蒸包',
                        url: 'https://img.zcool.cn/community/01a1e759be4dbda8012075340dcb6f.jpg@1280w_1l_2o_100sh.jpg'
                    }
                }, {
                    left: {
                        name: '无骨凤爪',
                        url: 'https://th.bing.com/th/id/OIP.QlzawUNOCC48hH-1paUAygHaLH?pid=ImgDet&rs=1',
                    },
                    right: {
                        name: '蒸包',
                        url: 'https://img.zcool.cn/community/01a1e759be4dbda8012075340dcb6f.jpg@1280w_1l_2o_100sh.jpg'
                    }
                }
            ]
        }
    },
    mounted() {
        // 获取liked list-------------------------------------------------
        axios({
            method: 'get',
            headers: { 'Authorization': 'Bearer ' + localStorage.token },
            // url: `http://124.220.158.211:7000/users/${localStorage.userId}/`,
        }).then((res) => {
            console.log('liked list:', res.data.data.user.avatar)
        }, error => {
            console.log('错误', error.message)
        })
    }
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