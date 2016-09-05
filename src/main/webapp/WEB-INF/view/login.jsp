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
						<label for="exampleInputRole">Role</label> 
						<select name="role"
							class="form-control">
							<c:forEach var="role" items="${roleList}">
								<option value="${role.id}">${role.name}</option>
							</c:forEach>
						</select>
					</div>
					<div class="checkbox">
						<label> <input type="checkbox" name="rememberMe" value="yes"> Remember me </label>
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-default"><div class="glyphicon glyphicon-asterisk"></div> Submit</button>
						<a href="/regAccount" class="btn btn-primary">Registration <div class="glyphicon glyphicon-user"></div></a>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>



