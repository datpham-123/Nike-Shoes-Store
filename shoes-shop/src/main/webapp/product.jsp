<%@ page import="dal.ProductDAO" %>
<!-- @format -->

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

    <title>Product</title>
</head>

<body class="dark">
<div class="wrapper wrapper-products">
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
                    <span class="navbar-text">About</span></a>
            </li>

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
    <section class="main-content products">
        <%-- number of products here--%>
        <div class="products-header">
            <h2 class="products-header__head">All Products</h2>
            <p class="products-header__desc">There are total ${requestScope.numberOfProducts} products</p>

            <%--search function here--%>
            <div class="products-search">
                <%--pass to servlet search ( "/search")--%>
                <form action="search" class="form-search" method="get">
                    <input type="text" class="form-search-input" name="search-product"
                           placeholder="Enter product name...."/>
                    <button type="submit" class="form-search-button">
                        <svg
                                width="1em"
                                height="1em"
                                viewBox="0 0 16 16"
                                class="bi bi-search form-search-icon"
                                fill="currentColor"
                                xmlns="http://www.w3.org/2000/svg"
                        >
                            <path
                                    fill-rule="evenodd"
                                    d="M10.442 10.442a1 1 0 0 1 1.415 0l3.85 3.85a1 1 0 0 1-1.414 1.415l-3.85-3.85a1 1 0 0 1 0-1.415z"
                            />
                            <path
                                    fill-rule="evenodd"
                                    d="M6.5 12a5.5 5.5 0 1 0 0-11 5.5 5.5 0 0 0 0 11zM13 6.5a6.5 6.5 0 1 1-13 0 6.5 6.5 0 0 1 13 0z"
                            />
                        </svg>
                    </button>
                </form>
            </div>

            <%--All Products types here--%>
            <div class="products-filter">
                <%--                <div class="products-cate products-cate1"><a href="filter-type?id=0">All</a></div>--%>
                <c:forEach items="${requestScope.listAllProductTypes}" var="type">
                    <%--link to filter servlet here: filter?id= --%>
                    <div class="products-cate products-cate${type.id+1}"><a
                            href="filter-type?id=${type.id}">${type.type}</a>
                    </div>
                </c:forEach>
            </div>
        </div>

        <!-- end product filter -->

        <%-- All Products display here--%>
        <div class="product">
            <c:forEach items="${requestScope.listAllProducts}" var="product">
                <article class="product-card">
                        <%--product image--%>
                    <img src="./assets/images/products/${product.image}" alt="product"
                         class="product-card__img"/>
                    <div class="product-card-content">
                        <div class="card-name">${product.name}</div>
                        <div class="card-price">${product.price}$</div>
                            <%--passed to product detail servlet--%>
                        <a href="product-detail?id=${product.id}" class="card-buy">Detail</a>
                    </div>
                </article>
            </c:forEach>
        </div>

        <%--pagination--%>
        <div class="pagination">

            <ul class="pagination-list">
                <%-- previous --%>
                <li class="pagination-item pagination-action pagination-prev is-disabled">
                    <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-chevron-left" fill="currentColor"
                         xmlns="http://www.w3.org/2000/svg">
                        <path
                                fill-rule="evenodd"
                                d="M11.354 1.646a.5.5 0 0 1 0 .708L5.707 8l5.647 5.646a.5.5 0 0 1-.708.708l-6-6a.5.5 0 0 1 0-.708l6-6a.5.5 0 0 1 .708 0z"
                        />
                    </svg>
                </li>
                <li class="pagination-item">1</li>
                <li class="pagination-item is-active">2</li>
                <li class="pagination-item">3</li>
                <li class="pagination-item">4</li>
                <li class="pagination-item">5</li>
                <%-- next --%>
                <li class="pagination-item pagination-action pagination-next">
                    <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-chevron-right" fill="currentColor"
                         xmlns="http://www.w3.org/2000/svg">
                        <path
                                fill-rule="evenodd"
                                d="M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708z"
                        />
                    </svg>
                </li>
            </ul>

        </div>
        <!-- end pagination -->
    </section>
    <!-- end main content -->
</div>

<!-- custom js -->
<script src="./assets/js/theme.js"></script>
</body>

</html>