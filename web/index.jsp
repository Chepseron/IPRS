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
                    <rich:layoutPanel position="top" width="100%" id="header" >
                    </rich:layoutPanel>
                    <rich:layoutPanel position="left" id="menu" width="15%">
                        <%@include file="/left_menu_ad.jsp" %>
                    </rich:layoutPanel>
                    <rich:layoutPanel position="center" id="main_content">

                        <h:form id="abmt_reg_form120" style="width: 860px; margin-right: auto; margin-right: auto;   padding:0;">
                            <rich:panel style="background: #ffffff" >
                                <f:facet name="header"><h:outputText value="Agency Registration" /></f:facet>
                                <h:message for="abmt_reg_form120" style="color: green"/>

                                <rich:tabPanel >

                                    <rich:tab label="VIEW REGISTERED AGENCIES">

                                        <rich:datascroller maxPages="20" id="pinless" for="usertable"/>
                                        <rich:dataTable id="usertable" rows="20" binding="#{immigration.agencytable}"
                                                        onRowMouseOver="this.style.backgroundColor='#F1F1F1'"
                                                        onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
                                                        cellpadding="0" cellspacing="0"
                                                        width="820px" border="2" var="recordlist" value="#{immigration.agencypermlist}">
                                            <rich:column >
                                                <f:facet name="header"><h:outputText value="Manage Users" /></f:facet>
                                                <h:commandLink value="Manage Agency"  action="#{immigration.returnagency}"/>
                                            </rich:column>
                                            <rich:column rendered="false" >
                                                <f:facet name="header"><h:outputText value="Topup" /></f:facet>
                                                <h:commandLink value="Topup"  action="#{immigration.topup}"/>
                                            </rich:column>
                                            <rich:column >
                                                <f:facet name="header"><h:outputText value="Agency Name" /></f:facet>
                                                <h:outputText value="#{recordlist.agencyName}" />
                                            </rich:column>
                                            <rich:column >
                                                <f:facet name="header"><h:outputText value="Agency Id" /></f:facet>
                                                <h:outputText value="#{recordlist.agencyId}"/>
                                            </rich:column>
                                            <rich:column >
                                                <f:facet name="header"><h:outputText value="Amount Payable" /></f:facet>
                                                <h:outputText value="#{recordlist.initialpay}"/>
                                            </rich:column>
                                            <rich:column >
                                                <f:facet name="header"><h:outputText value="Tarrif" /></f:facet>
                                                <h:outputText value="#{recordlist.tariff}"/>
                                            </rich:column>
                                            <rich:column >
                                                <f:facet name="header"><h:outputText value="Expiry Date" /></f:facet>
                                                <h:outputText value="#{recordlist.expiryDate}">
                                                    <f:convertDateTime pattern="yyyy-MM-dd"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column >
                                                <f:facet name="header"><h:outputText value="Debt" /></f:facet>
                                                <h:outputText value="#{recordlist.debt}"/>
                                            </rich:column>
                                        </rich:dataTable>
                                    </rich:tab>
                                    <rich:tab label="BILLING PARAMETERS">

                                        <h:outputLabel value="Assign the user/hits range and their consequent charges..."  style="color:green"/>

                                        <rich:tabPanel>
                                            <rich:tab label="Assign hit ranges and their standing charge">

                                                <h:message for="hits" style="color: red"/>
                                                <h:outputLabel value="HITS"/>
                                                <h:panelGrid id="hit" columns="2">

                                                    <h:outputLabel value="Minimum hits"/>
                                                    <h:inputText value="#{immigration.hits.minimum}" />
                                                    <h:outputLabel value="Maximum hits"/>
                                                    <h:inputText value="#{immigration.hits.maximum}" />
                                                    <h:outputLabel value="Standing charges in shillings"/>
                                                    <h:inputText value="#{immigration.hits.value}" />

                                                    <div align="center"> <h:commandButton value=" save  " action="#{immigration.rangehits}"/></div>
                                                    <div align="center"> <h:commandButton value=" clear  " action="#{immigration.clear}"/></div>
                                                </h:panelGrid>
                                                <hr>
                                                <rich:datascroller maxPages="20" id="pinless1234" for="use"/>
                                                <rich:dataTable id="use" rows="20"
                                                                onRowMouseOver="this.style.backgroundColor='#F1F1F1'"
                                                                onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
                                                                cellpadding="0" cellspacing="0"
                                                                width="800px" border="2" var="userlist" value="#{immigration.hitlist}">
                                                    <rich:column >
                                                        <f:facet name="header"><h:outputText value="Minimum hits" /></f:facet>
                                                        <h:outputText value="#{userlist.minimum}" />
                                                    </rich:column>
                                                    <rich:column >
                                                        <f:facet name="header"><h:outputText value="Maximum hits" /></f:facet>
                                                        <h:outputText value="#{userlist.maximum}" />
                                                    </rich:column>
                                                    <rich:column >
                                                        <f:facet name="header"><h:outputText value="Standing charge" /></f:facet>
                                                        <h:outputText value="#{userlist.value}" />
                                                    </rich:column>

                                                </rich:dataTable>

                                            </rich:tab>
                                            <rich:tab label="Assign user ranges and their standing charge">

                                                <h:message for="users" style="color: red"/>
                                                <h:outputLabel value="USERS"/>
                                                <h:panelGrid id="user" columns="2">

                                                    <h:outputLabel value="Minimum users"/>
                                                    <h:inputText value="#{immigration.rangeusers.minimum}" />
                                                    <h:outputLabel value="Maximum users"/>
                                                    <h:inputText value="#{immigration.rangeusers.maximum}" />
                                                    <h:outputLabel value="Standing charges in shillings"/>
                                                    <h:inputText value="#{immigration.rangeusers.value}" />
                                                    <div align="center"> <h:commandButton value=" Save  " action="#{immigration.rangeusers}"/></div>
                                                    <div align="center"> <h:commandButton value=" Clear  " action="#{immigration.clear}"/></div>
                                                </h:panelGrid>
                                                <hr>

                                                <rich:datascroller maxPages="20" id="pinless123" for="usertable5"/>
                                                <rich:dataTable id="usertable5" rows="20"
                                                                onRowMouseOver="this.style.backgroundColor='#F1F1F1'"
                                                                onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
                                                                cellpadding="0" cellspacing="0"
                                                                width="800px" border="2" var="userlist" value="#{immigration.userrangelist}">
                                                    <rich:column >
                                                        <f:facet name="header"><h:outputText value="Minimum users" /></f:facet>
                                                        <h:outputText value="#{userlist.minimum}" />
                                                    </rich:column>
                                                    <rich:column >
                                                        <f:facet name="header"><h:outputText value="Maximum users" /></f:facet>
                                                        <h:outputText value="#{userlist.maximum}" />
                                                    </rich:column>
                                                    <rich:column >
                                                        <f:facet name="header"><h:outputText value="Standing charge" /></f:facet>
                                                        <h:outputText value="#{userlist.value}" />
                                                    </rich:column>


                                                </rich:dataTable>

                                                <rich:spacer height="50"/>
                                            </rich:tab>                                            
                                        </rich:tabPanel>
                                    </rich:tab>

                                    <rich:tab label="REGISTER AGENCY">
                                        <h:panelGrid id="heading2" columns="2">
                                            <h:outputLabel value="Please fill in the agency details and assign them priviledges" style="color:green"/>
                                        </h:panelGrid>
                                        <h:panelGrid id="send_to" columns="6" style="width:800px">
                                            <rich:tabPanel>
                                                <rich:tab label="Agency Details">
                                                    <rich:spacer height="50"/>
                                                    <h:panelGrid id="ag" columns="5">

                                                        <h:outputLabel value="Agency Name "/>
                                                        <h:inputText id="a_name" value="#{immigration.agencyperms.agencyName}" />
                                                        <rich:spacer width="50" />
                                                        <h:outputLabel value="Agency Category "/>
                                                        <h:selectOneMenu value="#{immigration.agencyperms.agencyCategory}">
                                                            <f:selectItems value="#{immigration.acat}"/>
                                                        </h:selectOneMenu>
                                                        <h:inputText id="category" rendered="false" value="#{immigration.agencyperms.agencyCategory}" />
                                                        <h:outputLabel value="Agency Description "/>
                                                        <h:inputTextarea id="description"  value="#{immigration.agencyperms.agencyDescription}"  />
                                                        <rich:spacer width="50" />
                                                        <h:outputLabel value="Contact Person *" />
                                                        <h:inputText id="contact_person"  value="#{immigration.agencyperms.contactPerson}"  />

                                                        <h:outputLabel value="Contact Phone"/>
                                                        <h:inputText id="contact_phone"  value="#{immigration.agencyperms.contactPhone}"  />
                                                        <rich:spacer width="50" />
                                                        <h:outputLabel value="Agency ID"/>
                                                        <h:inputText id="agent_id"  value="#{immigration.agencyperms.agencyId}" readonly="false"/>

                                                    </h:panelGrid>
                                                    <rich:spacer height="50"/>
                                                    <hr>
                                                    <div align="center"> <h:commandButton value=" clear  " action="#{immigration.clear}"/></div>
                                                    <rich:spacer height="70"/>

                                                </rich:tab>
                                                <rich:tab label="Agency Priviledges(Biodata)">
                                                    <rich:spacer height="50"/>
                                                    <h:panelGrid id="age" columns="6">

                                                        <rich:spacer width="100" />

                                                        <h:outputLabel value="RID " />
                                                        <h:selectOneRadio id="rid"  value="#{immigration.agencyperms.rid}">
                                                            <f:selectItem itemValue="1" itemLabel="Yes"/>
                                                            <f:selectItem itemValue="0" itemLabel="No"/>
                                                        </h:selectOneRadio>
                                                        <rich:spacer width="200" />
                                                        <h:outputLabel value="PID "/>
                                                        <h:selectOneRadio id="pid"  value="#{immigration.agencyperms.pid}">
                                                            <f:selectItem itemValue="1" itemLabel="Yes"/>
                                                            <f:selectItem itemValue="0" itemLabel="No"/>
                                                        </h:selectOneRadio><br>
                                                        <h:outputLabel value="PIN "/>
                                                        <h:selectOneRadio id="pin"  value="#{immigration.agencyperms.pin}">
                                                            <f:selectItem itemValue="1" itemLabel="Yes"/>
                                                            <f:selectItem itemValue="0" itemLabel="No"/>
                                                        </h:selectOneRadio>
                                                        <rich:spacer width="10" />
                                                        <h:outputLabel value="Name  "/>
                                                        <h:selectOneRadio id="name"  value="#{immigration.agencyperms.name}">
                                                            <f:selectItem itemValue="1" itemLabel="Yes"/>
                                                            <f:selectItem itemValue="0" itemLabel="No"/>
                                                        </h:selectOneRadio><br>
                                                        <h:outputLabel value="Surname "/>
                                                        <h:selectOneRadio id="surn"  value="#{immigration.agencyperms.surn}">
                                                            <f:selectItem itemValue="1" itemLabel="Yes"/>
                                                            <f:selectItem itemValue="0" itemLabel="No"/>
                                                        </h:selectOneRadio>
                                                        <rich:spacer width="10" />
                                                        <h:outputLabel value="Last Name "/>
                                                        <h:selectOneRadio id="last_name"  value="#{immigration.agencyperms.lastName}">
                                                            <f:selectItem itemValue="1" itemLabel="Yes"/>
                                                            <f:selectItem itemValue="0" itemLabel="No"/>
                                                        </h:selectOneRadio><br>
                                                        <h:outputLabel value="Sex "/>
                                                        <h:selectOneRadio id="sex"  value="#{immigration.agencyperms.sex}">
                                                            <f:selectItem itemValue="1" itemLabel="Yes"/>
                                                            <f:selectItem itemValue="0" itemLabel="No"/>
                                                        </h:selectOneRadio>
                                                        <rich:spacer width="10" />
                                                        <h:outputLabel value="Year Of Birth "/>
                                                        <h:selectOneRadio id="yearBirth"  value="#{immigration.agencyperms.yearBirth}">
                                                            <f:selectItem itemValue="1" itemLabel="Yes"/>
                                                            <f:selectItem itemValue="0" itemLabel="No"/>
                                                        </h:selectOneRadio><br>
                                                        <h:outputLabel value="Month of Birth "/>
                                                        <h:selectOneRadio id="monthBirth"  value="#{immigration.agencyperms.monthBirth}">
                                                            <f:selectItem itemValue="1" itemLabel="Yes"/>
                                                            <f:selectItem itemValue="0" itemLabel="No"/>
                                                        </h:selectOneRadio>
                                                        <rich:spacer width="10" />
                                                        <h:outputLabel value="Day of Birth "/>
                                                        <h:selectOneRadio id="dayBirth"  value="#{immigration.agencyperms.dayBirth}">
                                                            <f:selectItem itemValue="1" itemLabel="Yes"/>
                                                            <f:selectItem itemValue="0" itemLabel="No"/>
                                                        </h:selectOneRadio><br>
                                                        <h:outputLabel value="Date of Birth "/>
                                                        <h:selectOneRadio id="dateBirth"  value="#{immigration.agencyperms.dateBirth}">
                                                            <f:selectItem itemValue="1" itemLabel="Yes"/>
                                                            <f:selectItem itemValue="0" itemLabel="No"/>
                                                        </h:selectOneRadio>
                                                        <rich:spacer width="10" />
                                                        <h:outputLabel value="Year of Death "/>
                                                        <h:selectOneRadio id="yearDeath"  value="#{immigration.agencyperms.yearDeath}">
                                                            <f:selectItem itemValue="1" itemLabel="Yes"/>
                                                            <f:selectItem itemValue="0" itemLabel="No"/>
                                                        </h:selectOneRadio>

                                                    </h:panelGrid>
                                                    <rich:spacer height="50"/>
                                                    <hr>
                                                    <div align="center"> <h:commandButton value=" clear  " action="#{immigration.clear}"/></div>
                                                </rich:tab>
                                                <rich:tab label="Agency Privilegdes(biodata,finger details and signature)">

                                                    <rich:spacer height="50"/>
                                                    <h:panelGrid id="sageo" columns="6">
                                                        <rich:spacer width="100"/>
                                                        <h:outputLabel value="Month of Death "/>
                                                        <h:selectOneRadio id="monthDeath"  value="#{immigration.agencyperms.monthDeath}">
                                                            <f:selectItem itemValue="1" itemLabel="Yes"/>
                                                            <f:selectItem itemValue="0" itemLabel="No"/>
                                                        </h:selectOneRadio>
                                                        <rich:spacer width="200" />
                                                        <h:outputLabel value="Day of Death "/>
                                                        <h:selectOneRadio id="dayDeath"  value="#{immigration.agencyperms.dayDeath}">
                                                            <f:selectItem itemValue="1" itemLabel="Yes"/>
                                                            <f:selectItem itemValue="0" itemLabel="No"/>
                                                        </h:selectOneRadio><br>
                                                        <h:outputLabel value="Ethnic "/>
                                                        <h:selectOneRadio id="ethnic"  value="#{immigration.agencyperms.ethnic}">
                                                            <f:selectItem itemValue="1" itemLabel="Yes"/>
                                                            <f:selectItem itemValue="0" itemLabel="No"/>
                                                        </h:selectOneRadio>
                                                        <rich:spacer width="200" />
                                                        <h:outputLabel value="Clan "/>
                                                        <h:selectOneRadio id="clan"  value="#{immigration.agencyperms.clan}">
                                                            <f:selectItem itemValue="1" itemLabel="Yes"/>
                                                            <f:selectItem itemValue="0" itemLabel="No"/>
                                                        </h:selectOneRadio><br>
                                                        <h:outputLabel value="Family "/>
                                                        <h:selectOneRadio id="family"  value="#{immigration.agencyperms.family}">
                                                            <f:selectItem itemValue="1" itemLabel="Yes"/>
                                                            <f:selectItem itemValue="0" itemLabel="No"/>
                                                        </h:selectOneRadio>
                                                        <rich:spacer width="200" />
                                                        <h:outputLabel value="Birth Address "/>
                                                        <h:selectOneRadio id="adrrefBirth"  value="#{immigration.agencyperms.adrrefBirth}">
                                                            <f:selectItem itemValue="1" itemLabel="Yes"/>
                                                            <f:selectItem itemValue="0" itemLabel="No"/>
                                                        </h:selectOneRadio>
                                                        <br>
                                                        <h:outputLabel value="Address Lived "/>
                                                        <h:selectOneRadio id="adrrefLive"  value="#{immigration.agencyperms.adrrefLive}">
                                                            <f:selectItem itemValue="1" itemLabel="Yes"/>
                                                            <f:selectItem itemValue="0" itemLabel="No"/>
                                                        </h:selectOneRadio>
                                                        <rich:spacer width="200" />
                                                        <h:outputLabel value="Address at Death "/>
                                                        <h:selectOneRadio id="adrrefDeath"  value="#{immigration.agencyperms.adrrefDeath}">
                                                            <f:selectItem itemValue="1" itemLabel="Yes"/>
                                                            <f:selectItem itemValue="0" itemLabel="No"/>
                                                        </h:selectOneRadio><br>
                                                        <h:outputLabel value="National ID Number "/>
                                                        <h:selectOneRadio id="opid"  value="#{immigration.agencyperms.opid}">
                                                            <f:selectItem itemValue="1" itemLabel="Yes"/>
                                                            <f:selectItem itemValue="0" itemLabel="No"/>
                                                        </h:selectOneRadio>
                                                        <rich:spacer width="200" />
                                                        <h:outputLabel value="City of Residence "/>
                                                        <h:selectOneRadio id="citiz"  value="#{immigration.agencyperms.citiz}">
                                                            <f:selectItem itemValue="1" itemLabel="Yes"/>
                                                            <f:selectItem itemValue="0" itemLabel="No"/>
                                                        </h:selectOneRadio><br>
                                                        <h:outputLabel value="Finger01"/>
                                                        <h:selectOneRadio id="finger01"  value="#{immigration.agencyperms.finger01}">
                                                            <f:selectItem itemValue="1" itemLabel="Yes"/>
                                                            <f:selectItem itemValue="0" itemLabel="No"/>
                                                        </h:selectOneRadio>
                                                        <rich:spacer width="200" />
                                                        <h:outputLabel value="Finger02 "/>
                                                        <h:selectOneRadio id="finger02"  value="#{immigration.agencyperms.finger02}">
                                                            <f:selectItem itemValue="1" itemLabel="Yes"/>
                                                            <f:selectItem itemValue="0" itemLabel="No"/>
                                                        </h:selectOneRadio><br>
                                                        <h:outputLabel value="Finger03 "/>
                                                        <h:selectOneRadio id="finger03"  value="#{immigration.agencyperms.finger03}">
                                                            <f:selectItem itemValue="1" itemLabel="Yes"/>
                                                            <f:selectItem itemValue="0" itemLabel="No"/>
                                                        </h:selectOneRadio>
                                                        <rich:spacer width="200" />
                                                        <h:outputLabel value="Finger04 "/>
                                                        <h:selectOneRadio id="finger04"  value="#{immigration.agencyperms.finger04}">
                                                            <f:selectItem itemValue="1" itemLabel="Yes"/>
                                                            <f:selectItem itemValue="0" itemLabel="No"/>
                                                        </h:selectOneRadio>
                                                        <br>
                                                        <h:outputLabel value="Finger05 "/>
                                                        <h:selectOneRadio id="finger05"  value="#{immigration.agencyperms.finger05}">
                                                            <f:selectItem itemValue="1" itemLabel="Yes"/>
                                                            <f:selectItem itemValue="0" itemLabel="No"/>
                                                        </h:selectOneRadio>
                                                        <rich:spacer width="200" />
                                                        <h:outputLabel value="Finger06 "/>
                                                        <h:selectOneRadio id="finger06"  value="#{immigration.agencyperms.finger06}">
                                                            <f:selectItem itemValue="1" itemLabel="Yes"/>
                                                            <f:selectItem itemValue="0" itemLabel="No"/>
                                                        </h:selectOneRadio>

                                                    </h:panelGrid>
                                                    <rich:spacer height="50"/>
                                                    <hr>
                                                    <div align="center">
                                                        <h:commandButton value=" clear  " action="#{immigration.clear}"/></div>
                                                    </rich:tab>
                                                    <rich:tab label=" Finger details,photo and occupation">
                                                        <rich:spacer height="50"/>
                                                        <h:panelGrid id="sage" columns="6">
                                                            <rich:spacer width="100" />
                                                            <h:outputLabel value="Finger07 "/>
                                                            <h:selectOneRadio id="finger07"  value="#{immigration.agencyperms.finger07}">
                                                                <f:selectItem itemValue="1" itemLabel="Yes"/>
                                                                <f:selectItem itemValue="0" itemLabel="No"/>
                                                            </h:selectOneRadio>
                                                            <rich:spacer width="200" />
                                                            <h:outputLabel value="Finger08 "/>
                                                            <h:selectOneRadio id="finger08"  value="#{immigration.agencyperms.finger08}">
                                                                <f:selectItem itemValue="1" itemLabel="Yes"/>
                                                                <f:selectItem itemValue="0" itemLabel="No"/>
                                                            </h:selectOneRadio>
                                                        <br>
                                                        <h:outputLabel value="Finger09 "/>
                                                        <h:selectOneRadio id="finger09"  value="#{immigration.agencyperms.finger09}">
                                                            <f:selectItem itemValue="1" itemLabel="Yes"/>
                                                            <f:selectItem itemValue="0" itemLabel="No"/>
                                                        </h:selectOneRadio>
                                                        <rich:spacer width="200" />
                                                        <h:outputLabel value="Finger10 "/>
                                                        <h:selectOneRadio id="finger10"  value="#{immigration.agencyperms.finger10}">
                                                            <f:selectItem itemValue="1" itemLabel="Yes"/>
                                                            <f:selectItem itemValue="0" itemLabel="No"/>
                                                        </h:selectOneRadio>
                                                        <br>
                                                        <h:outputLabel value="Main Finger"/>
                                                        <h:selectOneRadio id="fingermain"  value="#{immigration.agencyperms.fingerMain}">
                                                            <f:selectItem itemValue="1" itemLabel="Yes"/>
                                                            <f:selectItem itemValue="0" itemLabel="No"/>
                                                        </h:selectOneRadio>
                                                        <rich:spacer width="200" />
                                                        <h:outputLabel value="Photo "/>
                                                        <h:selectOneRadio id="photo"  value="#{immigration.agencyperms.photo}">
                                                            <f:selectItem itemValue="1" itemLabel="Yes"/>
                                                            <f:selectItem itemValue="0" itemLabel="No"/>
                                                        </h:selectOneRadio>
                                                        <br>
                                                        <h:outputLabel value="signature "/>
                                                        <h:selectOneRadio id="signature"  value="#{immigration.agencyperms.signature}">
                                                            <f:selectItem itemValue="1" itemLabel="Yes"/>
                                                            <f:selectItem itemValue="0" itemLabel="No"/>
                                                        </h:selectOneRadio>
                                                        <rich:spacer width="200" />
                                                        <h:outputLabel value="DataScan "/>
                                                        <h:selectOneRadio id="dataScan"  value="#{immigration.agencyperms.dataScan}">
                                                            <f:selectItem itemValue="1" itemLabel="Yes"/>
                                                            <f:selectItem itemValue="0" itemLabel="No"/>
                                                        </h:selectOneRadio>
                                                        <br>
                                                        <h:outputLabel value="Date Created "/>
                                                        <h:selectOneRadio id="dateCreated"  value="#{immigration.agencyperms.dateCreated}">
                                                            <f:selectItem itemValue="1" itemLabel="Yes"/>
                                                            <f:selectItem itemValue="0" itemLabel="No"/>
                                                        </h:selectOneRadio>
                                                        <rich:spacer width="200" />
                                                        <h:outputLabel value="Date Modified "/>
                                                        <h:selectOneRadio id="dateModified"  value="#{immigration.agencyperms.dateModified}">
                                                            <f:selectItem itemValue="1" itemLabel="Yes"/>
                                                            <f:selectItem itemValue="0" itemLabel="No"/>
                                                        </h:selectOneRadio>
                                                        <br>
                                                        <h:outputLabel value="Modified By "/>
                                                        <h:selectOneRadio id="modifiedBy"  value="#{immigration.agencyperms.modifiedBy}">
                                                            <f:selectItem itemValue="1" itemLabel="Yes"/>
                                                            <f:selectItem itemValue="0" itemLabel="No"/>
                                                        </h:selectOneRadio>
                                                        <rich:spacer width="200" />
                                                        <h:outputLabel value="Created By "/>
                                                        <h:selectOneRadio id="createdBy"  value="#{immigration.agencyperms.createdBy}">
                                                            <f:selectItem itemValue="1" itemLabel="Yes"/>
                                                            <f:selectItem itemValue="0" itemLabel="No"/>
                                                        </h:selectOneRadio>
                                                        <br>
                                                        <h:outputLabel value="Occupation "/>
                                                        <h:selectOneRadio id="occup"  value="#{immigration.agencyperms.occup}">
                                                            <f:selectItem itemValue="1" itemLabel="Yes"/>
                                                            <f:selectItem itemValue="0" itemLabel="No"/>
                                                        </h:selectOneRadio>
                                                        <rich:spacer width="200" />
                                                        <h:outputLabel value="Date of Death "/>
                                                        <h:selectOneRadio id="dateDeath" value="#{immigration.agencyperms.dateDeath}">
                                                            <f:selectItem itemValue="1" itemLabel="Yes"/>
                                                            <f:selectItem itemValue="0" itemLabel="No"/>
                                                        </h:selectOneRadio>

                                                    </h:panelGrid>
                                                    <rich:spacer height="50"/>
                                                    <hr>
                                                    <div align="center"> <h:commandButton value=" Clear  " action="#{immigration.clear}"/></div>
                                                </rich:tab>
                                                <rich:tab label="Bill">
                                                    <h:outputLabel value="Specify Billing Criteria" style="color:green"/>

                                                    <rich:spacer height="50"/>
                                                    <hr>
                                                    <h:panelGrid id="sagem" columns="2">                                                     
                                                        <h:outputLabel value="1.Tariff type " />
                                                        <h:selectOneMenu  rendered="true"  value="#{immigration.agencyperms.tariff}"  style="width:130px">
                                                            <f:selectItem itemValue="pre_paid" itemLabel="Pre paid"/>
                                                            <f:selectItem itemValue="post_paid" itemLabel="Post paid"/>
                                                        </h:selectOneMenu>

                                                        <h:outputLabel value="2.Tariff base "/>
                                                        <h:selectOneMenu rendered="true"  value="#{immigration.agencyperms.base}" style="width:130px">
                                                            <f:selectItem itemValue="per_user" itemLabel="per user"/>
                                                            <f:selectItem itemValue="per_transaction(fixed)" itemLabel="Per Transaction(fixed)"/>
                                                            <f:selectItem itemValue="per_transaction(tiered)" itemLabel="Per Transaction(tiered)"/>
                                                            <f:selectItem itemValue="fixed(monthly)" itemLabel="Fixed(monthly)"/>
                                                        </h:selectOneMenu>

                                                        <h:outputLabel value="3.Minimum monthly tariff(for fixed(monthly) base) "/>
                                                        <h:inputText   value="#{immigration.agencyperms.initialpay}" />

                                                        <h:outputLabel value="4.Per transaction tiered " />
                                                        <h:selectOneRadio rendered="true"  value="#{immigration.agencyperms.tiered}" >
                                                            <f:selectItem itemValue="yes" itemLabel="Yes"/>
                                                            <f:selectItem itemValue="no" itemLabel="No"/>
                                                        </h:selectOneRadio>

                                                        <h:outputLabel value="5.Billing frequency"/>
                                                        <h:selectOneMenu rendered="true"  value="#{immigration.agencyperms.frequency}" style="width:130px">
                                                            <f:selectItem itemValue="monthly" itemLabel="Monthly"/>
                                                            <f:selectItem itemValue="quarterly" itemLabel="Quarterly"/>
                                                        </h:selectOneMenu>

                                                        <h:outputLabel value="6.Free trial period"/>
                                                        <h:selectOneRadio rendered="true"  value="#{immigration.agencyperms.trial}" >
                                                            <f:selectItem itemValue="yes" itemLabel="Yes"/>
                                                            <f:selectItem itemValue="no" itemLabel="No"/>
                                                        </h:selectOneRadio>

                                                        <h:outputLabel value="7.Suspend account in arrears"/>
                                                        <h:selectOneMenu  rendered="true"  value="#{immigration.agencyperms.suspend}" style="width:130px">
                                                            <f:selectItem itemValue="suspend" itemLabel="Suspend"/>
                                                            <f:selectItem itemValue="override" itemLabel="Override"/>
                                                        </h:selectOneMenu>

                                                        <h:outputLabel value="Standing charge(for transaction(fixed) base 2 above) "/>
                                                        <h:inputText  value="#{immigration.agencyperms.amountQueried}" />
                                                        <rich:spacer height="50"/>

                                                    </h:panelGrid>
                                                    <hr>
                                                    <div align="center">
                                                        <h:commandButton value=" Clear  " action="#{immigration.clear}"/>
                                                        <h:commandButton value=" SAVE  " action="#{immigration.saveagent}"/>
                                                    </div>
                                                </rich:tab>

                                            </rich:tabPanel>

                                        </h:panelGrid>


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
