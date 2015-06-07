$("ul.nav.nav-pills li a").click(function() {
    $(this).parent().addClass('active').siblings().removeClass('active');
});

function MenuToggle(item) {
    $(document.getElementById(item)).parent().toggle("active").siblings().removeClass('active');
}

var main = function() {
    $('a').click(function() {
        $('li').toggle();
    });
};

$(document).ready(main);