package com.metacube.training;

public class TextEditor {

    private SpellChecker spellChecker;
    
    public TextEditor(SpellChecker spellChecker) {
            System.out.println("Text editor constructor is called");
            this.setSpellChecker(spellChecker);
    }
    
    public void spellCheck() {
        System.out.println("Spelling is checked in TextEditor..");
    }

    public SpellChecker getSpellChecker() {
        return spellChecker;
    }

    public void setSpellChecker(SpellChecker spellChecker) {
        this.spellChecker = spellChecker;
    }
}
