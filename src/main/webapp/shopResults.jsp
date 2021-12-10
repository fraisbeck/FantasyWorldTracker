<%@include file ="taglib.jsp"%>
<c:set var="title" value="shopResults" scope="session"/>
<html>
<c:import url="/templates/head.jsp" />
<body>
<div class="container-fluid">
    <c:import url="/templates/header.jsp" />
    <div class="row flex-nowrap">
        <c:import url="/templates/sidebar.jsp" />
        <div id="content" class="col-auto col-md-9 col-xl-10 mt-3">
            <h2>Shops</h2>
            <form action="searchShops" class="form-outline">
                <div class="input-group">
                    <input type="text" class="form-control" id="searchTerm" name="searchTerm" aria-describedby="searchTermHelp" placeholder="Search">
                    <select name="searchType" id="searchType">
                        <option value="name">Name</option>
                        <option value="shopCategory">Category</option>
                    </select>
                    <button type="submit" name="submit" value="search" class="btn btn-primary"><i class="fas fa-search"> Search</i></button>
                    <button type="submit" name="submit" value="viewAll" class="btn btn-success"><i class="fas fa-search-plus"> All</i></button>
                </div>
            </form>
            <a class="btn btn-primary" href="addNewShop"><i class="fas fa-plus-circle"></i> Add New Shop</a>
            <table id="shopsTable" class="table table-bordered">
                <thead>
                    <th>Name</th>
                    <th>Category</th>
                    <th>City/Town Location</th>
                    <th>Store Owner</th>
                    <th>Modify</th>
                </thead>
                <tbody>
                    <c:forEach var="shop" items="${shops}">
                        <tr>
                            <td>${shop.name}</td>
                            <td>${shop.shopCategory}</td>
                            <td>${shop.location.name}</td>
                            <td>${shop.owner.firstName} ${shop.owner.lastName}</td>
                            <td>
                                <a class="edit" title="Edit" data-toggle="tooltip" href="editShop?id=${shop.id}">
                                    <i class='fas' >&#xf044; Edit</i>
                                </a>
                                <a class="delete" title="Delete" data-toggle="tooltip" href="deleteShop?id=${shop.id}">
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