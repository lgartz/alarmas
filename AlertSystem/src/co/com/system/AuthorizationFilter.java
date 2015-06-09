/**
 * 
 */
package co.com.system;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;


public class AuthorizationFilter implements Filter {

	private String ctxPath;
	private String errorPage;
	private String homePage;
	private String defaultAuthExpression;
	private String unprotectedResources;
	private List<String> defaultAuthorizationRulesRegex;
	private List<String> unprotectedResourcesRulesRegex;

	/**
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 *      javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		boolean authorized = true;

		String requestedURI = ((javax.servlet.http.HttpServletRequest) arg0)
				.getRequestURI();

		/*
		 * Descartar par�metros GET
		 */
		int idx = requestedURI.indexOf('?');
		if (idx != -1) {
			requestedURI = requestedURI.substring(0, idx);
		}

		/*
		 * Si se solicita la ra�z redireccionar a home
		 */
		if (requestedURI.equals(ctxPath + "/") && homePage != null
				&& !homePage.trim().isEmpty()) {
			((HttpServletResponse) arg1).sendRedirect(ctxPath + homePage);
			return;
		}

		try {
//			InitialContext context = new InitialContext();
//			String jndiName = "java:app/Html5Jboss/SecurityContext!HBT.PoC.ISecurityContextLocal";
//			ISecurityContext securityContext = (ISecurityContext) context.lookup(jndiName);
//			System.out.println("User!!!! "+securityContext.getUser());
			
//			if (requestedURI.equals("/Html5Jboss/ConsultarR.html")) {
//				UserContext user = new UserContext();  
//		    	user.setUser("usuario1");
//		    			((javax.servlet.http.HttpServletRequest) arg0)
//				.getSession().setAttribute("user", user);
//			}
			
//			if (requestedURI.equals("/Html5Jboss/ConsultarR_rest.html")) {
			if (!isUnprotectedResource(requestedURI)) {	
				UserContext user = (UserContext) ((javax.servlet.http.HttpServletRequest) arg0)
				.getSession().getAttribute("user");

				if (user != null) {
					if (!user.getUser().equals("admin")) {
						((HttpServletResponse) arg1).sendRedirect(ctxPath
								+ errorPage);
					}
				} else {
					((HttpServletResponse) arg1).sendRedirect(ctxPath
							+ errorPage);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
				
		System.out.println("Filtros !! -> " + requestedURI);

		arg2.doFilter(arg0, arg1);
		
		
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		/*
		 * Cargar la p�gina de error
		 */
		errorPage = arg0.getInitParameter("errorPage");
		if (errorPage == null || errorPage.trim().isEmpty()) {
			throw new ServletException("security.errorPageRequired");
		}

		homePage = arg0.getInitParameter("homePage");

		/*
		 * Cargar el contexto web
		 */
		ctxPath = arg0.getServletContext().getContextPath();

		/*
		 * Cargar la expresi�n de autorizaci�n por defecto.
		 */
		defaultAuthExpression = arg0.getInitParameter("defaultAuthExpression");
		if (defaultAuthExpression != null
				&& !defaultAuthExpression.trim().isEmpty()) {
			defaultAuthorizationRulesRegex = ruleBuilder(ctxPath,
					defaultAuthExpression);
			defaultAuthorizationRulesRegex.add(ctxPath + errorPage);
		}

		/*
		 * Cargar las expresiones para los recursos no protegidos
		 */
		unprotectedResources = arg0.getInitParameter("unprotectedResources");
		if (unprotectedResources != null
				&& !unprotectedResources.trim().isEmpty()) {
			unprotectedResourcesRulesRegex = ruleBuilder(ctxPath,
					unprotectedResources);
			unprotectedResourcesRulesRegex.add(ctxPath + errorPage);
			unprotectedResourcesRulesRegex.add(ctxPath + homePage);
		}
	}

	private List<String> ruleBuilder(String ctxPath, String expression) {
		List<String> rulesRegex = new ArrayList<String>();
		String[] rules = expression.split(",");
		for (String rule : rules) {
			if (rule.startsWith("/")) {
				rule = rule.replaceFirst("/", ctxPath + "/");
			}
			rulesRegex.add(rule.replaceAll("\\.", "\\\\.")
					.replaceAll("\\*", ".+?").trim());
		}
		return rulesRegex;
	}

	private boolean isUnprotectedResource(String requestedURI) {
		boolean matches = false;

		for (String rule : unprotectedResourcesRulesRegex) {
			if (requestedURI.matches(rule)) {
				return true;
			}
		}

		return matches;
	}

	private boolean matchesAnyDefaultRule(String requestedURI) {
		boolean matches = false;

		for (String rule : defaultAuthorizationRulesRegex) {
			if (requestedURI.matches(rule)) {
				return true;
			}
		}

		return matches;
	}

	@Override
	public void destroy() {

	}
}
