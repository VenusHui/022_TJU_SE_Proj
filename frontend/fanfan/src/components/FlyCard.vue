<template>
  <div style="position: relative; height: 100%; width: 100%; padding-left: 0px">
    <div
      style="position: absolute; left: 50%; top: 50%; transform: translate(-50%, -50%); width:100%;height:100%;"
    >
      <div
        class="card"
        style="z-index: 13;width:100%;height:100%;"
        :style="{
          left: left + 'px',
          top: top + 'px',
          'border-radius': borderRadius + 'px',
          backgroundColor: cardBgColor,
        }"
        :class="{
          animation: isAnimating,
          shadowEffect: hasShadow,
          boderEffect: hasBorder,
        }"
        @touchstart="touchStart"
        @touchmove="touchMove"
        @touchcancel="touchCancel"
        @touchend="touchCancel"
      >
        <slot name="firstCard"></slot>
      </div>
      <div
        class="card"
        style="z-index: 12;height:100%;width:100%;"
        :style="{
          width: width2 + 'px',
          left: left2 + 'px',
          top: top2 + 'px',
          'border-radius': borderRadius + 'px',
          backgroundColor: cardBgColor,
        }"
        :class="{
          animation: isAnimating,
          shadowEffect: hasShadow,
          boderEffect: hasBorder,
        }"
      >
        <slot name="secondCard"></slot>
      </div>
      <div
        class="card"
        style="z-index: 11;width:100%;height:100%;"
        :style="{
          width: width3 + 'px',
          left: left3 + 'px',
          top: top3 + 'px',
          'border-radius': borderRadius + 'px',
          backgroundColor: cardBgColor,
        }"
        :class="{
          animation: isAnimating,
          shadowEffect: hasShadow,
          boderEffect: hasBorder,
        }"
      >
        <slot name="thirdCard"></slot>
      </div>
      <div
        class="card"
        style="z-index: 10"
        :style="{
          left: left4 + 'px',
          top: top4 + 'px',
          'border-radius': borderRadius + 'px',
          backgroundColor: cardBgColor,
          opacity: opacity4,
        }"
        :class="{
          animation: isAnimating,
          shadowEffect: hasShadow,
          boderEffect: hasBorder,
        }"
      ></div>
    </div>
  </div>
</template>

<script>
import useTouch from "../use/touch";

export default {
  props: {
    // ??????????????????
    cardWidth: {
      type: Number,
      default: 260,
    },
    // ??????????????????
    cardHeight: {
      type: Number,
      default: 300,
    },
    // ???????????????????????????
    leftPad: {
      type: Number,
      default: 10,
    },
    // ???????????????????????????
    topPad: {
      type: Number,
      default: 6,
    },
    // ???????????????
    cardBgColor: {
      type: String,
      default: "#fff",
    },
    // ??????????????????
    dragDirection: {
      type: String,
      default: "all", //all,vertical,horizontal
    },
    // ?????????????????????
    borderRadius: {
      type: Number,
      default: 10,
    },
    // ?????????????????????????????????
    throwTriggerDistance: {
      type: Number,
      default: 100,
    },
    // ?????????????????????
    throwDistance: {
      type: Number,
      default: 1000,
    },
    // ??????????????????????????????
    hasBorder: {
      type: Boolean,
      default: false,
    },
    // ????????????????????????
    hasShadow: {
      type: Boolean,
      default: true,
    },
  },
  emits: [
    "onDragStart",
    "onDragMove",
    "onDragStop",
    "onThrowFail",
    "onThrowStart",
    "onThrowDone",
  ],
  setup(props, { emit }) {
    const touchState = useTouch(props, {
      onDragStart: () => emit("onDragStart"),
      onDragMove: (obj) => emit("onDragMove", obj),
      onDragStop: (obj) => emit("onDragStop", obj),
      onThrowFail: () => emit("onThrowFail"),
      onThrowStart: () => emit("onThrowStart"),
      onThrowDone: () => emit("onThrowDone"),
    });
    return { ...touchState };
  },
};
</script>

<style>
.card {
  position: absolute;
  overflow: hidden;
}
.card.boderEffect {
  border: 1px solid #ccc;
}
.card.shadowEffect {
  box-shadow: 0px 4px 20px rgba(0, 0, 0, 0.3);
}
.card.animation {
  transition: opacity 0.4s ease-out, left 0.4s ease-out, top 0.4s ease-out,
    width 0.4s ease-out, height 0.4s ease-out;
}
</style>
