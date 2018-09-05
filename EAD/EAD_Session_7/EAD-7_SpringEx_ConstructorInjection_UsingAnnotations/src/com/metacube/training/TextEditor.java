package com.metacube.training;

public class TextEditor {

    private SpellChecker spellChecker;
    
    public TextEditor(SpellChecker spellChecker) {
            System.out.println("Text editor constructor is called");
            this.spellChecker = (spellChecker);
    }
    
    public void checkSpelling() {
        spellChecker.spellCheck();
    }

    public SpellChecker getSpellChecker() {
        return spellChecker;
    }

    public void setSpellChecker(SpellChecker spellChecker) {
        this.spellChecker = spellChecker;
    }
}
