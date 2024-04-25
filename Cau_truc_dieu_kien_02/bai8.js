function checkAge(age) {
    return age > 0 && age < 120;
}

var age = 25; // Tuổi cần kiểm tra
if (checkAge(age)) {
    console.log(age + " là tuổi của một người.");
} else {
    console.log(age + " không phải là tuổi của một người.");
}
