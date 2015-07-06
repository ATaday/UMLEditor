package Buttons;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;

import Classes.ClassList;
import Default.Global;
import Default.Gui;

public class AddButton extends JButton {
	private static final long serialVersionUID = 1L;

	private Gui gui = null;

	public AddButton(final Gui guiIn) {
		this.gui = guiIn;
		this.setAction(new AbstractAction() {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent arg0) {
				if (gui.GetFuncNameText().equals("") == false) {
					if (gui.GetFunctionVarNameAreaText().equals("") == false
							&& gui.GetFunctionVarTypeAreaText().equals("") == false) {
						Classes.Class currentClass = null;

						if (ClassList.Get().GetCurrentChosen() == -1) {
							if (gui.GetClassNameText().equals("") == false) {
								for (int i = 0; i < ClassList.Get().size(); i++) {
									if (ClassList.Get().get(i).GetClassName().equals(gui.GetClassNameText())) {
										currentClass = ClassList.Get().get(i);
										break;
									}
								}
							}
						} else {
							currentClass = ClassList.Get().get(ClassList.Get().GetCurrentChosen());
						}

						if (currentClass != null) {
							currentClass.AddVariableToFunction(currentClass, gui.GetFuncNameText(),
									gui.GetFunctionVarNameAreaText(), gui.GetFunctionVarTypeAreaText());
						}
					}
				}

				if (Global.activeTab != null) {
					gui.SetCodeAreaText(Global.activeTab.GetFileTab().GetAdapter().GetCodeOfClass());
				}
			}

		});
		this.setText("Add Variable");
	}

}
