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
        /// </summary>
        [JsonProperty("size")]
        public string Size { get; set; }

        /// <summary>
        /// Source region
        /// </summary>
        [JsonProperty("from")]
        public string From { get; set; }

        /// <summary>
        /// Gender sizing
        /// </summary>
        [JsonProperty("gender")]
        public string Gender { get; set; }
    }
}
