<template>
  <div class="framebox">
    <nut-navbar style="height:80px;line-height: 20px;margin-bottom: 0%;padding-left: 0%;">
      <template #content>
        <div class="logotitle logocolor"><b>Fander</b></div>
      </template>
      <template #left>
        
        <nut-avatar @click="JumpInfo" size="normal" :icon = avatar ></nut-avatar>
      </template>
      <template #right>
        <div @click="JumpFanFan()">
          <nut-badge :value="8">
            <nut-icon name="notice"></nut-icon>
          </nut-badge>
        </div>
      </template>
    </nut-navbar>

    <div id="cardBox" style="height:100%;padding:5%;padding-bottom: 13%;">
      <!-- 遮罩层显示操作或动画 -->
      <div v-if="actionName == '不喜欢'" class="choice">
        <div class="choiceicon">
          <nut-icon name="close" color="white" size="40px" style="left: 20%;"></nut-icon>
        </div>
      </div>

      <div v-if="actionName == '喜欢'" class="choice">
        <div class="choiceicon">
          <nut-icon name="follow" color="white" size="40px" style="left: 20%;"></nut-icon>
        </div>
      </div>

      <div v-if="actionName == '饭饭'" class="choice">
        <div class="fandericon">
          <img src="../assets/fander-icon-white.png" height="80" width="80" style="padding-left: 10px;padding-bottom: 10px;">
        </div>
      </div>
 
      <fly-card @onDragMove="onCardDragMove" @onDragStop="onCardDragStop" @onThrowDone="onCardThrowDone"
        :cardWidth=this.windowWidth*0.9 :throwTriggerDistance="100" :hasShadow="true">
        <template #firstCard style="width: 100%; height: 100%">
          <div v-if="cards[0]" class="tantanCard" :style='{backgroundImage:"url("+cards[0].photoUrl+")"}'>
            <div class="dishUIbox">
              <div class="dishinfobox">
                <div class="dishinfotextbox">
                  <div style="font-size: 30px;margin-bottom: 10px;">{{cards[0].dishName}}</div>
                  <div class="dishsubinfobox">
                    <div class="dishplace" style="margin-right:20px">{{cards[0].position}}</div>
                    <div class="dishprice">￥20</div>
                  </div>
                  <div class="dishscorebox">
                    <nut-rate v-model="cards[0].star" active-color="#FFC800" readonly />
                    <div class="dishscore" style="margin-left:10px;padding-top:3px ;">{{cards[0].score}}</div>
                  </div>
                </div>
                <div @click="JumpDetail(cards[0]._id)" style="align-self: center;">
                  <nut-icon name="right" color="white" size="30px"></nut-icon>
                </div>
              </div>
            </div>
          </div>
        </template>
        <template #secondCard style="width: 100%; height: 100%">
          <div v-if="cards[1]" class="tantanCard" :style='{backgroundImage:"url("+cards[1].photoUrl+")"}'>      
            <div class="dishUIbox">
              <div class="dishinfobox">
                <div class="dishinfotextbox">
                  <div style="font-size: 30px;margin-bottom: 10px;">{{cards[1].dishName}}</div>
                  <div class="dishsubinfobox">
                    <div class="dishplace" style="margin-right:20px">{{cards[1].position}}</div>
                    <div class="dishprice">￥20</div>
                  </div>
                  <div class="dishscorebox">
                    <nut-rate v-model="cards[1].star" active-color="#FFC800" readonly />
                    <div class="dishscore" style="margin-left:10px">{{cards[1].score}}</div>
                  </div>
                </div>
                <div @click="JumpDetail" style="align-self: center;">
                  <nut-icon name="right" color="white" size="30px"></nut-icon>
                </div>
              </div>   
            </div>
          </div>
        </template>
        <template #thirdCard style="width: 100%; height: 100%">
          <div v-if="cards[2]" class="tantanCard" :style='{backgroundImage:"url("+cards[2].photoUrl+")"}'>

            <div class="dishUIbox">
              <div class="dishinfobox">
              </div>
              <div class="dishchoicebox">
                <nut-icon name="heart" color="red" size="30px" style="margin:10px"></nut-icon>
              </div>
            </div>

          </div>
        </template>
      </fly-card>
      </div>

  </div>
</template>

<script>
import FlyCard from "../components/FlyCard.vue";
import { ref } from 'vue';
import axios from 'axios';
export default {
  components: {
    FlyCard,
  },
  data() {
    return {
      actionName: "",
      cards: [],
      windowWidth: document.documentElement.clientWidth,  //实时屏幕宽度
      windowHeight: document.documentElement.clientHeight,   //实时屏幕高度
      avatar:'',
      times:9,
    };
  },
  methods: {
    JumpDetail(dishId) {
      // console.log('dishId: '+dishId);
      this.$router.push({ path: "/detail", query: { dishId: dishId } });
    },
    JumpInfo() {
      this.$router.push('/info')
    },
    JumpFanFan() {
      this.$router.push('/fanfan')
    },
    onCardDragMove(obj) {
      if(obj.top > 20 && obj.top>Math.abs(obj.left) || obj.top < -20 && obj.top<-Math.abs(obj.left)){
        this.actionName = "饭饭";
      }
      else if (obj.left < -20 && obj.top>obj.left && obj.top<-obj.left) {
        this.actionName = "不喜欢";
      } else if (obj.left > 20 && obj.top<obj.left && obj.top>-obj.left) {
        this.actionName = "喜欢";
      } 
    },
    onCardDragStop(obj) {
      this.actionName = "";
    },
    onCardThrowDone(obj) {
      this.cards.splice(0, 1);
      console
      if(this.times>0)
      {
        this.times = this.times - 1;
      }
      else{
        this.times = 9;
        console.log('10次');
      }
    },
  },
  setup() {
    const value = ref(4.8);
    return { value }
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

    axios({
      method: 'get',
      headers: { 'Authorization': 'Bearer '+ localStorage.token },
      url: `http://124.220.158.211:7000/users/${localStorage.userId}/`,
    }).then((res) => {
      // console.log('user info:',  res.data.data.user.avatar)
      this.$data.avatar = res.data.data.user.avatar;
    }, error => {
      console.log('错误', error.message)
    })

    // get all dishes 
    axios({
      method: 'get',
      headers: { 'Authorization': 'Bearer '+ localStorage.token },
      url: 'http://124.220.158.211:7000/dishes/',
    }).then((res) => {
      console.log('dish info:',  res.data.data.dishes)
      this.$data.cards = res.data.data.dishes;
    }, error => {
      console.log('错误', error.message)
    })
  },
  setup() {
    const value = ref(4.8);
    return { value }
  }
}
</script>

<style scoped>
.choice {
  color: #fff;
  position: absolute;
  z-index: 999;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
}

.choiceicon {
  width: 70px;
  height: 70px;
  background-color: #e23c13;
  border-radius: 50%;
  position: absolute;
  font-size: 36px;
  color: #fff;
  transform: translate(-50%, -50%);
  align-items: center;
  display: flex;
}

.fandericon {
  width: 100px;
  height: 100px;
  background-color: #e23c13;
  border-radius: 50%;
  position: absolute;
  font-size: 36px;
  color: #fff;
  transform: translate(-50%, -50%);
  align-items: center;
  display: flex;
}

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


.dishUIbox {
  height: 50%;
  width: 100%;
  background: linear-gradient(360deg, rgb(0, 0, 0) 0%, rgba(255, 255, 255, 0) 100%);
  display: flex;
  flex-direction: column;
  justify-content: flex-end;
  color: white;
  padding: 12px;
  border-radius: 10px;
}

.dishinfobox {
  display: flex;
  flex-direction: row;
  padding: 15px;
  justify-content: space-between;
  padding-bottom: 5%;
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
  height: 35%;
  width: 100%;
}


div {
  box-sizing: border-box;
}

.tantanCard {
  width: 100%;
  height: 100%;
  background-size: cover;
  background: no-repeat center;
  background-size:cover;
  display: flex;
  align-items: flex-end;
	overflow: hidden;
	box-shadow: 0px 5px 43px rgba( 0, 0, 0, 0.48 );
	padding: 0;
	position: absolute;
	left: 50%;
	top: 50%;
	transform: translate(-50%,-50%);
}

::v-deep .nut-icon__img{
  object-fit: cover;
}
</style>

