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
		setColors(Color.yellow,Color.yellow,Color.blue);
		setAdjustRadarForRobotTurn(true);

		// Robot main loop
		while(true) {
			// scan the shit out of the map roomba!
			turnRadarRight(360);
		}	
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		if (e.getName().contains("Dumle") || e.getName().contains("BackstabbinBiatch")) {
			return;
		}
		
		setTurnRadarRight(getHeading() - getRadarHeading() + e.getBearing());
		setTurnRight(e.getBearing());
		if (e.getDistance() > 150) {
			setAhead(100);
		} else if (e.getDistance() > 100) {
			fire(1);
		} else if (e.getDistance() > 50) {
			fire(2);
		} else {
			fire(5);
		}
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Nothing here mate
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// No need to do anything here
	}	
}
