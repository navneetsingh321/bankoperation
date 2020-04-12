package com.springboot.platform.utils;

import com.relops.snowflake.Snowflake;

public class Utils {

	public static String generateUniqueId() {
		// Doesn't generate unique ID if more than one call is executed within a
		// millisecond,
		// that's why a short delay was introduced
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int node = 1;
		Snowflake s = new Snowflake(node);
		long id = s.next();
		// byte[] bytes = ByteBuffer.allocate(Long.SIZE /
		// Byte.SIZE).putLong(id).array();
		// String enc = Base64.encodeBase64URLSafeString(bytes);
		String enc = Long.toString(id, 36);
		return enc;
	}

}
