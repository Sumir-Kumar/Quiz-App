package com.sumir.quizapp;

public class Questions {
    private int ansResId;
    private boolean trueAns;

    public Questions(int ansResId, boolean trueAns) {
        this.ansResId = ansResId;
        this.trueAns = trueAns;
    }

    public int getAnsResId() {
        return ansResId;
    }

    public void setAnsResId(int ansResId) {
        this.ansResId = ansResId;
    }

    public boolean isTrueAns() {
        return trueAns;
    }

    public void setTrueAns(boolean trueAns) {
        this.trueAns = trueAns;
    }
}
