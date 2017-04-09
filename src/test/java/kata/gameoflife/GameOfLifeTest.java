package kata.gameoflife;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class GameOfLifeTest {

    private GameOfLife gameOfLife;

    @Before
    public void init(){
        //initialisation
        gameOfLife = new GameOfLife(4,8);
    }
    @Test
    public void gameOfLifeTest(){
        //1st generation
        gameOfLife.setAlive(1,4);
        gameOfLife.setAlive(2,3);
        gameOfLife.setAlive(2,4);

        System.out.println(gameOfLife);

        gameOfLife.computeNextGeneration();

        System.out.println(gameOfLife);

        String nextGeneration = ". . . . . . . . \n" +
                ". . . * * . . . \n" +
                ". . . * * . . . \n" +
                ". . . . . . . . \n";

        assertEquals(gameOfLife.toString(),nextGeneration);

        //case 2 having more than 3 alive neighbours
        gameOfLife.setAlive(2,5);
        System.out.println(gameOfLife);
        gameOfLife.computeNextGeneration();
        System.out.println(gameOfLife);

        assertEquals(gameOfLife.toString(), ". . . . . . . . \n" +
                ". . . * . . . . \n" +
                ". . . * * . . . \n" +
                ". . . . . . . . \n");

    }

    @Test
    public void getNeighboursLiveCountTest(){
        gameOfLife.setAlive(1,4);
        gameOfLife.setAlive(2,3);
        gameOfLife.setAlive(2,4);
        gameOfLife.setAlive(2,7);

        //Case 1
        assertEquals(gameOfLife.getNeighboursLiveCount(0,0),0);

        //case 2
        assertEquals(gameOfLife.getNeighboursLiveCount(gameOfLife.getNbrOfRows(),gameOfLife.getNbrOfColumns()),0);

        //case 3
        assertEquals(gameOfLife.getNeighboursLiveCount(1,3),3);

        //Case 4
        assertEquals(gameOfLife.getNeighboursLiveCount(2,4),2);

        assertEquals(gameOfLife.getNeighboursLiveCount(1,7),1);


    }
}
