
import com.trinary.dnd.CharacterClassLibrary;
import com.trinary.dnd.CharacterTemplate;
import com.trinary.dnd.SkillLibrary;
import java.io.IOException;
import java.net.MalformedURLException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mmain
 */
public class DnD4jMain {
    public static void main(String [] args) throws MalformedURLException, IOException {
        SkillLibrary.load("dnd-3.5.skills");
        CharacterClassLibrary.load("dnd-3.5.classes");
        CharacterTemplate.load("dnd-3.5.rules");
        
        SkillLibrary.printLibrary();
        CharacterClassLibrary.printLibrary();
        
        System.out.println("SKILL SHEET:     \n\t" + SkillLibrary.generateEmptySkillSheet());
        System.out.println("CHARACTER SHEET: \n\t" + CharacterTemplate.generateCharacterSheet());
    }
}
