package Elements;

import Panels.UmlPanel;

public class Element_Interface extends Element {
	public Element_Interface(int src, int dest) {
		super(src, dest);
	}

	public void GraphicalSetup() {
		super.GraphicalSetup();

		UmlPanel.Get().DrawInterfaceLine(closestPorts[1].x, closestPorts[1].y, closestPorts[0].x, closestPorts[0].y);
	}
}
