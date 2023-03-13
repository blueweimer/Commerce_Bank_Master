import { useAuthStore } from '@/stores/auth';
import DashboardView from '@/views/DashboardView.vue';
import LoginView from '@/views/LoginView.vue';
import AccountView from '@/views/AccountView.vue';
import LoanCalculatorView from '@/views/LoanCalculatorView.vue';
import { createRouter, createWebHistory } from 'vue-router'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'Dashboard',
      component: DashboardView
    },
    {
      path: '/login',
      name: 'Login',
      component: LoginView
    },
    {
      path: '/account',
      name: 'Account',
      component: AccountView
    },
    {
      path: '/loanCalculator',
      name: 'LoanCalculator',
      component: LoanCalculatorView
    }
  ]
})


router.beforeEach(async (to) => {
  const publicPages = ['/login']
  const authRequired = !publicPages.includes(to.path);
  const auth = useAuthStore();


  if(authRequired && !auth.user){

    //if auth is required and entered user is not an existent user, return login
    return '/login';

  }
})

export default router
