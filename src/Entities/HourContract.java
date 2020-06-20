package Entities;

import java.util.Date;

public class HourContract {
	private Date date;
	private Double ValuePerHour;
	private Integer Hour;
	
	public HourContract() {
	}
	
	public HourContract(Date date, Double ValuePerHour, Integer Hour) {
		this.date = date;
		this.ValuePerHour = ValuePerHour;
		this.Hour = Hour;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getValuePerHour() {
		return ValuePerHour;
	}

	public void setValuePerHour(Double valuePerHour) {
		ValuePerHour = valuePerHour;
	}

	public Integer getHour() {
		return Hour;
	}

	public void setHour(Integer hour) {
		Hour = hour;
	}
	
	public Double TotalValue() {
		return ValuePerHour * Hour;
	}

}
