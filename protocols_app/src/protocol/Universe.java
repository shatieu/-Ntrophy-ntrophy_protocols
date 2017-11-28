/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocol;

import java.util.ArrayList;
import protocol.enums.Action;
import protocol.enums.Attributes;
import protocol.exceptions.InvalidObjectException;
import protocol.objects.Asteroid;
import protocol.objects.SpaceObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import protocol.exceptions.InvalidActionException;
import protocol.objects.Planet;
import protocol.objects.Ship;

/**
 *
 * @author Ondrej Urbanovsky
 */
public class Universe {
    private Map <Integer, SpaceObject> objects = new HashMap<>();
    private int ID = 0;
    
    /**
     * creates first 5 testing objects
     * @throws InvalidObjectException wont actually do it...
     */
    public Universe(){
            
            //obj 1 asteroid
            List <Attributes> astAttr = new ArrayList<>();
            List <Attributes> astmissing = new ArrayList<>();
            astAttr.add(Attributes.RESOURCES);
            CreateObj(Type.ASTEROID, astAttr, astmissing);

            // obj 2 enemy live ship
            List <Attributes> enship = new ArrayList<>();
            List <Attributes> enshipmiss = new ArrayList<>();
            enship.add(Attributes.RESOURCES);
            enship.add(Attributes.LIFE);
            enship.add(Attributes.WEAPONS);
            enship.add(Attributes.ACT_WEAPON);
            enship.add(Attributes.COMUNICATES);
            CreateObj(Type.SHIP, enship, enshipmiss);

            // obj 3 anship
            List <Attributes> anship = new ArrayList<>();
            List <Attributes> anshipmiss = new ArrayList<>();
            anship.add(Attributes.WEAPONS);
            anship.add(Attributes.ACT_WEAPON);
            anship.add(Attributes.COMUNICATES);
            anship.add(Attributes.RESOURCES);
            anship.add(Attributes.BIGGER);
            CreateObj(Type.SHIP, anship, anshipmiss);

            // obj 4 vrak
            List <Attributes> vrak = new ArrayList<>();
            vrak.add(Attributes.WEAPONS);
            vrak.add(Attributes.BIGGER);
            vrak.add(Attributes.RESOURCES);
            CreateObj(Type.SHIP, vrak, anshipmiss);

            // obj 5 planet
            List <Attributes> planet = new ArrayList<>();
            planet.add(Attributes.RESOURCES);
            planet.add(Attributes.LIFE);
            planet.add(Attributes.COMUNICATES);
            planet.add(Attributes.BIGGER);
            CreateObj(Type.PLANET, planet, anshipmiss);
            
    }

    public Map<Integer, SpaceObject> getObjects() {
        return objects;
    }

    public int getID() {
        return ID;
    }
    
    
    /**
     * creates specified object
     * @param type enum Type
     * @param attrs attributes that are true
     * @param missing attributes that are missing
     * @return id of object upon success else -1;
     * @throws InvalidObjectException 
     */
    public final int CreateObj (Type type, List<Attributes> attrs, List<Attributes> missing){
    
        try{
            switch (type){
                case ASTEROID:{
                        objects.put(ID, new Asteroid(attrs,missing));
                        ID++;
                        break;
                }
                case PLANET:{
                        objects.put(ID, new Planet(attrs,missing));
                        ID++;
                        break;
                }
                case SHIP:{
                        objects.put(ID, new Ship(attrs,missing));
                        ID++;
                        break;
                }
            }
        } catch(InvalidObjectException e) {
        return -1;
        }
        return ID;
    }
    
    /**
     * removes object with spec ID (cant erase object created in constructor ID<4)
     * @param objectID 
     * @return  true upon succes 
     */
    public boolean removeObj (int objectID){
        if(objectID < 4){
            return false;
        }
        objects.remove(objectID);
        return true;
    }
    
    /**
     * Does action on specified obj.
     * @param action enum action
     * @param objectID int ID
     * @return String Body za action + int  
     */
    public String evalAction(Action action, int objectID){
        try{
            switch(action){
                case CONTACT:{
                    return "Body za kontaktování: " + objects.get(objectID).doAction(action);
                }
                case ESCAPE:{
                    return "Body za útěk: " + objects.get(objectID).doAction(action);
                }
                case FLYBY:{
                    return "Body za průlet: " + objects.get(objectID).doAction(action);
                }
                case GATHER_RESOURCES:{
                    return "Body za těžbu zdrojů: " + objects.get(objectID).doAction(action);
                }
                case SHOOT:{
                    return "Body za střílení: " + objects.get(objectID).doAction(action);
                }
                case TRADE:{
                    return "Body za obchodování: " + objects.get(objectID).doAction(action);
                }

            }
        } catch(InvalidActionException e){
            return "Nelze vyhodnotit není specifikováno dostatek atributů";
        }
        return "";
    }
   
    /**
     * asks object question Question is specified with same enum as attribute
     * @param attribute enum attribute
     * @param objectID id
     * @return t/f
     */
    public boolean ask (Attributes attribute, int objectID){
        try{
            switch (attribute){
                    case LIFE: {
                        return objects.get(objectID).isLife();
                    }
                    case COMUNICATES:{
                        return objects.get(objectID).isComunicates();
                    }
                    case BIGGER: {
                        return objects.get(objectID).isBigger();
                    }
                    case ACT_WEAPON:{
                        return objects.get(objectID).isActWeapons();
                    }
                    case WEAPONS:{
                        return objects.get(objectID).isWeapons();
                    }
                    case RESOURCES:{
                        return objects.get(objectID).isResources();
                    }
                    case FAST: {
                        return objects.get(objectID).isFast();
                    }
            }
            return false;
        }catch (NullPointerException e){
            return false;
        }
    }
}
