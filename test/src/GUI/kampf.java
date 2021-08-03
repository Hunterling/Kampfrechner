package GUI;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;

public class kampf {

	protected Shell shell;
	private Table table;
	private Table table_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			kampf window = new kampf();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		shell.setLayout(new FormLayout());
		
		TableViewer tableViewer = new TableViewer(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		
		JTable tablo = new JTable();
		Object[] columns = {"Einheit", "Vorher","Nachher"};
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		tablo.setModel(model);
		
		
		FormData fd_table = new FormData();
		fd_table.top = new FormAttachment(0, 79);
		fd_table.left = new FormAttachment(0, 84);
		table.setLayoutData(fd_table);
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setLayout(new TableColumnLayout());
		FormData fd_composite = new FormData();
		fd_composite.bottom = new FormAttachment(100, -81);
		fd_composite.left = new FormAttachment(table, 67);
		composite.setLayoutData(fd_composite);
		
		table_1 = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);
		
		
	}
}
