import 'package:flutter/material.dart';

class OtpInput extends StatelessWidget {
  final void Function(String) onCompleted;

  const OtpInput({super.key, required this.onCompleted});

  @override
  Widget build(BuildContext context) {
    final controllers =
        List.generate(6, (_) => TextEditingController());

    return Row(
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      children: List.generate(6, (index) {
        return SizedBox(
          width: 45,
          child: TextField(
            controller: controllers[index],
            textAlign: TextAlign.center,
            keyboardType: TextInputType.number,
            maxLength: 1,
            decoration: const InputDecoration(
              counterText: "",
              border: OutlineInputBorder(),
            ),
            onChanged: (value) {
              if (value.length == 1 && index < 5) {
                FocusScope.of(context).nextFocus();
              }
              final code = controllers.map((c) => c.text).join();
              if (code.length == 6) {
                onCompleted(code);
              }
            },
          ),
        );
      }),
    );
  }
}
