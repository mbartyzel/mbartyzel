package pl.bnsit.flights;

public interface TypeConverter {
	String toString( Object anObject );
	Object fromString( String str);
	Class type();
}
