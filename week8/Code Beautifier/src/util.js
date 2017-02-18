/**
 * Created by harrylang on 16/11/11.
 */

/**
 *
 * @param string
 * @param mark
 * @returns {Array}
 */
exports.findAll = function (string, mark) {
    var matches = [];
    var i = string.indexOf(mark);
    while (i !== -1) {
        matches.push(i);
        i = string.indexOf(mark, i + mark.length);
    }
    return matches;
};

/**
 * 
 * @param string
 * @returns {Array|!Array.<number>|*}
 */
exports.computeLineEndings = function (string) {
    var endings = exports.findAll(string, "\n");
    endings.push(string.length);
    return endings;
};

/**
 * 
 * @param array
 * @param object
 * @param comparator
 * @param left
 * @param right
 * @returns {*}
 */
exports.lowerBound = function (array, object, comparator, left, right) {

    function defaultComparator(a, b) {
        return a < b ? -1 : (a > b ? 1 : 0);
    }

    comparator = comparator || defaultComparator;
    var l = left || 0;
    var r = right !== undefined ? right : array.length;
    while (l < r) {
        var m = (l + r) >> 1;
        if (comparator(object, array[m]) > 0) {
            l = m + 1;
        } else {
            r = m;
        }
    }
    return r;
};

/**
 *  
 * @param array
 * @returns {*}
 */
exports.peekLast = function (array) {
    return array[array.length - 1];
};

/**
 * 
 * @param string
 * @returns {boolean}
 */
exports.isWhitespace = function (string) {
    return /^\s*$/.test(string);
};

/**
 * 
 * @param obj
 * @returns {*}
 */
exports.isDom = function (obj) {
    if (typeof HTMLElement === 'object') {
        return obj instanceof HTMLElement;
    } else {
        return obj && typeof obj === 'object' && obj.nodeType === 1 && typeof obj.nodeName === 'string';
    }
};
