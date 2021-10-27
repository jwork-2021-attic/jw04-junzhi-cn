package com.anish.screen;

import java.awt.Color;
import java.awt.event.KeyEvent;
import com.anish.calabashbros.World;
import com.anish.calabashbros.Player;
import com.anish.calabashbros.Thing;
import com.anish.calabashbros.Wall;
import com.anish.calabashbros.Floor;
import generator.MazeGenerator;

import asciiPanel.AsciiPanel;

public class WorldScreen implements Screen {

    private World world;
    private Player player;
    private int[][] maze;
    public static final int LEN = 20;

    public WorldScreen() {
        MazeGenerator mazeGenerator = new MazeGenerator(LEN);
        mazeGenerator.generateMaze();
        maze = mazeGenerator.getMaze();
        world = new World();
        player = new Player(Color.WHITE, world, 0, 0);
        world.put(player, 0, 0);
    }

    private void showPath()
    {
        for(int i = 0; i < maze.length; i++){
            for(int j = 0; j < maze[0].length; j++){
                if(maze[i][j] == 1 && world.get(i, j).getGlyph()==((char) 250)){
                        world.put(new Thing(world.get(i, j).getColor(), (char) 9, world), i, j);
                }
            }
        }
    }
    private void disPath()
    {
        for(int i = 0; i < maze.length; i++){
            for(int j = 0; j < maze[0].length; j++){
                if(maze[i][j] == 1 && world.get(i, j).getGlyph()==((char) 9)){
                    if( world.get(i, j).getColor()==Color.GRAY)
                    {
                        world.put(new Floor(world), i, j);
                    }
                    else
                    {
                        world.put(new Thing(world.get(i, j).getColor(), (char) 250, world), i, j);
                    }
                }
            }
        }
    }
    private boolean isOK(int xPos, int yPos){
        if(xPos >= 0 && xPos < LEN && yPos >= 0 && yPos < LEN && maze[xPos][yPos] != 0){
            return true;
        }
        world.put(new Wall(world), xPos, yPos);
        return false;
    }

    @Override
    public void displayOutput(AsciiPanel terminal) {

        for (int x = 0; x < World.WIDTH; x++) {
            for (int y = 0; y < World.HEIGHT; y++) {
                terminal.write(world.get(x, y).getGlyph(), x, y, world.get(x, y).getColor());

            }
        }
    }

    int i = 0;

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        int xPos = player.getxPos();
        int yPos = player.getyPos();
        switch(key.getKeyCode()){
            case 69://E
                player.changec();
                disPath();
                break;
            case 81://E
                player.changes();
                disPath();
                break;
            case 0x20://space
                showPath();
                break;
            case 0x25://←
                disPath();
                if(isOK(xPos - 1, yPos)){
                    player.moveTo(xPos - 1, yPos);
                    player.setxPos(xPos - 1);
                    player.setyPos(yPos);
                }
                break;
            case 0x26://↑
                disPath();
                if(isOK(xPos, yPos - 1)){
                    player.moveTo(xPos, yPos - 1);
                    player.setxPos(xPos);
                    player.setyPos(yPos - 1);
                }
                break;
            case 0x27://→
                disPath();
                if(isOK(xPos + 1, yPos)){
                    player.moveTo(xPos + 1, yPos);
                    player.setxPos(xPos + 1);
                    player.setyPos(yPos);
                }
                break;
            case 0x28://↓
                disPath();
                if(isOK(xPos, yPos + 1)){
                    player.moveTo(xPos, yPos + 1);
                    player.setxPos(xPos);
                    player.setyPos(yPos + 1);
                }
                break;
            default:
                disPath();
                break;
        }
        return this;
    }

}
