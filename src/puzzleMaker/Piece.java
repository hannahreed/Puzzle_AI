package puzzleMaker;

import java.io.File;

/**
 * represents individual puzzle piece
 * -whether piece is connected
 * @author Vasily Fedotov
 */
public class Piece {

	private Piece above, below, left, right;//adjoining pieces
	private File img;//image on piece
	
	public Piece(File img) {
		this.img = img;
	}

	/**
	 * @return - image on piece
	 */
	public File getImg() {
		return img;
	}

}
