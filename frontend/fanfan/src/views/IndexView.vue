<template>
  <div class="framebox">
    <div class="topbox">
      <div class="logotitle logocolor" style="margin-left: 10px;margin-right: 20px;">
        <b>Menu</b>
      </div>
      <nut-button class="searchbutton" size="normal" icon="search" plain type="default"
        @click="JumpSearch">search</nut-button>
    </div>

    <div class="bodybox">
      <nut-row class="row" type="flex" justify="center" gutter="10">
        <nut-col :span="11">
          <IndexBlock msg="热门推荐" imgUrl="{{ imageurl }}" @click="JumpMenu"></IndexBlock>
        </nut-col>
        <!-- <nut-col :span="1"></nut-col> -->
        <nut-col :span="11">
          <IndexBlock msg="高分菜品"></IndexBlock>
        </nut-col>
      </nut-row>
      <nut-row class="row" type="flex" justify="center" gutter="10">
        <nut-col :span="11">
          <IndexBlock msg="大食堂"></IndexBlock>
        </nut-col>
        <nut-col :span="11">
          <IndexBlock msg="小食堂"></IndexBlock>
        </nut-col>
      </nut-row>
      <nut-row class="row" type="flex" justify="center" gutter="10">
        <nut-col :span="11">
          <IndexBlock msg="教室食堂"></IndexBlock>
        </nut-col>
        <nut-col :span="11">
          <IndexBlock msg="清真食堂"></IndexBlock>
        </nut-col>
      </nut-row>
    </div>
  </div>
</template>

<script>
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
}
</script>

<style>
.framebox {
  height: 100%;
  width: 100%;
  /* padding: 10px; */
}

.topbox {
  margin: 10px;
  display: flex;
  /* justify-content: space-around; */
  align-items: center;
}

.row {
  margin-bottom: 20px;
}
</style>