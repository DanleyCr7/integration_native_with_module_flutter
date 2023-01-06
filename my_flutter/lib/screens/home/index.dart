import 'package:flutter/material.dart';
import 'package:get/route_manager.dart';

import '../../routes/route_name.dart';

class Home extends StatefulWidget {
  const Home({Key? key}) : super(key: key);

  @override
  _HomeState createState() => _HomeState();
}

class _HomeState extends State<Home> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Home Page"),
      ),
      body: Center(
          child: Column(
        children: [
          Text('Home'),
          ElevatedButton(
            onPressed: () {
              Get.toNamed(RouteName.secondary);
            },
            child: Text("Ir para tela secondaria"),
          ),
        ],
      )),
    );
  }
}
