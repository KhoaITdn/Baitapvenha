function calculateElectricityBill(units) {
    if (units <= 50) {
        return units * 500; // Giá điện: 500 đồng/kWh
    } else if (units <= 100) {
        return 50 * 500 + (units - 50) * 650; // 50 đơn vị đầu: 500 đồng/kWh, từ đơn vị thứ 51 đến 100: 650 đồng/kWh
    } else if (units <= 200) {
        return 50 * 500 + 50 * 650 + (units - 100) * 850; // 50 đơn vị đầu: 500 đồng/kWh, từ đơn vị thứ 51 đến 100: 650 đồng/kWh, từ đơn vị thứ 101 đến 200: 850 đồng/kWh
    } else {
        return 50 * 500 + 50 * 650 + 100 * 850 + (units - 200) * 1100; // 50 đơn vị đầu: 500 đồng/kWh, từ đơn vị thứ 51 đến 100: 650 đồng/kWh, từ đơn vị thứ 101 đến 200: 850 đồng/kWh, từ đơn vị thứ 201 trở đi: 1100 đồng/kWh
    }
}

var units = 150; // Số lượng điện sử dụng (kWh)
var bill = calculateElectricityBill(units);
console.log("Giá điện: " + bill + " đồng");
