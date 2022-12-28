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
    public void addPlayerToArena(Arena arena, Player player) {
        arena.players.add(player);
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

}
