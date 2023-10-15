package murach.download;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import murach.business.Product;
import murach.business.User;
import murach.business.UserIO;
import murach.util.CookieUtil;
//import murach.data.UserIO;
//import murach.util.CookieUtil;
@WebServlet(urlPatterns = {"/download"})
public class DownloadServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "viewAlbums";
        }
        String url = "/7_1.jsp";
        if (action.equals("viewAlbums")) {
            url = "/7_1.jsp";
        } else if (action.equals("checkUser")) {
            url = checkUser(request, response);
        } else if (action.equals("view_cookies")) {
            url = "/viewcookie.jsp";
            Cookie[] cookies = request.getCookies();
            request.setAttribute("cookies", cookies);
        } 
        else if (action.equals("delete_cookies")) {
            url = "/viewcookie.jsp";
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies ) {
               cookie.setValue("");
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
            }
            request.setAttribute("cookies", cookies);
        } 
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        String url = "/7_1.jsp";
        if (action.equals("registerUser")) {
            url = registerUser(request, response);
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    private String checkUser(HttpServletRequest request, HttpServletResponse response) {
        String productCode = request.getParameter("productCode");
        Product product =  new Product(productCode);  
        HttpSession session = request.getSession();
        session.setAttribute("product", product);
        User user = (User) session.getAttribute("user");
        String url;
        if (user == null) {
            Cookie[] cookies = request.getCookies();
            String emailAddress = CookieUtil.getCookieValue(cookies, "emailCookie");
            if (emailAddress == null || emailAddress.equals("")) {
                url = "/register.jsp";
            } else {
                ServletContext sc = getServletContext();
                String path = sc.getRealPath("/WEB-INF/EmailList.txt");
                user = UserIO.getUser(emailAddress, path);
                session.setAttribute("user", user);
                url = "/" + product.getCode() + "download.jsp";
            }
        } else {
            url = "/" + product.getCode() + "download.jsp";
        }
        return url;
    }
    private String registerUser(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        User user = new User(firstName, lastName, email);
        ServletContext sc = getServletContext();
        String path = sc.getRealPath("/WEB-INF/EmailList.txt");
        UserIO.add(user, path);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        Cookie c = new Cookie("emailCookie", email);
        c.setMaxAge(60 * 60 * 24 * 365 * 2); 
        c.setPath("/");
        response.addCookie(c); 
        Product product = (Product) session.getAttribute("product");
        String url = "/" + product.getCode() + "download.jsp";
        return url;
    }
}