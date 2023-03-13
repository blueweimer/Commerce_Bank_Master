<script setup lang="ts">
import { RouterLink, RouterView } from 'vue-router'
import { useAuthStore } from './stores/auth'

const auth = useAuthStore();

function logout(){
  auth.logout();
}

</script>

<template>
  <div>
    <header>
      <nav>
        <RouterLink to="/">Dashboard</RouterLink>
        <RouterLink to="/account">Account</RouterLink>
        <RouterLink to="/loanCalculator">Loan Calculator</RouterLink>
        <a href='#' @click="logout">logout</a>
      </nav>
    </header>

    <main>
      <RouterView />
    </main>
  </div>
</template>
