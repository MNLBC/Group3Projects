<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <script src="js/jquery-1-10-2-min.js"></script>
 <script src="js/bootstrap-min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
<title>Kanen Online Shopping</title>

<link rel="stylesheet" href="css/demo.css">
<link rel="stylesheet" href="css/main.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.css">
<link media="all" type="text/css" rel="stylesheet" href="css/style.css">
<script src="js/jquery-min.js"></script>
<script src="js/bootstrap-min.js"></script>
<style>
.carousel-inner>.item>img, .carousel-inner>.item>a>img {
width: 70%;
margin: auto;
}
</style>

</head>
<body>

	<header class="header-login-signup">


	<div class="header-limiter">




		<nav> 
            <a href="#">Products</a>
            <!-- Aica JayBee Merge-->
            <a href="Cart_Modal.jsp" class="selected" data-toggle="modal" data-target="#cartModal">View Cart</a>
            <!-- Aica JayBee Merge-->
           </nav>

		  <ul>
            <!-- Aica JayBee Merge-->
			<a href="Login_Modal.jsp" class="logout-button" class="selected" data-toggle="modal" data-target="#loginModal">Login</a>
            <a href="Register_Modal.jsp" class="logout-button" class="selected" data-toggle="modal" data-target="#registerModal">Sign up</a>
            <!-- Aica JayBee Merge-->
		<!--  	<a href="#" class="logout-button">Logout</a>-->
		</ul>


		<center>
			<h1>
				<img src="resources/cart.png" style="width: 58px; height: 47px;"><a
					href="#">    Kanen<span>Online Shopping</span>
					
			</a><hr width="700" align="center" color="white" style="width: 778px; "></h1>
	



		</center>


	</div>


	</header>
</br>

	<div class="slider">
		<div class="container">
			<div id="main-carousel" class="carousel slide" data-ride="carousel">
				<div class="carousel-inner">
					<div class="item active">
						<img src="resources/image1.PNG" alt="Slider"
							class="img-responsive">
					</div>
					<div class="item">
						<img src="resources/image2.PNG" alt="Slider"
							class="img-responsive">
					</div>
					<div class="item">
						<img src="resources/image3.PNG" alt="Slider"
							class="img-responsive">
					</div>
					<div class="item">
						<img src="resources/image4.PNG" alt="Slider"
							class="img-responsive">
					</div>
					<div class="item">
						<img src="resources/image5.PNG" alt="Slider"
							class="img-responsive">
					</div>
				</div>
				<a class="left carousel-control" href="#main-carousel" role="button"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left"></span>
				</a> <a class="right carousel-control" href="#main-carousel"
					role="button" data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right"></span>
				</a>
			</div>
		</div>
	</div>




	
</br>
	
	<div class="container" style="margin-top:50px;">
	<div class="row">

    	<div class="col-xs-12 col-sm-6 col-md-3">
            <div class="col-item">
                <div class="post-img-content">
                    <img src="resources/macbook.jpg" class="img-responsive" />
                    <span class="post-title">
                      
                    </span>
                   
                </div>
                <div class="info">
                    <div class="row">
                        <div class="price col-md-6">
                            <h5> MackBook Pro</h5>
                            <h5 class="price-text-color">$1,700.00</h5>
                        </div>
                        <div class="rating hidden-sm col-md-6">
          
                        </div>
                    </div>
                    <div class="separator clear-left">
                        <p class="btn-add">
                            <i class="fa fa-shopping-cart"></i><a href="#" class="hidden-sm">Add to cart</a></p>
                        <p class="btn-details">
                            <i class="fa fa-list"></i><a href="#" class="hidden-sm">More details</a></p>
                    </div>
                    <div class="clearfix">
                    </div>
                </div>
            </div>
        </div>
            
        <div class="col-xs-12 col-sm-6 col-md-3">
            <div class="col-item">
                <div class="post-img-content">
                    <img src="resources/laptop.png" class="img-responsive" alt="a" />
                    <span class="post-title">
                        
                    </span>
                    
                </div>
                <div class="info">
                    <div class="row">
                        <div class="price col-md-6">
                            <h5> Sample Product</h5>
                            <h5 class="price-text-color">$199.99</h5>
                        </div>
                        <div class="rating hidden-sm col-md-6">
                            <i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                            </i><i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                            </i><i class="fa fa-star"></i>
                        </div>
                    </div>
                    <div class="separator clear-left">
                        <p class="btn-add">
                            <i class="fa fa-shopping-cart"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">Add to cart</a></p>
                        <p class="btn-details">
                            <i class="fa fa-list"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">More details</a></p>
                    </div>
                    <div class="clearfix">
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-3">
            <div class="col-item">
                <div class="photo">
                    <img src="resources/laptop2.jpg" class="img-responsive" alt="a" />
                </div>
                <div class="info">
                    <div class="row">
                        <div class="price col-md-6">
                            <h5> Sample Product</h5>
                            <h5 class="price-text-color">$199.99</h5>
                        </div>
                        <div class="rating hidden-sm col-md-6">
                            <i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                            </i><i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                            </i><i class="fa fa-star"></i>
                        </div>
                    </div>
                    <div class="separator clear-left">
                        <p class="btn-add">
                            <i class="fa fa-shopping-cart"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">Add to cart</a></p>
                        <p class="btn-details">
                            <i class="fa fa-list"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">More details</a></p>
                    </div>
                    <div class="clearfix">
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-3">
            <div class="col-item">
                <div class="photo">
                    <img src="resources/laptop3.jpg" class="img-responsive" alt="a" />
                </div>
                <div class="info">
                    <div class="row">
                        <div class="price col-md-6">
                            <h5> Sample Product</h5>
                            <h5 class="price-text-color">$199.99</h5>
                        </div>
                        <div class="rating hidden-sm col-md-6">
                            <i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                            </i><i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                            </i><i class="fa fa-star"></i>
                        </div>
                    </div>
                    <div class="separator clear-left">
                        <p class="btn-add">
                            <i class="fa fa-shopping-cart"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">Add to cart</a></p>
                        <p class="btn-details">
                            <i class="fa fa-list"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">More details</a></p>
                    </div>
                    <div class="clearfix">
                    </div>
                </div>
            </div>
        </div>
		
		
	</div>
</div><div class="container" style="margin-top:50px;">
	<div class="row">

    	<div class="col-xs-12 col-sm-6 col-md-3">
            <div class="col-item">
                <div class="post-img-content">
                    <img src="resources/phone.jpg" class="img-responsive" />
                    <span class="post-title">
                      
                    </span>
                   
                </div>
                <div class="info">
                    <div class="row">
                        <div class="price col-md-6">
                            <h5> Sample Product</h5>
                            <h5 class="price-text-color">$100</h5>
                        </div>
                        <div class="rating hidden-sm col-md-6">
                            <h5 class="price-text-color">$100</h5>
                        </div>
                    </div>
                    <div class="separator clear-left">
                        <p class="btn-add">
                            <i class="fa fa-shopping-cart"></i><a href="#" class="hidden-sm">Add to cart</a></p>
                        <p class="btn-details">
                            <i class="fa fa-list"></i><a href="#" class="hidden-sm">More details</a></p>
                    </div>
                    <div class="clearfix">
                    </div>
                </div>
            </div>
        </div>
            
        <div class="col-xs-12 col-sm-6 col-md-3">
            <div class="col-item">
                <div class="post-img-content">
                    <img src="resources/phone2.jpg" class="img-responsive" alt="a" />
                    <span class="post-title">
                        
                    </span>
                    
                </div>
                <div class="info">
                    <div class="row">
                        <div class="price col-md-6">
                            <h5> Sample Product</h5>
                            <h5 class="price-text-color">$199.99</h5>
                        </div>
                        <div class="rating hidden-sm col-md-6">
                            <i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                            </i><i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                            </i><i class="fa fa-star"></i>
                        </div>
                    </div>
                    <div class="separator clear-left">
                        <p class="btn-add">
                            <i class="fa fa-shopping-cart"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">Add to cart</a></p>
                        <p class="btn-details">
                            <i class="fa fa-list"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">More details</a></p>
                    </div>
                    <div class="clearfix">
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-3">
            <div class="col-item">
                <div class="photo">
                    <img src="resources/phone3.png" class="img-responsive" alt="a" />
                </div>
                <div class="info">
                    <div class="row">
                        <div class="price col-md-6">
                            <h5> Sample Product</h5>
                            <h5 class="price-text-color">$199.99</h5>
                        </div>
                        <div class="rating hidden-sm col-md-6">
                            <i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                            </i><i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                            </i><i class="fa fa-star"></i>
                        </div>
                    </div>
                    <div class="separator clear-left">
                        <p class="btn-add">
                            <i class="fa fa-shopping-cart"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">Add to cart</a></p>
                        <p class="btn-details">
                            <i class="fa fa-list"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">More details</a></p>
                    </div>
                    <div class="clearfix">
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-3">
            <div class="col-item">
                <div class="photo">
                    <img src="resources/phone4.jpg" class="img-responsive" alt="a" />
                </div>
                <div class="info">
                    <div class="row">
                        <div class="price col-md-6">
                            <h5> Sample Product</h5>
                            <h5 class="price-text-color">$199.99</h5>
                        </div>
                        <div class="rating hidden-sm col-md-6">
                            <i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                            </i><i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                            </i><i class="fa fa-star"></i>
                        </div>
                    </div>
                    <div class="separator clear-left">
                        <p class="btn-add">
                            <i class="fa fa-shopping-cart"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">Add to cart</a></p>
                        <p class="btn-details">
                            <i class="fa fa-list"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">More details</a></p>
                    </div>
                    <div class="clearfix">
                    </div>
                </div>
            </div>
        </div>
		
		
	</div>
	
	
	
	
		<div class="row">

    	<div class="col-xs-12 col-sm-6 col-md-3">
            <div class="col-item">
                <div class="post-img-content">
                    <img src="resources/acc.jpg" class="img-responsive" />
                    <span class="post-title">
                      
                    </span>
                   
                </div>
                <div class="info">
                    <div class="row">
                        <div class="price col-md-6">
                            <h5> MackBook Pro</h5>
                            <h5 class="price-text-color">$1,700.00</h5>
                        </div>
                        <div class="rating hidden-sm col-md-6">
          
                        </div>
                    </div>
                    <div class="separator clear-left">
                        <p class="btn-add">
                            <i class="fa fa-shopping-cart"></i><a href="#" class="hidden-sm">Add to cart</a></p>
                        <p class="btn-details">
                            <i class="fa fa-list"></i><a href="#" class="hidden-sm">More details</a></p>
                    </div>
                    <div class="clearfix">
                    </div>
                </div>
            </div>
        </div>
            
        <div class="col-xs-12 col-sm-6 col-md-3">
            <div class="col-item">
                <div class="post-img-content">
                    <img src="resources/acc3.jpg" class="img-responsive" alt="a" />
                    <span class="post-title">
                        
                    </span>
                    
                </div>
                <div class="info">
                    <div class="row">
                        <div class="price col-md-6">
                            <h5> Sample Product</h5>
                            <h5 class="price-text-color">$199.99</h5>
                        </div>
                        <div class="rating hidden-sm col-md-6">
                            <i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                            </i><i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                            </i><i class="fa fa-star"></i>
                        </div>
                    </div>
                    <div class="separator clear-left">
                        <p class="btn-add">
                            <i class="fa fa-shopping-cart"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">Add to cart</a></p>
                        <p class="btn-details">
                            <i class="fa fa-list"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">More details</a></p>
                    </div>
                    <div class="clearfix">
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-3">
            <div class="col-item">
                <div class="photo">
                    <img src="resources/acc2.jpg" class="img-responsive" alt="a" />
                </div>
                <div class="info">
                    <div class="row">
                        <div class="price col-md-6">
                            <h5> Sample Product</h5>
                            <h5 class="price-text-color">$199.99</h5>
                        </div>
                        <div class="rating hidden-sm col-md-6">
                            <i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                            </i><i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                            </i><i class="fa fa-star"></i>
                        </div>
                    </div>
                    <div class="separator clear-left">
                        <p class="btn-add">
                            <i class="fa fa-shopping-cart"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">Add to cart</a></p>
                        <p class="btn-details">
                            <i class="fa fa-list"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">More details</a></p>
                    </div>
                    <div class="clearfix">
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-3">
            <div class="col-item">
                <div class="photo">
                    <img src="resources/acc5.jpg" class="img-responsive" alt="a" />
                </div>
                <div class="info">
                    <div class="row">
                        <div class="price col-md-6">
                            <h5> Sample Product</h5>
                            <h5 class="price-text-color">$199.99</h5>
                        </div>
                        <div class="rating hidden-sm col-md-6">
                            <i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                            </i><i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                            </i><i class="fa fa-star"></i>
                        </div>
                    </div>
                    <div class="separator clear-left">
                        <p class="btn-add">
                            <i class="fa fa-shopping-cart"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">Add to cart</a></p>
                        <p class="btn-details">
                            <i class="fa fa-list"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">More details</a></p>
                    </div>
                    <div class="clearfix">
                    </div>
                </div>
            </div>
        </div>
		
		
	</div>
</div>

<!-- Aica JayBee Merge-->
<div class="modal fade" id="cartModal" role="dialog">
    <div class="modal-dialog">
      <div class="modal-content">
      </div>
    </div>
</div>

<div class="modal fade" id="loginModal" role="dialog">
    <div class="modal-login">
      <div class="modal-content">
      </div>
    </div>
</div>

<div class="modal fade" id="registerModal" role="dialog">
    <div class="modal-registration">
      <div class="modal-content">
      </div>
    </div>
</div>
<!-- Aica JayBee Merge-->


</body>

</html>