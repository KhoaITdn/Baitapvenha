function solveLinearEquation(a, b) {
    if (a === 0) {
        return "Phương trình không phải là phương trình bậc 1.";
    } else {
        return -b / a;
    }
}

var a = 3; // Hệ số a
var b = 6; // Hệ số b
var solution = solveLinearEquation(a, b);
console.log("Nghiệm của phương trình là: x = " + solution);
