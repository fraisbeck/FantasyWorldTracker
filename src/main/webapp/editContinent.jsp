<%@include file ="taglib.jsp"%>
<c:set var="title" value="Add/Edit Continents" scope="session"/>
<html>
<c:import url="/templates/head.jsp" />
<body>
<div class="container-fluid">
    <c:import url="/templates/header.jsp" />
    <div class="row flex-nowrap">
        <c:import url="/templates/sidebar.jsp" />
        <div id="content" class="col-auto col-md-9 col-xl-10 mt-3">
            <h2>Add/Edit Continents</h2>
            <br />
            <form id="editContinentForm" role="form" data-toggle="validator"
                  class="form-horizontal" action="editContinent" method="post">
                <input type="hidden" id="id" name="id" value = ${continent.id}>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="name">Name</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="name" name="name"
                               value="${continent.name}" data-error="Please enter the continents name." required>
                    </div>
                    <div class="help-block with-errors"></div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="world">World</label>
                    <div class="col-sm-4">
                        <select class="col-sm-4" name="world" id="world">
                            <c:forEach items="${listWorlds}" var="world">
                                <c:choose>
                                    <c:when test="${world.id eq continent.world.id}">
                                        <option value="${world.id}" selected>${world.name}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${world.id}">${world.name}</option>
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
                <a href ="searchContinents?searchTerm=&submit=viewAll">
                    <button type="button" class="btn btn-danger">Cancel</button>
                </a>
            </form>
        </div>
    </div>
    <c:import url="/templates/footer.jsp" />
</div>
</body>
</html>