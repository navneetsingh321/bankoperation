package com.springboot.platform.error;

public interface BNKErrors {

	public enum TYPE {
		VALIDATION_ERROR,	// indicates a problem with the supplied values
		DUPLICATE_DATA_ERROR, // indicates a problem with duplicate identifying data/value
		DATA_NOT_FOUND_ERROR,	// indicates that there is no data for the supplied values
		FATAL_ERROR,		// indicates an unrecoverable error e.g. database connection lost
		ACCESS_DENIED
	}
	
	public enum CODE {
		AUTHORISATION_FAILED,		// an attempt to access a secured resource
		DEPENDENCY_NOT_SATISFIED,	// The operated entity has dependencies that prevent this action
		INPUT_MISSING,				// a required value has not been supplied
		DATA_NOT_FOUND,				// indicates that there is no data for the supplied values
		NON_NUMERIC,				// a field requires a numeric value (specific codes for basic types)
		NON_DATE,					// a field requires a numeric value (specific codes for basic types)
		INVALID_FORMAT,				// a field requires a specific format and the supplied value does not match the format
		FK_NOT_FOUND,				// a field contains an invalid reference key
		CROSS_VALIDATE_INVALID,		// the values supplied in one or more fields do not make sense or contradict one another
		DUPLICATE,					// duplicate field already exists in the database
		INFRA_ERROR,				// Error received from Infra server
		INTERNAL_SERVER_ERROR,		// Error received from internal server
		INVALID_DATA				// data supplied is invalid 
	}
}