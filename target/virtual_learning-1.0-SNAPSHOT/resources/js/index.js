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

function classDetail(classId) {
    var classResult = $.ajax({
        type: "GET",
        url: "/class?id=" + classId,
        async: false,
        success: function (result) {
            return result;
        },
        error: function (result) {
            return result;
        }
    }).responseText;

    classResult = JSON.parse(classResult);
    if (classResult.httpStatus != 'OK')
        return;

    $('#class-detail-modal-teacher-name').text(document.getElementById('class-teacher-'+classResult.id).innerText);
    $('#class-detail-modal-class-name').text('Class name: ' + classResult.name);
    $('#class-detail-modal-description').text(classResult.description);
    $('#class-detail-modal-join').click(function() {
        $('#readmore').modal('hide');
        openModal(classResult.id);
    });
    $('#readmore').modal('show');
}