<%--
    Document   : test
    Created on : Apr 16, 2012, 4:02:08 PM
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
                            <f:facet name="header"><h:outputText  styleClass="headings_lines" value="IPRS API Search System"/></f:facet>
                            <h:form id="form_1">
                                <h:message for="form_1" style="color: red"/>
                                <h:panelGrid columns="2">
                                    <h:outputLabel  styleClass="text" value="Enter National ID Number to search" /><br>
                                    <h:inputText value="#{immigration.searchString}" required="true" requiredMessage="insert the id to search" /><br>
                                    <h:outputLabel  styleClass="text" value="Enter ID Serial Number to search" /><br>
                                    <h:inputText value="#{immigration.serial}" required="true" requiredMessage="insert the serial to search" /><br>
                                    <h:commandButton value="search" action="#{immigration.searchadmin}" />
                                    <h:commandButton value=" Add To Whitelist " action="#{immigration.addwhitelistadmin}"/><br>
                                </h:panelGrid>
                            </h:form>
                            <h:form id="from2" style="width:760px">
                                <h:message for="from2" style="color: red"/>
                                <rich:tabPanel>
                                    <rich:tab styleClass="headings_lines" label="ID details">
                                        <div class="pages_container">
                                            <h:panelGrid columns="1">
                                                <h:panelGrid styleClass="photo_img" >
                                                    <a4j:mediaOutput element="img" createContent="#{immigration.paint}"  style="width:200px; height:200px;" cacheable="false" />
                                                </h:panelGrid>
                                                <h:panelGrid columns="2" styleClass="text" >
                                                    <h:outputText value="First name:" > </h:outputText>
                                                    <h:outputText  rendered="true" value="#{immigration.human.name}" > </h:outputText>
                                                    <h:outputText rendered="true" value="Surname:" ></h:outputText>
                                                    <h:outputText rendered="true" value="#{immigration.human.surn}" > </h:outputText>
                                                    <h:outputText  rendered="true" value="Last Name:" > </h:outputText>
                                                    <h:outputText rendered="true" value="#{immigration.human.lastName}" > </h:outputText>
                                                    <h:outputText   value="Clan:" > </h:outputText>
                                                    <h:outputText   value="#{immigration.human.clan}" > </h:outputText>
                                                    <h:outputText  value="Family:" > </h:outputText>
                                                    <h:outputText   value="#{immigration.human.family}" > </h:outputText>
                                                    <h:outputText   value="Ethnic:" > </h:outputText>
                                                    <h:outputText   value="#{immigration.human.ethnic}" > </h:outputText>
                                                </h:panelGrid>

                                                <h:panelGrid  columns="1" >
                                                    <h:panelGrid  columns="7">

                                                        <rich:column>
                                                            <h:outputText value="PID" />
                                                        </rich:column>
                                                        <rich:column >
                                                            <h:outputText value="PIN" />
                                                        </rich:column>
                                                        <rich:column >
                                                            <h:outputText value="Gender" />
                                                        </rich:column>
                                                        <rich:column >
                                                            <h:outputText value="Year Of Birth" />
                                                        </rich:column>
                                                        <rich:column >
                                                            <h:outputText value="Birth Month" />
                                                        </rich:column>
                                                        <rich:column >
                                                            <h:outputText value="Birth Day" />
                                                        </rich:column>
                                                        <rich:column >
                                                            <h:outputText value="Date Of Birth" />
                                                        </rich:column>
                                                                                             
                                                        <rich:column >
                                                            <h:outputText  value="#{immigration.human.pid}"  />
                                                        </rich:column>
                                                        <rich:column >
                                                            <h:outputText  value="#{immigration.human.pin}" />
                                                        </rich:column>
                                                        <rich:column >
                                                            <h:outputText  value="#{immigration.human.sex}" />
                                                        </rich:column>
                                                        <rich:column >
                                                            <h:outputText   value="#{immigration.human.yearBirth}"/>
                                                        </rich:column>
                                                        <rich:column >
                                                            <h:outputText   value="#{immigration.human.monthBirth}" />
                                                        </rich:column>
                                                        <rich:column >
                                                            <h:outputText   value="#{immigration.human.dayBirth}" />
                                                        </rich:column>
                                                        <rich:column >
                                                            <h:outputText   value="#{immigration.human.dateBirth}">
                                                                <f:convertDateTime pattern="dd-MM-yyyy"/>
                                                            </h:outputText>
                                                        </rich:column>                                                        



                                                    </h:panelGrid>
                                                </h:panelGrid>
                                                <hr>
                                                <h:panelGrid columns="5">
                                                    
                                                        <rich:column >
                                                            <h:outputText value="Year Of Death" />
                                                        </rich:column>
                                                        <rich:column >
                                                           <h:outputText value="Month Of Death" />
                                                        </rich:column>
                                                        <rich:column>
                                                            <h:outputText value="Day Of Death" />
                                                        </rich:column>
                                                        <rich:column >
                                                            <h:outputText value="Date Of Death" />
                                                        </rich:column>
                                                        <rich:column >
                                                            <h:outputText   value="#{immigration.human.yearDeath}" />
                                                        </rich:column>
                                                        <rich:column >
                                                            <h:outputText   value="#{immigration.human.monthDeath}" />
                                                        </rich:column>
                                                        <rich:column >
                                                            <h:outputText   value="#{immigration.human.dayDeath}" />
                                                        </rich:column>
                                                        <rich:column >
                                                            <h:outputText   value="#{immigration.human.dateDeath}" />
                                                        </rich:column>

                                                </h:panelGrid>
                                                <h:panelGrid columns="1" styleClass="text" >
                                                    <h:outputText  value="Date Created" > </h:outputText>
                                                    <h:outputText  value="#{immigration.human.dateCreated}" >
                                                        <f:convertDateTime pattern="dd-MM-yyyy"/>
                                                    </h:outputText>
                                                    <h:outputText  value="Created By" > </h:outputText>
                                                    <h:outputText  value="#{immigration.human.createdBy}" > </h:outputText>
                                                    <h:outputText   value="Date Modified" > </h:outputText>
                                                    <h:outputText   value="#{immigration.human.dateModified}" > </h:outputText>
                                                    <h:outputText  value="Modified By" > </h:outputText>
                                                    <h:outputText  value="#{immigration.human.modifiedBy}" > </h:outputText>
                                                    <h:outputText  value =""></h:outputText>
                                                </h:panelGrid>                                                
                                            </h:panelGrid>                                            
                                        </div>
                                    </rich:tab>
                                    <rich:tab label="Other Result" rendered="false" styleClass="headings_lines">
                                        <h:panelGrid columns="1">
                                            <h:panelGrid >
                                                <a4j:mediaOutput element="img" createContent="#{immigration.paint3}"  style="width:200px; height:200px;" cacheable="false" />
                                            </h:panelGrid>
                                            <h:panelGrid  columns="1" >
                                                <h:panelGrid  columns="1" styleClass="text">

                                                    <h:outputText   value="RID  : " > </h:outputText>
                                                    <h:outputText value="#{immigration.doubles.rid}" > </h:outputText>
                                                    <h:outputText  value="Gender" > </h:outputText>
                                                    <h:outputText   value="#{immigration.doubles.sex}" > </h:outputText>
                                                    <h:outputText   value="Year Of Birth" > </h:outputText>
                                                    <h:outputText   value="#{immigration.doubles.yearB}" > </h:outputText>
                                                    <h:outputText   value="Month of Birth" > </h:outputText>
                                                    <h:outputText   value="#{immigration.doubles.monthB}" > </h:outputText>
                                                    <h:outputText   value="Day of Birth" > </h:outputText>
                                                    <h:outputText  value="#{immigration.doubles.dayB}" > </h:outputText>
                                                    <h:outputText   value="Citizen" > </h:outputText>
                                                    <h:outputText  value="#{immigration.doubles.citiz}" > </h:outputText>
                                                    <h:outputText  value="Date Created" > </h:outputText>
                                                    <h:outputText  value="#{immigration.doubles.dateMade}" >
                                                        <f:convertDateTime pattern="dd-MM-yyyy"/>
                                                    </h:outputText>
                                                    <h:outputText   value="Date Modified" > </h:outputText>
                                                    <h:outputText   value="#{immigration.doubles.dateMods}" > </h:outputText>
                                                    <h:outputText  value="Created By" > </h:outputText>
                                                    <h:outputText  value="#{immigration.doubles.createdBy}" > </h:outputText>
                                                </h:panelGrid>
                                                <h:panelGrid columns="2" styleClass="text">
                                                    <h:outputText value="First name" ></h:outputText>
                                                    <h:outputText  rendered="true" value="#{immigration.doubles.name}"></h:outputText>
                                                    <h:outputText rendered="true" value="Surname" ></h:outputText>
                                                    <h:outputText rendered="true" value="#{immigration.doubles.surn}" > </h:outputText>
                                                    <h:outputText  rendered="true" value="Last Name" > </h:outputText>
                                                    <h:outputText rendered="true" value="#{immigration.doubles.lastName}" ></h:outputText>
                                                <h4>Two rows and three columns:</h4>
                                                <table border="1">
                                                    <tr>
                                                        <td><h:outputText   value="RID  : " /></td>
                                                        <td><h:outputText   value="Gender  : " /></td>
                                                        <td><h:outputText   value="Year Of Birth" /></td>
                                                    </tr>
                                                    <tr>
                                                        <td><h:outputText value="#{immigration.doubles.rid}" /></td>
                                                        <td><h:outputText value="#{immigration.doubles.sex}" /></td>
                                                        <td><h:outputText   value="#{immigration.doubles.yearB}" /></td>
                                                    </tr>
                                                </table>
                                                </h:panelGrid>
                                            </h:panelGrid>
                                        </h:panelGrid>
                                    </rich:tab>
                                    <rich:tab styleClass="text" label="Passport details">
                                        <h:panelGrid columns="2">
                                            <h:panelGrid >
                                                <a4j:mediaOutput element="img" createContent="#{immigration.paint2}"  style="width:170px; height:200px;" cacheable="false" />
                                            </h:panelGrid>
                                            <h:panelGrid columns="2" styleClass="text" >
                                                <h:outputText value="First name" > </h:outputText>
                                                <h:outputText  rendered="true" value="#{immigration.passport.firstNames}" > </h:outputText>
                                                <h:outputText rendered="true" value="City of birth " ></h:outputText>
                                                <h:outputText rendered="true" value="#{immigration.passport.birthCity}" > </h:outputText>
                                                <h:outputText  rendered="true" value="Birth country" > </h:outputText>
                                                <h:outputText rendered="true" value="#{immigration.passport.birthCountry}" > </h:outputText>
                                                <h:outputText  rendered="true" value="Birth date" > </h:outputText>
                                                <h:outputText rendered="true" value="#{immigration.passport.birthDate}" > </h:outputText>
                                                <h:outputText  rendered="true" value="Birth year" > </h:outputText>
                                                <h:outputText rendered="true" value="#{immigration.passport.birthYear}" > </h:outputText>
                                                <h:outputText  rendered="true" value="Fathers birth place" > </h:outputText>
                                                <h:outputText rendered="true" value="#{immigration.passport.fatherBirthPlace}" > </h:outputText>
                                                <h:outputText  rendered="true" value="Fathers identity card number" > </h:outputText>
                                                <h:outputText rendered="true" value="#{immigration.passport.fatherIdentityCardNo}" > </h:outputText>
                                                <h:outputText  rendered="true" value="Fathers name" > </h:outputText>
                                                <h:outputText rendered="true" value="#{immigration.passport.fatherName}" > </h:outputText>
                                                <h:outputText  rendered="true" value="Fathers passport number" > </h:outputText>
                                                <h:outputText rendered="true" value="#{immigration.passport.fatherPassportNo}" > </h:outputText>
                                                <h:outputText  rendered="true" value="Fathers Kin identity card number" > </h:outputText>
                                                <h:outputText rendered="true" value="#{immigration.passport.firstKinIdentityCardNo}" > </h:outputText>
                                                <h:outputText  rendered="true" value="First kin location" > </h:outputText>
                                                <h:outputText rendered="true" value="#{immigration.passport.firstKinLocation}" > </h:outputText>
                                            </h:panelGrid>
                                        </h:panelGrid>
                                    </rich:tab>
                                </rich:tabPanel>
                            </h:form>
                            <form id="print">
                                <input type="button" value="Print this page" onclick="window.print()">
                            </form>

                        </rich:panel>
                    </rich:layoutPanel>
                </rich:layout>
            </rich:panel>
            <%@include file="include_footer.jsp"%>
        </f:view>
    </div>
</body>
</html>