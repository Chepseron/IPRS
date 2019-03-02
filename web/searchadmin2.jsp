
<%@include file="include_IPRSheader.jsp" %>
<body>
    <f:view>
        <div id="main_container">
            <div id="top_part">
                <div class="navi">
                    <div class="user_id">Welcome:<h:outputText value="#{immigration.username}"/> </div>

                    <div class="navi_bar">
                        <ul class="dropdown dropdown-horizontal">
                            <li><a href="./" class="dir">User Configuration</a><ul>
                                    <li><a href="changepassword2.jsp">Change Password</a></li></ul>
                        </ul>
                    </div>
                </div>
            </div>

            <%@include file="welcomeJSF_login.jsp"%>
            <rich:panel style="background: transparent" rendered="#{immigration.loggedIn}">
                <rich:layout >
                    <rich:layoutPanel position="left" width="100%" id="left" >
                        <%@include file="/left_menu_ad.jsp" %>
                    </rich:layoutPanel>
                    <rich:layoutPanel position="center" width="400%" id ="main" >
                        <rich:panel style="background: transparent">
                            <f:facet name="header"><h:outputText value="IPRS API Search System"/></f:facet>                           
                            <h:form id="from2" style="width:800px">
                                <h:message for="from2" style="color: red"/>                                      
                                <h:panelGrid>
                                    <rich:tabPanel>
                                        <rich:tab label="ID details">
                                            <rich:datascroller maxPages="200" id="pinless123" for="usertable5"/>
                                            <rich:dataTable id="usertable5" rows="20" binding="#{immigration.humantable}"
                                                            onRowMouseOver="this.style.backgroundColor='#F1F1F1'"
                                                            onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
                                                            cellpadding="0" cellspacing="0"
                                                            width="700px" border="2" var="userlist" value="#{immigration.humanlist2}">
                                                <rich:column >
                                                    <f:facet name="header"><h:outputText value="Detail" /></f:facet>
                                                    <h:commandLink value="Detail"  action="#{immigration.detail}"/>
                                                </rich:column>

                                                <rich:column >
                                                    <f:facet name="header"><h:outputText value="Name" /></f:facet>
                                                    <h:outputText value="#{userlist.name}" />
                                                </rich:column>
                                                <rich:column >
                                                    <f:facet name="header"><h:outputText value="Surname" /></f:facet>
                                                    <h:outputText value="#{userlist.surn}" />
                                                </rich:column>
                                                <rich:column >
                                                    <f:facet name="header"><h:outputText value="Lastname" /></f:facet>
                                                    <h:outputText value="#{userlist.lastName}" />
                                                </rich:column>


                                            </rich:dataTable>
                                        </rich:tab>
                                        <rich:tab label="Other results">
                                            <rich:datascroller maxPages="200" id="doubles" for="doubletable"/>
                                            <rich:dataTable id="doubletable" rows="20" binding="#{immigration.doubletable}"
                                                            onRowMouseOver="this.style.backgroundColor='#F1F1F1'"
                                                            onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
                                                            cellpadding="0" cellspacing="0"
                                                            width="700px" border="2" var="userlist" value="#{immigration.doublist}">
                                                <rich:column >
                                                    <f:facet name="header"><h:outputText value="Detail" /></f:facet>
                                                    <h:commandLink value="Detail"  action="#{immigration.admindoubledetails}"/>
                                                </rich:column>

                                                <rich:column >
                                                    <f:facet name="header"><h:outputText value="First Name" /></f:facet>
                                                    <h:outputText value="#{userlist.name}" />
                                                </rich:column>
                                                <rich:column >
                                                    <f:facet name="header"><h:outputText value="Last Name" /></f:facet>
                                                    <h:outputText value="#{userlist.lastName}" />
                                                </rich:column>
                                            </rich:dataTable>
                                        </rich:tab>
                                        <rich:tab label="Passport Details">
                                            <rich:datascroller maxPages="200" id="pin" for="usertabl"/>
                                            <rich:dataTable id="usertabl" rows="20" binding="#{immigration.passportable}"
                                                            onRowMouseOver="this.style.backgroundColor='#F1F1F1'"
                                                            onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
                                                            cellpadding="0" cellspacing="0"
                                                            width="700px" border="2" var="userlist" value="#{immigration.passportlist}">                                              
                                                <rich:column >
                                                    <f:facet name="header"><h:outputText value="Detail" /></f:facet>
                                                    <h:commandLink value="Detail"  action="#{immigration.passportdetail2}"/>
                                                </rich:column>

                                                <rich:column >
                                                    <f:facet name="header"><h:outputText value="Name" /></f:facet>
                                                    <h:outputText value="#{userlist.firstNames}" />
                                                </rich:column>
                                                <rich:column >
                                                    <f:facet name="header"><h:outputText value="Surname" /></f:facet>
                                                    <h:outputText value="#{userlist.lastName}" />
                                                </rich:column>


                                            </rich:dataTable>
                                        </rich:tab>

                                    </rich:tabPanel>
                                </h:panelGrid>
                                <h:commandButton value="back" action="/search_admin.jsp" /><br>

                            </h:form>

                        </rich:panel>
                    </rich:layoutPanel>
                </rich:layout>
            </rich:panel>
            <%@include file="include_footer.jsp"%>
        </f:view>
    </div>
</body>
</html>

