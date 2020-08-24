package com.sapient.mowit.constructor;

import com.sapient.mowit.model.Mower;

public class MowerConstructor {

    public Mower contructMower(char[] position) throws Exception{
        if(position.length != 3) throw new Exception("Failed to construct a mower");
        int x = Character.getNumericValue(position[0]);
        int y = Character.getNumericValue(position[1]);
        return new Mower(x,y, new DirectionConstructor().contructDirection(position[2]));
    }
}
