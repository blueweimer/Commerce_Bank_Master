import router from '@/router';
import {defineStore} from 'pinia';


export const useAuthStore = defineStore({
    id: 'auth',
    state: () => {
        return {
            user: localStorage.getItem('user') ? JSON.parse(localStorage.getItem('user')!): null,
            token: localStorage.getItem('token') ? JSON.parse(localStorage.getItem('token')!): null,
            returnUrl: '/'
        }
    },
    actions: {
        //LOGIN FUNCTION
        async login(username: string, password: string){
            const response = await fetch('http://localhost:8080/token', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({username, password})
            });

            if(response.status == 200){
                const token = await response.text();
                localStorage.setItem('token', JSON.stringify(token));
                localStorage.setItem('user', JSON.stringify(username));
                this.user = username;
                this.token = token;
                router.push(this.returnUrl || '/')

            } else {
                throw new Error("Invalid Credentials!");
            }
        },

        //LOGOUT FUNCTION
        logout(){
            this.user = null;
            this.token = '';
            localStorage.removeItem('user');
            localStorage.removeItem('token');
            router.push('/login');
        }
    }
});