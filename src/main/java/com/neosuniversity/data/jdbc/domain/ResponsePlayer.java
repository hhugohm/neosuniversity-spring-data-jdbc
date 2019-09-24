package com.neosuniversity.data.jdbc.domain;

import java.util.List;

public class ResponsePlayer {

    private List<Player> playerList;

    public ResponsePlayer(List<Player> playerList) {
        this.playerList = playerList;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }
}
