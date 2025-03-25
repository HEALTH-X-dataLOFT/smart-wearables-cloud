package com.medisanaspace.healthx.dataloft.smartwearables.domain.auth;

import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.ActivityProviderAccountLink;

public interface AccountLinkPropertySetter {

    void setProviderSpecificLinkProperties(ActivityProviderAccountLink link);
}
