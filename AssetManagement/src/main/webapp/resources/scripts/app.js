/**
 * Created by Adrian on 01-Aug-14.
 */
$(function() {
    var $info = $('#info'),
        startInfo=$info.html();
    $info.on('click','#button1', function () {
        $.ajax({
            type: 'GET',
            url: 'views/ajax/Login.jsp',
            data:'',
            success: function(data){
                $info.fadeOut('fast', function () {
                    $info.html(data);
                });
                $info.fadeIn('fast')
            }
        });
    });
    $info.on('click','#back', function(){
        $info.fadeOut('fast',function(){
            $info.html(startInfo);
        })
        $info.fadeIn('fast');
    });
})
