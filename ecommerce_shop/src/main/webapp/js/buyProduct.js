$("button#buy").click(function () {
    let productId = jQuery(this).attr("product-id");
    let object = {'productId': productId};

    $.post("bucketInfo", object, function (data) {
        if (data === "Success") {
            alert("Product was added to bucket!");
        }
    });
});