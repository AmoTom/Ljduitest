package com.Ljd.Ljduitest.common;

import org.testng.Assert;

import com.Ljd.Ljduitest.common.LogType.LogTypeName;

public class assertion {
	public static boolean flog = true;
	
	public static void verifyassert(Object actual, Object expected) {
		try {
			Assert.assertEquals(actual, expected);
		} catch (Error e) {
			// TODO: handle exception
			 flog = false;
		}
	}

	public static void verifyassert(Object actual, Object expected,String message) {
		try {
			flog = true;
			Assert.assertEquals(actual, expected, message);
		} catch (AssertionError e) {
			// TODO: handle exception
			flog = false;
			Logger.Output(LogType.LogTypeName.ERROR,e.getMessage()+".");
		}
	}
}
