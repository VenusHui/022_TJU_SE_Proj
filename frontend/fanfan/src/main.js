import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import './all.css'


// 导入nutui组件
import NutUI from "@nutui/nutui";
//nutui全局css样式
import "@nutui/nutui/dist/style.css";

createApp(App).use(router).use(NutUI).mount("#app");

