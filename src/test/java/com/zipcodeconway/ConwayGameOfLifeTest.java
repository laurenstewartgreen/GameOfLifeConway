package com.zipcodeconway;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConwayGameOfLifeTest {

    @Test
    public void runTest1() {
        int[][] start = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0}};
        int[][] expected = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0}};
        ConwayGameOfLife sim = new ConwayGameOfLife(5, start);
        int[][] actual = sim.simulate(9);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void runTest2() {
        int[][] start = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}};
        int[][] expected = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0}};
        ConwayGameOfLife sim = new ConwayGameOfLife(5, start);
        int[][] results = sim.simulate(10);
        assertTrue(java.util.Arrays.deepEquals(results, expected));
    }

    @Test
    public void setMiniColMiddleCellTest() {
        ConwayGameOfLife sim = new ConwayGameOfLife(8);
        int[] expected = {2,3,4};
        int[] actual = sim.setMiniCols(3,8);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void setMiniColEdgeCellTest() {
        ConwayGameOfLife sim = new ConwayGameOfLife(8);
        int[] expected = {7,0,1};
        int[] actual = sim.setMiniCols(0,8);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void setMiniColEdgeCell2Test() {
        ConwayGameOfLife sim = new ConwayGameOfLife(8);
        int[] expected = {6,7,0};
        int[] actual = sim.setMiniCols(7,8);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void setMiniRowMiddleCellTest() {
        ConwayGameOfLife sim = new ConwayGameOfLife(8);
        int[] expected = {2,3,4};
        int[] actual = sim.setMiniRows(3,8);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void setMiniRowEdgeCellTest() {
        ConwayGameOfLife sim = new ConwayGameOfLife(8);
        int[] expected = {7,0,1};
        int[] actual = sim.setMiniRows(0,8);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void setMiniRowEdgeCell2Test() {
        ConwayGameOfLife sim = new ConwayGameOfLife(8);
        int[] expected = {6,7,0};
        int[] actual = sim.setMiniRows(7,8);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void createNextWorldTest() {
        int[][] start = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0}};
        int[][] expected = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}};
        ConwayGameOfLife sim = new ConwayGameOfLife(5, start);
        int[][] results = sim.createNextWorld(5, start);
        assertTrue(java.util.Arrays.deepEquals(results, expected));
    }

    @Test
    public void createNextWorld2Test() {
        int[][] start = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0}};
        int[][] expected = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}};
        ConwayGameOfLife sim = new ConwayGameOfLife(5, start);
        int[][] actual = sim.createNextWorld(5, start);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void isAliveTest() {
        int[][] start = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0}};
        int expected = 0;
        ConwayGameOfLife sim = new ConwayGameOfLife(5, start);
        int actual = sim.isAlive(0, 0, start);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isAliveTest2() {
        int[][] start = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0}};
        int expected = 2;
        ConwayGameOfLife sim = new ConwayGameOfLife(5, start);
        int actual = sim.isAlive(1, 3, start);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isAliveTest3() {
        int[][] start = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0}};
        int expected = 1;
        ConwayGameOfLife sim = new ConwayGameOfLife(5, start);
        int actual = sim.isAlive(1, 2, start);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isAliveTest4() {
        int[][] start = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0}};
        int expected = 3;
        ConwayGameOfLife sim = new ConwayGameOfLife(5, start);
        int actual = sim.isAlive(2, 3, start);
        Assert.assertEquals(expected, actual);
    }

}