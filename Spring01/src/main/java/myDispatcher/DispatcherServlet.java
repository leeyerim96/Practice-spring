package myDispatcher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DispatcherServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
   private HandlerMapping hmapping;
   private ViewResolver viewResolver;
   
    public DispatcherServlet() {
        super();
        hmapping = new HandlerMapping();
        viewResolver = new ViewResolver();
        viewResolver.setPrefix("/mView/");
        viewResolver.setSuffix(".jsp");
    }
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         // 1. ��û�м�
         // -> url �м� , �ش� ���񽺸� ã����
         // -> �ѱ�ó�� , ���� ����
         request.setCharacterEncoding("utf-8");
         response.setContentType("text/html; charset=utf-8");

         String uri = request.getRequestURI();
         String path = uri.substring(uri.lastIndexOf("/"));
         System.out.println("** uri =>" + uri);   
         
         //2.�ش��ϴ� Controller �˻�
         //=> HandlerMapping�� ���� path�� �ش��ϴ� Controller �˻�
         Controller action=hmapping.getController(path);
         //=> �ش� ���� ó��
         String vName = "/index.jsp";
         if (action!=null)
               vName=action.handleRequest(request, response);
         // 3. View ó��
         // redirect/forward ����
         //=> redirect�� ��û�� ".do" ����,
        
         if(vName.contains(".do"))
               response.sendRedirect(vName);
          else {
        	  vName=viewResolver.getView(vName);
        	  request.getRequestDispatcher(vName).forward(request, response); 
          }
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }

}