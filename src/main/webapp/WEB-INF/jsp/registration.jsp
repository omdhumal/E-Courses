<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
     "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.alignTable {
	margin-left: auto;
	margin-right: auto;
}
</style>
<meta charset="ISO-8859-1">
<title>REGISTER PAGE</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.css" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
<c:import url="header.jsp"></c:import>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js">
    </script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.bundle.min.js">
    </script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js">
    </script>

<style>
.container {
	display: flex;
	justify-content: center;
	margin-top: 30px;
}

h1, container {
	color: green;
}
</style>

<script>
$(".datepicker").datepicker({
    clearBtn: true,
    format: "dd/mm/yyyy",
});
$(".datepicker").on("change", function() {
    let pickedDate = $("input").val();
    $("#showdate").text(
    `You picked this ${pickedDate} Date`);
});
	
	 document.getElementById("uploadButton").onclick = () => {
	      let fileElement = document.getElementById('fileInput')

	      // check if user had selected a file
	      if (fileElement.files.length === 0) {
	        alert('please choose a file')
	        return
	      }
	      let file = fileElement.files[0]
	      let formData = new FormData();
	      formData.set('file', file);

	      axios.post("http://localhost:3306/upload-single-file", formData, {
	        onUploadProgress: progressEvent => {
	          const percentCompleted = Math.round(
	            (progressEvent.loaded * 100) / progressEvent.total
	          );
	          console.log(`upload process: ${percentCompleted}%`);
	        }
	      })
	        .then(res => {
	          console.log(res.data)
	          console.log(res.data.url)
	        })
	    }
	 
	 function copy(){
		 if(check.checked==true){
			 
			 document.getElementById('pstate').value=document.getElementById('cstate').value;
			 document.getElementById('pdistrict').value=document.getElementById('cdistrict').value;
			 document.getElementById('ptahsil').value=document.getElementById('ctahsil').value;
			 document.getElementById('pvillage').value=document.getElementById('cvillage').value;
			 document.getElementById('plandmark').value=document.getElementById('clandmark').value;
			 document.getElementById('ppincode').value=document.getElementById('cpincode').value;
		 }
		 else{
			 document.getElementById('pdistrict').value=null;
			 document.getElementById('ptahsil').value=null;
			 document.getElementById('pvillage').value=null;
			 document.getElementById('plandmark').value=null;
			 document.getElementById('ppincode').value=null;
			 
			 
		 }
			 
	 }
</script>
</head>
<body style="background-color: #8fc4b7;">

	<form:form action="save" method="post" modelAttribute="userdetails">
		<table class="alignTable">
			<div class="container">
				<section class="h-100 h-custom" style="background-color: #8fc4b7;">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-lg-8 col-xl-10">
						<div class="card rounded-6">


							<div class="card-body p-4 p-md-5">
								<form>

									<div class="col-sm-12">
										<h3 class="mb-4 pb-2 pb-md-0 mb-md-5 px-md-2">Fill the
											Registration Form</h3>
									</div>
									<div class="col-sm-12">
										<div class="row">
											<div class="col-sm-4 form-group">
												<h6 class="mb-1 pb-1">Customer / Agent</h6>
												<div class="form-check form-check-inline">
													<form:radiobutton path="usertype" id="customer"
														value="customer" />
													&nbsp; Customer
												</div>
												<div class="form-check form-check-inline">
													<form:radiobutton path="usertype" id="agent" value="agent" />
													&nbsp; Agent
												</div>
											</div>
										</div>
									</div>


									<div class="col-sm-12">
										<div class="row">
											<div class="col-sm-4 form-group">
												<label for="firstName"><span class="req">* </span>
													FirstName: </label> <input required name="firstName" type="text"
													class="form-control" id="firstName"
													placeholder="Enter FirstName Name Here.." />
											</div>

											<div class="col-sm-4 form-group">
												<label>Middle Name</label>
												<form:input type="text" path="middleName" id="middleName"
													placeholder="Enter MiddleName Here.." class="form-control"></form:input>
											</div>
												<div class="col-sm-4 form-group">
													<label for="lastName"><span class="req">* </span>
														LastName: </label> <input required name="lastName" type="text"
														class="form-control" id="lastName"
														placeholder="Enter LastName Here.." />
												</div>

											</div>
										</div>
									

									<div class="col-sm-12">
										<div class="row">
											<div class="col-sm-3 form-group">
												<h6 class="mb-1 pb-1">Gender:</h6>

												<div class="form-check form-check-inline">
													<form:radiobutton path="gender" id="female" value="female" />
													&nbsp; Female

												</div>

												<div class="form-check form-check-inline">
													<form:radiobutton path="gender" id="male" value="male" />
													&nbsp; Male
												</div>

												<div class="form-check form-check-inline">
													<form:radiobutton path="gender" id="other" value="other" />
													&nbsp; other
												</div>
											</div>
											
											<div class="col-sm-3 form-group">
												<label class="control-label" for="date">Date of
													Birth</label>
												<div class="input-group date" data-provide="datepicker">
													<input type="text" id="dob" name="dob"
														placeholder="DD/MM/YYYY" class="form-control">
													<div class="input-group-addon">
														<span class="glyphicon glyphicon-th"></span>
													</div>
												</div>
											</div>
											<div class="col-sm-3 form-group">
												<label>Email Address</label>
												<form:input type="text" path="email" id="email"
													placeholder="Enter Email Address Here.."
													class="form-control"></form:input>
											</div>
											<div class="col-sm-3 form-group">
												<label for="password"><span class="req">* </span>
													Password: </label> <input required name="password" type="password"
													class="form-control" maxlength="12" id="pass1" />
											</div>

										</div>
									</div>
									<div class="col-sm-12">
										<div class="row">
											<div class="col-sm-4 form-group">
												<label>Primary contact</label>
												<form:input type="text" path="primaryContact"
													id="primaryContact" placeholder="Enter Phone Number Here.."
													class="form-control" maxlength="10"></form:input>
											</div>
											<div class="col-sm-4 form-group">
												<label>Alternate Contact</label>
												<form:input type="text" path="alternateContact"
													id="alternateContact"
													placeholder="Enter Phone Number Here.."
													class="form-control" maxlength="10"></form:input>
											</div>
											<div class="col-sm-4 form-group">
												<label>GovermentID Number</label>
												<form:input type="text" path="adhaarNumber"
													id="adhaarNumber" placeholder="Enter Adhar Number Here.."
													class="form-control" maxlength="12"></form:input>
											</div>
										</div>
									</div>
									<div class="col-sm-12">
										<h6 class="text-primary"></h6>
										<div class="row">
											<div class="col-sm-4 form-group">
												<label>Select Id Proof</label>
												<form:select path="idType" class="form-control">
													<option>Select:</option>
													<option>AdharCard:</option>
													<option>PanCard</option>
													<option>VoterId</option>
													<option>Pass_Port</option>
												</form:select>
											</div>
											<div class="col-sm-4 form-group">
												<label>Attach Document</label> <input type="file"
													name="image">
											</div>
										</div>
									</div>
									<div class="col-sm-12">
										<h6 class="text-primary">Current Address</h6>
										<p>Enter permanent address as your Identity card</p>
										<div class="row">

											<div class="col-sm-4 form-group">
												<label>State</label>
												<form:select path="caddress.state" id="cstate" value=""
													class="form-control">
													<option>Select State:</option>
													<option>Maharastra</option>
													<option>Gujrat</option>
													<option>Dehli</option>
												</form:select>
											</div>
											<div class="col-sm-4 form-group">
												<label>District</label>
												<form:input type="text" path="caddress.district"
													id="cdistrict" value="" placeholder="Enter District Here.."
													class="form-control"></form:input>
											</div>
											<div class="col-sm-4 form-group">
												<label>Tahsil</label>
												<form:input type="text" path="caddress.tahsil" id="ctahsil"
													value="" placeholder="Enter Tahsil Here.."
													class="form-control"></form:input>
											</div>
											<div class="col-sm-4 form-group">
												<label>village</label>
												<form:input type="text" path="caddress.Village"
													id="cvillage" value="" placeholder="Enter Village Here.."
													class="form-control"></form:input>
											</div>
											<div class="col-sm-4 form-group">
												<label>Landmak</label>
												<form:input type="text" path="caddress.landMark"
													id="clandmark" value="" placeholder="Enter Landmark Here.."
													class="form-control"></form:input>
											</div>

											<div class="col-sm-4 form-group">
												<label>Pin code</label>
												<form:input type="text" path="caddress.pincode"
													id="cpincode" value="" placeholder="Enter Zip Code Here.."
													class="form-control"></form:input>
											</div>
										</div>
										<div class="col-sm-14">
											<h6 class="text-primary">Permanent Address</h6>
											<div class="form-group">
												<input type="checkbox" id="check" onclick="copy()">
												Same as current address
											</div>


											<div class="row">
												<div class="col-sm-4 form-group">
													<label>State</label>
													<form:select path="paddress.state" id="pstate" value=""
														class="form-control">
														<option>Select State:</option>
														<option>Maharastra</option>
														<option>Gujrat</option>
														<option>Dehli</option>
													</form:select>
												</div>


												<div class="col-sm-4 form-group">
													<label>District</label>
													<form:input type="text" path="paddress.district"
														id="pdistrict" value=""
														placeholder="Enter District Here.." class="form-control"></form:input>
												</div>
												<div class="col-sm-4 form-group">
													<label>Tahsil</label>
													<form:input type="text" path="paddress.tahsil" id="ptahsil"
														value="" placeholder="Enter Tahsil Here.."
														class="form-control"></form:input>
												</div>
												<div class="col-sm-4 form-group">
													<label>village</label>
													<form:input type="text" path="paddress.village"
														id="pvillage" value="" placeholder="Enter Village Here.."
														class="form-control"></form:input>
												</div>
												<div class="col-sm-4 form-group">
													<label>Landmak</label>
													<form:input type="text" path="paddress.landMark"
														id="plandmark" value=""
														placeholder="Enter LandMark Here.." class="form-control"></form:input>
												</div>

												<div class="col-sm-4 form-group">
													<label>Pin code</label>
													<form:input type="text" path="paddress.pincode"
														id="ppincode" value="" placeholder="Enter Zip Code Here.."
														class="form-control"></form:input>
												</div>
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>

				</div>
				</section>

			</div>

			<tr>
				<td></td>
				<td align="right"><input type="submit" value="Save"></td>
			</tr>

		</table>
	</form:form>
</body>
</html>