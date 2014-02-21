package pl.bnsit.account;

import pl.bnsit.account.main.MainWindow;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Runner {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector( new DefaultGuiceModule() );
		
		MainWindow mainWindow = injector.getInstance( MainWindow.class );
		mainWindow.setVisible(true);
	}


}
