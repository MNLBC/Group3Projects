<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"> -->



  <!-- <link rel="stylesheet" type="text/css" href="bootstrap-3.3.6-dist\css\bootsrap.css"> -->
<!--   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> -->

</head>
<body onload="Popup()">

        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Modal Header</h4>
        </div>
        <div class="modal-body">
                                  


<div class="container-fluid">
  <div class="row">
    <div class="col-xs-12">
      <div class="panel panel-info">
        <div class="panel-heading">
          <div class="panel-title">
            <div class="row">
              <div class="col-xs-6">
                <h5><span class="glyphicon glyphicon-shopping-cart"></span> Shopping Cart</h5>
              </div>
              <div class="col-xs-6">
                <button type="button" class="btn btn-primary btn-sm btn-block">
                  <span class="glyphicon glyphicon-share-alt"></span> Continue shopping
                </button>
              </div>
            </div>
          </div>
        </div>
        <div class="panel-body" >
        <div id="divBodyCartModal">
          <div class="row">
            <div class="col-xs-2"><img class="img-responsive" src="http://placehold.it/100x70">
            </div>
            <div class="col-xs-4">
              <h4 class="product-name"><strong>Product name</strong></h4><h4><small>Product description</small></h4>
            </div>
            <div class="col-xs-6">
              <div class="col-xs-6 text-right">
                <h6><strong><label id = "lblCartItemPrice1">25.00</label> <span class="text-muted">x</span></strong></h6>
              </div>
              <div class="col-xs-4">
                <input type="text" class="form-control input-sm" value="1" id="txtCartItem1">
              </div>
              <div class="col-xs-2">
                <button type="button" class="btn btn-link btn-xs">
                  <span class="glyphicon glyphicon-trash"> </span>
                </button>
              </div>
            </div>
          </div>
          <hr>
          <div class="row">
            <div class="col-xs-2"><img class="img-responsive" src="http://placehold.it/100x70">
            </div>
            <div class="col-xs-4">
              <h4 class="product-name"><strong>Product name</strong></h4><h4><small>Product description</small></h4>
            </div>
            <div class="col-xs-6">
              <div class="col-xs-6 text-right">
                <h6><strong><label id = "lblCartItemPrice2">50.00</label><span class="text-muted">x</span></strong></h6>
              </div>
              <div class="col-xs-4">
                <input type="text" class="form-control input-sm" value="1" id="txtCartItem2">
              </div>
              <div class="col-xs-2">
                <button type="button" class="btn btn-link btn-xs">
                  <span class="glyphicon glyphicon-trash"> </span>
                </button>
              </div>
            </div>
          </div>
          <hr>
          <div class="row">
            <div class="col-xs-2"><img class="img-responsive" src="http://placehold.it/100x70">
            </div>
            <div class="col-xs-4">
              <h4 class="product-name"><strong>Product name</strong></h4><h4><small>Product description</small></h4>
            </div>
            <div class="col-xs-6">
              <div class="col-xs-6 text-right">
                <h6><strong><label id = "lblCartItemPrice3">100.00</label><span class="text-muted">x</span></strong></h6>
              </div>
              <div class="col-xs-4">
                <input type="text" class="form-control input-sm" value="1" id="txtCartItem3">
              </div>
              <div class="col-xs-2">
                <button type="button" class="btn btn-link btn-xs">
                  <span class="glyphicon glyphicon-trash"> </span>
                </button>
              </div>
            </div>
          </div>
          <hr>
          </div>
          <div class="row">
            <div class="text-center">
              <div class="col-xs-9">
                <h6 class="text-right">Added items?</h6>
              </div>
              <div class="col-xs-3">
                <button type="button" class="btn btn-default btn-sm btn-block" onclick="myFunction()">
                  Update cart
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
        </div>
          <div class="panel-footer">
          <div class="row text-center">

            <div class="col-xs-7">
              <h4 class="text-right">Total <strong>$50.00</strong></h4>
            </div>

            <div class="col-xs-3">
              <button type="button" class="btn btn-success btn-block">Checkout</button>
              </div>

               <div class="col-xs-2"> 
              <button id="btnRegisterCancel" name="btnRegisterCancel" class="btn btn-danger btn-block" data-dismiss="modal">Cancel</button>
              </div>   

          </div>
        </div>
        </div>
      
</body>




<script type="text/javascript">
  

function updateCart(){
  
  var cartItem1 = parseInt(document.getElementById('txtCartItem1').value);
  var cartItem2 = parseInt(document.getElementById('txtCartItem2').value);
  var cartItem3 = parseInt(document.getElementById('txtCartItem3').value);
  var cartPrice1 = parseInt(document.getElementById('lblCartItemPrice1').innerHTML);
  var cartPrice2 = parseInt(document.getElementById('lblCartItemPrice2').innerHTML);
  var cartPrice3 = parseInt(document.getElementById('lblCartItemPrice3').innerHTML);

  var totalCost = (cartItem1 * cartPrice1)  + (cartItem2 * cartPrice2 )+ (cartItem3 * cartPrice3);

  alert(totalCost);

}
  function myFunction() {



    var Test = document.getElementById('divBodyCartModal').innerHTML;

      document.getElementById('divBodyCartModal').innerHTML=Test+'<div class="row">'
            +'<div class="col-xs-2"><img class="img-responsive" src="http://placehold.it/100x70">'
            +'</div>'
            +'<div class="col-xs-4">'
            +  '<h4 class="product-name"><strong>Product name</strong></h4><h4><small>Product description</small></h4>'
            +'</div>'
            +'<div class="col-xs-6">'
            +  '<div class="col-xs-6 text-right">'
            +    '<h6><strong><label id = "lblCartItemPrice1">25.00</label> <span class="text-muted">x</span></strong></h6>'
            +  '</div>'
            +  '<div class="col-xs-4">'
            +    '<input type="text" class="form-control input-sm" value="1" id="txtCartItem1">'
            +  '</div>'
            +  '<div class="col-xs-2">'
            +    '<button type="button" class="btn btn-link btn-xs">'
            +      '<span class="glyphicon glyphicon-trash"> </span>'
            +    '</button>'
            +  '</div>'
            + '</div>'
            +'</div>'
            +'<hr>';




}


</script>





</script>

</html>