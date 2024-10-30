package com.itwill.set03;

import java.util.Objects;

public class Score {
    private int java;
    private int sql;
    private int html;
    
    public Score(int java, int sql, int html) {
        this.java = java;
        this.sql = sql;
        this.html = html;
    }
    
    @Override
    public String toString() {
        return "Score(java=" + java
                + ", sql=" + sql
                + ", html=" + html
                + ")";
    }
    
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj instanceof Score) {
            Score other = (Score) obj;
            result = (this.java == other.java) 
                    && (this.sql == other.sql) 
                    && (this.html == other.html);
        }
        
        return result;
    }

    @Override
    public int hashCode() {
//        return java + sql + html;
//        return java * 8 + sql * 4 + html * 2;
        return Objects.hash(java, sql, html);
    }
    
}
