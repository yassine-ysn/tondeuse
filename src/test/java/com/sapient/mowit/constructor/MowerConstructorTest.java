package com.sapient.mowit.constructor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MowerConstructorTest {


    MowerConstructor mowerConstructor = new MowerConstructor();

    @Test
    void contructMower() throws Exception {
        assertEquals(1, mowerConstructor.contructMower(new char[]{'1','2','N'}).getX());
        assertEquals(2, mowerConstructor.contructMower(new char[]{'1','2','N'}).getY());
        assertEquals('N', mowerConstructor.contructMower(new char[]{'1','2','N'}).getDirection().getSymbol());
    }

    @Test
    void contructMower_should_throw_exception_when_constructing_mower() throws Exception {
        String expectedMessage = "Failed to construct a mower";
        Exception exception = assertThrows(Exception.class, () -> {
           mowerConstructor.contructMower(new char[]{'1','3','2','N'}).getX();
        });
        assertTrue(exception.getMessage().contains(expectedMessage));

    }
}