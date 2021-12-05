function getQuestionById(id) {
    if (id == null) {
        // set data for question modal return null
        document.getElementById('question-id').value = '';
        document.getElementById('question-input').value = '';
        for (var i = 0; i < 4; i++) {
            document.getElementsByClassName('answer-input')[i].value = '';
            document.getElementsByName('correct')[i].checked = false;
        }

        $('#question').modal("show");
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
    document.getElementById('question-id').value = question.id;
    document.getElementById('question-input').value = question.content;
    var options = question.option.split('|');
    for (var i = 0; i < document.getElementsByClassName('answer-input').length; i++) {
        document.getElementsByClassName('answer-input')[i].value = options[i];
    }
    document.getElementsByName('correct')[question.correct - 1].checked = true;

    document.getElementById('question').className += ' show';
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
        if (document.getElementsByClassName('answer-input')[i].value.trim() == '') {
            alert("Some fields are invalid.");
            return;
        }

        if (i != document.getElementsByClassName('answer-input').length - 1)
            options += document.getElementsByClassName('answer-input')[i].value + '|';
        else
            options += document.getElementsByClassName('answer-input')[i].value;
    }
    var correct = -1;
    for (var i = 0; i < document.getElementsByName('correct').length; i++)
        if (document.getElementsByName('correct')[i].checked) {
            correct = i + 1;
            break;
        }
    if (correct == -1) {
        alert("Some fields are invalid.");
        return;
    }

    var url = new URL(window.location.href);
    var lessonId = url.searchParams.get('id');
    if (lessonId.trim() == '') {
        alert("Some fields are invalid.");
        return;
    }

    var question = {
        id: document.getElementById('question-id').value,
        content: document.getElementById('question-input').value,
        option: options,
        correct: correct,
        lessonId: parseInt(lessonId)
    }

    $('#id').val(question.id);
    $('#content').val(question.content);
    $('#option').val(question.option);
    $('#correct').val(question.correct);
    $('#lessonId').val(question.lessonId);
    $("#hidden-question-form").submit();
}

$("#class-form").submit(function (e) {
    e.preventDefault(); // avoid to execute the actual submit of the form.
    var form = $(this);

    var result = $.ajax({
        type: "POST",
        url: "/teacher/edit-lesson",
        async: false,
        data: form.serialize(), // serializes the form's elements.
        success: function (result) {
            return result;
        },
        error: function (result) {
            return result;
        }
    }).responseText;

    result = JSON.parse(result);
    if (result.httpStatus != 'OK') {
        alert(result.message);
        return;
    }

    window.location.reload();
});

$("#hidden-question-form").submit(function (e) {
    e.preventDefault(); // avoid to execute the actual submit of the form.
    var form = $(this);

    if ($('#id').val() == null || $('#id').val().trim() == '') // add question
    {
        var result = $.ajax({
            type: "POST",
            url: "/teacher/add-question",
            async: false,
            data: form.serialize(), // serializes the form's elements.
            success: function (result) {
                return result;
            },
            error: function (result) {
                return result;
            }
        }).responseText;

        result = JSON.parse(result);
        if (result.httpStatus != 'OK') {
            alert(result.message);
            return;
        }

        $('#question').modal("hide");
        var container = document.querySelector('.question-form-container');

        var div = document.createElement('div');
        div.setAttribute('class', 'text-center edit-question-form');
        div.setAttribute('id', 'question-overview-'+result.id);

        var questionButton = document.createElement('button');
        questionButton.setAttribute('class', 'join-button join-button-edit font-weight-bold');
        questionButton.setAttribute('data-toggle', 'modal');
        questionButton.setAttribute('type', 'button');
        questionButton.setAttribute('data-target', '#question');
        questionButton.setAttribute('style', 'width: 79% !important;');
        questionButton.setAttribute('onclick', 'getQuestionById('+result.id+');')
        questionButton.innerHTML = 'Question';

        var deleteButton = document.createElement('button');
        deleteButton.setAttribute('class', 'join-button join-button-edit font-weight-bold deleteButton');
        deleteButton.setAttribute('data-toggle', 'modal');
        deleteButton.setAttribute('type', 'button');
        deleteButton.setAttribute('data-target', '#delete');
        deleteButton.setAttribute('style', 'width: 20% !important;');
        deleteButton.innerHTML = 'Delete';
        deleteButton.setAttribute('onclick', "deleteQuestion('question-overview-"+result.id+"')");

        div.appendChild(questionButton);
        div.appendChild(deleteButton);

        container.appendChild(div);
    }
    else // edit question
    {
        var result = $.ajax({
            type: "POST",
            url: "/teacher/edit-question",
            async: false,
            data: form.serialize(), // serializes the form's elements.
            success: function (result) {
                return result;
            },
            error: function (result) {
                return result;
            }
        }).responseText;

        result = JSON.parse(result);
        if (result.httpStatus != 'OK') {
            alert(result.message);
            return;
        }

        $('#question').modal("hide");
    }
});