package pl.bnsit.java.foundations.backup;

public class Runner {

	public static void main(String[] args) {
		final String FILENAME = "target/classes/pl/bnsit/java/foundations/backup/backup.txt";

		Backupper backupper = new Backupper( FILENAME );
		backupper.makeBackup();
		backupper.makeZippedBackup();
	}
}
