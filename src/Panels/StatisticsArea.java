package Panels;

import javax.swing.JTextArea;

import Classes.ClassList;
import Default.Global;

public class StatisticsArea extends JTextArea {
	private static final long serialVersionUID = 1L;

	private static StatisticsArea instance = null;

	private StatisticsArea() {
		super();

		this.setEditable(false);
	}

	public static StatisticsArea Get() {
		if (instance == null) {
			instance = new StatisticsArea();
		}
		return instance;
	}

	public void UpdateStatistics() {
		String result = "STATISTICS\n\n";
		result += "Total " + ClassList.Get().size() + " Classes \n";
		result += "Total " + Global.totalConnection + " Connections \n";

		int numberOfInheritance = 0;
		int numberOfAggregation = 0;
		int numberOfInterface = 0;

		Classes.Class currentClass = null;
		for (int i = 0; i < ClassList.Get().size(); i++) {
			currentClass = ClassList.Get().get(i);

			if (currentClass != null) {
				if (currentClass.connectionMethods.contains(Global.INHERITANCE_CHILD)
						|| currentClass.connectionMethods.contains(Global.INHERITANCE_PARENT)) {
					numberOfInheritance++;
				}
				if (currentClass.connectionMethods.contains(Global.INTERFACE_CHILD)
						|| currentClass.connectionMethods.contains(Global.INTERFACE_PARENT)) {
					numberOfInterface++;
				}

				numberOfAggregation += currentClass.GetAggregatedFromSize();
			}
		}

		result += "Total " + numberOfInheritance + " Inheritance \n";
		result += "Total " + numberOfAggregation + " Aggregation \n";
		result += "Total " + numberOfInterface + " Interface \n";

		this.setText(result);
	}
}
