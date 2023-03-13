<script lang="ts" setup>
import { reactive } from "vue";
import {useAuthStore} from '@/stores/auth';


const user = reactive({
    username: '',
    password: ''
});

function onSubmit(){
    console.log("form submitted.");
    console.log(user);
    if(user.username != '' && user.password != ''){
        useAuthStore().login(user.username, user.password);
    }
}
</script>

<template>
    <form @submit.prevent="onSubmit">
        <div>
            <label for="username">Username</label>
            <input type="text" id="username" placeholder="username" v-model="user.username">
        </div>
        <div>
            <label for="password">Password</label>
            <input type="password" id="password" placeholder="password" v-model="user.password">
        </div>
        <div>
            <button type="submit">Sign In</button>
        </div>
    </form>
</template>