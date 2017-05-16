function _(id) {
	return document.getElementById(id);
}

let main_body = $('#main_body')

$(document).ready(() => {
	$('#header').load('assets/html/header.html')
	$('#footer').load('assets/html/footer.html')
})

$(document).on('click', '#about_us, #contact_us, #faq, #canc_policy', function() {
	$('#external_css').remove()
	main_body.parent().parent().append('<link id="external_css" rel="stylesheet" href="assets/stylesheets/' + this.id + '.css">')
	main_body.load('assets/html/' + this.id + '.html')
})

$(document).on('click', '#brand_logo', function() {
	main_body.load('assets/html/home.html')
})

$(document).on('click', '#login', function() {
	swal({
		title: '<h2>Login</h2>',
		html: `<div class="input-group">
				<i class="input-group-addon fa fa-user-circle"></i>
				<input type="text" class="form-control" id="login_id" placeholder="Enter username">
			</div><br>
			<div class="input-group">
				<input type="password" class="form-control" id="password" placeholder="Enter password">
				<button id="show_hide" class="input-group-addon fa fa-eye" type="button"></button>
			</div>`,
		animation: false,
		customClass: 'animated bounceIn',
		showCancelButton: true,
		showLoaderOnConfirm: true,
		preConfirm: function() {
			return new Promise(function(resolve) {
				setTimeout(function() {
					resolve();
				}, 2000);
			});
		},
		allowEscapeKey: false,
		allowOutsideClick: false,
		confirmButtonClass: 'login_prompt',
		cancelButtonClass: 'login_prompt',
		confirmButtonColor: 'blue',
		cancelButtonColor: 'red',
		confirmButtonText: '<i class="fa fa-thumbs-up"></i> Submit',
		cancelButtonText: '<i class="fa fa-times"></i> Cancel'
	}).then(isConfirm => {
		if (isConfirm) {
			swal('Hi')
		}
	})
})

$(document).on('click', '#show_hide', function() {
	$(this).toggleClass('fa-eye fa-eye-slash')
	var pass = $('#password')
	if (pass.attr('type') == 'password')
		pass.attr('type', 'text')
	else
		pass.attr('type', 'password')
	pass.focus()
})

let fname = ''

var steps = [
  {
		title: '<h2>Register</h2>',
		html: `<div class="input-group">
				<i class="input-group-addon fa fa-user"></i>
				<input type="text" class="form-control" id="first_name" placeholder="Enter your First Name">
				<input type="text" class="form-control" id="last_name" placeholder="Enter your Last Name">
			</div><br>
				<div class="input-group">
				<div class="input-group-addon">+91</div>
				<input type="tel" class="form-control" id="phone_no" placeholder="Enter your Phone Number">
			</div><br>
				<div class="input-group">
				<i class="input-group-addon fa fa-envelope"></i>
				<input type="email" class="form-control" id="email_id" placeholder="Enter your Email ID">
			</div><br>
			<div class="input-group">
				<i class="input-group-addon fa fa-id-card-o"></i>
				<input type="text" class="form-control" id="license_no" placeholder="Enter your License Number">
			</div><br>
			<div class="input-group">
				<i class="input-group-addon fa fa-address-book"></i>
				<input type="text" class="form-control" id="address" placeholder="Enter your Address">
			</div><br>`,
		
		preConfirm: function() {
			fname = $('#first_name').val()
			return new Promise(function(resolve) {
					resolve();
			});
		},
		allowEscapeKey: false,
		allowOutsideClick: false,
		confirmButtonClass: 'login_prompt',
		cancelButtonClass: 'login_prompt',
		confirmButtonColor: 'blue',
		cancelButtonColor: 'red',
		confirmButtonText: '<i class="fa fa-thumbs-up"></i> Submit',
		cancelButtonText: '<i class="fa fa-times"></i> Cancel'
	},
	{

		title: '<h2>Register</h2>',
		html: `<div class="input-group">
				<i class="input-group-addon fa fa-user-circle"></i>
				<input type="text" class="form-control" id="reg_uid" placeholder="Set your Username">
			</div><br>
				<div class="input-group">
				<i class="input-group-addon fa fa-lock"></i>
				<input type="password" class="form-control" id="reg_passwd" placeholder="Set your password">
			</div>
			<br><small>*Both should be minimum 8 characters long.</small>`,
		
		preConfirm: function() {
			return new Promise(function(resolve) {
					resolve();
			});
		},
		allowEscapeKey: false,
		allowOutsideClick: false,
		confirmButtonClass: 'login_prompt',
		cancelButtonClass: 'login_prompt',
		confirmButtonColor: 'blue',
		cancelButtonColor: 'red',
		confirmButtonText: '<i class="fa fa-thumbs-up"></i> Submit',
		cancelButtonText: '<i class="fa fa-times"></i> Cancel'
	}
]

$(document).on('click', '#register', function() {

	swal.setDefaults({
	  showCancelButton: true,
	  animation: false,
	  progressSteps: ['1', '2'],
	  customClass: 'animated bounceIn',
	  showLoaderOnConfirm: true
	})

	swal.queue(steps).then(function (result) {
	  swal.resetDefaults()
	  swal({
	    title: 'Hey,' + fname,
	    showCancelButton: false,
	    showConfirmButton: false,
	    allowEscapeKey: true,
	    allowOutsideClick: true, 
	    timer:3000,
	    type: 'success'
	  })
	}, function () {
	  swal.resetDefaults()
	})	
})
