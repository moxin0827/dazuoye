import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import './assets/fonts/font.less'
import './assets/fonts/font.css'; // 引入字体样式文件
createApp(App).use(store).use(router).mount('#app')
