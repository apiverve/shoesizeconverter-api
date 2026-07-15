declare module '@apiverve/shoesizeconverter' {
  export interface shoesizeconverterOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface shoesizeconverterResponse {
    status: string;
    error: string | null;
    data: ShoeSizeConverterData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface ShoeSizeConverterData {
      inputSize:   number | null;
      inputRegion: null | string;
      gender:      null | string;
      conversions: Conversions;
      note:        null | string;
  }
  
  interface Conversions {
      cm: number | null;
      jp: number | null;
      us: number | null;
      uk: number | null;
      au: number | null;
      eu: number | null;
      mx: number | null;
      kr: number | null;
  }

  export default class shoesizeconverterWrapper {
    constructor(options: shoesizeconverterOptions);

    execute(callback: (error: any, data: shoesizeconverterResponse | null) => void): Promise<shoesizeconverterResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: shoesizeconverterResponse | null) => void): Promise<shoesizeconverterResponse>;
    execute(query?: Record<string, any>): Promise<shoesizeconverterResponse>;
  }
}
