
<h:form id="abmt_reg_form09"   style="width: 102%; margin-right auto; margin-right: auto;   padding:0; " rendered="#{!immigration.loggedIn}">
    <font size="+1" color="white"> <h2>login</h2></font>
    <h:message for="abmt_reg_form09" style="color: red"/>
    <div align="center">
        <h:panelGrid id="send_to" columns="2" >
            <font size="+1" color="white"> User name</font>
            <h:inputText id="username" value="#{immigration.username}"  />
            <font size="+1" color="white">Secret phrase</font>
            <h:inputSecret id="pass" value="#{immigration.pass}"/>

        </h:panelGrid>
        <h:commandButton value="LOGIN" action="#{immigration.login}"/><br>
        <h:commandLink value="Change Password" action="changepassword2.jsp"/><br>
        <h:commandLink value="Reset Password" action="changepassword3.jsp"/>

    </div>
</h:form>

