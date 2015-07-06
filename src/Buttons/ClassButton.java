package Buttons;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import Classes.Class;
import Classes.ClassList;
import CodeAdapters.FileTab;
import Default.Global;
import Default.Gui;

public class ClassButton extends Button {
	private static final long serialVersionUID = 1L;

	private Gui gui = null;

	public ClassButton(final Gui inGui) {
		super();

		gui = inGui;

		this.setAction(new AbstractAction() {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				Point mouseLocation = MouseInfo.getPointerInfo().getLocation();

				Global.ClassNo++;
				Class newClass = null;
				if (mouseLocation != null) {
					newClass = new Class(mouseLocation);
					ClassList.Get().add(newClass);
				} else {
					newClass = new Class(new Point(0, 0));
					ClassList.Get().add(new Class(new Point(0, 0)));
				}
				newClass.SetClassName("Class" + Global.ClassNo);

				FileTab newTab = new FileTab(gui, newClass);
				newClass.SetFileTab(newTab);
				gui.AddFileToTabBar(newTab);
			}
		});
		this.setIcon(new ImageIcon("img/class.jpg"));
	}
}
