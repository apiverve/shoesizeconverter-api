// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     ShoeSizeConverterData data = Converter.fromJsonString(jsonString);

package com.apiverve.shoesizeconverter.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static ShoeSizeConverterData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(ShoeSizeConverterData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(ShoeSizeConverterData.class);
        writer = mapper.writerFor(ShoeSizeConverterData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// ShoeSizeConverterData.java

package com.apiverve.shoesizeconverter.data;

import com.fasterxml.jackson.annotation.*;

public class ShoeSizeConverterData {
    private long inputSize;
    private String inputRegion;
    private String gender;
    private Conversions conversions;
    private String note;

    @JsonProperty("input_size")
    public long getInputSize() { return inputSize; }
    @JsonProperty("input_size")
    public void setInputSize(long value) { this.inputSize = value; }

    @JsonProperty("input_region")
    public String getInputRegion() { return inputRegion; }
    @JsonProperty("input_region")
    public void setInputRegion(String value) { this.inputRegion = value; }

    @JsonProperty("gender")
    public String getGender() { return gender; }
    @JsonProperty("gender")
    public void setGender(String value) { this.gender = value; }

    @JsonProperty("conversions")
    public Conversions getConversions() { return conversions; }
    @JsonProperty("conversions")
    public void setConversions(Conversions value) { this.conversions = value; }

    @JsonProperty("note")
    public String getNote() { return note; }
    @JsonProperty("note")
    public void setNote(String value) { this.note = value; }
}

// Conversions.java

package com.apiverve.shoesizeconverter.data;

import com.fasterxml.jackson.annotation.*;

public class Conversions {
    private double cm;
    private double jp;
    private long us;
    private double uk;
    private double au;
    private double eu;
    private double mx;
    private double kr;

    @JsonProperty("cm")
    public double getCM() { return cm; }
    @JsonProperty("cm")
    public void setCM(double value) { this.cm = value; }

    @JsonProperty("jp")
    public double getJp() { return jp; }
    @JsonProperty("jp")
    public void setJp(double value) { this.jp = value; }

    @JsonProperty("us")
    public long getUs() { return us; }
    @JsonProperty("us")
    public void setUs(long value) { this.us = value; }

    @JsonProperty("uk")
    public double getUk() { return uk; }
    @JsonProperty("uk")
    public void setUk(double value) { this.uk = value; }

    @JsonProperty("au")
    public double getAu() { return au; }
    @JsonProperty("au")
    public void setAu(double value) { this.au = value; }

    @JsonProperty("eu")
    public double getEu() { return eu; }
    @JsonProperty("eu")
    public void setEu(double value) { this.eu = value; }

    @JsonProperty("mx")
    public double getMX() { return mx; }
    @JsonProperty("mx")
    public void setMX(double value) { this.mx = value; }

    @JsonProperty("kr")
    public double getKr() { return kr; }
    @JsonProperty("kr")
    public void setKr(double value) { this.kr = value; }
}