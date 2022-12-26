import { createRouter, createWebHashHistory } from 'vue-router'

//lazy-load routes
const routes = [
  {
    path: '/',
    redirect: '/show'
  },
  {
    path: '/home',
    component: () => import('./views/HomeView.vue')
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
      { path: '/main', component: () => import('./views/MainView.vue') },
      { path: '/more', component: () => import('./views/IndexView.vue') },
      { path: '/liked', component: () => import('./views/LikedView.vue') }
    ],
  },
  {
    path: '/menu',
    component: () => import('./views/MenuView.vue')
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
