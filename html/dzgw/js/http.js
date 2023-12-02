var fileid = "";

function doPost(url, data, token) {
    // body...
    url = baseurl + url;
    var result;
    $.ajax({
        type: "POST",
        url: url,//请求地址必须带http协议
        headers: { "Content-Type": "application/json", "token": token },
        data: data,
        async: false,//是否异步
        dataType: "json",//固定格式
        // jsonp: "callback",//固定格式
        // jsonpCallback:"flightHandler",//固定格式
        success: function (data) {
            result = data;
        },
        error: function (data) {
            alert("数据获取失败，请稍后重试");
            result = "error";
        }
    });
    return result;
}

function doPostnew(url, data, token) {
    // body...
    url = backurl + url;
    var result;
    $.ajax({
        type: "POST",
        url: url,//请求地址必须带http协议
        headers: { "Content-Type": "application/json", "token": token },
        data: data,
        async: false,//是否异步
        dataType: "json",//固定格式
        // jsonp: "callback",//固定格式
        // jsonpCallback:"flightHandler",//固定格式
        success: function (data) {
            result = data;
        },
        error: function (data) {
            alert("数据获取失败，请稍后重试");
            result = "error";
        }
    });
    return result;
}

//url 内容 权限 vip等级 问题 答案 token
function doTextPost(url, title, introduce, content, fengmian, isread, vip, question, answer, token) {
    // body...
    url = baseurl + url;
    var data = { subscription_title: title, subscription_introduce: introduce, subscription_content: content, subscription_fengmian: fengmian, subscription_isread: isread, subscription_vip: vip, subscription_question: question, subscription_answer: answer };
    var result;
    $.ajax({
        type: "POST",
        url: url,//请求地址必须带http协议
        headers: { "Content-Type": "application/x-www-form-urlencoded", "token": token },
        data: data,
        async: false,//是否异步
        dataType: "json",//固定格式
        // jsonp: "callback",//固定格式
        // jsonpCallback:"flightHandler",//固定格式
        success: function (data) {
            result = data;
        },
        error: function (data) {
            alert("数据获取失败，请稍后重试");
            result = "error";
        }
    });
    return result;
}

//url 内容 权限 vip等级 问题 答案 token
function doTextPost1(url, opus_id, title, introduce, content, fengmian, isread, vip, question, answer, token) {
    // body...
    url = baseurl + url;
    var data = { subscription_id: opus_id, subscription_title: title, subscription_introduce: introduce, subscription_content: content, subscription_fengmian: fengmian, subscription_isread: isread, subscription_vip: vip, subscription_question: question, subscription_answer: answer };
    var result;
    $.ajax({
        type: "POST",
        url: url,//请求地址必须带http协议
        headers: { "Content-Type": "application/x-www-form-urlencoded", "token": token },
        data: data,
        async: false,//是否异步
        dataType: "json",//固定格式
        // jsonp: "callback",//固定格式
        // jsonpCallback:"flightHandler",//固定格式
        success: function (data) {
            result = data;
        },
        error: function (data) {
            alert("数据获取失败，请稍后重试");
            result = "error";
        }
    });
    return result;
}

// 道可道，非常道。名可名，非常名。无名天地之始，有名天地之母，故常无欲以观其妙。常有欲以观其徼。此两者同出而异名，同谓之玄。玄之又玄，众妙之门。

function doAsyncPost(url, data, token) {
    // body...
    var httpheader = "";
    url = baseurl + url;
    var result;
    $.ajax({
        type: "POST",
        url: url,//请求地址必须带http协议
        headers: { "Content-Type": "application/json", "token": token },
        data: data,
        async: true,//是否异步
        dataType: "json",//固定格式
        // jsonp: "callback",//固定格式
        // jsonpCallback:"flightHandler",//固定格式
        success: function (data) {
            result = data;
        },
        error: function (data) {
            alert("数据获取失败，请稍后重试");
            result = "error";
        }
    });
    return result;
}

// 天街小雨润如酥，草色遥看近却无。最是一年春好处，绝胜烟柳满皇都。

function doFilePost(url, file, token) {
    // body...
    var formData = new FormData();
    formData.append("file", file);
    url = baseurl + url;
    var result;
    $.ajax({
        url: url,
        type: "POST",
        data: formData,
        headers: {"token": localStorage.getItem("token")},
        async: false,//是否异步
        processData: false,         // 告诉jQuery不要去处理发送的数据
        contentType: false,        // 告诉jQuery不要去设置Content-Type请求头
        success: function (data) {
            result = data;
            console.log("code:" + data.code);
        },
        error: function (data) {
            alert("数据获取失败，请稍后重试");
            result = data;
        },
        xhr: function () {            //在jquery函数中直接使用ajax的XMLHttpRequest对象
            var xhr = new XMLHttpRequest();
            xhr.upload.addEventListener("progress", function (evt) {
                if (evt.lengthComputable) {
                    var percentComplete = Math.round(evt.loaded * 100 / evt.total);
                    console.log("正在提交." + percentComplete.toString() + '%');        //在控制台打印上传进度
                }
            }, false);
            return xhr;
        }
    });
    return result;
}

function uploadAsyncPost(files,token,url) {
    url = baseurl + url; 
    var formData = new FormData();
    formData.append("file", files);
    $.ajax({
        url: url,
        type: "POST",
        data: formData,
        headers: { "token": token },
        async: false,//是否异步
        processData: false,         // 告诉jQuery不要去处理发送的数据
        contentType: false,        // 告诉jQuery不要去设置Content-Type请求头
        success: function (data) {
            console.log("执行成功：============");
            console.log("图片url", data.data);
            fileid = data.data; 
        },
        error: function (data) {
            alert("数据获取失败，请稍后重试");
            result = data;
        },
        xhr: function () {            //在jquery函数中直接使用ajax的XMLHttpRequest对象
            var xhr = new XMLHttpRequest();
            xhr.upload.addEventListener("progress", function (evt) {
                if (evt.lengthComputable) {
                    var percentComplete = Math.round(evt.loaded * 100 / evt.total);
                    console.log("正在提交." + percentComplete.toString() + '%');        //在控制台打印上传进度
                }
            }, false);
            return xhr;
        }
    });
    return null;
}

// 天下皆知美之为美，斯恶矣；皆知善之为善，斯不善已。故有无相生，难易相成，长短相形，高下相倾，音声相和，前後相随。是以圣人处无为之事，行不言之教。万物作焉而不辞。生而不有，为而不恃，功成而弗居。夫唯弗居，是以不去。 