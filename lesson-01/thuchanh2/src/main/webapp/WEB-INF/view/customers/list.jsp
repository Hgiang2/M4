<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    table {
        border: 1px solid #000;
    }

    th, td {
        border: 1px dotted #555;
    }
</style>
There are ${customers.size()} customer(s) in list.
<table>
    <caption>Customers List</caption>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="c" items="${customers}">
        <tr>
            <td>
                <c:out value="${c.getId()}"/>
            </td>
            <td>
                <c:out value="${c.getName()}"/>
            </td>
            <td>
                <c:out value="${c.getEmail()}"/>
            </td>
            <td>
                <c:out value="${c.getAddress()}"/>
            </td>
            <td>
                <a href="<c:url value="/edit?action=edit&customerId=${c.getId()}"/>">
                    <button>Edit</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>