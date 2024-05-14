package com.example.tictactoe1;

public enum PozycjaY {
    GORA(0, "G"),
    SRODKOWY(1, "S"),
    DOL(2, "D");

    private final int intValue;
    private final String stringValue;

    PozycjaY(int intValue, String stringValue) {
        this.intValue = intValue;
        this.stringValue = stringValue;
    }

    public int getIntValue() {
        return intValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public static String getStringValueFromInt(int value) {
        for (PozycjaY pozycja : PozycjaY.values()) {
            if (pozycja.getIntValue() == value) {
                return pozycja.getStringValue();
            }
        }
        return "nieznany";
    }
}
