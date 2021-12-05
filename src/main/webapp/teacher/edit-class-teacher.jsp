<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Virtual learning | Edit class</title>
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
<%--    <link rel="stylesheet" type="text/css" href="../resources/styles/styles-merged.css">>--%>

</head>

<body>
    <div class="super_container">

        <!-- Header -->
        <header class="header">
            <%@include file="/common/header.jsp" %>
        </header>

	    <!-- Menu -->
	    <div class="menu d-flex flex-column align-items-end justify-content-start text-right menu_mm trans_400">
		    <div class="menu_close_container"><div class="menu_close"><div></div><div></div></div></div>
		    <div class="search">
			    <form action="#" class="header_search_form menu_mm">
				    <input type="search" class="search_input menu_mm" placeholder="Search" required="required">
				    <button class="header_search_button d-flex flex-column align-items-center justify-content-center menu_mm">
					    <i class="fa fa-search menu_mm" aria-hidden="true"></i>
			    	</button>
		    	</form>
		    </div>
		    <nav class="menu_nav">
		    	<ul class="menu_mm">
				    <li class="menu_mm"><a href="#">Home</a></li>
				    <li class="menu_mm"><a href="#">My classes</a></li>
			     	<li class="menu_mm"><a href="#">Contact</a></li>
			    </ul>
		    </nav>
	    </div>
    </div>

    <div class="courses">
        <!--Background-->
        <div class="section_background parallax-window" data-parallax="scroll" data-image-src="../resources/images/courses_background.jpg" data-speed="0.8"></div>
        <div class="topic-of-page">
            <h3 class="h fix" style="font-size: 28px">Edit Class</h3>
        </div>

        <!--Form add class-->
        <form class="login100-form validate-form edit-form" method="post">
            <span class="login100-form-title p-b-43">
                <div class="text-center">
                    <h1 class="h fix" style="font-size: 48px">Editing class form</h1>
                    <p class="">This is the section for the initial setting up for your class</p>
                </div>
            </span>

            <c:if test="${not empty responseEntity && responseEntity.httpStatus == 'ERROR'}">
                <div class="alert alert-danger" role="alert">
                    <c:out value="${responseEntity.message}"/>
                </div>
            </c:if>
            <c:if test="${not empty responseEntity && responseEntity.httpStatus == 'OK'}">
                <div class="alert alert-success" role="alert">
                    <c:out value="${responseEntity.message}"/>
                </div>
            </c:if>
            <input type="hidden" value="${clazz.id}" name="id">

            <div class="wrap-input100 validate-input" data-validate = "Name of class is required">
                <input class="input100 has-val" type="text" name="name" value="${clazz.name}">
                <span class="focus-input100"></span>
                <span class="label-input100">Name of class</span>
            </div>

            <div class="wrap-input100 validate-input" id="subjectSelector" data-validate = "Type of class is required">
                <h3 class="TypeOfClass">Type of class</h3>
                <select name="subjectId"  class="form-select form-select-lg " id="subjectId">
                    <c:forEach items="${subjects}" var="subject">
                        <c:if test="${subject.id == clazz.subject.id}">
                            <option value="${subject.id}" selected>${subject.name}</option>
                        </c:if>
                        <c:if test="${subject.id != clazz.subject.id}">
                            <option value="${subject.id}">${subject.name}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>

<%--            <div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">--%>
<%--                <input class="input100" type="text" name="text">--%>
<%--                <span class="focus-input100"></span>--%>
<%--                <span class="label-input100">Name of subject</span>--%>
<%--            </div>--%>
            <div class="wrap-input100 validate-input description" data-validate = "Description is required">
                <textarea id="descriptionInput" class="input100 has-val" type="text" name="description" data-toggle="modal"
                          data-target="#description" value=""></textarea>
                <span class="focus-input100"></span>
                <span class="label-input100">Description</span>
            </div>

            <div class="wrap-input100 validate-input" data-validate="Password is required">
                <input class="input100" id="password-field1" type="password" name="password">
                <span class="focus-input100"></span>
                <span class="label-input100">Password</span>
            </div>

            <div class="wrap-input100 validate-input" data-validate="Password is required">
                <input class="input100" id="password-field2" type="password" name="confirmPassword">
                <span class="focus-input100"></span>
                <span class="label-input100">Confirm password</span>
            </div>

            <!-- Modal - description-->
            <div class="modal fade" id="description" tabindex="-1" role="dialog" aria-labelledby="descriptionTitle" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content description">
                        <div class="modal-header">
                            <h4 class="modal-title" id="descriptionTitle"><b>Complete your description</b></h4>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div class="question-content">
                                <label>Type the description:</label>
                                <textarea id="modalDescriptionInput" class="question-input description"></textarea>

                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button id="descriptionSave" type="button" class="btn btn-primary" data-dismiss="modal">Save</button>
                        </div>
                    </div>
                </div>
            </div>
            <!--End modal-->
        </form>

        <!--Apply button-->
        <div class="text-center">
            <a href="#" class="a-join-button">
                <button type="submit" class="join-button">
                    <b>Apply</b>
                </button>
            </a>
        </div>
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