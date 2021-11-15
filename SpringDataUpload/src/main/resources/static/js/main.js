let singleFileUploadForm = document.querySelector("#singleFileUploadForm");
let singleFileUploadInput = document.querySelector("#singleFileUploadInput");
let singleFileUploadSuccess = document.querySelector("#singleFileUploadSuccess");
let singleFileUploadError = document.querySelector("#singleFileUploadError");

let multipleFileUploadForm = document.querySelector("#multipleFileUploadForm");
let multipleFileUploadInput = document.querySelector("#multipleFileUploadInput");
let multipleFileUploadSuccess = document.querySelector("#multipleFileUploadSuccess");
let multipleFileUploadError = document.querySelector("#multipleFileUploadError");


multipleFileUploadForm.addEventListener('submit', function (event) {
    let files = multipleFileUploadInput.files;
    if (files.length === 0) {
        multipleFileUploadError.innerHTML = "Please select at least one file!";
    }
    uploadMultipleFiles(files);
    event.preventDefault();
}, true);


singleFileUploadForm.addEventListener('submit', function (event) {
    let files = singleFileUploadInput.files;
    if (files.length === 0) {
        singleFileUploadError.innerHTML = "Please select 1 file!";
    }
    uploadSingleFiles(files[0]);
    event.preventDefault();
}, true);


function uploadSingleFiles(file) {
    let data = new FormData();
    data.append("file", file);

    let xhr = new XMLHttpRequest();
    xhr.open("POST", "/uploadFile");

    xhr.onload = function () {
        console.log(xhr.responseText);
        let response = JSON.parse(xhr.responseText);
        if (xhr.status === 200) {
            singleFileUploadError.style.display = "none";
            let content = "<p>File uploaded successfully.</p>" + "<p>Download uri : <a href='"
                + response.downloadUrl
                + "' target='_blank'>"
                + response.downloadUrl
                + "</a></p>";
            singleFileUploadSuccess.innerHTML = content;
        } else {
            singleFileUploadSuccess.style.display = "none";
            singleFileUploadError.innerHTML = (response && response.message)
                || "Some error occured";
        }
    };

    xhr.send(data);
}


function uploadMultipleFiles(files) {
    let data = new FormData();
    for (let i = 0; i < files.length; i++) {
        data.append("files", files[i]);
    }

    let xhr = new XMLHttpRequest();
    xhr.open("POST", "/uploadMultipleFiles");

    xhr.onload = function () {
        console.log(xhr.responseText);
        let response = JSON.parse(xhr.responseText);
        if (xhr.status === 200) {
            multipleFileUploadError.style.display = "none";
            let content = "<p>All files uploaded successfully.</p>";
            for (let i = 0; i < response.length; i++) {
                content += "<p>Download uri : <a href='"
                    + response[i].downloadUrl
                    + "' target='_blank'>"
                    + response[i].downloadUrl
                    + "</a></p>";
            }
            multipleFileUploadSuccess.innerHTML = content;
        } else {
            multipleFileUploadSuccess.style.display = "none";
            multipleFileUploadError.innerHTML = (response && response.message)
                || "Some error occured";
        }
    };

    xhr.send(data);
}