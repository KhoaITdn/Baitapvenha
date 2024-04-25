function calculateInterest(principal, months, interestRate) {
    var totalAmount = principal * Math.pow(1 + (interestRate / 100), months);
    var interest = totalAmount - principal;
    return interest;
}

var principal = 1000000; // Số tiền ban đầu (đồng)
var months = 12; // Số tháng cho vay
var interestRate = 0.8; // Lãi suất hàng tháng (%)
var totalInterest = calculateInterest(principal, months, interestRate);
console.log("Lãi ngân hàng sau " + months + " tháng là: " + totalInterest + " đồng");
