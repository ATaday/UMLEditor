package Classes;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import Default.Global;
import Elements.ElementList;
import Panels.StatisticsArea;
import Panels.UmlPanel;

public class ClassList extends ArrayList<Class> {
	private static final long serialVersionUID = 1L;

	private int currentChosen = -1;
	private int currentMate = -1;

	public final int GetCurrentChosen() {
		return currentChosen;
	}

	public final int GetCurrentMate() {
		return currentMate;
	}

	private static ClassList instance = null;

	private ClassList() {
		super();
	}

	public static ClassList Get() {
		if (instance == null) {
			instance = new ClassList();
		}
		return instance;
	}

	public void NotifyMouseClicked(int leftOrRight, Point point) {
		GraphicalClear();

		double differenceX, differenceY;

		boolean found = false;

		for (int i = this.size() - 1; i >= 0; i--) {
			differenceX = (point.x - this.get(i).GetSetupPosition().x);
			differenceY = (point.y - this.get(i).GetSetupPosition().y);

			if (differenceX < Global.DIAGRAM_WIDTH && differenceX >= 0 && differenceY < Global.DIAGRAM_HEIGHT
					&& differenceY >= 0) {
				if (currentChosen >= 0 && currentChosen < this.size()) {
					if (leftOrRight == 2) {
						if (currentMate >= 0 && currentMate < this.size()) {
							this.get(currentMate).GraphicalSetup(Color.BLACK);
						}

						if (currentChosen == i) {
							this.get(currentChosen).GraphicalSetup(Color.BLACK);
							currentMate = -1;
						} else {
							currentMate = i;

							this.get(currentMate).GraphicalSetup(Color.GREEN);
						}
					} else {
						this.get(currentChosen).GraphicalSetup(Color.BLACK);
					}
				}

				if (currentMate != i) {
					currentChosen = i;

					this.get(currentChosen).GraphicalSetup(Color.RED);
				}

				found = true;

				break;
			}
		}

		if (found == false) {
			if (currentChosen >= 0 && currentChosen < this.size()) {
				if (currentMate >= 0 && currentMate < this.size()) {
					this.get(currentMate).GraphicalSetup(point, Color.BLACK);

					currentMate = -1;
				} else {
					this.get(currentChosen).GraphicalSetup(point, Color.BLACK);

					currentChosen = -1;
				}
			}
		}

		GraphicalReset();
	}

	private void GraphicalClear() {
		UmlPanel.Get().getGraphics().clearRect(0, 0, UmlPanel.Get().getWidth(), UmlPanel.Get().getHeight());
	}

	// Observer pattern burada.
	private void GraphicalReset() {
		GraphicalClear();

		for (int i = 0; i < ClassList.Get().size(); i++) {
			ClassList.Get().get(i).GraphicalSetup();
		}
		for (int i = 0; i < ElementList.Get().size(); i++) {
			ElementList.Get().get(i).GraphicalSetup();
		}

		StatisticsArea.Get().UpdateStatistics();
	}

	/**
	 * @param method
	 *            GLOBAL.INHERITANCE_BASE Global.INTERFACE_BASE
	 *            Global.AGGREGATION_BASE
	 * @return Eger iki sinif birbirine parametre olarak gelen method ile
	 * @return Baglanmaya uygunsa TRUE doner.
	 */
	public boolean CheckIfClassesPossible(int method) {
		if (currentChosen == -1 || currentMate == -1) {
			return false;
		}

		if (method != Global.AGGREGATION_BASE && method != Global.INHERITANCE_BASE && method != Global.INTERFACE_BASE) {
			return false;
		}

		Class firstClass = this.get(currentChosen);
		Class secondClass = this.get(currentMate);

		// Kurallar

		// Interface baska bir interface'i implement edemez.
		if (firstClass.connectionMethods.contains(Global.INTERFACE_PARENT)) {
			if (method == Global.INTERFACE_BASE) {
				return false;
			}
		}

		// Eger mevcut istenen durumun tam tersi bir hal sozkonusu ise
		if (secondClass.children.contains(firstClass) || firstClass.parents.contains(secondClass)
				|| secondClass.parents.contains(firstClass) || firstClass.children.contains(secondClass)) {
			return false;
		}

		// Eger A inherits B isteniyorsa
		if (method == Global.INHERITANCE_BASE) {
			// Eger zaten bir atasi varsa
			if (firstClass.connectionMethods.contains(Global.INHERITANCE_CHILD)) {
				return false;
			}
		}

		return true;
	}

	public void NotifyScreenChange() {
		GraphicalReset();
	}
}
