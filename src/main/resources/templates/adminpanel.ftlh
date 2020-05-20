<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Admin panel!</title>
</head>
<body>
<h1>Admin panel</h1>
<#if exist??>
<div>
    Destination point with this short name already exist.
</div>
</#if>
<#if wrongLength??>
<div>
    Destination point should be 3 symbols long.
</div>
</#if>
<#if success??>
    <div>
        Destination point successfully added.
    </div>
</#if>

<form action="/dest-point/add" method="post">
    <div><label> Destination point name : <input type="text" name="name"/> </label></div>
    <div><label> Short name: <input type="text" name="shortName"/> </label></div>
    <div><input type="submit" value="Add destination"/></div>
</form>
<br>

<#if dp1??>
    <div>
        Destination point ${dp1} does not exist
    </div>
</#if>
<#if dp2??>
    <div>
        Destination point ${dp2} does not exist
    </div>
</#if>
<form action="/route/add" method="post">
    <div><label> Start destination name: <input type="text" name="dp1SN"/> </label></div>
    <div><label> Stop destination name: <input type="text" name="dp2SN"/> </label></div>
    <div><label> Distance: <input type="number" name="distance"/> </label></div>
    <div><label> Cost: <input type="number" name="cost"/> </label></div>
    <div><input type="submit" value="Add fly"/></div>
</form>
</body>
</html>
</body>
</html>