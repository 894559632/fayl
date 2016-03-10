<script>
    $(function () {
        //float_right_bar St
        $(".float-right-bar li").hover(function () {
            $(this).find(".tooltip").show().animate({"left": "-264px"}, 300);
        }, function () {
            $(this).find(".tooltip").animate({"left": "-300px"},800).hide();
        });
        $(".bar-backtop").on("click", function () {
            $('body,html').animate({scrollTop: 0}, 800);
            return false;
        });
        //    float_right_bar End
    });
</script>

<ul class="float-right-bar">
    <li class="bar-custom">
        <span rel="nofollow" class="spancode"></span>
        <div class="tooltip fade in " style="display: none; left: -290px;">
            <div class="talk">
            	<#if setting??>
                	<img src="${setting.qrCode!''}" alt="<#if setting??>${setting.title!''}-</#if>微信二维码"/>
                </#if>
                <span>泛奥景观微信</span>
                <label>扫一扫，获取更多资讯和服务</label>
            </div>
        </div>
    </li>
    <li class="bar-backtop">
    </li>
</ul>