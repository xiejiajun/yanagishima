package yanagishima.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import yanagishima.config.YanagishimaConfig;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@Singleton
public class QueryDetailServlet extends HttpServlet {

	private static Logger LOGGER = LoggerFactory.getLogger(QueryDetailServlet.class);

	private static final long serialVersionUID = 1L;

	private YanagishimaConfig yanagishimaConfig;

	@Inject
	public QueryDetailServlet(YanagishimaConfig yanagishimaConfig) {
		this.yanagishimaConfig = yanagishimaConfig;
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String datasource = Optional.ofNullable(request.getParameter("datasource")).get();
		String prestoRedirectServerServer = yanagishimaConfig
				.getPrestoRedirectServer(datasource);
		response.sendRedirect(prestoRedirectServerServer + "/query.html?" + request.getParameter("queryid"));

	}

}
