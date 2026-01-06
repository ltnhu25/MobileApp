import 'package:flutter/material.dart';
import '../models/onboarding_model.dart';
import '../widgets/onboarding_layout.dart';
import 'home_screen.dart';

class GetStarted3 extends StatelessWidget {
  const GetStarted3({super.key});

  @override
  Widget build(BuildContext context) {
    return OnboardingLayout(
      showBack: true,
      data: OnboardingModel(
        image: 'assets/images/reminder.png',
        title: 'Reminder Notification',
        description:
            'The advanced of this application is that it also provides reminders for you so you don\'t forget to keep doing your assignments well and according to the time you have set',
        buttonText: 'Get Started',
      ),
      onNext: () {
        Navigator.pushReplacement(
          context,
          MaterialPageRoute(builder: (_) => const HomeScreen()),
        );
      },
    );
  }
}
