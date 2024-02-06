package ec.edu.ups.ppw63.ExamenJS.services;



import ec.edu.ups.ppw63.ExamenJS.business.GestionClientes;
import ec.edu.ups.ppw63.ExamenJS.model.RecargaMovilDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;

import jakarta.ws.rs.POST;

import jakarta.ws.rs.Path;

import jakarta.ws.rs.Produces;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("transferencias")
public class TransferenciaServices {
    
    @Inject
    private GestionClientes gClientes;

    

    @POST
    @Path("/recargaMovil")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response recargarMovil(RecargaMovilDTO recargaMovilDTO) {
        try {
            
            gClientes.procesarRecargaMovil(recargaMovilDTO);

            ErrorMessage mensaje = new ErrorMessage(0, "Recarga realizada con éxito");
            return Response.status(Response.Status.CREATED).entity(mensaje).build();
        } catch (Exception e) {
            ErrorMessage error = new ErrorMessage(99, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
        }
    }

   

   
}
