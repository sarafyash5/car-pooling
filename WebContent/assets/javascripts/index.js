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
        title: '<h2><strong>Login</strong></h2>',
        html: `<div class="input-group">
                <i class="input-group-addon fa fa-user-circle"></i>
                <input type="text" class="form-control" id="login_id" placeholder="Enter username">
            </div><br>
            <div class="input-group">
                <input type="password" class="form-control" id="password" placeholder="Enter password">
                <button id="show_hide" class="input-group-addon fa fa-eye" type="button"></button>
            </div>`,
        showCloseButton: true,
        confirmButtonColor: 'blue',
        confirmButtonText: '<i class="fa fa-thumbs-up"></i> Login'
    }).then(isConfirm => {
        if (isConfirm) {}
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
