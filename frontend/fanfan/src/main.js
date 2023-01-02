import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import './all.css'
import axios from 'axios'
axios.defaults.baseURL = '/api'
// 导入nutui组件
import NutUI from "@nutui/nutui";
//nutui全局css样式
import "@nutui/nutui/dist/style.css";

// 单独引入vant中的组件
import { Notify,Popup } from 'vant';
import { Tabbar, TabbarItem } from 'vant';
import 'vant/lib/index.css';

import $ from 'jquery';

const app = createApp(App);

app.use(router).use(NutUI)

// vant组件
app.use(Notify);
app.use(Tabbar);
app.use(TabbarItem);

app.use($);

app.mount("#app");

app.use(Popup);

App.config.globalProperties.$axios = axios;  //配置axios的全局引用


