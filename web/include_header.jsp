<%--
    Document   : sp
    Created on : Aug 14, 2010, 1:03:48 PM
    Author     : ochomo
--%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich" %>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>I.P.R.S | Intergrated Population Registration Services</title>
    <link href="pages_layout.css" rel="stylesheet" type="text/css">
    <link href="dropdown.css" rel="stylesheet" type="text/css">
    <link href="default.advanced.css" rel="stylesheet" type="text/css">
    </head>
     <body>
    <div id="main_container">
        <div id="top_part">
            <div class="navi">
                <div class="user_id">Welcome :<h:outputText value="#{immigration.username}"></h:outputText></div>
                <div class="navi_bar">
                    <ul class="dropdown dropdown-horizontal">
                        <li><a href="./" class="dir">User Config</a><ul>
                        <li><a href="changepassword2.jsp">Change Password</a></li></ul>
                    </li>
                    </ul>
                </div>
            </div>
            <div id="logos"></div>
        </div>
