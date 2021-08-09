import 'package:flutter/material.dart';
import 'package:week112017313135/pages/page1.dart';
import 'package:week112017313135/pages/page2.dart';
import 'package:week112017313135/pages/page3.dart';
import 'package:week112017313135/pages/page4.dart';
import 'package:provider/provider.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MultiProvider(
        providers: [
          ChangeNotifierProvider(create: (context) => Page1CounterProvider(0)),
          ChangeNotifierProvider(create: (context) => Page2CounterProvider(0)),
          ChangeNotifierProvider(create: (context) => Page3CounterProvider(0)),
          ChangeNotifierProvider(create: (context) => Page4CounterProvider(0)),
        ],
        child: MaterialApp(
          title: 'Flutter Demo',
          theme: ThemeData(
            primarySwatch: Colors.blue,
          ),
          initialRoute: '/',
          onGenerateRoute: (routerSettings){
            switch(routerSettings.name){
              case '/':
                return MaterialPageRoute(builder: (_) => MyHomePage(title: "Dynamic Routing"));
              case '/page1':
                return MaterialPageRoute(builder: (_) => Page1());
                break;
              case '/page2':
                return MaterialPageRoute(builder: (_) => Page2());
                break;
              case '/page3':
                return MaterialPageRoute(builder: (_) => Page3());
                break;
              case'/page4':
                return MaterialPageRoute(builder: (_) => Page4());
              default:
                return MaterialPageRoute(builder: (_) => MyHomePage(title: "Error Unknown Route!"));
            }
          },



          home: MyHomePage(title: 'Dynamic Routing'),
        )
    );

  }
}

class MyHomePage extends StatelessWidget {
  MyHomePage({Key key, this.title}) : super(key: key);
  final String title;

  @override
  Widget build(BuildContext context) {
    final Page1CounterProvider _counter1 = Provider.of<Page1CounterProvider>(context);
    final Page2CounterProvider _counter2 = Provider.of<Page2CounterProvider>(context);
    final Page3CounterProvider _counter3 = Provider.of<Page3CounterProvider>(context);
    final Page4CounterProvider _counter4 = Provider.of<Page4CounterProvider>(context);

    return Scaffold(
      appBar: AppBar(
        title: Text(title),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            ElevatedButton(
                onPressed: (){
                  Navigator.pushNamed(
                    context,
                    '/page1',
                  );
                },
                child: Text("Move to Page 1")),
            ElevatedButton(
                onPressed: (){
                  Navigator.pushNamed(
                    context,
                    '/page2',
                  );
                },
                child: Text("Move to Page 2")),
            ElevatedButton(
                onPressed: (){
                  Navigator.pushNamed(
                    context,
                    '/page3',
                  );
                },
                child: Text("Move to Page 3")),
            ElevatedButton(
                onPressed: (){
                  Navigator.pushNamed(
                    context,
                    '/page4',
                  );
                },
                child: Text("Move to Page 4")),
            ElevatedButton(
                onPressed: (){
                  Navigator.pushNamed(
                    context,
                    '/unknown',
                  );
                },
                child: Text("Unknown")),
            Consumer<Page1CounterProvider>(
                builder: (context, counter, child) => Text(
                  'Page 1 Count : ${_counter1.counter}',
                  style: Theme.of(context).textTheme.headline5,
                )
            ),
            Consumer<Page2CounterProvider>(
                builder: (context, counter, child) => Text(
                  'Page 2 Count : ${_counter2.counter}',
                  style: Theme.of(context).textTheme.headline5,
                )
            ),
            Consumer<Page3CounterProvider>(
                builder: (context, counter, child) => Text(
                  'Page 3 Count : ${_counter3.counter}',
                  style: Theme.of(context).textTheme.headline5,
                )
            ),
            Consumer<Page4CounterProvider>(
                builder: (context, counter, child) => Text(
                  'Page 4 Count : ${_counter4.counter}',
                  style: Theme.of(context).textTheme.headline5,
                )
            ),
          ],
        ),
      ),
    );
  }
}