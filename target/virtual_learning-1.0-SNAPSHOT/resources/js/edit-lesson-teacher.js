function getQuestionById(id) {
    if (id == null) {
        // set data for question modal return null
        document.getElementById('question-input').value = '';
        for (var i = 0; i < 4; i++) {
            document.getElementsByClassName('answer-input')[i].value = '';
            document.getElementsByName('correct')[i].checked = false;
        }

        document.getElementById('question').style.display = "block";
        return;
    }

    var question = $.ajax({
        url: '/teacher/get-question?id=' + id,
        type: 'GET',
        async: false,
        contentType: 'application/json',
        success: function (result) {
            return result;
        },
        error: function (result) {
            return result;
        }
    });

    question = JSON.parse(question.responseText);

    // set data for question modal
    document.getElementById('question-input').value = question.content;
    var options = question.option.split('|');
    for (var i = 0; i < document.getElementsByClassName('answer-input').length; i++) {
        document.getElementsByClassName('answer-input')[i].value = options[i];
    }
    document.getElementsByName('correct')[question.correct - 1].checked = true;

    document.getElementById('question').style.display = "block";
}

function deleteQuestion(id) {
    document.getElementById(id).remove();
}