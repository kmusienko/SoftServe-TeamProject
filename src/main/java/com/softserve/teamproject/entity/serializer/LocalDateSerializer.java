package com.softserve.teamproject.entity.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateSerializer extends JsonSerializer<LocalDate> {

  private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

  @Override
  public void serialize(LocalDate date, JsonGenerator generator,
      SerializerProvider provider) throws IOException {

    String dateString = date.format(formatter);
    generator.writeString(dateString);
  }
}