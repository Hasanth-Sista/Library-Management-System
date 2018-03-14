<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Search Page</title>
<script src="https://code.jquery.com/jquery-3.3.1.js"
	integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
	crossorigin="anonymous"></script>
<script type="text/javascript">
	function checkingChecked() {
		if ($("input#check").is(':checked')) {
			availabilityCheck();
		} else {
			clearForm();
		}
	};

	function clearForm() {
		document.MyForm.reset();
	}
	function availabilityCheck() {

		var checkboxes = document.querySelectorAll("input#check:checked");
		var available = []
		//console.log(checkboxes);
		jQuery(checkboxes).each(
				function(key, el) {
					available.push(jQuery(el).closest("tr").find(
							"[id$='available']").text());
				});
		var flag = 1;
		jQuery(available).each(function(key, el) {
			if (el == 'false') {
				flag = 0;
				alert("You cannot check out unavailable book");
				clearForm();
			}

		});
		if (flag == 1) {
			details();
		}

	}
	function details() {

		var check = confirm("Do you want to check out selected books?");
		//console.log(check);
		if (check) {

			var checkboxes = document.querySelectorAll("input#check:checked");
			//console.log(checkboxes)
			/* var checkboxes = jQuery.find("input#check").filter(function(el){
				return jQuery(el).prop("checked");
			}) */
			var isbn = []
			var title = []
			var authors = []

			jQuery(checkboxes).each(
					function(key, el) {
						isbn.push(jQuery(el).closest("tr").find("[id$='isbn']")
								.text());
						title.push(jQuery(el).closest("tr").find(
								"[id$='title']").text());
						authors.push(jQuery(el).closest("tr").find(
								"[id$='authors']").text());
					});

			/* jQuery.each(isbn,function(key,isbnEl){
				console.log(jQuery(isbnEl).text())
			}) */
			//console.log(isbn);
			if (checkboxes.length <= 3) {
				var id = prompt("Please enter your card id : ");
				if (id == "") {
					alert("You cannot check out without card id");
					details();
				} else {

					$.ajax({
						url : "/LibraryManagementSystem/GetCard",
						data : {
							"isbn" : isbn.toString(),
							"id" : id.toString(),
							"title" : title.toString(),
							"authors" : authors.toString()
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

			} else {
				alert("Please select less than or equal to 3 books");
			}
		}
	}
</script>
</head>
<body onload="clearForm()">
	<f:view>
		<h:form id="MyForm">
			<pre> ISBN 			TITLE 						          	                               	AUTHORS 		  AVAILABILITY</pre>
			<h:dataTable value="#{searchBean.bookBeanSearch}" var="bs">
				<h:column>
					<h:outputText value="#{bs.isbn}" id="isbn"></h:outputText>
				</h:column>
				<h:column>
				
					<h:outputText value="#{bs.title}" id="title"></h:outputText>

				</h:column>
				<h:column>
				
					<h:outputText value="#{bs.authors}" id="authors"></h:outputText>
				</h:column>
				<h:column>

					<h:outputText value="#{bs.availability}" id="available"></h:outputText>
				</h:column>
				<h:column>
				
					<input type="checkbox" onclick="checkingChecked()" id="check"></input>
				</h:column>
			</h:dataTable>
		</h:form>

	</f:view>

</body>
</html>