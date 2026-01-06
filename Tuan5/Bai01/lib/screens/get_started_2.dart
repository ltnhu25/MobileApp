import 'package:flutter/material.dart';
import '../models/onboarding_model.dart';
import '../widgets/onboarding_layout.dart';
import 'get_started_3.dart';

class GetStarted2 extends StatelessWidget {
  const GetStarted2({super.key});

  @override
  Widget build(BuildContext context) {
    return OnboardingLayout(
      showBack: true,
      data: OnboardingModel(
        image: 'assets/images/increase_work.png',
        title: 'Increase Work Effectiveness',
        description:
            'Time management and determination of important tasks will give your job statistics better and always improve',
        buttonText: 'Next',
      ),
      onNext: () {
        Navigator.push(
          context,
          MaterialPageRoute(builder: (_) => const GetStarted3()),
        );
      },
    );
  }
}
