package com.microservice.administrative.project.application.addTeam;

import com.microservice.administrative.shared.domain.bus.command.Command;

public final class AddTeamCommand implements Command{
    private final String projectId;
    private final String teamId;
    private final String roleId;
    private final String name;

    public AddTeamCommand(String projectId, String teamId, String roleId, String name) {
        this.projectId = projectId;
        this.teamId = teamId;
        this.roleId = roleId;
        this.name = name;
    }

    public String getProjectId() {
        return this.projectId;
    }

    public String getTeamId() {
        return this.teamId;
    }

    public String getRoleId() {
        return this.roleId;
    }

    public String getName() {
        return this.name;
    }
}
