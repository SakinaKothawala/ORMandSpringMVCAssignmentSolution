<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Customers List</title>
</head>

<body>

	<div class="container">

		
		<nav class="navbar navbar-light bg-success">
			<h1 class="text-light">CUSTOMER RELATIONSHIP MANAGEMENT</h1>
			<hr>
		</nav>
		
		<p></p>
		
			<form class="d-flex">
				<a href="/crm/customers/new"
					class="btn btn-success btn-sm mb-3"> Add Customer </a>
			</form>
		</div>
		</nav>

		<table class="table table-bordered table-striped">
			<thead class="table-success">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${customers}" var="customer">
					<tr>
						<td><c:out value="${customer.firstname}" /></td>
						<td><c:out value="${customer.lastname}" /></td>
						<td><c:out value="${customer.email}" /></td>
						<td>
							<!-- Add "update" button/link --> <a
							href="/crm/customers/edit?id=${customer.id}"
							class="btn btn-outline-success btn-sm"> Update </a> <!-- Add "delete" button/link -->
							<a href="/crm/customers/delete?id=${customer.id}"
							class="btn btn-outline-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">
								Delete </a>

						</td>

					</tr>
				</c:forEach>

			</tbody>
		</table>


	</div>

</body>
</html>


