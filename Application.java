package puzzleClassifier;

import java.io.IOException;

public class Application {

	public Application() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		Image img = new Image("IMG_pies.jpg");
		img.makePuzzle(2, 2);

	}

}
