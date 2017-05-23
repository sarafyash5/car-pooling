<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Car pooling</title>

<link rel="stylesheet" href="assets/stylesheets/bootstrap.min.css">
<link rel="stylesheet" href="assets/stylesheets/animate.min.css">
<link rel="stylesheet"
	href="assets/fonts/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="assets/stylesheets/main.css">
<link rel="stylesheet" href="assets/stylesheets/sweetalert2.min.css">

<div class="container-fluid">
	<div id="header">
		<!-- HEADER -->
	</div>
	<div id="main_body" class="container">
		<!-- BODY -->
		<div id="carouselExampleSlidesOnly" class="carousel slide"
			data-ride="carousel" data-interval="1000">
			<div class="carousel-inner" role="listbox">
				<div class="carousel-item active">
					<img class="d-block img-fluid" src="..." alt="First slide">
				</div>
				<div class="carousel-item">
					<img class="d-block img-fluid" src="..." alt="Second slide">
				</div>
				<div class="carousel-item">
					<img class="d-block img-fluid" src="..." alt="Third slide">
				</div>
			</div>
		</div>
	</div>
	<div id="footer">
		<!-- FOOTER -->
	</div>
</div>

<script src="assets/javascripts/jquery-3.2.1.min.js"></script>
<script src="assets/javascripts/tether.min.js"></script>
<script src="assets/javascripts/bootstrap.min.js"></script>
<script src="assets/javascripts/sweetalert2.min.js"></script>
<script src="assets/javascripts/index.js"></script>

<!-- Initialize Bootstrap functionality -->
<script>
	// Initialize tooltip component
	$(function() {
		$('[data-toggle="tooltip"]').tooltip()
	})

	// Initialize popover component
	$(function() {
		$('[data-toggle="popover"]').popover()
	})
</script>
