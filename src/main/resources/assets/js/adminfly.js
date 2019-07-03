(function () {

    $('.navbar-nav .nav-link').each(function () {
        let link = $(this);
        let href = link.attr('href');
        let current = location.pathname;

        if (href !== undefined) {
            if (href.split('/')[1] === current.split('/')[1]) {
                link.addClass('active');
            }
        }
    });

    ClassicEditor.create(document.querySelector('.editor'), {
        language: window.localeName
    }).then(editor => {
        window.editor = editor;
    }).catch(error => {
        console.error(error.stack);
    });

})();