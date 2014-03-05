package pl.bnsit.flights;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements TypeConverter {
	
	private DateFormat df;
	
	public DateConverter(DateFormat df) {
		this.df = df;
	}
	
	public DateConverter() {
		this( new SimpleDateFormat("dd-MM-yyyy") );
	}

	@Override
	public String toString(Object anObject) {
		return df.format(anObject);
	}

	@Override
	public Date fromString(String str) {
		try {
			return df.parse(str);
		} catch (ParseException e) {
			throw new TypeConverstionException( "Cannot convert string '" + str + "' to" + Date.class, e );
		}
	}

	@Override
	public Class<Date> type() {
		return Date.class;
	}
}
