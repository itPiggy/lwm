//  对Date的扩展，将 Date 转化为指定格式的String
//  月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
//  年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
//  例子：
//  new Date().cusFormat("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
//  new Date().cusFormat("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18
Date.prototype.cusFormat =  function (fmt) {  // author: meizz
    var o = {
        "M+":  this.getMonth() + 1,  // 月份
        "d+":  this.getDate(),  // 日
        "h+":  this.getHours(),  // 小时
        "m+":  this.getMinutes(),  // 分
        "s+":  this.getSeconds(),  // 秒
        "q+": Math.floor(( this.getMonth() + 3) / 3),  // 季度
        "S":  this.getMilliseconds()  // 毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, ( this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for ( var k  in o)
        if ( new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

//获取前7天的日期
var getWeekStartDay = function(){
    let flag = new Date();
    //向前推七天
    flag.setTime(flag.getTime() - 7 * 24 * 60 * 60 * 1000);

    return flag.cusFormat("yyyy-MM-dd");
}

//获取本月第一天的日期
var getMonthStartDay = function(){
    let flag = new Date();
    //设置一月的第一天
    flag.setDate(1);

    return flag.cusFormat("yyyy-MM-dd");
}

//获取本年第一天的日期
var getYearStartDay = function(){
    let flag = new Date();
    //设置一年的第一天
    flag.setMonth(0, 1);

    return flag.cusFormat("yyyy-MM-dd");
    // return "2024-01-01";
}

var getYearLastDay = function(){
    let flag = new Date();
    //设置一年的第一天
    flag.setMonth(11, 31);

    return flag.cusFormat("yyyy-MM-dd");
}

//根据给定日期向后推指定月份
var getAfterDate = function (startDate, month){
    let currDate = new Date(startDate);
    let endDate = new Date(startDate);
    endDate.setMonth(currDate.getMonth() + month);
    return endDate.cusFormat("yyyy-MM-dd");
}

//获取当天的日期
var getNowDay = function(){
    let flag = new Date();

    return flag.cusFormat("yyyy-MM-dd");
}

//获取当天的日期
var getNowDatetime = function(){
    let flag = new Date();

    return flag.cusFormat("yyyy-MM-dd hh:mm:ss");
}
