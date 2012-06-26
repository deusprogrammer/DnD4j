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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author mmain
 */
public class CharacterClassLibrary {
    static HashMap<String, CharacterClassTemplate> characterClasses;
    
    public static void load(String filename) throws MalformedURLException, IOException {
        URL url = new File(filename).toURI().toURL();
        Scanner scanner = new Scanner (new InputStreamReader((InputStream)url.getContent()));
        
        Pattern namePattern = Pattern.compile("([a-zA-Z]+)\\(([a-zA-Z]+)\\)");
        Pattern levelPattern = Pattern.compile("[ \t]*Level ([0-9]+):[ \t]*(.*)");
        Pattern hitDiePattern = Pattern.compile("[ \t]*Hit Die:[ \t]*(.*)");
        Pattern profPattern = Pattern.compile("[ \t]*Proficiencies:[ \t]*(.*)");
        Pattern alignPattern = Pattern.compile("[ \t]*Alignments:[ \t]*(.*)");
        Matcher m;
        
        String csv;
        String[] values;
        CharacterClassStatEntry entry;
        CharacterClassTemplate template = null;
        characterClasses = new HashMap<>();
        
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            
            m = namePattern.matcher(line);
            if (m.matches()) {
                //System.out.println("FOUND name");
                
                if (template != null)
                    characterClasses.put(template.classAbbrev, template);

                template = new CharacterClassTemplate();
                
                template.className = m.group(1);
                template.classAbbrev = m.group(2);
                
                continue;
            }
            
            if (template != null) {
                m = levelPattern.matcher(line);
                if (m.matches()) {
                    //System.out.println("FOUND level");
                    
                    csv = m.group(2);
                    values = csv.split(",[ ]*");
                    entry = new CharacterClassStatEntry();
                    entry.baseAttackBonus = values[0];
                    entry.fortSave = values[1];
                    entry.refSave = values[2];
                    entry.willSave = values[3];
                    entry.special = values[4];
                    template.levels.add(entry);
                    
                    continue;
                }

                m = hitDiePattern.matcher(line);
                if (m.matches()) {
                    //System.out.println("FOUND hit die");
                    
                    template.hitDie = m.group(1);
                    
                    continue;
                }

                m = profPattern.matcher(line);
                if (m.matches()) {
                    //System.out.println("FOUND proficiencies");
                    
                    values = m.group(1).split(",[ ]*");
                    for (String s : values)
                        template.proficiencies.add(s);
                    
                    continue;
                }

                m = alignPattern.matcher(line);
                if (m.matches()) {
                    //System.out.println("FOUND alignments");
                    
                    values = m.group(1).split(",[ ]*");
                    for (String s : values)
                        template.alignments.add(s);
                    
                    continue;
                }
            }
        }
        
        if (template != null)
            characterClasses.put(template.classAbbrev, template);
    }
    
    public static void printLibrary() {
        for (CharacterClassTemplate template : characterClasses.values()) {
            System.out.println(template);
        }
    }
}
