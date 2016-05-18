package org.mum.hotel.aop;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.mum.hotel.domain.Booking;
import org.mum.hotel.domain.Customer;
import org.mum.hotel.domain.Room;
import org.mum.hotel.messaging.ApplicationMailer;
import org.mum.hotel.service.CustomerService;
import org.mum.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Aspect
@Transactional
public class BookAdvice {

	@Autowired
	CustomerService customerService;
	
	ApplicationMailer mailer;
	
	@Autowired
	RoomService roomService;
	
	
	public ApplicationMailer getMailer() {
		return mailer;
	}
	public void setMailer(ApplicationMailer mailer) {
		this.mailer = mailer;
	}
	

	@After("execution(* org.mum.hotel.controller.BookingController.userConfirm(..))")
	public void notificationAdvice(JoinPoint jp){
		Object[] args = jp.getArgs();
		String custNo = (String) args[2];
        Booking booking = (Booking) args[0];
        
		Customer customer = customerService.findCustomer(Integer.parseInt(custNo));
		System.out.println("Sending Email to==="+custNo+"====="+customer.getFirstName()+booking.getCheckInDate()+"=="+booking.getCheckoutDate());
		if(customer.getEmail()!=null){ 
			mailer.sendMail(customer.getEmail(), "Booking Confirmation", "This is a message to notify that you have booked a reservation in our hotel from" +booking.getCheckInDate()+ "till"+booking.getCheckoutDate());
		}
	
	}
}
