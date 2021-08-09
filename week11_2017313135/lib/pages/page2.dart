import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

class Page2 extends StatelessWidget{

  Widget build(BuildContext context){
    Page2CounterProvider counter = Provider.of<Page2CounterProvider>(context);
    return Scaffold(
      appBar: AppBar(
        title: Text("Page 2"),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text("Hi, welcome to page2"),
            Consumer<Page2CounterProvider>(
              builder: (context, counter, child) => Text(
                '${counter.counter}',
                style: Theme.of(context).textTheme.headline4,
              ),
            ),
          ],
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () => counter.incrementCounter(),
        tooltip: 'Increment',
        child: Icon(Icons.add),
      ),
    );

  }

}

class Page2CounterProvider with ChangeNotifier {
  int _counter;
  get counter => _counter;

  Page2CounterProvider(this._counter);
  void incrementCounter(){
    _counter++;
    notifyListeners();
  }

}