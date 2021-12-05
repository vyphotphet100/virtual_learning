
(function ($) {
    "use strict";


    /*==================================================================
    [ Focus Contact2 ]*/
    $('.input100').each(function(){
        $(this).on('blur', function(){
            if($(this).val().trim() != "") {
                $(this).addClass('has-val');
            }
            else {
                $(this).removeClass('has-val');
            }
        })    
    })
  
  
    /*==================================================================
    [ Validate ]*/
    var input = $('.validate-input .input100');

    $('.validate-form').on('submit',function(){
        var check = true;

        for(var i=0; i<input.length; i++) {
            if(validate(input[i]) == false){
                showValidate(input[i]);
                check=false;
            }
        }

        return check;
    });


    $('.validate-form .input100').each(function(){
        $(this).focus(function(){
           hideValidate(this);
        });
    });

    function validate (input) {
        if($(input).attr('type') == 'email' || $(input).attr('name') == 'email') {
            if($(input).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
                return false;
            }
        }
        else {
            if($(input).val().trim() == ''){
                return false;
            }
        }
    }

    function showValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).removeClass('alert-validate');
    }

    
    /*==================================================================
    [ Add + delete question ]*/
    var deleteEvent = function (deleteButton) {
        // deleteButton.addEventListener('click', function () {
        //     if (document.querySelectorAll('.deleteButton').length < 2) {
        //         alert('Must have at least 1 Question');
        //     } else {
        //         deleteButton.parentNode.parentNode.removeChild(deleteButton.parentNode);
        //     }
        // });
    };

    
    var deleteButton0 = document.querySelectorAll('.deleteButton');
    deleteEvent(deleteButton0[0]);

    var addQuestion = document.querySelector('.addQuestion');
    addQuestion.addEventListener('click', function() {
        return;

        var container = document.querySelector('.question-form-container');

        var div = document.createElement('div');
        div.setAttribute('class', 'text-center edit-question-form');
        let r = (Math.random() + 1).toString(36).substring(5);
        div.setAttribute('id', 'question-overview-'+r);

        var questionButton = document.createElement('button');
        questionButton.setAttribute('class', 'join-button join-button-edit font-weight-bold');
        questionButton.setAttribute('data-toggle', 'modal');
        questionButton.setAttribute('type', 'button');
        questionButton.setAttribute('data-target', '#question');
        questionButton.setAttribute('style', 'width: 79% !important;');
        questionButton.setAttribute('onclick', 'getQuestionById();')
        questionButton.innerHTML = 'Question';

        var deleteButton = document.createElement('button');
        deleteButton.setAttribute('class', 'join-button join-button-edit font-weight-bold deleteButton');
        deleteButton.setAttribute('data-toggle', 'modal');
        deleteButton.setAttribute('type', 'button');
        deleteButton.setAttribute('data-target', '#delete');
        deleteButton.setAttribute('style', 'width: 20% !important;');
        deleteButton.innerHTML = 'Delete';
        deleteButton.setAttribute('onclick', "deleteQuestion('question-overview-"+r+"')");

        div.appendChild(questionButton);
        div.appendChild(deleteButton);

        container.appendChild(div);

        //deleteEvent(deleteButton);
    });

    /*==================================================================
    [ take the text in modal description into textarea description ]*/
    document.querySelector('#descriptionSave').addEventListener('click', function () {
        document.querySelector('#descriptionInput').value = document.querySelector('#modalDescriptionInput').value;
    });

})(jQuery);