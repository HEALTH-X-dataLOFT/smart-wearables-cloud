<template>
  <p class="m-auto mb-5 text-balance text-center">
    Verknüpfen Sie hier Ihren Wearable-Anbieter, um Daten von diesem zu importieren und im Health-X-Datenraum freigeben
    zu können.
  </p>
  <p><span class="font-bold p-2">Aktive Verbindungen</span></p>
  <div class="flex flex-col justify-center">
    <DataView :value="connectionInfos" dataKey="vendor">
      <template #list="slotProps">
        <div class="flex flex-col">
          <div v-for="(item, index) in slotProps.items" :key="index">
            <div
              class="flex flex-col sm:flex-row sm:items-center p-4 gap-4"
              :class="{ 'border-t border-surface-200 dark:border-surface-700': index !== 0 }"
            >
              <div class="flex flex-col md:flex-row flex-1 gap-6">
                <div class="text-lg font-medium flex flex-row gap-2 justify-center items-center">
                  <i class="pi pi-circle-fill text-green-500" style="font-size: 0.7rem"></i>
                  {{ item.vendor }}
                  <span class="font-medium text-surface-500 dark:text-surface-400 text-sm">{{
                    formatTimestamp(item.connectedAt)
                  }}</span>
                </div>
                <div class="flex flex-col flex-grow md:items-end">
                  <Button label="Trennen" icon="pi pi-link" severity="danger" size="small" class="min-w-70" />
                </div>
              </div>
            </div>
          </div>
        </div>
      </template>
    </DataView>
    <Button
      class="min-w-70 m-auto"
      icon="pi pi-external-link"
      label="Verknüpfungen verwalten"
      severity="info"
      @click="onThryveBtnClick"
    />
  </div>
</template>

<script setup lang="ts">
import { addHint } from '@/composables/hint'
import { onMounted, ref } from 'vue'
import moment from 'moment'

const DATASOURCE_CREATION_URL = '/data/api/thryve/dataSourceUrl'
const CONNECTION_INFOS_URL = '/data/api/thryve/connectionStates'

const connectionInfos = ref([] as ConnectionInfo[])

onMounted(async () => {
  connectionInfos.value = await getConnectionInfos()
})

const formatTimestamp = (timestamp: Date) => moment(timestamp).format('DD.MM.YY HH:mm')

const onThryveBtnClick = async () => {
  const url = await obtainThryveDatasourceUrl()
  window.open(url, '_blank')
}

const obtainThryveDatasourceUrl = async () => {
  return fetch(DATASOURCE_CREATION_URL, { method: 'GET' }).then((response: Response) => {
    if (response.status !== 200) {
      console.warn('Error while obtaining data source URL: ' + response.body)
      addHint('Fehler', `Die Verbindungs-URL konnte nicht abgerufen werden ${response.body}`, 'error')
      throw new Error('Die Verbindungs-URL konnte nicht abgerufen werden')
    } else {
      addHint('Verbindungs-URL erfolgreich abgerufen', '', 'success')
      return response.text()
    }
  })
}

const getConnectionInfos = async () => {
  return fetch(CONNECTION_INFOS_URL, { method: 'GET' }).then((response: Response) => {
    if (response.status !== 200) {
      console.warn('Error while obtaining connection infos: ' + response.body)
      addHint('Fehler', `Die Verbindungs-Infos konnte nicht abgerufen werden ${response.body}`, 'error')
      throw new Error('Die Verbindungs-Infos konnte nicht abgerufen werden')
    } else {
      addHint('Verbindungs-Infos erfolgreich abgerufen', '', 'success')
      return response.json() as Promise<ConnectionInfo[]>
    }
  })
}
</script>

<style scoped></style>
