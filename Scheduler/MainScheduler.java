package Scheduler;

import java.sql.Connection;
import java.sql.DriverManager;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class MainScheduler {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		JobDetail j = JobBuilder.newJob(Logic.class).build();

		Trigger t = TriggerBuilder.newTrigger().withIdentity("CroneTrigger")
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInMinutes(5).repeatForever()).build();
				//.withIntervalInSeconds(50).repeatForever()).build();

		Scheduler s = StdSchedulerFactory.getDefaultScheduler();
		s.start();
		s.scheduleJob(j, t);

	}

}
