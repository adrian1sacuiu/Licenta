<%--
  Created by IntelliJ IDEA.
  User: internship
  Date: 8/7/2014
  Time: 4:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title></title>
</head>
<body>
	<div id="info">
		<form class="form-horizontal" role="form" action="/login"
			method="post">
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">Username</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="inputEmail3"
						placeholder="Username" name="username">
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="inputPassword3"
						placeholder="Password" name="password">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary">Sign in</button>
				</div>
			</div>
			<br /> <br />
			<div class="form-group">
				<div class="col-sm-offset-10 col-sm-10">
					<button type="button" id="back" class="btn btn-link">Back</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
