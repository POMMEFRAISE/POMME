package clientRMI;

import java.net.MalformedURLException;
import java.rmi.server.RMIClassLoader;

public class ChargerService {
	//private static String url="http://localhost/servicermi/persistanceservice.jar";
	private static String url="file:/C:/Users/Dylan/git/PDS/persistanceservice/persistanceservice/bin/";

	public static Object chargerDTO(String DTOACharger){
		Object objetDTO = null;
		try {
			Class<?> classeDTO = RMIClassLoader.loadClass(url,"dto."+DTOACharger);
			objetDTO = classeDTO.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return objetDTO;
	}
	
	public static Object chargerInterface(){
		Object objetService = null;
		try {
			Class<?> classeService = RMIClassLoader.loadClass(url,"servicefacade.ServiceFacade");
			objetService = classeService.newInstance();
		} catch (MalformedURLException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		return objetService;
	}
}