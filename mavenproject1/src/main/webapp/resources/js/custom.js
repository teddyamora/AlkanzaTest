/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function(){
    function setButtonImage(buttonObject){
        if ($(buttonObject).find('img').length) return;
        $(buttonObject).text('Cargando...');
        $.get("http://www.splashbase.co/api/v1/images/random").done(function (responseData) {
            $(buttonObject).text('');
            console.log(responseData);
            $(buttonObject).append($('<img/>', {
                src : responseData.large_url,
                style : 'width: 200px; height: 200px; margin: 5px; border-radius: 10px;'
            }));
        });
    }
    
    $('#imagesContainer').find('a').each(function(){
        setButtonImage(this);
    });
});