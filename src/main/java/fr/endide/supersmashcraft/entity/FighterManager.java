package fr.endide.supersmashcraft.entity;

import java.util.List;

public class FighterManager {
    public List<Fighters> fighters;

    public void addFighter(Fighters fighter){
        fighters.add(fighter);
    }
}
