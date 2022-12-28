package fr.endide.supersmashcraft.entity;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.List;

public class Arena {
    String name;
    Location loc1;
    Location loc2;
    World worldName;
    List<Player> players;
    boolean isStarted;
    public Arena(String name, Location loc1, Location loc2, World worldName, List<Player> players, boolean isStarted) {
        this.name = name;
        this.loc1 = loc1;
        this.loc2 = loc2;
        this.worldName = worldName;
        this.players = players;
        this.isStarted = isStarted;
    }
}
