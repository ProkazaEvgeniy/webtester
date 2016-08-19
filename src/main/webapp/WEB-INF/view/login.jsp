<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:if test="${error!=null }">
	<div class="alert alert-danger" role="alert">${error}</div>
</c:if>


<div class="row">
	<div class="col-md-4 col-xs-12 col-sm-10">
		<div class="panel panel-default">


			<div class="panel-heading">Login</div>

			<div class="panel-body">
				<form action="/login" method="post">

					<div class="form-group">

						<label for="exampleInputLogin">Login</label> <input name="login"
							class="form-control" id="exampleInputLogin" placeholder="Login">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Password</label> <input
							name="password" type="password" class="form-control"
							id="exampleInputPassword1" placeholder="Password">
					</div>

					<div class="form-group">
						<label for="exampleInputRole">Role</label> <select name="role"
							class="form-control">
							<option value="1">Admin</option>
							<option value="2">Advance tutor</option>
							<option value="3">Tutor</option>
							<option value="4">Student</option>
						</select>
					</div>

					<div class="checkbox">
						<label> <input type="checkbox" name="rememberMe"
							value="yes"> Remember me
						</label>
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-default">Submit</button>
					</div>

<!--  
					<div class="col-xs-4 col-sm-2">
						<a href="#" class="btn btn-default"><span class="hidden-xs">Facebook</span>
						</a> <a href="#" class="btn btn-default"><span class="hidden-xs">Twitter</span>
						</a> <a href="#" class="btn btn-default"><span class="hidden-xs">Google+</span>
						</a>
					</div>
-->

				</form>
			</div>
		</div>
	</div>
</div>



