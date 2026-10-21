# Shoe Size Converter API - Ruby Gem

Shoe Size Converter translates footwear measurements across regional standards, including US, UK, Australian, Mexican, and Korean sizing systems. Provide a size, source region, and gender category to get equivalent sizes, with paid plans adding European, Japanese, and centimeter measurements.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_shoesizeconverter'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_shoesizeconverter
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_shoesizeconverter'

# Initialize the client
client = APIVerve::Shoesizeconverter::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({
  size: "9",
  from: "us",
  gender: "unisex"
})

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ size: "9", from: "us", gender: "unisex" })
  puts response["data"]
rescue APIVerve::Shoesizeconverter::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Shoesizeconverter::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Shoesizeconverter::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
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

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/shoesizeconverter?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/shoesizeconverter?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/shoesizeconverter?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
