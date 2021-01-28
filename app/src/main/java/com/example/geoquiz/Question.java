package com.example.geoquiz;

public class Question {
    //Attribute
    public int idText;
    public boolean answer;
    //Construct
    public Question(int idText, boolean answer){
        this.idText = idText;
        this.answer = answer;
    }

    //getters && setters
    public int getIdText() {
        return idText;
    }

    public void setIdText(int idText) {
        this.idText = idText;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
