<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-md-4 col-xs-12 col-sm-10">
		<div class="panel panel-default">
			<div class="panel-heading">Reestablish</div>
			<div class="panel-body">
				<!-- 
				 -->
				<form action="/admin/reestablishPasswordToBD" method="get">
					
					<div class="form-group">
						<label for="exampleInputPassword">Password</label> <input
							name="password" type="password" class="form-control"
							id="exampleInputPassword1" placeholder="Password">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword">Repeat Password</label> <input
							name="repeatPassword" type="password" class="form-control"
							id="exampleInputPassword1" placeholder="Repeat Password">
					</div>
					
					<div class="form-group">
						<label for="exampleInputEmail1">Email address</label> <input
							name="email" type="email" class="form-control"
							id="exampleInputEmail" placeholder="Email">
					</div>

					<div class="text-center">
						<button type="submit" name="addAccount" class="btn btn-default">Ok</button>
						<a href="/admin/home" class="btn btn-warning">Cancel</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

