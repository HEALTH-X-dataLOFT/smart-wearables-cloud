package com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.thryve;

import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.user.User;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.user.UserService;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.helper.UserIdHelper;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.thryve.model.ConnectionStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.security.RolesAllowed;
import java.security.Principal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/thryve")
@Slf4j
public class ThryveController {

    private final ThryveService thryveService;
    private final UserService userService;

    public ThryveController(ThryveService thryveService, UserService userService) {
        this.thryveService = thryveService;
        this.userService = userService;
    }

    @GetMapping(path = "/dataSourceUrl")
    @RolesAllowed("swc-user")
    public String obtainDataSourceConnectionUrl(Principal userPrincipal) {
        UUID userUUID = UserIdHelper.parseUserIdFromPrincipal(userPrincipal);
        User user = userService.findByKeycloakId(userUUID);
        return thryveService.obtainDataSourceUrlFor(user);
    }

    @GetMapping(path = "/connectionStates")
    @RolesAllowed("swc-user")
    public List<ConnectionStatus> connectionStates(Principal userPrincipal) {
        UUID userUUID = UserIdHelper.parseUserIdFromPrincipal(userPrincipal);
        User user = userService.findByKeycloakId(userUUID);
        return thryveService.getConnectionStatesFor(user);
    }
}
