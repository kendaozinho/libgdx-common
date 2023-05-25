package com.kendao.libgdx.socket;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.net.Socket;
import com.badlogic.gdx.net.SocketHints;
import com.badlogic.gdx.utils.Logger;
import com.google.gson.Gson;
import com.kendao.libgdx.security.CustomAES;
import com.kendao.libgdx.socket.exception.CustomSocketException;
import com.kendao.libgdx.util.CustomGsonUtil;

import java.io.PrintStream;
import java.util.Optional;
import java.util.Scanner;

public class CustomSocket {
  private final Logger logger = new Logger(this.toString(), Application.LOG_DEBUG);

  private final String host;
  private final Integer port;
  private final String deviceId;
  private final String secretKey;
  private final String appVersion;
  private final CustomAES customAES;
  private final Gson gson;

  private Socket socket = null;
  private Scanner input = null;
  private PrintStream output = null;
  private Boolean blocked = false;

  protected CustomSocket(String host, Integer port, String deviceId, String secretKey, String appVersion) {
    this.host = host;
    this.port = port;
    this.deviceId = deviceId;
    this.secretKey = secretKey;
    this.appVersion = appVersion;
    this.customAES = new CustomAES(this.secretKey);
    this.gson = CustomGsonUtil.getGson();
  }

  protected void connect() throws Throwable {
    if (this.socket == null) {
      SocketHints hints = new SocketHints();
      hints.socketTimeout = 0;
      hints.connectTimeout = 0;

      this.socket = Gdx.net.newClientSocket(Net.Protocol.TCP, this.host, this.port, hints);

      this.input = new Scanner(this.socket.getInputStream());
      this.output = new PrintStream(this.socket.getOutputStream(), true);
    }
  }

  protected void disconnect() {
    if (this.output != null) {
      try {
        this.output.close();
      } catch (Throwable t) {
        logger.error("Unable to close output", t);
      } finally {
        this.output = null;
      }
    }

    if (this.input != null) {
      try {
        this.input.close();
      } catch (Throwable t) {
        logger.error("Unable to close input", t);
      } finally {
        this.input = null;
      }
    }

    if (this.socket != null) {
      try {
        this.socket.dispose();
      } catch (Throwable t) {
        logger.error("Unable to dispose socket", t);
      } finally {
        this.socket = null;
      }
    }
  }

  protected <REQ> Boolean onlySendMessageToServer(REQ request, final boolean disconnect) {
    return this.sendMessageToServer(request, Boolean.class, disconnect).orElse(Boolean.FALSE);
  }

  protected <REQ, RES> Optional<RES> sendMessageToServerAndWaitForResponse(REQ request, Class<RES> responseClass, final boolean disconnect) {
    return this.sendMessageToServer(request, responseClass, disconnect);
  }

  private <REQ, RES> Optional<RES> sendMessageToServer(REQ request, Class<RES> responseClass, final boolean disconnect) {
    if (this.isBlocked()) {
      return Optional.empty();
    }
    this.setBlocked(true);

    String errorMessage = "Unable to connect to server";
    try {
      this.connect();

      errorMessage = "Unable to send message to server";
      this.output.println(this.customAES.encrypt(this.gson.toJson(request)));

      Optional<RES> response = Optional.empty();

      if (Boolean.class.isAssignableFrom(responseClass)) {
        response = Optional.of((RES) Boolean.TRUE);
      } else {
        errorMessage = "Unable to receive message from server";

        if (this.input.hasNext()) {
          String line = this.customAES.decrypt(this.input.nextLine());
          response = Optional.of(this.gson.fromJson(line, responseClass));
        }
      }

      return response;
    } catch (Throwable t) {
      this.logger.error(errorMessage, t);
      throw new CustomSocketException(errorMessage);
    } finally {
      if (disconnect) {
        this.disconnect();
      }
      this.setBlocked(false);
    }
  }

  protected Boolean isBlocked() {
    return this.blocked;
  }

  private void setBlocked(Boolean blocked) {
    this.blocked = blocked;
  }

  protected String getHost() {
    return this.host;
  }

  protected Integer getPort() {
    return this.port;
  }

  protected String getDeviceId() {
    return this.deviceId;
  }

  protected String getSecretKey() {
    return this.secretKey;
  }

  protected String getAppVersion() {
    return this.appVersion;
  }
}
