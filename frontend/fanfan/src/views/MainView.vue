<template>
  <div class="framebox">
    <nut-navbar style="height:80px">
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
      <div class="maskbox">
        <div class="buttonbox">
          <nut-icon name="heart" color="white"></nut-icon>
          <nut-icon name="heart" color="white"></nut-icon>
          <nut-icon name="heart" color="white"></nut-icon>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
</script>

<style scoped>
.framebox {
  display: flex;
  flex-direction: column;
}

.profileicon {
  height: 40px;
  width: 40px;
  border-radius: 50%;
}

.dishsuggest {
  align-self: center;
  height: 75%;
  width: 95%;
  background-image: url("../assets/dish2.jpg");
  background-size: auto 100%;
  background-position: center center;
  display: flex;
  align-items: flex-end;
}

.maskbox {
  height: 30%;
  width: 100%;
  background: linear-gradient(360deg, rgba(36, 31, 0, 1) 0%, rgba(255, 255, 255, 0) 100%);
  display: flex;
  align-items: flex-end;
  /* justify-content: center; */
}

.buttonbox{

}
</style>