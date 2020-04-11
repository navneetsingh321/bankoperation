package com.springboot.platform.error;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public class BNKErrorMessages {
	
	private ResourceBundle messageBundle = null;
			
	public BNKErrorMessages(ResourceBundle messageBundle) {
		this.messageBundle = messageBundle;
	}
	
	public String errorToText(BNKError error) {
		BNKErrors.TYPE type = error.getType();
		BNKErrors.CODE code = error.getCode();
		String info = error.getInfo();
		List<Object> messageArguments = new ArrayList<Object>();
		
		String msgPattern = "An unexpected error occurred ["+type+"."+code+"."+info+"]";
		if (messageBundle.containsKey(type+"."+code+"."+info)) {
			msgPattern = messageBundle.getString(type+"."+code+"."+info);
		} else if (messageBundle.containsKey(type+"."+code)) {
			msgPattern = messageBundle.getString(type+"."+code);
			Collections.addAll(messageArguments, new Object[] { info });
		} else if (messageBundle.containsKey(type.toString())) {
			msgPattern = messageBundle.getString(type.toString());
			Collections.addAll(messageArguments, new Object[] { code, info });
		}
		if (error.getMessageArguments() != null) {
			Collections.addAll(messageArguments, error.getMessageArguments());
		}
		
		MessageFormat formatter = new MessageFormat(msgPattern);
		return formatter.format(messageArguments.toArray());
	}
}