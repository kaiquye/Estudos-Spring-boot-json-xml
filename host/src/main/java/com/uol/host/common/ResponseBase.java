package com.uol.host.common;

import lombok.Data;

@Data
public class ResponseBase<T> {
  T data;

  public ResponseBase(T data) {
    this.data = data;
  }
}
