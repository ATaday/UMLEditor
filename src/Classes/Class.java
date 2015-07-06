package Classes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import CodeAdapters.FileTab;
import Default.Global;
import Objects.Function;
import Objects.Variable;
import Panels.UmlPanel;

public class Class {
	private Point setupPosition = null;

	public final Point GetSetupPosition() {
		return setupPosition;
	}

	public ArrayList<Integer> connectionMethods = new ArrayList<Integer>();
	public ArrayList<Class> parents = new ArrayList<Class>();
	public ArrayList<Class> children = new ArrayList<Class>();

	private ArrayList<Class> aggregatedFrom = new ArrayList<Class>();

	private String className = "";
	private ArrayList<Function> functions = new ArrayList<Function>();
	private ArrayList<Variable> variables = new ArrayList<Variable>();

	private int classSize = 0;

	private Graphics panelGraphics = null;

	private Point[] portArray;

	public final Point GetPort(int index) {
		if (index >= 0 && index < 4) {
			return portArray[index];
		}
		return new Point();
	}

	public Class(final Point mouseLocation) {
		if (mouseLocation != null) {
			setupPosition = mouseLocation;
			panelGraphics = UmlPanel.Get().getGraphics();

			this.portArray = new Point[4];
			for (int i = 0; i < 4; i++) {
				this.portArray[i] = new Point();
			}

			this.GraphicalSetup(Color.BLACK);
		}
	}

	public void GraphicalSetup() {
		if (setupPosition != null) {
			GraphicalUpdate();

			UpdatePortArray();
		}
	}

	public void GraphicalSetup(final Color newColor) {
		if (setupPosition != null) {
			panelGraphics.setColor(newColor);

			GraphicalUpdate();

			UpdatePortArray();
		}
	}

	public void GraphicalSetup(Point newPosition, final Color newColor) {
		if (newPosition != null) {
			setupPosition = newPosition;
			GraphicalSetup(newColor);
		}
	}

	private void GraphicalUpdate() {
		if (panelGraphics != null) {
			panelGraphics.drawRect(setupPosition.x, setupPosition.y, Global.DIAGRAM_WIDTH, 20);
			panelGraphics.drawRect(setupPosition.x, setupPosition.y + 20, Global.DIAGRAM_WIDTH, Global.DIAGRAM_HEIGHT
					+ classSize - 20);

			panelGraphics.drawString(this.className, setupPosition.x + 15, setupPosition.y + 15);

			int i = 0;
			while (i < variables.size()) {
				ClassSizeControl(i);
				panelGraphics.drawString(variables.get(i).GetStringVersion(), setupPosition.x + 15, setupPosition.y
						+ 15 * (i + 2));
				i++;
			}
			ClassSizeControl(i);

			if (functions.size() > 0) {
				panelGraphics.drawLine(setupPosition.x, setupPosition.y + ((i + 2) * 15), setupPosition.x
						+ Global.DIAGRAM_WIDTH, setupPosition.y + ((i + 2) * 15));
				i++;
			}

			int j = 0;
			while (j < functions.size()) {
				ClassSizeControl(j + i);
				panelGraphics.drawString(functions.get(j).GetFunctionGeneralInfoStringVersion(), setupPosition.x + 15,
						setupPosition.y + 15 * (j + i + 2));
				j++;
			}

		}
	}

	private void ClassSizeControl(int index) {
		if (((index + 2) * 15) > (Global.DIAGRAM_HEIGHT + classSize - 20)) {
			classSize += 15;
			UpdatePortArray();

			ClassList.Get().NotifyScreenChange();
		}
	}

	private void UpdatePortArray() {
		if (setupPosition != null) {
			this.portArray[0].setLocation(setupPosition.x + (Global.DIAGRAM_WIDTH / 2), setupPosition.y);
			this.portArray[1].setLocation(setupPosition.x, setupPosition.y + ((Global.DIAGRAM_HEIGHT + classSize) / 2));
			this.portArray[2].setLocation(setupPosition.x + Global.DIAGRAM_WIDTH, setupPosition.y
					+ ((Global.DIAGRAM_HEIGHT + classSize) / 2));
			this.portArray[3].setLocation(setupPosition.x + (Global.DIAGRAM_WIDTH / 2), setupPosition.y
					+ Global.DIAGRAM_HEIGHT + classSize);
		}
	}

	public String GetClassName() {
		return this.className;
	}

	public void SetClassName(String newClassName) {
		this.className = newClassName;
		ClassList.Get().NotifyScreenChange();
	}

	public void AddNewVariable(Variable variable) {
		if (variable != null) {
			variables.add(variable);
		}
		ClassList.Get().NotifyScreenChange();
	}

	public int GetVariableSize() {
		return variables.size();
	}

	public Variable GetVariable(int i) {
		if (i >= 0 && i < variables.size()) {
			return variables.get(i);
		}
		return null;
	}

	public Function GetFunction(int i) {
		if (i >= 0 && i < functions.size()) {
			return functions.get(i);
		}
		return null;
	}

	public int GetFunctionSize() {
		return functions.size();
	}

	public void AddNewFunction(Function function) {
		if (function != null) {
			functions.add(function);
		}
		ClassList.Get().NotifyScreenChange();
	}

	public void AddVariableToFunction(Classes.Class currentClass, String functionName, String variableName,
			String variableType) {
		if (currentClass != null) {
			Function currentFunction = null;
			for (int i = 0; i < currentClass.GetFunctionSize(); i++) {
				if (currentClass.GetFunction(i).GetFunctionName().equals(functionName)) {
					currentFunction = currentClass.GetFunction(i);
					break;
				}
			}

			if (currentFunction != null) {
				currentFunction.GetFunctionParameterList().add(new Variable(variableName, variableType, false));
				ClassList.Get().NotifyScreenChange();
			}
		}
	}

	public void AddAggregatedFrom(Class from) {
		if (aggregatedFrom.contains(from) == false) {
			aggregatedFrom.add(from);
		}
	}

	public Class GetAggregatedFrom(int i) {
		if (i >= 0 && i < aggregatedFrom.size()) {
			return aggregatedFrom.get(i);
		}
		return null;
	}

	public int GetAggregatedFromSize() {
		return aggregatedFrom.size();
	}

	private FileTab fileTab = null;

	public void SetFileTab(FileTab newTab) {
		fileTab = newTab;
	}

	public FileTab GetFileTab() {
		return fileTab;
	}
}
