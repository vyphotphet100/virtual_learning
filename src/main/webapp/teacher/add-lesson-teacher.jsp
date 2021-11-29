<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Virtual learning | Add lesson</title>
    <link rel="stylesheet" type="text/css" href="../resources/styles/bootstrap4/bootstrap.min.css">
    <link href="../resources/plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="../resources/plugins/OwlCarousel2-2.2.1/owl.carousel.css">
    <link rel="stylesheet" type="text/css" href="../resources/plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
    <link rel="stylesheet" type="text/css" href="../resources/plugins/OwlCarousel2-2.2.1/animate.css">
    <link rel="stylesheet" type="text/css" href="../resources/styles/main_styles.css">
    <link rel="stylesheet" type="text/css" href="../resources/styles/responsive.css">

    <link rel="stylesheet" type="text/css" href="../resources/styles/main.css">
    <link rel="stylesheet" type="text/css" href="../resources/styles/util.css">
	<link rel="stylesheet" type="text/css" href="../resources/styles/main_1.css">
    <link rel="stylesheet" type="text/css" href="../resources/styles/style.min.css">
    <link rel="stylesheet" type="text/css" href="../resources/styles/styles-merged.css">
</head>

<body>
    <div class="super_container">

        <!-- Header -->
        <header class="header">
			<%@include file="/common/header.jsp"%>
	    </header>
    </div>    

    <div class="courses">
        <!--Background-->
        <div class="section_background parallax-window" data-parallax="scroll" data-image-src="images/courses_background.jpg" data-speed="0.8"></div>
        <div class="topic-of-page">
            <h3 class="h">Add lesson</h3>
        </div>

        <!--Form add class-->
        <form class="login100-form validate-form edit-form">
            <span class="login100-form-title p-b-43">
                <div class="text-center">
                    <h1>Adding lesson form</h1>
                    <p>This is the section for the question that you want to give your students</p>   
                </div>
            </span>
            
            
            <div class="wrap-input100 validate-input" data-validate = "Name of class is required">
                <input class="input100" type="text" name="name">
                <span class="focus-input100"></span>
                <span class="label-input100">Title</span>
            </div>
            
            <div class="wrap-input100 validate-input" data-validate = "Full-name is required">
                <input class="input100" type="text" name="text">
                <span class="focus-input100"></span>
                <span class="label-input100">Description</span>
            </div>

            <div class="question-form-container">
                <div class="text-center edit-question-form">
                    <button type="button" class="join-button join-button-edit font-weight-bold" data-toggle="modal" data-target="#question" style="width: 79% !important;">
                        Upload Video
                    </button>
                    <button type="button" class="join-button join-button-edit font-weight-bold" id="btnSaveLink" onclick="alert('Link uploaded!');">
                        Save
                    </button>
                </div>
            </div>
            <!-- Modal - question-->
            <div class="modal fade" id="question" tabindex="-1" role="dialog" aria-labelledby="questionTitle" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title" id="questionTitle"><b>Post your link</b></h4>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div class="question-content">
                                <label>Enter link here</label>
                                <input type="text" name="link" placeholder="You link" class="InputLink">
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary" data-dismiss="modal" >Confirm</button>
                        </div>


                    </div>
                </div>
            </div>
            <!--End modal-->
            <h3 class="text-center" style="margin-bottom: 20px; margin-top: 50px;">Question?</h3>
            
            <div class="text-center">
                <a href="#" class="a-join-button">
                    <button class="join-button join-button-edit">
                        <b>Question 1</b>
                    </button>
                </a>
            </div>

            <div class="text-center">
                <a href="#" class="a-join-button">
                    <button class="join-button join-button-edit">
                        <b>Question 2</b>
                    </button>
                </a>
            </div>

            <div class="text-center">
                <a href="#" class="a-join-button">
                    <button class="join-button join-button-edit">
                        <b>Add question</b>
                    </button>
                </a>
            </div>
            
        </form>
    </div>

    <!--join button-->
    <div class="text-center">
        <a href="#" class="a-join-button">
            <button class="join-button">
                <b>Apply</b>
            </button>
        </a>
    </div>
</body>

<!-- Footer-->
<footer class="footer">
	<%@include file="/common/footer.jsp"%>
</footer>

<script src="../resources/js/jquery-3.2.1.min.js"></script>
<script src="../resources/styles/bootstrap4/popper.js"></script>
<script src="../resources/styles/bootstrap4/bootstrap.min.js"></script>
<script src="../resources/plugins/greensock/TweenMax.min.js"></script>
<script src="../resources/plugins/greensock/TimelineMax.min.js"></script>
<script src="../resources/plugins/scrollmagic/ScrollMagic.min.js"></script>
<script src="../resources/plugins/greensock/animation.gsap.min.js"></script>
<script src="../resources/plugins/greensock/ScrollToPlugin.min.js"></script>
<script src="../resources/plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
<script src="../resources/plugins/easing/easing.js"></script>
<script src="../resources/plugins/parallax-js-master/parallax.min.js"></script>

<script src="../resources/js/custom.js"></script>
<script src="../resources/js/main.js"></script>
<script src="../resources/js/main.min.js"></script>
<script src="../resources/js/scripts.min.js"></script>
</html>