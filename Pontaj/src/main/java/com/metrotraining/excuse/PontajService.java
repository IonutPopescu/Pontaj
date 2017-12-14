package com.metrotraining.excuse;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PontajService {
	@Autowired
	private PontajRepository repo;
	
	public String getMonthName() {

	        String[] monthName = {"January", "February",
	                "March", "April", "May", "June", "July",
	                "August", "September", "October", "November",
	                "December"};

	        Calendar cal = Calendar.getInstance();
	        return monthName[cal.get(Calendar.MONTH)];
	}
	
	
	public void savePontaj(String startDate, String endDate) {
		GetDate dateConvertor = new GetDate();
		Pontaj log = new Pontaj(dateConvertor.getDateAsLong(startDate),dateConvertor.getDateAsLong(endDate), calcDifference(dateConvertor.getDateAsLong(endDate), dateConvertor.getDateAsLong(startDate)));
		repo.save(log);
	}

	
	public List<Pontaj> getPontaj () {
		return repo.findAll();
	}
	
	public long calcDifference(long firstDate, long secondDate) {
		long shorDay = 23400000;
		long normalDay = 32400000;
		long workTime = firstDate - secondDate;
		long difference;
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(firstDate);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		if (dayOfWeek == 6) {
			difference = workTime - shorDay;
		}
		else {
			difference = workTime - normalDay;
		}
		return difference;
	}
	
	public String getSumDifference() {
		long difference = repo.findSumDifference();
		return String.format("%d hours, %d min, %d sec", 
				TimeUnit.MILLISECONDS.toHours(difference),
				TimeUnit.MILLISECONDS.toMinutes(difference) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(difference)),
			    TimeUnit.MILLISECONDS.toSeconds(difference) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(difference)));
	}
}
