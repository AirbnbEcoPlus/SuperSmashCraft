package fr.endide.supersmashcraft.entity;

import org.bukkit.inventory.ItemStack;

import java.util.List;

public class Fighters {
    public String name;
    public int jump;
    public int speed;
    public int damage;
    public int weight;
    public List<ItemStack> items;

    public Fighters(String name, int jump, int speed, int damage, int weight, List<ItemStack> items) {
        this.name = name;
        this.jump = jump;
        this.speed = speed;
        this.damage = damage;
        this.weight = weight;
        this.items = items;
    }
}
