<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@ taglib prefix="f"
	uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Check In</title>
<script src="https://code.jquery.com/jquery-3.3.1.js"
	integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
	crossorigin="anonymous"></script>
<script type="text/javascript">
	function clearForm() {
		document.MyForm1.reset();
	}
	function checkInBooks() {
		if ("input#check:checked") {
			var checkboxes = document.querySelectorAll("input#check:checked");
			if (checkboxes.length == 0) {
				alert("Please select atleast one book loan for check in");
			} else {
				var id = confirm("Do you want to check in selected books?");
				if (id) {

					var loan_id = []
					var isbn = []
					var card_id = []
					var date_out = []
					var due_date = []

					jQuery(checkboxes).each(
							function(key, el) {
								loan_id.push(jQuery(el).closest("tr").find(
										"[id$='loan_id']").text());
								isbn.push(jQuery(el).closest("tr").find(
										"[id$='isbn']").text());
								card_id.push(jQuery(el).closest("tr").find(
										"[id$='card_id']").text());
								date_out.push(jQuery(el).closest("tr").find(
										"[id$='date_out']").text());
								due_date.push(jQuery(el).closest("tr").find(
										"[id$='due_date']").text());
							});
					
					$.ajax({
						url : "/LibraryManagementSystem/CheckIn",
						data : {
							"loan_id" :loan_id.toString(),
							"isbn" : isbn.toString(),
							"card_id" : card_id.toString(),
							"date_out" : date_out.toString(),
							"due_date" : due_date.toString()
						},
						type : "post",
						success : function(response) {
							if (response) {
								alert(response);
							}
							window.location = "SearchBook.jsp";
						}
					});

				} else {

					alert("Try again to check in later");
					var id1 = confirm("Do you want to return to search page ?")
					if (id1) {
						window.location = "SearchBook.jsp";
					} else {
						clearForm();
					}
				}
			}
		}
	}
</script>
</head>
<body onload="clearForm()">
	<f:view>
		<h:form id="MyForm1">
<pre>LOAN_ID    ISBN          CARD_ID                DATE_OUT                    DUE_DATE</pre>
			<h:dataTable value="#{searchBean.bookCheckIns}" var="bs">
				<h:column>
					<h:outputText value="#{bs.loan_id}" id="loan_id"></h:outputText>
				</h:column>
			<h:column>
					<h:outputText value="#{bs.isbn}" id="isbn" style="margin-left:30px;"></h:outputText>

				</h:column>
				<h:column>
					<h:outputText value="#{bs.card_id}" id="card_id" style="margin-left:40px;"></h:outputText>
				</h:column>
				<h:column>

					<h:outputText value="#{bs.date_out}" id="date_out" style="margin-left:60px;"></h:outputText>
				</h:column>
				<h:column>

					<h:outputText value="#{bs.due_date}" id="due_date" style="margin-left:70px;"></h:outputText>
				</h:column>

				<h:column>
					<input type="checkbox" id="check"></input>
				</h:column>
			</h:dataTable>
			
			<input type="button" onclick="checkInBooks()" id="checkin"
				value="CheckIn Books"></input>
		</h:form>

	</f:view>

</body>
</html>