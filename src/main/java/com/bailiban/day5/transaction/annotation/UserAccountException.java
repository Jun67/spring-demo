package com.bailiban.day5.transaction.annotation;

public class UserAccountException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UserAccountException() {
        super();
        // TODO Auto-generated constructor stub
    }

    public UserAccountException(String arg0, Throwable arg1, boolean arg2,
                                boolean arg3) {
        super(arg0, arg1, arg2, arg3);
        // TODO Auto-generated constructor stub
    }

    public UserAccountException(String arg0, Throwable arg1) {
        super(arg0, arg1);
        // TODO Auto-generated constructor stub
    }

    public UserAccountException(String arg0) {
        super(arg0);
        // TODO Auto-generated constructor stub
    }

    public UserAccountException(Throwable arg0) {
        super(arg0);
        // TODO Auto-generated constructor stub
    }
}
