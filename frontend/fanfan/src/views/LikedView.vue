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
                <template v-slot:default="{ item }">
                    <nut-row class="row" type="flex" justify="center" gutter="10">
                        <nut-col :span="11">
                            <LikedCard :name="item.left.name" :imgUrl="item.left.url" :_id="item.left._id">
                            </LikedCard>
                        </nut-col>
                        <nut-col :span="11">
                            <LikedCard :name="item.right.name" :imgUrl="item.right.url" :_id="item.right._id">
                            </LikedCard>
                        </nut-col>
                    </nut-row>
                    <!-- <nut-row v-if="index % 2 == 0" class="row" type="flex" justify="center" gutter="10">
                        <nut-col :span="11">
                            <LikedCard :name="item.name" :imgUrl="item.url" :_id="item._id"></LikedCard>
                        </nut-col>
                        <nut-col :span="11">
                            <LikedCard :name="likedlist[index + 1].name" :imgUrl="likedlist[index + 1].url"
                                :_id="likedlist[index + 1]._id"></LikedCard>
                        </nut-col>
                    </nut-row> -->
                </template>
            </nut-list>
        </div>
    </div>
</template>

<script>
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
                    left: {
                        name: '同济月饼',
                        url: 'http://rntej2yad.hd-bkt.clouddn.com/assets/dish15.jpg',
                        _id: '63b40092397b4e6e97d5b2f5'
                    },
                    right: {
                        name: '无骨鸡爪',
                        url: 'https://th.bing.com/th/id/OIP.QlzawUNOCC48hH-1paUAygHaLH?pid=ImgDet&rs=1',
                        _id: '63b43b264215fc121e4f476f'
                    },
                },
                {
                    left: {
                        name: '兰州牛肉面',
                        url: 'http://rntej2yad.hd-bkt.clouddn.com/assets/dish10.jpg',
                        _id: '63b43af84215fc121e4f476d'
                    },
                    right: {
                        name: '济不理蒸包',
                        url: 'https://img.zcool.cn/community/01a1e759be4dbda8012075340dcb6f.jpg@1280w_1l_2o_100sh.jpg',
                        _id: '63b49c094215fc121e4f4778'
                    },
                },
                {
                    left: {
                        name: '鸡公煲',
                        url: 'http://rntej2yad.hd-bkt.clouddn.com/assets/dish03.jpg',
                        _id: '63b49d8e4215fc121e4f477b'
                    },
                    right: {
                        name: '猪肚鸡',
                        url: 'http://rntej2yad.hd-bkt.clouddn.com/assets/dish02.jpg',
                        _id: '63b49dc74215fc121e4f477c'
                    },
                },
            ],
            // likeditems: [
            //     {
            //         left: {
            //             name: '无骨凤爪',
            //             url: 'https://th.bing.com/th/id/OIP.QlzawUNOCC48hH-1paUAygHaLH?pid=ImgDet&rs=1',
            //         },
            //         right: {
            //             name: '蒸包',
            //             url: 'https://img.zcool.cn/community/01a1e759be4dbda8012075340dcb6f.jpg@1280w_1l_2o_100sh.jpg'
            //         }
            //     }, {
            //         left: {
            //             name: '无骨凤爪',
            //             url: 'https://th.bing.com/th/id/OIP.QlzawUNOCC48hH-1paUAygHaLH?pid=ImgDet&rs=1',
            //         },
            //         right: {
            //             name: '蒸包',
            //             url: 'https://img.zcool.cn/community/01a1e759be4dbda8012075340dcb6f.jpg@1280w_1l_2o_100sh.jpg'
            //         }
            //     }
            // ]
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