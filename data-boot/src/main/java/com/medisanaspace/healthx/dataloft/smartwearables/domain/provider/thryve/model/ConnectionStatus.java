package com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.thryve.model;

import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.thryve.DataSource;
import lombok.Data;

import java.time.Instant;
import java.util.Set;

@Data
public class ConnectionStatus {

    static final String SCOPE_OXYGEN_SATURATION =    "huaweihealth_oxygen_saturation";
    static final String SCOPE_HEART_RATE =           "huaweihealth_heart_rate";
    static final String SCOPE_STEP =                 "huaweihealth_step";

    private static final Set<String> REQUIRED_SCOPES = Set.of(
            SCOPE_OXYGEN_SATURATION,
            SCOPE_HEART_RATE,
            SCOPE_STEP
    );

    private DataSource vendor;
    private boolean connected;
    private boolean requiredScopesGranted;
    private Instant connectedAt;
    private Set<String> grantedScopes;

    private ConnectionStatus(DataSource vendor, boolean connected, Instant connectedAt, boolean requiredScopesGranted, Set<String> grantedScopes) {
        this.vendor = vendor;
        this.connected = connected;
        this.connectedAt = connectedAt;
        this.requiredScopesGranted = requiredScopesGranted;
        this.grantedScopes = grantedScopes;
    }

    public static ConnectionStatus of(ConnectedSourcesDto dataSource) {
        var grantedScopes = dataSource.getDataScopes();
        var requiredScopesGranted = grantedScopes.containsAll(REQUIRED_SCOPES);
        var vendor = DataSource.forId(dataSource.getDataSource());
        return new ConnectionStatus(vendor, dataSource.getConnectedAt() != null, dataSource.getConnectedAt(), requiredScopesGranted, grantedScopes);
    }

}
