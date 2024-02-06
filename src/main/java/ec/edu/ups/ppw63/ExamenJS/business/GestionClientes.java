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
        // Validación de datos del DTO
        if (recargaMovilDTO.getMonto() <= 0) {
            throw new Exception("El monto de la recarga debe ser positivo");
        }

        // Aquí podrías añadir lógica para validar el operador y el número de teléfono
        // Por ejemplo, comprobar que el operador sea uno de los permitidos en tu sistema

        Cliente cliente = daoCliente.read(recargaMovilDTO.getClienteId());
        if (cliente == null) {
            throw new Exception("Cliente no encontrado");
        }

        // Lógica para procesar la recarga
        // Aquí actualizamos el saldo del cliente con el monto de la recarga
        double nuevoSaldo = cliente.getSaldo() + recargaMovilDTO.getMonto();
        cliente.setSaldo(nuevoSaldo);

        // Guardamos los cambios en la base de datos
        daoCliente.update(cliente);
    }
	
	

}
