function isTriangleSide(a, b, c) {
    return a > 0 && b > 0 && c > 0 && (a + b > c) && (b + c > a) && (a + c > b);
}

var sideA = 3; // Cạnh a
var sideB = 4; // Cạnh b
var sideC = 5; // Cạnh c
if (isTriangleSide(sideA, sideB, sideC)) {
    console.log("Ba số " + sideA + ", " + sideB + ", " + sideC + " là độ dài của cạnh của một tam giác.");
} else {
    console.log("Ba số " + sideA + ", " + sideB + ", " + sideC + " không phải là độ dài của cạnh của một tam giác.");
}
