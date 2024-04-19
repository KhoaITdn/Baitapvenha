<script>
  const physics = parseFloat(prompt("Nhập điểm Vật lý:"));
  const chemistry = parseFloat(prompt("Nhập điểm Hóa học:"));
  const biology = parseFloat(prompt("Nhập điểm Sinh học:"));

  const totalScore = physics + chemistry + biology;
  const averageScore = totalScore / 3;

  document.write("Tổng điểm: " + totalScore + "<br>");
  document.write("Điểm trung bình: " + averageScore);
</script>