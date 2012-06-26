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
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author mmain
 */
public class CharacterTemplate {
    protected static String[] attributes, stats, saves, classes;
    
    public static void load(String filename) throws MalformedURLException, IOException {
        URL url = new File(filename).toURI().toURL();
        Scanner scanner = new Scanner (new InputStreamReader((InputStream)url.getContent()));
        
        Pattern attributesPattern = Pattern.compile("attributes:(.*)");
        Pattern statsPattern = Pattern.compile("stats:(.*)");
        Pattern savesPattern = Pattern.compile("saves:(.*)");
        Pattern classesPattern = Pattern.compile("classes:(.*)");
        Matcher m;
        
        String csv;
        
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            
            m = attributesPattern.matcher(line);
            if (m.matches()) {
                csv = m.group(1);
                attributes = csv.split(",[ ]*");
            }
            
            m = statsPattern.matcher(line);
            if (m.matches()) {
                csv = m.group(1);
                stats = csv.split(",[ ]*");
            }
            
            m = savesPattern.matcher(line);
            if (m.matches()) {
                csv = m.group(1);
                saves = csv.split(",[ ]*");
            }
            
            m = classesPattern.matcher(line);
            if (m.matches()) {
                csv = m.group(1);
                classes = csv.split(",[ ]*");
            }
        }
    }
    
    public static HashMap<String, HashMap<String, Integer>> generateCharacterSheet() {
        HashMap<String, HashMap<String, Integer>> characterSheet = new HashMap<>();
        
        HashMap<String, Integer> aMap = new HashMap<>();
        for (String s : attributes)
            aMap.put(s, 0);
        
        characterSheet.put("attributes", aMap);
        
        HashMap<String, Integer> saMap = new HashMap<>();
        for (String s : saves)
            saMap.put(s, 0);
        
        characterSheet.put("saves", saMap);
        
        HashMap<String, Integer> stMap = new HashMap<>();
        for (String s : stats)
            stMap.put(s, 0);
        
        characterSheet.put("stats", stMap);
        
        return characterSheet;
    }
}
