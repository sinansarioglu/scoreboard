package models;

import exceptions.TeamIsAlreadyCreatedException;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Team {
    private final UUID id;
    private final String name;
    private final static Set<String> teams = new HashSet<>();

    public Team(String name) throws TeamIsAlreadyCreatedException {
        if(teams.contains(name.toLowerCase())) {
            throw new TeamIsAlreadyCreatedException(name);
        }
        this.id = UUID.randomUUID();
        this.name = name;
        teams.add(name.toLowerCase());
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }
}
