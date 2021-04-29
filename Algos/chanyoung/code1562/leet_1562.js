// 1562. Find Latest Group of Size M

/*
 * @param {number[]} arr
 * @param {number} m
 * @return {number}
 */

var findLatestStep = function(arr, m) {
    if (m === arr.length) return m;

    let reverseArr = new Array(arr.length + 1).fill(true);

    reverseArr[0] = false
    // [0 ,1, 1, 1, 1, 1]

    let position, flag;

    for (let i = arr.length - 1; i >= 0; i--){
        position = arr[i];
        reverseArr[position] = false;

        flag = true;
        // 현재 position 기준, 왼쪽으로 탐색
        for (let j = 1; j <= m; j++) {
            if (flag) flag = reverseArr[position - j]
            else break;
        }
        if (flag && !reverseArr[position - m - 1]) return i;


        flag = true;
        // 현재 position 기준, 오른쪽으로 탐색
        for (let j = 1; j <= m; j++){
            if (flag) flag = reverseArr[position + j]
            else break;
        }
        if (flag && !reverseArr[position + m + 1]) return i;
    }
    return -1;
};




let arr = [3, 5, 1, 2, 4]
let m = 2;

console.log(findLatestStep(arr,m))
