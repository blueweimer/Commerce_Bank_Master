<script lang="ts" setup>
import { useAuthStore } from "@/stores/auth";
import {onMounted, ref} from 'vue';


    const auth = useAuthStore();
    const token = auth.token;
    const data = ref('');


//Adding token to header
    onMounted(async() => {
        const response = await fetch('http://localhost:8080/loanCalculator', {
            headers: {
                Authorization: `Bearer ${token}`,

            }
        });
        data.value = await response.text();
    })

</script>

<template>
  <h1>Loan Calculator</h1>
  <p>{{ data }}</p>
</template>