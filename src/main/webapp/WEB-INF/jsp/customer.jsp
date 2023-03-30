<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<c:import url="header.jsp"></c:import>
<style type="text/css">

table{
background-color: lightcyan;
}
</style>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: #eee;">

	<div class="container mt-5">
		<div class="row" style="background-color: bisque;">
			<div class="col primary" >
				<h4>Customer Details</h4>
				<div class="col-md-12">
					<h6>
						ID :&nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
						&nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp;
						<c:out value="${listOfObjects.get(2).id }"></c:out>
					</h6>
				</div>
				<div class="col-md-8">
					<div>
						<h6>
							Name :&nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
							&nbsp;&nbsp;&nbsp; &nbsp;
							<c:out
								value="${listOfObjects.get(2).firstName }  ${listOfObjects.get(2).lastName }"></c:out>


						</h6>
					</div>
				</div>

				<div class="col-md-10">
					<h6>
						Email ID :&nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
						&nbsp;&nbsp;
						<c:out value="${listOfObjects.get(2).email }"></c:out>
					</h6>
				</div>

				<div class="col-md-8">
					<h6>
						Gender :&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<c:out value="${listOfObjects.get(2).gender}"></c:out>
					</h6>
				</div>
				<div class="col-md-8">
					<h6>
						Primary Contact :&nbsp; &nbsp;&nbsp;&nbsp;
						<c:out value="${listOfObjects.get(2).primaryContact}"></c:out>
					</h6>
				</div>

				<div class="col-md-8">
					<h6>
						Alternate Contact :&nbsp; &nbsp;
						<c:out value="${listOfObjects.get(2).alternateContact}"></c:out>
					</h6>
				</div>
			</div>
			<div class="col" style="background-color: bisque;">
				<h4>Policy Details</h4>
				
				<div class="col-md-12">
				
					<h6>
						Policy ID :&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
						<c:out value="${listOfObjects.get(0).policyId }"></c:out>
					</h6>
					

					<div class="col-md-8">
						
							<h6>
								Policy Type :&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<c:out value="${listOfObjects.get(0).policyType }"></c:out>
							</h6>
						
					</div>

					<div class="col-md-10">
						<h6>
							Policy Start Date :&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
							<c:out value="${listOfObjects.get(0).policyStartDate }"></c:out>
						</h6>
					</div>

					<div class="col-md-8">
						<h6>
							Policy End Date :&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<c:out value="${listOfObjects.get(0).policyEndDate }"></c:out>
						</h6>
					</div>
					<div class="col-md-8">
						<h6>
							Premium Amount :&nbsp;&nbsp;&nbsp; &nbsp;
							<c:out value="${listOfObjects.get(0).premiumAmount }"></c:out>
						</h6>
					</div>
				</div>
			</div>


		</div>
	</div>
	<div class="container">

		<div class="p-4 me-3">
			<table style="width: 100%" border="1px solid black" class="tblAlign">

				<div class="d-flex pb-2">
					<h5>
						<span class="far fa-check-square pe-2"></span> &nbsp;<b></b>
					</h5>
					<div>
						<h2>Transaction History</h2>
					</div>

				</div>


				<tr>
					<th>ID</th>
					<th>Customer Email</th>
					<th>Transaction ID</th>
					<th>Amount</th>
					<th>Date</th>
					<th>Policy Type</th>
					<th>Transaction Status</th>


				</tr>
				<c:forEach var="transcation" items="${listOfObjects.get(1)}">


					<tr>
						<td><c:out value="${transcation.id }"></c:out></td>
						<td><c:out value="${listOfObjects.get(2).email }"></c:out></td>

						<td><c:out value="${transcation.id }"></c:out></td>

						<td><c:out value="${transcation.amount }"></c:out></td>
						<td><c:out value="${transcation.date }"></c:out></td>

						<td><c:out value="${listOfObjects.get(0).policyType }"></c:out></td>

						<td><b><c:out value="${transcation.transactionStatus }"></c:out></b></td>



					</tr>
				</c:forEach>
			</table>
		</div>
	</div>



</body>
</html>

