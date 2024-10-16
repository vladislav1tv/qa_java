package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParamTest {
    private String sex;
    private Boolean hasMane; // Исправлено: hasMane вместо gasMane
    private Lion lion;
    private Feline feline; // Добавлена переменная feline

    public LionParamTest(String sex, Boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] setParams() {
        return new Object[][]{
                {"Самка", false},
                {"Самец", true},
        };
    }

    @Test
    public void doesHaveMane() throws Exception {
        feline = new Feline(); // Инициализирована feline
        lion = new Lion(feline, sex); // Передан feline в конструктор Lion

        assertEquals(hasMane, lion.doesHaveMane());
    }
}


