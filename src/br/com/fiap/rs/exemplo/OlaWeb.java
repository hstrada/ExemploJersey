package br.com.fiap.rs.exemplo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("exemplows")
public class OlaWeb {

	
  @GET	
  @Produces(MediaType.TEXT_PLAIN)
  public String ola(){
    return "Boa noite";  
  }
  
}
