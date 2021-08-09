import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;

void main(){
  runApp(MyApp());
}

Future<SubwayInfo> fetchInfo()async{
  String url = "http://swopenapi.seoul.go.kr/api/subway/4a416447747379623131397356695074/json/realtimeStationArrival/1/5/성균관대";

  final response = await http.get(url);

  if(response.statusCode == 200){
    print("yes");
    String jsonString = '${response.body}';

    var list = jsonDecode(jsonString)['realtimeArrivalList'] as List;

    var infomap = list[0];

    print(infomap is List);
    print(infomap is Map);
    print(infomap);
    print(infomap['rowNum']);
    print(infomap['subwayHeading']);

       return SubwayInfo.fromJson(infomap);
  }else{
    throw Exception('Failed to load info');
  }
  
}

class SubwayInfo {
  String rowNum;
  String subwayId;
  String trainLineNm;
  String subwayHeading;
  String arvlMsg2;

  SubwayInfo({@required this.rowNum,@required this.subwayId,@required this.trainLineNm,@required this.subwayHeading,@required this.arvlMsg2});

  factory SubwayInfo.fromJson(Map<String, dynamic> json){
    return SubwayInfo(rowNum: json['rowNum'].toString(),
        subwayId: json['subwayId'].toString(),
        trainLineNm: json['trainLineNm'],
        subwayHeading: json['subwayHeading'],
        arvlMsg2: json['arvlMsg2']
    );
  }

}

class MyApp extends StatefulWidget{
  MyApp({Key key}) : super(key:key);

  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp>{
  Future<SubwayInfo> subInfo;

  @override
  void initState(){
    super.initState();
    subInfo = fetchInfo();
  }

  @override
  Widget build(BuildContext context) {

    return MaterialApp(
      title: 'Fetch Data Example',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home : Scaffold(
        appBar: AppBar(
          title: Text('Fetch Data Example'),
        ),
        body: Center(
            child: FutureBuilder<SubwayInfo>(
              future: subInfo,
              builder: (context,snapshot){
                if(snapshot.hasData){
                  return Column(
                    mainAxisAlignment:  MainAxisAlignment.center,
                    children: <Widget>[
                      Text("rowNum : ${snapshot.data.rowNum}"),
                      Text("subwayID : ${snapshot.data.subwayId}"),
                      Text("trainLineNm : ${snapshot.data.trainLineNm}"),
                      Text("subwayHeading : ${snapshot.data.subwayHeading}"),
                      Text("arvlMsg2 : ${snapshot.data.arvlMsg2}")
                    ]
                  );
                }else if(snapshot.hasError){
                  return Text("no_data");
                }
                return CircularProgressIndicator();
              },
            )
        ),
      )
    );
  }

}
