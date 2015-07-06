package Default;

public class Global {
	public static final String TITLE = "UML Editor";

	public static final int WIDTH = 1366;
	public static final int HEIGHT = 768;

	public static final int DIAGRAM_WIDTH = 200;
	public static final int DIAGRAM_HEIGHT = 200;

	public static final double ARROW_HEIGHT = 20;
	public static final double ARROW_WIDTH = 20;

	public static final int NO_CONNECTION = -1;
	public static final int AGGREGATION_BASE = 1;
	public static final int AGGREGATION_PARENT = 2;
	public static final int AGGREGATION_CHILD = 3;
	public static final int INHERITANCE_BASE = 4;
	public static final int INHERITANCE_PARENT = 5;
	public static final int INHERITANCE_CHILD = 6;
	public static final int INTERFACE_BASE = 7;
	public static final int INTERFACE_PARENT = 8;
	public static final int INTERFACE_CHILD = 9;

	public static int ClassNo = 0;

	public static Classes.Class activeTab = null;

	public static int totalConnection = 0;

	public static java.awt.Point[] FindClosestPort(Classes.Class portOf, Classes.Class withWhom) {
		java.awt.Point[] result = new java.awt.Point[2];
		for (int i = 0; i < 2; i++) {
			result[i] = new java.awt.Point();  // 2 nokta belirledik
		}

		int previousDistance = -1;

		if (portOf != null && withWhom != null) {
			int[][] distances = new int[4][4];

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					distances[i][j] = (int) Math.sqrt(Math.abs(Math.pow((portOf.GetPort(i).x - withWhom.GetPort(j).x),
							2)) + Math.abs(Math.pow((portOf.GetPort(i).y - withWhom.GetPort(j).y), 2)));

					if (previousDistance == -1) {
						previousDistance = distances[i][j];
					} else {
						if (previousDistance > distances[i][j]) {
							previousDistance = distances[i][j];

							result[0] = portOf.GetPort(i);
							result[1] = withWhom.GetPort(j);
						}
					}
				}
			}
		}
		return result;
	}
}
