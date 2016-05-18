package org.mum.hotel.service;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.mum.hotel.dao.CheckinDao;
import org.mum.hotel.domain.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CheckinService {
	
	@Autowired
	protected CheckinDao checkinDAO;
	
	public void addBooking(Booking booking){
		
		Date date=null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//("yyyy-MM-dd'T'HH:mm");
		try {
			date = simpleDateFormat.parse(booking.getCheckInDateTrans());
			System.out.println(date+""+date.getTime());
			
			//Calendar c = Calendar.getInstance();
			//Date today = new Date();
			//c.setTime(simpleDateFormat.parse(today));//booking.getCheckInDateTrans()));
			//c.setTime(today);
			//c.add(Calendar.DATE, 1);  // number of days to add
			//date = c.getTime(); 
			
			//date.date.getDay()+1
			booking.setCheckInDate(new java.sql.Date(date.getTime()));//date); //
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		checkinDAO.addBooking(booking);
	}
	
	public List<Booking> getAllBooking(){
		return checkinDAO.getAllBooking();
	}
	
	public Booking getByBookingNo(String bookingNo){
		return checkinDAO.getByBookingNo(new Integer(bookingNo));
	}
	public void updateCheckIn(Booking booking){
		Date date = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			// date = simpleDateFormat.parse(simpleDateFormat.format(Calendar.getInstance().getTime()));
			//System.out.println(date+""+date.getTime());
			
			Calendar c = Calendar.getInstance();
			Date today = new Date();
			//c.setTime(simpleDateFormat.parse(today));//booking.getCheckInDateTrans()));
			c.setTime(today);
			c.add(Calendar.DATE, 1);  // number of days to add
			date = c.getTime(); 
			
			
			booking.setCheckInDate(date); //new java.sql.Date(date.getTime()));
			booking.setBookedStatus(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		checkinDAO.updateCheckIn(booking);
	}
	public void updateCheckOut(Booking booking){
		Date date = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			 //date = simpleDateFormat.parse(simpleDateFormat.format(Calendar.getInstance().getTime()));
				
			 Calendar c = Calendar.getInstance();
				Date today = new Date();
				//c.setTime(simpleDateFormat.parse(today));//booking.getCheckInDateTrans()));
				c.setTime(today);
				c.add(Calendar.DATE, 1);  // number of days to add
				date = c.getTime(); 
			 
			 
			 //System.out.println(date+""+date.getTime());
			booking.setCheckoutDate(date); //new java.sql.Date(date.getTime()));
			booking.setBookedStatus(false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		checkinDAO.updateCheckIn(booking);
	}

}
