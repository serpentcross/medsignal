$(document).ready(function() {

    var rootURL = window.location.host;

    loadItems(rootURL + "/shop");

    function loadItems(url) {
        $.ajax({
            dataType: "JSON",
            contentType: 'application/json',
            type: "GET",
            url: url + "/items"
        }).then(function(response) {
            if ($.isEmptyObject(response)) {
                UIkit.notify({message: 'Список товаров пуст!', status: 'info', timeout: 5000, pos: 'top-center'});
            } else {
                renderDetails(response);
            }
        });
    }

    function renderDetails(response) {
        console.log(response[0]);
    }
});