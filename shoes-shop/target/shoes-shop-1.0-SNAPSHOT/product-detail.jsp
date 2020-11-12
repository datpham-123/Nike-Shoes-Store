<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 11/9/2020
  Time: 9:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <!-- favicon -->
    <link rel="shortcut icon" type="image/png" href="./assets/icons/favicon/dou-shou-qi-wolf-64-194531.png"/>

    <!-- css reset -->
    <link rel="stylesheet" href="./assets/css/reset.css"/>

    <!-- google font -->
    <link rel="stylesheet" href="./assets/css/font.css"/>

    <!-- gallery css -->
    <link rel="stylesheet" href="./assets/css/main.css"/>

    <title>Product detail</title>
</head>

<body class="dark">
<div class="wrapper wrapper-pdetail">
    <nav class="navbar">
        <ul class="navbar-list">
            <li class="logo">
                <a href="#" class="navbar-link">
                    <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-chevron-double-right logo-icon"
                         fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                        <path
                                fill-rule="evenodd"
                                d="M3.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L9.293 8 3.646 2.354a.5.5 0 0 1 0-.708z"
                        />
                        <path
                                fill-rule="evenodd"
                                d="M7.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L13.293 8 7.646 2.354a.5.5 0 0 1 0-.708z"
                        />
                    </svg>
                </a>
            </li>
            <!-- end class logo -->
            <li class="navbar-item">
                <a href="index.jsp" class="navbar-link">
                    <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-house navbar-icon"
                         fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                        <path
                                fill-rule="evenodd"
                                d="M2 13.5V7h1v6.5a.5.5 0 0 0 .5.5h9a.5.5 0 0 0 .5-.5V7h1v6.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5zm11-11V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z"
                        />
                        <path
                                fill-rule="evenodd"
                                d="M7.293 1.5a1 1 0 0 1 1.414 0l6.647 6.646a.5.5 0 0 1-.708.708L8 2.207 1.354 8.854a.5.5 0 1 1-.708-.708L7.293 1.5z"
                        />
                    </svg>
                    <span class="navbar-text">Home</span></a>
            </li>

            <li class="navbar-item">
                <a href="${pageContext.request.contextPath}/list-products" class="navbar-link">
                    <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-wallet-fill navbar-icon"
                         fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                        <path
                                d="M1.5 2A1.5 1.5 0 0 0 0 3.5v2h6a.5.5 0 0 1 .5.5c0 .253.08.644.306.958.207.288.557.542 1.194.542.637 0 .987-.254 1.194-.542.226-.314.306-.705.306-.958a.5.5 0 0 1 .5-.5h6v-2A1.5 1.5 0 0 0 14.5 2h-13z"
                        />
                        <path
                                d="M16 6.5h-5.551a2.678 2.678 0 0 1-.443 1.042C9.613 8.088 8.963 8.5 8 8.5c-.963 0-1.613-.412-2.006-.958A2.679 2.679 0 0 1 5.551 6.5H0v6A1.5 1.5 0 0 0 1.5 14h13a1.5 1.5 0 0 0 1.5-1.5v-6z"
                        />
                    </svg>
                    <span class="navbar-text">Product</span></a>
            </li>

            <li class="navbar-item">
                <a href="gallery.jsp" class="navbar-link">
                    <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-images navbar-icon"
                         fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                        <path
                                fill-rule="evenodd"
                                d="M12.002 4h-10a1 1 0 0 0-1 1v8l2.646-2.354a.5.5 0 0 1 .63-.062l2.66 1.773 3.71-3.71a.5.5 0 0 1 .577-.094l1.777 1.947V5a1 1 0 0 0-1-1zm-10-1a2 2 0 0 0-2 2v8a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V5a2 2 0 0 0-2-2h-10zm4 4.5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0z"
                        />
                        <path
                                fill-rule="evenodd"
                                d="M4 2h10a1 1 0 0 1 1 1v8a1 1 0 0 1-1 1v1a2 2 0 0 0 2-2V3a2 2 0 0 0-2-2H4a2 2 0 0 0-2 2h1a1 1 0 0 1 1-1z"
                        />
                    </svg>
                    <span class="navbar-text">Gallery</span></a>
            </li>

            <c:if test="${sessionScope.accountLogin ne null}">
                <li class="navbar-item">
                    <a href="about.jsp" class="navbar-link">
                        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-person-circle navbar-icon"
                             fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                            <path
                                    d="M13.468 12.37C12.758 11.226 11.195 10 8 10s-4.757 1.225-5.468 2.37A6.987 6.987 0 0 0 8 15a6.987 6.987 0 0 0 5.468-2.63z"
                            />
                            <path
                                    fill-rule="evenodd"
                                    d="M8 9a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"
                            />
                            <path
                                    fill-rule="evenodd"
                                    d="M8 1a7 7 0 1 0 0 14A7 7 0 0 0 8 1zM0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8z"
                            />
                        </svg>
                        <span class="navbar-text">${sessionScope.accountLogin.account}</span></a>
                </li>
            </c:if>

            <li class="navbar-item">
                <a href="login.jsp" class="navbar-link">
                    <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-door-open-fill navbar-icon"
                         fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                        <path
                                fill-rule="evenodd"
                                d="M1.5 15a.5.5 0 0 0 0 1h13a.5.5 0 0 0 0-1H13V2.5A1.5 1.5 0 0 0 11.5 1H11V.5a.5.5 0 0 0-.57-.495l-7 1A.5.5 0 0 0 3 1.5V15H1.5zM11 2v13h1V2.5a.5.5 0 0 0-.5-.5H11zm-2.5 8c-.276 0-.5-.448-.5-1s.224-1 .5-1 .5.448.5 1-.224 1-.5 1z"
                        />
                    </svg>
                    <span class="navbar-text">Login</span></a>
            </li>

            <li class="navbar-item">
                <a href="cart.jsp" class="navbar-link">
                    <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-bag-check-fill navbar-icon"
                         fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                        <path
                                fill-rule="evenodd"
                                d="M5.5 3.5a2.5 2.5 0 0 1 5 0V4h-5v-.5zm6 0V4H15v10a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2V4h3.5v-.5a3.5 3.5 0 1 1 7 0zm-.646 5.354a.5.5 0 0 0-.708-.708L7.5 10.793 6.354 9.646a.5.5 0 1 0-.708.708l1.5 1.5a.5.5 0 0 0 .708 0l3-3z"
                        />
                    </svg>
                    <span class="navbar-text">Cart</span></a>
            </li>

            <div class="navbar-item--last">
                <li class="navbar-item">
                    <a href="#" class="navbar-link" id="light">
                        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-toggle-off navbar-icon"
                             fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                            <path
                                    fill-rule="evenodd"
                                    d="M11 4a4 4 0 0 1 0 8H8a4.992 4.992 0 0 0 2-4 4.992 4.992 0 0 0-2-4h3zm-6 8a4 4 0 1 1 0-8 4 4 0 0 1 0 8zM0 8a5 5 0 0 0 5 5h6a5 5 0 0 0 0-10H5a5 5 0 0 0-5 5z"
                            />
                        </svg>
                        <span class="navbar-text">Light</span></a>
                </li>

                <li class="navbar-item">
                    <a href="#" class="navbar-link" id="dark">
                        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-toggle-on navbar-icon"
                             fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                            <path
                                    fill-rule="evenodd"
                                    d="M5 3a5 5 0 0 0 0 10h6a5 5 0 0 0 0-10H5zm6 9a4 4 0 1 0 0-8 4 4 0 0 0 0 8z"
                            />
                        </svg>
                        <span class="navbar-text">Dark</span></a>
                </li>
            </div>
        </ul>
        <!-- end nav list -->
    </nav>
    <!-- end navbar -->
    <main class="main-content pdetail item-wrapper">
        <div class="item">
            <div class="item-imgs">
                <%--main image--%>
                <div class="img-showcase">
                    <img src="./assets/images/products/${requestScope.pDetail.image}" alt="shoes-item"/>
                </div>
                <%--more images--%>
                <div class="img-more">
                    <c:forEach items="${requestScope.pDetailImages}" var="image">
                        <img src="./assets/images/products/${image.image}" alt="showcase" class="img-more-item"/>
                    </c:forEach>
                </div>
                <!-- end img showcase -->
            </div>
            <!-- card left: show image -->
            <div class="item-content">
                <h2 class="item-title">${requestScope.pDetail.name}</h2>
                <div class="item-rating">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star-half-alt"></i>
                    <span>4.7(21)</span>
                </div>
                <div class="item-price">
                    <p class="new-price">Price: <span>$${requestScope.pDetail.price}</span></p>
                </div>
                <div class="item-detail">
                    <h2 class="item-detail__header">About this item:</h2>
                    <p class="item-detail__desc">
                        ${requestScope.pDetail.description}
                    </p>
                    <ul class="item-info-list">
                        <li class="item-info-item">Brand: <span> ${requestScope.pDetailBrand}</span></li>
                        <li class="item-info-item">Type:<span> ${requestScope.pDetailType}</span></li>
                        <li class="item-info-item">Status: <span> ${requestScope.pDetailStatus}</span></li>
                        <li class="item-info-item">Quantity: <span> ${requestScope.pDetail.quantity}</span></li>
                        <li class="item-info-item">
                            Shipping area: <span>HN, HCM city</span>
                        </li>
                        <li class="item-info-item">Shipping fee: <span>Free</span></li>
                    </ul>
                </div>
                <div class="item-purchase">
                    <form action="#">
                        <input type="number" name="item-input-purchase" class="item-input-purchase" min="0" value="1"/>
                        <button href="#" class="btn btn-primary item-input-btn" type="submit">
                            Add to Cart <i class="fas fa-shopping-cart"></i>
                        </button>
                    </form>
                </div>
                <div class="item-social">
                    <p class="item-social-text">
                        Send as gift:
                        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-gift item-social-link"
                             fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                            <path
                                    fill-rule="evenodd"
                                    d="M3 2.5a2.5 2.5 0 0 1 5 0 2.5 2.5 0 0 1 5 0v.006c0 .07 0 .27-.038.494H15a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1v7.5a1.5 1.5 0 0 1-1.5 1.5h-11A1.5 1.5 0 0 1 1 14.5V7a1 1 0 0 1-1-1V4a1 1 0 0 1 1-1h2.038A2.968 2.968 0 0 1 3 2.506V2.5zm1.068.5H7v-.5a1.5 1.5 0 1 0-3 0c0 .085.002.274.045.43a.522.522 0 0 0 .023.07zM9 3h2.932a.56.56 0 0 0 .023-.07c.043-.156.045-.345.045-.43a1.5 1.5 0 0 0-3 0V3zM1 4v2h6V4H1zm8 0v2h6V4H9zm5 3H9v8h4.5a.5.5 0 0 0 .5-.5V7zm-7 8V7H2v7.5a.5.5 0 0 0 .5.5H7z"
                            />
                        </svg>
                    </p>
                </div>
            </div>
            <!-- card right -->
        </div>
        <!-- end individual product -->
    </main>
    <!-- end main product detail -->
</div>
<!-- custom js -->
<script src="./assets/js/theme.js"></script>
</body>

</html>

