package com.zipcodeconway;

import java.util.Random;

public class ConwayGameOfLife {

    Integer dimension = 1;
    int[][] world;
    int[][] nextWorld;
    SimpleWindow window;

    public ConwayGameOfLife(Integer dimension) {
        this.dimension = dimension;
        this.world = createRandomStart(dimension);
        window = new SimpleWindow(dimension);
        window.display(world, dimension);
     }

    public ConwayGameOfLife(Integer dimension, int[][] startmatrix) {
        this.dimension = dimension;
        this.world = startmatrix;
        window = new SimpleWindow(dimension);
        window.display(world, dimension);
    }

    public static void main(String[] args) {
        ConwayGameOfLife sim = new ConwayGameOfLife(100);
        sim.simulate(100);
    }

    private int[][] createRandomStart(Integer dimension) {
        int[][] start = new int[dimension][dimension];

        for (int row = 0; row < dimension; row++) {
            for (int col = 0; col < dimension; col++) {
                start[row][col] = (int) (Math.random()+0.1);
            }
        }
        return start;
    }

    public int[][] simulate(Integer maxGenerations) {
        int[][] newWorld = new int[dimension][dimension];
        for (int i = 0; i <= maxGenerations; i++) {
            newWorld = createNextWorld(dimension, world);
            copyAndZeroOut(newWorld);
            window.display(world, i);
            window.sleep(150);
        }
        return newWorld;
    }


    public void copyAndZeroOut(int [][] replacementWorld) {
        this.world = replacementWorld;
        this.nextWorld = new int[world.length][world.length];

    }

    public int[][] createNextWorld(int dimension, int[][] currentWorld) {
        nextWorld = new int[dimension][dimension];
        for (int row = 0; row < dimension; row++) {
            for (int col = 0; col < dimension; col++) {
                int liveNeighbors = isAlive(row, col, currentWorld);
                if(currentWorld[row][col] == 1 && liveNeighbors == 2) {
                    nextWorld[row][col] = 1;
                }
                if(liveNeighbors == 3) {
                    nextWorld[row][col] = 1;
                }
            }
        }

        return nextWorld;
    }

    public int isAlive(int row, int col, int[][] world) {
        int liveNeighbors = -(world[row][col]);
        int[] miniRows = setMiniRows(row, world.length);
        int[] miniCols = setMiniCols(col, world.length);

        for (int indexRow : miniRows) {
            for (int indexCol : miniCols) {
                    liveNeighbors += world[indexRow][indexCol];
            }
        }

        return liveNeighbors;
    }

    public int[] setMiniRows(int row, int worldLength) {
        int[] miniRows = {row - 1, row, row + 1};
        if(row == 0) {
            miniRows[0] = worldLength - 1;
        }
        if(row == worldLength - 1) {
            miniRows[2] = 0;
        }
        return miniRows;
    }

    public int[] setMiniCols(int col, int worldLength) {
        int[] miniCols = {col - 1, col, col + 1};
        if(col == 0) {
            miniCols[0] = world.length - 1;
        }

        if(col == world.length - 1) {
            miniCols[2] = 0;
        }
        return miniCols;
    }

}
