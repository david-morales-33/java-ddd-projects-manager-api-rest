package com.dmx.administrative.funcionality.domain;

public record FuncionalityDTO(
        String id,
        String name,
        String description,
        String creationdate,
        boolean state,
        String teamId,
        String roleId
) {
}