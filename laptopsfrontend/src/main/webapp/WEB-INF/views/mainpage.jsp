<%@include file="Header.jsp" %>


 <style>
.carousel-inner > .item > img,
.carousel-inner > .item > a > img {
/*  width:70%; */
 margin:auto;
 /* height:150%; */
}
body{
background-image:background-image:url('images/2.jpg');}
/* .carousel-inner {
height:150%;} */
</style> 

<div class="container">
<h2>Laptops</h2>
<div id="myCarousel" class="carousel slide" data-ride="carousel">
<ol class="carousel-indicators">
<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
<li data-target="#myCarousel" data-slide-to="1" ></li>
<li data-target="#myCarousel" data-slide-to="2" ></li>
<li data-target="#myCarousel" data-slide-to="3" ></li>
<li data-target="#myCarousel" data-slide-to="4" ></li>
</ol>
<div class="carousel-inner" role="listbox" style="width:100%; height:300px !important;">
<div class="item active">
<img src="images/1.png" alt="bmw" ><!-- width="460px" height="300px" -->
<!-- <img src="images/touch.jpg" alt="PIC" width="460" height="300"> -->
<div class="carousel-caption">
<h3>1</h3></div></div>



<div class="item">
<img src="images/2.jpg" alt="LOGO" width="460px" height="300px"> 
<div class="carousel-caption">
<h3>2</h3></div></div>

<div class="item">
<img src="images/3.jpg" alt="PIC" width="460px" height="300px"> 
<div class="carousel-caption">
<h3>3</h3></div></div>

<div class="item">
<img src="images/4.jpg" alt="PIC"  width="460px" height="300px">
<div class="carousel-caption">
<h3>4</h3></div></div>

<div class="item">
<img src="images/5.jpg" alt="PIC" ><!--  width="460px" height="300px"> -->
<div class="carousel-caption">
<h3>5</h3></div></div>
</div>

<a class="left carousel-control" href="#myCarousel" data-slide="prev">
 <span class="glyphicon glyphicon-chevron-left"></span> 
<span class="sr-only">Previous</span></a>
<a class="right carousel-control" href="#myCarousel" data-slide="next">
 <span class="glyphicon glyphicon-chevron-right"></span>
<span class="sr-only">Next</span></a>

</div></div>
<%@include file="Footer.jsp"%>