package Controller;

import Entity.News;
import Service.NewService;
import jdk.nashorn.api.scripting.ScriptUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

@WebServlet(urlPatterns = "/SaveNewsServlet")
public class SaveNewsServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       News news=new News ();
        news.setNewID(Integer.valueOf( request.getParameter("newid")));
        news.setAuthor(request.getParameter("author"));
        String newsDate=request.getParameter("writedate");
        SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd"); //加上时间
        Date date= null;
        try {
            date = sDateFormat.parse(newsDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        news.setNewsDate(date);
        news.setNewsContent(request.getParameter("newcontent"));
        NewService service=new NewService();
        service.UpdateNews(news);
        request.getRequestDispatcher("ShowNewsListServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
