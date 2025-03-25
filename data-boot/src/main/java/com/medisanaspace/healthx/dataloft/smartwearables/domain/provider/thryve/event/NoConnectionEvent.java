package com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.thryve.event;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor(staticName = "of")
@Data
public class NoConnectionEvent implements ConnectionEvent {
    private final UUID userId;
}
