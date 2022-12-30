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
    int maxPlayers;
    List<smashPlayer> players;
    boolean isStarted;
    public Arena(String name, Location loc1, Location loc2, World worldName, List<smashPlayer> players, boolean isStarted, int maxPlayers) {
        this.name = name;
        this.loc1 = loc1;
        this.loc2 = loc2;
        this.worldName = worldName;
        this.players = players;
        this.isStarted = isStarted;
        this.maxPlayers = maxPlayers;
    }
    public String getName(){
        return name;
    }
    public void getPlayers(){
        players.forEach(player -> {
            System.out.println(player.player.getName());
        });
    }
    public void addPlayer(Player player, Fighters selected){
        players.add(player, selected);
    }
    public void removePlayer(Player player){
        players.remove(player);
    }
    public boolean isStarted(){
        return isStarted;
    }
    public void setStarted(boolean started){
        isStarted = started;
    }
    public Location getLoc1(){
        return loc1;
    }
    public Location getLoc2(){
        return loc2;
    }
    public World getWorldName(){
        return worldName;
    }
    public int getMaxPlayers(){
        return maxPlayers;
    }
}
