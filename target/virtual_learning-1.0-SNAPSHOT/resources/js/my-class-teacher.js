function deleteClass(classId) {
    if (!confirm("Are you sure to delete this class?"))
        return;

    $.ajax({
        url: '/teacher/delete-class?id=' + classId,
        type: 'DELETE',
        async: false,
        contentType: 'application/json',
        success: function(result) {
            window.location.href = "/teacher/my-class";
        },
        error: function(error) {
            alert("Something went wrong");
        }
    });
}