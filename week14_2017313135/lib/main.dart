import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:flutter/foundation.dart';
import 'dart:async';
import 'dart:convert';

void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget{
  MyApp({Key key}) : super(key:key);

  @override
  MyHomePage createState() => MyHomePage();
}

class MyHomePage extends State<MyApp>{
  int num;

  @override
  void initState() {
    super.initState();
    num = 0;
  }
  @override
  Widget build(BuildContext context){
      return MaterialApp(
        title: "week14_2017313135",
        home: Scaffold(
          appBar: AppBar(
            title: Text("week14_assignment"),
          ),
          body: Column(
              mainAxisAlignment: MainAxisAlignment.start,
              children: [
                Expanded(
                  child: Padding(
                    padding: EdgeInsets.all(10),
                    child: ElevatedButton(
                        style: ElevatedButton.styleFrom(primary: Colors.white, onPrimary: Colors.lightBlueAccent),
                        onPressed: setshownum,
                        child: Text("http request button: $num clicked")),
                  ),
                  flex: 1
                ),
                Expanded(
                  child: Container(
                    child:  FutureBuilder<List<Photo>>(
                      future: fetchPhotos(http.Client()),
                      builder: (context, snapshot){
                        if(snapshot.hasError) print(snapshot.error);
                        return snapshot.hasData ? PhotoList(num, photos: snapshot.data)
                            : Center(child: CircularProgressIndicator());
                      },
                    ),
                  ),
                  flex: 12
                )
              ],
            )


        )
      );
  }

  void setshownum(){
    setState(() {
      num++;
    });
  }

}


class PhotoList extends StatelessWidget{
  final List<Photo> photos;
  int num;

  PhotoList(this.num, {Key key, @required this.photos}) : super(key: key);

  @override
  Widget build(BuildContext context){
    return GridView.builder(
      gridDelegate:SliverGridDelegateWithFixedCrossAxisCount(
          crossAxisCount: 2
      ),
      itemCount:  num * num,
      itemBuilder: (context, index){
        return Image.network(photos[index].thumbnailUrl);
      },
    );
  }
}

Future<List<Photo>> fetchPhotos(http.Client client) async{
  final response = await client
      .get(Uri.parse("https://jsonplaceholder.typicode.com/photos"));

  return compute(parsePhotos, response.body);
}

List<Photo> parsePhotos(String responseBody){
  final parsed = jsonDecode(responseBody).cast<Map<String, dynamic>>();

  return parsed.map<Photo>((json) => Photo.fromJson(json)).toList();
}

class Photo{
  final int albumId;
  final int id;
  final String title;
  final String url;
  final String thumbnailUrl;

  Photo({@required this.albumId, @required this.id, @required this.title, @required this.url, @required this.thumbnailUrl});

  factory Photo.fromJson(Map<String, dynamic> json){
    return Photo(
      albumId: json['albumId'] as int,
      id: json['id'] as int,
      title: json['title'] as String,
      url: json['url'] as String,
      thumbnailUrl: json['thumbnailUrl'] as String,
    );
  }
}
