<%@include file ="taglib.jsp"%>
<c:set var="title" value="Add/Edit Locations" scope="session"/>
<html>
<c:import url="/templates/head.jsp" />
<body>
<div class="container-fluid">
    <c:import url="/templates/header.jsp" />
    <div class="row flex-nowrap">
        <c:import url="/templates/sidebar.jsp" />
        <div id="content" class="col-auto col-md-9 col-xl-10 mt-3">
            <h2>Add/Edit Locations</h2>
            <br />
            <form id="editLocationForm" role="form" data-toggle="validator"
                  class="form-horizontal" action="editLocation" method="post">
                <input type="hidden" id="id" name="id" value = ${location.id}>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="name">Name</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="name" name="name"
                               value="${location.name}" data-error="Please enter the shops name." required>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="region">Region</label>
                        <div class="col-sm-4">
                            <select class="col-sm-4" name="region" id="region">
                                <c:forEach items="${listRegions}" var="region">
                                    <c:choose>
                                        <c:when test="${region.id eq location.region.id}">
                                            <option value="${region.id}" selected>${region.name}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${region.id}">${region.name}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="help-block with-errors"></div>
                    </div>
                    <div class="help-block with-errors"></div>
                </div>
                <button type="submit" class="btn btn-primary col-sm-offset-3"
                        data-disable="true">Add/Update
                </button>
                <button type="reset" class="btn btn-secondary">Clear</button>
                <a href ="searchLocations?searchTerm=&submit=viewAll">
                    <button type="button" class="btn btn-danger">Cancel</button>
                </a>
            </form>
        </div>
    </div>
    <c:import url="/templates/footer.jsp" />
</div>
</body>
</html>
