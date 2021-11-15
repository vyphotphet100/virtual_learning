var input = document.getElementById( 'upload' );
function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#avatar')
                .attr('src', e.target.result);
            $('#avatarInput').val(e.target.result);
        };
        reader.readAsDataURL(input.files[0]);
    }
}

// input.addEventListener( 'change', showFileName );
// function showFileName( event ) {
//     var input = event.srcElement;
//     var fileName = input.files[0].name;
// }