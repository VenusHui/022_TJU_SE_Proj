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
    path:'/register',
    component: () => import('./views/Register.vue')
  },
  {
    path:'/login',
    component: () => import('./views/Login.vue')
  },
  {
    path: '/show',
    component: () => import('./views/ShowView.vue')
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
