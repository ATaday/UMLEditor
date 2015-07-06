package Elements;

import Panels.UmlPanel;

public class Element_Inheritance extends Element {
	public Element_Inheritance(int child, int parent) {
		super(child, parent);
	}

	public void GraphicalSetup() {
		super.GraphicalSetup();

		UmlPanel.Get().DrawInheritanceLine(closestPorts[1].x, closestPorts[1].y, closestPorts[0].x, closestPorts[0].y);
	}
}
