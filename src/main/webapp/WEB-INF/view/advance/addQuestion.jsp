<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-md-4 col-xs-12 col-sm-10">
		<div class="panel panel-default">
			<div class="panel-heading">Add Question</div>
			<div class="panel-body">
				<form action="/advance/addQuestionToBD" method="get">
					<div class="form-group">
						<label for="exampleInputRole">Test Name</label> 
						<select name="idTest" class="form-control">
							<c:forEach var="test" items="${listTest}">
								<option value="${test.id}">${test.name}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="exampleInputDescription">Name Question</label> <input
							name="name" type="text" class="form-control" placeholder="Name Question" id="exampleInputDescription">
					</div>
					<div class="form-group">
						<label for="exampleInputDescription">True Answer</label> <input
							name="tName" type="text" class="form-control" placeholder="True Answer" id="exampleInputDescription">
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-default">Add Question</button>
						<a href="/advance/home" class="btn btn-warning">Cancel</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>