<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-md-4 col-xs-12 col-sm-10">
		<div class="panel panel-default">
			<div class="panel-heading">Edit Question for id = ${question.id}</div>
			<div class="panel-body">
				<!-- 
				 -->
				<form action="/advance/editQuestionToBD" method="get">
					<div class="form-group">
						<label for="exampleInputName">Id</label> <input
							name="id" type="text" class="form-control"
							value="${question.id}" id="exampleInputDescription">
					</div>
					<div class="form-group">
						<label for="exampleInputName">Id Test</label> <input
							name="idTest" type="text" class="form-control"
							value="${question.idTest}" id="exampleInputDescription">
					</div>
					<div class="form-group">
						<label for="exampleInputDescription">Name</label> <input
							name="name" type="text" class="form-control"
							value="${question.name}" id="exampleInputDescription">
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-default">Edit Question</button>
						<a href="/advance/home" class="btn btn-warning">Cancel</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

