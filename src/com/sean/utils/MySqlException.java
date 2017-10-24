package com.sean.utils;

public class MySqlException extends Exception {

	public MySqlException() {
		super();
	}

	public MySqlException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public MySqlException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public MySqlException(String arg0) {
		super(arg0);
	}

	public MySqlException(Throwable arg0) {
		super(arg0);
	}

}
