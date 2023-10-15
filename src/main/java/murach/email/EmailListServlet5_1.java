package murach.email;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import murach.business.User;
@WebServlet(urlPatterns = {"/emailList5_1"})
public class EmailListServlet5_1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/5_1.jsp";
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        // get current action
        String action = request.getParameter("action");
        System.out.println("Gia tri cua action: "+action);
        if (action == null) {
            action = "join";// default action
        } // perform action and set URL to appropriate page 
        if (action.equals ("join")) { url = "/5_1.jsp"; 
            // the "join" page 
        }
        else if (action.equals("add")) {
            // get parameters from the request
            
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            User user = new User (firstName, lastName, email); 
            url = "/thank5_1.jsp";
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        // Đặt giá trị năm hiện tại như một thuộc tính của request
                        // validate the parameters
            request.setAttribute("currentYear", currentYear );
            LocalDateTime currentDate = LocalDateTime.now();
            request.setAttribute("currentdate", currentDate );
            ArrayList<User> users = new ArrayList<>();
            users.add(new User ("John", "Smith", "jsmith@gmail.com"));
            users.add(new User ("Trieu", "Huynh", "huynh@gmail.com"));
            request.setAttribute("users", users );
            request.setAttribute("custServEmail", "custserv@murach.com" );
            String message;
            if (firstName == null || lastName == null || email == null ||firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()) {
                message = "Please fill out all three text boxes.";
                request.setAttribute("message", message);
                url = "/5_1.jsp"; // the "thanks" page
                request.setAttribute("currentYear", "" );
            }
            request.setAttribute ("user", user); 
            

            
        }
        // forward request and response objects to specified URL 
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
   

   

}
