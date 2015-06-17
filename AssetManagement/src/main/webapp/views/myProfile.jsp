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
				
					<form role="form">
						<center>
							<h1 style="color: #000000">Personal Details</h1>
						</center>
						<div class="form-group">
							<div class="form-group" style="width: 150px; margin: 0 auto;">
								<img src="<c:url value="resources/images/${logged_user.username}/${logged_user.username}.jpg"/>"
									width="150" class="img-thumbnail"
									onerror="this.src='<c:url value="resources/images/placeholder.png"/>';">
							</div>
							<br>
							<p>
								<b>Username :</b>
								<c:out value="${logged_user.username}" />
							</p>
						</div>
					</form>
				</div>
			</div>
		</article>
	</section>
</div>
<jsp:include page="/views/Footer.jsp" flush="true" />
<!-- END PAGE SOURCE -->
</body>
</html>
