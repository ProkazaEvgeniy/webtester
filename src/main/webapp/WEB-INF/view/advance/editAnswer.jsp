<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-md-4 col-xs-12 col-sm-10">
		<div class="panel panel-default">
			<div class="panel-heading">Edit Answer for id = ${answer.id}</div>
			<div class="panel-body">
				<!-- 
				 -->
				<form action="/advance/editAnswerToBD" method="get">
						<input name="id" type="hidden" class="form-control"
							value="${answer.id}" id="exampleInputDescription">
					<div class="form-group">
						<label for="exampleInputRole">Question Name</label> 
						<select name="idQuestion"
							class="form-control">
							<c:forEach var="question" items="${listQuestion}">
								<option value="${question.id}">${question.name}</option>
							</c:forEach>

						</select>
					</div>
					<div class="form-group">
						<label for="exampleInputDescription">Name Answer</label> <input
							name="name" type="text" class="form-control" value="${answer.name}" placeholder="Name" id="exampleInputDescription">
					</div>
					<div class="checkbox">
						<label> <input type="checkbox" name="correct" value="${answer.correct}"> Correct (default false)
						</label>
					</div>
					
					<div class="text-center">
						<button type="submit" class="btn btn-default">Edit Answer</button>
						<a href="/advance/home-answer" class="btn btn-warning">Cancel</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

