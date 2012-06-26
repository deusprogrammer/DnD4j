/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trinary.dnd;

import java.util.HashMap;

/**
 *
 * @author mmain
 */
public class Character {
    HashMap<String, Integer> attributes, stats, saves;
    CharacterClass characterClass;
    CharacterRace characterRace;
    
    protected int strength, dexterity, constitution, charisma, intelligence, wisdom;
        
    protected int willSave, fortSave, reflexSave;
    protected int baseAttackBonus;
    protected int meleeBonus;
    protected int rangeBonus;
    protected int initiative;
    protected int armorClass;
    protected int hp, currentHP;
        
    protected String name;
    protected int level;
        
    public Character(String name, HashMap<String, Integer> attributes, HashMap<String, Integer> stats, HashMap<String, Integer> saves) {
        this.level = 1;
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.charisma = charisma;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
    }
    
    
}
