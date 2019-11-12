package org.opendatakit.aggregate.redrose;

import java.lang.reflect.Method;

import javax.servlet.ServletException;

import com.google.gwt.user.client.rpc.RpcToken;
import com.google.gwt.user.client.rpc.RpcTokenException;
import com.google.gwt.user.server.rpc.AbstractXsrfProtectedServiceServlet;
import com.google.gwt.user.server.rpc.XsrfTokenServiceServlet;

public class MyXsrfServlet extends AbstractXsrfProtectedServiceServlet {
	private static final long serialVersionUID = 1L;
	String sessionCookieName = null;

	public MyXsrfServlet() {
		this(null);
	}

	public MyXsrfServlet(String sessionCookieName) {
		this.sessionCookieName = sessionCookieName;
	}

	public MyXsrfServlet(Object delegate) {
		this(delegate, null);
	}

	public MyXsrfServlet(Object delegate,
			String sessionCookieName) {
		super(delegate);
		this.sessionCookieName = sessionCookieName;
	}

	@Override
	public void init() throws ServletException {
		super.init();
		// do not overwrite if value is supplied in constructor
		if (sessionCookieName == null) {
			// servlet configuration precedes context configuration
			sessionCookieName = getServletConfig().getInitParameter(
					XsrfTokenServiceServlet.COOKIE_NAME_PARAM);
			if (sessionCookieName == null) {
				sessionCookieName = getServletContext().getInitParameter(
						XsrfTokenServiceServlet.COOKIE_NAME_PARAM);
			}
		}
	}

	protected boolean shouldValidateXsrfToken(Method method) {
		return false;
	}
	
	@Override
	protected void validateXsrfToken(RpcToken token, Method method)
			throws RpcTokenException {
	}
}
