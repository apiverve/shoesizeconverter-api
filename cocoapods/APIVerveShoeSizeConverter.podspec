Pod::Spec.new do |s|
  s.name             = 'APIVerveShoeSizeConverter'
  s.version          = '1.2.3'
  s.summary          = 'Shoe Size Converter translates footwear measurements across regional standards, including US, UK, Australian, Mexican, and Korean sizing...'
  s.description      = <<-'DESC'
Shoe Size Converter translates footwear measurements across regional standards, including US, UK, Australian, Mexican, and Korean sizing systems. Provide a size, source region, and gender category to get equivalent sizes, with paid plans adding European, Japanese, and centimeter measurements.

This iOS/macOS SDK provides a convenient way to access the Shoe Size Converter from APIVerve.
Supports both callback-based and async/await patterns.
                       DESC

  s.homepage         = 'https://apiverve.com/marketplace/shoesizeconverter?utm_source=cocoapods&utm_medium=referral&utm_content=homepage'
  s.license          = { :type => 'MIT', :file => 'LICENSE' }
  s.author           = { 'APIVerve' => 'hello@apiverve.com' }
  # The SDK repo holds every language; the pod lives under cocoapods/ with its own tag.
  s.source           = { :git => 'https://github.com/apiverve/shoesizeconverter-api.git', :tag => "cocoapods/v#{s.version}" }

  s.ios.deployment_target = '15.0'
  s.osx.deployment_target = '12.0'

  s.swift_version = '5.0'

  s.source_files = 'cocoapods/Sources/APIVerveShoeSizeConverter/**/*.swift'

  s.frameworks = 'Foundation'

  # APIResponse, APIVerveError and the request plumbing, shared by every APIVerve pod.
  s.dependency 'APIVerveCore', '~> 1.2'
end
