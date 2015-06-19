<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<!-- START PAGE SOURCE -->
<jsp:include page="/views/TopMenu.jsp" flush="true" />
<div class="main">
	<section id="content">
		<jsp:include page="/views/LeftMenu.jsp" flush="true" />
		<c:set var="logged_user" value="${logged_user}"/>
		<article class="col2 pad_left1">
			<div class="well removewidth normalwidth">
				<div class="panel-body">
						<h1 style="color: #000000;text-align:center;">Account Details</h1>
						<div id="user_details" class="form-group">
							<div class="form-group" style="float:left; width: 150px; margin: 0 auto;">
									<img src="<c:url value="resources/images/${logged_user.username}/${logged_user.username}.jpg"/>"
										width="150" class="img-thumbnail"
										onerror="this.src='<c:url value="resources/images/placeholder.png"/>';">
										
								</div>
								<div class="clear"></div>

									<hr>
								
									<label for="inputName1" class="col-sm-4 control-label">Username:</label>
									<div class="col-sm-8">
										<span class="form-control"><c:out value="${logged_user.username}" /></span>
									</div>

									<hr>
									<label for="inputName1" class="col-sm-4 control-label">First Name:</label>
									<div class="col-sm-8">
										<span class="form-control"><c:out value="${logged_user.firstName}" /></span>
									</div>
									<label for="inputName1" class="col-sm-4 control-label">Last Name:</label>
									<div class="col-sm-8">
										<span class="form-control"><c:out value="${logged_user.lastName}" /></span>
									</div>
									<label for="inputName1" class="col-sm-4 control-label">Email:</label>
									<div class="col-sm-8">
										<span class="form-control"><c:out value="${logged_user.email}" /></span>
									</div>
	
							<div class="col-sm-8">
								<button id="edit" class="btn btn-primary btn-lg" type="button" style="float: right;margin-top:59px">Edit Profile</button>
							</div>
						</div>
						<div id="edit_user_details" class="form-group">
							<form role="form">
								<div class="form-group" style="float:left; width: 150px; margin: 0 auto;">
									<div class="glyphicon glyphicon-edit edit_image">
										<input type="file" onchange="javascript:show_upload();readURL($(this))" class="" name="image" id="image" placeholder="Upload profile image" />
									</div>
									<img id="image_value" src="<c:url value="resources/images/${logged_user.username}/${logged_user.username}.jpg"/>"
										width="150" class="img-thumbnail"
										onerror="this.src='<c:url value="resources/images/placeholder.png"/>';">
										<div id="upload_image" class="upload_image"></div>
								</div>
								<div class="clear"></div>
							
									<hr>
								
									<label for="inputName1" class="col-sm-4 control-label">Username:</label>
									<div class="col-sm-8">
										<input class="form-control" type="text" value="" placeholder="<c:out value="${logged_user.username}" />" /> <span style="font-size:9px;"> @<b><c:out value="${logged_user.username}" /></b> you can change the username</span>
									</div>
									
									<label for="inputName1" class="col-sm-4 control-label">Password:</label>
									<div class="col-sm-8">
										<input class="form-control" type="password" value="" placeholder="Insert password" /><span style="font-size:9px;"> @<b><c:out value="${logged_user.username}" /></b> you can change your password</span>
									</div>
							
									<hr>
									<label for="inputName1" class="col-sm-4 control-label">First Name:</label>
									<div class="col-sm-8">
										<input class="form-control" type="text" value="" placeholder="<c:out value="${logged_user.firstName}" />" /><span style="font-size:9px;"> @<b><c:out value="${logged_user.username}" /></b> you can change your First Name</span>
									</div>
									<label for="inputName1" class="col-sm-4 control-label">Last Name:</label>
									<div class="col-sm-8">
										<input class="form-control" type="text" value="" placeholder="<c:out value="${logged_user.lastName}" />" /><span style="font-size:9px;"> @<b><c:out value="${logged_user.username}" /></b> you can change your Last Name</span>
									</div>
									<label for="inputName1" class="col-sm-4 control-label">Email:</label>
									<div class="col-sm-8">
										<input class="form-control" type="text" value="" placeholder="<c:out value="${logged_user.email}" />" /><span style="font-size:9px;"> @<b><c:out value="${logged_user.username}" /></b> you can change your email</span>
									</div>
									<div class="col-sm-12">
										<button id="update" class="btn btn-primary btn-lg" type="button" style="float: right;margin-top:59px">Update Changes</button>
									</div>
							</form>
						</div>
				</div>
			</div>
		</article>
	</section>
</div>
<jsp:include page="/views/Footer.jsp" flush="true" />
<!-- END PAGE SOURCE -->
</body>
</html>
