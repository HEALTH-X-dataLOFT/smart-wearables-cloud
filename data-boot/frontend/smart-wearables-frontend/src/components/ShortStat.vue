<template>
  <Card class="flex-1 border border-surface shadow-none">
    <template #content>
      <div v-if="loading" class="flex justify-center w-full">
        <ProgressSpinner
          style="width: 50px; height: 50px"
          strokeWidth="8"
          fill="transparent"
          animationDuration=".5s"
          aria-label="Custom ProgressSpinner"
        />
      </div>
      <div v-else class="flex justify-between gap-8">
        <div class="flex flex-col gap-1">
          <span class="text-surface-500 dark:text-surface-400 text-sm">{{ props.label }}</span>
          <span class="font-bold text-lg">{{ displayValue }}</span>
        </div>
        <span
          class="w-8 h-8 rounded-full inline-flex justify-center items-center text-center"
          :style="{ backgroundColor: `${props.color}`, color: '#ffffff' }"
        >
          <i :class="props.icon" />
        </span>
      </div>
    </template>
  </Card>
</template>

<script setup lang="ts">
import { computed, defineProps } from 'vue'

const props = defineProps<{
  label: string
  color: string
  value: number
  icon: string
  loading: boolean
}>()

let displayValue = computed(() => {
  return isFinite(props.value) ? props.value : '-'
})
</script>
