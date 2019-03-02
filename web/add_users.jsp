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
                                <h:outputText value="FOR:"></h:outputText>
                                <h:outputText value="#{immigration.agencyperms.agencyId}"></h:outputText>
                            </f:facet>
                            <rich:tabPanel>

                                <rich:tab label="Add User">
                                    <h:form id="abmt_reg_form1" style="width: 800px; margin-right auto; margin-right: auto;   padding:0; " >
                                        <h:panelGrid id="heading2" columns="2">

                                        </h:panelGrid>
                                        <h:message for="abmt_reg_form1" style="color: red"/>
                                        <h:panelGrid id="send_to" columns="2" >
                                            <h:outputLabel value="User ID "/>
                                            <h:inputText id="user"  value="#{immigration.connectusers1.userid}" requiredMessage="please fill in the userid"/>
                                            <h:outputLabel value="Password "/>
                                            <h:inputSecret id="pass" value="#{immigration.connectusers1.password}" requiredMessage="please fill in the password"/>
                                            <h:outputLabel value="Employee ID"/>
                                            <h:inputText id="emp_id"  value="#{immigration.connectusers1.empId}" requiredMessage="employee id required" />
                                            <h:outputLabel value="Please Select The Role" />
                                            <h:selectOneMenu id="customerCountryCode" rendered="true"  value="#{immigration.connectusers1.roleuser}" requiredMessage="role field required">
                                                <f:selectItem itemValue="" itemLabel="Please select the role"/>
                                                <f:selectItem itemValue="user" itemLabel="Agency admin"/>
                                                <f:selectItem itemValue="admin" itemLabel="admin"/>
                                            </h:selectOneMenu>
                                            <h:outputLabel value="Agency ID"/>
                                            <h:outputText id="agency_id"  value="#{immigration.agencyperms.agencyId}" />                               
                                        </h:panelGrid>
                                        <h:commandButton value=" SAVE " action="#{immigration.adduser}"/>
                                    </h:form>
                                </rich:tab>
                                <rich:tab  label="Registered Users" >
                                    <h:form id="ghghgh">
                                        <rich:datascroller maxPages="200" id="pinlesscroller67" for="usertable"/>
                                        <rich:dataTable id="usertable" rows="10" binding="#{immigration.deactivate}"
                                                        onRowMouseOver="this.style.backgroundColor='#F1F1F1'"
                                                        onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
                                                        cellpadding="0" cellspacing="0"
                                                        width="820px" border="2" var="record" value="#{immigration.iconnectuserlist}">

                                            <rich:column >
                                                <f:facet name="header"><h:outputText value="Manage" /></f:facet>
                                                <h:commandLink value="Deactivate"  action="#{immigration.deactivateuser}"/>
                                            </rich:column>
                                            <rich:column >
                                                <f:facet name="header"><h:outputText value="Manage" /></f:facet>
                                                <h:commandLink value="Activate"  action="#{immigration.activateuser}"/>
                                            </rich:column>
                                            <rich:column >
                                                <f:facet name="header"><h:outputText value="Manage" /></f:facet>
                                                <h:commandLink value="Reset"  action="#{immigration.resetpass}"/>
                                            </rich:column>                                            
                                            <rich:column >
                                                <f:facet name="header"><h:outputText value="User ID" /></f:facet>
                                                <h:outputText value="#{record.userid}" />
                                            </rich:column>
                                            <rich:column >
                                                <f:facet name="header"><h:outputText value="Agency ID" /></f:facet>
                                                <h:outputText value="#{record.agencyId}" />
                                            </rich:column>
                                            <rich:column>
                                                <f:facet name="header"><h:outputText value="Employee ID" /></f:facet>
                                                <h:outputText value="#{record.empId}" />
                                            </rich:column>
                                            <rich:column>
                                                <f:facet name="header"><h:outputText value="Date Created" /></f:facet>
                                                <h:outputText value="#{record.createDate}" />

                                            </rich:column>
                                            <rich:column>
                                                <f:facet name="header"><h:outputText value="Expiry Date" /></f:facet>
                                                <h:outputText value="#{record.expiryDate}" />

                                            </rich:column>
                                            <rich:column>
                                                <f:facet name="header"><h:outputText value="Role" /></f:facet>
                                                <h:outputText value="#{record.roleuser}" />
                                            </rich:column>
                                            <rich:column>
                                                <f:facet name="header"><h:outputText value="Status" /></f:facet>
                                                <h:outputText value="#{record.status}" />
                                            </rich:column>
                                            <rich:column>
                                                <f:facet name="header"><h:outputText value="Logged" /></f:facet>
                                                <h:outputText value="#{record.logged}" />
                                            </rich:column>
                                        </rich:dataTable>
                                    </h:form>
                                </rich:tab>
                                <rich:tab label="Top Up Agency">
                                    <h:form id="abmt_reg_form21" style="width: 600px; margin-right auto; margin-right: auto;   padding:0; " >
                                        <h:message for="abmt_reg_form1" style="color: green"/>
                                        <h:panelGrid id="send_to" columns="2" >
                                            <h:outputLabel value="Topup Amount "/>
                                            <h:inputText id="user"  value="#{immigration.agencyperms.initialpay}" requiredMessage="please fill in the initial pay"/>
                                            <h:outputLabel value="Agency ID"/>
                                            <h:outputText id="agency_id"  value="#{immigration.agencyperms.agencyId}" />
                                        </h:panelGrid>
                                        <h:commandButton value=" Topup " action="#{immigration.topup2}"/>
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
