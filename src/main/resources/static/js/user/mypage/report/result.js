
 window.addEventListener("load", () => {
var ctx = document.getElementById('myChart').getContext('2d');
var list = new Array();
list.push("${detail.id}");
//var aaa = list;
    var chart = new Chart(ctx, { // 챠트 종류를 선택 
        type: 'line',
        // 챠트를 그릴 데이타
        data: {
            labels: ['1월', '2월', '3월', '4월', '5월', '6월', '7월'],
            datasets: [{
                label: '데이터 표시 색', backgroundColor: 'transparent', borderColor: 'red',
                data: list
            }]
        }, // 옵션 
        options: {}
    });


    var ctx = document.getElementById('myChart3').getContext('2d');
    var chart = new Chart(ctx, { // 챠트 종류를 선택 
        type: 'radar',
        // 챠트를 그릴 데이타
        data: {
            labels: ['역량', '건강', '취미', '관계', '자산', '생활'],
            datasets: [{
                label: '데이터 표시 색', backgroundColor: 'rgba(75, 192, 192, 0.2)', borderColor: 'green',

                 data: [23, 10, 5, 2, 20, 10]
            }]
        }, // 옵션 
        options: {}
    });


    var ctx = document.getElementById('myChart2');
    var myChart = new Chart(ctx, {
        type: 'bar', data: {
            labels: ['1월', '2월', '3월', '4월', '5월', '6월', '7월'],
            datasets: [{
                label: '데이터 표시 색', data: [12, 19, 3, 5, 2, 3,5],
                backgroundColor: ['rgba(255, 99, 132, 0.2)', 'rgba(54, 162, 235, 0.2)',
                    'rgba(255, 206, 86, 0.2)',
                    'rgba(75, 192, 192, 0.2)',
                    'rgba(153, 102, 255, 0.2)',
                    'rgba(255, 159, 64, 0.2)'],
                borderColor: ['rgba(255, 99, 132, 1)', 'rgba(54, 162, 235, 1)',
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)',
                    'rgba(153, 102, 255, 1)',
                    'rgba(255, 159, 64, 1)'],
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true
                    }
                }]
            }
        }
    });
});