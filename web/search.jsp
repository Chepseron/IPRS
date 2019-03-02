
<%@include file="include_IPRSheader.jsp" %>
<body>
    <f:view>
        <div id="main_container">
            <div id="top_part">
                <div class="navi">
                    <div class="user_id" >Welcome: <h:outputText value="#{immigration.username}"/></div>

                    <div class="navi_bar">
                        <ul class="dropdown dropdown-horizontal">
                            <li><a href="./" class="dir">User Configuration</a><ul>
                                    <li><a href="changepassword2.jsp">Change Password</a></li></ul>
                        </ul>
                    </div>
                </div>
            </div>


            <%@include file="welcomeJSF_login.jsp"%>
            <rich:panel style="background: transparent; font:+3" rendered="#{immigration.loggedIn}">
                <rich:layout >    
                    <rich:layoutPanel position="left" width="100%" id="left" >
                        <%@include file="/left_menu_user.jsp" %>
                    </rich:layoutPanel>
                    <rich:layoutPanel position="center" width="400%" id ="main" >
                        <rich:panel style="background: transparent">
                            <f:facet name="header"><h:outputText value="IPRS API Search System"/></f:facet>
                            <h:form id="form_add_user" rendered="#{immigration.ADMIN}">
                                <h:message for="form_add_user" style="color: green"/>
                                <rich:tabPanel>
                                    <rich:tab label="Add user">
                                        <h:panelGrid columns="2">
                                            <h:outputLabel value="User ID "/>
                                            <h:inputText id="user"  value="#{immigration.connectusers1.userid}" requiredMessage="please fill in the userid"/>
                                            <h:outputLabel value="Password "/>
                                            <h:inputSecret id="pass" value="#{immigration.connectusers1.password}" requiredMessage="please fill in the password"/>
                                            <h:outputLabel value="Employee ID"/>
                                            <h:inputText id="emp_id"  value="#{immigration.connectusers1.empId}" requiredMessage="employee id required" />
                                            <h:outputLabel value="Please select the role" />
                                            <h:selectOneMenu id="customerCountryCode" rendered="true"  value="#{immigration.connectusers1.roleuser}" requiredMessage="role field required">
                                                <f:selectItem itemValue="" itemLabel="please select the role"/>
                                                <f:selectItem itemValue="sub_user" itemLabel="sub_user"/>
                                                <f:selectItem itemValue="checker" itemLabel="checker"/>
                                            </h:selectOneMenu>
                                            <h:outputLabel value="Agency ID"/>
                                            <h:outputText id="agency_id"  value="#{immigration.agencyperms.agencyId}" />
                                            <h:commandButton value=" SAVE " action="#{immigration.adduser}"/>
                                        </h:panelGrid>
                                    </rich:tab>
                                    <rich:tab  label="Registered Users" >
                                        <rich:datascroller maxPages="200" id="pinlesscroller6700000000" for="usertable"/>
                                        <rich:dataTable id="usertable" rows="10" 
                                                        onRowMouseOver="this.style.backgroundColor='#F1F1F1'"
                                                        onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
                                                        cellpadding="0" cellspacing="0"
                                                        width="740px" border="2" var="record" value="#{immigration.agencyuserlist2}">                           
                                            <rich:column >
                                                <f:facet name="header"><h:outputText value="Password" /></f:facet>
                                                <h:outputText value="#{record.password}" />
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
                                                <f:facet name="header"><h:outputText value="Date created" /></f:facet>
                                                <h:outputText value="#{record.createDate}" />
                                            </rich:column>
                                            <rich:column>
                                                <f:facet name="header"><h:outputText value="Expiry date" /></f:facet>
                                                <h:outputText value="#{record.expiryDate}" />

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
                                    </rich:tab>
                                    <rich:tab label="Audit Trail">
                                        <rich:datascroller maxPages="200" id="tablescroller" for="audittable"/>
                                        <rich:dataTable id="audittable" rows="10"
                                                        onRowMouseOver="this.style.backgroundColor='#F1F1F1'"
                                                        onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
                                                        cellpadding="0" cellspacing="0"
                                                        width="700px" border="2" var="record" value="#{immigration.userloglist}">
                                            <rich:column >
                                                <f:facet name="header"><h:outputText value="Agency Id" /></f:facet>
                                                <h:outputText value="#{record.agencyId}" />
                                            </rich:column>
                                            <rich:column >
                                                <f:facet name="header"><h:outputText value="Agency User" /></f:facet>
                                                <h:outputText value="#{record.agencyUser}" />
                                            </rich:column>
                                            <rich:column >
                                                <f:facet name="header"><h:outputText value="Action Performed/Query Performed" /></f:facet>
                                                <h:outputText value="#{record.queryResult}"/>
                                            </rich:column>
                                            <rich:column >
                                                <f:facet name="header"><h:outputText value="Time Performed" /></f:facet>
                                                <h:outputText value="#{record.queryTime}"/>
                                            </rich:column>
                                        </rich:dataTable>
                                    </rich:tab>
                                </rich:tabPanel>                             
                            </h:form>
                            <h:form id="form_checker" rendered="#{immigration.CHECKER}">
                                <rich:panel>
                                    <rich:datascroller maxPages="200" id="pinlesscroller6700000000" for="usertable"/>
                                    <rich:dataTable id="usertable" rows="10" binding="#{immigration.deactivate}"
                                                    onRowMouseOver="this.style.backgroundColor='#F1F1F1'"
                                                    onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
                                                    cellpadding="0" cellspacing="0"
                                                    width="740px" border="2" var="record" value="#{immigration.agencyuserlist}">

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
                                            <f:facet name="header"><h:outputText value="Password" /></f:facet>
                                            <h:outputText value="#{record.password}" />
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
                                            <f:facet name="header"><h:outputText value="Status" /></f:facet>
                                            <h:outputText value="#{record.status}" />
                                        </rich:column>
                                        <rich:column>
                                            <f:facet name="header"><h:outputText value="Logged" /></f:facet>
                                            <h:outputText value="#{record.logged}" />
                                        </rich:column>
                                    </rich:dataTable>
                                </rich:panel>
                            </h:form>
                            <rich:tabPanel>
                                <rich:tab label="search by id">
                                    <h:form id="form_1">
                                        <h:message for="form_1" style="color: red"/>
                                        <h:panelGrid columns="2">
                                            <h:outputLabel styleClass="text" value="Enter National ID Number to search" /><br>
                                            <h:inputText value="#{immigration.searchString}"/><br>
                                            <h:outputLabel styleClass="text" value="Enter ID Serial Number to search" /><br>
                                            <h:inputText value="#{immigration.serial}" /><br>
                                            <h:commandButton value="search" action="#{immigration.searchByID}" /><br>
                                        </h:panelGrid>

                                    </h:form>
                                    <h:form id="from2" style="width:740px">
                                        <h:message for="from2" style="color: red" styleClass="text"/>
                                        <h:outputText value="#{immigration.error}" style="color: red"/>                                    
                                                <h:panelGrid columns="2">
                                                    <h:panelGrid rendered="#{immigration.PHOTO}">
                                                        <a4j:mediaOutput element="img" createContent="#{immigration.paint}"  style="width:200px; height:200px;" cacheable="false" />
                                                    </h:panelGrid>
                                                    <h:panelGrid  columns="2" >

                                                        <h:panelGrid  columns="2" >
                                                           
                                                            <h:outputLabel  styleClass="text" rendered="#{immigration.PID}" value="PID"/>
                                                            <h:outputText styleClass="text" rendered="#{immigration.PID}"  value="#{immigration.human.pid}"  />
                                                            <h:outputText  styleClass="text" rendered="#{immigration.PIN}"  value="PIN   : " > </h:outputText>
                                                            <h:outputText styleClass="text" rendered="#{immigration.PIN}" value="#{immigration.human.pin}" > </h:outputText>
                                                            <h:outputText styleClass="text" rendered="#{immigration.SEX}"  value="Gender" > </h:outputText>
                                                            <h:outputText styleClass="text" rendered="#{immigration.SEX}"  value="#{immigration.human.sex}" > </h:outputText>
                                                            <h:outputText styleClass="text" rendered="#{immigration.YEARBIRTH}"  value="Year Of Birth" > </h:outputText>
                                                            <h:outputText  styleClass="text" rendered="#{immigration.YEARBIRTH}" value="#{immigration.human.yearBirth}" > </h:outputText>
                                                            <h:outputText styleClass="text" rendered="#{immigration.MONTHBIRTH}"  value="Month of Birth" > </h:outputText>
                                                            <h:outputText  styleClass="text" rendered="#{immigration.MONTHBIRTH}" value="#{immigration.human.monthBirth}" > </h:outputText>
                                                            <h:outputText  styleClass="text" rendered="#{immigration.DAYBIRTH}" value="Day of Birth" > </h:outputText>
                                                            <h:outputText  styleClass="text" rendered="#{immigration.DAYBIRTH}" value="#{immigration.human.dayBirth}" > </h:outputText>
                                                            <h:outputText styleClass="text" rendered="#{immigration.DATEBIRTH}" value="Date of Birth" > </h:outputText>
                                                            <h:outputText styleClass="text" rendered="#{immigration.DATEBIRTH}"  value="#{immigration.human.dateBirth}" > </h:outputText>
                                                            <h:outputText styleClass="text" rendered="#{immigration.YEARDEATH}" value="Year of death" > </h:outputText>
                                                            <h:outputText styleClass="text" rendered="#{immigration.YEARDEATH}"  value="#{immigration.human.yearDeath}" > </h:outputText>
                                                            <h:outputText styleClass="text" rendered="#{immigration.MONTHDEATH}"  value="Month of Death" > </h:outputText>
                                                            <h:outputText styleClass="text" rendered="#{immigration.MONTHDEATH}" value="#{immigration.human.monthDeath}" ></h:outputText>
                                                            <h:outputText styleClass="text" rendered="#{immigration.DAYDEATH}" value="Day of Death" > </h:outputText>
                                                            <h:outputText styleClass="text" rendered="#{immigration.DAYDEATH}" value="#{immigration.human.dayDeath}" > </h:outputText>
                                                            <h:outputText styleClass="text" rendered="#{immigration.ETHNIC}"  value="Ethnic" > </h:outputText>
                                                            <h:outputText styleClass="text" rendered="#{immigration.ETHNIC}"  value="#{immigration.human.ethnic}" > </h:outputText>
                                                            <h:outputText styleClass="text" rendered="#{immigration.CLAN}" value="Clan" > </h:outputText>
                                                            <h:outputText styleClass="text" rendered="#{immigration.CLAN}" value="#{immigration.human.clan}" > </h:outputText>
                                                            <h:outputText styleClass="text" rendered="#{immigration.FAMILY}" value="Family" > </h:outputText>
                                                            <h:outputText styleClass="text" rendered="#{immigration.FAMILY}" value="#{immigration.human.family}" > </h:outputText>                           
                                                            <h:outputText styleClass="text" rendered="#{immigration.DATECREATED}" value="Date Created" > </h:outputText>
                                                            <h:outputText styleClass="text" rendered="#{immigration.DATECREATED}" value="#{immigration.human.dateCreated}" >
                                                                <f:convertDateTime pattern="dd-MM-yyyy"/>
                                                            </h:outputText>
                                                            <h:outputText styleClass="text" rendered="#{immigration.DATEMODIFIED}"  value="Date Modified" > </h:outputText>
                                                            <h:outputText styleClass="text" rendered="#{immigration.DATEMODIFIED}" value="#{immigration.human.dateModified}" > </h:outputText>
                                                            <h:outputText styleClass="text" rendered="#{immigration.MODIFIEDBY}" value="Modified By" > </h:outputText>
                                                            <h:outputText styleClass="text" rendered="#{immigration.MODIFIEDBY}"  value="#{immigration.human.modifiedBy}" > </h:outputText>
                                                            <h:outputText styleClass="text" rendered="#{immigration.CREATEDBY}" value="Created By" > </h:outputText>
                                                            <h:outputText styleClass="text" rendered="#{immigration.CREATEDBY}" value="#{immigration.human.createdBy}" > </h:outputText>
                                                            <h:outputText styleClass="text" rendered="#{immigration.OCUP}"  value="Occupation" > </h:outputText>
                                                            <h:outputText styleClass="text" rendered="#{immigration.OCUP}" value="#{immigration.human.occup}" > </h:outputText>
                                                            <h:outputText styleClass="text" rendered="#{immigration.DATEDEATH}" value="Date of Death" > </h:outputText>
                                                            <h:outputText styleClass="text" rendered="#{immigration.DATEDEATH}" value="#{immigration.human.dateDeath}" > </h:outputText>

                                                        </h:panelGrid>
                                                        <h:panelGrid columns="2" rendered="#{immigration.NAME}" >
                                                            <h:outputText styleClass="text" value="First name" ></h:outputText>
                                                            <h:outputText styleClass="text" rendered="true" value="#{immigration.human.name}"></h:outputText>
                                                            <h:outputText styleClass="text" rendered="true" value="Surname" ></h:outputText>
                                                            <h:outputText styleClass="text" rendered="true" value="#{immigration.human.surn}" > </h:outputText>
                                                            <h:outputText styleClass="text" rendered="true" value="Last Name" > </h:outputText>
                                                            <h:outputText styleClass="text" rendered="true" value="#{immigration.human.lastName}" ></h:outputText>
                                                        </h:panelGrid>
                                                    </h:panelGrid>
                                                </h:panelGrid>                                      
                                    </h:form>
                                </rich:tab>
                                

                            </rich:tabPanel>

                        </rich:panel>
                    </rich:layoutPanel>
                </rich:layout>
            </rich:panel>
            <%@include file="include_footer.jsp"%>
        </f:view>
    </div>
</body>
</html>

