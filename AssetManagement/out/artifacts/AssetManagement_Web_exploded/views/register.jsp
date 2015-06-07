<%--
  Created by IntelliJ IDEA.
  User: Adrian
  Date: 15-Jul-14
  Time: 10:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<!-- START PAGE SOURCE -->
<jsp:include page="TopMenu.jsp" flush="true"/>
<div class="main">
    <section id="content">
        <jsp:include page="LeftMenu.jsp" flush="true"/>
        <article class="col2 pad_left1">
            <div id="info">
                <sf:form class="form-horizontal" role="form"  modelAttribute="user" method="post" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="inputName1" class="col-sm-3 control-label">Full Name</label>
                        <div class="col-sm-9">
                            <sf:input type="text" class="form-control" id="inputName1" placeholder="Full Name" path="name"/><br/>
                            <sf:errors path="name" cssClass="error"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputEmail1" class="col-sm-3 control-label">Email</label>
                        <div class="col-sm-9">
                            <sf:input type="email" class="form-control" id="inputEmail1" placeholder="Email" path="email"/><br/>
                            <sf:errors path="email" cssClass="error"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword1" class="col-sm-3 control-label">Password</label>
                        <div class="col-sm-9">
                            <sf:input type="password" class="form-control" id="inputPassword1" placeholder="Password" path="password"/><br/>
                            <sf:errors path="password" cssClass="error"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="image" class="col-sm-3 control-label">Profile Image</label>
                        <div class="col-sm-9">
                            <input type="file" class="form-control" id="image" name="image">
                        </div>
                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-10">
                            <button type="submit" class="btn btn-primary btn-lg">Register</button>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-10 col-sm-10">
                            <button type="button" id="back" class="btn btn-link">Back</button>
                        </div>
                    </div>
                    <sf:input type="hidden" value="user" path="role" />
                </sf:form>
            </div>
        </article>
    </section>
</div>
<jsp:include page="Footer.jsp" flush="true"/>
<!-- END PAGE SOURCE -->
</body>
</html>
