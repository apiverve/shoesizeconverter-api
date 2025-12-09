using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.ShoeSizeConverter
{
    /// <summary>
    /// Query options for the Shoe Size Converter API
    /// </summary>
    public class ShoeSizeConverterQueryOptions
    {
        /// <summary>
        /// The shoe size to convert
        /// Example: 9
        /// </summary>
        [JsonProperty("size")]
        public string Size { get; set; }

        /// <summary>
        /// Source region: us, uk, eu, cm, jp, au, mx, or kr
        /// Example: us
        /// </summary>
        [JsonProperty("from")]
        public string From { get; set; }

        /// <summary>
        /// Gender sizing: men, women, unisex, or child (default: unisex)
        /// Example: men
        /// </summary>
        [JsonProperty("gender")]
        public string Gender { get; set; }
    }
}
