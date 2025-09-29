package org.coolandfunandnice.matchengine.team;

import org.coolandfunandnice.common.enums.Position;
import org.coolandfunandnice.matchengine.player.PlayerInfo;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public record TeamInfo(
        String name,
        String coachName,
        List<PlayerInfo> players
) {
    public List<PlayerInfo> orderedPlayers() {
        return players.stream().sorted().toList();
    }

    public String getFormationString() {
        Map<Position, Integer> positionCount = players.stream().collect(Collectors.toMap(
                PlayerInfo::position,
                p -> 1,
                Integer::sum
        ));

        return String.format("%d-%d-%d",
                positionCount.getOrDefault(Position.DEFENDER, 0),
                positionCount.getOrDefault(Position.MIDFIELDER, 0),
                positionCount.getOrDefault(Position.FORWARD, 0)
        );
    }

    @Override
    public String toString() {
        return "TeamInfo{" +
                "name='" + name + '\'' +
                ", coachName='" + coachName + '\'' +
                ", players=" + players +
                ", formation=" + getFormationString() +
                '}';
    }
}
