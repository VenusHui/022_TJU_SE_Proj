import { createRouter, createWebHashHistory } from 'vue-router'

//lazy-load routes
const routes = [
  {
    path: '/',
    redirect: '/show'
  },
  {
    path: '/login',
    component: () => import('./views/Login.vue')
  },
  {
    path: '/show',
    component: () => import('./views/ShowView.vue')
  },
  {
    path: '/tabbarViews',
    component: () => import('./views/Tabbar.vue'),
    redirect:'/main',
    children: [
      { path: '/main', component: () => import('./views/MainView.vue') },//原有主页
      { path: '/more', component: () => import('./views/IndexView.vue') },
      { path: '/liked', component: () => import('./views/LikedView.vue') },
      { path: '/home',component: () => import('./views/HomeView.vue')}//新飞牌主页
    ],
  },
  {
    path: '/fanfan',
    component: () => import('./views/FanFanView.vue'),
  },
  {
    path: '/info',
    component: () => import('./views/InfoView.vue'),
  },
  {
    path: '/revisePassword',
    component: () => import('./views/PasswordView.vue'),
  },
  {
    path: '/reviseInfo',
    component: () => import('./views/InfoRevisionView.vue'),
  },
  {
    path: '/menu',
    component: () => import('./views/MenuView.vue')
  },
  {
    path: '/detail',
    component: () => import('./views/DetailView.vue')
  },
  {
    path: '/demo',
    component: () => import('./views/AboutView.vue')
  }
]

const router = createRouter({
  mode:'hash',
  history: createWebHashHistory(),
  routes
})

export default router
