<template>
  <Menubar :model="items">
    <template #item="{ item, props, hasSubmenu }">
      <router-link v-if="item.route" v-slot="{ href, navigate }" :to="item.route" custom>
        <a v-ripple :href="href" v-bind="props.action" @click="navigate">
          <span :class="item.icon" />
          <span class="ml-2">{{ item.label }}</span>
        </a>
      </router-link>
      <a v-else v-ripple :href="item.url" :target="item.target" v-bind="props.action">
        <span :class="item.icon" />
        <span class="ml-2">{{ item.label }}</span>
        <span v-if="hasSubmenu" class="pi pi-fw pi-angle-down ml-2" />
      </a>
    </template>
    <template #end>
      <Image src="/data/swc_logo.png" alt="Image" width="230" />
    </template>
  </Menubar>
</template>

<script setup lang="ts">
import { ref } from 'vue'

const logout = () => {
  window.location.href = '/data/logout'
}

const items = ref([
  {
    label: 'Übersicht',
    icon: 'pi pi-home',
    route: '/'
  },
  {
    label: 'Einstellungen',
    icon: 'pi pi-cog',
    route: '/settings'
  },
  {
    label: 'Mein VC',
    icon: 'pi pi-id-card',
    command: () => window.open('api/verifiable-credential/issue', '_blank')
  },
  {
    label: 'Abmelden',
    icon: 'pi pi-sign-out',
    command: () => logout()
  }
])
</script>

<style scoped>
:deep(a:hover) {
  background: hsla(216, 70%, 58%, 0.01);
}
</style>
