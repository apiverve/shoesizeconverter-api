declare module '@apiverve/shoesizeconverter' {
  export interface shoesizeconverterOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface shoesizeconverterResponse {
    status: string;
    error: string | null;
    data: ShoeSizeConverterData;
    code?: number;
  }


  interface ShoeSizeConverterData {
      inputSize:   number;
      inputRegion: string;
      gender:      string;
      conversions: Conversions;
      note:        string;
  }
  
  interface Conversions {
      cm: number;
      jp: number;
      us: number;
      uk: number;
      au: number;
      eu: number;
      mx: number;
      kr: number;
  }

  export default class shoesizeconverterWrapper {
    constructor(options: shoesizeconverterOptions);

    execute(callback: (error: any, data: shoesizeconverterResponse | null) => void): Promise<shoesizeconverterResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: shoesizeconverterResponse | null) => void): Promise<shoesizeconverterResponse>;
    execute(query?: Record<string, any>): Promise<shoesizeconverterResponse>;
  }
}
