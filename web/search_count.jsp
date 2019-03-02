<%-- 
    Document   : search_count
    Created on : Apr 10, 2012, 11:00:03 AM
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
                <rich:layout >
                    <rich:layoutPanel position="top" width="100%" id="header" >
                    </rich:layoutPanel>
                    <rich:layoutPanel position="left" id="menu" width="15%">
                        <%@include file="/left_menu_ad.jsp" %>
                    </rich:layoutPanel>
                    <rich:layoutPanel position="center" id="main_content">

                        <h:form id="abmt_reg_form120" style="width: 860px; margin-right auto; margin-right: auto;   padding:0;">
                            <rich:panel style="background: #ffffff" >
                                <f:facet name="header"><h:outputText value="Agency Search Counts" /></f:facet>
                                <h:message for="abmt_reg_form120" style="color: green"/>

                                <rich:tabPanel >

                                    <rich:tab label="All Searched Records">

                                        <rich:datascroller maxPages="20" id="pinless" for="usertable"/>
                                        <rich:dataTable id="usertable" rows="20" binding="#{immigration.searchtable}"
                                                        onRowMouseOver="this.style.backgroundColor='#F1F1F1'"
                                                        onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
                                                        cellpadding="0" cellspacing="0"
                                                        width="820px" border="2" var="recordlist" value="#{immigration.searchlist}">
                                            <rich:column >
                                                <f:facet name=""><h:outputText value="Picker" /></f:facet>
                                                <h:commandLink value="View Hits"  action="#{immigration.sessionpicker}"/>
                                            </rich:column>
                                            <rich:column >
                                                <f:facet name="header"><h:outputText value="Agency name" /></f:facet>
                                                <h:outputText value="#{recordlist.agencyUser}" />
                                            </rich:column>
                                            <rich:column id="aID" filterBy="#{recordlist.agencyId}">
                                                <f:facet name="header"><h:outputText value="Agency id" /></f:facet>
                                                <h:outputText value="#{recordlist.agencyId}"/>
                                            </rich:column>
                                            <rich:column id="sID" filterBy="#{recordlist.sessionId}">
                                                <f:facet name="header"><h:outputText value="Session id" /></f:facet>
                                                <h:outputText value="#{recordlist.sessionId}"/>
                                            </rich:column>
                                            <rich:column >
                                                <f:facet name="header"><h:outputText value="Search Type" /></f:facet>
                                                <h:outputText value="#{recordlist.searchType}"/>
                                            </rich:column>
                                            <rich:column >
                                                <f:facet name="header"><h:outputText value="Document ID" /></f:facet>
                                                <h:outputText value="#{recordlist.documentId}"/>
                                            </rich:column>
                                            <rich:column >
                                                <f:facet name="header"><h:outputText value="Search Result" /></f:facet>
                                                <h:outputText value="#{recordlist.searchResult}"/>
                                            </rich:column>                                            
                                            <rich:column >
                                                <f:facet name="header"><h:outputText value="Search date" /></f:facet>
                                                <h:outputText value="#{recordlist.searchDate}">
                                                    <f:convertDateTime pattern="yyyy-MM-dd"/>
                                                </h:outputText>
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
