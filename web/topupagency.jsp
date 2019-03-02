<%@include file="include_IPRSheader.jsp" %>
    <body>
        <f:view>
        <div id="main_container">
            <div id="top_part">
                <div class="navi">
                    <div class="user_id">Welcome:<h:outputText value="#{immigration.username}"/></div>
                    <div class="navi_bar">
                    <ul class="dropdown dropdown-horizontal">
                        <li><a href="./" class="dir">User configuration</a><ul>
                        <li><a href="changepassword2.jsp">Change password</a></li></ul>
                    </ul>
                    </div>
                </div>
            </div>
       
            <%@include file="welcomeJSF_login.jsp"%>
            <rich:panel style="background: #ffffff" rendered="#{immigration.loggedIn}">
                <rich:layout>
                    <rich:layoutPanel position="top" width="100%" id="header"  >
                      
                    </rich:layoutPanel>

                    <rich:layoutPanel position="left" id="menu" width="15%" >
                        <%@include file="/left_menu_ad.jsp" %>
                    </rich:layoutPanel>

                    <rich:layoutPanel position="center" id="main_content" width="820px">                    
                        <rich:panel style=" border:1 " >
                            <f:facet name="header">
                                <h:outputText value="FOR:"></h:outputText>
                                <h:outputText value="#{immigration.agencyperms.agencyId}"/>
                            </f:facet>
                           
                                    <h:form id="abmt_reg_form1" style="width: 600px; margin-right auto; margin-right: auto;   padding:0; " >
                                        <h:message for="abmt_reg_form1" style="color: green"/>
                                        <h:panelGrid id="send_to" columns="2" >
                                            <h:outputLabel value="Topup Amount "/>
                                            <h:inputText id="user"  value="#{immigration.agencyperms.initialpay}" requiredMessage="please fill in the initial pay"/>
                                            <h:outputLabel value="Agency ID"/>
                                            <h:outputText id="agency_id"  value="#{immigration.agencyperms.agencyId}" />
                                        </h:panelGrid>
                                        <h:commandButton value=" Topup " action="#{immigration.topup2}"/>
                                    </h:form>
                               
                            

                        </rich:panel>

                    </rich:layoutPanel>
                    <rich:layoutPanel position="bottom" width="100%" id="footer" >

                    </rich:layoutPanel>
                </rich:layout>
            </rich:panel>
             <%@include file="include_footer.jsp"%>
        </f:view>
    </body>
</html>
