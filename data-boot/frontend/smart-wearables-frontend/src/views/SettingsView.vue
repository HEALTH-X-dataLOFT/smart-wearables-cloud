<template>
  <div class="about">
    <h1 class="text-2xl mb-10">Accountverwaltung</h1>
    <div class="flex flex-row flex-wrap">
      <div class="flex-grow px-4 md:w-1/3 mb-5">
        <Card>
          <template #title>
            <div class="flex items-center pl-2">
              <i class="pi pi-link" />
              <span class="font-bold p-2">Anbieter-Verknüpfungen</span>
            </div>
          </template>
          <template #content>
            <div class="flex flex-col justify-center">
              <p class="m-auto mb-5 text-center text-balance">
                Verknüpfen Sie hier Ihren Wearable-Account, um Daten von ihrem Wearable-Anbieter zu importieren und
                diese im Health-X-Datenraum freigeben zu können.
              </p>
              <Button
                class="min-w-70 m-auto"
                :label="garminBtnLabel"
                :severity="garminBtnSeverity"
                @click="onGarminBtnClick"
              />
            </div>
          </template>
        </Card>
      </div>
      <div class="flex-grow px-4 md:w-1/3 mb-5">
        <Card>
          <template #title>
            <div class="flex items-center pl-2">
              <i class="pi pi-database" />
              <span class="font-bold p-2">Daten</span>
            </div>
          </template>
          <template #content>
            <div class="flex flex-col justify-center">
              <p class="m-auto mb-5 text-center text-balance">
                Sie möchten Ihre Daten nicht länger mit uns teilen? <br />
                Klicken Sie auf den untenstehenden Button, um ihre Aktivitätsdaten aus Ihrem Account zu löschen.
              </p>
              <Button
                class="min-w-70 m-auto"
                label="Aktivitätsdaten löschen"
                severity="danger"
                @click="confirmDataDeletion"
              />
            </div>
          </template>
        </Card>
      </div>
      <div class="flex-grow px-4 md:w-1/3 mb-5">
        <Card>
          <template #title>
            <div class="flex items-center pl-2">
              <i class="pi pi-user" />
              <span class="font-bold p-2">Account</span>
            </div>
          </template>
          <template #content>
            <div class="flex flex-col justify-center">
              <p class="m-auto mb-5 text-center text-balance">
                Hier können Sie Ihren Smart Wearables Account vollständig löschen. Sollten Sie Smart Wearables Cloud
                später doch wieder nutzen zu wollen, müssen Sie sich dafür erneut registrieren.
              </p>
              <Button
                class="min-w-70 m-auto"
                label="Account löschen"
                severity="danger"
                @click="confirmAccountDeletion"
              />
            </div>
          </template>
        </Card>
      </div>
      <div class="px-4 md:w-1/3 mb-5">
        <Card>
          <template #title>
            <div class="flex items-center pl-2">
              <i class="pi pi-mobile" />
              <span class="font-bold p-2">Thryve</span>
            </div>
          </template>
          <template #content>
            <thryve-settings />
          </template>
        </Card>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { computed, onMounted, ref } from 'vue'
import { addHint } from '@/composables/hint'
import { useConfirm } from 'primevue/useconfirm'
import ThryveSettings from '@/views/ThryveSettings.vue'

const confirm = useConfirm()

// Data deletion
const USER_DATA_DELETION_PATH = 'api/user-data/data'

const confirmDataDeletion = () => {
  confirm.require({
    message: 'Durch diesen Schritt werden ihre Aktivitätsdaten gelöscht. Sind Sie sich sicher?',
    header: 'Aktivitätsdaten löschen',
    icon: 'pi pi-info-warn',
    rejectLabel: 'Abbrechen',
    rejectProps: {
      label: 'Abbrechen2',
      severity: 'secondary',
      outlined: true
    },
    acceptProps: {
      label: 'Aktivitätsdaten löschen',
      severity: 'danger'
    },
    accept: () => {
      performDataDeletion()
    },
    reject: () => {}
  })
}

const performDataDeletion = () => {
  fetch(USER_DATA_DELETION_PATH, { method: 'DELETE' }).then(response => {
    if (response.status !== 200) {
      console.warn('Error while deleting user data: ' + response.body)
      addHint('Fehler', `Die Daten konnten nicht gelöscht werden ${response.body}`, 'error')
    } else {
      addHint('Daten erfolgreich entfernt', '', 'success')
    }
  })
}

// Account deletion
const USER_ACCOUNT_DELETION_PATH = 'api/user-data/account'

const confirmAccountDeletion = () => {
  confirm.require({
    message:
      'Durch diesen Schritt wird Ihr Account unklusive aller zugehörigen Daten endgültig gelöscht. Sind Sie sicher, dass Sie fortfahren möchten?',
    header: 'Account löschen',
    icon: 'pi pi-info-warn',
    rejectLabel: 'Abbrechen',
    rejectProps: {
      label: 'Abbrechen2',
      severity: 'secondary',
      outlined: true
    },
    acceptProps: {
      label: 'Account endgültig löschen',
      severity: 'danger'
    },
    accept: () => {
      performAccountDeletion()
    },
    reject: () => {}
  })
}

const performAccountDeletion = () => {
  fetch(USER_ACCOUNT_DELETION_PATH, { method: 'DELETE' }).then(async response => {
    if (response.status !== 200) {
      console.warn('Error while deleting user account: ' + response.body)
      const responseJson = await response.json()
      addHint('Fehler', `Der Account konnte nicht gelöscht werden: ${responseJson.error}`, 'error')
    } else {
      addHint('Account erfolgreich gelöscht', '', 'success')
      window.location.href = '/data/logout'
    }
  })
}

// Garmin

const garminIsConnected = ref(false)

const onGarminBtnClick = () => {
  garminIsConnected.value ? disconnectGarmin() : connectGarmin()
}
const GARMIN_VENDOR_BASE_PATH = '/data/external-vendors/GARMIN'
const GARMIN_VENDOR_STATUS_PATH = GARMIN_VENDOR_BASE_PATH + '/status'

const connectGarmin = () => {
  window.location.href = GARMIN_VENDOR_BASE_PATH
}

const disconnectGarmin = () => {
  fetch(GARMIN_VENDOR_BASE_PATH, { method: 'DELETE' })
    .then(response => {
      if (response.status !== 200) {
        console.warn('Error while disconnecting Garmin: ' + response.body)
        addHint('Fehler', `Die Garmin-Verknüpfung konnte nicht aufgelöst werden ${response.body}`, 'error')
      } else {
        addHint('Garmin-Vernküpfung erfolgreich entfernt', '', 'success')
      }
    })
    .finally(fetchGarminStatus)
}

const fetchGarminStatus = () => {
  fetch(GARMIN_VENDOR_STATUS_PATH)
    .then(response => response.json())
    .then(data => {
      garminIsConnected.value = data.connected as unknown as boolean
    })
}

onMounted(() => {
  fetchGarminStatus()
})

const garminBtnLabel = computed(() => (garminIsConnected.value ? 'Garmin-Verknüpfung aufheben' : 'Garmin verknüpfen'))
const garminBtnSeverity = computed(() => (garminIsConnected.value ? 'danger' : 'info'))
</script>

<style>
h1 {
  margin-top: 1rem;
}
</style>
