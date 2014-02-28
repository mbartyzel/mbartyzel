package pl.bnsit.java.foundations.swing.mvp;

import java.util.Collection;

public interface View {

	void setTextField(String value);
	String getTextField();
	void addCollumns( Collection<String> columns );
	void addRow( Collection<Object> row);
	void showView();
	void hideView();
}
