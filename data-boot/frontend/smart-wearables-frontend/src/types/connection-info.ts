interface ConnectionInfo {
  vendor: string
  connected: boolean
  requiredScopesGranted: boolean
  connectedAt: Date
  grantedScopes: string[]
  connectedAndHasRequiredConsents: boolean
  missingScopes: string[]
}
