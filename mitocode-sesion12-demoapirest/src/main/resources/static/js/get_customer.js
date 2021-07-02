$(document).ready(function(){
	let pathname = window.location.pathname;
        console.log(pathname);
    (function(){
        $.ajax({
            type : "GET",
            url : "/customers",
            success: function(response){
              $.each(response.customers, (i, customer) => {  

       
                
				let deleteButton=`<button id='btn_delete' ${customer.id} type='button' 
							class='btn btn-danger btn_delete' data-toggle='modal' data-target='#delete-modal' 
							>&times</button>`;
							
				let get_More_Info_Btn=`<button id='btn_id_${customer.id}' type='button' class='btn btn-info btn_id'>
										${customer.id}
								</button>`

                
                
                let tr_id = 'tr_' + customer.id;
                
                let customerRow = '<tr id=\"' + tr_id + "\"" + '>' +
                          '<td>' + get_More_Info_Btn + '</td>' +
                          '<td class=\"td_first_name\">' + customer.firstname.toUpperCase() + '</td>' +
                          '<td class=\"td_address\">' + customer.address + '</td>' +
                          '<td>' + deleteButton + '</td>' +
                          '</tr>';     
                                     
                $('#customerTable tbody').append(customerRow);
              });
            },
            error : function(e) {
              alert("ERROR: ", e);
              console.log("ERROR: ", e);
            }
        });
    })();        
    
    /*(function(){
        let pathname = window.location.pathname;
        if (pathname == "/customers.html") {
            $(".nav .nav-item a:last").addClass("active");
        }
    })();*/
});