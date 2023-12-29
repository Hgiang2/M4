<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 26/12/2023
  Time: 11:33 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <style>
        * {
            font-family: sans-serif;
            font-size: 18px;
        }
    </style>
<c:set var="customer" value="${customer}"/>
<form action="/edit?action=save&customerId=${customer.getId()}" method="post">
    <input type="text" name="id" id="id" value="${customer.getId()}" hidden="hidden">
    <label for="name">Name</label>
    <input type="text" name="name" id="name" placeholder="${customer.getName()}" value="${customer.getName()}">

    <label for="email">Email</label>
    <input type="text" name="email" id="email" placeholder="${customer.getEmail()}" value="${customer.getEmail()}">

    <label for="address">Address</label>
    <input type="text" name="address" id="address" placeholder="${customer.getAddress()}" value="${customer.getAddress()}">

    <button type="submit">Submit</button>
    </form>
