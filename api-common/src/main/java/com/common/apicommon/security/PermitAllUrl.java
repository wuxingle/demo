package com.common.apicommon.security;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class PermitAllUrl {

    private static final String[] WHITE_LIST = {"/actuator/test", "/actuator/env", "/actuator/metrics/**",
            "/actuator/trace", "/actuator/dump", "/actuator/jolokia", "/actuator/info", "/actuator/logfile",
            "/actuator/refresh", "/actuator/flyway", "/actuator/liquibase", "/actuator/heapdump", "/actuator/loggers",
            "/actuator/auditevents", "/actuator/env/PID", "/actuator/jolokia/**","/oauth/token","/oauth/**"};

    public static String[] permitAllUrl(String... urls) {
        if (urls != null && urls.length > 0) {
            Set<String> set = new HashSet<>();
            Collections.addAll(set, WHITE_LIST);
            Collections.addAll(set, urls);
            return set.toArray(new String[set.size()]);
        }
        return WHITE_LIST;
    }
}
