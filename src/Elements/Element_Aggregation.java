package Elements;

import Panels.UmlPanel;

public class Element_Aggregation extends Element {
	public Element_Aggregation(int child, int parent) {
		super(child, parent);
	}

	public void GraphicalSetup() {
		super.GraphicalSetup();

		UmlPanel.Get().DrawAggregationLine(closestPorts[1].x, closestPorts[1].y, closestPorts[0].x, closestPorts[0].y);
	}
}
