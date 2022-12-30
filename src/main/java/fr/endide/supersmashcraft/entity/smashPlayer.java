package fr.endide.supersmashcraft.entity;

import org.bukkit.entity.Player;

public class smashPlayer {
    Player player;
    Fighters fighter;

    public smashPlayer(Player player, Fighters selected) {
        this.player = player;
        this.fighter = selected;
    }
}
