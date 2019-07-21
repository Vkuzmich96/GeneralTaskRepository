$('document').ready(function () {
    sandMassage()
});

    function sandMassage() {
        $('#1').on('click', function () {
            alert('its working')
            // ajax(getValue('#newId'), getValue('#newMassage'));
        });
    }

    // function ajax(name,massage){
    //     $.ajax({
    //         type: 'GET',
    //             url: 'http://localhost:8080/forum',
    //             data: 'nick=' + name + '&massage=' + massage,
    //             success: function(data){
    //             $('#result').prepend(data)
    //         }
    //     });
    // }
    //
    // function getValue(id) {
    //     return $(id).val();
    // }
