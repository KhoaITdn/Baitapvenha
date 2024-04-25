function solveQuadraticEquation(a, b, c) {
    var delta = b * b - 4 * a * c;
    if (delta < 0) {
        return "Phương trình vô nghiệm.";
    } else if (delta === 0) {
        return -b / (2 * a);
    } else {
        var x1 = (-b + Math.sqrt(delta)) / (2 * a);
        var x2 = (-b - Math.sqrt(delta)) / (2 * a);
        return [x1, x2];
    }
}

var a = 1; // Hệ số a
var b = -3; // Hệ số b
var c = 2; // Hệ số c
var solution = solveQuadraticEquation(a, b, c);
console.log("Nghiệm của phương trình là: " + solution);
