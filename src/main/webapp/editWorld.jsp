<%@include file ="taglib.jsp"%>
<c:set var="title" value="Add/Edit World" scope="session"/>
<html>
<c:import url="/templates/head.jsp" />
<body>
<div class="container-fluid">
    <c:import url="/templates/header.jsp" />
    <div class="row flex-nowrap">
        <c:import url="/templates/sidebar.jsp" />
        <div id="content" class="col-auto col-md-9 col-xl-10 mt-3">
            <h2>Add/Edit Worlds</h2>
            <br />
            <form id="editWorldForm" role="form" data-toggle="validator"
                  class="form-horizontal" action="editWorld" method="post">
                <input type="hidden" id="id" name="id" value = ${world.id}>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="name">Name</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="name" name="name"
                               value="${world.name}" data-error="Please enter the worlds name." required>
                    </div>
                    <div class="help-block with-errors"></div>
                </div>
                <input type="hidden" id="user" name="user" value = ${world.user.id}>

                <button type="submit" class="btn btn-primary col-sm-offset-3"
                        data-disable="true">Add/Update
                </button>
                <button type="reset" class="btn btn-secondary">Clear</button>
                <a href ="searchWorlds?searchTerm=&submit=viewAll">
                    <button type="button" class="btn btn-danger">Cancel</button>
                </a>
            </form>
        </div>
    </div>
    <c:import url="/templates/footer.jsp" />
</div>
</body>
</html>