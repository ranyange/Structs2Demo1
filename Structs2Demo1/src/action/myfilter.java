package action;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import  biz.UserBiz;
import  biz.impl.UserBizImpl;

public class myfilter implements Filter {

	//过滤器拦截
	
	public void doFilter(ServletRequest srequest, ServletResponse sresponse,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("登录拦截doFilter方法");
		//登录拦截
		HttpServletRequest request = (HttpServletRequest)srequest;
		//强转
		HttpServletResponse response = (HttpServletResponse)sresponse;
		HttpSession session = request.getSession();
		//将页面保护起来
		String user = (String)session.getAttribute("username");
		if(user!=null&&!user.equals("")){
			chain.doFilter(request, response); //放行
		}else{
			String msg = "你还没有登录";
			//将未登录信息存储到request作用域;
			request.setAttribute("error", msg);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
	}

	public void destroy() {
		// TODO Auto-generated method stub
			System.out.println("销毁登录拦截Filter");
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("初始化登录拦截Filter");
	}

	 

}
