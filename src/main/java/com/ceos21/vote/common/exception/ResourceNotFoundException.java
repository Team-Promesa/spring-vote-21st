package com.ceos21.vote.common.exception;

public class ResourceNotFoundException extends VoteCodeException{

    public static final ResourceNotFoundException EXCEPTION = new ResourceNotFoundException();
    private ResourceNotFoundException() {super(GlobalErrorCode.RESOURCE_NOT_FOUND);}
}
