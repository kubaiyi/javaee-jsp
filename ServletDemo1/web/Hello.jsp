<%--
  Created by IntelliJ IDEA.
  User: wangbing
  Date: 2020/5/28
  Time: 8:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <%
    for ( int i=0; i<2; i++ )
    {
   %>
          你好<br>
    <%
    }
   %>
    <%
       String Msg = "This is JSP test.";
       out.print("Hello World!");
     %>
     <h2><%=Msg%></h2>

   <h1>JSP表达式 </h1>
   <b>PI 的值： </b><%=Math.PI %><br />
   <b>Max :</b><%=Math.max(100,99) %><br/>
   <b>Min :</b><%=Math.min(100,99) %><br/>
   <b>3+2-5的值 :</b><%=3+2-5 %><br/>

</body>
</html>
