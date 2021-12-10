<%@include file ="taglib.jsp"%>
<c:set var="title" value="HomePage" scope="session"/>
<html>
<c:import url="/templates/head.jsp" />
<body>
<div class="container-fluid">
    <c:import url="/templates/header.jsp" />
    <div class="row flex-nowrap">
        <c:import url="/templates/sidebar.jsp" />
        <div id="content" class="col-auto col-md-9 col-xl-10 mt-3">
            <h2>Fantasy World Tracker</h2>
            <ul class="nav nav-tabs" id="myTab" role="tablist">
                <li class="nav-item" role="presentation">
                    <a class="nav-link" id="continents-tab" data-bs-toggle="tab" href="#continents" type="button" role="tab" aria-controls="continents" aria-selected="true">Continents</a>
                </li>
                <li class="nav-item" role="presentation">
                    <a class="nav-link" id="profile-tab" data-bs-toggle="tab" href="#regions" type="button" role="tab" aria-controls="regions" aria-selected="false">Regions</a>
                </li>
                <li class="nav-item" role="presentation">
                    <a class="nav-link" id="locations-tab" data-bs-toggle="tab" href="#locations" type="button" role="tab" aria-controls="locations" aria-selected="false">Locations</a>
                </li>
                <li class="nav-item" role="presentation">
                    <a class="nav-link" id="shops-tab" data-bs-toggle="tab" href="#shops" type="button" role="tab" aria-controls="shops" aria-selected="false">Shops</a>
                </li>
                <li class="nav-item" role="presentation">
                    <a class="nav-link" id="shop_owners-tab" data-bs-toggle="tab" href="#shop_owners" type="button" role="tab" aria-controls="shop_owners" aria-selected="false">Shop Owners</a>
                </li>
            </ul>
            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade" id="continents" role="tabpanel" aria-labelledby="continents-tab">
                    <form action="searchContinents" class="form-outline">
                        <div class="input-group">
                            <input type="text" class="form-control" id="continentSearchTerm" name="continentSearchTerm" aria-describedby="searchTermHelp" placeholder="Enter Name">
                            <input type="hidden" id="continentSearchType" name="continentSearchType" value="name">
                            <button type="submit" name="submit" value="search" class="btn btn-primary"><i class="fas fa-search"> Search</i></button>
                            <button type="submit" name="submit" value="viewAll" class="btn btn-success"><i class="fas fa-search-plus"> All</i></button>
                        </div>
                    </form>
                    <a class="btn btn-primary" href="addNewContinent"><i class="fas fa-plus-circle"></i> Add New Continent</a>
                    <table id="continentsTable" class="table table-striped table-hover">
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
                                        <i class='fas' >&#xf1f8; Delete</i>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="tab-pane fade" id="regions" role="tabpanel" aria-labelledby="regions-tab">
                    <form action="searchRegions" class="form-outline">
                        <div class="input-group">
                            <input type="text" class="form-control" id="regionSearchTerm" name="regionSearchTerm" aria-describedby="searchTermHelp" placeholder="Enter Name">
                            <input type="hidden" id="regionSearchType" name="regionSearchType" value="name">
                            <button type="submit" name="submit" value="search" class="btn btn-primary"><i class="fas fa-search"> Search</i></button>
                            <button type="submit" name="submit" value="viewAll" class="btn btn-success"><i class="fas fa-search-plus"> All</i></button>
                        </div>
                    </form>
                    <a class="btn btn-primary" href="addNewRegion"><i class="fas fa-plus-circle"></i> Add New Region</a>
                    <table id="regionsTable" class="table table-striped table-hover">
                        <thead>
                        <th>Name</th>
                        <th>Continent</th>
                        <th>Modify</th>
                        </thead>
                        <tbody>
                        <c:forEach var="region" items="${regions}">
                            <tr>
                                <td><a class="search" title="Search" data-toggle="tooltip" href="searchLocations?submit=region&id=${region.id}">${region.name}</a></td>
                                <td>${region.continent.name}</td>
                                <td>
                                    <a class="edit" title="Edit" data-toggle="tooltip" href="editRegion?id=${region.id}">
                                        <i class='fas' >&#xf044; Edit</i>
                                    </a>
                                    <a class="delete" title="Delete" data-toggle="tooltip" href="deleteRegion?id=${region.id}">
                                        <i class='fas' >&#xf1f8; Delete</i>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="tab-pane fade" id="locations" role="tabpanel" aria-labelledby="locations-tab">
                    <form action="searchLocations" class="form-outline">
                        <div class="input-group">
                            <input type="text" class="form-control" id="locationSearchTerm" name="locationSearchTerm" aria-describedby="searchTermHelp" placeholder="Enter Name">
                            <input type="hidden" id="locationSearchType" name="locationSearchType" value="name">
                            <button type="submit" name="submit" value="search" class="btn btn-primary"><i class="fas fa-search"> Search</i></button>
                            <button type="submit" name="submit" value="viewAll" class="btn btn-success"><i class="fas fa-search-plus"> All</i></button>
                        </div>
                    </form>
                    <a class="btn btn-primary" href="addNewLocation"><i class="fas fa-plus-circle"></i> Add New Location</a>
                    <table id="locationsTable" class="table table-striped table-hover">
                        <thead>
                        <th>Name</th>
                        <th>Region</th>
                        <th>Modify</th>
                        </thead>
                        <tbody>
                        <c:forEach var="location" items="${locations}">
                            <tr>
                                <td><a class="search" title="Search" data-toggle="tooltip" href="searchShops?submit=location&id=${location.id}">${location.name}</a></td>
                                <td>${location.region.name}</td>
                                <td>
                                    <a class="edit" title="Edit" data-toggle="tooltip" href="editLocation?id=${location.id}">
                                        <i class='fas' >&#xf044; Edit</i>
                                    </a>
                                    <a class="delete" title="Delete" data-toggle="tooltip" href="deleteLocation?id=${location.id}">
                                        <i class='fas' >&#xf1f8; Delete</i>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="tab-pane fade" id="shops" role="tabpanel" aria-labelledby="shops-tab">
                    <form action="searchShops" class="form-outline">
                        <div class="input-group">
                            <input type="text" class="form-control" id="shopSearchTerm" name="shopSearchTerm" aria-describedby="searchTermHelp" placeholder="Search">
                            <select name="shopSearchType" id="shopSearchType">
                                <option value="name">Name</option>
                                <option value="shopCategory">Category</option>
                            </select>
                            <button type="submit" name="submit" value="search" class="btn btn-primary"><i class="fas fa-search"> Search</i></button>
                            <button type="submit" name="submit" value="viewAll" class="btn btn-success"><i class="fas fa-search-plus"> All</i></button>
                        </div>
                    </form>
                    <a class="btn btn-primary" href="addNewShop"><i class="fas fa-plus-circle"></i> Add New Shop</a>
                    <table id="shopsTable" class="table table-striped table-hover">
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
                                        <i class='fas' >&#xf1f8; Delete</i>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="tab-pane fade" id="shop_owners" role="tabpanel" aria-labelledby="shop_owners-tab">
                    <form action="searchOwners" class="form-outline">
                        <div class="input-group">
                            <input type="text" class="form-control" id="shopOwnerSearchTerm" name="shopOwnerSearchTerm" aria-describedby="searchTermHelp" placeholder="Enter First name">
                            <select name="shopOwnerSearchType" id="shopOwnerSearchType">
                                <option value="firstName">First Name</option>
                                <option value="lastName">Last Name</option>
                                <option value="profession">Profession</option>
                            </select>
                            <button type="submit" name="submit" value="search" class="btn btn-primary"><i class="fas fa-search"> Search</i></button>
                            <button type="submit" name="submit" value="viewAll" class="btn btn-success"><i class="fas fa-search-plus"> All</i></button>
                        </div>
                    </form>
                    <a class="btn btn-primary" href="addNewOwner"><i class="fas fa-plus-circle"></i> Add New Owner</a>
                    <table id="shopOwnersTable" class="table table-striped table-hover">
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
                                    <a class="edit" title="Edit" data-toggle="tooltip" href="editShopOwner?id=${owner.id}">
                                        <i class='fas' >&#xf044; Edit</i>
                                    </a>
                                    <a class="delete" title="Delete" data-toggle="tooltip" href="deleteShopOwner?id=${owner.id}">
                                        <i class='fas' >&#xf1f8; Delete</i>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <c:import url="/templates/footer.jsp" />
</div>
</body>
</html>

<script>
    $(document).ready(function(){
        $('a[data-bs-toggle="tab"]').on('show.bs.tab', function(e) {
            localStorage.setItem('activeTab', $(e.target).attr('href'));
        });
        let activeTab = localStorage.getItem('activeTab');
        if(activeTab){
            $('#myTab a[href="' + activeTab + '"]').tab('show');
        }
    });
</script>
