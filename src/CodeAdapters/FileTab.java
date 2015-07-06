package CodeAdapters;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;

import Default.Global;
import Default.Gui;

public class FileTab extends JButton {
	private static final long serialVersionUID = 1L;

	private Gui gui = null;

	private Classes.Class classOfFile = null;

	private ClassTextAdapter adapter;

	public FileTab(Gui inGui, Classes.Class inClassOfFile) {
		super();
		gui = inGui;
		classOfFile = inClassOfFile;

		adapter = new ClassTextAdapter(classOfFile);

		this.setAction(new AbstractAction() {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent arg0) {
				String codes = adapter.GetCodeOfClass();

				gui.SetCodeAreaText(codes);

				Global.activeTab = classOfFile;
			}
		});

		this.setText(classOfFile.GetClassName());
	}

	public final ClassTextAdapter GetAdapter() {
		return adapter;
	}
}
