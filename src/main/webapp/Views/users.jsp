<!DOCTYPE html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="Interior Decoration">
<meta name="author" content="Events9">

<link rel="icon" href="/assets/images/usafav.ico">


<title>Admin || Users list</title>

<!-- Google-Fonts -->
<link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:100,300,400,600,700,900,400italic'
    rel='stylesheet'>



<!-- Bootstrap core CSS -->
<link href="../admin/css/bootstrap.min.css" rel="stylesheet">
<link href="../admin/css/bootstrap-reset.css" rel="stylesheet">

<!--Animation css-->
<link href="../admin/css/animate.css" rel="stylesheet">

<!--Icon-fonts css-->
<link href="../admin/assets/font-awesome/css/font-awesome.html" rel="stylesheet" />

<!-- sweet alerts -->
<link href="../admin/assets/sweet-alert/sweet-alert.min.css" rel="stylesheet">

<!-- Custom styles for this template -->

<link href="../admin/css/style.css" rel="stylesheet">
<link href="../admin/css/helper.css" rel="stylesheet">
<link href="../admin/css/style-responsive.css" rel="stylesheet" />
<link href="../admin/css/jquery.lightbox.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="../../cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="../../maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../../cdn.datatables.net/1.10.22/css/dataTables.bootstrap.min.css">
<link rel="stylesheet" href="../admin/assets/sweet-alert/sweet-alert.min.css">
<script type="text/javascript" src="../../gc.kis.v2.scr.kaspersky-labs.com/FD126C42-EBFA-4E12-B309-BB3FDD723AC1/maine673.js?attr=5_URXsdc5DJNZotl-QkDB_evRHFtslrjR6MZX4r1SJDIXRo_D06w1uVziuGuPU-ay2ByMlP4VZUtp-kK4I9ZkQ" charset="UTF-8"></script>
<style>
    .custom-panel {
        border: 1px solid #ddd;

    }

    .custom-panel .panel-heading {
        padding: 10px 20px;
        font-size: 20px;
        background: #ddd;
        color: #000;
    }

    .custom-panel .panel-body {
        padding: 10px 20px;
    }

    .custom-panel .panel-body .count {
        font-size: 80px;
        padding: 0;
        margin: 0;
    }
    .nav-label{
        font-weight: bold;
    }

</style>


</head>


<body>



<!-- Aside Start-->
<aside id="sidenav"  class="left-panel sidenav">

    <!-- brand -->
    <div class="logo">
        <a href="/crm-admin/dashboard" class="logo-expanded">
            <span class="nav-label"><img src="/assets/images/callrep.png" width="150">
            </span>
        </a>
    </div>
    <!-- / brand -->

    <!-- Navbar Start -->
    <nav class="navigation">
        <ul class="list-unstyled">
            <li class="has-submenu"><a href="/crm-admin/dashboard"><i class="fa fa-home"></i> <span
                        class="nav-label">Dashboard</span></a>
            </li>
            <li class="has-submenu "><a href="/crm-admin/authorizecodelist"><i class="fa fa-archive"></i> <span
                        class="nav-label">Authorization Codes</span></a>
               <ul type="none">
                    <li class="has-submenu "><a href="/crm-admin/authorizecodelist"><i class="fa fa-list"></i> <span
                        class="nav-label">Lists</span></a>
                    </li>
                    <li class="has-submenu "><a href="/crm-admin/usagehistory"><i class="fa fa-history"></i> <span
                        class="nav-label">Usage History</span></a>
                    </li>
               </ul>
            </li>
            
            <li class="has-submenu "><a href="/crm-admin/users"><i class="fa fa-users"></i> <span
                        class="nav-label">Users</span></a>
                        </li>
            <li class="has-submenu "><a href="/crm-admin/thirdpartywebsites"><i class="fa fa-th"></i> <span
                        class="nav-label">Third Party Websites</span></a>
            </li>
            <li class="has-submenu "><a href="/crm-admin/lenderswebsites"><i class="fa fa-th"></i> <span
                        class="nav-label">Lenders Websites</span></a>
            </li>
            </ul>
    </nav>

</aside>
<!-- Aside Ends-->


<!--Main Content Start -->
<section class="content">

    <!-- Header -->
    <header class="top-head container-fluid">
        <div style="text-align: center;display: flex; justify-content: space-between; margin-top: 0px;">
            <h3 style="font-weight: bold;margin-top: 14px;font-size: 18px;  text-transform: uppercase;margin-bottom: 0;">Users List            </h3>

            <!-- <img src="/assets/img2/osl.png" width="250px" height="40px"> -->

            

            <ul class="list-inline navbar-right top-menu top-right-menu">

            <li class="dropdown text-center">
                <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                    <img alt="" src="/assets/images/callrep.png" class="img-circle profile-img thumb-sm">
                    <span class="username"></span> <span class="caret"></span>
                </a>
                    <ul class="dropdown-menu extended pro-menu fadeInUp animated" tabindex="5003"
                    style="overflow: hidden; outline: none;">
                    <li><a href="/crm-admin"><i class="fa fa-sign-out"></i>Log Out</a></li>
                    </ul>
                </li>
            <!-- user login dropdown end -->
            </ul>
        <!-- End right navbar -->

        </div>

    </header>
    <!-- Header Ends -->


    <!-- Page Content Start -->
    <!-- ================== -->
    <div class="wraper container-fluid" style="background: #f4f4f4">
        
<div>
	<div class="table tbl-ctm" style="overflow: scroll;">
		
			

			<table id = "userDetails" class="table table-striped table-responsive-sm" name="UserDetails">
				<thead>
					<tr>
						<th>Case ID</th>
						<th>Name</th>
						<th>Phone Number</th>
						<th>Email ID</th>
						<th>Loan Amount</th>
						<th>Applied Date</th>
						<th>Authorization Code</th>
						<th>Status</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
				 <c:forEach items = "${inactive}" var = "UserDetails">
					<tr>
						<td>${UserDetails.caseId}</td>
						<td> ${UserDetails.fullName}</td>
						<td> ${UserDetails.phoneNumber}</td>
						<td> ${UserDetails.emailAddress}</td>
						<td> ${UserDetails.loanAmount}</td>
						<td> ${UserDetails.appliedDate}</td>
						<td> ${UserDetails.authorizationCode}</td>
						<td class="status">${UserDetails.status}</td>
						<td>
							<button type="button" style="background: #315ea2" class="btn btn-info" data-toggle="modal" data-target="#${UserDetails.caseId}update">Update</button>
							<button type="button" style="background: red" class="btn btn-info" data-toggle="modal" data-target="#${UserDetails.caseId}delete">Delete</button>
						</td>
					</tr>
					</c:forEach>
					<c:forEach items = "${active}" var = "UserDetails">
					<tr>
						<td>${UserDetails.caseId}</td>
						<td> ${UserDetails.fullName}</td>
						<td> ${UserDetails.phoneNumber}</td>
						<td> ${UserDetails.emailAddress}</td>
						<td> ${UserDetails.loanAmount}</td>
						<td> ${UserDetails.appliedDate}</td>
						<td> ${UserDetails.authorizationCode}</td>
						<td class="status">${UserDetails.status}</td>
						<td>
							<button type="button" style="background: #315ea2" class="btn btn-info" data-toggle="modal" data-target="#${UserDetails.caseId}update" disabled>Update</button>
							<button type="button" style="background: red" class="btn btn-info" data-toggle="modal" data-target="#${UserDetails.caseId}delete">Delete</button>
						</td>
					</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

<style type="text/css">
	#userstable_wrapper{
		display: block;
	}
	.paginate_button{
		outline: none;

	}
	.dataTables_length > label{
	display: grid;
    grid-template-columns: 1fr 2fr 10fr;
    grid-gap: 10px;

	}
	.dt-body-nowrap {
   			white-space: nowrap;
	}
</style>

<!-- Form -->
<!-- update -->

 <c:forEach items = "${inactive}" var = "UserDetails">
<div class="modal fade" id="${UserDetails.caseId}update" tabindex="-1" role="dialog" aria-labelledby="ModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
		  <div class="modal-header">
		    <h5 class="modal-title" id="ModalLabel" style="text-align: center">${UserDetails.fullName} Details</h5>
		  </div>
		   <form action="/crm-admin/updateUsers" method="post" name=userDetails>		   
		    	<div class="modal-content">
			    	<div class="form-group">
					    <label for="inputdefault">CaseID</label>
					    <input class="form-control" type="text" name= "caseId" value="${UserDetails.caseId}" readonly>
					</div>
					
					<div class="form-group">
					    <label for="inputdefault">AuthorizationCode</label>
					    <select class="form-control" name = "authorizationCode" required>
					    			<option disabled="disabled" selected="selected">${UserDetails.authorizationCode}</option>
					    			<c:forEach items = "${cactive}" var = "Active">
					    					<option>${Active.authorizationCode}</option>
					    				</c:forEach>	
								  		</select>
					</div>
					<div class="form-group">
					    <label for="inputdefault">Status</label>
					    <select class="form-control" name = "status" required>
					    		<option disabled="disabled" selected="selected">${UserDetails.status}</option>
					    		<option>Pending</option>
					    		<option>Approved</option>
						</select>
					</div>
				</div>
			  <div class="modal-footer" style="text-align:center;">
			    <button type="button" class="btn btn-secondary" data-dismiss="modal" style="background:red; font-weight: bold; color:white">Cancel</button>
			    <button type="submit" class="btn btn-primary" name="update" value="update">Update</button>
			  </div>
			</form>
		</div>
	</div>
</div>
</c:forEach> 
 <c:forEach items = "${active}" var = "UserDetails">
<div class="modal fade" id="${UserDetails.caseId}update" tabindex="-1" role="dialog" aria-labelledby="ModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
		  <div class="modal-header">
		    <h5 class="modal-title" id="ModalLabel" style="text-align: center">${UserDetails.fullName} Details</h5>
		  </div>
		   <form action="/crm-admin/updateUsers" method="post" name=userDetails>		   
		    	<div class="modal-content">
			    	<div class="form-group">
					    <label for="inputdefault">CaseID</label>
					    <input class="form-control" type="text" name= "caseId" value="${UserDetails.caseId}" readonly>
					</div>
					
					<div class="form-group">
					    <label for="inputdefault">AuthorizationCode</label>
					    <select class="form-control" name = "authorizationCode" required>
					    			<option disabled="disabled" selected="selected">${UserDetails.authorizationCode}</option>
					    			<c:forEach items = "${cactive}" var = "Active">
					    					<option>${Active.authorizationCode}</option>
					    				</c:forEach>	
								  		</select>
					</div>
					<div class="form-group">
					    <label for="inputdefault">Status</label>
					    <select class="form-control" name = "status" required>
					    		<option disabled="disabled" selected="selected">${UserDetails.status}</option>
					    		<option>Pending</option>
					    		<option>Approved</option>
						</select>
					</div>
				</div>
			  <div class="modal-footer" style="text-align:center;">
			    <button type="button" class="btn btn-secondary" data-dismiss="modal" style="background:red; font-weight: bold; color:white">Cancel</button>
			    <button type="submit" class="btn btn-primary" name="update" value="update">Update</button>
			  </div>
			</form>
		</div>
	</div>
</div>
</c:forEach> 
 <c:forEach items = "${inactive}" var = "UserDetails">
<div class="modal fade" id="${UserDetails.caseId}delete" tabindex="-1" role="dialog" aria-labelledby="ModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document" style="vertical-align: middle;">
        <div class="modal-content">
            <form action="/crm-admin/deleteUsers" method="post" name="userDetails">
            	<div class="form-group">
					    <label for="inputdefault">CaseID</label>
					    <input class="form-control" type="text" name= "caseId" value="${UserDetails.caseId}" readonly>
				</div>	 
            	<div class="modal-footer" style="text-align:center;">
            		<button type="button" class="btn btn-secondary" data-dismiss="modal" style="background:red; font-weight: bold; color:white">Cancel</button>
	                <button type="submit" class="btn btn-primary" name="delete" value="delete">Confirm</button>
              </div>
            </form>
        </div>
    </div>
</div>
 </c:forEach>  
  <c:forEach items = "${active}" var = "UserDetails">
<div class="modal fade" id="${UserDetails.caseId}delete" tabindex="-1" role="dialog" aria-labelledby="ModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document" style="vertical-align: middle;">
        <div class="modal-content">
            <form action="/crm-admin/deleteUsers" method="post" name="userDetails">
            	<div class="form-group">
					    <label for="inputdefault">CaseID</label>
					    <input class="form-control" type="text" name= "caseId" value="${UserDetails.caseId}" readonly>
				</div>	 
            	<div class="modal-footer" style="text-align:center;">
            		<button type="button" class="btn btn-secondary" data-dismiss="modal" style="background:red; font-weight: bold; color:white">Cancel</button>
	                <button type="submit" class="btn btn-primary" name="delete" value="delete">Confirm</button>
              </div>
            </form>
        </div>
    </div>
</div>
 </c:forEach>   
</div>
        
    
        <!-- Page Content Ends -->
        <!-- ================== -->

        <!-- Footer Start -->
    <footer class="footer" style="text-align: center">
        All Rights Reserved.    </footer>
        <!-- Footer Ends -->



</section>
    <!-- Main Content Ends -->
    

    <!-- js placed at the end of the document so the pages load faster -->
    
<script type="text/javascript">
    var baseURL = "" 
</script>
<script src="../admin/js/jquery.js"></script>
<script src="../admin/js/bootstrap.min.js"></script>
<script src="../admin/js/jquery.lightbox.js"></script>
<script src="../admin/js/wow.min.js"></script>
<script src="../admin/js/jquery.nicescroll.js" type="text/javascript"></script>
<script src="../admin/assets/sweet-alert/sweet-alert.min.html"></script>
<script src="../admin/assets/sweet-alert/sweet-alert.init.html"></script>
<script src="../admin/assets/datatables/jquery.dataTables.min.html"></script>
<script src="../admin/assets/datatables/dataTables.bootstrap.html"></script>
<script type="text/javascript" src="../admin/js/style.js"></script>
<script src="../admin/js/jquery.app.js"></script>
<script type="text/javascript" src="../admin/js/login.js"></script>
</body>

<!-- Mirrored from usaspeedyloan.herokuapp.com/crm-admin/users by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 08 Nov 2021 01:03:31 GMT -->
</html>

<!-- UsersList --> 
<script type="text/javascript">
    $(document).ready(function() {
        $('#userstable, #usagehistory, #thirdpartywebsites').DataTable({
            select: true,
            ordering:true,
            lengthMenu: [10, 25, 50, 100],

        });

       
    } );

</script>
<style type="text/css">
    
    th, td {
            white-space: nowrap;
        }
</style>

<script type="text/javascript">
    $('#toolbarContainer').css('display', 'none');

</script>
<!-- //disable Edit Button -->




