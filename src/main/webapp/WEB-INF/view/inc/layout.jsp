<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title></title>
  </head>
  <body>
    <!-- header 부분 -->
     <tiles:insertAttribute name="header" /> 
   

    <!-- --------------------------- <body> --------------------------------------- -->
    <div id="body">
      <div class="content-container">
        <!-- --------------------------- main --------------------------------------- -->

       <tiles:insertAttribute name="main" /> 
      
      </div>
    </div>
  </body>
</html>
