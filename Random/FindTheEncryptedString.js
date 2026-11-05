/**
 * @param {string} s
 * @param {number} k
 * @return {string}
 */
var getEncryptedString = function(s, k) {
    const shift = k % s.length;
    return s.slice(shift) + s.slice(0, shift);
};
