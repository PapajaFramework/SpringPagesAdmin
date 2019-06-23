(function(){

    $('.navbar-nav .nav-link').each(function () {
        if (this.getAttribute('href').split('/')[1] == location.pathname.split('/')[1]) {
            $(this).addClass('active');
        }
    });

})();