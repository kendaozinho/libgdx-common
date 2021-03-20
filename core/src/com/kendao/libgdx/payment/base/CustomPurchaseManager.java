package com.kendao.libgdx.payment.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.pay.*;
import com.kendao.libgdx.listener.CustomGameListener;

import java.util.HashMap;
import java.util.Map;

public class CustomPurchaseManager {
  private PurchaseManager purchaseManager;

  public CustomPurchaseManager() {
    this.purchaseManager = null;
  }

  public CustomPurchaseManager(PurchaseManager purchaseManager) {
    this.purchaseManager = purchaseManager;
  }

  public static CustomPurchaseManager getInstance() {
    return ((CustomGameListener) Gdx.app.getApplicationListener()).getInstanceOf(CustomPurchaseManager.class);
  }

  public void install(PurchaseObserver purchaseObserver, HashMap<OfferType, String> offers) {
    if (this.purchaseManager != null) {
      this.purchaseManager.install(
          purchaseObserver,
          this.getPurchaseManagerConfig(offers),
          true
      );
    }
  }

  private PurchaseManagerConfig getPurchaseManagerConfig(HashMap<OfferType, String> offers) {
    PurchaseManagerConfig config = new PurchaseManagerConfig();

    for (Map.Entry<OfferType, String> entry : offers.entrySet()) {
      config.addOffer(new Offer().setType(entry.getKey()).setIdentifier(entry.getValue()));
    }

    return config;
  }

  public Boolean installed() {
    if (this.purchaseManager != null) {
      return this.purchaseManager.installed();
    }

    return false;
  }

  public void purchase(String identifier) {
    if (this.purchaseManager != null) {
      this.purchaseManager.purchase(identifier);
    }
  }

  public void purchaseRestore() {
    if (this.purchaseManager != null) {
      this.purchaseManager.purchaseRestore();
    }
  }

  public String storeName() {
    if (this.purchaseManager != null) {
      return this.purchaseManager.storeName();
    }

    return null;
  }

  public void dispose() {
    if (this.purchaseManager != null) {
      this.purchaseManager.dispose();
    }
  }
}