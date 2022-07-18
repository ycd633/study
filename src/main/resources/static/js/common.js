(function(){
    window.ajaxc = (window.ajaxc || function ajaxc(){})

    const REQUEST_WAIT_TIME = 500;
    const LIMIT_REQUEST_RETRY = 1;

    ajaxc.contentType = {
        'json'          : 'application/json; charset=UTF-8',
        'formData'      : 'application/x-www-form-urlencoded; charset=UTF-8',
        'multipart'     : 'multipart/form-data; charset=UTF-8'
    }

    /**
     * callback - 503 / 401 핸들러 추가 필요
     * @param url
     * @param data
     * @param contentType
     * @param callback
     * @param retryObj
     * @param dataType
     */
    ajaxc.get = function get(url, data, contentType, callback, retryObj, dataType)
    {
        let hasCallback = !!(callback);
        let req
        if(dataType !== "binary")
        {
            req = $.ajax({
                type : "GET",
                xhrFields : {
                    'withCredentials' : true
                },
                url : url,
                async : true,
                cache : true,
                statusCode : {
                    404: function() {
                        console.log("Page not Found")
                    },
                    401 : function() {
                        console.log("Authentication fail")
                    }
                },
                //headers : "asdf",
                contentType : contentType,
                data : data,
                dataType : 'text'
            })
        }
        else {
            req = $.ajax({
                type: "GET",
                xhrFields: {
                    'withCredentials': true
                },
                url: url,
                async: true,
                cache: true,
                statusCode: {
                    404: function () {
                        console.log("Page not Found")
                    },
                    401: function () {
                        console.log("Authentication fail")
                    }
                },
                //headers : "asdf",
                contentType: contentType,
                data: data,
                dataType: 'text',
                mimeType: "text/plain; charset=x-user-defined"
            })
        }

        if(hasCallback)
        {
            req = req.then(function(data, textStatus, jqXHR) {
                if (dataType === 'html' || dataType === 'binary') {
                    var json = data || {};
                }
                else
                {
                    var json = jsonParse(data) || {};
                }
                return callback(json, jqXHR.status, true, this ) || json;
            }).fail(function(jqXHR){
                callbak(data, jqXHR.status, false, self);
            })
        }
        return Promise.resolve(req);
    }

    function jsonParse(data)
    {
        try
        {
            return data && JSON.parse(data);
        }catch(err){}
    }




})(window)