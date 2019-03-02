<%@include file="include_IPRSheader.jsp" %>
<body>
    <f:view>
    <div id="main_container">
        <div id="top_part">
            <div class="navi">
                <div class="user_id">Welcome: <h:outputText value="#{immigration.username}"/></div>
                <div class="navi_bar">
                    <ul class="dropdown dropdown-horizontal">
                        <li><a href="./" class="dir">User Configuration</a><ul>
                                <li><a href="changepassword2.jsp">Change Password</a></li></ul>
                    </ul>
                </div>
            </div>
        </div>
        
            <%@include file="welcomeJSF_login.jsp"%>

            <rich:panel style="background: transparent" rendered="#{immigration.loggedIn}" >
                <rich:layout>
                    <rich:layoutPanel position="top" width="80%" id="headerr" >

                    </rich:layoutPanel>

                    <rich:layoutPanel position="left" id="menurrrrrrr" width="15%">
                        <%@include file="/left_menu_ad.jsp" %>
                    </rich:layoutPanel>
                    <hr>
                    <rich:layoutPanel position="center" id="mainjjjjjjj">
                        <h:form id="abmt_reg_form121" style="width: 800px; margin-right auto; margin-right: auto;   padding:0; ">

                            <rich:panel >
                                <rich:tabPanel>
                                    <rich:tab label="QUERY LOG">
                                        
                                        <rich:datascroller maxPages="20" id="pinlesscrolllog" for="usertable"/>
                                        <rich:dataTable id="usertable" rows="20"
                                                        onRowMouseOver="this.style.backgroundColor='#F1F1F1'"
                                                        onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
                                                        cellpadding="0" cellspacing="0"
                                                        width="750px" border="2" var="recordlog" value="#{immigration.loglist}">
                                            <rich:column>
                                                <f:facet name="header"><h:outputText value="Agency ID" /></f:facet>
                                                <h:outputText value="#{recordlog.agencyId}" />
                                            </rich:column>
                                            <rich:column>
                                                <f:facet name="header"><h:outputText value="Agency User" /></f:facet>
                                                <h:outputText value="#{recordlog.agencyUser}" />
                                            </rich:column>
                                            <rich:column>
                                                <f:facet name="header"><h:outputText value="Query Result(id querried)" /></f:facet>
                                                <h:outputText value="#{recordlog.queryResult}"/>
                                            </rich:column>
                                            <rich:column>
                                                <f:facet name="header"><h:outputText value="Query Time" /></f:facet>
                                                <h:outputText value="#{recordlog.queryTime}"/>
                                            </rich:column>
                                            <rich:column>
                                                <f:facet name="header"><h:outputText value="Amount Used" /></f:facet>
                                                <h:outputText value="#{recordlog.amountUsed}"/>
                                            </rich:column>


                                        </rich:dataTable>

                                    </rich:tab>
                                    <rich:tab label="ADMINS QUERY LOG">
                                       
                                        <rich:datascroller maxPages="20" id="pinlesscroller672" for="usertablep"/>
                                        <rich:dataTable id="usertablep" rows="20"
                                                    onRowMouseOver="this.style.backgroundColor='#F1F1F1'"
                                                    onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
                                                    cellpadding="0" cellspacing="0"
                                                    width="750px" border="2" var="recordaudit" value="#{immigration.auditlist}">
                                        <rich:column >
                                            <f:facet name="header"><h:outputText value="User ID" /></f:facet>
                                            <h:outputText value="#{recordaudit.userId}" />
                                        </rich:column>
                                        <rich:column >
                                            <f:facet name="header"><h:outputText value="Action Performed" /></f:facet>
                                            <h:outputText value="#{recordaudit.action}"/>
                                        </rich:column>
                                        <rich:column >
                                            <f:facet name="header"><h:outputText value="Time Performed" /></f:facet>
                                            <h:outputText value="#{recordaudit.timestamp}"/>
                                        </rich:column>
                                    </rich:dataTable>
                                
                                    </rich:tab>
                                </rich:tabPanel>
                            </rich:panel>

                        </h:form>

                    </rich:layoutPanel>
                    <rich:layoutPanel position="bottom" width="100%" id="footer" >

                    </rich:layoutPanel>
                </rich:layout>
            </rich:panel>
            <%@include file="include_footer.jsp"%>
        </f:view>

    </div>
</body>
</html>
