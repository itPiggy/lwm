/**
 * 查询比较日期
 * 注意：依赖 DateUtil.js
 * return 0：校验通过  1：前日期大于后日期  -1: 有日期为null
 */
function check2Date(beforeDate, afterDate){
    if(!beforeDate || !afterDate){
        return -1;
    }
    let bDate = new Date(beforeDate);
    let aDate = new Date(afterDate);
    if(bDate.cusFormat("yyyy-MM-dd") > aDate.cusFormat("yyyy-MM-dd")){
        return 1;
    }

    return 0;
}

/**
 * 校验空字符串
 * return： true 通过校验（无空串）， false 没有通过校验（有空串）
 */
function checkEmptyString(... strArgs){
    for(let str of strArgs){
        if(!str || str.trim() == ""){
            return false;
        }
    }

    return true;
}

/**
 * 校验字符串的长度
 * return: true 通过（在指定范围内）； false未通过校验
 */
function checkStringLength(str, minLen, maxLen){
    if(!str){
        return false;
    }

    let len = str.length;
    if(len < minLen){
        return false;
    }
    if(len > maxLen){
        return false;
    }

    return true;
}

/**
 * 较远数值的范围
 */
function checkNumRange(targetNum, minNum, maxNum){
    if(!targetNum){
        return false;
    }
    if( targetNum < minNum){
        return false;
    }
    if( targetNum > maxNum){
        return false;
    }
    return true;
}

/**
 * 校验属性是否为空
 * return： true 通过校验（无空串）， false 没有通过校验（有空串）
 * excludeKeys： 不校验的属性
 *
 */
function checkEmptyAttrs(obj, ... excludeKeys) {
    for (let key in obj) {
        if (obj.hasOwnProperty(key) && !excludeKeys.includes(key)) {
            if (obj[key] == null || obj[key] == "") {
                return false;
            }
        }
    }
    return true;
}