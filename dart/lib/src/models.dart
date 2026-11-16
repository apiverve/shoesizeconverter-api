/// Response models for the Shoe Size Converter API.

/// API Response wrapper.
class ShoesizeconverterResponse {
  final String status;
  final dynamic error;
  final ShoesizeconverterData? data;

  /// Set only when the current plan locks one or more fields; null otherwise.
  final PremiumInfo? premium;

  ShoesizeconverterResponse({
    required this.status,
    this.error,
    this.data,
    this.premium,
  });

  factory ShoesizeconverterResponse.fromJson(Map<String, dynamic> json) => ShoesizeconverterResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? ShoesizeconverterData.fromJson(json['data']) : null,
    premium: json['premium'] != null ? PremiumInfo.fromJson(json['premium']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
    if (premium != null) 'premium': premium!.toJson(),
  };
}

/// Describes fields the current plan does not unlock. Locked fields arrive as null
/// in [data], and [lockedFields] names them (nested ones use dot paths).
class PremiumInfo {
  final String? message;
  final String? upgradeUrl;
  final List<String>? lockedFields;

  PremiumInfo({this.message, this.upgradeUrl, this.lockedFields});

  factory PremiumInfo.fromJson(Map<String, dynamic> json) => PremiumInfo(
    message: json['message'] as String?,
    upgradeUrl: json['upgrade_url'] as String?,
    lockedFields: (json['locked_fields'] as List?)?.map((e) => e.toString()).toList(),
  );

  Map<String, dynamic> toJson() => {
    if (message != null) 'message': message,
    if (upgradeUrl != null) 'upgrade_url': upgradeUrl,
    if (lockedFields != null) 'locked_fields': lockedFields,
  };
}

/// Response data for the Shoe Size Converter API.

class ShoesizeconverterData {
  num? inputSize;
  String? inputRegion;
  String? gender;
  ShoesizeconverterDataConversions? conversions;
  String? note;

  ShoesizeconverterData({
    this.inputSize,
    this.inputRegion,
    this.gender,
    this.conversions,
    this.note,
  });

  factory ShoesizeconverterData.fromJson(Map<String, dynamic> json) => ShoesizeconverterData(
      inputSize: json['input_size'],
      inputRegion: json['input_region'],
      gender: json['gender'],
      conversions: json['conversions'] != null ? ShoesizeconverterDataConversions.fromJson(json['conversions']) : null,
      note: json['note'],
    );
}

class ShoesizeconverterDataConversions {
  num? cm;
  num? jp;
  num? us;
  num? uk;
  num? au;
  num? eu;
  num? mx;
  num? kr;

  ShoesizeconverterDataConversions({
    this.cm,
    this.jp,
    this.us,
    this.uk,
    this.au,
    this.eu,
    this.mx,
    this.kr,
  });

  factory ShoesizeconverterDataConversions.fromJson(Map<String, dynamic> json) => ShoesizeconverterDataConversions(
      cm: json['cm'],
      jp: json['jp'],
      us: json['us'],
      uk: json['uk'],
      au: json['au'],
      eu: json['eu'],
      mx: json['mx'],
      kr: json['kr'],
    );
}

class ShoesizeconverterRequest {
  String size;
  String from;
  String? gender;

  ShoesizeconverterRequest({
    required this.size,
    required this.from,
    this.gender,
  });

  Map<String, dynamic> toJson() => {
      'size': size,
      'from': from,
      if (gender != null) 'gender': gender,
    };
}
