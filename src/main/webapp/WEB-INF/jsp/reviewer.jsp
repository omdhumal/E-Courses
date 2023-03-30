<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <title>LifeSecureInsurance</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<c:import url="header.jsp"></c:import>

    <style>
    .btn-purple {
    color: #fff;
    background-color: #6f42c1;
    border-color: #643ab0;
}
.header {
  padding: 20px;
  text-align: center;
  background: #1abc9c;
  color: yellow;
  font-size: 15px;
}

.modal-body div{float:left; width: 100%}
.modal-body div p{float:left; width: 20%; font-weight: 600;}
.modal-body div span{float:Right; width: 50%}
</style>
<script>
    jQuery(document).ready(function($) {
    $('#example').DataTable({
        searching: false,
        responsive: true,
        "autoWidth": false,
    });
    var table = $('#example').DataTable();
    $('#example tbody').on('click', 'tr', function () {
        //console.log(table.row(this).data()0);
        $(".modal-body div span").text("");0
        $(".customerid span").text(table.row(this).data()[0]);
        $(".customerfname span").text(table.row(this).data()[1]);   
        $(".customertype span").text(table.row(this).data()[2]);
        $(".customerGender span").text(table.row(this).data()[3]);
        $(".customerDob span").text(table.row(this).data()[4]);
        $(".customerEmail span").text(table.row(this).data()[5]);
        $(".customerPrimContact span").text(table.row(this).data()[6]);
        $(".customerid").text(table.row(this).data()[0]);
        $("#myModal").modal("show");
    });
} );
</script>
</head>
<body>
<div class="header">
         <h1>Customer Details</h1>
      
         </div>
     <div>
        

    
    <table id="example" class="display " style="width:100%">
    <thead>
        <tr>
                    <th>customer Id</th>
                    <th>customer_name</th>                    
                    <th>customer_type</th>
                    <th>customer_gender</th>
                    <th>customer_dob</th>               
                    <th> customer_email</th>
                    <th> customer_primcontact</th> 
                    <th> customer_altcontact</th> 
                    <th>status<th>
                        
                    
        </tr>
    </thead>
    <tbody>
       
        <c:forEach var="reviewer" items="${uList}">
                <tr>
                    <td ><c:out value="${reviewer.id}"></c:out></td>
                    <td><c:out value="${reviewer.fname}  ${reviewer.lname}"></c:out></td>                  
                    <td ><c:out value="${reviewer.type}"></c:out></td>
                    <td ><c:out value="${reviewer.gender}"></c:out></td>
                    <td ><c:out value="${reviewer.dob}"></c:out></td>
                    <td ><c:out value="${reviewer.email}"></c:out></td>
                    <td ><c:out value="${reviewer.primaryContact}"></c:out></td>
                    <td ><c:out value="${reviewer.altanateContact}"></c:out></td>
                    <td> pending<td>
                    
                    
                    
                </tr>
                </c:forEach>
    </tbody>
    
</table>
   <div class="modal fade" id="myModal" role="dialog">
<div class="modal-dialog">
  <!-- Modal content-->
  <div class="modal-content">
    <div class="modal-header">
      <h4 class="modal-title">Customer Details</h4>
    </div>
    <div class="modal-body">
    
       <div class="customerid"><p>customer Id: </p><span></span></div>
      <div class="customerfname"><p>customer_fname: </p><span></span></div>
      <div class="customertype"><p>customer_type: </p><span></span></div>
      <div class="customerGender"><p>customer_gender: </p><span></span></div>
      <div class="customerDob"><p>customer_dob: </p><span></span></div>
        <div class="customerEmail"><p>customer_email: </p><span></span></div>
         <div class="customer_prim_contact"><p>customer_prim_contact: </p><span></span></div>
          <div class="customer_alt_contact"><p>customer_alt_contact: </p><span></span></div>
           <div class="customer_gov_id_number"><p>customer_gov_id_number: </p><span></span></div>
           
          
           <a  href="approve?id=${customerid}"  >approve</a>
           </div>
         
    </div>
    <div class="modal-footer">
      <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
    </div>
  </div>
  <div>
  
</div>
</div>
</div>

</body>
</html>