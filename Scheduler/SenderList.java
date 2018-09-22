package Scheduler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@SuppressWarnings("serial")
public class SenderList implements Job{
	
		String[] mails = {"lokeshaditya.3.6.9@outlook.com","gmmanohar90@gmail.com","manoharmanit@gmail.com","kancharla68@gmail.com"};
		public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		System.out.println("inside SEnderlist");
		for(int i=0;i<mails.length-1;i++){
			
			System.out.println("inside for loop"+i);	
		}
		System.out.println("all receipients are completed");
	}

}
