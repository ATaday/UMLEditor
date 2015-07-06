package Buttons;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import Classes.ClassList;
import Default.Global;
import Default.Gui;
import Objects.Function;
import Objects.Variable;

public class ChangeButton extends JButton {
	private static final long serialVersionUID = 1L;

	Gui gui = null;

	public ChangeButton(final Gui inGui) {
		super();

		this.gui = inGui;

		this.setAction(new AbstractAction() {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				if (ClassList.Get().GetCurrentChosen() != -1) {
					Classes.Class currentClass = ClassList.Get().get(ClassList.Get().GetCurrentChosen());

					if (currentClass != null) {
						if (gui.GetClassNameText().equals("") == false) {
							currentClass.SetClassName(gui.GetClassNameText());
						}
						if (gui.GetVarNameText().equals("") == false) {
							boolean found = false;
							for (int i = 0; i < currentClass.GetVariableSize(); i++) {
								if (currentClass.GetVariable(i).GetVariableName().equals(gui.GetVarNameText())) {
									found = true;
									break;
								}
							}

							if (!found && gui.GetVarTypeText().equals("") == false) {
								currentClass.AddNewVariable(new Variable(gui.GetVarNameText(), gui.GetVarTypeText(),
										gui.VarVisibilityButton_1().GetVisibility()));
							}
						}
						if (gui.GetFuncNameText().equals("") == false) {
							Function foundFunc = null;
							for (int i = 0; i < currentClass.GetFunctionSize(); i++) {
								if (currentClass.GetFunction(i).GetFunctionName().equals(gui.GetFuncNameText())) {
									foundFunc = currentClass.GetFunction(i);
									break;
								}
							}

							if (foundFunc == null) {
								currentClass.AddNewFunction(new Function(gui.GetFuncNameText(), gui
										.GetFuncReturnTypeText(), new ArrayList<Variable>(), gui
										.VarVisibilityButton_1().GetVisibility()));
							}
						}
					}
				}

				if (Global.activeTab != null) {
					inGui.SetCodeAreaText(Global.activeTab.GetFileTab().GetAdapter().GetCodeOfClass());
				}
			}
		});
		this.setIcon(new ImageIcon("img/change.jpg"));
	}
}
