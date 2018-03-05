package impl.robot;

import java.util.Map;

import interfaces.Robot;
import interfaces.RobotCollection;

public class T1000Collection implements RobotCollection {

	Map<Integer, Robot> robotsMap;

	public T1000Collection() {
	}

	public T1000Collection(Map<Integer, Robot> robotsMap) {
		this.robotsMap = robotsMap;
	}

	public void setRobotsMap(Map<Integer, Robot> robotsMap) {
		this.robotsMap = robotsMap;
	}

	@Override
	public Map<Integer, Robot> getRobotsMap() {
		// TODO Auto-generated method stub
		return this.robotsMap;
	}

	public void action() {
		for (Map.Entry<Integer, Robot> a : getRobotsMap().entrySet()) {
			System.out.println(a.getKey().toString());
			a.getValue().action();
		}
	}

}
