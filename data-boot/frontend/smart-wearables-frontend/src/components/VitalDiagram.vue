<template>
  <div v-if="isLoading" class="flex justify-center">
    <ProgressSpinner
      style="width: 50px; height: 50px"
      strokeWidth="8"
      fill="transparent"
      animationDuration=".5s"
      aria-label="Custom ProgressSpinner"
    />
  </div>
  <div :style="{ display: isLoading ? 'none' : 'block' }">
    <Chart :type="chartType" :data="chartData" :options="chartOptions" :key="renderKey" />
  </div>
</template>

<script setup lang="ts">
import { computed, onMounted, onBeforeUnmount, type PropType, ref } from 'vue'
import type { Activity } from '@/types/activity'
import type { ChartOptions } from 'chart.js'
import 'chartjs-adapter-moment'
import moment from 'moment'

const props = defineProps({
  activities: Object as PropType<Activity[]>,
  min: Date,
  chartType: {
    type: String,
    default: 'bar'
  },
  title: {
    type: String,
    default: ''
  },
  extractValue: {
    type: Function,
    required: true
  },
  extractLabel: {
    type: Function,
    required: true
  },
  labelX: String,
  labelY: String,
  loading: Boolean,
  color: {
    type: String,
    default: '--p-cyan-400'
  }
})

const rendered = ref(false)
const renderKey = ref(0)

onMounted(() => {
  rendered.value = false
  window.addEventListener('resize', resizeHandler)
})

onBeforeUnmount(() => {
  rendered.value = false
  window.removeEventListener('resize', resizeHandler)
})

const chartOptions = computed(() => createChartOptions(props.title))

const isLoading = computed(() => {
  return props.loading || !rendered
})

const onRendered = () => {
  console.log('Rendered')
  rendered.value = true
}

const chartData = computed(() => {
  const documentStyle = getComputedStyle(document.documentElement)

  const sortedActivities = [...props.activities!].sort(compareActivities)
  const labels = sortedActivities?.map(a => props.extractLabel(a))
  const data = sortedActivities?.map(a => props.extractValue(a))
  return {
    labels,
    datasets: [
      {
        label: props.title,
        backgroundColor: documentStyle.getPropertyValue(props.color),
        borderColor: documentStyle.getPropertyValue(props.color),
        data
      }
    ]
  }
})

const createChartOptions = (title: string): ChartOptions => {
  const dayUnitThreshold = 30
  const numberOfDisplayedDays = moment().diff(props.min, 'day')
  const roundUnit = numberOfDisplayedDays >= dayUnitThreshold ? 'day' : 'hour'
  const tooltipFormat = numberOfDisplayedDays >= dayUnitThreshold ? 'DD.MM.YY' : 'DD.MM.YY HH:mm'
  return {
    plugins: {
      title: {
        display: true,
        text: title,
        font: {
          size: 18
        }
      },
      legend: {
        display: false
      }
    },
    scales: {
      x: {
        type: 'time',
        min: props.min!.valueOf(),
        max: new Date().valueOf(),
        grid: {
          tickLength: 5,
          drawOnChartArea: false,
          display: true
        },
        ticks: {
          // stepSize: 1,
          // maxTicksLimit: 7,
          align: 'center'
        },
        time: {
          unit: 'day',
          round: roundUnit,
          minUnit: 'hour',
          displayFormats: {
            day: 'DD.MM.YY'
          },
          tooltipFormat: tooltipFormat
        }
      },
      y: {
        grid: {
          tickLength: 5,
          drawOnChartArea: false,
          display: true
        }
      }
    }
  }
}

const compareActivities = (a: Activity, b: Activity) => {
  const timestampA = a.start_timestamp
  const timestampB = b.start_timestamp
  if (!timestampA && !timestampB) return 0
  if (!timestampA) return -1
  if (!timestampB) return 1
  if (timestampA > timestampB) return 1
  if (timestampB > timestampA) return -1
  return 0
}

const resizeHandler = () => {
  renderKey.value += 1
}
</script>

<style scoped></style>
