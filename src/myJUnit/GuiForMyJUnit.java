package myJUnit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

public class GuiForMyJUnit {

	private TestResult result;
	private String suiteName;
	private JFrame frame;
	private JEditorPane paneForFailures;

	public GuiForMyJUnit(TestResult result) {
		this.result = result;
	}

	public void createAndShowGui() {
		frame = new JFrame("My JUnit");
		frame.setMinimumSize(new Dimension(500, 600));
		frame.getContentPane().add(createMainPanel());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	private JPanel createMainPanel() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(createResultPanel(), BorderLayout.NORTH);
		mainPanel.add(createTraceSplit(), BorderLayout.CENTER);
		return mainPanel;
	}

	private JSplitPane createTraceSplit() {
		JSplitPane traceSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true);
		traceSplit.setTopComponent(createTreeScroll());
		traceSplit.add(createFailurePanel());
		frame.addWindowListener(new WindowAdapter() {

			@Override
			public void windowOpened(WindowEvent e) {
				traceSplit.setDividerLocation(0.5);
				traceSplit.setResizeWeight(0.5);
				frame.repaint();
				frame.revalidate();
			}
		});
		return traceSplit;
	}

	private Component createFailurePanel() {
		JPanel failurePanel = new JPanel(new BorderLayout());
		paneForFailures = new JEditorPane();
		paneForFailures.setEditable(false);
		paneForFailures.setContentType("text/html");
		paneForFailures.addHyperlinkListener(new HyperlinkListener() {
			
			@Override
			public void hyperlinkUpdate(HyperlinkEvent hle) {
				if (HyperlinkEvent.EventType.ACTIVATED.equals(hle.getEventType())) {
                    System.out.println(hle.getURL());
                    Desktop desktop = Desktop.getDesktop();
                    try {
                        desktop.browse(hle.getURL().toURI());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
			}
		});
		JScrollPane scrollForTextPane = new JScrollPane(paneForFailures);
		JLabel lab = new JLabel("failure trace");
		lab.setBorder(new EmptyBorder(10, 10, 10, 10));
		failurePanel.add(lab, BorderLayout.NORTH);
		failurePanel.add(scrollForTextPane, BorderLayout.CENTER);
		return failurePanel;
	}

	private JScrollPane createTreeScroll() {
		SortedMap<String, SortedMap<String, Messager>> tests = result
				.getTestClasses();
		Vector<Object> root = new Vector<Object>();
		Vector<MyTreeLeaf> tmp = null;
		for (Entry<String, SortedMap<String, Messager>> entry : tests
				.entrySet()) {
			tmp = new Vector<>();
			for (Entry<String, Messager> entry2 : entry.getValue().entrySet()) {
				tmp.add(new MyTreeLeaf(entry2.getKey(), entry2.getValue()));
			}
			root.add(new TreeNodeVector<Object>(entry.getKey(), tmp.toArray()));
		}
		Vector<Object> treeData = null;
		if (suiteName != null) {
			treeData = new Vector<>();
			treeData.add(new TreeNodeVector<Object>(suiteName, root.toArray()));
		} else {
			treeData = root;
		}
		JTree testsTree = new JTree(treeData);
		testsTree.setCellRenderer(new RedTreeCellRenderer());
		testsTree.addTreeSelectionListener(new TreeSelectionListener() {

			@Override
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode selectedElement = (DefaultMutableTreeNode) testsTree
						.getSelectionPath().getLastPathComponent();
				if (selectedElement.isLeaf()) {
					MyTreeLeaf ob = (MyTreeLeaf) selectedElement
							.getUserObject();
					if (ob.getMessanger().isFailed()
							|| ob.getMessanger().isFailure()) {
						paneForFailures.setText(ob.getMessanger().getMes());
					} else {
						paneForFailures.setText("");
					}
				} else {
					paneForFailures.setText("");
				}
			}
		});
		JScrollPane scrollForTree = new JScrollPane(testsTree);
		return scrollForTree;
	}

	private JPanel createResultPanel() {
		JPanel resultPanel = new JPanel(new BorderLayout());
		JLabel labForRes = new JLabel(result.resSum());
		labForRes.setBorder(new EmptyBorder(10, 50, 10, 10));
		resultPanel.add(labForRes, BorderLayout.NORTH);
		JLabel labForColor = new JLabel(" ");
		if (result.isAllTrue()) {
			labForColor.setBackground(Color.GREEN);
		} else {
			labForColor.setBackground(Color.RED);
		}
		labForColor.setOpaque(true);
		JPanel panForColr = new JPanel();

		panForColr.setBorder(new EmptyBorder(0, 20, 20, 20));
		panForColr.setLayout(new BorderLayout());
		panForColr.add(labForColor, BorderLayout.CENTER);
		resultPanel.add(panForColr, BorderLayout.CENTER);
		return resultPanel;
	}

	public void setSuiteName(String name) {
		suiteName = name;
	}

}

class TreeNodeVector<E> extends Vector<E> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6064965314193986315L;
	String name;

	TreeNodeVector(String name) {
		this.name = name;
	}

	TreeNodeVector(String name, E elements[]) {
		this.name = name;
		for (int i = 0, n = elements.length; i < n; i++) {
			add(elements[i]);
		}
	}

	public String toString() {
		return name;
	}
}

class MyTreeLeaf extends DefaultMutableTreeNode {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2271177839432147164L;
	private String name;
	private Messager messanger;

	public MyTreeLeaf(String name, Messager messanger) {

		this.name = name;
		this.messanger = messanger;
	}

	public String getName() {
		return name;
	}

	public Messager getMessanger() {
		return messanger;
	}

	@Override
	public String toString() {
		return name;
	}
}

class RedTreeCellRenderer extends DefaultTreeCellRenderer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 707287337017494764L;
	private String status;

	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value,
			boolean isSelected, boolean expanded, boolean leaf, int row,
			boolean hasFocus) {
		super.getTreeCellRendererComponent(tree, value, isSelected, expanded,
				leaf, row, hasFocus);
		setForeground(getTextSelectionColor());
		DefaultMutableTreeNode treenode = (DefaultMutableTreeNode) value;
		Object ob = null;
		if (leaf) {
			ob = treenode.getUserObject();
			if (((MyTreeLeaf) ob).getMessanger().isFailed()) {
				setIcon(new ImageIcon("images/redkrest.png"));
			} else if (((MyTreeLeaf) ob).getMessanger().isFailure()) {
				setIcon(new ImageIcon("images/blueminus.png"));
			} else {
				setIcon(new ImageIcon("images/green.png"));
			}
		} else {

			status = "";
			getChilds(treenode);

			if (status.equals("failed")) {
				setIcon(new ImageIcon("images/redkrest.png"));
			} else if (status.equals("failure")) {
				setIcon(new ImageIcon("images/blueminus.png"));
			} else {
				setIcon(new ImageIcon("images/green.png"));
			}
		}
		return this;
	}

	private void getChilds(DefaultMutableTreeNode treenode) {
		int count = treenode.getChildCount();
		for (int i = 0; i < count; i++) {
			if (treenode.getChildAt(i).isLeaf()) {
				createIcons((DefaultMutableTreeNode) treenode.getChildAt(i));
			}
			else{
				getChilds((DefaultMutableTreeNode) treenode.getChildAt(i));
			}
		}
	}

	private void createIcons(DefaultMutableTreeNode child) {

		Object ob = ((DefaultMutableTreeNode) child).getUserObject();
		if (((MyTreeLeaf) ob).getMessanger().isFailed()) {
			status = "failed";
		} else if (((MyTreeLeaf) ob).getMessanger().isFailure()) {
			if (!status.equals("failed")) {
				status = "failure";
			}
		} else {
			if (!status.equals("failed") && !status.equals("failure")) {
				status = "ok";
			}
		}

	}
}
