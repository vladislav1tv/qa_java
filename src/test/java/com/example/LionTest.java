package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    private Lion lion;

    @Mock
    private Feline feline;

    @Test
    public void getKittensWithoutArgumentReturnOne() throws Exception {
        lion = new Lion(feline, "Самка");
        Mockito.when(feline.getKittens()).thenReturn(1);
        int defaultKittensValue = 1;

        assertEquals(defaultKittensValue, lion.getKittens());
    }

    @Test
    public void lionConstructorWrongSexReturnError() {
        Exception exception = assertThrows(Exception.class, () -> {
            lion = new Lion(feline, "Гермафродит");
        });

        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @Test
    public void getFoodReturnPredatorFood() throws Exception {
        lion = new Lion(feline, "Самка");
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);

        assertEquals(expectedFood, lion.getFood());
    }
}
