package com.nagarro.constant;

public class Constant {
	public static final String REST_URL = "http://localhost:8080/EmployeeManagement/";
	public static final String GET_ALL_EMPLOYEES = "employees/";
	public static final String PUT_EMPLOYEE = "employee/";
	public static final String GET_EMPLOYEE = "employee/";
	public static final String POST_EMPLOYEE = "employee/";
	public static final String CSV_SEPERATOR = ",";
	public static final String CSV_FILE_NAME = "EmployeeData.csv";
	public static final String[] DISPLAY_HEADER = { "Id", "Employee Code", "Employee Name", "Location", "Email",
			"Date Of Birth" };
	public static final String[] BEAN_HEADER = { "id", "employeeCode", "employeeName", "location", "email",
			"dateOfBirth" };

	private static Constant constantParamsObject = null;

	private Constant() {
		super();
	}

	public static final Constant getObject() {
		if (constantParamsObject == null) {
			constantParamsObject = new Constant();
		}
		return constantParamsObject;
	}
}