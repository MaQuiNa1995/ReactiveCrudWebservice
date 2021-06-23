package maquina1995.webservice.reactive.dominio;

import java.io.Serializable;

public interface Persistible<K extends Serializable> {

	K getId();

	void setId(K id);

}
