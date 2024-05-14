package com.example.tictactoe1;

public enum PozycjaX {
    LEWY(0, "L"),
    SRODKOWY(1, "S"),
    PRAWY(2, "P");

    private final int intValue;
    private final String stringValue;

    PozycjaX(int intValue, String stringValue) {
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
        for (PozycjaX pozycja : PozycjaX.values()) {
            if (pozycja.getIntValue() == value) {
                return pozycja.getStringValue();
            }
        }
        return "nieznany";
    }
}

