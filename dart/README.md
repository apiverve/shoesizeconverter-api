# Shoe Size Converter API - Dart/Flutter Client

Shoe Size Converter translates footwear measurements across regional standards, including US, UK, Australian, European, Mexican, Korean and Japanese sizing systems. Provide a size, source region, and gender category to get US, UK and Australian equivalents, with paid plans adding European, Mexican, Korean, Japanese, and centimeter measurements.

[![pub package](https://img.shields.io/pub/v/apiverve_shoesizeconverter.svg)](https://pub.dev/packages/apiverve_shoesizeconverter)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [Shoe Size Converter API](https://apiverve.com/marketplace/shoesizeconverter?utm_source=dart&utm_medium=referral&utm_content=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_shoesizeconverter: ^1.2.6
```

Then run:

```bash
dart pub get
# or for Flutter
flutter pub get
```

## Usage

```dart
import 'package:apiverve_shoesizeconverter/apiverve_shoesizeconverter.dart';

void main() async {
  final client = ShoesizeconverterClient('YOUR_API_KEY');

  try {
    final response = await client.execute({
      'size': '9',
      'from': 'us',
      'gender': 'unisex'
    });

    print('Status: ${response.status}');
    print('Data: ${response.data}');
  } catch (e) {
    print('Error: $e');
  }
}
```

## Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "input_size": 9,
    "input_region": "US",
    "gender": "men",
    "conversions": {
      "cm": 29.1,
      "jp": 29.1,
      "us": 9,
      "uk": 8.1,
      "au": 8.1,
      "eu": 43.7,
      "mx": 13.7,
      "kr": 43.7
    },
    "note": "Sizes are approximate and may vary by manufacturer"
  }
}
```

## API Reference

- **API Home:** [Shoe Size Converter API](https://apiverve.com/marketplace/shoesizeconverter?utm_source=dart&utm_medium=referral&utm_content=readme)
- **Documentation:** [docs.apiverve.com/ref/shoesizeconverter](https://docs.apiverve.com/ref/shoesizeconverter?utm_source=dart&utm_medium=referral&utm_content=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme)
