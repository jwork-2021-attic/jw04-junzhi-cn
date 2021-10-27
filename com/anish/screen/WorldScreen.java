package com.anish.screen;

import java.awt.Color;
import java.awt.event.KeyEvent;

import com.anish.calabashbros.BubbleSorter;
import com.anish.calabashbros.Calabash;
import com.anish.calabashbros.World;

import asciiPanel.AsciiPanel;

public class WorldScreen implements Screen {

    private World world;
    private Calabash[][] bros;
    String[] sortSteps;

    public WorldScreen() {
        world = new World();

        bros = new Calabash[16][16];


        int rr=255;
        int gg=255;
        int bb=255;
        int i=0;
        int j=0;
        for(i=0;i<=31;i++)
        {
            if(bb>=8)
                bb=bb-8;
            else
                bb=0;
            bros[j/16][j%16] = new Calabash(new Color(rr, gg, bb), j, world);
            j++;
        }
        for(i=0;i<=31;i++)
        {
            if(rr>=8)
                rr=rr-8;
            else
                rr=0;
                bros[j/16][j%16] = new Calabash(new Color(rr, gg, bb), j, world);
            j++;
        }
        for(i=0;i<=31;i++)
        {
            if(bb<=255-8)
                bb=bb+8;
            else
                bb=255;
                bros[j/16][j%16] = new Calabash(new Color(rr, gg, bb), j, world);
            j++;
        }for(i=0;i<=31;i++)
        {
            if(gg>=8)
                gg=gg-8;
            else
                gg=0;
                bros[j/16][j%16] = new Calabash(new Color(rr, gg, bb), j, world);
            j++;
        }for(i=0;i<=31;i++)
        {
            if(rr<=255-8)
                rr=rr+8;
            else
                rr=255;
                bros[j/16][j%16] = new Calabash(new Color(rr, gg, bb), j, world);
            j++;
        }for(i=0;i<=31;i++)
        {
            if(bb>=8)
                bb=bb-8;
            else
                bb=0;
                bros[j/16][j%16] = new Calabash(new Color(rr, gg, bb), j, world);
            j++;
        }for(i=0;i<=31;i++)
        {
            if(rr>=8)
                rr=rr-8;
            else
                rr=0;
                bros[j/16][j%16] = new Calabash(new Color(rr, gg, bb), j, world);
            j++;
        }
        for(i=0;i<=31;i++)
        {
            if(rr<=255-8)
                rr=rr+8;
            else
                rr=255;
            if(gg<=255-8)
                gg=gg+8;
            else
                gg=255;
            if(bb<=255-8)
            bb=bb+8;
            else
            bb=255;
            bros[j/16][j%16] = new Calabash(new Color(rr, gg, bb), j, world);
            j++;
        }
        int rand;
        for(int k=0;k<256;k++)
        {
            rand=(int) (System.currentTimeMillis()%(256-k));
            Calabash temp=bros[k/16][k%16];
            bros[k/16][k%16]=bros[rand/16][rand%16];
            bros[rand/16][rand%16]=temp;
        }
        for(int k=0;k<256;k++)
        {
            world.put(bros[k/16][k%16], k/16*2, k%16*2);
        }

        BubbleSorter<Calabash> b = new BubbleSorter<>();
        b.load(bros);
        b.sort();

        sortSteps = this.parsePlan(b.getPlan());
    }

    private String[] parsePlan(String plan) {
        return plan.split("\n");
    }

    private void execute(Calabash[][] bros, String step) {
        String[] couple = step.split("<->");
        getBroByRank(bros, Integer.parseInt(couple[0])).swap(getBroByRank(bros, Integer.parseInt(couple[1])));
    }

    private Calabash getBroByRank(Calabash[][] bros, int rank) {
        for (int i=0;i<256;i++) {
            Calabash bro=bros[i/16][i%16];
            if (bro.getRank() == rank) {
                return bro;
            }
        }
        return null;
    }

    @Override
    public void displayOutput(AsciiPanel terminal) {

        for (int x = 0; x < World.WIDTH; x++) {
            for (int y = 0; y < World.HEIGHT; y++) {

                terminal.write(world.get(x, y).getGlyph(), x, y, world.get(x, y).getColor());

            }
        }
    }

    int ii = 0;

    @Override
    public Screen respondToUserInput(KeyEvent key) {

        if (ii < this.sortSteps.length) {
            this.execute(bros, sortSteps[ii]);
            ii++;
        }

        return this;
    }

}
