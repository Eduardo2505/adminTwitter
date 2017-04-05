<%-- 
    Document   : index
    Created on : 23/02/2016, 11:08:40 AM
    Author     : INE
--%>

<%@page import="com.bsd.OperacionTwiterImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

</head>
<body>
    <%

        OperacionTwiterImpl daoope = new OperacionTwiterImpl();
        int cuenta = 1;
        //daoope.optenerSeguidoresPropios(cuenta);
        //daoope.optenerFriendsPropios(cuenta);
        //  daoope.purgar(cuenta);


        // Busqueda 
        double lat = 19.350000;
        double lon = -99.150002;
        double res = 5;
        String fecha = "2017-04-05";
        daoope.optenerSeguidores("desayuno", cuenta, lat, lon, res, fecha);
    %>


</body>

</body>
</html>
