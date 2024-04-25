function calculateIncomeTax(income) {
    if (income <= 5000000) {
        return 0.05 * income; // Thuế suất: 5%
    } else if (income <= 10000000) {
        return 0.1 * income; // Thuế suất: 10%
    } else {
        return 0.15 * income; // Thuế suất: 15%
    }
}

var income = 8000000; // Thu nhập cá nhân (đồng)
var tax = calculateIncomeTax(income);
console.log("Thuế thu nhập cá nhân: " + tax + " đồng");
