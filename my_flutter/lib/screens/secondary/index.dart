import 'package:flutter/material.dart';

class Secondary extends StatefulWidget {
  const Secondary({Key? key}) : super(key: key);

  @override
  _SecondaryState createState() => _SecondaryState();
}

class _SecondaryState extends State<Secondary> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Secodary"),
      ),
      body: Center(
        child: Text('Secodary'),
      ),
    );
  }
}
