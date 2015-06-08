<%--
  Created by IntelliJ IDEA.
  User: Adrian
  Date: 15-Jul-14
  Time: 10:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<!-- START PAGE SOURCE -->
<jsp:include page="views/TopMenu.jsp" flush="true"/>
<div class="main">
    <section id="content">
        <jsp:include page="views/LeftMenu.jsp" flush="true"/>
        <article class="col2 pad_left1">
            <div id="info">
                <h2>Welcome to our Website!</h2>
                <div class="marker">
                    <p class="color1">You can login to acces your account.</p>
                </div>
                <div class="wrapper pad_bot2"><button type="button" id="button1" class="btn btn-info btn-lg">Login</button></div>
                <div class="marker">
                    <p class="color1">Don't have an account? You can register here.</p>
                </div>
                <div class="wrapper pad_bot2"><form action="register" method="get"><button type="submit" id="button2" class="btn btn-info btn-lg">Register</button> </form></div>
            </div>
        </article>
    </section>
</div>
<jsp:include page="views/Footer.jsp" flush="true"/>
<!-- END PAGE SOURCE -->
</body>
</html>
