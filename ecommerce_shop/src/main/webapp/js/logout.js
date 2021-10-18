$(document).ready(function () {
    $("button#logout").click(function () {
        $.get("logout", function (data) {
            if (data !== "") {
                let finalUrl = "";
                let url = window.location.href.split("/");
                for (let i = 0; i < url.length - 1; i++) {
                    finalUrl += url[i] + "/";
                }
                finalUrl += data;
                window.location.href = finalUrl;
            }
        });
    });
});