
$(function() {
    
    $('header .menu button').click(function(e) {
        if($(e.target).hasClass('home')) {
            location.href="index.jsp";
        }
        else if($(e.target).hasClass('social')) {
            location.href="social";
        }
        else if($(e.target).hasClass('editor')) {
            location.href="editor";
        }
    });   
    
});

function showModal() {
    
    $('#modal').fadeTo(300, 1, function() {
        $('#modal .window').fadeTo(200, 1);
    });
    $('#modal').click(function(e) {
        if ($(e.target).is('#modal') || $(e.target).is('#modal .window .close')) {
            hideModal();
        }
    });
    $(document).keyup(function(e) {
        if (e.keyCode === 27) {
            hideModal();
        }
    });
}

function hideModal() {
    $('#modal .window').fadeTo(300, 0, function() {
        $('#modal').fadeTo(200, 0, function() {
            $(this).hide();
        });
    });
}

function showInfoModal() {
    
    $('#info_modal').show();
    $('#info_modal .window').show();
}

function hideInfoModal() {
    $('#info_modal .window').hide();
    $('#info_modal').hide();
}
