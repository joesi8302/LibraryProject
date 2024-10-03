<%@ taglib uri="http://www.springframework.org/tags/f" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Form</title>

</head>
<body>

<div class="container">
    <h2>User Registration Form</h2>

    <!-- Start of the Spring Form -->
    <f:form method="POST" action="/saveUser" modelAttribute="user">

        <div class="f-group">
            <label for="firstName">First Name</label>
            <f:input path="firstName" id="firstName" />
            <f:errors path="firstName" cssClass="error" />
        </div>

        <div class="f-group">
            <label for="lastName">Last Name</label>
            <f:input path="lastName" id="lastName" />
            <f:errors path="lastName" cssClass="error" />
        </div>

        <div class="f-group">
            <label for="address">Address</label>
            <f:textarea path="address" id="address" rows="3" />
            <f:errors path="address" cssClass="error" />
        </div>

        <div class="f-group">
            <label for="email">Email</label>
            <f:input path="email" id="email" type="email" />
            <f:errors path="email" cssClass="error" />
        </div>

        <div class="f-group">
            <label for="phone">Phone</label>
            <f:input path="phone" id="phone" />
            <f:errors path="phone" cssClass="error" />
        </div>

        <!-- Submit Button -->
        <div class="f-group">
            <button type="submit">Submit</button>
        </div>

    </f:f>
</div>

</body>
</html>
