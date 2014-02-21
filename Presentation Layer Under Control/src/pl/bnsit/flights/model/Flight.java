package pl.bnsit.flights.model;
import java.io.Serializable;
import java.util.Date;




public class Flight implements Serializable, Identifiable {
	
	private Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	private String from;
	private String to;
	private Date date;
	private FlightClass clazz = FlightClass.ECONOMY;
	private Integer seatsNumber;
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public FlightClass getClazz() {
		return clazz;
	}
	public void setClazz(FlightClass clazz) {
		this.clazz = clazz;
	}
	public Integer getSeatsNumber() {
		return seatsNumber;
	}
	public void setSeatsNumber(Integer seatsNumber) {
		this.seatsNumber = seatsNumber;
	}
}
