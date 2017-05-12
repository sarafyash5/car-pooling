function _(id) {
    return document.getElementById(id);
}

$(document).ready(() => {
    $('#header').load('assets/html/header.html')
    $('#footer').load('assets/html/footer.html')
})

$(document).on('click', '#about_us, #contact_us, #faq, #canc_policy', function() {
	var main_body = $('#main_body')
	$('#external_css').remove()
	main_body.parent().parent().append('<link id="external_css" rel="stylesheet" href="assets/stylesheets/' + this.id + '.css">')
    main_body.load('assets/html/' + this.id + '.html')
})
