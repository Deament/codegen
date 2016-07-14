package main;

import java.util.ArrayList;
import java.util.List;


import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

import cn.org.rapid_framework.generator.GeneratorProperties;

public class Gen extends ApplicationWindow {
	private Text name;
	private Text key;
	private Text backagename;
	private Text tablename;
	private Text jspath;
	private Text viewpath;
	private Text viewpre;

	Button save;
	Button batchadd;
	Button query1;
	Button query;
	private Button remove;
	private Button batchremove;
	private Button update;
	private Button batchupdate;
	private Button savewithid;
	private Button getwithid;
	private Button isselect;
	private Button go;
	private Button havejs;
	private Button havahtml;
	private Button defaultview;
	private Button defaultpre;

	/**
	 * Create the application window.
	 */
	public Gen() {
		super(null);
		createActions();
		addToolBar(SWT.FLAT | SWT.WRAP);
		addMenuBar();
		addStatusLine();
	}

	/**
	 * Create contents of the application window.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createContents(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);

		save = new Button(container, SWT.CHECK);
		save.setSelection(true);

		save.setBounds(0, 10, 98, 17);
		save.setText("新增接口");

		query1 = new Button(container, SWT.CHECK);
		query1.setSelection(true);
		query1.setBounds(104, 10, 98, 17);
		query1.setText("分页查询接口");

		query = new Button(container, SWT.CHECK);
		query.setSelection(true);
		query.setBounds(104, 33, 98, 17);
		query.setText("不分页查询");

		batchadd = new Button(container, SWT.CHECK);
		batchadd.setSelection(true);
		batchadd.setBounds(0, 33, 98, 17);
		batchadd.setText("批量新增");

		remove = new Button(container, SWT.CHECK);
		remove.setSelection(true);
		remove.setBounds(224, 10, 98, 17);
		remove.setText("删除");

		batchremove = new Button(container, SWT.CHECK);
		batchremove.setSelection(true);
		batchremove.setBounds(224, 33, 98, 17);
		batchremove.setText("批量删除");

		update = new Button(container, SWT.CHECK);
		update.setSelection(true);
		update.setBounds(326, 10, 98, 17);
		update.setText("更新");

		batchupdate = new Button(container, SWT.CHECK);
		batchupdate.setSelection(true);
		batchupdate.setBounds(326, 33, 98, 17);
		batchupdate.setText("批量更新");

		savewithid = new Button(container, SWT.CHECK);
		savewithid.setSelection(true);
		savewithid.setBounds(0, 56, 98, 17);
		savewithid.setText("新增+主键");

		getwithid = new Button(container, SWT.CHECK);
		getwithid.setSelection(true);

		getwithid.setText("get方法");
		getwithid.setBounds(104, 56, 98, 17);

		isselect = new Button(container, SWT.CHECK);
		isselect.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (isselect.getSelection()) {
					key.setEnabled(true);
					name.setEnabled(true);
				} else {
					key.setEnabled(false);
					name.setEnabled(false);
				}

			}
		});

		isselect.setBounds(27, 118, 98, 17);
		isselect.setText("是否有选择框");

		name = new Text(container, SWT.BORDER);
		name.setText("name");
		name.setBounds(276, 112, 73, 23);
		name.setEnabled(false);
		Label label = new Label(container, SWT.NONE);
		label.setBounds(258, 118, 12, 17);
		label.setText("值");

		key = new Text(container, SWT.BORDER);
		key.setText("id");
		key.setBounds(166, 115, 73, 23);
		key.setEnabled(false);
		Label label_1 = new Label(container, SWT.NONE);
		label_1.setText("键");
		label_1.setBounds(141, 118, 19, 17);
		backagename = new Text(container, SWT.BORDER);
		backagename.setText("cn.qton.backagename");
		backagename.setBounds(188, 220, 211, 23);

		Label label_2 = new Label(container, SWT.NONE);
		label_2.setBounds(141, 223, 29, 17);
		label_2.setText("包名");

		tablename = new Text(container, SWT.BORDER);
		tablename.setBounds(131, 89, 131, 23);

		Label label_3 = new Label(container, SWT.NONE);
		label_3.setBounds(96, 95, 29, 17);
		label_3.setText("表名");

		Label lblJs = new Label(container, SWT.NONE);
		lblJs.setText("JS路径");
		lblJs.setBounds(136, 263, 46, 17);

		jspath = new Text(container, SWT.BORDER);
		jspath.setText("/path/");
		jspath.setBounds(188, 260, 211, 23);

		havejs = new Button(container, SWT.CHECK);
		havejs.setSelection(true);

		havejs.setText("生成JS");
		havejs.setBounds(50, 266, 57, 17);

		havahtml = new Button(container, SWT.CHECK);
		havahtml.setSelection(true);
		havahtml.setText("生成HTML");
		havahtml.setBounds(50, 289, 98, 17);

		viewpath = new Text(container, SWT.BORDER);
		viewpath.setText("/xxpt/");
		viewpath.setBounds(244, 144, 211, 23);

		Label label_4 = new Label(container, SWT.NONE);
		label_4.setText("视图路径");
		label_4.setBounds(188, 147, 62, 17);

		Label label_5 = new Label(container, SWT.NONE);
		label_5.setText("访问前缀");
		label_5.setBounds(188, 187, 62, 17);

		viewpre = new Text(container, SWT.BORDER);
		viewpre.setText("/xxpt/");
		viewpre.setBounds(244, 181, 211, 23);

		defaultview = new Button(container, SWT.CHECK);
		defaultview.setBounds(141, 147, 46, 17);
		defaultview.setText("默认");

		defaultpre = new Button(container, SWT.CHECK);
		defaultpre.setText("默认");
		defaultpre.setBounds(141, 187, 46, 17);
		go = new Button(container, SWT.NONE);
		go.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				// XXX 获取参数
				List<Properties> plist = new ArrayList<Properties>();
				plist.add(getproperties("save", save.getSelection()));

				plist.add(getproperties("batchadd", batchadd.getSelection()));
				plist.add(getproperties("savewithid", savewithid.getSelection()));
				plist.add(getproperties("query1", query1.getSelection()));
				plist.add(getproperties("query", query.getSelection()));
				plist.add(getproperties("getwithid", getwithid.getSelection()));
				plist.add(getproperties("remove", remove.getSelection()));
				plist.add(getproperties("batchremove",
						batchremove.getSelection()));
				plist.add(getproperties("update", update.getSelection()));
				plist.add(getproperties("batchupdate",
						batchupdate.getSelection()));
				plist.add(getproperties("isselect", isselect.getSelection()));
				plist.add(getproperties("defaultview",
						defaultview.getSelection()));
				plist.add(getproperties("defaultpre", defaultpre.getSelection()));
				plist.add(getproperties("havajs", havejs.getSelection()));
				plist.add(getproperties("havahtml", havahtml.getSelection()));
				plist.add(getproperties("key", key.getText()));
				plist.add(getproperties("valuename", name.getText()));
				//plist.add(getproperties("tablename", tablename.getText()));
				plist.add(getproperties("basepackage", backagename.getText()));
				plist.add(getproperties("jspath", jspath.getText()));
				plist.add(getproperties("viewpre", viewpre.getText()));
				plist.add(getproperties("viewpath", viewpath.getText()));
				try {
					GenCodeUtil.todo(plist,tablename.getText(),"template");
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				MessageDialog.openInformation(getShell(), "生成成功", "请到XXPT文件查看");
			}
		});
		go.setBounds(206, 303, 80, 27);
		go.setText("生成");

		return container;
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Create the menu manager.
	 * 
	 * @return the menu manager
	 */
	@Override
	protected MenuManager createMenuManager() {
		MenuManager menuManager = new MenuManager("menu");
		return menuManager;
	}

	/**
	 * Create the toolbar manager.
	 * 
	 * @return the toolbar manager
	 */
	@Override
	protected ToolBarManager createToolBarManager(int style) {
		ToolBarManager toolBarManager = new ToolBarManager(style);
		return toolBarManager;
	}

	/**
	 * Create the status line manager.
	 * 
	 * @return the status line manager
	 */
	@Override
	protected StatusLineManager createStatusLineManager() {
		StatusLineManager statusLineManager = new StatusLineManager();
		return statusLineManager;
	}

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Gen window = new Gen();
			window.setBlockOnOpen(true);
			window.open();
			Display.getCurrent().dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Configure the shell.
	 * 
	 * @param newShell
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("综合素质WEB版本生成器-严宇V0.1");
	}

	/**
	 * Return the initial size of the window.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(554, 454);
	}

	Properties getproperties(String key,String value){
		Properties p = new Properties();
		p.setKey(key);
		p.setValue(value);
		return p;
	}
	Properties getproperties(String key,boolean value){
		Properties p = new Properties();
		p.setKey(key);
		p.setValue(value+"");
		return p;
	}
	
	
}
