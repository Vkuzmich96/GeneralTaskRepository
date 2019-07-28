$('document').ready(function () {
    change()
});

    function change() {
        if($('#1').val()=="true"){
            $("input:checkbox").prop('checked', true)
        }else {
            $("input:checkbox").prop('checked', false)
        }
    }

