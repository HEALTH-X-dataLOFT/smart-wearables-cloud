import { app } from '@/main'

type Severity = 'info' | 'success' | 'warn' | 'error' | 'secondary' | 'contrast' | undefined

export const addHint = (title: string, body: string, severity?: Severity, life: number = 4000) => {
  app.config.globalProperties.$toast.add({
    severity: severity ?? 'info',
    summary: title,
    detail: body,
    life
  })
}
