<%-- 
    Document   : index
    Created on : 23/02/2016, 11:08:40 AM
    Author     : INE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
    <style type="text/css">
        #container {
            height: 500px;
            min-width: 310px;
            max-width: 800px;
            margin: 0 auto;
        }

        .loading {
            margin-top: 10em;
            text-align: center;
            color: gray;
        }
    </style>
    <script type="text/javascript">
        $(function() {

            // Prepare demo data
            var data = [{
                    "hc-key": "mx-3622",
                    "value": 0
                }, {
                    "hc-key": "mx-bc",
                    "value": 1
                }, {
                    "hc-key": "mx-bs",
                    "value": 2
                }, {
                    "hc-key": "mx-so",
                    "value": 3
                }, {
                    "hc-key": "mx-cl",
                    "value": 4
                }, {
                    "hc-key": "mx-na",
                    "value": 5
                }, {
                    "hc-key": "mx-cm",
                    "value": 6
                }, {
                    "hc-key": "mx-qr",
                    "value": 7
                }, {
                    "hc-key": "mx-mx",
                    "value": 8
                }, {
                    "hc-key": "mx-mo",
                    "value": 9
                }, {
                    "hc-key": "mx-df",
                    "value": 10
                }, {
                    "hc-key": "mx-qt",
                    "value": 11
                }, {
                    "hc-key": "mx-tb",
                    "value": 12
                }, {
                    "hc-key": "mx-cs",
                    "value": 13
                }, {
                    "hc-key": "mx-nl",
                    "value": 14
                }, {
                    "hc-key": "mx-si",
                    "value": 15
                }, {
                    "hc-key": "mx-ch",
                    "value": 16,
                    "color":"red"
                }, {
                    "hc-key": "mx-ve",
                    "value": 17
                }, {
                    "hc-key": "mx-za",
                    "value": 18
                }, {
                    "hc-key": "mx-ag",
                    "value": 19
                }, {
                    "hc-key": "mx-ja",
                    "value": 20
                }, {
                    "hc-key": "mx-mi",
                    "value": 21
                }, {
                    "hc-key": "mx-oa",
                    "value": 22
                }, {
                    "hc-key": "mx-pu",
                    "value": 23
                }, {
                    "hc-key": "mx-gr",
                    "value": 24
                }, {
                    "hc-key": "mx-tl",
                    "value": 25
                }, {
                    "hc-key": "mx-tm",
                    "value": 26
                }, {
                    "hc-key": "mx-co",
                    "value": 27
                }, {
                    "hc-key": "mx-yu",
                    "value": 28
                }, {
                    "hc-key": "mx-dg",
                    "value": 29
                }, {
                    "hc-key": "mx-gj",
                    "value": 30
                }, {
                    "hc-key": "mx-sl",
                    "value": 31
                }, {
                    "hc-key": "mx-hg",
                    "value": 32
                }];

            // Initiate the chart
            $('#container').highcharts('Map', {
                title: {
                    text: 'Mapa Ine'
                },
                subtitle: {
                    text: 'México'
                },
                mapNavigation: {
                    enabled: true,
                    buttonOptions: {
                        verticalAlign: 'bottom'
                    }
                },
                colorAxis: {
                    min: 0
                },
                series: [{
                        data: data,
                        mapData: Highcharts.maps['countries/mx/mx-all'],
                        joinBy: 'hc-key',
                        name: 'Cuenta Regresiva',
                        states: {
                            hover: {
                                color: '#BADA55'
                            }
                        },
                        dataLabels: {
                            enabled: true,
                            format: '{point.name}'
                        }
                    }]
            });
        });
    </script>
</head>
<body>
    <script src="https://code.highcharts.com/maps/highmaps.js"></script>
    <script src="https://code.highcharts.com/maps/modules/exporting.js"></script>
    <script src="https://code.highcharts.com/mapdata/countries/mx/mx-all.js"></script>    
    <script src="https://code.highcharts.com/highcharts.js"></script>
    <script src="https://code.highcharts.com/modules/data.js"></script>
    <script src="https://code.highcharts.com/modules/exporting.js"></script>

    <div id="container"></div>


</body>

</body>
</html>
