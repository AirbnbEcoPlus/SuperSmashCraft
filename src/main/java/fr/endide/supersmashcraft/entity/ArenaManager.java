package fr.endide.supersmashcraft.entity;

import org.bukkit.entity.Player;

import java.util.List;

public class ArenaManager {
    public List<Arena> arenas;

    public void addArena(Arena arena) {
        arenas.add(arena);
    }
    public void deleteArena(Arena arena) {
        arenas.remove(arena);
    }
    public Arena getArena(String name) {
        for (Arena arena : arenas) {
            if (arena.name.equals(name)) {
                return arena;
            }
        }
        return null;
    }
    public void addPlayerToArena(Arena arena, Player player, Fighters selected) {
        arena.players.add(new smashPlayer(player, selected));
        player.sendMessage("You have been added to the arena " + arena.name);
        for(int index = 0; arena.players.size() > index ; index++) {
            arena.players.get(index).player.sendMessage(player.getName() + " has been added to the arena " + arena.name);
        }
        if(arena.players.size() == arena.maxPlayers) {
            arena.setStarted(true);
            if(arena.maxPlayers == 2){
                arena.players.get(0).player.sendMessage("The game is starting");
                arena.players.get(1).player.sendMessage("The game is starting");
                arena.players.get(0).player.teleport(arena.loc1);
                arena.players.get(1).player.teleport(arena.loc2);
            }
        }
    }
    public void removeStock(){

    }
    public void addPercent(Player player, int percent){

    }
    public Arena getArenaByPlayer(Player player) {
        for (Arena arena : arenas) {
            if (arena.players.contains(player)) {
                return arena;
            }
        }
        return null;
    }
    public void removePlayerFromArena(Arena arena, Player player) {
        arena.players.remove(player);
    }
    public void startArena(Arena arena) {
        arena.isStarted = true;
    }
    public void stopArena(Arena arena) {
        arena.isStarted = false;
    }
    public Arena getArenaNotStarted() {
        for (Arena arena : arenas) {
            if (!arena.isStarted) {
                return arena;
            }
        }
        return null;
    }
    public void deleteAllArenas() {
        arenas.clear();
    }

}
