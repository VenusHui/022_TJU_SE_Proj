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
      <nut-list :listData="indexitems" height="150" container-height="530" @scroll-bottom="handleScroll">
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
          url: 'http://rntej2yad.hd-bkt.clouddn.com/assets/dish05.jpg'
        },
        right: {
          name: '高分菜品',
          url: 'http://rntej2yad.hd-bkt.clouddn.com/assets/dish03.jpg'
        }
      },
      {
        left: {
          name: '大食堂一楼',
          url: 'http://rntej2yad.hd-bkt.clouddn.com/assets/dish12.jpg'
        },
        right: {
          name: '大食堂二楼',
          url: 'http://rntej2yad.hd-bkt.clouddn.com/assets/dish07.jpg'
        }
      },
      {
        left: {
          name: '小食堂一楼',
          url: 'http://rntej2yad.hd-bkt.clouddn.com/assets/dish09.jpg'
        },
        right: {
          name: '小食堂二楼',
          url: 'http://rntej2yad.hd-bkt.clouddn.com/assets/dish02.jpg'
        }
      },
      {
        left: {
          name: '教师食堂',
          url: 'http://rntej2yad.hd-bkt.clouddn.com/assets/dish08.jpg'
        },
        right: {
          name: '清真食堂',
          url: 'http://rntej2yad.hd-bkt.clouddn.com/assets/dish10.jpg'
        }
      },
      ]
    });
    const handleScroll = () => {
      let arr = new Array(
        {
          left: {
            name: '西点部',
            url: 'http://rntej2yad.hd-bkt.clouddn.com/assets/dish16.jpg'
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