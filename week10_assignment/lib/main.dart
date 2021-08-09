import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: MyHomePage(title: 'Flutter Demo Home Page'),
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

  List<String> _dataList = [""];

  final controller = TextEditingController();

  void _addText(){
    setState((){
      _dataList.add(controller.text);
    });
  }

  @override
  Widget build(BuildContext context) {

    return Scaffold(
      appBar: AppBar(

        title: Text(widget.title),
      ),
      body: Center(
        child: Column(
          children: [
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                SizedBox(
                  width: 300,
                  child: TextField(
                      controller: controller
                  ),
                ),
                ElevatedButton(style: ElevatedButton.styleFrom(
                  primary: Colors.blue, // background
                ), onPressed: _addText, child: Text('Put', style: TextStyle(color: Colors.white))),
              ],
            ),

            _buildStaticListView(),

          ],
        ),
      ),
    );
  }

  Widget _buildStaticListView(){
    return ListView.builder(
        scrollDirection: Axis.vertical,
        shrinkWrap: true,
        itemCount: _dataList.length,
        itemBuilder: (BuildContext _ctx, int idx) => Row(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text(_dataList[idx])
          ],
        ),
    );
  }
}
