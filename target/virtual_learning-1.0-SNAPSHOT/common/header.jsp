<!-- Top Bar -->
<div class="top_bar">
    <div class="top_bar_container">
        <div class="container">
            <div class="row">
                <div class="col">
                    <div class="top_bar_content d-flex flex-row align-items-center justify-content-start">
                        <ul class="top_bar_contact_list">
                            <li><div class="question">Have any questions?</div></li>
                            <li>
                                <i class="fa fa-phone" aria-hidden="true"></i>
                                <div>0964-088-473</div>
                            </li>
                            <li>
                                <i class="fa fa-envelope-o" aria-hidden="true"></i>
                                <div>19110065@student.hcmute.edu.vn</div>
                            </li>
                        </ul>
                        <c:if test="${empty sessionScope.userDto}">
                            <div class="top_bar_login ml-auto">
                                <div class="login_button"><a href="/log-in" class="Login">Login</a></div>
                            </div>
                        </c:if>
                        <c:if test="${not empty sessionScope.userDto}">
                            <div class="top_bar_login ml-auto">
                                <div class="login_button"><a class="Login">Hello, ${sessionScope.userDto.fullName}</a></div>
                            </div>
                        </c:if>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Header Content -->
<div class="header_container">
    <div class="container">
        <div class="row">
            <div class="col">
                <div class="header_content d-flex flex-row align-items-center justify-content-start">
                    <div class="logo_container">
                        <a href="#">
                            <div class="logo_text">Virtual<span>Learning</span></div>
                        </a>
                    </div>
                    <nav class="main_nav_contaner ml-auto">
                        <ul class="main_nav">
                            <li class="active"><a href="index.html">Home</a></li>
                            <li><a href="MyClass.html">My classes</a></li>
                            <li><a href="contact.html">Contact</a></li>
                        </ul>
                        <div class="search_button"><i class="fa fa-search" aria-hidden="true"></i></div>

                        <!-- Hamburger -->

                        <div class="shopping_cart"><i><a href="profile.html" class="fa fa-user-circle-o"></a></i></div>
                        <div class="hamburger menu_mm">
                            <i class="fa fa-bars menu_mm" aria-hidden="true"></i>
                        </div>
                    </nav>

                </div>
            </div>
        </div>
    </div>
</div>
<!-- Header Search Panel -->
<div class="header_search_container">
    <div class="container">
        <div class="row">
            <div class="col">
                <div class="header_search_content d-flex flex-row align-items-center justify-content-end">
                    <form action="#" class="header_search_form">
                        <input type="search" class="search_input" placeholder="Search" required="required">
                        <button class="header_search_button d-flex flex-column align-items-center justify-content-center">
                            <i class="fa fa-search" aria-hidden="true"></i>
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>