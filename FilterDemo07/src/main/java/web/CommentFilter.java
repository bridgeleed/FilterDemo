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
	//�������������������һ��������
	public CommentFilter() {
		System.out.println("CommentFilter�Ĺ�������������");
	}
  
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
//�����յ����������doFilter��������������
	//ServletRequest��HttpServletRequest�ĸ��ӿڣ�������ƵĲ��
	//�����������FilterChain�����doFilter���������ʾ���������ã������ж����󣬷��ش�����
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
	
		//ǿ��ת��
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String content = request.getParameter("content");
		System.out.println(request.getServletContext());
		String illegal = config.getInitParameter("illegal");
		if (content.indexOf(illegal)!=-1) {
			//�����������֣����������ã����ش�����
			response.getWriter().println("���۵����ݰ�����Υ����");
			
		}else{
			//û�������֣����������
			chain.doFilter(request, response);//֮����ȡservice��request, response������
			
		}
		
		
	}
//���������ù������󣬻��������ø�ʵ����init��������ʼ��������
	//�÷���ֻ��ִ��һ��
	//�����ὫFilterConfig������Ϊ�������������������øö����ȡ��ʼ������
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("����commentFilter��init������");
		config = arg0;
		System.out.println(111);
		
	}

}
