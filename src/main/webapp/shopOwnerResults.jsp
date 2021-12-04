<%@include file ="taglib.jsp"%>
<c:set var="title" value="shopOwnerResults" scope="session"/>
<html>
<c:import url="/templates/head.jsp" />
<body>
<div class="container-fluid">
    <c:import url="/templates/header.jsp" />
    <div class="row flex-nowrap">
        <c:import url="/templates/sidebar.jsp" />
        <div id="content" class="col-auto col-md-9 col-xl-10 mt-3">
            <h2>Shop Owners</h2>
            <form action="searchOwners" class="form-outline">
                <div class="input-group">
                    <input type="text" class="form-control" id="searchTerm" name="searchTerm" aria-describedby="searchTermHelp" placeholder="Enter First name">
                    <select name="searchType" id="searchType">
                        <option value="firstName">First Name</option>
                        <option value="lastName">Last Name</option>
                        <option value="profession">Profession</option>
                    </select>
                    <button type="submit" name="submit" value="search" class="btn btn-primary"><i class="fas fa-search"> Search</i></button>
                    <button type="submit" name="submit" value="viewAll" class="btn btn-success"><i class="fas fa-search-plus"> All</i></button>
                </div>
            </form>
            <a class="btn btn-primary" href="addNewOwner"><i class="fas fa-plus-circle"></i> Add New Owner</a>
            <table id="shopsTable" class="table table-bordered">
                <thead>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Profession</th>
                <th>Modify</th>
                </thead>
                <tbody>
                <c:forEach var="owner" items="${owners}">
                    <tr>
                        <td><a class="search" title="Search" data-toggle="tooltip" href="searchShops?submit=owner&id=${owner.id}">${owner.firstName}</a></td>
                        <td>${owner.lastName}</td>
                        <td>${owner.profession}</td>
                        <td>
                            <a class="edit" title="Edit" data-toggle="tooltip" href="editShopOwner?id=${owner.id}"><i class='fas' >&#xf044; Edit</i></a>
                            <i> / </i>
                            <a class="delete" title="Delete" data-toggle="tooltip" href="deleteShopOwner?id=${owner.id}"><i class='fas' >&#xf1f8; Remove</i></a>
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
