package murach.email;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import murach.business.User;
//import murach.data.UserDB;
@WebServlet(urlPatterns = {"/emailList"})
public class EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/tuan4.html";
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        // get current action
        String action = request.getParameter("action");
        System.out.println("Gia tri cua action: "+action);
        if (action == null) {
            action = "join";// default action
        } // perform action and set URL to appropriate page 
        if (action.equals ("join")) { url = "/tuan4.html"; 
            // the "join" page 
        }
        else if (action.equals("add")) {
            // get parameters from the request
            
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String hear = request.getParameter("hear");
            String[] noti= request.getParameterValues("noti");
            String con= request.getParameter("con");
            Date date;
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
                User user = new User (firstName, lastName, email,date,hear,noti,con); 
                request.setAttribute ("user", user); 
                url = "/thank.jsp";
            } catch (ParseException ex) {
                Logger.getLogger(EmailListServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            // store data in User object and save User object in db 
           
            //UserDB. insert (user);
            // set User object in request object and set URL 
            
        }
        // forward request and response objects to specified URL 
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
