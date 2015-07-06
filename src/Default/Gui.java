package Default;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

import Buttons.AddButton;
import Buttons.AggregationButton;
import Buttons.ChangeButton;
import Buttons.ClassButton;
import Buttons.InheritanceButton;
import Buttons.InterfaceButton;
import Buttons.VisibilityButton;
import CodeAdapters.FileTab;
import Panels.StatisticsArea;
import Panels.UmlPanel;

public class Gui {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Gui application = new Gui();
				try {
					application.GetFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JFrame frame = null;
	private JPanel content = null;

	private JSplitPane splitPane_1 = null;
	private JSplitPane splitPane_2 = null;
	private JSplitPane splitPane_3 = null;

	private JToolBar buttonsBar = null;

	private JSplitPane codeAreaPane = null;

	private JSplitPane umlAreaPane = null;
	private JSplitPane classVarFuncPane = null;

	private JToolBar fileTabsToolBar = null;
	private JTextArea codeArea = null;

	private JTextArea classNameTypingArea = null;

	private JSplitPane varFuncPane = null;

	private JSplitPane funcPane = null;

	private JTextArea varNameTypingArea = null;
	private JTextArea varTypeTypingArea = null;

	private JTextArea funcNameTypingArea = null;
	private JTextArea funcReturnTypeTypingArea = null;

	private JTextArea functionVarNameArea = null;
	private JTextArea functionVarTypeArea = null;

	private JMenuBar varToolBar = null;
	private JMenuBar funcToolBar = null;
	private JMenuBar addVarToFunc = null;

	private JFrame GetFrame() {
		if (frame == null) {
			frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(Global.WIDTH, Global.HEIGHT);
			frame.setContentPane(GetContent());
			frame.setResizable(false);
			frame.setTitle(Global.TITLE);
		}
		return frame;
	}

	private JPanel GetContent() {
		if (content == null) {
			content = new JPanel();
			content.setLayout(new BorderLayout());
			content.add(SplitPane_1(), BorderLayout.CENTER);
		}
		return content;
	}

	private JSplitPane SplitPane_1() {
		if (splitPane_1 == null) {
			splitPane_1 = new JSplitPane();
			splitPane_1.setDividerLocation(100);
			splitPane_1.setLeftComponent(SplitPane_2());
			splitPane_1.setRightComponent(SplitPane_3());
			splitPane_1.setEnabled(false);
		}
		return splitPane_1;
	}

	private JSplitPane SplitPane_2() {
		if (splitPane_2 == null) {
			splitPane_2 = new JSplitPane();
			splitPane_2.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPane_2.setDividerLocation(450);
			splitPane_2.setTopComponent(ButtonsPanel());
			splitPane_2.setBottomComponent(StatisticsScrollPane());
			splitPane_2.setEnabled(false);
		}
		return splitPane_2;
	}

	private JSplitPane SplitPane_3() {
		if (splitPane_3 == null) {
			splitPane_3 = new JSplitPane();
			splitPane_3.setDividerLocation(1000);
			splitPane_3.setLeftComponent(UmlAreaSplitPane());
			splitPane_3.setRightComponent(CodeAreaSplitPane());
			splitPane_3.setEnabled(false);
		}
		return splitPane_3;
	}

	private JToolBar ButtonsPanel() {
		if (buttonsBar == null) {
			buttonsBar = new JToolBar();
			buttonsBar.setOrientation(JToolBar.VERTICAL);
			buttonsBar.add(new ClassButton(this));
			buttonsBar.add(new InheritanceButton(this));
			buttonsBar.add(new AggregationButton(this));
			buttonsBar.add(new InterfaceButton(this));
			buttonsBar.setEnabled(false);
		}
		return buttonsBar;
	}

	private JSplitPane UmlAreaSplitPane() {
		if (umlAreaPane == null) {
			umlAreaPane = new JSplitPane();
			umlAreaPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
			umlAreaPane.setDividerLocation(100);
			umlAreaPane.setTopComponent(ClassVarFuncNameEditorPane());
			umlAreaPane.setBottomComponent(UmlPanel.Get());
			umlAreaPane.setEnabled(false);
		}
		return umlAreaPane;
	}

	private JScrollPane statisticsScrollPane = null;

	private JScrollPane StatisticsScrollPane() {
		if (statisticsScrollPane == null) {
			statisticsScrollPane = new JScrollPane(StatisticsArea.Get());
			statisticsScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			statisticsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		}
		return statisticsScrollPane;
	}

	private JScrollPane fileTabsScrollPane = null;

	private JScrollPane FileTabsScrollPane() {
		if (fileTabsScrollPane == null) {
			fileTabsScrollPane = new JScrollPane(FileTabs());
			fileTabsScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			fileTabsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		}
		return fileTabsScrollPane;
	}

	private JScrollPane codeAreaScrollPane = null;

	private JScrollPane CodeAreaScrollPane() {
		if (codeAreaScrollPane == null) {
			codeAreaScrollPane = new JScrollPane(CodeArea());
			codeAreaScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			codeAreaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		}
		return codeAreaScrollPane;
	}

	private JSplitPane CodeAreaSplitPane() {
		if (codeAreaPane == null) {
			codeAreaPane = new JSplitPane();
			codeAreaPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
			codeAreaPane.setDividerLocation(50);
			codeAreaPane.setTopComponent(FileTabsScrollPane());
			codeAreaPane.setBottomComponent(CodeAreaScrollPane());
			codeAreaPane.setEnabled(false);
		}
		return codeAreaPane;
	}

	private JToolBar FileTabs() {
		if (fileTabsToolBar == null) {
			fileTabsToolBar = new JToolBar();
			fileTabsToolBar.setOrientation(JToolBar.HORIZONTAL);
			fileTabsToolBar.setEnabled(false);
		}
		return fileTabsToolBar;
	}

	public void AddFileToTabBar(FileTab tabToAdd) {
		if (tabToAdd != null) {
			fileTabsToolBar.add(tabToAdd);
		}
	}

	private JTextArea CodeArea() {
		if (codeArea == null) {
			codeArea = new JTextArea();
			codeArea.setEditable(false);
		}
		return codeArea;
	}

	public void SetCodeAreaText(String text) {
		codeArea.setText(text);
	}

	private JSplitPane ClassVarFuncNameEditorPane() {
		if (classVarFuncPane == null) {
			classVarFuncPane = new JSplitPane();
			classVarFuncPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
			classVarFuncPane.setDividerLocation(940);
			classVarFuncPane.setLeftComponent(VarFuncPane());
			classVarFuncPane.setRightComponent(new ChangeButton(this));
			classVarFuncPane.setEnabled(false);
		}
		return classVarFuncPane;
	}

	private JSplitPane VarFuncPane() {
		if (varFuncPane == null) {
			varFuncPane = new JSplitPane();
			varFuncPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
			varFuncPane.setDividerLocation(25);
			varFuncPane.setTopComponent(VarToolBar());
			varFuncPane.setBottomComponent(FuncPane());
		}
		return varFuncPane;
	}

	private JSplitPane FuncPane() {
		if (funcPane == null) {
			funcPane = new JSplitPane();
			funcPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
			funcPane.setDividerLocation(25);
			funcPane.setTopComponent(FuncToolBar());
			funcPane.setBottomComponent(AddVarToFuncBar());
		}
		return funcPane;
	}

	private JMenuBar VarToolBar() {
		if (varToolBar == null) {
			varToolBar = new JMenuBar();
			varToolBar.add(new JLabel("Visibility: "));
			varToolBar.add(VarVisibilityButton_1());
			varToolBar.add(new JLabel("Class Name: "));
			varToolBar.add(ClassNameTypingArea());
			varToolBar.add(new JLabel("Variable's Name: "));
			varToolBar.add(VarNameTypingArea());
			varToolBar.add(new JLabel("Variable's Type: "));
			varToolBar.add(VarTypeTypingArea());
		}
		return varToolBar;
	}

	private VisibilityButton varVisibilityButton_1 = null;

	public VisibilityButton VarVisibilityButton_1() {
		if (varVisibilityButton_1 == null) {
			varVisibilityButton_1 = new VisibilityButton(this);
			varVisibilityButton_1.setEnabled(true);
		}
		return varVisibilityButton_1;
	}

	private JMenuBar FuncToolBar() {
		if (funcToolBar == null) {
			funcToolBar = new JMenuBar();
			funcToolBar.add(new JLabel("Function's Name: "));
			funcToolBar.add(FuncNameTypingArea());
			funcToolBar.add(new JLabel("Function's Return Type: "));
			funcToolBar.add(FuncReturnTypeTypingArea());
			funcToolBar.setEnabled(false);
		}
		return funcToolBar;
	}

	private JMenuBar AddVarToFuncBar() {
		if (addVarToFunc == null) {
			addVarToFunc = new JMenuBar();
			addVarToFunc.add(new JLabel("Function Variable's Name: "));
			addVarToFunc.add(FunctionVariableNameArea());
			addVarToFunc.add(new JLabel("Function Variable's Type: "));
			addVarToFunc.add(FunctionVariableTypeArea());
			addVarToFunc.add(new AddButton(this));
			addVarToFunc.setEnabled(false);
		}
		return addVarToFunc;
	}

	private JTextArea ClassNameTypingArea() {
		if (classNameTypingArea == null) {
			classNameTypingArea = new JTextArea();
			classNameTypingArea.setEditable(true);
		}
		return classNameTypingArea;
	}

	private JTextArea VarNameTypingArea() {
		if (varNameTypingArea == null) {
			varNameTypingArea = new JTextArea();
			varNameTypingArea.setEditable(true);
		}
		return varNameTypingArea;
	}

	private JTextArea VarTypeTypingArea() {
		if (varTypeTypingArea == null) {
			varTypeTypingArea = new JTextArea();
			varTypeTypingArea.setEditable(true);
		}
		return varTypeTypingArea;
	}

	private JTextArea FuncNameTypingArea() {
		if (funcNameTypingArea == null) {
			funcNameTypingArea = new JTextArea();
			funcNameTypingArea.setEditable(true);
		}
		return funcNameTypingArea;
	}

	private JTextArea FuncReturnTypeTypingArea() {
		if (funcReturnTypeTypingArea == null) {
			funcReturnTypeTypingArea = new JTextArea();
			funcReturnTypeTypingArea.setEditable(true);
		}
		return funcReturnTypeTypingArea;
	}

	private JTextArea FunctionVariableNameArea() {
		if (functionVarNameArea == null) {
			functionVarNameArea = new JTextArea();
			functionVarNameArea.setEditable(true);
		}
		return functionVarNameArea;
	}

	private JTextArea FunctionVariableTypeArea() {
		if (functionVarTypeArea == null) {
			functionVarTypeArea = new JTextArea();
			functionVarTypeArea.setEditable(true);
		}
		return functionVarTypeArea;
	}

	public String GetClassNameText() {
		if (classNameTypingArea != null) {
			return classNameTypingArea.getText();
		}
		return "";
	}

	public String GetVarNameText() {
		if (varNameTypingArea != null) {
			return varNameTypingArea.getText();
		}
		return "";
	}

	public String GetVarTypeText() {
		if (varTypeTypingArea != null) {
			return varTypeTypingArea.getText();
		}
		return "";
	}

	public String GetFuncNameText() {
		if (funcNameTypingArea != null) {
			return funcNameTypingArea.getText();
		}
		return "";
	}

	public String GetFuncReturnTypeText() {
		if (funcReturnTypeTypingArea != null) {
			return funcReturnTypeTypingArea.getText();
		}
		return "";
	}

	public String GetFunctionVarNameAreaText() {
		if (functionVarNameArea != null) {
			return functionVarNameArea.getText();
		}
		return "";
	}

	public String GetFunctionVarTypeAreaText() {
		if (functionVarTypeArea != null) {
			return functionVarTypeArea.getText();
		}
		return "";
	}
}
