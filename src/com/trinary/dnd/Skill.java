/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trinary.dnd;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author mmain
 */
public class Skill {
    protected String skillName;
    protected boolean untrained;
    protected boolean armorPenalty;
    protected String keyAbility;
    
    //0: Class exclusive
    //1: Cross-class
    //2: Class
    protected HashMap<String, Integer> crossClass;
    
    public Skill(String skillName, String keyAbility, String crossClass, boolean untrained, boolean armorPenalty) {
        this.skillName = skillName;
        this.untrained = untrained;
        this.armorPenalty = armorPenalty;
        this.keyAbility = keyAbility;
        this.crossClass = new HashMap<String, Integer>();
        
        Pattern crossClassPattern = Pattern.compile("[\t ]*([a-zA-Z]{3}):([0-2]),*");
        Matcher m;
        
        m = crossClassPattern.matcher(crossClass);
        
        while (m.find()) {
            this.crossClass.put(m.group(1), Integer.parseInt(m.group(2)));
        }
    }
    
    public String toString() {
        return "Skill: " + skillName + "\n\tUntrained: " + untrained + "\n\tArmor Penalty: " + armorPenalty + "\n\tKey Ability: " + keyAbility + "\n\tCrossClass: " + crossClass;
    }
}
