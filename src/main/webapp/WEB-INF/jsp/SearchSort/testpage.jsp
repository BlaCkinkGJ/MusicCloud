<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page import ="com.team04.musiccloud.utilities.sort.Music"
         import ="com.team04.musiccloud.utilities.sort.ListSort"
         import ="com.team04.musiccloud.utilities.Search.Search"
         import="java.util.ArrayList"
         language= "java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    /*
     * sort
     * */
    ListSort listsort = new ListSort();

    //임시로 1이야 (title 오름차순)
    ArrayList<Music> sortlist;

    sortlist = listsort.Sort(1);

%>

<!DOCTYPE html>
<html >
<head>
    <meta charset="UTF-8">
    <title>pnu_004_team4 musiccloud</title>
    <link href='https://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900italic,900' rel='stylesheet' type='text/css'>

    <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
    <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css'>
    <link rel='stylesheet prefetch' href='http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css'>
    <link rel='stylesheet prefetch' href='/css/nouislider.min.css'>

    <link rel="stylesheet" href="/css/myPlayer.css">
</head>

<body>

<section class="header">

    <!--
    <div class="window__actions">
      <i class="ion-record red"></i>
      <i class="ion-record yellow"></i>
      <i class="ion-record green"></i>
    </div>
    -->
    <form:form action="search" method="post">
        <div class="search">
            <input type="text" name = "index" placeholder="Search" />
        </div>
        <div class="Button">
            <button type="submit">Search</button>
        </div>
    </form:form>

    <form:form action="sort" method="post">
        <div class="search">
            <input type="text" name = "index" placeholder="Sort place" />
        </div>
        <div class="Button">
            <button type="submit">Sort</button>
        </div>
    </form:form>


<%--    <div class="content__right">--%>
<%--        <form:form action="sort">--%>
<%--            <input type="text" name="index" value="1" size="1" readonly>--%>
<%--            <input type="button" id="tASC" value="titleASC">--%>
<%--        </form:form>--%>
<%--        <form:form action="sort">--%>
<%--            <input type="text" name="index" value="2" size="1" readonly>--%>
<%--            <input type="button" id="tDSC" value="titleDSC">--%>
<%--        </form:form>--%>
<%--        <form:form action="sort">--%>
<%--            <input type="text" name="index" value="3"size="1" readonly>--%>
<%--            <input type="button" id="aASC" value="artistASC">--%>
<%--        </form:form>--%>
<%--        <form:form action="sort">--%>
<%--            <input type="text" name="index" value="4" size="1"readonly>--%>
<%--            <input type="button" id="aDSC" value="artistDSC">--%>
<%--        </form:form>--%>
<%--    </div>--%>




</section>


<section class="content">

    <div class="content__middle">

        <div class="album__tracks">

            <div class="tracks">

                <div class="tracks__heading">

                    <div class="tracks__heading__number">#</div>

                    <div class="tracks__heading__title">Song</div>

                    <div class="tracks__heading__artist">ARTIST</div>

                    <div class="tracks__heading__length">


                    </div>


                </div>

                <%
                    for (int i = 0; i < sortlist.size(); i++) {
                %>
                <div class="track">

                    <div class="track__number"><%= i%></div>

                    <div class="track__play">

                        <i class="ion-ios-play"></i>
                    </div>
                    <div class="track__delete">

                        <i class="ion-android-delete"></i>
                    </div>

                    <%--title입니다.--%>
                    <div class="track__title"><%= sortlist.get(i).getTitle()%></div>

                    <%--artist--%>
                    <div class="track__artist"><%= sortlist.get(i).getArtist()%></div>

                </div>
                <%
                    }
                %>
            </div>

        </div>
    </div>

</section>


<%--<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>--%>
<%--<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>--%>
<%--<script src='/js/nouislider.min.js'></script>--%>
<%--<script src="/js/myPlayer.js"></script>--%>

</body>
</html>