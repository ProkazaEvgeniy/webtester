<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-md-4 col-xs-12 col-sm-10">
		<div class="panel panel-default">
			<div class="panel-heading">Add Answer</div>
			<div class="panel-body">
				<!-- 
				 -->
				<form action="/advance/addAnswerToBD" method="get">
					
					<div class="form-group">
						<label for="exampleInputName">Id Question</label> <input
							name="idQuestion" type="text" class="form-control" placeholder="Id Question" id="exampleInputDescription">
					</div>
					<div class="form-group">
						<label for="exampleInputDescription">Name Answer</label> <input
							name="name" type="text" class="form-control" placeholder="Name" id="exampleInputDescription">
					</div>
					<div class="checkbox">
						<label> <input type="checkbox" name="correct"> Correct (default false)
						</label>
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-default">Add Answer</button>
						<a href="/advance/home-answer" class="btn btn-warning">Cancel</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>