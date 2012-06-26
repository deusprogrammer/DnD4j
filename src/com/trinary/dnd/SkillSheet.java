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
public class SkillSheet {
    protected Character owner;
    protected HashMap<String, Integer> skillSheet;
    
    SkillSheet(Character owner) {
        this.owner = owner;
        skillSheet = SkillLibrary.generateEmptySkillSheet();
    }
    
    public void assignPoints(String skillName, int points) {
        
    }    
}
