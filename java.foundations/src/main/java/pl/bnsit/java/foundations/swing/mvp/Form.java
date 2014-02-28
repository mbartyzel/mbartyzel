package pl.bnsit.java.foundations.swing.mvp;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.ScrollPane;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Form extends JFrame implements View {

	private JTextField tf;
	private JButton button;
	private JTable table;

	public Form() {
		super( "Password" );
		Container pane = getContentPane();
		button = new JButton("OK");
		table = new JTable( 
				new DefaultTableModel(new Object[] {}, 0 ) );
		
		JScrollPane scroll = new JScrollPane( new JTextArea(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );
		scroll.add(table);
		
		pane.add(new JScrollPane( table ), BorderLayout.NORTH);
		pane.add(button, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
	}

	public void addListener( ActionListener l ) {
		button.addActionListener(l);
	}
	
	@Override
	public void setTextField(String value) {
		tf.setText( value );
	}

	@Override
	public String getTextField() {
		return tf.getText();
	}

	@Override
	public void showView() {
		setVisible(true);
	}

	@Override
	public void hideView() {
		setVisible(false);
	}

	@Override
	public void addRow(Collection<Object> row) {
		Object[] newRow = new Object[row.size()];
		int i = 0;
		for (Object object : row) {
			newRow[i++] = object;
		}
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(newRow);
	}


	@Override
	public void addCollumns(Collection<String> columns) {
		String[] newCollumns = new String[columns.size()];
		int i = 0;
		for (String object : columns) {
			newCollumns[i++] = object;
		}
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(newCollumns);
	}
}
