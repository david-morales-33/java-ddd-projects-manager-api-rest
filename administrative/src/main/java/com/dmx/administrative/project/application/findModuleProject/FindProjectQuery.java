package com.dmx.administrative.project.application.findModuleProject;

import com.dmx.shared.domain.bus.query.Query;

public final class FindProjectQuery implements Query {
    private final String projectId;

    public FindProjectQuery(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectId() {
        return this.projectId;
    }
}
