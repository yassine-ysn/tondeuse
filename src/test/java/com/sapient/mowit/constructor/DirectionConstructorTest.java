package com.sapient.mowit.constructor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionConstructorTest {

    DirectionConstructor directionConstructor = new DirectionConstructor();

    @Test
    void contructDirectionEast() {
        assertEquals('E', directionConstructor.contructDirection('E').getSymbol());
    }
    @Test
    void contructDirectionWeast() {
        assertEquals('W', directionConstructor.contructDirection('W').getSymbol());
    }
    @Test
    void contructDirectionSouth() {
        assertEquals('S', directionConstructor.contructDirection('S').getSymbol());
    }
    @Test
    void contructDirectionNorth() {
        assertEquals('N', directionConstructor.contructDirection('N').getSymbol());
    }
}