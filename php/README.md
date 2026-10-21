# Shoe Size Converter API - PHP Package

Shoe Size Converter translates footwear measurements across regional standards, including US, UK, Australian, Mexican, and Korean sizing systems. Provide a size, source region, and gender category to get equivalent sizes, with paid plans adding European, Japanese, and centimeter measurements.

## Installation

Install via Composer:

```bash
composer require apiverve/shoesizeconverter
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Shoesizeconverter\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute([
    'size' => '9',
    'from' => 'us',
    'gender' => 'unisex'
]);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Shoesizeconverter\Client;
use APIVerve\Shoesizeconverter\Exceptions\APIException;
use APIVerve\Shoesizeconverter\Exceptions\ValidationException;

try {
    $response = $client->execute(['size' => '9', 'from' => 'us', 'gender' => 'unisex']);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
```

## Example Response

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

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/shoesizeconverter?utm_source=packagist&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/shoesizeconverter?utm_source=php&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/shoesizeconverter?utm_source=php&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
