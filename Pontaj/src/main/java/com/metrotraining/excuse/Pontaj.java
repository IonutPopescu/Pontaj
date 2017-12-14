package com.metrotraining.excuse;

import java.util.concurrent.TimeUnit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Pontaj {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long dateStart;
	private long dateEnd;
	private long difference;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDateStart() {
		GetDate dateConvertor = new GetDate();
		return dateConvertor.getDateAsString(dateStart);
	}

	public void setDateStart(long dateStart) {
		this.dateStart = dateStart;
	}

	public String getDateEnd() {
		GetDate dateConvertor = new GetDate();
		return dateConvertor.getDateAsString(dateEnd);
	}

	public void setDateEnd(long dateEnd) {
		this.dateEnd = dateEnd;
	}
	
	public String getDifference() {
		return String.format("%d hours, %d min, %d sec", 
				TimeUnit.MILLISECONDS.toHours(difference),
				TimeUnit.MILLISECONDS.toMinutes(difference) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(difference)),
			    TimeUnit.MILLISECONDS.toSeconds(difference) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(difference))
			);
	}

	public void setDifference(long difference) {
		this.difference = difference;
	}

	public Pontaj() {
	}

	public Pontaj(long dateStart, long dateEnd, long difference) {
		super();
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.difference = difference;
	}

	@Override
	public String toString() {
		return "Pontaj [id=" + id + ", dateStart=" + dateStart + ", dateEnd=" + dateEnd + "]";
	}

}
