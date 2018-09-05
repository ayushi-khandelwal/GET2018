package com.metacube.training;

public class TextEditor {

    SpellChecker spellChecker;
    String word;

    public TextEditor() {
        System.out.println("Text editor constructor is called");
    }

    public SpellChecker getSpellChecker() {
        return spellChecker;
    }

    public void setSpellChecker(SpellChecker spellChecker) {
        this.spellChecker = spellChecker;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void spellCheck() {
        spellChecker.spellCheck();
    }
}
