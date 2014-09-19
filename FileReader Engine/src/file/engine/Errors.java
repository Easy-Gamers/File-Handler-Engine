package file.engine;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//import me.zabuzasword3.engine.Destinyor;
//import me.zabuzasword3.engine.menu.Options;
//import me.zabuzasword3.engine.graphics.Resolution;

public class Errors {
	
    public static String home = System.getProperty("user.home");
    
	// Test what is running
	public static String Test1 = "Thread is running";
	public static String Test2 = "BufferStrategy is being created";
	public static String Test3 = "ResolutionChanger is running";
	public static String Test4 = "ResTextChanger is running";
	public static String Test5 = "Writer is running";
	public static String Test6 = "Reader is running";
	public static String Test7 = "Check is running";
	public static String Test8 = "Fullscreen is running";
	public static String Test9 = "CreateFile is running";
	public static String Test10 = "CreateFile.WriterToFile is running";
	public static String Test11 = "CreateFile.ReadFromFile is running";
	
	// Human Written Errors
	private static String Error1 = "Error 1: The game could not start";
	private static String Error2 = "Error 2: Invald Resolution";
	private static String Error3 = "Error 3: ResTextChanger has encountered a error";
	private static String Error4 = "Error 4: ResolutionChanger has encountered a error";
	private static String Error5;
	private static String Error6;
	//private static String Error7;
	private static String Error8 = "Error 8: IOException in Primary files";
	private static String Error0 = "Invalid OS";
	
	private static boolean BError1;
	private static boolean BError2;
	private static boolean BError3;
	private static boolean BError4;
	private static boolean BError5;
	private static boolean BError6;
	private static boolean BError7;
	private static boolean BError8;
	
	public static void WriteErrorLog(String location, String StringMessage) {
		BufferedWriter bw;
                String Error;
                if(StringMessage.equals(Error0)) {
                	if(location.contains("/")) {
                		Error = "//DestinyorErrorLog.txt";
                		location = location + Error;
                	} else {
                		Error = "\\DestinyorErrorLog.txt";
                		location = location + Error;
                	}
                } else {
                	location = home + System.getProperty("file.separator") + "ErrorLog";
                }
		try {
			
			File file = new File(location);
			bw = new BufferedWriter(new FileWriter(file));
			
			if(Errors.isBError1()) {
				bw.write(Errors.Error1);
				bw.newLine();
			}
		
			if(Errors.isBError2()) {
				bw.write(Errors.Error2);
				bw.newLine();
				//bw.write("Width = " + Resolution.width() + " Height = " + Resolution.height());
				//bw.newLine();
				bw.write("Please Change the Settings.ini file to match one of these Width and Height values");
				bw.newLine();
				//for(int i = 0; i < Options.Resolutions.length; i++) {
				//bw.newLine();
				//bw.write("Desired Width = " + Options.Width[i] + " Desired Height = " + Options.Height[i]);
				bw.write("Desired Width = 1024");
				bw.newLine();
				bw.write("Desired Height = 768");
				bw.newLine();
				//}
				//bw.newLine();
			}
		
			if(Errors.isBError3()) {
				bw.write(Errors.Error3);
				bw.newLine();
			}
			
			if(Errors.isBError4()) {
				bw.write(Errors.Error4);
				bw.newLine();
			}
			
			if(Errors.isBError5()) {
				bw.write(Errors.Error5);
				bw.newLine();
			}
			
			if(Errors.isBError6()) {
				bw.write(Errors.Error6);
				bw.newLine();
			}
			
			if(Errors.isBError8()) {
				bw.write(Errors.Error8);
				bw.newLine();
			}
                
                
            if(StringMessage.equals("null")) {
            	bw.close();
            } else {   
                bw.write(StringMessage);
            }
            
            bw.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean isBError1() {
		return BError1;
	}
	public static void setBError1(boolean bError1) {
		BError1 = bError1;
	}
	public static boolean isBError2() {
		return BError2;
	}
	public static void setBError2(boolean bError2) {
		BError2 = bError2;
	}
	public static boolean isBError3() {
		return BError3;
	}
	public static void setBError3(boolean bError3) {
		BError3 = bError3;
	}
	public static boolean isBError4() {
		return BError4;
	}
	public static void setBError4(boolean bError4) {
		BError4 = bError4;
	}
	public static boolean isBError5() {
		return BError5;
	}
	public static void setBError5(boolean bError5) {
		BError5 = bError5;
	}
	public static boolean isBError6() {
		return BError6;
	}
	public static void setBError6(boolean bError6) {
		BError6 = bError6;
	}
	public static boolean isBError7() {
		return BError7;
	}
	public static void setBError7(boolean bError7) {
		BError7 = bError7;
	}
	public static boolean isBError8() {
		return BError8;
	}
	public static void setBError8(boolean bError8) {
		BError8 = bError8;
	}
        
        public static void setHome(String home) {
            Errors.home = home;
            //System.out.println(Errors.home);
        }
	
}
