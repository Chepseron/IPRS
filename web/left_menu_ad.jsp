
<h:form>

    <h:panelGrid columns="1">
        <h3></h3>
       
        <img src="images/door_out.png" alt="add users" width="32" height="32" border="0">
        <h:commandLink value=" LOGOUT " action="#{immigration.logout}"/>
        <hr>
        <!--<a href="index.jsp"><img src="images/folder_user.png" alt="add users" width="32" height="32" border="0"></a>-->
        <a href="index.jsp">REGISTER AGENCY</a>
        <hr>
        <!--<a href="add_users.jsp"><img src="images/group_add.png" alt="add users" width="32" height="32" border="0"></a>-->
        <a href="add_users.jsp">ADD USER</a>
        <hr>
        
        <!--<a href="billing.jsp"><img src="images/group_edit.png" alt="add users" width="32" height="32" border="0"></a>-->
        <a href="billing.jsp">AUDIT TRAIL</a><!--      (admin and user)-->
        <hr>

        <!--<a href="search_admin.jsp"><img src="images/group_edit.png" alt="add users" width="32" height="32" border="0"></a>-->
        <a href="search_admin.jsp">SEARCH</a>
        <hr>
        <!--<a href="search_count.jsp"><img src="images/group_edit.png" alt="add users" width="32" height="32" border="0"></a>-->
        <a href="search_count.jsp">SEARCH COUNT</a>
        <hr>        
        <!--<a href="white_list.jsp"><img src="images/group_edit.png" alt="add users" width="32" height="32" border="0"></a>-->
        <a href="white_list.jsp">WHITE LIST</a>
        <hr>
        <!--<a href="/."><img src="images/group_edit.png" alt="add users" width="32" height="32" border="0"></a>-->
        <a href="/.">REPORTS</a>
        <hr>
        
    </h:panelGrid>
</h:form>

