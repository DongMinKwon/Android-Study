import 'dart:async';

import 'package:flutter/material.dart';
import 'package:flutter/rendering.dart';
import 'package:flutter/services.dart';

void main() {
  runApp(MyApp());
}

const eventChannel = const EventChannel("com.example.flutter/Rotate");

class RotationEvent{
  final double x;
  final double y;
  final double z;
  RotationEvent(this.x, this.y, this.z);

  @override
  String toString() => "[RotationEvent(x: $x, y: $y, z: $z]";
}

Stream<RotationEvent> _rotationEvents;

Stream<RotationEvent> get rotationEventStream{
  Stream<RotationEvent> rotationEvents = _rotationEvents;
  if(rotationEvents == null){
    rotationEvents = eventChannel.receiveBroadcastStream().map(
            (dynamic event) => RotationEvent(event[0] as double, event[1] as double, event[2] as double)
    );
    _rotationEvents = rotationEvents;
  }

  return rotationEvents;
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(

        primarySwatch: Colors.blue,
      ),
      home: MyHomePage(title: '2017313135_Week13'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  MyHomePage({Key key, this.title}) : super(key: key);

  final String title;

  @override
  _MyHomePageState createState() => _MyHomePageState();
}



class _MyHomePageState extends State<MyHomePage> {

  List<String> _rotationValues;
  StreamSubscription<dynamic> _streamSubscription;

  @override
  void initState(){
    super.initState();
    _streamSubscription = rotationEventStream.listen((RotationEvent event) {
      setState(() {
        _rotationValues = <String>[event.x.toStringAsFixed(3), event.y.toStringAsFixed(3), event.z.toStringAsFixed(3)];
      });
    });
  }

  @override
  void dispose(){
    super.dispose();
    _streamSubscription.cancel();
  }

  @override
  Widget build(BuildContext context) {

    return Scaffold(
      appBar: AppBar(

        title: Text(widget.title),
      ),
      body: Center(
        child: Column(

          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Text(
              'Rotation vector : $_rotationValues',
            ),
          ],
        ),
      ), // This trailing comma makes auto-formatting nicer for build methods.
    );
  }
}
