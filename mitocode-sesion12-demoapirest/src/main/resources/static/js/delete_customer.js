$(document).ready(function(){
    let customerId = 0;

    $(document).on("click", "#div_customer_table table button.btn_delete", function() {
        let btn_id = (event.srcElement.id);
        customerId = btn_id.split("_")[2];

        $("div.modal-body")
            .text("¿Quieres eliminar un cliente con id = " + customerId + " ?");
        $("#model-delete-btn").css({"display": "inline"});
    });

    $(document).on("click", "#model-delete-btn", function() {
        $.ajax({
            url: '/customers/' + customerId,
            type: 'DELETE',
            success: function(response) {
                $("div.modal-body")
                    .text("Cliente eliminado con id = " + customerId + "!");

                $("#model-delete-btn").css({"display": "none"});
                $("button.btn.btn-secondary").text("Close");

                // elimina la fila del cliente en la página html
                let row_id = "tr_" + customerId;
                $("#" + row_id).remove();
                $("#div_customer_updating").css({"display": "none"});
            },
            error: function(error){
                console.log(error);
                $("#div_customer_updating").css({"display": "none"});
                alert("Error -> " + error);
            }
        });
    });
});