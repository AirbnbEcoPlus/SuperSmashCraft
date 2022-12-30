package fr.endide.supersmashcraft.listeners;

import fr.endide.supersmashcraft.SuperSmashCraft;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
public class basicSystem implements Listener {
    public SuperSmashCraft main;
    public basicSystem(SuperSmashCraft superSmashCraft) {
        this.main = superSmashCraft;
    }
    @EventHandler public void onPlayerQuit(PlayerQuitEvent e){
        Player player = e.getPlayer();
        if(main.getArenaManager().getArenaByPlayer(player) != null){
            main.getArenaManager().getArenaByPlayer(player).removePlayer(player);
        }
    }
}
