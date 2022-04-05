package br.com.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LeitorModel {
	private Integer idLeitor;
	private String nomeLeitor;
	private String tipoLeitor;
	
	public LeitorModel() {
	}

	public LeitorModel(Integer idLeitor, String nomeLeitor, String tipoLeitor) {
		this.idLeitor = idLeitor;
		this.nomeLeitor = nomeLeitor;
		this.tipoLeitor = tipoLeitor;
	}
	
}
