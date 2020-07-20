import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from '../views/index'
import App from '../App'
import Main from '../views/Main'
import Register from "../views/Register";


Vue.use(VueRouter)

  const routes = [
    {
      path: '/',
      name: "导航1",
      component: Index,
      redirect:"/main",
      children: [
        {
          path: '/main',
          name: "主页面",
          component: Main,

        },
        {
          path: '/register',
          name: "注册页面",
          component: Register,
        }]
    },
    ]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
