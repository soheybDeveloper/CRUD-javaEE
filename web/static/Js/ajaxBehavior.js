$(document).ready(function(){
ListUser();




    function ListUser(){

        $.ajax({
            url:"ajaxList",
            type:"GET",
            data:{},
            success:function(response){
$('#ajaxTbody').html("")
$('#ajaxTbody').html(response)
/* */
     $("#tableUser").DataTable({
                              dom: 'lBfrtip',
//                              buttons: [ {
//                                  extend: 'excel',
//                                  text: '<i class="fa fa-fw" aria-hidden="true" title="Export it!"></i>&nbsp;&nbsp;Export to excel',
//                                   className: 'btn btn-success my-2 glyphicon glyphicon-list-alt',
//                                  title: 'USER List'
//                              }, {
//                                  extend: 'pdf',
//                                  text: '<i class="fa fa-file-pdf-o" aria-hidden="true" title="Export it!"></i>&nbsp;&nbsp;Export to PDF',
//                                  className: 'btn btn-danger my-2 glyphicon glyphicon-list-alt',
//                                  title: 'USER List'
//                              },
//                              {
//                                  extend: 'print',
//                                  text: '<i class="fa fa-print" aria-hidden="true" title="Export it!"></i>&nbsp;&nbsp;Print',
//                                  className: 'btn btn-secondary my-2 ',
//                                  title: 'USER List'
//                              }
//                              ],
                              "lengthMenu": [5,10,25,50,100]
                              });

                              }});

    }


             



   $("body").on("click",".deleteUser",function(e){

    e.preventDefault();
    Ref= $(this).attr('id');


   $("#DeleteProd").modal("show");
$("#itg").click(function(o){

    o.preventDefault();

    $.ajax({
url:"delete",
type:"GET",
data:{REF:Ref},
success:function(resp){
 Swal.fire({
        title: 'user <b>removed </b> successfully <i class="fa fa-trash fa-lg" aria-hidden="true">&nbsp;</i> !',
        text: 'check it!',
        icon: 'success'
     } )
ListUser()
$("#DeleteProd").modal('hide');
                   }
});})});


// edit User 

$("body").on("click",".editbtn",function(e){


   idel='#';
       idel+= $(this).attr('id');
       //console.log(idel);

       info=$(idel).parent();

    //console.log(info);

    var datauser = {};
    info.children().each( function( index, element ){
      datauser[index]=$.trim($(this).text());
  });
  idel='';
  $("#OLDemail").val(datauser[2]);
  $("#editid").val(datauser[0]);
  $("#editedName").val(datauser[1]);
 $("#editedEmail").val(datauser[2]);
 $("#editmod").modal('show');
 });
 
 
 $("body").on("click","#editIt",function(e){
 
     e.preventDefault();
     $.ajax({
         url:"update",
 type:'GET',
 data: {id:$("#editid").val(),
     name:$("#editedName").val(),
     OLDname: $("#OLDemail").val(),
     NEWemail: $("#editedEmail").val()},
 // data: $("form").serialize()+"&action=insert",
 success: function(resp){


 Swal.fire({
        title: '<b>'+$("#editedName").val()+'</b> updated successfully !',
        text: 'check it!',
        icon: 'success'
     } )

ListUser()
    $("#fromEditer")[0].reset();



     $("#editmod").modal('hide');
  console.log(resp);
  
 }
     });});

})