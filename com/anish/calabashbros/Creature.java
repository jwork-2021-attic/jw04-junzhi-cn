package com.anish.calabashbros;

import java.awt.Color;

public class Creature extends Thing {

    Creature(Color color, char glyph, World world) {
        super(color, glyph, world);
    }

    public void moveTo(int xPos, int yPos) {
        int px=this.getX();
        int py=this.getY();
        // if (this.world.get(xPos,yPos).getColor()==Color.RED)
        // this.world.put(new Thing(Color.BLUE, (char) 250, world), px, py);
        // else if (this.world.get(xPos,yPos).getColor()==Color.BLUE)
        // this.world.put(new Thing(Color.PINK, (char) 250, world), px, py);
        // else if (this.world.get(xPos,yPos).getColor()==Color.PINK)
        // this.world.put(new Thing(Color.GREEN, (char) 250, world), px, py);
        // else if (this.world.get(xPos,yPos).getColor()==Color.GREEN)
        // this.world.put(new Thing(Color.CYAN, (char) 250, world), px, py);
        // else if (this.world.get(xPos,yPos).getColor()==Color.CYAN)
        // this.world.put(new Thing(Color.BLACK, (char) 250, world), px, py);
        // else 
        this.world.put(new Thing(Color.RED, (char) 250, world), px, py);
        this.world.put(this, xPos, yPos);
    }

}
