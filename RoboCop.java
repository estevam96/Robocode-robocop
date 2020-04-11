package Cop;
import robocode.*;
import static robocode.util.Utils.normalRelativeAngleDegrees;
//import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * RoboCop - a robot by (your name here)
 */
public class RoboCop extends Robot
{
	/**
	 * run: RoboCop's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		// setColors(Color.red,Color.blue,Color.green); // body,gun,radar

		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			ahead(100);
			turnGunRight(360);
			back(75);
			turnGunRight(360);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		double distance = e.getDistance();
		if(distance > 800){
			fire(1);
		} 
		else if (distance > 600 && distance <= 600){
			fire(1);
		} else if(distance > 400 && distance <= 600){
			fire(1);
		} else if (distance > 200 && distance <= 400){
			 fire(2);
		} else if (distance < 200){
			turnGunRight(e.getBearing());
			fire(3);
			back(100);
		}
		scan();
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		turnRight(normalRelativeAngleDegrees(90 - (getHeading() - e.getHeading())));
		ahead(100);
		fire(1);
		back(100);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		double bearing = e.getBearing();
		turnRight(-bearing);
		ahead(100);
	}	
}
