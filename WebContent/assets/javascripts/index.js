function _(id) {
	return document.getElementById(id)
}

function showSuccessSwal(title, text) {
	swal({
		title,
		text,
		showCancelButton: false,
		showConfirmButton: false,
		allowEscapeKey: true,
		allowOutsideClick: true,
		animation: true,
		timer: 3000,
		type: 'success'
	})
}

let main_body = $('#main_body')

swal.setDefaults({
	allowEscapeKey: false,
	allowOutsideClick: false,
	showCancelButton: true,
	confirmButtonColor: 'blue',
	cancelButtonColor: 'red',
	confirmButtonClass: 'login_prompt',
	cancelButtonClass: 'login_prompt',
	animation: false,
	customClass: 'animated bounceIn',
	showLoaderOnConfirm: true
})


let regDetails = {}
let steps = [{
	title: '<h2>Register</h2>',
	html: `<small>Enter your details:</small><br><br>
			<div class="input-group">
				<i class="input-group-addon fa fa-user">&nbsp*</i>
				<input type="text" class="form-control" id="first_name" placeholder="First Name">
				<input type="text" class="form-control" id="last_name" placeholder="Last Name">
			</div><br>
			<div class="input-group">
				<div class="input-group-addon fa fa-phone">&nbsp*</div>
				<div class="input-group-addon">+91</div>
				<input type="number" class="form-control" id="phone_no" placeholder="Phone Number">
			</div><br>
			<div class="input-group">
				<i class="input-group-addon fa fa-envelope">&nbsp*</i>
				<input type="text" class="form-control" id="email_id" placeholder="Email ID">
			</div><br>
			<div class="input-group">
				<i class="input-group-addon fa fa-id-card-o"></i>
				<input type="text" class="form-control" id="license_no" placeholder="License Number">
			</div><br>
			<div class="input-group">
				<i class="input-group-addon fa fa-address-book"></i>
				<textarea class="form-control" id="address" placeholder="Address"></textarea>
			</div><br>
			<small><strong>Note: </strong> Fields marked with <i class="fa fa-asterisk"></i> are mandatory.</small><br><br>`,

	preConfirm: () => {
		regDetails = {
			fname: $('#first_name').val(),
			lname: $('#last_name').val(),
			phone: $('#phone_no').val(),
			email: $('#email_id').val(),
			license: $('#license_no').val(),
			address: $('#address').val()
		};
		return new Promise((resolve, reject) => {
			$.post('ValidateServlet', regDetails, data => {
				if (data[0] == 'ERROR') reject(data[1])
				else resolve()
			})
		})
	},
	progressSteps: ['1', '2'],
	confirmButtonText: '<i class="fa fa-thumbs-up"></i> Submit',
	cancelButtonText: '<i class="fa fa-times"></i> Cancel'
}, {
	title: '<h2>Register</h2>',
	html: `<small>Set your login credentials:</small><br><br>
			<div class="input-group">
				<i class="input-group-addon fa fa-user-circle"></i>
				<input type="text" class="form-control" id="reg_uid" placeholder="User Name">
			</div><br>
				<div class="input-group">
				<i class="input-group-addon fa fa-lock"></i>
				<input type="password" class="form-control" id="reg_passwd" placeholder="Password">
			</div>
			<br><small>*Both should be minimum 8 characters long.</small><br><br>`,

	preConfirm: () => {
		return new Promise((resolve, reject) => {
			let loginDetails = {
				login_id: $('#reg_uid').val(),
				passwd: $('#reg_passwd').val()
			}
			$.post('ValidateServlet', loginDetails, data => {
				if (data[0] == 'ERROR') reject(data[1])
				else {
					$.extend(regDetails, loginDetails)
					$.post('RegisterServlet', regDetails, data => {
						if (data[0] == 'ERROR') reject(data[1])
						else resolve()
					})
				}
			})
		})
	},
	progressSteps: ['1', '2'],
	confirmButtonText: '<i class="fa fa-thumbs-up"></i> Submit',
	cancelButtonText: '<i class="fa fa-times"></i> Cancel'
}]

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
		html: `<small>Enter your login credentials:</small><br><br>
				<div class="input-group">
				<i class="input-group-addon fa fa-user-circle"></i>
				<input type="text" class="form-control" id="login_uid" placeholder="User Name">
			</div><br>
			<div class="input-group">
				<i class="input-group-addon fa fa-lock"></i>
				<input type="password" class="form-control" id="login_passwd" placeholder="Password">	
				<button id="show_hide" class="input-group-addon fa fa-eye" type="button"></button>
			</div><br>
			<div class="form-group">
				<div class="form-check">
				<label class="form-check-label">
					<input id="role" class="form-check-input" type="checkbox"> <ins>Login as an employee</ins>
				</label>
				</div>
			</div>`,
		preConfirm: () => {
			return new Promise((resolve, reject) => {
				let role = _('role').checked ? 'employee' : 'customer'
				$.post('LoginServlet', {
					login_id: $('#login_uid').val(),
					passwd: $('#login_passwd').val(),
					role
				}, data => {
					if (data[0] == 'ERROR') reject(data[1])
					else resolve()
				})
			})
		},
		confirmButtonText: '<i class="fa fa-thumbs-up"></i> Submit',
		cancelButtonText: '<i class="fa fa-times"></i> Cancel'
	}).then(() => {
		showSuccessSwal('', 'You have successfully logged in!')
	}).catch(() => {})
})

$(document).on('click', '#register', function() {
	swal.queue(steps).then(() => {
		showSuccessSwal('Hey, ' + regDetails.fname, 'You have successfully signed up!')
	}).catch(() => {})
})

$(document).on('click', '#show_hide', function() {
	$(this).toggleClass('fa-eye fa-eye-slash')
	var pass = $('#login_passwd')
	if (pass.attr('type') == 'password')
		pass.attr('type', 'text')
	else
		pass.attr('type', 'password')
	pass.focus()
})