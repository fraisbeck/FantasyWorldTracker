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
            <h2>Add/Edit Regions</h2>
            <br />
            <form id="editRegionForm" role="form" data-toggle="validator"
                  class="form-horizontal" action="editRegion" method="post">
                <input type="hidden" id="id" name="id" value = ${region.id}>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="name">Name</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="name" name="name"
                               value="${region.name}" data-error="Please enter the shops name." required>
                    </div>
                    <div class="help-block with-errors"></div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="continent">Continent</label>
                    <div class="col-sm-4">
                        <select class="col-sm-4" name="continent" id="continent">
                            <c:forEach items="${listContinents}" var="continent">
                                <c:choose>
                                    <c:when test="${continent.id eq region.continent.id}">
                                        <option value="${continent.id}" selected>${continent.name}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${continent.id}">${continent.name}</option>
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
                <a href ="searchRegions?searchTerm=&submit=viewAll">
                    <button type="button" class="btn btn-danger">Cancel</button>
                </a>
            </form>
        </div>
    </div>
    <c:import url="/templates/footer.jsp" />
</div>
</body>
</html>
