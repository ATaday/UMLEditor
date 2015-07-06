package Elements;

import java.awt.Graphics;
import java.awt.Point;

import Classes.ClassList;
import Default.Global;
import Panels.UmlPanel;

public class Element {
	protected int sourceIndex = -1;
	protected int destinationIndex = -1;
	
	protected Point[] closestPorts;

	protected Graphics panelGraphics = null;

	public Element(final int src, final int dest) {
		sourceIndex = src;
		destinationIndex = dest;

		panelGraphics = UmlPanel.Get().getGraphics();

		if (src != -1 && dest != -1 && src != dest) {
			GraphicalSetup();
		}
	}

	public void GraphicalSetup() {
		closestPorts = Global.FindClosestPort(ClassList.Get().get(destinationIndex), ClassList.Get().get(sourceIndex));
	}
}
