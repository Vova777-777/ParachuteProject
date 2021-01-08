package ru.vova777;

public interface CheckAbleIsDigit {
    default boolean isDigit(String value){
        try {
            int digit = Integer.parseInt(value);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }
}
