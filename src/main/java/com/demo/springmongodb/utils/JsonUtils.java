package com.demo.springmongodb.utils;

import java.io.IOException;
import java.io.StringWriter;
import org.springframework.http.HttpMethod;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.jayway.jsonpath.JsonPath;

public class JsonUtils {

  private static final ObjectMapper OBJECT_MAPPER = createObjectMapper();
  
  private static ObjectMapper createObjectMapper() {
    return new ObjectMapper();
  }
  
  public static String getRequestJson(HttpMethod httpMethod, String uri, Object request) {
    JsonNode requestObject = OBJECT_MAPPER.createObjectNode();
    ((ObjectNode)requestObject).put(AppConstants.REQUEST_URI, uri);
    ((ObjectNode)requestObject).put(AppConstants.REQUEST_METHOD, httpMethod.toString());
    JsonNode requestNode = objectToNode(request);
    ((ObjectNode)requestObject).set(AppConstants.REQUEST_BODY, requestNode);
    return requestObject.toPrettyString();
  }
  
  public static JsonNode objectToNode(Object object) {
    try {
      if (object == null) {
        return OBJECT_MAPPER.createObjectNode();
      } else {
        return OBJECT_MAPPER.convertValue(object, JsonNode.class);
      }
    } catch (Exception e) {
      throw new RuntimeException("Error with object to Json", e);
    }
  }
  
  public static String objectToJson(Object object) {
    StringWriter sw = new StringWriter();
    JsonGenerator generator = null;
    try {
      generator = new JsonFactory().createGenerator(sw);
      OBJECT_MAPPER.writeValue(generator, object);
    } catch (IOException e) {
      throw new RuntimeException("Error with Object to Json", e);
    } finally {
      if (generator != null) {
        try {
          generator.close();
        } catch (IOException e) {
          throw new RuntimeException("Error with Close JsonFactory", e);
        }
      }
    }
    return sw.toString();
  }
  
  public static Object getJsonValueByJsonPath(String json, String path) {
    return JsonPath.parse(json).read(path);
  }
}
