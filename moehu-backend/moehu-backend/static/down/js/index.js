class index {
    constructor() {
        this.appUpdateInfo = {};
        this.iosDownApkUrl = "";
        this.baseUrl = "https://moehu.net/app/tool";
        this.ApiList = {
            checkUpdateUrl: "/Update",
            addUpdateCount: "/addUpdateCount"
        };

        $(".h5_version_r").click(() => this.UpdateCount())
        this.getVersion();
    }


    getVersion() {
        $.ajax({
            type: "post", headers: {"Content-Type": "application/json; charset=utf-8"},
            data: {}, url: `${this.baseUrl}${this.ApiList.checkUpdateUrl}`,
            success: (res) => {
                this.appUpdateInfo = res.data;
                // 设置app版本
                $(".version_num").text(this.appUpdateInfo.update_version);

                $(".app_count span").text(`${this.appUpdateInfo.update_down_count}次`)
               
                // 设置按钮文字
                this.downloadApp() == "ios" 
                    ? $(".down_button").append(`
                        <i class="iconfont icon-ios"></i>
                        <span>H5 访问</span>
                      `)
                    : $(".down_button").append(`
                        <i class="iconfont icon-android"></i>
                        <span>下载并安装</span>
                      `);

                // 点击安装事件
                this.downloadApp() == "ios" 
                  ? $(".down_button").click(() => location.href = this.iosDownApkUrl)
                  : $(".down_button").click(() => {
                      this.UpdateCount();
                  });      

                // 生成二维码
                // $(".app_download").length != 0 ? this.CreatedQrcode() : ''
                // 新版本特性
                this.appUpdateInfo.update_content.split("\n").forEach((v,i) => {
                    $(".update").append(`<li>${v}</li>`)
                });
                // 详细信息
                $(".detailed .update_time").text(`更新时间：${this.appUpdateInfo.update_time}`)
            },
            error: (err) => {
                throw new Error(err)
            }
        })
    }

    UpdateCount() {
        $.ajax({
            type: "post", headers: { "Content-Type": "application/json; charset=utf-8" },
            data: JSON.stringify({ update_id: this.appUpdateInfo.update_id }),
            url: `${this.baseUrl}${this.ApiList.addUpdateCount}`,
            success: (res) => {
                location.href = this.appUpdateInfo.update_down_url
                console.log(res)
            }
        })
    }

    CreatedQrcode() {
        let url = this.downloadApp() == "ios" 
                    ? this.iosDownApkUrl 
                    : this.appUpdateInfo.update_down_url;

        new QRCode("QRCodeNone", {
            text: url,
            width: 128,
            height: 128,
            colorDark : "#000000",
            colorLight : "#ffffff",
            correctLevel : QRCode.CorrectLevel.H
        });
        $("#down_code").append(
            this.convertCanvasToImage($("canvas")[0])
        );
    }

    convertCanvasToImage(canvas){
        var image = new Image();
        image.src = canvas.toDataURL("image/png");
        return image;
    }

    downloadApp() {
        var u = navigator.userAgent;
        var ua = navigator.userAgent.toLowerCase();
        var isAndroid = u.indexOf('Android') > -1 || u.indexOf('Adr') > -1; //android终端 
        var isiOS = !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/); //ios终端 
        return "android"
        // if (isiOS) {
        //     return 'ios';
        // } else if (isAndroid) {
        //     return "android"
        // }
    }
}

new index()