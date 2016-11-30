package org.CoreNight.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brennan on 11/17/2016.
 */
public class EntityManager {
    private static List<Entity> entityList = new ArrayList<>();

    public static void put(Entity entity){
        entityList.add(entity);
    }
    public static void updateEntities(){
        for(Entity e : entityList){
            e.update();
        }
    }
    public static void drawEntities(){
        for(Entity e : entityList){
            e.draw();
        }
    }
}
