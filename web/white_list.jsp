<%-- 
    Document   : white_list
    Created on : Jun 15, 2012, 10:25:37 AM
    Author     : Ogutu
--%>

<%@include file="include_IPRSheader.jsp" %>
<body>
    <f:view>
    <div id="main_container">
        <div id="top_part">
            <div class="navi">
                <div class="user_id">Welcome: <h:outputText value="#{immigration.username}"/></div>
                <div class="navi_bar">
                    <ul class="dropdown dropdown-horizontal">
                        <li><a href="./" class="dir">User configuration</a><ul>
                                <li><a href="changepassword2.jsp">Change password</a></li></ul>
                    </ul>
                </div>
            </div>
        </div>

            <%@include file="welcomeJSF_login.jsp"%>
            <rich:panel style="background: transparent" rendered="#{immigration.loggedIn}">
                <rich:layout>
                    <rich:layoutPanel position="top" width="80%" id="header"  >

                    </rich:layoutPanel>

                    <rich:layoutPanel position="left" id="menu" width="15%" >
                        <%@include file="/left_menu_ad.jsp" %>
                    </rich:layoutPanel>

                    <rich:layoutPanel position="center" id="main_content" width="850px">
                        <rich:panel style=" border:1">
                            <f:facet name="header">
                                <h:outputText value="WHITE LIST:"></h:outputText>
                                <h:outputText value="#{immigration.agencyperms.agencyId}"></h:outputText>
                            </f:facet>
                            <rich:tabPanel>

                                <rich:tab  label="White List Names, IDs" >
                                    <h:form id="abmt_reg_form1" style="width: 800px; margin-right auto; margin-right: auto;   padding:0; " >
                                        <rich:datascroller maxPages="20" id="pinlesscroller67" for="usertable"/>
                                        <rich:dataTable id="usertable" rows="10" binding="#{immigration.deactivate}"
                                                        onRowMouseOver="this.style.backgroundColor='#F1F1F1'"
                                                        onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
                                                        cellpadding="0" cellspacing="0"
                                                        width="820px" border="2" var="record" value="#{immigration.whitellist}">

                                            <rich:column >
                                                <f:facet name="header"><h:outputText value="Manage" /></f:facet>
                                                <h:commandLink value="Remove"  action="#{immigration.Deletewhitelist}"/>
                                            </rich:column>                                            
                                            <rich:column >
                                                <f:facet name="header"><h:outputText value="Name" /></f:facet>
                                                <h:outputText value="#{record.name}" />
                                            </rich:column>
                                            <rich:column >
                                                <f:facet name="header"><h:outputText value="ID/PPT Number" /></f:facet>
                                                <h:outputText value="#{record.idPpt}" />
                                            </rich:column>
                                            <rich:column >
                                                <f:facet name="header"><h:outputText value="Agency ID" /></f:facet>
                                                <h:outputText value="#{record.agencyId}" />
                                            </rich:column>                                            
                                            <rich:column>
                                                <f:facet name="header"><h:outputText value="Date Saved" /></f:facet>
                                                <h:outputText value="#{record.dateSaved}" />
                                            </rich:column>
                                        </rich:dataTable>
                                    </h:form>
                                </rich:tab>
                            </rich:tabPanel>
                        </rich:panel>

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
