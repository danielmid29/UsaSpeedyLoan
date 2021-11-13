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
            <h3 style="font-weight: bold;margin-top: 14px;font-size: 18px;  text-transform: uppercase;margin-bottom: 0;">Authorization Code List            </h3>

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
        

<div class="container authorizecodeform">

	<form action="/crm-admin/addAuthorizationCode" method="post" style="margin-bottom: 20px;" name = "codeList">
		<div class="row">
			<div class="col-xs-10">
			  <input style="display: inline-block; width: 250px;" type="text" class="form-control" placeholder="Enter New Authorization Code" name = "authorizationCode" required style="outline: none">
			  <button type="submit" class="btn btn-primary" name='add' value="add" style="outline: none">Add Code</button>
			   <div class="form-group">
             <div style="color:red">${error.errorMessage}</div>
          </div>
			</div>
		</div>
	</form>



	
	
	
				<div class="table tbl-ctm" style="width:950px;">
						<table id="CodeTable" class="table odd table-striped table-responsive-sm">
							<thead>
								<tr>
									<th>Authorization Code</th>
									<th>Total Usages</th>
									<th>Status</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items = "${active}" var = "Active">
								<tr>
									<td>${Active.authorizationCode}</td>
									<td>${Active.usages}</td>
									<td>${Active.status}</td>
									<td>
											<button 
												type="button"
												class="btn btn-danger"
												style="background: red;width:100px; height: 30px"
												data-toggle="modal"
												data-target="#${Active.authorizationCode}disable">De-Activate</button>
									</td>
									</c:forEach>
									
									
									<c:forEach items = "${inactive}" var = "Inactive">
									<tr>
									<td>${Inactive.authorizationCode}</td>
									<td>${Inactive.usages}</td>
									<td>${Inactive.status}</td>
									<td>
										
											<button 
												type="button"
												class="btn btn-danger"
												style="background: red;width:100px; height: 30px"
												data-toggle="modal" disabled>De-Activated</button>
									</td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>	  	

	
</div>

<!-- Disable the Code -->

<c:forEach items = "${active}" var = "Active">
<div class="modal fade" id="${Active.authorizationCode}disable" tabindex="-1" role="dialog" aria-labelledby="ModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-sm" role="document" style="vertical-align: middle;">
        <div class="modal-content">
            <form action="/crm-admin/deactivateCode" name="codeList" method="post">
            	<div class="form-group">
            		<p style="color: red;text-align: center">You can't use further, once de-activate particular code</p>
              	</div>
            	<div class="form-group">
					    <input class="form-control" type="text" name= "authorizationCode" value="${Active.authorizationCode}" readonly>
				</div>
				<div class="modal-footer" style="text-align:center;">
            		<button type="button" class="btn btn-secondary" data-dismiss="modal" style="background:red; font-weight: bold; color:white">Cancel</button>
	                <button type="submit" id="${Active.authorizationCode}" class="btn btn-primary" name="deactivate" value="delete">Confirm</button>
              	</div>
            </form>
        </div>
    </div>
</div>
</c:forEach>

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
<script src="${pageContext.request.contextPath}/admin/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/admin/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/js/jquery.lightbox.js"></script>
<script src="${pageContext.request.contextPath}/admin/js/wow.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/js/jquery.nicescroll.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/admin/assets/sweet-alert/sweet-alert.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/assets/sweet-alert/sweet-alert.init.js"></script>
<script src="${pageContext.request.contextPath}/admin/assets/datatables/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/assets/datatables/dataTables.bootstrap.js  "></script>
<script type="${pageContext.request.contextPath}/text/javascript" src="/admin/js/style.js"></script>
<script src="${pageContext.request.contextPath}/admin/js/jquery.app.js"></script>
<script type="${pageContext.request.contextPath}/text/javascript" src="/admin/js/login.js"></script>
</body>
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

