<%@ page contentType="text/html" pageEncoding="UTF-8" %>


        <html>

        <head>
            <title>User Management Application</title>
       <!-- <link rel="stylesheet" href="static/css/bootstrap.min.css" > -->

             <!-- jQuery library -->
            <script src="static\Js\jquery.min.js"></script>
            <!-- Popper JS -->
            <!-- <script src="static/Js/popper.min.js"></script> -->
            <!-- <script src="js/popper.min.js"></script> -->
            <!-- <script src="https://unpkg.com/@popperjs/core@2"></script> <script src="https://unpkg.com/tippy.js@6"></script> -->
               <!-- @import bootstrap 5 js file-->
               <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
               <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
                  <!-- @import SweetAlert2 -->
            <script src="static\Js\SweetAlert.min.js"></script>
            <!-- @import DATA table css file-->

                    <link rel="stylesheet" type="text/css" href="static\DataTables\datatables.min.css"/>
            <link rel="stylesheet" href="static/font-awsome/css/font-awesome.min.css">
        </head>

        <body class="bg-dark">

            <header>
                <nav class="navbar navbar-expand-md text-center navbar-dark bg-danger p-3">
                    <div>
                        <a href="app" class="navbar-brand lead"> User Management App </a>
                    </div>
                </nav>
            </header>
            <br>



                <div class="container bg-light m-5 p-5  ">
                    <h3 class="text-muted text-center"><span class="display-5">List of Users</span></h3>
                    <hr>
                    <div class="container">

                        <a href="new" class="btn btn-danger lead">Add New User</a>
                    </div>
                    <br>
                    <div class="container col-12 lead">
                    <table class="table table-dark table-hover " id="tableUser">
                        <thead>
                            <tr>
                                <th scope="col" class="col-2">ID</th>
                                <th scope="col"  class="col-3">Name</th>
                                <th scope="col"  class="col-3">Email</th>
                                <th scope="col"  class="col-2">Actions</th>
                            </tr>
                        </thead>

                        <tbody id="ajaxTbody">
  


                        </tbody>

                    </table>
                        </div>
                </div>

            <!--!start scripts links -->



<!-- Delete Modal -->
<article class="modal fade Modal-T- " id="DeleteProd" tabindex="-1" aria-labelledby="mdu" aria-hidden="true">
  <div class="modal-dialog ">
    <div class="modal-content">
      <div class="modal-header bg-dark">
        <h5 class="modal-title text-center text-white" id="mdu"><i class="fa fa-trash fa-lg" aria-hidden="true" title="supp. ChefDepot"></i>&nbsp;&nbsp;Confirmation</h5>
        <button type="button" class=" btn-close bg-white" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
      are you sure ?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal">Close</button>
             <button type="button" class="btn btn-danger" id="itg"><i class="fa fa-trash fa-lg" aria-hidden="true" title="Copy to use edit" data-bs-toggle="modal" data-bs-target="#Delete"></i>&nbsp;Remove that user</button>

      </div>
    </div>
  </div>
</article>
          
 <!-- edit Modal -->
            <div class="modal fade Modal-T-" id="editmod" tabindex="-1" aria-labelledby="mdu" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-header bg-dark">
                            <h5 class="modal-title text-center text-white" id="mdu"><i class="fa fa-edit fa-lg" aria-hidden="true" title=" edit"></i>&nbsp;&nbsp;Edit User</h5>
                            <button type="button" class=" btn-close bg-white" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body px-3 py-3" id="editmodbody" >
                            <div class="row justify-centre my-4 text-primary" title="infoCHEF"><i class="fa fa-edit fa-lg text-center" style="font-size:120px"id="infobtn" aria-hidden="true"></i></div>

                            <form action"" method="post" id="fromEditer">

                                                    <caption>
                                                        <h2>Add New User</h2>
                                                    </caption>
                                                     <fieldset class="form-group" style="display:node;"> <input type="text" style="display:none;" class="form-control" name="OLDemail" id="OLDemail" required="required" readonly>
                                                                                                        </fieldset>
                             <div class="mt-2"><input name="iduser" id="editid" placeholder="nom" type="text" class="form-control" readonly></div>

                                                    <fieldset class="form-group">
                                                        <label>User Name</label> <input type="text" class="form-control" name="editedName" id="editedName" required="required">
                                                    </fieldset>

                                                    <fieldset class="form-group">
                                                        <label>User Email</label> <input type="text" class="form-control" id="editedEmail" name="editedEmail">
                                                    </fieldset>
                                                    </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary" id="editIt"><i class="fa fa-edit fa-lg" aria-hidden="true" title=" edit"></i>&nbsp;Edit it!</button>
                        </div>
                    </div>
                </div>
            </div>

 

     
      
    <script src="static/Js/ajaxBehavior.js"></script>

            <!-- @import DATA table js file-->
            <script type="text/javascript" src="static\DataTables\datatables.min.js"></script>
            <!-- !end scripts links -->

        </body>

        </html>