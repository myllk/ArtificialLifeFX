/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artificiallifefx;

/**
 *
 * @author James
 */
public abstract class ALifeform extends AnEntity {
    protected int energy;
    protected boolean alive;
    protected AWorld.Direction foodDirection;
    
    ALifeform(){
        super();
        energy = 0;
        alive = true;
    }
    
    ALifeform(String speciesIn, char symbolIn, int xPosIn, int yPosIn, int energyIn, int IDIn, AWorld iWorld){
        super(speciesIn, symbolIn, xPosIn, yPosIn, IDIn, iWorld);
        energy = energyIn;
        alive = true;
    } 
    
    public int getEnergy(){
        return energy;
    }
    public void setEnergy(int iEnergy){
        energy = iEnergy;
    }
    
    public void decEnergy(){
        energy--;
    }
    
    public boolean getAlive(){
        return alive;
    }    
    public void setAlive(boolean iAlive){
        alive = iAlive;
    }
    
    public AWorld.Direction getFoodDirection(){
        return foodDirection;
    }
    public void setFoodDirection(AWorld.Direction newFoodDirection){
        foodDirection = newFoodDirection;
    }
    
    public abstract void packCheck();
    
    public int smellFood(AWorld.Direction D, int range){
        switch (D){
            case north:
                for (int i = 1; i <= range; i++) { //for a set smell range
                    if (world.isFood(xPos, yPos-i)){ //smell north in increments 
                        foodDirection = AWorld.Direction.north;
                        return i;
                    }
                }
                return 99;
            case south:
                for (int i = 1; i <= range; i++) { //for a set smell range
                    if (world.isFood(xPos, yPos+i)){ //smell south in increments 
                        foodDirection = AWorld.Direction.south;
                        return i;
                    }
                }
                return 99;
            case east:
                for (int i = 1; i <= range; i++) { //for a set smell range
                    if (world.isFood(xPos+i, yPos)){ //smell east in increments 
                        foodDirection = AWorld.Direction.east;
                        return i;
                    }
                }
                return 99;
            case west:
                for (int i = 1; i <= range; i++) { //for a set smell range
                    if (world.isFood(xPos-i, yPos)){ //smell west in increments 
                        foodDirection = AWorld.Direction.west;
                        return i;
                    }
                }
                return 99;
        }
        return 99;
    }
    
    public String entToText(){ //return all the attributes in one string
        String attributes = "\nSpecies: " + species + "\nSymbol : " + symbol + "\nxPosition: " + xPos + "\nyPosition: " + yPos + "\nEnergy: " + energy + "\nAlive: " + alive + "\nID: " + ID;
        return attributes;
    }

}
