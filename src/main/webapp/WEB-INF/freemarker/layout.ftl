<#macro basic>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Reston Lunch</title>
    <link type="text/css" rel="stylesheet" href="${rc.contextPath}/bootstrap/css/bootstrap.min.css"/>
    <style type="text/css">
        body {
            padding-top: 60px;
            padding-bottom: 40px;
        }
    </style>

    <link type="text/css" rel="stylesheet" href="${rc.contextPath}/bootstrap/css/bootstrap-responsive.min.css"/>


    <script src="${rc.contextPath}/jquery/jquery.min.js"></script>
    <script src="${rc.contextPath}/bootstrap/js/bootstrap.min.js"></script>
    <script src="${rc.contextPath}/angular/angular.min.js"></script>
    <script src="${rc.contextPath}/script/controllers.js"></script>
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="brand">Reston Lunch</a>
        <ul class="nav">
            <li <#if area == "home">class="active"</#if>><a href="${rc.contextPath}/index.html">Home</a></li>
            <li <#if area == "restaurants">class="active"</#if>><a href="${rc.contextPath}/restaurants.html">Restaurants</a></li>
            <li><a href="">Contact</a></li>
            <li> ${rc.contextPath + .template_name}</li>
        </ul>
    </div>
</div>

  <#nested>
</body>
</html>
</#macro>