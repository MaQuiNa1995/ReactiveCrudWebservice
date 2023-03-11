package maquina1995.webservice.reactive.dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Arma implements Serializable {

	@Id
	@GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "sequence", allocationSize = 1)
	@EqualsAndHashCode.Exclude
	private Long id;
	private String nombre;
	private String tipo;

}
