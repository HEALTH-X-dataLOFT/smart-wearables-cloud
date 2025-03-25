import './assets/main.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'
import PrimeVue from 'primevue/config'
import Aura from '@primevue/themes/aura'
import Menubar from 'primevue/menubar'
import Image from 'primevue/image'
import DataTable from 'primevue/datatable'
import DataView from 'primevue/dataview'
import Column from 'primevue/column'
import Fieldset from 'primevue/fieldset'
import Button from 'primevue/button'
import Toast from 'primevue/toast'
import Ripple from 'primevue/ripple'
import ConfirmDialog from 'primevue/confirmdialog'
import Chart from 'primevue/chart'
import Card from 'primevue/card'
import ProgressSpinner from 'primevue/progressspinner'
import SelectButton from 'primevue/selectbutton'

import ToastService from 'primevue/toastservice'
import ConfirmationService from 'primevue/confirmationservice'

export const app = createApp(App)

app.use(createPinia())
app.use(router)
app.use(PrimeVue, {
  theme: {
    preset: Aura
  },
  ripple: true
})

app.use(ToastService)
app.use(ConfirmationService)

app.directive('ripple', Ripple)

app.component('Menubar', Menubar)
app.component('Image', Image)
app.component('DataTable', DataTable)
app.component('Column', Column)
app.component('Fieldset', Fieldset)
app.component('Button', Button)
app.component('Toast', Toast)
app.component('ConfirmDialog', ConfirmDialog)
app.component('Chart', Chart)
app.component('Card', Card)
app.component('ProgressSpinner', ProgressSpinner)
app.component('SelectButton', SelectButton)
app.component('DataView', DataView)

app.mount('#app')
