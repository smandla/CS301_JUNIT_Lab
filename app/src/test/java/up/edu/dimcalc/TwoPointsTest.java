package up.edu.dimcalc;

import android.graphics.Point;

import org.junit.Test;

import static org.junit.Assert.*;

public class TwoPointsTest {

    /** when created, getPoint() should show both points at the origin */
    @Test
    public void getPoint() throws Exception{
        TwoPoints testPoints = new TwoPoints();
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(p1.x, 0);
        assertEquals(p1.y, 0);
        assertEquals(p2.x, 0);
        assertEquals(p2.y, 0);
    }

    /** verify that arbitrary values are properly stored via setPoint() */
    @Test
    public void setPoint() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 5, -3);
        testPoints.setPoint(1, -3, 5);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(p1.x, 5);
        assertEquals(p1.y, -3);
        assertEquals(p2.x, -3);
        assertEquals(p2.y, 5);
    }


    @Test
    public void randomValue() {

        //create Instance of TwoPoints class
        TwoPoints testPoints = new TwoPoints();
        testPoints.randomValue(0);
        testPoints.randomValue(1);

        Point point1 = testPoints.getPoint(0);
        Point point2 = testPoints.getPoint(1);

        //this test fails when it's compared with 10
        assertTrue(point1.x > -10 && point1.x < 10 && point1.y > -10 && point1.y < 10);

        //this test fails when it's compared with 10
        assertTrue(point2.x > -10 && point2.x < 10 && point2.y > -10 && point2.y < 10);


    }

    @Test
    public void setOrigin() {
        //create Instance of TwoPoints class
        TwoPoints testPoints = new TwoPoints();
        testPoints.setOrigin(0);

        Point point1 = testPoints.getPoint(0);

        //these tests pass
        assertEquals(point1.x, 0);
        assertEquals(point1.y, 0);
    }

    @Test
    public void copy() {
        //create Instance of TwoPoints class
        TwoPoints testPoints = new TwoPoints();

        testPoints.setPoint(0,3,-4);
        testPoints.setPoint(1,-6,4);

        testPoints.copy(0,1);

        Point point1 = testPoints.getPoint(0);
        Point point2 = testPoints.getPoint(1);

        assertEquals(point1.x, 3);
        assertEquals(point1.y, -4);
        assertEquals(point2.x, 3);
        assertEquals(point2.y, -4);
    }

    @Test
    public void distance() {
        //create Instance of TwoPoints class
        TwoPoints testPoints = new TwoPoints();

        testPoints.setPoint(0,3,-5);
        testPoints.setPoint(1,-6,2);

        double distance = testPoints.distance();

        //test fails
        assertEquals(11, distance, 0.02);

    }

    @Test
    public void slope() {
        //create Instance of TwoPoints class
        TwoPoints testPoints = new TwoPoints();

        testPoints.setPoint(0,3,-5);
        testPoints.setPoint(1,3,-5);

        double zeroSlope = testPoints.slope();

        //test fails
        assertEquals(0, zeroSlope,0);

        testPoints.setPoint(0,3,-5);
        testPoints.setPoint(1,-6,2);

        double testSlope = testPoints.slope();
        assertEquals(-1.0,testSlope,  0.01);
    }
}