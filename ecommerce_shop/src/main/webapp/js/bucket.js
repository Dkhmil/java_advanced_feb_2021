let products = null;

$.get("bucketInfo", function (data) {
    if (data !== "") {
        products = data;
    }
}).done(function () {
    let tableContent;
    if (products.length === 0) {
        tableContent = "<h2>Your bucket is empty!</h2>";
    } else {
        tableContent = "<tr class='header'>" +
            "    <th style='width:20%;'>Name</th>" +
            "    <th style='width:30%;'>Description</th>" +
            "    <th style='width:20%;'>Price</th>" +
            "    <th style='width:10%;'>Count</th>" +
            "    <th style='width:10%;'>Add/Remove</th>" +
            "    <th style='width:10%;'></th>" +
            "  </tr>";

        jQuery.each(products, function (i, product) {
            tableContent += "<tr>" +
                "<td>" + product.name + "</td>" +
                "<td>" + product.description + "</td>" +
                "<td>" + product.price + "</td>" +
                "<td>" + product.productCount + "</td>" +
                "<td><button><img src='/image/plus.svg' onclick='addOneProduct(" + product.id + ")'></button>" +
                "<button><img src='/image/minus.svg' onclick='removeOneProduct(" + product.id + ")'></button></td>" +
                "<td><button onclick='deleteProductsFromBucket(" + product.id + ")'>Delete</button></td>" +
                "</tr>";
        });
    }
    $("table#bucketTable").html(tableContent);
});

function addOneProduct(productId) {
    let object = {'productId': productId};
    $.post("bucketInfo", object);
    document.location.reload();
}

function removeOneProduct(productId) {
    remove(productId, false)
}

function deleteProductsFromBucket(productId) {
    remove(productId, true)
}

function remove(productId, all) {
    let finalUrl = "";
    let url = window.location.href.split("/");
    for (let i = 0; i < url.length - 1; i++) {
        finalUrl += url[i] + "/";
    }
    finalUrl += "bucketInfo?productId=" + productId + "&all=" + all;

    $.ajax({
        url: finalUrl,
        type: 'DELETE',
        success: function (data) {
            if (data === "Success") {
                location.reload();
            }
        }
    });
}

function searchFunction() {
    let input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    table = document.getElementById("bucketTable");
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[0];
        if (td) {
            txtValue = td.textContent || td.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}