package br.com.fiap.rs.exemplo;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/alunos")
public class AlunoWeb {
  static private List<Aluno> alunos;
  
  static{
	  alunos = new ArrayList<Aluno>();
	  
	  Aluno a = new Aluno();
	  a.setNome("Fabio Purcino");
	  a.setTurma("28SCJ");
	  a.setMedia(8.2);
	  alunos.add(a);
	  
	  Aluno b = new Aluno();
	  b.setNome("Bruno do Acre");
	  b.setTurma("28SCJ");
	  b.setMedia(10);
	  alunos.add(b);	  
  }
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Aluno> getAlunos(){
	  return alunos;
  }
  
  @GET
  @Path("unico/{indice}")
  @Produces(MediaType.APPLICATION_JSON)
  public Aluno getAluno(@PathParam("indice") int indice){
	 return alunos.get(indice);  
  }
  
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response novo(Aluno a){
	  alunos.add(a);	  
	  Retorno r = new Retorno();
	  r.setMensagem("Aluno incluído com sucesso");
	  return Response.status(418).entity(r).build();	  		
  }
  
  @PUT
  @Path("{indice}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)  
  public Response atualizar(Aluno a, @PathParam("indice")int indice){
	  alunos.set(indice, a);
	  Retorno r = new Retorno();
	  r.setMensagem("Aluno Atualizado ");
	  return Response.status(202).entity(r).build();
  }
  
  @DELETE
  @Path("{ind}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response excluir(@PathParam("ind") int indice){
	  alunos.remove(indice);
	  Retorno r = new Retorno();
	  r.setMensagem("Aluno foi excluído");
	  return Response.status(200).entity(r).build();
  }
  
  
  
  
  
  
  
}
