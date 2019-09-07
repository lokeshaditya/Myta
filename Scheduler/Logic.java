package Scheduler;

import Scheduler.MainScheduler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import org.quartz.Job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class Logic implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select email,name from occasion where to_char(dated,'mm/dd') = to_char(sysdate-1,'mm/dd')");
			ScheduleMail sm = new ScheduleMail();
			String toadd = "",name = "";
			while(rs.next()){
				toadd = rs.getString("email");
				name = rs.getString("name");
				System.out.println(toadd +"-"+name);
				sm.execute(toadd,name);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block	
			e.printStackTrace();
		
	}
		
		//System.out.println(new Date());
		
	}
}
