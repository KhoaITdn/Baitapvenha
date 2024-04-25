// xac dinh lap o dau

let example = "" ;
for(let i=1 ; i<10;i++){
    example += "<tr>";
    for(let j =1 ; j < 10; j++){
        example += "<td>" + j + "x" + i + " = " + (i * j);
        example += "</td>";
    }
    example += "</tr>"
}
 document.getElementById("main").innerHTML= example