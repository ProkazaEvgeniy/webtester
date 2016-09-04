<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="row">
	<div class="col-md-4 col-xs-12 col-sm-10">
		<div class="panel panel-default">
			<div class="panel-heading">Establish role for id = ${account.id}</div>
			<div class="panel-body">
				<form action="/admin/establishRoleToBD" method="get">
					<div class="form-group">
						<div class="form-group">
							<input name="id" type="hidden" class="form-control" id="exampleInputLogin"
								value="${account.id}" placeholder="id">
						</div>

						<label for="exampleInputRole">Role</label> <select name="role"
							class="form-control">
							<option value="1">Admin</option>
							<option value="2">Advance tutor</option>
							<option value="3">Tutor</option>
							<option value="4">Student</option>
						</select>
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-default">Establish role</button>
						<a href="/admin/home" class="btn btn-warning">Cancel</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>



