package it.polimi.awt.springmvc.util;

import java.util.Comparator;
import java.util.Date;

import it.polimi.awt.springmvc.mapper.RegisterType;

public class MyComparator implements Comparator<RegisterType> {

	public MyComparator(){
		
	}
	
	@Override
	public int compare(RegisterType s1, RegisterType s2) {

		return toDate(s2).compareTo(toDate(s1));
	}

	// return date format from xmlDate
	private Date toDate(RegisterType time) {
		return time.getTimestamp2().toGregorianCalendar().getTime();
	}
}