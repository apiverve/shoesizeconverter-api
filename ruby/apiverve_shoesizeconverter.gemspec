# frozen_string_literal: true

Gem::Specification.new do |spec|
  spec.name          = "apiverve_shoesizeconverter"
  spec.version       = "1.2.2"
  spec.authors       = ["APIVerve"]
  spec.email         = ["hello@apiverve.com"]

  spec.summary       = "Shoe Size Converter API - Ruby Client"
  spec.description   = "Shoe Size Converter translates footwear measurements across regional standards, including US, UK, Australian, Mexican, and Korean sizing systems. Provide a size, source region, and gender category to get equivalent sizes, with paid plans adding European, Japanese, and centimeter measurements."
  spec.homepage      = "https://apiverve.com/marketplace/shoesizeconverter?utm_source=ruby&utm_medium=referral&utm_content=homepage"
  spec.license       = "MIT"
  spec.required_ruby_version = ">= 2.7.0"

  spec.metadata["homepage_uri"] = spec.homepage
  spec.metadata["source_code_uri"] = "https://github.com/apiverve/shoesizeconverter-API/tree/main/ruby"
  spec.metadata["changelog_uri"] = "https://apiverve.com/changelog"
  spec.metadata["documentation_uri"] = "https://docs.apiverve.com/ref/shoesizeconverter"

  spec.files = Dir.glob("{lib}/**/*") + %w[README.md LICENSE]
  spec.require_paths = ["lib"]

  spec.add_dependency "faraday", ">= 1.0", "< 3.0"
  spec.add_dependency "faraday-multipart", "~> 1.0"
  spec.add_dependency "json", "~> 2.0"
end
