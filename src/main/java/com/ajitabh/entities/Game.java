package com.ajitabh.entities;

import javax.sql.DataSource;

public interface Game {

    void setDataSource(DataSource dataSource);
    DataSource getDataSource();
    void setHomeTeam(Team team);
    Team getHomeTeam();
    void setAwayTeam(Team team);
    Team getAwayTeam();
    String playGame();
}
