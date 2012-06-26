/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trinary.dnd;

/**
 *
 * @author mmain
 */
public class CharacterClassStatEntry {
    public String baseAttackBonus;
    public String fortSave, refSave, willSave;
    public String special;
    
    public String toString() {
        return baseAttackBonus + ", " + fortSave + ", " + refSave + ", " + willSave + ", " + special;
    }
}
