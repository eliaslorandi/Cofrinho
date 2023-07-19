package uninter;

public class Dolar extends Moeda {

	public Dolar(double valorInicial) {
		this.valor = valorInicial;
	}

	public void info() {
		System.out.println("Dolar = " + valor);

	}

	public double converter() {
		return this.valor * 4.8;
	}

	@Override
	public boolean equals(Object objeto) {
		if (this.getClass() != objeto.getClass()) {
			return false;
		}

		// cast
		Dolar objetoMoedaDolar = (Dolar) objeto;

		if (this.valor != objetoMoedaDolar.valor) {
			return false;
		}

		return true;
	}

}
