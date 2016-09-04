<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-md-4 col-xs-12 col-sm-10">
		<div class="panel panel-default">
			<div class="panel-heading">Edit Test for id = ${test.id}</div>
			<div class="panel-body">
				<!-- 
				 -->
				<form action="/tutor/editTestToBD" method="get">
					<input name="id" type="hidden" class="form-control"
							value="${test.id}">
				
					<div class="form-group">
						<label for="exampleInputName">Test name</label> <input
							name="name" type="text" class="form-control"
							value="${test.name}" id="exampleInputDescription">
					</div>
					<div class="form-group">
						<label for="exampleInputDescription">Description</label> <input
							name="description" type="text" class="form-control"
							value="${test.description}" id="exampleInputDescription">
					</div>
					<div class="form-group">
						<label for="exampleInputDurationPerQuestion">Duration per Question</label> <input
							name="durationPerQuestion" type="text" class="form-control"
							value="${test.durationPerQuestion}" id="exampleInputDurationPerQuestion">
					</div>
					
					<div class="text-center">
						<button type="submit" class="btn btn-default">Edit
							Test</button>
						<a href="/tutor/home" class="btn btn-warning">Cancel</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

