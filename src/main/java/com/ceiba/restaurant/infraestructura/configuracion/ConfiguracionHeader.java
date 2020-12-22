package com.ceiba.restaurant.infraestructura.configuracion;

import com.ceiba.restaurant.infraestructura.filtro.FiltroHeaderSeguridad;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracionHeader {
	
	@Bean
	public FiltroHeaderSeguridad filtroHeader() {
		return new FiltroHeaderSeguridad();
	}

}