<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>

	<head>
		<title>Crear Kiosko</title>
	</head>	
	<body>
		<form:form method="post" commandName="kioskoForm" action="addKiosko">
		
			<br/>
			nombre:<form:input path="nombre"/>
			<br/>
			descripcion:<form:input path="description"/>
			
			<input type="submit" value="guardar"/>
		
		</form:form>
		
		
	
	</body>

</html>
