<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fine Details</title>

<script src="https://code.jquery.com/jquery-3.3.1.js"
	integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
	crossorigin="anonymous"></script>
<script type="text/javascript">
	function checkingChecked() {
		if ($("input#check").is(':checked')) {

		} else {
			clearForm();
		}
	}
	function clearForm() {
		document.MyForm1.reset();
	}

</script>


</head>
<body onload="clearForm()">
	<h:form id="MyForm1">
		<pre>CARD ID      FINE AMOUNT      PAID</pre>
		<h:dataTable value="#{finesBean.fines}" var="f">
			<h:column>
				<h:inputText value="#{f.card_id}" id="card_id"></h:inputText>
			</h:column>
			<h:column>
				<h:inputText value="#{f.fine_amt}" id="fine_amt"></h:inputText>
			</h:column>
			<h:column>
				<h:inputText value="#{f.paid}" id="paid"></h:inputText>
			</h:column>
			<h:column>
				<input type="checkbox" onclick="checkingChecked()" id="check"></input>
			</h:column>

		</h:dataTable>
		
		<h:commandButton value="Submit" onclick="update()"></h:commandButton>
	</h:form>

</body>
</html>