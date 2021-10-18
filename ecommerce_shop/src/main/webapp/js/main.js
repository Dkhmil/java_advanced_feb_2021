$('.message a').click(function () {
    $('form').animate({
        height: "toggle",
        opacity: "toggle"
    }, "slow");
});

$(document).ready(function () {
    $("button#register").click(function () {
        let firstName = $("form.register-form input.firstName").val();
        let lastName = $("form.register-form input.lastName").val();
        let email = $("form.register-form input.email").val();
        let password = $("form.register-form input.password").val();
        let confirmPassword = $("form.register-form input.confirmPassword").val();
        if (firstName === "" || lastName === "" || email === "" || password === "" || confirmPassword === "") {
            alert("Please fill all fields!!!");
        } else if (password.length < 2) {
            alert("Password must contains more than 5 characters");
        } else if (!(password.match(confirmPassword))) {
            alert("Your passwords don`t match! Try again!")
        } else {
            let userRegistration = {
                firstName: firstName,
                lastName: lastName,
                email: email,
                password: password
            };
            $.post("registration", userRegistration, function (data) {
                if (data === "Success") {
                    $("form")[0].reset();
                }
            });
        }
    });
});


$(document).ready(function () {
    $("button#login").click(function () {
        let email = $("form.register-form input.email").val();
        let password = $("form.register-form input.password").val();

        if (email === "" || password === "") {
            alert("Please fill all fields!!!");
        } else {
            let user = {
                email: email,
                password: password
            };
            $.post("login", user, function (data) {
                if (data !== "") {
                    let finalUrl = '';
                    let url = window.location.href.split("/");
                    for (let i = 0; i < url.length - 1; i++) {
                        finalUrl += url[i] + "/";
                    }
                    finalUrl += data.destinationUrl;
                    window.location.href = finalUrl;
                }
                $("form")[1].reset();
            });
        }
    });
});





