<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Search and Availability</title>

<script src="https://code.jquery.com/jquery-3.3.1.js"
	integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
	crossorigin="anonymous"></script>
<script type="text/javascript">
	function S(){
		document.SearchForm.reset();
	}
	
</script>
</head>
<body onload="S();">
	<f:view>
		<h:form id="SearchForm">
			<div><center>
			<h1>Library Management System</h1>
				<h2>Search for book</h2>
				<h:inputText id="inputText" value="#{searchBean.search}"
					required="true" requiredMessage="Please enter any book details" style="width:400px;">
				</h:inputText>
				<br>
				<br>

				<h:commandButton value="CheckOut"
					action="#{searchBean.bookSearchCheckOut}"></h:commandButton>

				<h:commandButton value="CheckIn"
					action="#{searchBean.bookSearchCheckIn}" style="margin-left:30px;"></h:commandButton>

				<a href="AddBorrowers.jsp" style="margin-left:50px;">Add New Borrowers</a>
				
				<a href="Fines.jsp" style="margin-left:80px;">Fine Page</a>
				
				<h:messages />
</center>
			</div>
		</h:form>
	</f:view>
</body>
</html>