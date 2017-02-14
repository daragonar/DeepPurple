<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Deep Purple - Copies</title>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3"></div>
			<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>Libro</th>
							<th>Fecha Impresion</th>
							<th>Autor</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${copies}" var="copy">
							<tr>
								<td>${copy.book.name}</td>
								<td><fmt:formatDate value="${copy.printdate}" pattern="dd-MM-yyyy"/> </td>
								<td>${copy.book.author.name}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>



			</div>
			<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
				<form action='<c:url value="/copies"></c:url>' method="POST" role="form">
					<legend>Add Copies</legend>

					<div class="form-group">
						<label for="">Date</label> <input type="date"
							value="" class="form-control" id="printdate" name="printdate" placeholder="Print date">
					</div>
					<script type="text/javascript">
					document.getElementById("yourDatePicker").valueAsDate = new Date()
					$(document).ready(function() {
						
					})
</script>
							<div class="form-group">
								<label for="">Books</label> <select name="book"
									id="book" class="form-control">
									<c:forEach items="${books}" var="book">

										<option value="${book.id}">${book.name}</option>
									</c:forEach>
								</select>
							</div>

					<input type="hidden" name="id" id="id" class="form-control" value="">	
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>