package com.microservice.administrative.project.domain;

import java.util.HashMap;

import com.microservice.administrative.card.domain.Card;
import com.microservice.administrative.shared.domain.AggregateRoot;
import com.microservice.administrative.shared.domain.ProjectId;
import com.microservice.administrative.team.domain.Team;

public abstract class Project extends AggregateRoot {
    private final ProjectId id;
    private final ProjectName name;
    private final HashMap<String, Team> teamList;
    private final HashMap<String, Card> cardList;
    private ProjectFuncionalitiesCounter funcionalitiesCounter;
    private ProjectCardCounter cardCounter;
    private ProjectTeamsCounter teamsCounter;

    public Project(
            ProjectId id,
            ProjectName name,
            ProjectFuncionalitiesCounter funcionalitiesCounter,
            HashMap<String, Team> teamList,
            HashMap<String, Card> cardList
    ) {
        this.id = id;
        this.name = name;
        this.funcionalitiesCounter = funcionalitiesCounter;
        this.teamList = teamList;
        this.cardList = cardList;
        this.teamsCounter = new ProjectTeamsCounter(teamList.size());
        this.cardCounter = new ProjectCardCounter(cardList.size());
    }

    public void addTeam(Team team) {
        if (this.teamList.containsKey(team.getId().value()))
            throw new ProjectInternalException("El equipo ya existe");
        this.teamList.put(team.getId().value(), team);
        this.incrementTeamsCounter();
    }

    public void addCard(Card card) {
        if (this.cardList.containsKey(card.getId().value()))
            throw new ProjectInternalException("La targeta ya existe");
        this.cardList.put(card.getId().value(), card);
        this.incrementCardCounter();
    }

    public void incrementFuncionalitiesCounter() {
        this.funcionalitiesCounter = new ProjectFuncionalitiesCounter(this.funcionalitiesCounter.value() + 1);
    }

    public void incrementCardCounter() {
        this.cardCounter = new ProjectCardCounter(this.cardCounter.value() + 1);
    }

    public void incrementTeamsCounter() {
        this.teamsCounter = new ProjectTeamsCounter(this.teamsCounter.value() + 1);
    }

    public ProjectId getId() {
        return this.id;
    }

    public ProjectName getName() {
        return this.name;
    }

    public ProjectFuncionalitiesCounter getFuncionalitiesCounter() {
        return this.funcionalitiesCounter;
    }

    public HashMap<String, Team> getTeamList() {
        return teamList;
    }

    public HashMap<String, Card> getCardList() {
        return cardList;
    }

    public ProjectCardCounter getCardCounter() {
        return this.cardCounter;
    }

    public ProjectTeamsCounter getTeamsCounter() {
        return this.teamsCounter;
    }
}
