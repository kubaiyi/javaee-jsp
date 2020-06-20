<%--
  Created by IntelliJ IDEA.
  User: wangbing
  Date: 2020/5/28
  Time: 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<span class="cp_title">新闻管理</span>
<div class="add_cp">
    <a href="logo.html">+添加新闻</a>
</div>
<div class="table_con">
    <table>
        <tr class="tb_title">
            <td width="10%">ID</td>
            <td width="30%">标题</td>
            <td width="12%">内容</td>
            <td width="12%">作者</td>
            <td width="10%">时间</td>
            <td width="26%">操作</td>
        </tr>
        <c:forEach var="news" items="${lstNews}" >
            <tr>
                <td width="10%">${news.title}</td>
                <td width="30%">${news.newsContent} </td>
                <td width="12%">${news.author}</td>
                <td width="12%">${news.newsDate}</td>
                <td width="10%">—</td>
                <td width="26%">
                    <a href="EditNewsServlet?newid=${news.newID}" class="del_btn">编辑</a>
                    <a href="viewServlet?newid=${news.newID}" class="del_btn">查看</a>
                    <a href="DeleteNewsServlet?newid=${news.newID}" class="del_btn">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
