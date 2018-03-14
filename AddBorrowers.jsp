<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Borrowers</title>
<script src="https://code.jquery.com/jquery-3.3.1.js"
	integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
	crossorigin="anonymous"></script>
<script type="text/javascript">
	
</script>
</head>

<body>
	<f:view>
		<h:form id="add">
			<center>
				<table>
					<tr>
						<td>SSN</td>
						<td><h:inputText value="#{borrowerBean.ssn}" id="ssn"
								required="true" requiredMessage="SSN is mandatory"
								maxlength="10"
								validatorMessage="Please enter only digits for ssn">
								<f:validateRegex pattern="[0-9]+" />
							</h:inputText></td>
					</tr>


					<tr>
						<td>Name</td>
						<td><h:inputText value="#{borrowerBean.bname}" id="bname"
								required="true" requiredMessage="Name is mandatory"
								validatorMessage="Name can have only alphabets">
								<f:validateRegex pattern="[a-zA-Z]+" />
							</h:inputText></td>
					</tr>


					<tr>

						<td>Address</td>
						<td><h:inputText value="#{borrowerBean.address}" id="address"
								required="true" requiredMessage="Address is mandatory"></h:inputText></td>
					</tr>

					<tr>

						<td>City</td>
						<td><h:inputText value="#{borrowerBean.city}" id="city"
								required="true" requiredMessage="City is mandatory"></h:inputText></td>
					</tr>

					<tr>

						<td>State</td>
						<td><h:inputText value="#{borrowerBean.state}" id="state"
								required="true" requiredMessage="State is mandatory"></h:inputText></td>
					</tr>


					<tr>

						<td>Phone</td>
						<td><h:inputText value="#{borrowerBean.phone}" id="phone"
								required="true" requiredMessage="Phone is mandatory"
								maxlength="10"
								validatorMessage="Please enter only digits for phone number">
								<f:validateRegex pattern="[0-9]+" />
							</h:inputText></td>
					</tr>
				</table>
				<h:commandButton value="Add User" action="#{borrowerBean.addUser}"></h:commandButton>

				<h:messages />
			</center>
		</h:form>
	</f:view>
</body>
</html>