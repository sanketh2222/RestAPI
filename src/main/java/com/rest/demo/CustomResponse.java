package com.rest.demo;

import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Component;

@Component
public class CustomResponse {
   public int status;
   public String response;

   public int getStatus() {
       return status;
   }

   public void setStatus(int status) {
       this.status = status;
   }

   public String getResponse() {
       return response;
   }

   public void setResponse(String response) {
       this.response = response;
   }

public void setStatus(BodyBuilder ok) {
}
}
