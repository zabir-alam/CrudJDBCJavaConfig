<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
     <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
     <title>Insert title here</title>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
   </head>
   <body>
      <h3>Add / Edit Employee!!!</h3>

      <form method="post" action="saveEmp" >
        <div class="table-responsive">
        <h2 style="color:green;">${msg}</h2>
          <table class="table table-bordered" style="width: 300px">
            <tr>
              <td>Id :</td>
              <td><input type="text" name="id" value="${emp.id}"/></td>
            </tr>
            <tr>
              <td>Name :</td>
              <td><input type="text" name="name" value="${emp.name}"/></td>
            </tr>
            <tr>
              <td>Age :</td>
              <td><input type="text" name="age" value="${emp.age}"/></td>
            </tr>
            <tr>
              <td>Department :</td>
              <td><input type="text" name="dept" value="${emp.dept}"/></td>
            </tr>
            <tr>
              <td></td>
              <td><input class="btn btn-primary btn-sm" type="submit" value="Save/Update" /></td>
            </tr>
          </table>
        </div>
      </form>
    
     <br>
     <h3>List of Employees</h3>
       <table class="table table-bordered" style="width: 400px">
         <tr>
           <th>Id</th>
           <th>Name</th>
           <th>Age</th>
           <th>Department</th>
           <th>Edit/Delete</th>
         </tr>
         <c:forEach items="${list}" var="emp">
         <tr>
           <td width="60" align="center">${emp.id}</td>
           <td width="60" align="center">${emp.name}</td>
           <td width="60" align="center">${emp.age}</td>
           <td width="60" align="center">${emp.dept}</td>
           <td width="60" align="center"><a href="editEmp?id=${emp.id}">Edit</a>/<a href="deleteEmp?id=${emp.id}">Delete</a></td>
         </tr>
      </c:forEach>
    </table>
  </body>
</html>