package org.opendatakit.aggregate.redrose;

import com.google.gwt.user.client.rpc.RpcToken;
import com.google.gwt.user.client.rpc.RpcTokenException;
import com.google.gwt.user.server.rpc.AbstractXsrfProtectedServiceServlet;

import java.lang.reflect.Method;

import javax.servlet.ServletException;

public class MyXsrfProtectedServiceServlet extends AbstractXsrfProtectedServiceServlet {

    public MyXsrfProtectedServiceServlet() {
        this((String)null);
    }

    public MyXsrfProtectedServiceServlet(String sessionCookieName) {
    }

    public MyXsrfProtectedServiceServlet(Object delegate) {
        this(delegate, (String)null);
    }

    public MyXsrfProtectedServiceServlet(Object delegate, String sessionCookieName) {
        super(delegate);
    }

    public void init() throws ServletException {
        super.init();

    }

    protected void validateXsrfToken(RpcToken token, Method method) throws RpcTokenException {

    }

    protected boolean shouldValidateXsrfToken(Method method) {
        return false;
    }

}