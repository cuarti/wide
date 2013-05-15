
$(function() {

    $('#header_user_panel').click(function(e) {
        if ($(e.target).is('.sign_out')) {
            submitSignOut();
        }
        else if ($(this).hasClass('logged')) {
            alert('logeado' + '\n' + $(this).text());
        }
        else {
            showModal();
        }
    });

    $('#modal .authentication .option').click(function() {
        if (!$(this).is('.selected')) {
            $('#modal .selected').removeClass('selected');
            $(this).addClass('selected');
            if ($(this).text() === 'Sign in') {
                $('#modal .authentication .sign_up').fadeTo(300, 0).hide();
                $('#modal .authentication .sign_in').fadeTo(300, 1);
            }
            else if ($(this).text() === 'Sign up') {
                $('#modal .authentication .sign_in').fadeTo(300, 0).hide();
                $('#modal .authentication .sign_up').fadeTo(300, 1);
            }
        }
    });

    $('#modal .sign_in .submit_button').click(function() {
        submitSignIn();
    });

    $('#modal .sign_up .submit_button').click(function() {
        submitSignUp();
    });

});

function submitSignIn() {
    var username = $('#modal .sign_in input.username').val();
    var password = $('#modal .sign_in input.password').val();

    var json = {
        action: 'signIn',
        username: username,
        password: password
    };

    $.ajax({
        type: 'POST',
        url: 'authentication',
        dataType: 'json',
        data: json,
        beforeSend: function() {
            showInfoModal();
            $('#info_modal .window .content').prepend(
                    '<p>Connecting with the server...</p>' +
                    '<p>Authenticating user...</p>' +
                    '<p>Please wait!</p>');
        },
        success: function(data) {
            signIn(data);
        }
    });
}

function submitSignUp() {
    var username = $('#modal .sign_up input.username').val();
    var mail = $('#modal .sign_up input.mail').val();
    var password = $('#modal .sign_up input.password').val();
    var confirmPassword = $('#modal .sign_up input.confirmPassword').val();

    var json = {
        action: 'signUp',
        username: username,
        mail: mail,
        password: password,
        confirmPassword: confirmPassword
    };

    $.ajax({
        type: 'POST',
        url: 'authentication',
        dataType: 'json',
        data: json,
        beforeSend: function() {
            showInfoModal();
            $('#info_modal .window').html(
                    '<p>Connecting with the server...</p>' +
                    '<p>Creating user...</p>' +
                    '<p>Please wait</p>');
        },
        success: function(data) {
            signIn(data);
        }
    });
}

function submitSignOut() {

    $.ajax({
        type: 'POST',
        url: 'authentication',
        data: {action: 'signOut'},
        success: function() {
            $('#header_user_panel').html('<h4>login</h4>').removeClass('logged');
            $('header .menu button.editor').remove();
        }
    });
}

function signIn(data) {
    hideInfoModal();
    if (data.username === undefined) {
        var errors = "";
        $.each(data.errors, function(key, value) {
            errors += value;
        });
        alert(errors);
    }
    else {
        hideModal();
        $('#header_user_panel').html('<h3>' + data.username +
                '</h3><span class="sign_out" >Sign out</span>');
        $('header .menu').append('<button type="submit" class="editor" >Editor</button>');
    }
}
