<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Routes</title>
    <#include "bootstrap.ftlh">
</head>
<body>
<h1>Available routes</h1>
<div class="container">
    <div class="row justify-content-center">
        <table class="table" style="border: black solid 1px;">
            <tr>
                <th>Start point</th>
                <th>Finish point</th>
                <th>Distance</th>
                <th>Cost</th>
            </tr>
            <#list routes as route>
                <tr>
                    <td>${route.dp1}</td>
                    <td>${route.dp2}</td>
                    <td>${route.distance}</td>
                    <td>${route.cost}</td>
                </tr>
            </#list>
        </table>
    </div>
</div>


</body>
</html>