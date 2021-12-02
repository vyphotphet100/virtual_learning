function getQuestionById(id) {
    var question = $.ajax({
        url: '/teacher/get-question?id=' + id,
        type: 'GET',
        async: false,
        contentType: 'application/json',
        success: function(result) {
            return result;
        },
        error: function(result) {
            return result;
        }
    });

    question = JSON.parse(question.responseText);
}