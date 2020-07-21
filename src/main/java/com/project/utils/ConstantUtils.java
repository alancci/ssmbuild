package com.project.utils;

import java.util.HashMap;
import java.util.Map;

public class ConstantUtils {

	public final static String USER_DEAULT_PASSWORD = "wdyh123!";
	public static final class SystemDefaultRole{
		public static final Integer ADMIN = 999;
	}
	
	public final static class ExeCode {
		public final static String SUCCESS = "Y";
		public final static String FAILED = "N";
	}

	public final static class ExeCodeString {
		public final static String SUCCESS = "SUCCESS";
		public final static String FAILED = "FAIL";
		public final static String UNANTH = "UNAUTH";
		public final static String UNKNOWN_USER = "UNKNOWN_USER";
		public final static String CHECK_FAILED = "CHECK_FAILED";
		public final static String OUT_OF_DATE = "OUT_OF_DATE";
	}

}
