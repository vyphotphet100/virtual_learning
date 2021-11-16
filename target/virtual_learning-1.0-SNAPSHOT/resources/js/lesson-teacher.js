function deleteLesson(questionId, classId) {
    if (!confirm("Are you sure to delete this lesson?"))
        return;

    $.ajax({
        url: '/teacher/delete-lesson?id=' + questionId,
        type: 'DELETE',
        async: false,
        contentType: 'application/json',
        success: function(result) {
            window.location.href = "/teacher/class?id=" + classId;
        },
        error: function(error) {
            alert("Something went wrong");
        }
    });
}