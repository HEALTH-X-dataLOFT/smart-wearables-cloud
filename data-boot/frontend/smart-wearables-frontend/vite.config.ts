import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import vueDevTools from 'vite-plugin-vue-devtools'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    vue(),
    vueDevTools(),
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  },
  base: '/data/',
  server: {
    proxy: {
      // '/data' : {
      //   target: 'http://localhost:7272/data'
      // },
      '/data/api': {
        target: 'http://localhost:7272',
        // changeOrigin: true,
        // autoRewrite: true,
      },
      '/data/external-vendors': {
        target: 'http://localhost:7272',
        // changeOrigin: true,
        // autoRewrite: true,
      },
      '/data/logout': {
        target: 'http://localhost:7272/data/logout',
        followRedirects: true,
        changeOrigin: true,
        autoRewrite: true
      }
    }
  }
})
