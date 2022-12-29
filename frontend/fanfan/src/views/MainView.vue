<template>
  <div class="framebox">
    <nut-navbar style="height:80px;line-height: 20px;margin-bottom: 0%;padding-left: 0%;">
      <template #content>
        <div class="logotitle logocolor"><b>Fander</b></div>
      </template>
      <template #left>
        <nut-avatar size="normal"
          icon="https://img12.360buyimg.com/imagetools/jfs/t1/143702/31/16654/116794/5fc6f541Edebf8a57/4138097748889987.png"></nut-avatar>
      </template>
      <template #right>
        <nut-badge :value="8">
          <nut-icon name="notice"></nut-icon>
        </nut-badge>
      </template>
    </nut-navbar>
    <div class="dishsuggest">
      <div class="dishUIbox">
        <div class="dishinfobox">
          <div class="dishinfotextbox">
            <div class="dishname">意面</div>
            <div class="dishsubinfobox">
              <div class="dishplace" style="margin-right:20px">小食堂二楼</div>
              <div class="dishprice">￥20</div>
            </div>
            <div class="dishscorebox">
              <nut-icon name="star" color="yellow"></nut-icon>
              <nut-icon name="star" color="yellow"></nut-icon>
              <nut-icon name="star" color="yellow"></nut-icon>
              <nut-icon name="star" color="yellow"></nut-icon>
              <nut-icon name="star" color="yellow"></nut-icon>
              <div class="dishscore" style="margin-left:10px">4.5</div>
            </div>
          </div>
          <div class="dishdetail" @click="JumpDetail">
            <nut-icon name="right" color="white" size="30px"></nut-icon>
          </div>
        </div>
        <div class="dishchoicebox">
          <nut-icon name="heart" color="white" size="30px"></nut-icon>
          <nut-icon name="heart" color="white"></nut-icon>
          <nut-icon name="heart" color="white"></nut-icon>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    // dish: {
    //   name: '意面'
    // }
  },
  methods: {
    JumpDetail(){
      this.$router.push('/detail')
    }
  }
}
</script>

<style scoped>
.framebox {
  display: flex;
  flex-direction: column;
  height: 100%;
}

.profileicon {
  height: 40px;
  width: 40px;
  border-radius: 50%;
}

.dishsuggest {
  align-self: center;
  height: 100%;
  width: 95%;
  background-image: url("../assets/dish2.jpg");
  background-size:cover;
  background-position: center center;
  display: flex;
  align-items: flex-end;
  margin:5%;
  border-radius: 10px;
}

.dishUIbox {
  height: 40%;
  width: 100%;
  background: linear-gradient(360deg, rgb(0, 0, 0) 0%, rgba(255, 255, 255, 0) 100%);
  display: flex;
  flex-direction: column;
  justify-content: flex-end;
  color: white;
  padding: 10px;
  border-radius: 10px;
}

.dishinfobox {
  display: flex;
  flex-direction: row;
  padding: 15px;
  justify-content: space-between;
}

.dishinfotextbox {
  display: flex;
  flex-direction: column;
}

.dishname {
  font-size: 40px;
  margin-bottom: 10px;
}

.dishsubinfobox {
  display: flex;
  flex-direction: row;
  margin-bottom: 10px;
}

.dishscorebox {
  display: flex;
  flex-direction: row;
}

.dishdetail {
  align-self: center;
}

.dishchoicebox {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 25%;
  width: 100%;
}


</style>