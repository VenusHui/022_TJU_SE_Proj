import { createRouter, createWebHashHistory } from 'vue-router'
import HomeView from './views/HomeView.vue'
import ShowView from './views/ShowView.vue'

const routes = [
  {
    path: '/',
    redirect: '/show'
  },
  {
    path: '/home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ './views/AboutView.vue')
  },
  {
    path: '/show',
    component: ShowView
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
