package ec.edu.ups.ppw63.ExamenJS.business;

import java.util.List;

import ec.edu.ups.ppw63.ExamenJS.dao.ClienteDao;
import ec.edu.ups.ppw63.ExamenJS.model.Cliente;
import ec.edu.ups.ppw63.ExamenJS.model.RecargaMovilDTO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionClientes {
	
	@Inject
	private ClienteDao daoCliente;

	public void guardarClientes(Cliente cliente) {
		Cliente cli = daoCliente.read(cliente.getCodigo());
		if (cli != null){
			daoCliente.update(cliente);
		}else {
			daoCliente.insert(cliente);
		}
	}
	
	public void actualizarCliente(Cliente cliente) throws Exception {
		Cliente cli = daoCliente.read(cliente.getCodigo());
		if (cli != null){
			daoCliente.update(cliente);
		}else {
			throw new Exception("Cliente no existe");
		}
	}
	
	public Cliente getClientePorCedula(String cedula) throws Exception{
		
		if(cedula.length()!=10)
			throw new Exception("Cedula incorrecta");
			
		return daoCliente.getClientePorCedula(cedula);
	}
	
	public void borrarCliente(int codigo){
		
		daoCliente.remove(codigo);
	}
	
	public List<Cliente> getClientes(){
		return daoCliente.getAll();
	}
	
	
	public void procesarRecargaMovil(RecargaMovilDTO recargaMovilDTO) throws Exception {
        
		
        if (recargaMovilDTO.getMonto() <= 0) {
            throw new Exception("El monto de la recarga no debe ser menor a 1");
        }

        

        Cliente cliente = daoCliente.read(recargaMovilDTO.getClienteId());
        if (cliente == null) {
            throw new Exception("Cliente no encontrado");
        }

    
        double nuevoSaldo = cliente.getSaldo() + recargaMovilDTO.getMonto();
        cliente.setSaldo(nuevoSaldo);

        
        daoCliente.update(cliente);
    }
	
	
	

}
