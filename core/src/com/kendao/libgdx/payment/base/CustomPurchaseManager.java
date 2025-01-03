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

  /***
   * @return If method was executed, but install method is async.
   */
  public Boolean install(PurchaseObserver purchaseObserver, HashMap<OfferType, String> offers) {
    if (this.purchaseManager != null) {
      this.purchaseManager.install(
          purchaseObserver,
          this.getPurchaseManagerConfig(offers),
          true
      );
      return true;
    }
    return false;
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

  /***
   * @return If method was executed, but purchase method is async.
   */
  public Boolean purchase(String identifier) {
    if (this.installed()) {
      this.purchaseManager.purchase(identifier);
      return true;
    }
    return false;
  }

  /***
   * @return If method was executed, but purchaseRestore method is async.
   */
  public Boolean restorePurchases() {
    if (this.installed()) {
      this.purchaseManager.purchaseRestore();
      return true;
    }
    return false;
  }

  public String storeName() {
    if (this.purchaseManager != null) {
      return this.purchaseManager.storeName();
    }

    return null;
  }

  /***
   * @return If method was executed.
   */
  public Boolean dispose() {
    if (this.purchaseManager != null) {
      this.purchaseManager.dispose();
      return true;
    }
    return false;
  }
}