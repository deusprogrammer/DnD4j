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
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author mmain
 */
public class CharacterClassTemplate {
    public ArrayList<CharacterClassStatEntry> levels;
    public String hitDie;
    public ArrayList<String> alignments;
    public ArrayList<String> proficiencies;
    public String className;
    public String classAbbrev;
    
    public CharacterClassTemplate() {
        this.levels = new ArrayList<>();
        this.alignments = new ArrayList<>();
        this.proficiencies = new ArrayList<>();
    }
    
    public String toString() {
        String ret = "Class Name: " + className + "(" + classAbbrev + ")\n" + "Levels: \n";
        
        for (CharacterClassStatEntry entry : levels)
            ret += "\t" + entry + "\n";
        
        return ret + "\n\tHit Die: " + hitDie + "\n\tAlignments: " + alignments + "\n\tProficiencies: " + proficiencies + "\n";
    }
}
