package org.mpower.acl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:couchdb-connection-context.xml", "classpath:etl-bean-context.xml",
        "classpath:hibernate-cfg.xml", "classpath:listener-context.xml", "classpath:mvc-context.xml" })
public class HouseholdServiceTest {
	
	@Ignore
	@Test
	public void dateConverStingToDate() {
		
		final Date currentTime = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		// Give it to me in GMT time.
		//sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		System.out.println("GMT time: " + sdf.format(currentTime));
		
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
		String dateInString = "11-12-2005"; //
		
		try {
			
			Date date = sdf.parse(dateInString);
			System.out.println(date);
			System.out.println(sdf.format(date));
			System.out.println(formatter1.format(date));
			
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
}
