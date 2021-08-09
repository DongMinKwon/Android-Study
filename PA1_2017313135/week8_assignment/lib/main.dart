import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        // This is the theme of your application.
        //
        // Try running your application with "flutter run". You'll see the
        // application has a blue toolbar. Then, without quitting the app, try
        // changing the primarySwatch below to Colors.green and then invoke
        // "hot reload" (press "r" in the console where you ran "flutter run",
        // or simply save your changes to "hot reload" in a Flutter IDE).
        // Notice that the counter didn't reset back to zero; the application
        // is not restarted.
        primarySwatch: Colors.blue,
      ),
      home: MyHomePage(title: 'Week9_assignment'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  MyHomePage({Key key, this.title}) : super(key: key);

  // This widget is the home page of your application. It is stateful, meaning
  // that it has a State object (defined below) that contains fields that affect
  // how it looks.

  // This class is the configuration for the state. It holds the values (in this
  // case the title) provided by the parent (in this case the App widget) and
  // used by the build method of the State. Fields in a Widget subclass are
  // always marked "final".

  final String title;

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  int _counter = 0;

  void _incrementCounter() {
    setState(() {
      // This call to setState tells the Flutter framework that something has
      // changed in this State, which causes it to rerun the build method below
      // so that the display can reflect the updated values. If we changed
      // _counter without calling setState(), then the build method would not be
      // called again, and so nothing would appear to happen.
      _counter++;
    });
  }

  String _name = "Name : steak";
  String _email = "Email : email";
  String password = "qwer1234";
  String path = "assets/images/steak.jpg";
  int num = 0;

  final namecontroller = TextEditingController();
  final emailcontroller = TextEditingController();
  final pwcontroller = TextEditingController();

  bool checkPW(String pw){
    return pw == password;
  }

  void _changeName(){
    if(checkPW(pwcontroller.text)){
      setState(() {
        _name = "Name : " + namecontroller.text;
      });
    }

  }

  void _changeEmail(){
    if(checkPW(pwcontroller.text)){
      setState(() {
        _email = "Email : " + emailcontroller.text;
      });
    }
  }

  void _changeImage() {
    if (checkPW(pwcontroller.text)) {
      setState(() {
        switch (num) {
          case 0:
            path = "assets/images/macaron.jpg";
            num++;
            break;
          case 1:
            path = "assets/images/hamburger.jpg";
            num++;
            break;
          case 2:
            path = "assets/images/melon.jpg";
            num++;
            break;
          case 3:
            path = "assets/images/salad.jpg";
            num++;
            break;
          case 4:
            path = "assets/images/steak.jpg";
            num = 0;
            break;
        }
      });
    }
  }
  @override
  Widget build(BuildContext context) {

    // This method is rerun every time setState is called, for instance as done
    // by the _incrementCounter method above.
    //
    // The Flutter framework has been optimized to make rerunning build methods
    // fast, so that you can just rebuild anything that needs updating rather
    // than having to individually change instances of widgets.
    return Scaffold(
      appBar: AppBar(
        // Here we take the value from the MyHomePage object that was created by
        // the App.build method, and use it to set our appbar title.
        title: Text(widget.title),
      ),
      body: Center(
        // Center is a layout widget. It takes a single child and positions it
        // in the middle of the parent.
        child: Column(

          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Text(
              'Profile Image'
            ),
            Text(
              '$_name',
            ),
            Text(
              '$_email',
            ),
            SizedBox(
              width: 300,
              height: 100,
              child: Image.asset(path),
            ),
            Row(
              children: [
                Text(
                  '  Change Name: ',
                ),
                SizedBox(
                  width : 160,
                  child : TextField(
                    controller: namecontroller,
                  ),
                ),
                ElevatedButton(onPressed: _changeName, child: Text('Change Name')),
              ],

            ),
            Row(
              children: [
                Text(
                  '  Change Email: ',
                ),
                SizedBox(
                  width : 160,
                  child : TextField(
                   controller: emailcontroller,
                  ),
                ),
                ElevatedButton(onPressed: _changeEmail, child: Text('Change Email')),
            ],
            ),
            ElevatedButton(style: ElevatedButton.styleFrom(
              primary: Colors.white, // background
            ), onPressed: _changeImage, child: Text('Change Image', style: TextStyle(color: Colors.blue))),
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
               Text(
                  'password : '
               ),
                SizedBox(
                  width: 200,
                  child : TextField(
                    controller: pwcontroller,
                  ),
                ),
              ],

            ),

          ],

        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: _incrementCounter,
        tooltip: 'Increment',
        child: Icon(Icons.add),
      ), // This trailing comma makes auto-formatting nicer for build methods.
    );
  }
}
