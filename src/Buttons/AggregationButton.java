package Buttons;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

import Classes.ClassList;
import Default.Global;
import Default.Gui;
import Elements.ElementList;
import Elements.Element_Aggregation;
import Panels.StatisticsArea;

public class AggregationButton extends Button {
	private static final long serialVersionUID = 1L;

	public AggregationButton(final Gui inGui) {
		super();

		this.setAction(new AbstractAction() {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				if (ClassList.Get().CheckIfClassesPossible(Global.AGGREGATION_BASE)) {
					Classes.Class child = ClassList.Get().get(ClassList.Get().GetCurrentChosen());
					Classes.Class parent = ClassList.Get().get(ClassList.Get().GetCurrentMate());

					// Karsilikli eklemeler
					child.parents.add(parent);
					parent.children.add(child);

					// Atanin tum atalarini child'a ata olarak ekledik.
					for (int i = 0; i < parent.parents.size(); i++) {
						child.parents.add(parent.parents.get(i));
					}

					ElementList.Get().add(
							new Element_Aggregation(ClassList.Get().GetCurrentChosen(), ClassList.Get()									.GetCurrentMate()));

					child.AddAggregatedFrom(parent);

					child.connectionMethods.add(Global.AGGREGATION_CHILD);
					parent.connectionMethods.add(Global.AGGREGATION_PARENT);

					Global.totalConnection++;
				}

				if (Global.activeTab != null) {
					inGui.SetCodeAreaText(Global.activeTab.GetFileTab().GetAdapter().GetCodeOfClass());
				}

				StatisticsArea.Get().UpdateStatistics();
			}
		});
		this.setIcon(new ImageIcon("img/aggregation.jpg"));
	}
}
