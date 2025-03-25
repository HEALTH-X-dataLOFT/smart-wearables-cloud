<template>
  <div class="flex flex-row flex-wrap">
    <div class="flex-grow px-4 w-full">
      <h1 class="text-2xl mb-5">Meine Daten</h1>
      <div class="flex flex-wrap flex-grow w-full mb-5 m-auto justify-center gap-5">
        <SelectButton
          v-model="displayMode"
          :options="displayModeOptions"
          :allowEmpty="false"
          dataKey="value"
          optionLabel="label"
          optionValue="value"
          class="flex-grow justify-start"
        >
          <template #option="slotProps">
            <i :class="slotProps.option.icon"></i>
          </template>
        </SelectButton>
        <div class="flex flex-col justify-end sm:flex-row gap-3">
          <SelectButton
            v-model="selectedProvider"
            :options="providerOptions"
            :allowEmpty="false"
            optionLabel="label"
            optionValue="value"
          />
          <SelectButton
            v-model="displayPeriodInDays"
            :options="displayPeriodOptions"
            :allowEmpty="false"
            optionLabel="label"
            optionValue="value"
            optionDisabled="disabled"
          />
        </div>
      </div>
    </div>
    <div v-if="displayDashboard" class="flex-grow px-4 md:w-1/3 mb-5 space-y-5">
      <Card>
        <template #content>
          <vital-diagram
            title="Schritte"
            :activities="data"
            :extract-value="extractSteps"
            :extract-label="extractLabel"
            :color="stepsColor"
            :loading="loading"
            :min="displayStartDate.toDate()"
          />
        </template>
      </Card>
      <ShortStatGroup
        :color="stepsColor"
        :data="data"
        :targetField="'steps'"
        :icon="'pi pi-map-marker'"
        :loading="loading"
      />
    </div>
    <div v-if="displayDashboard" class="flex-grow px-4 md:w-1/3 mb-5 space-y-5">
      <Card>
        <template #content>
          <vital-diagram
            title="Herzfrequenz"
            :activities="data"
            :extract-value="extractHeartRate"
            :extract-label="extractLabel"
            :color="heartRateColor"
            :loading="loading"
            :min="displayStartDate.toDate()"
          />
        </template>
      </Card>
      <ShortStatGroup
        :color="heartRateColor"
        :data="data"
        :targetField="'heart_rate'"
        :icon="'pi pi-heart'"
        :loading="loading"
      />
    </div>
    <div v-if="displayDashboard" class="flex-grow px-4 md:w-1/3 mb-5 space-y-5">
      <Card>
        <template #content>
          <vital-diagram
            title="Kalorien"
            :activities="data"
            :extract-value="extractKilocalories"
            :extract-label="extractLabel"
            :color="kilocaloriesColor"
            :loading="loading"
            :min="displayStartDate.toDate()"
          />
        </template>
      </Card>
      <ShortStatGroup
        :color="kilocaloriesColor"
        :data="data"
        :targetField="'kilocalories'"
        :icon="'pi pi-bolt'"
        :loading="loading"
      />
    </div>
    <div v-if="displayTable" class="flex-grow px-4 w-full mb-5">
      <Card>
        <template #content>
          <div v-if="loading" class="flex justify-center">
            <ProgressSpinner
              style="width: 50px; height: 50px"
              strokeWidth="8"
              fill="transparent"
              animationDuration=".5s"
              aria-label="Custom ProgressSpinner"
            />
          </div>
          <div v-else>
            <DataTable :value="data" :loading="loading" paginator :rowsPerPageOptions="[10, 25, 50, 100]" :rows="10">
              <Column
                v-for="field in columns"
                :field="field.key"
                :header="field.label"
                :sort-field="field.sortFn ? field.sortFn : field.key"
                sortable
              />
            </DataTable>
          </div>
        </template>
      </Card>
    </div>
  </div>
</template>

<script setup lang="ts">
import { computed, onMounted, ref, watch } from 'vue'
import VitalDiagram from '@/components/VitalDiagram.vue'
import moment from 'moment'
import type { Activity } from '@/types/activity'
import ShortStatGroup from '@/components/ShortStatGroup.vue'

const stepsColor = '--p-orange-400'
const heartRateColor = '--p-red-400'
const kilocaloriesColor = '--p-cyan-400'

const displayPeriodOptionsByProvider = {
  GARMIN: [
    {
      label: 'Letzte 7 Tage',
      value: 7,
      disabled: false
    },
    {
      label: 'Letzte 14 Tage',
      value: 14,
      disabled: false
    },
    {
      label: 'Letzter Monat',
      value: 30,
      disabled: false
    },
    {
      label: 'Letzte 2 Monate',
      value: 60,
      disabled: false
    }
  ],
  THRYVE: [
    {
      label: 'Letzte 7 Tage',
      value: 7,
      disabled: false
    },
    {
      label: 'Letzte 14 Tage',
      value: 14,
      disabled: false
    },
    {
      label: 'Letzter Monat',
      value: 30,
      disabled: false
    },
    {
      label: 'Letzte 2 Monate',
      value: 60,
      disabled: true
    }
  ]
} as { [key: string]: any[] }

const displayModeTable = 0x1
const displayModeDashboard = 0x2
const displayModeTableAndDashboard = 0x3
const displayModeOptions = [
  {
    icon: 'pi pi-home',
    label: 'Standardansicht',
    value: displayModeTableAndDashboard
  },
  {
    icon: 'pi pi-chart-bar',
    label: 'Dashboardansicht',
    value: displayModeDashboard
  },
  {
    icon: 'pi pi-table',
    label: 'Tabellenansicht',
    value: displayModeTable
  }
]

const columns = [
  { key: 'number', label: '#' },
  { key: 'imported', label: 'Importiert' },
  { key: 'date', label: 'Datum', sortFn: (activity: Activity) => '' + moment(activity.date, 'DD.MM.YYYY').unix() },
  { key: 'start_time', label: 'Beginn' },
  { key: 'end_time', label: 'Ende' },
  { key: 'provider', label: 'Anbieter' },
  { key: 'type', label: 'Typ' },
  { key: 'activity', label: 'Aktivität' },
  { key: 'kilocalories', label: 'Kilokalorien' },
  { key: 'steps', label: 'Schritte' },
  { key: 'heart_rate', label: 'Herzrate' }
]

const providerOptions = [
  {
    label: 'Garmin',
    value: 'GARMIN'
  },
  {
    label: 'Thryve',
    value: 'THRYVE'
  }
]

const dayUnitThreshold = 30

const activities = ref([] as string[][])
const loading = ref(false)
const displayMode = ref(displayModeTableAndDashboard)
const displayPeriodInDays = ref(7)
const selectedProvider = ref('GARMIN')

onMounted(() => {
  console.log('MOUNTED')
  fetchData()
})

let fetchData = async () => {
  loading.value = true
  fetch(
    `/data/api/user-data/summary?from=${displayStartDate.value.toISOString()}&provider=${selectedProvider.value}&resolution=${roundUnit.value}`
  )
    .then(response => response.json())
    .then(data => (activities.value = data as unknown as []))
    .finally(() => (loading.value = false))
}

watch(displayPeriodInDays, async () => await fetchData())
watch(selectedProvider, async () => await fetchData())

const displayTable = computed(() => (displayModeTable & displayMode.value) == displayModeTable)
const displayDashboard = computed(() => (displayModeDashboard & displayMode.value) == displayModeDashboard)
const displayStartDate = computed(() => moment(new Date()).subtract(displayPeriodInDays.value, 'days'))
const displayPeriodOptions = computed(() => displayPeriodOptionsByProvider[selectedProvider.value])
const numberOfDisplayedDays = computed(() => moment().diff(displayStartDate.value.toDate(), 'day'))
const roundUnit = computed(() => (numberOfDisplayedDays.value >= dayUnitThreshold ? 'DAYS' : 'HOURS'))

const extractHeartRate = (activity: Activity) => activity.heart_rate
const extractSteps = (activity: Activity) => activity.steps
const extractKilocalories = (activity: Activity) => activity.kilocalories
const extractLabel = (activity: Activity) => moment(activity.start_timestamp)

const data = computed(() => {
  const parsedActivities = activities.value?.map(mapActivityToDateEntry)
  parsedActivities.forEach((activity: Activity) => {
    activity.start_timestamp = parseStartTimestamp(activity)
  })
  console.log(parsedActivities)
  return parsedActivities
})

const mapActivityToDateEntry = (activity: string[]) => {
  const record = {} as any
  for (let index in activity) {
    const key = columns[index].key as string
    record[key] = activity[index] as unknown as string
  }
  return record
}

const parseStartTimestamp = (activity: Activity) => {
  let datetimeString = `${activity.date} ${activity.start_time}`
  return moment(datetimeString, 'DD-MM-YYYY HH:mm:ss').toDate()
}
</script>

<style scoped>
h1 {
  margin-top: 1rem;
}
</style>
