<%@include file ="taglib.jsp"%>
<c:set var="title" value="HomePage" scope="session"/>
<html>
    <c:import url="/templates/head.jsp" />
<body>
<div class="container-fluid">
    <c:import url="/templates/header.jsp" />
    <div class="row flex-nowrap">
        <c:import url="/templates/sidebar.jsp" />
        <div id="content">
            <h2>Fantasy World Tracker</h2>
        </div>
    </div>
    <c:import url="/templates/footer.jsp" />
</div>
</body>
</html>
