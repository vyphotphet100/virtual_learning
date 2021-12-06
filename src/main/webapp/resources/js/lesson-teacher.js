function deleteLesson(lessonId, classId) {
    if (!confirm("Are you sure to delete this lesson?"))
        return;

    var lessonResult = $.ajax({
        url: '/teacher/delete-lesson?id=' + lessonId,
        type: 'DELETE',
        async: false,
        contentType: 'application/json',
        success: function (result) {
            return result;
            //window.location.href = "/teacher/lesson?id=" + classId;
        },
        error: function (result) {
            alert("Something went wrong");
            return result;
        }
    }).responseText;

    lessonResult = JSON.parse(lessonResult);
    if (lessonResult.httpStatus == 'OK') {
        alert(lessonResult.message);
        if (lessonResult.resultList[0] != null)
            window.location.href = '/teacher/lesson?id=' + lessonResult.resultList[0];
        else
            window.location.href = '/teacher/my-class';
    }

}

function saveAddLesson(classId) {
    if ($('#add-lesson-title').val() == null ||
        $('#add-lesson-title').val().trim() == '')
        return;

    // Create a form synamically
    var form = document.createElement("form");
    form.setAttribute("id", "add-lesson-form");
    form.setAttribute("method", "post");
    form.setAttribute("style", "display:none;");

    // Create an input element
    var input = document.createElement("input");
    input.setAttribute("name", "title");
    input.setAttribute("value", $('#add-lesson-title').val());
    form.appendChild(input);

    input = document.createElement("input");
    input.setAttribute("name", "classId");
    input.setAttribute("value", classId);
    form.appendChild(input);
    document.body.appendChild(form);

    $('#add-lesson-form').submit(function (e) {
        e.preventDefault(); // avoid to execute the actual submit of the form.
        var form = $(this);

        var lessonResult = $.ajax({
            url: '/teacher/add-lesson',
            type: 'POST',
            async: false,
            data: form.serialize(),
            success: function (result) {
                return result;
            },
            error: function (result) {
                alert("Something went wrong");
                return result;
            }
        }).responseText;

        lessonResult = JSON.parse(lessonResult);
        if (lessonResult.httpStatus == 'OK') {
            window.location.href = '/teacher/edit-lesson?id=' + lessonResult.id;
        } else {
            $('announcement-content').text(lessonResult.message);
            $('announcement').modal('show');
        }
    });

    $('#add-lesson-form').submit();
}