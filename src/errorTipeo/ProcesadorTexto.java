package errorTipeo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ProcesadorTexto {
	public int procesar(String stringOriginal, String stringPrueba) {
		List<String> original = Arrays.asList(stringOriginal.split(""));
		List<String> prueba = new LinkedList<String>(Arrays.asList(stringPrueba.split("")));
		int total = 0;
		for (int i = 0; i < original.size(); i++) {
			String charPrueba = prueba.get(i);
			String charOriginal = original.get(i);
			if (charPrueba != charOriginal) {
				//convierto la list de prueba en una string y busco la pos que necesito;
				int encontrado = String.join("", prueba).indexOf(charOriginal, i);
				total += encontrado - i;
				prueba.add(i, prueba.remove(encontrado));
			}
		}
		return total;
	}
}
