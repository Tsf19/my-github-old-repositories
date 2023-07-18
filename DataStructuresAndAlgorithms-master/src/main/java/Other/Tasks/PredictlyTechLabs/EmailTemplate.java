package Other.Tasks.PredictlyTechLabs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class EmailTemplate {

	public static void main(String[] args) {

		try {
			
	// 'EmailTemplate.class' class is a keyword which returns object of that class
	// class.getResource() finds a resource with a given name, This method returns URL Object, with complete absolute path of resource 
	// getFile() or getPath() convert URL Object to String 
			
	//		File file = new File(EmailTemplate.class.getResource("/com/company_questions/predictly_tech_labs/sample_email.csv").getPath()); //Also Worked
	//		File file = new File(EmailTemplate.class.getResource("/com/company_questions/predictly_tech_labs/sample_email.csv").getFile());
		
	//System.out.println(EmailTemplate.class.getResource("/com/company_questions/predictly_tech_labs/sample_email.csv"));
	// O/P : file:/C:/../eclipse-workspace/Challenges/bin/com/company_questions/predictly_tech_labs/sample_email.csv
		
			String fileName = EmailTemplate.class.getResource("/com/company_questions/predictly_tech_labs/sample_email.csv").getFile();
			File file = new File(fileName);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			line = br.readLine();
			System.out.println(line);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
