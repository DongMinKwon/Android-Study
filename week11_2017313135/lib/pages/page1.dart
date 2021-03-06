import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

class Page1 extends StatelessWidget{

  Widget build(BuildContext context){
    Page1CounterProvider counter = Provider.of<Page1CounterProvider>(context);
    return Scaffold(
      appBar: AppBar(
        title: Text("Page 1"),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text("Hi, welcome to page1"),
            Consumer<Page1CounterProvider>(
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

class Page1CounterProvider with ChangeNotifier {
  int _counter;
  get counter => _counter;

  Page1CounterProvider(this._counter);
  void incrementCounter(){
    _counter++;
    notifyListeners();
  }

}