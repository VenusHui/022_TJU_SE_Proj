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
    <!-- <div class="dishsuggest">
      <div class="dishUIbox">
        <div class="dishinfobox">
          <div class="dishinfotextbox">
            <div style="font-size: 40px;margin-bottom: 10px;">意面</div>
            <div class="dishsubinfobox">
              <div class="dishplace" style="margin-right:20px">小食堂二楼</div>
              <div class="dishprice">￥20</div>
            </div>
            <div class="dishscorebox">
              <nut-rate v-model="value" readonly />
              <div class="dishscore" style="margin-left:10px">4.5</div>
            </div>
          </div>
          <div @click="JumpDetail" style="align-self: center;">
            <nut-icon name="right" color="white" size="30px"></nut-icon>
          </div>
        </div>
        <div class="dishchoicebox">
          <nut-icon name="close-little" color="gray" size="28px" style="margin:10px"></nut-icon>
          <nut-icon name="star" color="yellow" size="30px" style="margin:10px"></nut-icon>
          <nut-icon name="heart" color="red" size="30px" style="margin:10px"></nut-icon>
        </div>
      </div>
    </div> -->


    <div id="cardBox" style="height:100%;padding:5%;padding-bottom: 13%;">
      <!-- 遮罩层显示操作或动画 -->
      <!-- <div v-if="actionName != ''" style="
            color: #fff;
            background: rgba(0, 0, 0, 0.3);
            padding: 10px 20px;
            font-size: 24px;
            position: absolute;
            z-index: 999;
            left: 50%;
            top: 50%;
            transform: translate(-50%, -50%);
          ">
        {{ actionName }}
      </div> -->
      <fly-card @onDragMove="onCardDragMove" @onDragStop="onCardDragStop" @onThrowDone="onCardThrowDone"
        :cardWidth= this.windowWidth*0.9 :throwTriggerDistance="100" dragDirection="horizontal" :hasShadow="true">
        <template #firstCard style="width: 100%; height: 100%">
          <div v-if="cards[0]" class="tantanCard">
            <img :src="cards[0].img" style="width: 100%; height: 100%; object-fit:cover;" />
          </div>
        </template>
        <template #secondCard style="width: 100%; height: 100%">
          <div v-if="cards[1]" class="tantanCard">
            <img :src="cards[1].img" style="width: 100%; height: 100%; object-fit:cover;" />
          </div>
        </template>
        <template #thirdCard style="width: 100%; height: 100%">
          <div v-if="cards[2]" class="tantanCard">
            <img :src="cards[2].img" style="width: 100%; height: 100%; object-fit:cover;" />
          </div>
        </template>
      </fly-card>
    </div>



  </div>
</template>

<script>
import FlyCard from "../components/FlyCard.vue";
import dish from "../assets/dish1.jpg";
import dish2 from "../assets/dish2.jpg";
import dish3 from "../assets/dish3.jpg";
import dish4 from "../assets/dish4.jpg";
import dish5 from "../assets/dish5.jpg";
import { ref } from 'vue';
export default {
  components: {
    FlyCard,
  },
  data() {
    return {
      actionName: "",
      cards: [
        {
          img: dish2,
        },
        {
          img: dish,
        },
        {
          img: dish3,
        },
        {
          img: dish4,
        },
        {
          img: dish5,
        },
      ],
      windowWidth: document.documentElement.clientWidth,  //实时屏幕宽度
      windowHeight: document.documentElement.clientHeight,   //实时屏幕高度
    };
  },
  methods: {
    JumpDetail() {
      this.$router.push('/detail')
    },
    onCardDragMove(obj) {
      if (obj.left < -10) {
        this.actionName = "不喜欢";
      } else if (obj.left > 10) {
        this.actionName = "喜欢";
      } else {
        this.actionName = "";
      }
    },
    onCardDragStop(obj) {
      this.actionName = "";
    },
    onCardThrowDone(obj) {
      this.cards.splice(0, 1);
    },
  },

  watch: {
    windowHeight(val) {
      let that = this;
      // console.log("实时屏幕高度：", val, that.windowHeight);
    },
    windowWidth(val) {
      let that = this;
      // console.log("实时屏幕宽度：", val, that.windowHeight);
    }
  },
  mounted() {
    var that = this;
    // <!--把window.onresize事件挂在到mounted函数上-->
    window.onresize = () => {
      return (() => {
        window.fullHeight = document.documentElement.clientHeight;
        window.fullWidth = document.documentElement.clientWidth;
        that.windowHeight = window.fullHeight;  // 高
        that.windowWidth = window.fullWidth; // 宽
      })()
    };
  },
  setup() {
    const value = ref(4.8);
    return { value }
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
  background-size: cover;
  background-position: center center;
  display: flex;
  align-items: flex-end;
  margin: 5%;
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

.dishsubinfobox {
  display: flex;
  flex-direction: row;
  margin-bottom: 10px;
}

.dishscorebox {
  display: flex;
  flex-direction: row;
}

.dishchoicebox {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 25%;
  width: 100%;
}


div {
  box-sizing: border-box;
}

.tantanCard {
  width: 100%;
  height: 100%;
}
</style>