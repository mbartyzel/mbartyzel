package pl.bnsit.java.foundations.decompilation;

import java.io.File;

public class Runner {

	public static void main(String[] args) {
		
		Decompliler decompliler = new Decompliler(File.class);
		String soruceCode = decompliler.decompile();
		System.out.println( soruceCode );
	}
}
