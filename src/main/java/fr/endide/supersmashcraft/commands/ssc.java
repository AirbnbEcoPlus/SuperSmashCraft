package fr.endide.supersmashcraft.commands;

import fr.endide.supersmashcraft.SuperSmashCraft;
import fr.endide.supersmashcraft.entity.Arena;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ssc implements CommandExecutor {
    public SuperSmashCraft main;
    public ssc(SuperSmashCraft superSmashCraft) {
        this.main = superSmashCraft;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if(args.length == 0) {
            player.sendMessage("§c§lSuper§f§lSmash§6§lCraft §7- §f§lBy Endide");
            player.sendMessage("§7- §f§l/ssc help");
        }
        if(args.length == 1){
            if(args[0].equalsIgnoreCase("help")){
                player.sendMessage("§c§lSuper§f§lSmash§6§lCraft §7- §f§lBy Endide");
                player.sendMessage("§7- §f§l/ssc join");
                player.sendMessage("§7- §f§l/ssc leave");
                player.sendMessage("Admin Commands");
                player.sendMessage("§7- §f§l/ssc list");
                player.sendMessage("§7- §f§l/ssc setlobby");
                player.sendMessage("§7- §f§l/ssc create");


            }
            if(args[0].equalsIgnoreCase("join")){
                if(player.getLocation() == main.getSpawn()){
                    Arena arena = main.getArenaManager().getArenaNotStarted();
                    if(arena != null){
                        main.getArenaManager().addPlayerToArena(arena, player, main.getFightersManager().getFighter("mario"));
                    }else{
                        player.sendMessage(ChatColor.RED + "No arena available");
                    }
                }else{
                    player.sendMessage("§cYou are not in the lobby");
                }
            }
            if(args[0].equalsIgnoreCase("setlobby")){

            }
            if(args[0].equalsIgnoreCase("leave")){

            }
        }
        return false;
    }
}
