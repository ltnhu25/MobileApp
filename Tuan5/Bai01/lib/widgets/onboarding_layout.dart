import 'package:flutter/material.dart';
import '../models/onboarding_model.dart';
import '../utils/app_colors.dart';

class OnboardingLayout extends StatelessWidget {
  final OnboardingModel data;
  final VoidCallback onNext;
  final bool showBack;

  const OnboardingLayout({
    super.key,
    required this.data,
    required this.onNext,
    this.showBack = false,
  });

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Padding(
        padding: const EdgeInsets.all(24),
        child: Column(
          children: [
            const SizedBox(height: 40),

            // Skip
            Align(
              alignment: Alignment.topRight,
              child: Text(
                'skip',
                style: TextStyle(
                  color: AppColors.primary,
                  fontWeight: FontWeight.w500,
                ),
              ),
            ),

            const SizedBox(height: 30),

            // Image
            Image.asset(data.image, height: 250),

            const SizedBox(height: 30),

            // Title
            Text(
              data.title,
              style: const TextStyle(
                fontSize: 22,
                fontWeight: FontWeight.bold,
              ),
            ),

            const SizedBox(height: 12),

            // Description
            Text(
              data.description,
              textAlign: TextAlign.center,
              style: TextStyle(color: AppColors.gray),
            ),

            const Spacer(),

            // Button + Back
            Row(
              children: [
                if (showBack)
                  IconButton(
                    icon: const Icon(Icons.arrow_back),
                    onPressed: () => Navigator.pop(context),
                  ),
                Expanded(
                  child: SizedBox(
                    height: 50,
                    child: ElevatedButton(
                      style: ElevatedButton.styleFrom(
                        backgroundColor: AppColors.primary,
                        shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(25),
                        ),
                      ),
                      onPressed: onNext,
                      child: Text(data.buttonText),
                    ),
                  ),
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }
}
