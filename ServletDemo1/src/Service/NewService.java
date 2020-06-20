package Service;
import DAL.SqlHelper;
import Entity.News;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class NewService {
    public void AddNews(){}
    public boolean DeleteNews(int newID){
        String sql="delete from News where NewID="+newID;
        System.out.println(sql);
         boolean result= SqlHelper.executeUpdate(sql);
         return result;
    }
    public boolean UpdateNews(News news){

        String sql="update News set NewsContent='"+news.getNewsContent()+"'   where NewID="+ news.getNewID();
        System.out.println(sql);
        boolean result= SqlHelper.executeUpdate(sql);
        return result;

    }
    public List<News> QueryNews() throws SQLException {
        String sql="Select * from News";
        ResultSet rs;
        rs= SqlHelper.executeQuery(sql);
        List<News> lstNews=new ArrayList<News>();
        while (rs.next()){
            News news=new News();
            news.setNewID(rs.getInt("NewID"));
            news.setTitle(rs.getString("Category"));
            news.setNewsContent(rs.getString("NewsContent"));
            news.setAuthor(rs.getString("Author"));
            news.setNewsDate(rs.getDate("NewsDate"));
            lstNews.add(news);
        }
        return lstNews;
    }
    public News GetNews(int newID) throws SQLException {
        String sql="Select * from News where NewID="+newID;
        ResultSet rs;
        rs= SqlHelper.executeQuery(sql);
        News  news=new News();
        if (rs.next()){
            news.setNewID(rs.getInt("NewID"));
            news.setTitle(rs.getString("Category"));
            news.setNewsContent(rs.getString("NewsContent"));
            news.setAuthor(rs.getString("Author"));
            news.setNewsDate(rs.getDate("NewsDate"));
        }
        return news;

    }
}
