import 'package:flutter/material.dart';
import 'screens/forget_password_screen.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'SmartTasks',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const ForgetPasswordScreen(),
    );
  }
}
