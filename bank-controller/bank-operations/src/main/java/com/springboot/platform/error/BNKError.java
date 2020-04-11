package com.springboot.platform.error;

import java.util.Arrays;

import com.springboot.platform.error.BNKErrors.CODE;
import com.springboot.platform.error.BNKErrors.TYPE;



public class BNKError {

	private final BNKErrors.TYPE type;
	private final BNKErrors.CODE code;
	private final Object[] messageArguments;
	private final String info;
	private String relatedEntity;
	
	public BNKError(TYPE type, CODE code, Object[] messageArguments, String info) {
		super();
		this.type = type;
		this.code = code;
		this.messageArguments = messageArguments;
		this.info = info;
	}
	
	public BNKError(TYPE type, CODE code, Object[] messageArguments, String info, String relatedEntity) {
		super();
		this.type = type;
		this.code = code;
		this.messageArguments = messageArguments;
		this.info = info;
		this.relatedEntity = relatedEntity;
	}
	
	public BNKErrors.TYPE getType() {
		return type;
	}
	public BNKErrors.CODE getCode() {
		return code;
	}
	public Object[] getMessageArguments() {
		return messageArguments;
	}
	public String getInfo() {
		return info;
	}
	public String getRelatedEntity() {
		return relatedEntity;
	}

	@Override
	public String toString() {
		return "TEMNError [type=" + type + ", code=" + code
				+ ", messageArguments=" + Arrays.toString(messageArguments)
				+ ", info=" + info + ", relatedEntity=" + relatedEntity + "]";
	}
}
