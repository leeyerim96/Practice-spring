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
         // 1. 요청분석
         // -> url 분석 , 해당 서비스를 찾아줌
         // -> 한글처리 , 변수 선언
         request.setCharacterEncoding("utf-8");
         response.setContentType("text/html; charset=utf-8");

         String uri = request.getRequestURI();
         String path = uri.substring(uri.lastIndexOf("/"));
         System.out.println("** uri =>" + uri);   
         
         //2.해당하는 Controller 검색
         //=> HandlerMapping을 통해 path에 해당하는 Controller 검색
         Controller action=hmapping.getController(path);
         //=> 해당 서비스 처리
         String vName = "/index.jsp";
         if (action!=null)
               vName=action.handleRequest(request, response);
         // 3. View 처리
         // redirect/forward 구분
         //=> redirect는 요청명에 ".do" 포함,
        
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