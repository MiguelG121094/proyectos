<%-- 
    Document   : reporte_per
    Created on : 21/11/2022, 02:03:54 PM
    Author     : Miguel
--%>

<%@page import="Conexion.gbl"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.io.File"%>
<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
          System.out.println("Entra al reporte");                
          try {
                  String accion = request.getParameter("accion");
                  String id = request.getParameter("id");
                  int id_per = Integer.parseInt(id);
                  File reporte = null;
                  Map<String, Object> parameter = new HashMap<String, Object>();
                  if (accion.equalsIgnoreCase("sin")) {
                        reporte = new File(application.getRealPath("reportes/per1.jasper"));
                        
                  } else if(accion.equalsIgnoreCase("param")){
                        reporte = new File(application.getRealPath("reportes/per2.jasper"));
                        parameter.put("p_id", id_per);
                  }
                  //reporte = new File(application.getRealPath("reportes/per1.jasper"));
                  //Map<String, Object> parameter = new HashMap<String, Object>();
                  
                  byte[] bytes = JasperRunManager.runReportToPdf(reporte.getPath(), parameter, gbl.cx.conectar_reporte());
                  response.setContentType("application/pdf");
                  response.setContentLength(bytes.length);
                  ServletOutputStream outS = response.getOutputStream();
                  outS.write(bytes, 0, bytes.length);
                  outS.flush();
                  outS.close();
              } catch (Exception e) {
                  System.out.println("Error: " + e);
              }
        %>
    </body>
</html>