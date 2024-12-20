package com.kendao.libgdx.api;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kendao.libgdx.api.dto.CustomApiResponse;
import com.kendao.libgdx.util.CustomGsonUtil;

import java.util.Arrays;
import java.util.List;

public class CustomApi {
  private final String baseUrl;
  private final String deviceId;
  private final String secretKey;
  private final String appVersion;
  private final Gson gson;

  protected CustomApi(String baseUrl, String deviceId, String secretKey, String appVersion) {
    this.baseUrl = baseUrl;
    this.deviceId = deviceId;
    this.secretKey = secretKey;
    this.appVersion = appVersion;
    this.gson = CustomGsonUtil.getGson();
  }

  public static Integer getThrowableStatus(Throwable t) {
    try {
      return Integer.valueOf(
          t.getMessage().split("\\|")[0].trim()
      );
    } catch (Throwable t2) {
      System.err.println("Unable to get throwable status -> " + t2);
    }
    return 0;
  }

  protected <T> T callApi(String method, String path, Object requestBody, Class<T> clazz) throws Throwable {
    Net.HttpRequest httpRequest = new Net.HttpRequest(method);
    httpRequest.setUrl(this.baseUrl + path);
    if (requestBody != null) {
      httpRequest.setContent(this.gson.toJson(requestBody));
    }
    httpRequest.setHeader("Authorization", this.secretKey);
    httpRequest.setHeader("X-Client-ID", this.deviceId);
    httpRequest.setHeader("X-Client-Version", this.appVersion);
    httpRequest.setTimeOut(10000);

    final CustomApiResponse response = new CustomApiResponse();

    Gdx.net.sendHttpRequest(httpRequest, new Net.HttpResponseListener() {
      @Override
      public void handleHttpResponse(Net.HttpResponse httpResponse) {
        String responseBody = httpResponse.getResultAsString();
        if (httpResponse.getStatus().getStatusCode() >= 200 && httpResponse.getStatus().getStatusCode() < 300) {
          response.setContent(responseBody == null ? "" : responseBody);
        } else {
          response.setContent(httpResponse.getStatus().getStatusCode() + " | " + responseBody);
        }
      }

      @Override
      public void failed(Throwable t) {
        response.setContent("0 | " + t.toString());
      }

      @Override
      public void cancelled() {
        response.setContent("0 | Operation was canceled");
      }
    });

    while (true) {
      Thread.sleep(25);

      if (response.getContent() != null) {
        String[] words = response.getContent().split(" ");
        if (words.length > 1 && words[1].equals("|")) { // When API returns error
          throw new RuntimeException(response.getContent());
        } else { // When API returns success
          if (clazz.equals(String.class)) {
            return ((T) response.getContent());
          } else {
            try {
              return this.gson.fromJson(response.getContent(), clazz);
            } catch (Throwable t) {
              throw new RuntimeException("0 | " + t);
            }
          }
        }
      }
    }
  }

  protected <T> List<T> callApiAsList(String method, String path, Object requestBody, Class<T[]> clazz) throws Throwable {
    Net.HttpRequest httpRequest = new Net.HttpRequest(method);
    httpRequest.setUrl(this.baseUrl + path);
    if (requestBody != null) {
      httpRequest.setContent(this.gson.toJson(requestBody));
    }
    httpRequest.setHeader("Authorization", this.secretKey);
    httpRequest.setHeader("X-Client-ID", this.deviceId);
    httpRequest.setHeader("X-Client-Version", this.appVersion);
    httpRequest.setTimeOut(10000);

    final CustomApiResponse response = new CustomApiResponse();

    Gdx.net.sendHttpRequest(httpRequest, new Net.HttpResponseListener() {
      @Override
      public void handleHttpResponse(Net.HttpResponse httpResponse) {
        String responseBody = httpResponse.getResultAsString();
        if (httpResponse.getStatus().getStatusCode() >= 200 && httpResponse.getStatus().getStatusCode() < 300) {
          response.setContent(responseBody == null ? "" : responseBody);
        } else {
          response.setContent(httpResponse.getStatus().getStatusCode() + " | " + responseBody);
        }
      }

      @Override
      public void failed(Throwable t) {
        response.setContent("0 | " + t.toString());
      }

      @Override
      public void cancelled() {
        response.setContent("0 | Operation was canceled");
      }
    });

    while (true) {
      Thread.sleep(25);

      if (response.getContent() != null) {
        String[] words = response.getContent().split(" ");
        if (words.length > 1 && words[1].equals("|")) { // When API returns error
          throw new RuntimeException(response.getContent());
        } else { // When API returns success
          try {
            T[] array = this.gson.fromJson(response.getContent(), clazz);
            return Arrays.asList(array);
          } catch (Throwable t) {
            throw new RuntimeException("0 | " + t);
          }
        }
      }
    }
  }

  protected String toStringJson(Object object) {
    return this.gson.toJson(object);
  }

  protected String getBaseUrl() {
    return this.baseUrl;
  }

  protected String getDeviceId() {
    return this.deviceId;
  }
}
