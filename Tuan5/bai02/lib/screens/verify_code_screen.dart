import 'package:flutter/material.dart';
import '../widgets/otp_input.dart';
import 'create_new_password_screen.dart';
import 'dart:math';

class VerifyCodeScreen extends StatefulWidget {
  final String email;
  const VerifyCodeScreen({super.key, required this.email});

  @override
  State<VerifyCodeScreen> createState() => _VerifyCodeScreenState();
}

class _VerifyCodeScreenState extends State<VerifyCodeScreen> {
  late String generatedOtp;
  String enteredOtp = "";

  @override
  void initState() {
    super.initState();
    generatedOtp = _generateOtp();
    debugPrint("OTP (test): $generatedOtp"); 
  }

  String _generateOtp() {
    final rand = Random();
    return List.generate(6, (_) => rand.nextInt(10)).join();
  }

  void _verifyOtp() {
    if (enteredOtp != generatedOtp) {
      ScaffoldMessenger.of(context).showSnackBar(
        const SnackBar(
          content: Text("OTP is incorrect. Please try again."),
          backgroundColor: Colors.red,
        ),
      );
      return;
    }

    Navigator.push(
      context,
      MaterialPageRoute(
        builder: (_) => CreateNewPasswordScreen(
          email: widget.email,
          otp: generatedOtp,
        ),
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      appBar: AppBar(
        backgroundColor: Colors.white,
        elevation: 0,
        leading: const BackButton(color: Colors.black),
      ),
      body: Padding(
        padding: const EdgeInsets.all(24),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            Center(
              child: Column(
                children: [
                  Image.asset('assets/uth_logo.jpg', height: 70),
                  const SizedBox(height: 8),
                  const Text(
                    "SmartTasks",
                    style: TextStyle(
                      fontSize: 18,
                      fontWeight: FontWeight.w600,
                      color: Colors.blue,
                    ),
                  ),
                ],
              ),
            ),
            const SizedBox(height: 40),
            const Text(
              "Verify Code",
              textAlign: TextAlign.center,
              style: TextStyle(fontSize: 22, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 8),
            Text(
              "We sent a verification code to\n${widget.email}",
              textAlign: TextAlign.center,
              style: const TextStyle(color: Colors.grey),
            ),
           const SizedBox(height: 16),

Container(
  width: double.infinity,
  padding: const EdgeInsets.symmetric(vertical: 12),
  decoration: BoxDecoration(
    color: Colors.blue.shade50,
    borderRadius: BorderRadius.circular(8),
    border: Border.all(color: Colors.blue.shade200),
  ),
  child: Column(
    children: [
      const Text(
        "OTP Code",
        style: TextStyle(
          fontSize: 14,
          color: Colors.grey,
        ),
      ),
      const SizedBox(height: 4),
      Text(
        generatedOtp,
        style: const TextStyle(
          fontSize: 24,
          fontWeight: FontWeight.bold,
          letterSpacing: 4,
          color: Colors.blue,
        ),
      ),
    ],
  ),
),

            /// OTP INPUT
            OtpInput(
              onCompleted: (code) {
                enteredOtp = code;
              },
            ),

            const Spacer(),

            SizedBox(
              height: 48,
              child: ElevatedButton(
                onPressed: _verifyOtp,
                child: const Text("Next"),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
