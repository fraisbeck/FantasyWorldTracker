<%@include file ="taglib.jsp"%>
<c:set var="title" value="continentResults" scope="session"/>
<html>
<c:import url="/templates/head.jsp" />
<body>
<div class="container-fluid">
    <c:import url="/templates/header.jsp" />
    <div class="row flex-nowrap">
        <c:import url="/templates/sidebar.jsp" />
        <div id="content" class="col-auto col-md-9 col-xl-10 mt-3">
            <h2>Continents</h2>
            <form action="searchContinents" class="form-outline">
                <div class="input-group">
                    <input type="text" class="form-control" id="searchTerm" name="searchTerm" aria-describedby="searchTermHelp" placeholder="Enter Name">
                    <input type="hidden" id="searchType" name="searchType" value="name">
                    <button type="submit" name="submit" value="search" class="btn btn-primary"><i class="fas fa-search"> Search</i></button>
                    <button type="submit" name="submit" value="viewAll" class="btn btn-success"><i class="fas fa-search-plus"> All</i></button>
                </div>
            </form>
            <a class="btn btn-primary" href="addNewContinent"><i class="fas fa-plus-circle"></i> Add New Continent</a>
            <table id="continentsTable" class="table table-bordered">
                <thead>
                <th>Name</th>
                <th>World</th>
                <th>Modify</th>
                </thead>
                <tbody>
                <c:forEach var="continent" items="${continents}">
                    <tr>
                        <td><a class="search" title="Search" data-toggle="tooltip" href="searchRegions?submit=continent&id=${continent.id}">${continent.name}</a></td>
                        <td>${continent.world.name}</td>
                        <td>
                            <a class="edit" title="Edit" data-toggle="tooltip" href="editContinent?id=${continent.id}">
                                <i class='fas' >&#xf044; Edit</i>
                            </a>
                            <a class="delete" title="Delete" data-toggle="tooltip" href="deleteContinent?id=${continent.id}">
                                <i class='fas' >&#xf1f8; Remove</i>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <c:import url="/templates/footer.jsp" />
</div>
</body>
</html>
