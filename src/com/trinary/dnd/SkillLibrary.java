/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trinary.dnd;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author mmain
 */
public class SkillLibrary {
    
    protected static HashMap<String, Skill> skills;
    protected static boolean loaded = false;
    
    public static void load(String filename) throws MalformedURLException, IOException {
        URL url = new File(filename).toURI().toURL();
        Scanner scanner = new Scanner (new InputStreamReader((InputStream)url.getContent()));
        //Scanner scanner = new Scanner(new FileInputStream(filename));
        skills = new HashMap<String, Skill>();
        
        String skillName = null;
        String crossClass = null;
        String keyAbility = null;
        boolean untrained = false, armorPenalty = false;
        
        Pattern untrainedPattern = Pattern.compile("[\t ]*Untrained:(Yes|No)");
        Pattern keyAbilityPattern = Pattern.compile("[\t ]*Key Ability:([a-zA-Z]{3})*");
        Pattern crossClassPattern = Pattern.compile("[\t ]*(([a-zA-Z]{3}):([0-2]),*)+");
        Matcher m;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            
            m = untrainedPattern.matcher(line);
            
            if (m.matches()) {
                if (m.group(1).equals("Yes"))
                    untrained = true;
                else
                    untrained = false;
                continue;
            }
            
            m = keyAbilityPattern.matcher(line);
            
            if (m.matches()) {
                keyAbility = m.group(1);
                continue;
            }
            
            m = crossClassPattern.matcher(line);
            
            if (m.find()) {
                crossClass = line;
                continue;
            }
                               
            if (line.length() == 1 && skillName != null) {
                skills.put(skillName, new Skill(skillName, keyAbility, crossClass, untrained, armorPenalty));
                continue;
            }
            
            skillName = line;
        }
        
        skills.put(skillName, new Skill(skillName, keyAbility, crossClass, untrained, armorPenalty));
        
        loaded = true;
    }
    
    public static HashMap<String, Integer> generateEmptySkillSheet() {
        HashMap<String, Integer> skillSheet = new HashMap<String, Integer>();
        
        if (loaded) {
            Iterator it = skills.values().iterator();
        
            for (Skill skill : skills.values())
                skillSheet.put(skill.skillName, 0);
            
            return skillSheet;
        }
        else
            return null;
    }
    
    public static void printLibrary() {
        for (Skill skill : skills.values()) {
            System.out.println(skill);
        }
    }
}