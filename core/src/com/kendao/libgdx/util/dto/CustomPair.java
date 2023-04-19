package com.kendao.libgdx.util.dto;

public class CustomPair<A, B> {
  private A firstValue;
  private B secondValue;

  public CustomPair(A firstValue, B secondValue) {
    this.firstValue = firstValue;
    this.secondValue = secondValue;
  }

  public A getFirstValue() {
    return this.firstValue;
  }

  public void setFirstValue(A firstValue) {
    this.firstValue = firstValue;
  }

  public B getSecondValue() {
    return this.secondValue;
  }

  public void setSecondValue(B secondValue) {
    this.secondValue = secondValue;
  }
}