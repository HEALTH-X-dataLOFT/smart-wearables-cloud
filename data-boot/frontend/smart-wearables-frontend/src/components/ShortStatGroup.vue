<template>
  <div class="flex flex-row flex-wrap gap-5">
    <div v-for="stat of stats" class="flex-grow space-y-5 space-x-5 w-2/3 md:w-1/4 min-w-28">
      <ShortStat :label="stat.label" :color="stat.color" :value="stat.val" :icon="stat.icon" :loading="loading" />
    </div>
  </div>
</template>

<script setup lang="ts">
import ShortStat from '@/components/ShortStat.vue'
import { computed } from 'vue'

const props = defineProps<{
  color: string
  targetField: string
  icon: string
  data: any[]
  loading: boolean
}>()

const documentStyle = getComputedStyle(document.documentElement)

const valueIsPresentVerifier = (field: string) => (activity: any) =>
  !!activity[field] && isFinite(activity[field]) && parseInt(activity[field]) != 0

const computeMin = (field: string) => {
  const mappedValues = props.data.filter(valueIsPresentVerifier(field)).map(activity => parseInt(activity[field]))
  return Math.min(...mappedValues)
}

const computeMax = (field: string) => {
  const mappedValues = props.data.filter(valueIsPresentVerifier(field)).map(activity => parseInt(activity[field]))
  return Math.max(...mappedValues)
}

const computeAverage = (field: string) => {
  const filtered = props.data.filter(valueIsPresentVerifier(field))
  const value = filtered.reduce((acc, activity) => acc + parseInt(activity[field]), 0) / filtered.length
  return Math.round(value * 100) / 100
}

let min = computed(() => computeMin(props.targetField))
let max = computed(() => computeMax(props.targetField))
let average = computed(() => computeAverage(props.targetField))
let color = computed(() => (props.color.startsWith('--p') ? documentStyle.getPropertyValue(props.color) : props.color))

let stats = computed(() => [
  { label: 'Min', color: color.value, val: min.value, icon: props.icon, loading: props.loading },
  { label: 'Avg', color: color.value, val: average.value, icon: props.icon, loading: props.loading },
  { label: 'Max', color: color.value, val: max.value, icon: props.icon, loading: props.loading }
])
</script>
