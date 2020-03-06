import robocode.*;
import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * Roomba - a robot by (your name here)
 */
public class Roomba extends AdvancedRobot
{
	/**
	 * run: Roomba's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		setColors(Color.yellow,Color.yellow,Color.blue); // body,gun,radar
		setAdjustRadarForRobotTurn(true);

		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			//ahead(100);
			//turnGunRight(360);
			//back(200);
			//turnGunRight(360);
			turnRadarRight(360);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		setTurnRadarRight(getHeading() - getRadarHeading() + e.getBearing());
		setTurnRight(e.getBearing());
		if (e.getDistance() > 200) {
			setAhead(200);
		} else if (e.getDistance() > 100) {
			fire(1);
		} else {
			fire(2);
		}
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		//back(10);
	}
	
	public void onHitRobot(HitRobotEvent e) {
		
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		//back(20);
	}	
}
