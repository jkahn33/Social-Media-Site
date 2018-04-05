var sendData;

function registerUser(){
    $.ajax({
        url: '/login/registerUser',
        type: 'GET',
        async: false
    });
}

// function registerUser(){
//     sendData = {
//         first: $('#iFirst').val(),
//         last: $('#iLast').val(),
//         email: $('#iEmail').val()
//     };
//     $.ajax({
//         url: '/login/registerUser/',
//         type: "POST",
//         contentType: "application/json",
//         dataType: "json",
//         processData: false,
//         data: JSON.stringify(sendData),
//         async: true,
//         success: function (data) {
//             console.log("SUCCESS");
//         }
//     });
//
// }