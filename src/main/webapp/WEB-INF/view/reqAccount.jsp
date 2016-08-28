<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-md-4 col-xs-12 col-sm-10">
		<div class="panel panel-default">
			<div class="panel-heading">Registration</div>
			<div class="panel-body">
				<!-- 
				 -->
				<form action="/regAccountToBD" method="get">
					<div class="form-group">
						<label for="exampleInputLogin">Login</label> <input name="login"
							class="form-control" id="exampleInputLogin" placeholder="Login">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword">Password</label> <input
							name="password" type="password" class="form-control"
							id="exampleInputPassword1" placeholder="Password">
					</div>
					<div class="form-group">
						<label for="exampleInputFirstName">First name</label> <input
							name="firstName" type="text" class="form-control"
							id="exampleInputFirstName" placeholder="FirstName">
					</div>
					<div class="form-group">
						<label for="exampleInputLastName">Last name</label> <input
							name="lastName" type="text" class="form-control"
							id="exampleInputLastName" placeholder="LastName">
					</div>
					<div class="form-group">
						<label for="exampleInputSecondName">Second name</label> <input
							name="secondName" type="text" class="form-control"
							id="exampleInputSecondName" placeholder="SecondName">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Email address</label> <input
							name="email" type="email" class="form-control"
							id="exampleInputEmail" placeholder="Email">
					</div>

					<div class="text-center">
						<button type="submit" name="reqAccount" class="btn btn-default">Sing up</button>
						<a href="/login" class="btn btn-warning">Cancel</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

