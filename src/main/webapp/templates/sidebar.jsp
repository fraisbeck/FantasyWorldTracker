<%@include file ="../taglib.jsp"%>
<div class="col-auto col-md-3 col-xl-2 px-sm-2 px-0 bg-dark">
    <div class="d-flex flex-column align-items-center align-items-sm-start px-3 pt-2 text-white min-vh-100">
        <a href="home" class="d-flex align-items-center pb-3 mb-md-0 me-md-auto text-white text-decoration-none">
            <i class="fas fa-home"></i> <span class="fs-5 d-none d-sm-inline">Home</span>
        </a>
        <ul class="nav nav-pills flex-column mb-sm-auto mb-0 align-items-center align-items-sm-start" id="menu">
            <li>
                <a href="#submenu1" data-bs-toggle="collapse" class="nav-link px-0 align-middle">
                    <i class="fas fa-globe"></i> <span class="ms-1 d-none d-sm-inline text-info">Worlds</span> </a>
                <ul class="collapse show nav flex-column ms-1" id="submenu1" data-bs-parent="#menu">
                    <li class="w-100">
                        <a href="worldResults.jsp" class="nav-link px-0"><i class="fas fa-search"></i>
                            <span class="d-none d-sm-inline text-warning">Search Worlds</span></a>
                    </li>
                    <li>
                        <a href="addNewWorld" class="nav-link px-0"><i class="far fa-plus-square"></i>
                            <span class="d-none d-sm-inline text-warning">Add New World</span></a>
                    </li>
                </ul>
            </li>
        </ul>
        <hr>
        <div class="dropdown pb-4">
            <c:choose>
                <c:when test="${empty user}">
                    <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle"
                        id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
                        <i class="	fas fa-user-circle"></i>
                        <span class="d-none d-sm-inline mx-1">Login</span>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-dark text-small shadow">
                        <li><a class="dropdown-item" href="signInForm">Sign in</a></li>
                        <li><a class="dropdown-item" href="userForm">Sign up</a></li>
                    </ul>
                </c:when>
                <c:otherwise>
                    <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle"
                       id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
                        <i class="	fas fa-user-circle"></i>
                        <span class="d-none d-sm-inline mx-1">${user.userName}</span>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-dark text-small shadow">
                        <li><a class="dropdown-item" href="signOut">Sign out</a></li>
                    </ul>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>
