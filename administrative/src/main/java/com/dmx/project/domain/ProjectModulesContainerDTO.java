package com.dmx.project.domain;

import com.dmx.card.domain.CardDTO;
import com.dmx.module.domain.ModuleDTO;
import com.dmx.team.domain.TeamDTO;

public record ProjectModulesContainerDTO(
        String id,
        String name,
        String createBy,
        String creationDate,
        float state,
        int funcionalitiesCounter,
        TeamDTO[] teamsList,
        CardDTO[] cardList,
        ModuleDTO[] moduleList
) {
}
