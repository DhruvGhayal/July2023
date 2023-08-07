package data;

import utilities.Xls_Reader;

public class DataFile {
	
	Xls_Reader d = new Xls_Reader("D:\\QA\\Testing\\NikulTest.xlsx");
	//login
	public String specialcharemail=d.getCellData("Data1", "UserName", 4);
	public String password=d.getCellData("Data1", "Password", 2);
	public String wrongemail= d.getCellData("Data1", "UserName", 3);
	public String specialcharemailerr= d.getCellData("Data1", "Email Error", 5);
	public String emptyemailerr= d.getCellData("Data1", "Email Error", 4);
	public String emptypassworderr= d.getCellData("Data1", "Password Error", 3);
	public String wrongemailpassworderr=d.getCellData("Data1", "Global Error", 2);
}
