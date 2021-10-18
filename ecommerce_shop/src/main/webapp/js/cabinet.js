let products = null;

$.get("products", function (data) {
    if (data !== "") {
        products = data;
    }
}).done(function () {
    let cardsContent = "";
    jQuery.each(products, function (i, product) {
        cardsContent += "<div class='card'>" +
            "  <div class='card-body'>" +
            "    <h5 class='card-title'>Product name : " + product.name + "</h5>" +
            "    <h6 class='card-subtitle mb-2 text-muted'>Price" + product.price + "</h6>" +
            "    <p class='card-text'>Product description : " + product.description + "</p>" +
            "    <a href='product?id=" + product.id + "'class='card-link'>About product</a>" +
            "  </div>" +
            "</div>";
    });
    $("div#productCards").html(cardsContent);
});