package com.anish.calabashbros;

import java.awt.Color;

public class Thing {

    protected World world;

    public Tile<? extends Thing> tile;

    public int getX() {
        return this.tile.getxPos();
    }

    public int getY() {
        return this.tile.getyPos();
    }

    public void setTile(Tile<? extends Thing> tile) {
        this.tile = tile;
    }

    public Thing(Color color, char glyph, World world) {
        this.color = color;
        this.glyph = glyph;
        this.world = world;
    }

    protected Color color;

    public Color getColor() {
        return this.color;
    }

    protected char glyph;

    public char getGlyph() {
        return this.glyph;
    }
    public void changec(){
        int r=(int) (System.currentTimeMillis()%(256));

        try { 
            Thread.sleep(100);
         } catch (Exception e) { 
             System.out.println("err"); 
         }
        int g=(int) (System.currentTimeMillis()%(256));

        try { 
            Thread.sleep(100);
         } catch (Exception er) { 
             System.out.println("err"); 
         }
        int b=(int) (System.currentTimeMillis()%(256));
        this.color=new Color(r, g, b);
    }
}
