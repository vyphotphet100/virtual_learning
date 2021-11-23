// Get the modal
var modal = document.getElementById("myModal");


// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal
function openModal(classId) {
    document.getElementById("class-to-join").value = classId;
    document.getElementById("password").value = '';
    modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

function joinClass() {
    var classId = document.getElementById("class-to-join").value;
    var password = document.getElementById("password").value;
    window.location.href = '/student/class/join?classId=' + classId + '&password=' + password;
}