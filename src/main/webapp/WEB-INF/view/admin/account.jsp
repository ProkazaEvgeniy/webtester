<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-md-4 col-xs-12 col-sm-10">
		<div class="panel panel-default">
			<div class="panel-heading">Account id = ${account.id}</div>
			<div class="panel-body">
				<!-- 
				<form action="/admin/editAccountToBD" method="post">
				 <form action="/admin/addAccountToBD" method="get">
				 -->
				 <form name="simpleForm" action="/admin/addAccount">
					<div class="form-group">
						<label for="exampleInputLogin">Login</label> <input name="login"
							class="form-control" id="exampleInputLogin" value="${account.login}" placeholder="Login">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword">Password</label> <input
							name="password" type="password" class="form-control"
							id="exampleInputPassword1" value="${account.password}" placeholder="Password">
					</div>
					<div class="form-group">
						<label for="exampleInputFirstName">First name</label> <input
							name="firstName" type="text" class="form-control"
							id="exampleInputFirstName" value="${account.firstName}" placeholder="FirstName">
					</div>
					<div class="form-group">
						<label for="exampleInputLastName">Last name</label> <input
							name="lastName" type="text" class="form-control"
							id="exampleInputLastName" value="${account.lastName}" placeholder="LastName">
					</div>
					<div class="form-group">
						<label for="exampleInputSecondName">Second name</label> <input
							name="secondName" type="text" class="form-control"
							id="exampleInputSecondName" value="${account.secondName}" placeholder="SecondName">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Email address</label> <input
							name="email" type="email" class="form-control"
							id="exampleInputEmail" value="${account.email}" placeholder="Email">
					</div>

					<div class="text-center">
						<button type="submit" name="editAccount" class="btn btn-default">Edit</button>
						<button type="submit" name="addAccount" class="btn btn-default">Add account</button>
						<a href="/admin/home" class="btn btn-warning">Cancel</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

