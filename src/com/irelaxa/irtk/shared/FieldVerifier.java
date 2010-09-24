package com.irelaxa.irtk.shared;

/**
 * <p>
 * FieldVerifier validates that the name the user enters is valid.
 * </p>
 * <p>
 * This class is in the <code>shared</code> packing because we use it in both
 * the client code and on the server. On the client, we verify that the name is
 * valid before sending an RPC request so the user doesn't have to wait for a
 * network round trip to get feedback. On the server, we verify that the name is
 * correct to ensure that the input is correct regardless of where the RPC
 * originates.
 * </p>
 * <p>
 * When creating a class that is used on both the client and the server, be sure
 * that all code is translatable and does not use native JavaScript. Code that
 * is note translatable (such as code that interacts with a database or the file
 * system) cannot be compiled into client side JavaScript. Code that uses native
 * JavaScript (such as Widgets) cannot be run on the server.
 * </p>
 */
public class FieldVerifier {

	/**
	 * Verifies that the specified name is valid for our service.
	 * 
	 * In this example, we only require that the name is at least four
	 * characters. In your application, you can use more complex checks to ensure
	 * that usernames, passwords, email addresses, URLs, and other fields have the
	 * proper syntax.
	 * 
	 * @param name the name to validate
	 * @return true if valid, false if invalid
	 */
	public static boolean isValidName(String name) {
		if (name == null) {
			return false;
		}
		return name.length() > 3;
	}
	public static String getMonth(int i){
		String month = null;
		switch (i) {

		case 0:
			 month = "January";
			break;
		case 1:
			month = "February";
			break;
		case 2:
			 month = "March";
			break;
		case 3:
			month = "April";
			break;
		case 4:
			 month = "May";
			break;
		case 5:
			month = "June";
			break;
		case 6:
			 month = "July";
			break;
		case 7:
			month = "August";
			break;
		case 8:
			 month = "September";
			break;
		case 9:
			month = "October";
			break;
		case 10:
			 month = "November";
			break;
		case 11:
			month = "December";
			break;
			
			
		}
		return month;	
	}
}
