package Buttons;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;

import Default.Gui;

public class VisibilityButton extends JButton {
	private static final long serialVersionUID = 1L;

	private boolean visibility = false;

	public VisibilityButton(Gui inGui) {
		super();

		final VisibilityButton self = this;

		this.setAction(new AbstractAction() {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent arg0) {
				if (visibility) {
					visibility = false;
					self.setText("Invisible");
				} else {
					visibility = true;
					self.setText("Visible");
				}
			}
		});

		this.setText("Invisible");
	}

	public boolean GetVisibility() {
		return visibility;
	}
}
