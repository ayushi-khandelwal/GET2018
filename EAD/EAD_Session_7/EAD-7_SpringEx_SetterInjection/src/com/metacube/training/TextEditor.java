package com.metacube.training;

public class TextEditor {

    SpellChecker spellChecker;
    
    public TextEditor() {
            System.out.println("Text editor constructor is called");
    }
    
    public SpellChecker getSpellChecker() {
        return spellChecker;
    }
    
    public void setSpellChecker(SpellChecker spellChecker) {
        this.spellChecker = spellChecker;
    }
    
    public void spellCheck() {
        System.out.println("Spelling is checked..");
    }
}
