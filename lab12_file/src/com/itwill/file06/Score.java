package com.itwill.file06;

import java.io.Serial;
import java.io.Serializable;

public class Score implements Serializable {
    @Serial
    private static final long serialVersionUID = 9085725719667912981L;
    
    private int korean;
    private int english;
    private int math;
    
    // 생성자
    public Score() {}

    public Score(int korean, int english, int math) {
        this.korean = korean;
        this.english = english;
        this.math = math;
    }

    // getters & setters
    public int getKorean() {
        return korean;
    }

    public void setKorean(int korean) {
        this.korean = korean;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    // toString
    @Override
    public String toString() {
        return "Score [korean=" + korean + ", english=" + english + ", math=" + math + "]";
    }

}
