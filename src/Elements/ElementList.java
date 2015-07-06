package Elements;

import java.util.ArrayList;

public class ElementList extends ArrayList<Element> {
	private static final long serialVersionUID = 1L;

	private static ElementList instance = null;

	private ElementList() {
		super();
	}

	public static ElementList Get() {
		if (instance == null) {
			instance = new ElementList();
		}
		return instance;
	}
}
