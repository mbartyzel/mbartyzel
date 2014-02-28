package pl.bnsit.java.foundations.swing.mvp;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Presenter implements ViewObserver {

	private View view;

	private JdbcTemplate template;
	
	public Presenter(View view) {
		this.view = view;
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("org.hsqldb.jdbcDriver");
		ds.setUrl("jdbc:hsqldb:file:target/classes/pl/bnsit/java/foundations/purejdbc/db");
		ds.setUsername("sa");
		ds.setPassword("");
		
		template = new JdbcTemplate(ds);
	}
	
	public void start() {
		view.showView();
	}

	@Override
	public void okButtonClicked() {
		List<Map<String, Object>> resutl = template.queryForList("select * from loty;");
		
		Set<String> collumns = resutl.get(1).keySet();
		view.addCollumns(collumns);

		for (Map<String, Object> map : resutl) {
			Collection<Object> values = map.values();
			view.addRow(values);
		}
	}
}
