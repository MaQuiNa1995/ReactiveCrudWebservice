package maquina1995.webservice.reactive.dto;

import java.io.Serializable;

public interface PersistibleDto<K extends Serializable> {

	K getId();

	void setId(K id);
}
