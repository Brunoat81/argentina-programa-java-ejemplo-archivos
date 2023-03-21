package modelo;

import com.opencsv.bean.CsvBindByPosition;

public class Pronosticos {
	
	@CsvBindByPosition(position = 0)
    private String EquipoA;

    @CsvBindByPosition(position = 1)
    private String pronosticoEquipoA;
    
    @CsvBindByPosition(position = 2)
    private String EquipoB;
    
    @CsvBindByPosition(position = 3)
    private String pronosticoEquipoB;
    

	public String getEquipoA() {
		return EquipoA;
	}

	public void setEquipoA(String equipoA) {
		EquipoA = equipoA;
	}

	public String getPronosticoEquipoA() {
		return pronosticoEquipoA;
	}

	public void setPronosticoEquipoA(String pronosticoEquipoA) {
		this.pronosticoEquipoA = pronosticoEquipoA;
	}

	public String getEquipoB() {
		return EquipoB;
	}

	public void setEquipoB(String equipoB) {
		EquipoB = equipoB;
	}

	public String getPronosticoEquipoB() {
		return pronosticoEquipoB;
	}

	public void setPronosticoEquipoB(String pronosticoEquipoB) {
		this.pronosticoEquipoB = pronosticoEquipoB;
	}
}
