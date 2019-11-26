var deleteUrl;
function deleteCompany(url, id) {

    deleteUrl = url;
    event.preventDefault();
    $('#deleteModalMessage').text('Delete Data '+ id + ' ?');
    $('#deleteModal').modal('show');

}

function getExtension(filename) {
    return filename.split('.').pop().toLowerCase();
}

function deleteCompanyData() {
    location.href = deleteUrl;
}

$(document).ready(function () {
    $(".imageFile").mnFileInput();


    $("#submitCompanyBtn").click(function (event) {
            var image = $("#logoFile");
            if(image.val()) {
                var fileName = image.val();
                var extension = getExtension(fileName);
                if (extension !="jpg" && extension != "jpeg" && extension != "png"){
                    var message = 'Please upload logo file jpg/png only ';
                    event.preventDefault();
                    $('#errorModalMessage').text(message);
                    $('#errorModal').modal('show');
                    return false;
                }
            }
        return true;
    });
});

function setIcon(element, order) {

    var iconSpan = $(element).find('div');
    if (order == "ASC" ) {
        $(iconSpan).removeClass();
        $(iconSpan).addClass('pe-7s-angle-up');
    } else {
        $(iconSpan).removeClass();
        $(iconSpan).addClass('pe-7s-angle-down');
    }
    $(element).siblings().find('div').removeClass();
    $(element).siblings().data("order", "");
    $(element).data("order", order);
}

function sortTable(element, tableId) {
    var id =  $(element).attr("id");
    var order  = $(element).data("order");

    if (order != "ASC" ) {
        order = "ASC";
    } else {
        order = "DESC";
    }

    sortColumn = id, sortOrder = order;

    $.post( url , { page: 0, column: column, searchString: search, sortColumn: id, sortOrder: order}, function(response) {
        $("#"+ tableId).html(response);
        var total =  $("#" + tableId).find('table').data("total")
        console.log(total);
        $("#pagination").pagination('updateItems', total);
        $("#pagination").pagination('drawPage', 1);
        element = $("#"+id);
        setIcon(element, sortOrder);

    });


}