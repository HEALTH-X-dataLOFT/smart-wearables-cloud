package com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.thryve;

import com.medisanaspace.healthx.dataloft.smartwearables.common.TimePeriod;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.user.User;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.epochs.EpochValue;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.epochs.EpochValueProvider;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.thryve.model.ConnectedSourcesDto;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.thryve.model.ConnectionStatus;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.thryve.model.QueryOptions;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.thryve.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service("thryve")
@Slf4j
public class ThryveService implements EpochValueProvider<Double> {

    private final ThryveClient thryveClient;

    public ThryveService(ThryveClient thryveClient) {
        this.thryveClient = thryveClient;
    }

    String obtainDataSourceUrlFor(User user) {
        return thryveClient.createDataSourceURLFor(user);
    }

    List<ConnectionStatus> getConnectionStatesFor(User user) {
        UserInfo userInfo = thryveClient.getUserInfoFor(user).orElseThrow();
        List<ConnectedSourcesDto> connectedSources = userInfo.getConnectedSources();
        return connectedSources.stream()
                .map(ConnectionStatus::of)
                .toList();
    }

    @Override
    public Collection<EpochValue<Double>> findEpochValuesFor(User user, TimePeriod timePeriod) {
        QueryOptions options = QueryOptions.of(timePeriod.getStart(), timePeriod.getEnd());
        return thryveClient.fetchDynamicEpochValues(user, options);
    }
}
