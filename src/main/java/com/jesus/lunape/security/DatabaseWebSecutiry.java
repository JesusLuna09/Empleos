package com.jesus.lunape.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecutiry
					extends
					WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;
	
	protected void configure(AuthenticationManagerBuilder auth) 
			throws Exception{
		//configuracion por default, utiliza su propia base de datos 
		//.jdbcAuthentication().dataSource(dataSource);
		//Configuracion personalizada usando la base de nuestra aplicacion
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select username, password, estatus from Usuarios where username=?")
		.authoritiesByUsernameQuery("select u.username, p.perfil from UsuarioPerfil up " +
		"inner join Usuarios u on u.id = up.idUsuario " +
		"inner join Perfiles p on p.id = up.idPerfil " +
		"where u.username = ?");
	}

	//personalizar el acceso a las diferentes urls
	@Override
    protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
    // Los recursos estáticos no requieren autenticación
    .antMatchers(
    "/bootstrap/**",
    "/images/**",
    "/tinymce/**",
    "/logos/**").permitAll()
    // Las vistas públicas no requieren autenticación
    .antMatchers("/",
    "/usuarios/crear",
    "/buscar",
    "/vacantes/detalle/**").permitAll()
    
 // Asignar permisos a URLs por ROLES
    .antMatchers("/vacantes/**").hasAnyAuthority("SUPERVISOR","ADMINISTRADOR")
    .antMatchers("/categorias/**").hasAnyAuthority("SUPERVISOR","ADMINISTRADOR")
    .antMatchers("/usuarios/**").hasAnyAuthority("ADMINISTRADOR")
    // Todas las demás URLs de la Aplicación requieren autenticación
    .anyRequest().authenticated()
    // El formulario de Login no requiere autenticacion
    .and().formLogin().permitAll();
    }
}
