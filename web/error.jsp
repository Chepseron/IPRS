<%-- 
    Document   : error
    Created on : Aug 13, 2012, 10:01:24 AM
    Author     : Ogutu
--%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich" %>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<f:view>


    <rich:panel style="background: transparent">
        <html>
            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

                <title>IPRS | Integrated Population Registration Services</title>
                <link href="lay_out.css" rel="stylesheet" type="text/css">
            </head>
            <body>
                <div id="login_container">
                    <div id="login_content">
                        <h:form id="abmt_reg_form09"   style="width: 102%; margin-right auto; margin-right: auto;   padding:0; ">

                            <div id="login_page" align="right">
                                <div class="headline">Login</div>
                                <h:message for="abmt_reg_form09" style="color: yellow; float: left; padding: 5px 5px 10px 10px"/>

                                <h:panelGrid id="send_to" columns="2" >
                                    <div class="text_lines">
                                        <font size="2px" color="white"> User name</font>
                                        <h:inputText id="username" value="#{immigration.username}"  />
                                    </div>
                                    <div class="text_lines">
                                        <font size="2px" color="white">Password</font>
                                        <h:inputSecret id="pass" value="#{immigration.pass}"/>
                                    </div>
                                </h:panelGrid>
                                <div class="enter_button">
                                    <h:commandButton value="LOGIN" action="#{immigration.login}"/><br>
                                    <h:commandLink value="Change Password" action="changepassword2.jsp"/><br>

                                </div>

                            </h:form>

                        </div>
                        <div id="footer">Powered by: <img src="images/logo.png" width="75" height="31" align="absmiddle"></div>
                    </div>
                </div>
            </body>
        </html>
    </rich:panel>
</f:view>
