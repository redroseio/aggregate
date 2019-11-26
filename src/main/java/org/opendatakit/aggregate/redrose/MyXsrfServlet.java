package org.opendatakit.aggregate.redrose;

import java.lang.reflect.Method;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import javax.servlet.http.Cookie;

import com.google.gwt.user.client.rpc.RpcToken;
import com.google.gwt.user.client.rpc.RpcTokenException;
import com.google.gwt.user.client.rpc.XsrfToken;
import com.google.gwt.user.server.Util;
import com.google.gwt.user.client.rpc.XsrfTokenService;
import com.google.gwt.util.tools.shared.Md5Utils;
import com.google.gwt.util.tools.shared.StringUtils;

public class MyXsrfServlet extends RemoteServiceServlet implements XsrfTokenService {
	private static final long serialVersionUID = 1L;
	public MyXsrfServlet() {
		this(null);
	}

	public MyXsrfServlet(String sessionCookieName) {
	}

	public MyXsrfServlet(Object delegate) {
		this(delegate, null);
	}

	public MyXsrfServlet(Object delegate,
						 String sessionCookieName) {
		super(delegate);
	}

	public XsrfToken getNewXsrfToken() {
		return new XsrfToken(this.generateTokenValue());
	}

	public void init() {
	}

	private String getInitParameterValue(String name) {
		String paramValue = null;
		paramValue = this.getServletConfig().getInitParameter(name);
		if (paramValue == null) {
			paramValue = this.getServletContext().getInitParameter(name);
		}

		return paramValue;
	}

	private String generateTokenValue() {
		return StringUtils.toHexString(Md5Utils.getMd5Digest("RedRose".getBytes()));
	}
}
