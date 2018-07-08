package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommentFilter implements Filter{
	private FilterConfig config;
	//容器启动后会立即创建一个过滤器
	public CommentFilter() {
		System.out.println("CommentFilter的构造器被调用了");
	}
  
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
//容器收到请求后会调用doFilter方法来处理请求
	//ServletRequest是HttpServletRequest的父接口（过度设计的产物）
	//，如果调用了FilterChain对象的doFilter方法，则表示继续向后调用，否则中断请求，返回处理结果
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
	
		//强制转换
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String content = request.getParameter("content");
		System.out.println(request.getServletContext());
		String illegal = config.getInitParameter("illegal");
		if (content.indexOf(illegal)!=-1) {
			//包含了敏感字，不再向后调用，返回处理结果
			response.getWriter().println("评论的内容包含了违禁字");
			
		}else{
			//没有敏感字，则继续调用
			chain.doFilter(request, response);//之后会调取service（request, response）方法
			
		}
		
		
	}
//容器创建好过滤器后，会立即调用该实例的init方法（初始化方法）
	//该方法只会执行一次
	//容器会将FilterConfig对象作为参数传进来，可以利用该对象读取初始化参数
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("这是commentFilter的init方法！");
		config = arg0;
		System.out.println(111);
		
	}

}
