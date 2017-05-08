function _(id) {
    return document.getElementById(id);
}

$(document).ready(() => {
    $('#header').load('assets/html/header.html')
    $('#footer').load('assets/html/footer.html')
})

$(document).on('click', '#about_us, #contact_us', function() {
    $('#body').load('assets/html/' + this.id + '.html')
})
