package uninter;

public class Real extends Moeda {

	public Real(double valorInicial) {
		this.valor = valorInicial;
	}

	@Override
	public void info() {
		System.out.println("Real = " + valor);

	}

	@Override
	public double converter() {
		return this.valor;
	}

	@Override
	public boolean equals(Object objeto) {
		if (this.getClass() != objeto.getClass()) {
			return false;
		}

		// cast
		Real objetoMoedaReal = (Real) objeto;

		if (this.valor != objetoMoedaReal.valor) {
			return false;
		}

		return true;
	}

}
