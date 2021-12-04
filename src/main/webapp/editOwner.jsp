<%@include file ="taglib.jsp"%>
<c:set var="title" value="Add/Edit Owner" scope="session"/>
<html>
<c:import url="/templates/head.jsp" />
<body>
<div class="container-fluid">
    <c:import url="/templates/header.jsp" />
    <div class="row flex-nowrap">
        <c:import url="/templates/sidebar.jsp" />
        <div id="content" class="col-auto col-md-9 col-xl-10 mt-3">
            <h2>Add/Edit Owner</h2>
            <br />
            <form id="editOwnerForm" role="form" data-toggle="validator"
                  class="form-horizontal" action="editShopOwner" method="post">
                <input type="hidden" id="id" name="id" value = ${owner.id}>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="firstName">First Name</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="firstName" name="firstName"
                               value="${owner.firstName}" data-error="Please enter the owners first name." required>
                    </div>
                    <div class="help-block with-errors"></div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="LastName">Last Name</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="lastName" name="lastName"
                               value="${owner.lastName}" data-error="Please enter the owners last name." required>
                    </div>
                    <div class="help-block with-errors"></div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="profession">Profession</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="profession" name="profession"
                               value="${owner.profession}" data-error="Please enter the owners profession." required>
                    </div>
                    <div class="help-block with-errors"></div>
                </div>

                <button type="submit" class="btn btn-primary col-sm-offset-3"
                        data-disable="true">Add/Update
                </button>
                <button type="reset" class="btn btn-secondary">Clear</button>
                <a href ="searchOwners?searchTerm=&submit=viewAll">
                    <button type="button" class="btn btn-danger">Cancel</button>
                </a>
            </form>
        </div>
    </div>
    <c:import url="/templates/footer.jsp" />
</div>
</body>
</html>