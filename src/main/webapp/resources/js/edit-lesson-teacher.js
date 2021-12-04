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
    if (!confirm("Are you sure to delete this question?"))
        return;

    var questionId = id.split('-')[2];

    // remove on backend
    var question = $.ajax({
        url: '/teacher/delete-question?id=' + questionId,
        type: 'DELETE',
        async: false,
        contentType: 'application/json',
        success: function (result) {
            return result;
        },
        error: function (result) {
            return result;
        }
    }).responseText;

    if (question == 'false') {
        alert('Something went wrong!');
        return;
    }

    // remove on frontend
    document.getElementById(id).remove();
}

function saveChangeAddQuestion() {
    var options = '';
    for (var i = 0; i < document.getElementsByClassName('answer-input').length; i++) {
        if (i != document.getElementsByClassName('answer-input').length - 1)
            options += document.getElementsByClassName('answer-input')[i].value + '|';
        else
            options += document.getElementsByClassName('answer-input')[i].value;
    }
    var correct = 1;
    for (var i=0; i<document.getElementsByName('correct').length; i++)
        if (document.getElementsByName('correct')[i].checked) {
            correct = i+1;
            break;
        }

    var url = new URL(window.location.href);
    var lessonId = url.searchParams.get('id');

    var question = {
        content: document.getElementById('question-input').value,
        option : options,
        correct: correct,
        lessonId: parseInt(lessonId)
    }

    var result = $.ajax({
        url: '/teacher/add-question',
        type: 'POST',
        async: false,
        contentType: 'application/json',
        data: JSON.stringify(question),
        dataType: 'json',
        success: function (result) {
            return result;
        },
        error: function (result) {
            return result;
        }
    }).responseText;

    result = JSON.parse(result);
    alert(result.message);
}