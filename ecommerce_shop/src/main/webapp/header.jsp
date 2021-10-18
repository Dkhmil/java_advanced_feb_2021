
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Header</title>
</head>
<body>
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet"
      id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<div class="container">
    <div class="row">
        <div class="span12">
            <div class="head">
                <div class="row-fluid">
                    <div class="span12">
                        <div class="span6">
                            <h1 class="muted">Company Name</h1>
                        </div>

                        <div class="span4 offset2" style="margin-top:15px;">
                            <button class="btn pull-right" type="button" id="logout">Log out</button>
                        </div>
                    </div>
                </div>

                <div class="navbar">
                    <div class="navbar-inner">
                        <div class="container">
                            <ul class="nav">
                                <li>
                                    <a href="${pageContext.request.contextPath}/cabinet.jsp">Products</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/bucket.jsp">Bucket</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/createProduct.jsp">ADD Product</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="js/logout.js"></script>

</body>
</html>
