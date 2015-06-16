<%--
  Created by IntelliJ IDEA.
  User: Adrian
  Date: 15-Jul-14
  Time: 10:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<!-- START PAGE SOURCE -->
<jsp:include page="views/TopMenu.jsp" flush="true" />

    <div class="container-fluid">
      <div class="row">
    	  <jsp:include page="views/LeftMenu.jsp" flush="true" />
        
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Dashboard</h1>
         	<div class="row" id="info">
	  			<div class="col-sm-6">
					<div class="panel panel-info">
						<div class="panel-heading">
							<h3 class="panel-title  glyphicon glyphicon-lock"></h3>
						</div>
						<div class="panel-body">
							<p class="glyphicon glyphicon-user pull-left">  You can login to acces your account.</p><p class="pull-right"><button type="button" id="button1" class="btn btn-info btn-lg">Login</button></p>
						</div>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="panel panel-info">
						<div class="panel-heading">
							<h3 class="panel-title glyphicon glyphicon-plus"></h3>
						</div>
						<div class="panel-body">
							<p class="glyphicon glyphicon-user pull-left">  Don't have an account? You can register here.</p><p class="pull-right"><button type="submit" id="button2" class="btn btn-info btn-lg">Register</button></p>
						</div>
					</div>
				</div>
			</div>
		
          <div class="row placeholders">
            <div class="col-xs-6 col-sm-3 placeholder">
              <img data-src="holder.js/200x200/auto/sky" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Label</h4>
              <span class="text-muted">Something else</span>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <img data-src="holder.js/200x200/auto/vine" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Label</h4>
              <span class="text-muted">Something else</span>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <img data-src="holder.js/200x200/auto/sky" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Label</h4>
              <span class="text-muted">Something else</span>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <img data-src="holder.js/200x200/auto/vine" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Label</h4>
              <span class="text-muted">Something else</span>
            </div>
          </div>
		<div class="row placeholders">
   			<jsp:include page="views/Footer.jsp" flush="true" />
   		</div>
      </div>
    </div>
    
  </body>
 
</html>
