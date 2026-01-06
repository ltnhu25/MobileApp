import 'package:flutter/material.dart';
import '../models/onboarding_model.dart';
import '../widgets/onboarding_layout.dart';
import 'get_started_2.dart';

class GetStarted1 extends StatelessWidget {
  const GetStarted1({super.key});

  @override
  Widget build(BuildContext context) {
    return OnboardingLayout(
      data: OnboardingModel(
        image: 'assets/images/easy_time.png',
        title: 'Easy Time Management',
        description:
            'With management based on priority and daily tasks, it will give you convenience in managing and determining the tasks that must be done first.',
        buttonText: 'Next',
      ),
      onNext: () {
        Navigator.push(
          context,
          MaterialPageRoute(builder: (_) => const GetStarted2()),
        );
      },
    );
  }
}
