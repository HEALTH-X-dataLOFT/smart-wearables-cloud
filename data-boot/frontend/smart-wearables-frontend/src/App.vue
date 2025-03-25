<script setup lang="ts">
import { RouterLink, RouterView } from 'vue-router'
import HelloWorld from './components/HelloWorld.vue'
import SwcMenu from '@/components/SwcMenu.vue'
</script>

<template>
  <SwcMenu />
  <RouterView />
  <ConfirmDialog></ConfirmDialog>
  <Toast position="bottom-right" />
</template>

<style scoped>
h1 {
  margin: 0 1rem 1rem 1rem;
}
</style>
