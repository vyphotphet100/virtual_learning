function getQuestionData() {
    var questionBox =
        `
    <p class="qContent">CONTENT</p>
    <ul id="q1" class="question">
        <li>
            <input type="radio" name="OPTION_CLASS" class="OPTION_CLASS" value="0">
            <label class="LABEL_OPTION">OPTION1</label>
        </li>
        <li>
            <input type="radio" name="OPTION_CLASS" class="OPTION_CLASS" value="1">
            <label class="LABEL_OPTION">OPTION2</label>
        </li>
        <li>
            <input type="radio" name="OPTION_CLASS" class="OPTION_CLASS" value="2">
            <label class="LABEL_OPTION">OPTION3</label>
        </li>
        <li>
            <input type="radio" name="OPTION_CLASS" class="OPTION_CLASS" value="3">
            <label class="LABEL_OPTION">OPTION4</label>
        </li>
    </ul>
    <input type="hidden" class="question-correct" value="CORRECT">
    `;

    var totalQuestionBox = '';
    for (var i = 0; i < document.getElementsByClassName('q_a question').length; i++) {
        var questionBoxTmp = questionBox;
        questionBoxTmp = questionBoxTmp.replace('CONTENT', document.getElementsByClassName('qContent')[i].innerText);
        questionBoxTmp = questionBoxTmp.replace('CORRECT', document.getElementsByClassName('question-correct')[i].value);
        // get option
        options = document.getElementsByClassName('question-option')[i].value.split('|');
        for (var k = 0; k<options.length; k++) {
            questionBoxTmp = questionBoxTmp.replace('OPTION_CLASS', 'option-question' + i);
            questionBoxTmp = questionBoxTmp.replace('OPTION_CLASS', 'option-question' + i);
            questionBoxTmp = questionBoxTmp.replace('LABEL_OPTION', 'label-option-question' + i);
            questionBoxTmp = questionBoxTmp.replace('OPTION' + (k+1), options[k]);
        }
        totalQuestionBox += `<div class="q_a question">` + questionBoxTmp + `</div><hr>`;
    }

    document.getElementsByClassName('questions')[0].innerHTML = totalQuestionBox;
}
getQuestionData();

function checkResult() {
    for (var i=0; i<document.getElementsByClassName('q_a question').length; i++) {
        // get index of checked option of each question
        for (var k=0; k<document.getElementsByClassName('option-question'+i).length; k++) {
            if (document.getElementsByClassName('option-question'+i)[k].checked) {
                document.getElementsByClassName('label-option-question'+i)[k].style.color = 'red';
                break;
            }
        }

        document.getElementsByClassName('label-option-question'+i)[document.getElementsByClassName('question-correct')[i].value].style.color = 'green';
    }
}

