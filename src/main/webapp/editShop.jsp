<%@include file ="taglib.jsp"%>
<c:set var="title" value="Add/Edit Shops" scope="session"/>
<html>
<c:import url="/templates/head.jsp" />
<body>
<div class="container-fluid">
    <c:import url="/templates/header.jsp" />
    <div class="row flex-nowrap">
        <c:import url="/templates/sidebar.jsp" />
        <div id="content" class="col-auto col-md-9 col-xl-10 mt-3">
            <h2>Add/Edit Shops</h2>
            <br />
            <form id="editShopForm" role="form" data-toggle="validator"
                  class="form-horizontal" action="editShop" method="post">
                <input type="hidden" id="id" name="id" value = ${shop.id}>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="name">Name</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="name" name="name"
                               value="${shop.name}" data-error="Please enter the shops name." required>
                    </div>
                    <div class="help-block with-errors"></div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="shopCategory">Category</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="shopCategory" name="shopCategory"
                               value="${shop.shopCategory}" data-error="Please enter the shops category." required>
                    </div>
                    <div class="help-block with-errors"></div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="location">Location</label>
                    <div class="col-sm-4">
                        <select class="col-sm-4" name="location" id="location">
                            <c:forEach items="${listLocations}" var="location">
                                <c:choose>
                                    <c:when test="${location.id eq shop.location.id}">
                                        <option value="${location.id}" selected>${location.name}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${location.id}">${location.name}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="help-block with-errors"></div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="owner">Owner</label>
                    <div class="col-sm-4">
                        <select class="col-sm-4" name="owner" id="owner">
                            <c:forEach items="${listOwners}" var="owner">
                                <c:choose>
                                    <c:when test="${owner.id eq shop.owner.id}">
                                        <option value="${owner.id}" selected>${owner.firstName} ${owner.lastName}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${owner.id}">${owner.firstName} ${owner.lastName}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="help-block with-errors"></div>
                </div>

                <button type="submit" class="btn btn-primary col-sm-offset-3"
                        data-disable="true">Add/Update
                </button>
                <button type="reset" class="btn btn-secondary">Clear</button>
                <a href ="searchShops?searchTerm=&submit=viewAll">
                    <button type="button" class="btn btn-danger">Cancel</button>
                </a>
            </form>
        </div>
    </div>
    <c:import url="/templates/footer.jsp" />
</div>
</body>
</html>