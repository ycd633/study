(function(){
    window.common = (window.common || function common(){})

    const REQUEST_WAIT_TIME = 500;
    const LIMIT_REQUEST_RETRY = 1;

    common.contentType = {
        'json'          : 'application/json; charset=UTF-8',
        'formData'      : 'application/x-www-form-urlencoded; charset=UTF-8',
        'multipart'     : 'multipart/form-data; charset=UTF-8'
    }

    /**
     ajax 보강작업 필요
     **/
    common.ajax = function ajax(url, type, data, contentType, sync, callback, dataType)
    {
        let hasCallback = !!(callback);
        let ajax;
        ajax = $.ajax({
            type            : type
            ,async           : sync
            ,cache           : true
            ,url             : url
            ,contentType     : contentType
            ,data            : data
            ,dataType        : "text"
            ,mimeType        : "text/plain; charset=x-user-defined"
            ,xhrFields       : {
                'withCredentials': true
            }
            ,statusCode      : {
                404: function () {
                    console.log("Page not Found")
                },
                401: function () {
                    console.log("Authentication fail")
                },
                503: function() {
                    console.log("Service Unavailable")
                },
                500: function() {
                    console.log("APi Params Check")
                }
            }

        })

        if(hasCallback)
        {
            ajax = ajax.then(function(data, textStatus, jqXHR)
            {
                let json;
                if(dataType == "String")
                {
                    json = data;
                }
                else
                {
                    json = data && JSON.parse(data) || {};
                }
                return callback(json, jqXHR.status, true, this ) || json;
            }).fail(function(jqXHR)
            {
                var self = this;
                callback(data, jqXHR.status, false, self);
            })
        }
        else
        {
            ajax = ajax.then(function(data, textStatus, jqXHR)
            {
                let json = data;
                if(dataType == "String")
                {
                    json = data;
                }
                else
                {
                    json = data && JSON.parse(data) || {};
                }
                return json;
            }).fail(function(jqXHR)
            {
                var self = this;
                callback(data, jqXHR.status, false, self);
            })
        }
        return Promise.resolve(ajax);
    }

    common.ajax2 = function ajax2(url, type, data, contentType, sync, callback, dataType)
    {
        let hasCallback = !!(callback);
        let ajax;
        ajax = $.ajax({
            type            : type
            ,async           : sync
            ,cache           : true
            ,url             : url
            ,contentType     : contentType
            ,data            : data
            ,dataType        : "json"
            ,xhrFields       : {
                'withCredentials': true
            }
            ,statusCode      : {
                404: function () {
                    console.log("Page not Found")
                },
                401: function () {
                    console.log("Authentication fail")
                },
                503: function() {
                    console.log("Service Unavailable")
                },
                500: function() {
                    console.log("APi Params Check")
                }
            }

        })

        if(hasCallback)
        {
            ajax = ajax.then(function(data, textStatus, jqXHR)
            {
                let json;
                if(dataType == "String")
                {
                    json = data;
                }
                else
                {
                    json = data && JSON.parse(data) || {};
                }
                return callback(json, jqXHR.status, true, this ) || json;
            }).fail(function(jqXHR)
            {
                var self = this;
                callback(data, jqXHR.status, false, self);
            })
        }
        else
        {
            ajax = ajax.then(function(data, textStatus, jqXHR)
            {
                let json = data;
                if(dataType == "String")
                {
                    json = data;
                }
                else
                {
                    json = data && JSON.parse(data) || {};
                }
                return json;
            }).fail(function(jqXHR)
            {
                var self = this;
                callback(data, jqXHR.status, false, self);
            })
        }
        return Promise.resolve(ajax);
    }

    common.getXmlSync = function getXhttpAjax(url, data, contentType, callback)
    {
        var xHttp =new XMLHttpRequest();
        xHttp.open("GET", url, async);
        xHttp.send();
    }

    function jsonParse(data)
    {
        try
        {
            return data && JSON.parse(data) || {};
        }
        catch
        {
            return null;
        }
    }
})(window)