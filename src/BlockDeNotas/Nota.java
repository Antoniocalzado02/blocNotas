package BlockDeNotas;

import java.time.LocalDateTime;
import java.util.Objects;


public class Nota implements Comparable<Nota> {
	
	private static Integer codigoSiguiente=0;
	private Integer codigo;
	private String texto;
	private LocalDateTime fechaCreacion;
	private LocalDateTime fechaUltimaModificacion;
	
	
	public Nota(String texto) {
		super();
		this.texto = texto;
		this.codigo=codigoSiguiente;
		codigoSiguiente++;
	}


	public Integer getCodigo() {
		return codigo;
	}


	public String getTexto() {
		return texto;
	}


	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}


	public LocalDateTime getFechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}



	public void setTexto(String texto) {
		this.texto = texto;
		this.fechaUltimaModificacion=LocalDateTime.now();
	}


	public boolean isModificado() {
		return this.fechaUltimaModificacion!=null;
	}
	
	public boolean isEmpty() {
		return this.texto==null || this.texto.isBlank();
	}
	
	public boolean isCreadoAnterior(Nota nota) {
		return this.getFechaCreacion().isBefore(nota.getFechaCreacion());
	}
	
	public boolean isModificadoAnterior(Nota nota) {
		boolean esAnterior=false;
		if(this.getFechaUltimaModificacion()==null && nota.getFechaUltimaModificacion()==null) {
			esAnterior=false;
		}else if(this.isModificado() && nota.isModificado()) {
			esAnterior=this.getFechaUltimaModificacion().isBefore(nota.getFechaUltimaModificacion());
		}else if(this.isModificado()) {
			esAnterior=true;
		}
		
		return esAnterior;
	}


	@Override
	public int hashCode() {
		return Objects.hash(codigo, fechaCreacion, fechaUltimaModificacion, texto);
	}


	@Override
	public boolean equals(Object obj) {
		boolean sonIguales=false;
		Nota other = (Nota) obj;
		if (obj!=null) {
			if (this == obj) {
				sonIguales= true;
				}
			
		}else if(this.texto.equals(other.getTexto()) && this.fechaCreacion.equals(other.getFechaCreacion())) {
			sonIguales=true;
		}
		return sonIguales;
	}
	
	
	@Override
	public String toString() {
		return "Nota [codigo=" + codigo + ", texto=" + texto + ", fechaCreacion=" + fechaCreacion
				+ ", fechaUltimaModificacion=" + fechaUltimaModificacion + "]";
	}


	@Override
	public int compareTo(Nota o) {
		return this.getFechaCreacion().compareTo(o.getFechaCreacion());
	}
	
	

}
