<template>
  <div style="height:100%;width: 100%;">
    <div class="indextopbox">
      <div class="logotitle logocolor" style="margin-left: 10px;margin-right: 20px;">
        <b>Index</b>
      </div>
      <nut-button class="searchbutton" size="normal" icon="search" plain type="default"
        @click="JumpSearch">search</nut-button>
    </div>
    <div style="margin-top:10px;">
      <nut-list :listData="indexitems" height="150" container-height="550" @scroll-bottom="handleScroll">
        <template v-slot:default="{ item }">
          <nut-row class="row" type="flex" justify="center" gutter="10">
            <nut-col :span="11">
              <IndexBlock :msg="item.left.name" :imgUrl="item.left.url"></IndexBlock>
            </nut-col>
            <nut-col :span="11">
              <IndexBlock :msg="item.right.name" :imgUrl="item.right.url"></IndexBlock>
            </nut-col>
          </nut-row>
        </template>
      </nut-list>
    </div>
  </div>
</template>

<script>
import { reactive, toRefs } from 'vue';
import IndexBlock from '@/components/IndexBlock.vue'
export default {
  components: {
    IndexBlock
  },
  methods: {
    JumpSearch() {
      this.$router.push('/search')
    },
    JumpMenu() {
      this.$router.push('/menu')
    },
  },
  setup() {
    const state = reactive({
      indexitems: [{
        left: {
          name: '热门推荐',
          url: 'https://img.zcool.cn/community/0189d85c3c421aa80121fbb0284f6c.jpg@1280w_1l_2o_100sh.jpg'
        },
        right: {
          name: '高分菜品',
          url: 'https://img.zcool.cn/community/0170d35cd35630a8012141687a38d1.jpg@1280w_1l_2o_100sh.jpg'
        }
      },
      {
        left: {
          name: '大食堂一楼',
          url: 'https://ts1.cn.mm.bing.net/th/id/R-C.b462c8a15de4a20e4252710b8b6ad0ce?rik=FDMvst0GFl4TxA&riu=http%3a%2f%2fi3.meishichina.com%2fattachment%2frecipe%2f201110%2f201110131446318.jpg&ehk=kc8VjmIcfuDS5chx9lDnMuo9RFL6JC%2f%2bpTG2NeY0gAI%3d&risl=&pid=ImgRaw&r=0'
        },
        right: {
          name: '大食堂二楼',
          url: 'https://img.zcool.cn/community/01da655764ef810000012e7e3dc28e.jpg@1280w_1l_2o_100sh.jpg'
        }
      },
      {
        left: {
          name: '小食堂一楼',
          url: 'https://pic.ntimg.cn/file/20200721/27916432_084518004081_2.jpg'
        },
        right: {
          name: '小食堂二楼',
          url: 'https://img.zcool.cn/community/0131105ff6c22811013fdcc726e15b.jpg@3000w_1l_0o_100sh.jpg'
        }
      },
      {
        left: {
          name: '教师食堂',
          url: 'https://pic.ntimg.cn/file/20141125/19138507_131708744000_2.jpg'
        },
        right: {
          name: '清真食堂',
          url: 'https://tse4-mm.cn.bing.net/th/id/OIP-C.Z00-PiYWai4Eyh874rqrKAHaLH?pid=ImgDet&rs=1'
        }
      },
      ]
    });
    const handleScroll = () => {
      let arr = new Array(
        {
          left: {
            name: '西点部',
            url: 'https://www.usst.edu.cn/_upload/article/images/58/1a/a822de93405db4de5e7f7bfdfd96/ead924f4-39ca-4bab-8289-2e11d19552be_d.jpg'
          },
          right: {
          }
        });
      state.indexitems = state.indexitems.concat(arr);
    };
    return { ...toRefs(state), handleScroll };
  }
}
</script>

<style>
.indextopbox {
  padding: 10px;
  height: 50px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: white;
}

.row {
  margin-bottom: 20px;
}
</style>