package org.coolandfunandnice.matchengine.player;

import org.coolandfunandnice.common.Coordinate;
import org.coolandfunandnice.matchengine.environment.Pitch;
import org.coolandfunandnice.matchengine.environment.PitchEntity;

public class MatchPlayer implements PitchEntity {

    private final PlayerInfo playerInfo;
    private final Pitch pitch;

    private Coordinate positionOnPitch;

    public MatchPlayer(PlayerInfo playerInfo, Pitch pitch) {
        this.playerInfo = playerInfo;
        this.pitch = pitch;
    }

    public PlayerInfo getPlayerInfo() {
        return playerInfo;
    }

    public Pitch getPitch() {
        return pitch;
    }

    public Coordinate getPositionOnPitch() {
        return positionOnPitch;
    }

    public void setPositionOnPitch(Coordinate positionOnPitch) {
        this.positionOnPitch = positionOnPitch;
    }

    @Override
    public Coordinate getPitchEntityCoordinate() {
        return positionOnPitch;
    }

    @Override
    public void setPitchEntityCoordinate(Coordinate coordinate) {
        this.positionOnPitch = coordinate;
    }

    @Override
    public String getLabel() {
        return "MatchPlayer";
    }
}
