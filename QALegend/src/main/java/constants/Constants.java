package constants;

import java.io.File;

public class Constants {
	
	public static final String TEST_DATA_EXCELPATH = "\\src\\main\\resources\\Test_Data.xlsx";	
	public static final String HOME_DIRECTORY = System.getProperty("user.dir");	
	public static final String LOGIN_PAGE ="LoginPage";
	public static final String HOME_PAGE = "HomePage";
	public static final String RESET_PAGE = "ResetPage";
	public static final String ADD_USER = "AddUser";
	public static final String USERS_PAGE = "Users";
	public static final String MAILID_EXTENSION = "@yahoo.com";
	public static final String Welcome_MSG = "Welcome ";
	public static final String COMMA = ",";
	public static final String DOT = ".";
	public static final String NEWUSERLOGIN_ERROR = "Login in with new User is not successful";
	public static final String CONFIGFILE = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "config.properties";
}
