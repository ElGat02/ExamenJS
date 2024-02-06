package ec.edu.ups.ppw63.ExamenJS.business;



import java.util.Date;
import java.util.List;

import ec.edu.ups.ppw63.ExamenJS.dao.ClienteDao;
import ec.edu.ups.ppw63.ExamenJS.model.Cliente;
import ec.edu.ups.ppw63.ExamenJS.model.RecargaMovilDTO;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class GestionDatos {

	@Inject
	private ClienteDao daoCliente;
	
	@Inject
    private GestionClientes gestionClientes;
	
	
	@PostConstruct
	public void init() {
		System.out.println("iniciando");
		
		Cliente cliente1 = new Cliente();
        cliente1.setCodigo(1);
        cliente1.setDni("1150704672");
        cliente1.setDireccion("Ricaurte");
        cliente1.setNombre("Jairo Salazar");
        cliente1.setSaldo(50.0); // Estableciendo un saldo inicial

        daoCliente.insert(cliente1);

        Cliente cliente2 = new Cliente();
        cliente2.setCodigo(2);
        cliente2.setDni("098987332");
        cliente2.setDireccion("Monay");
        cliente2.setNombre("Juan Torres");
        cliente2.setSaldo(100.0); // Estableciendo un saldo inicial

        daoCliente.insert(cliente2);

        // Realizar una recarga de demostración
        realizarRecargaDemo();

        // Imprimir la información de los clientes después de la recarga
        imprimirClientes();
    }

    private void realizarRecargaDemo() {
        try {
            RecargaMovilDTO recarga = new RecargaMovilDTO();
            recarga.setNumeroMovil("099837018");
            recarga.setFecha(new Date());
            recarga.setOperador("movistar");
            recarga.setMonto(10.0);
            recarga.setClienteId(1); 

            System.out.println("Saldo antes de la recarga: " + daoCliente.read(1).getSaldo());
            gestionClientes.procesarRecargaMovil(recarga);
            System.out.println("Recarga móvil realizada con éxito");
            System.out.println("Saldo después de la recarga: " + daoCliente.read(1).getSaldo());
        } catch (Exception e) {
            System.err.println("Error al realizar recarga móvil: " + e.getMessage());
        }
        
        try {
            RecargaMovilDTO recarga = new RecargaMovilDTO();
            recarga.setNumeroMovil("0988226099");
            recarga.setFecha(new Date());
            recarga.setOperador("movistar");
            recarga.setMonto(10.0);
            recarga.setClienteId(3); 

            
            gestionClientes.procesarRecargaMovil(recarga);
            
        } catch (Exception e) {
            System.err.println("Error al realizar recarga móvil: " + e.getMessage());
        }
    }

    private void imprimirClientes() {
        System.out.println("\n------------- Clientes---------------");
        List<Cliente> list = daoCliente.getAll();
        for (Cliente cli : list) {
            System.out.println(cli.getCodigo() + "\t" + cli.getNombre() + "\tSaldo: " + cli.getSaldo());
        }
    }
	
}
