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
		if (!$("input#check").is(':checked')) {
			clearForm();
		}
	}
	function clearForm() {
		document.MyForm.reset();
	}
	function paidFine() {
		var checkboxes = document.querySelectorAll("input#check:checked");

		if (checkboxes == null) {
			alert("Please select atleast one record");
		}

		var paid = [];
		var card_id = [];
		var fine_amt = [];
		jQuery(checkboxes).each(
				function(key, el) {

					card_id.push(jQuery(el).closest("tr").find(
							"[id$='card_id']").text());

					fine_amt.push(jQuery(el).closest("tr").find(
							"[id$='fine_amt']").text());
					paid.push(jQuery(el).closest("tr").find("[id$='paid']")
							.text());
				})

		var flag = 1
		jQuery(paid).each(function(key, el) {
			if (el == "true") {
				flag = 0;
			}
		})
 
			$.ajax({
				url : "/LibraryManagementSystem/PaidFine",
				data : {
					"card_id" : card_id.toString(),
					"fine_amt" : fine_amt.toString(),
					"f_paid" : paid.toString(),
					"flag" : flag.toString()
				},
				type : "post",
				success : function(response) {
					if (response) {
						alert(response);
					}
					window.location = "SearchBook.jsp";
				}
			});
		

	}
</script>

</head>
<body onload="clearForm()">
	<f:view>
		<h:form id="MyForm">
			<center>
				<pre>CARD ID     FINE AMOUNT      PAID</pre>
				<h:dataTable value="#{finesBean.fines}" var="f">
					<h:column>
						<h:outputText value="#{f.card_id}" id="card_id"></h:outputText>
					</h:column>
					<h:column>
						<h:outputText value="#{f.fine_amt}" id="fine_amt"
							style="margin-left:30px;"></h:outputText>
					</h:column>
					<h:column>
						<h:outputText value="#{f.paid}" id="paid"
							style="margin-left:100px;"></h:outputText>
					</h:column>
					<h:column>
						<input type="checkbox" onclick="checkingChecked()" id="check"></input>
					</h:column>
				</h:dataTable>

				<h:commandButton value="Paid Fine" onclick="paidFine()"></h:commandButton>
			</center>
		</h:form>

	</f:view>

</body>
</html>