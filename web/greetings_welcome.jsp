<%@include file="include_IPRSheader.jsp" %>
<body>
    <div id="main_container">
        <div id="welcome_container">
            
            <div id="welcome_content">
                <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="1000" height="605" id="FlashID" title="flash">
                    <param name="movie" value="images/IPRS_login.swf" />
                    <param name="quality" value="high" />
                    <param name="wmode" value="opaque" />
                    <param name="swfversion" value="6.0.65.0" />
                    <!-- This param tag prompts users with Flash Player 6.0 r65 and higher to download the latest version of Flash Player. Delete it if you don?t want users to see the prompt. -->
                    <param name="expressinstall" value="Scripts/expressInstall.swf" />
                    <!-- Next object tag is for non-IE browsers. So hide it from IE using IECC. -->
                    <!--[if !IE]>-->
                    <object type="application/x-shockwave-flash" data="images/IPRS_login.swf" width="1000" height="605">
                        <!--<![endif]-->
                        <param name="quality" value="high" />
                        <param name="wmode" value="opaque" />
                        <param name="swfversion" value="6.0.65.0" />
                        <param name="expressinstall" value="Scripts/expressInstall.swf" />
                        <!-- The browser displays the following alternative content for users with Flash Player 6.0 and older. -->
                        <div>
                            <h4>Content on this page requires a newer version of Adobe Flash Player.</h4>
                            <p><a href="http://www.adobe.com/go/getflashplayer"><img src="http://www.adobe.com/images/shared/download_buttons/get_flash_player.gif" alt="Get Adobe Flash player" /></a></p>
                        </div>
                        <!--[if !IE]>-->
                    </object>
                    <!--<![endif]-->
                </object>
                <script type="text/javascript">
                    swfobject.registerObject("FlashID");
                </script>

            </div>
            <div class="welcome_buttons">
                <a href="w/welcomeJSF.jsp"><font size="+3">ENTER</font></a>


            </div>
        </div>
    </div>
</body>