package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_empleado")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmpleadoEntity {
	
	@Id
	@Column(name = "dni_empleado", 
	nullable = false, 
	unique = true)
	private Integer dniEmpleado;
	
	@Column(name = "nombre_empleado", 
			columnDefinition = "VARCHAR(45)", 
			nullable = false)
	private String nombreEmpleado;
	
	@Column(name = "apellido_empleado", 
			columnDefinition = "VARCHAR(45)", 
			nullable = false)
	private String apellidoEmpleado;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_nacimiento_empleado")
	private Date fchaNacimientoEmpleado;
	
	@Column(name = "direccion_empleado", 
			columnDefinition = "VARCHAR(45)", 
			nullable = false)
	private String direccionEmpleado;
	
	@Column(name = "correo_empleado", 
			columnDefinition = "VARCHAR(45)", 
			nullable = false, unique = true)
	private String correoEmpleado;
	
	@ManyToOne
	@JoinColumn(name = "area_id", nullable = false)
	private AreaEntity area;
	
	
}
