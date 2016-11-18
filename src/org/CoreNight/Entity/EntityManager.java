package org.CoreNight.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brennan on 11/17/2016.
 */
public class EntityManager {
    private static List<Entity> entityList = new ArrayList<>();

    public void updateEntities(){
        for(Entity e : entityList){
            e.x *= e.dX;
            e.y *= e.dY;
            e.dY = 1; e.dX = 1;
        }
    }
}
