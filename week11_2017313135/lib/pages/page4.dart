import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

class Page4 extends StatelessWidget{

  Widget build(BuildContext context){
    Page4CounterProvider counter = Provider.of<Page4CounterProvider>(context);
    return Scaffold(
      appBar: AppBar(
        title: Text("Page 4"),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text("Hi, welcome to page4"),
            Consumer<Page4CounterProvider>(
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

class Page4CounterProvider with ChangeNotifier {
  int _counter;
  get counter => _counter;

  Page4CounterProvider(this._counter);
  void incrementCounter(){
    _counter++;
    notifyListeners();
  }

}