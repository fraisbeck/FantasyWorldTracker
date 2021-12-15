<%@include file ="taglib.jsp"%>
<c:set var="title" value="Sign in" scope="session"/>
<html>
<c:import url="/templates/head.jsp" />
<body>
<div class="container-fluid">
    <h1>Sign In</h1>
    <h2 class="text-danger">${errorMessage}</h2>
    <form id="userForm" role="form" data-toggle="validator"
          class="form-horizontal" action="signInForm" method="post">
        <input type="hidden" id="id" name="id" value = ${user.id}>
        <div class="form-group">
            <label class="control-label col-sm-2" for="userName">UserName</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="userName" name="userName"
                       value="${user.userName}" titler="Please enter a username." required>
            </div>
            <div class="help-block with-errors"></div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="password">Password</label>
            <div class="col-sm-4">
                <input type="password" class="form-control" id="password" name="password"
                       value="${user.password}" title=""
                       data-error="Please enter a valid password." required>
            </div>
            <div class="help-block with-errors"></div>
        </div>

        <button type="submit" class="btn btn-primary col-sm-offset-3"
                data-disable="true">Sign In
        </button>
            <button type="button" class="btn btn-danger">Cancel</button>
        </a>
    </form>
</body>
</html>
