package org.example.chap02;

public class PasswordStrengthMeter {
    public PasswordStrength meter(String s) {
        if(s == null || s.isEmpty()) {
            return PasswordStrength.INVALID;
        }

        int metCounts = this.getMetCriteriaCounts(s);
        if(metCounts <= 1) {
            return PasswordStrength.WEAK;
        }
        if(metCounts == 2) {
            return PasswordStrength.NORMAL;
        }
        return PasswordStrength.STRONG;
    }

    private boolean meetsContainingNumberCriteria(String s) {
        for(char ch : s.toCharArray()) {
            if(ch >= '0' && ch <= '9') {
                return true;
            }
        }
        return false;
    }

    private boolean meetsContainingUppercaseCriteria(String s) {
        for(char ch : s.toCharArray()) {
            if(Character.isUpperCase(ch)) {
                return true;
            }
        }
        return false;
    }

    private int getMetCriteriaCounts(String s) {
        int meetCounts = 0;
        if(s.length() >= 8) {
            meetCounts++;
        }
        if(this.meetsContainingNumberCriteria(s)) {
            meetCounts++;
        }
        if(this.meetsContainingUppercaseCriteria(s)) {
            meetCounts++;
        }

        return meetCounts;
    }
}
