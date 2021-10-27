package com.anish.calabashbros;
import java.awt.Color;

public class Player extends Creature{
    private int xPos;
    private int yPos;
    public Player(Color color, World world, int xPos, int yPos) {
        super(color, (char) 2, world);
        this.xPos = xPos;
        this.yPos = yPos;
    }
    public int getxPos(){
        return xPos;
    }
    public int getyPos(){
        return yPos;
    }
    public void setxPos(int xPos){
        this.xPos = xPos;
    }
    public void setyPos(int yPos){
        this.yPos = yPos;
    }
    
    public void changes(){
        switch(this.getGlyph()){
            case (char) 2://smile
                this.glyph=(char)1;
                break;
            case (char) 1:
                this.glyph=(char)3;
                break;
            case (char) 3:
                this.glyph=(char)4;
                break;
            case (char) 4:
                this.glyph=(char)5;
                break;
            case (char) 5:
                this.glyph=(char)6;
                break;
            case (char) 6:
                this.glyph=(char)11;
                break;
            case (char) 11:
                this.glyph=(char)12;
                break;
            case (char) 12:
                this.glyph=(char)13;
                break;
            case (char) 13:
                this.glyph=(char)14;
                break;
            case (char) 14:
                this.glyph=(char)15;
                break;
            case (char) 15:
                this.glyph=(char)2;
                break;
            default:
            this.glyph=(char) 2 ;
                break;
            }
    }
}