package modelo;

import com.opencsv.bean.CsvBindByPosition;

public class productosEjercicio {

	@CsvBindByPosition(position = 0)
    private double Cantidad;

    @CsvBindByPosition(position = 1)
    private String producto;
    
    @CsvBindByPosition(position = 2)
    private double precioUnitario;

	public double getCantidad() {
		return Cantidad;
	}

	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
	
}
