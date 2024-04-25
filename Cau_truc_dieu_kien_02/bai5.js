function calculateTriangleArea(sideA, sideB) {
    return (sideA * sideB) / 2;
}

var sideA = 3; // Cạnh góc vuông a
var sideB = 4; // Cạnh góc vuông b
var area = calculateTriangleArea(sideA, sideB);
console.log("Diện tích tam giác vuông là: " + area);
