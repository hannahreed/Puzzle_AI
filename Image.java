package puzzleClassifier;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Manipulation of puzzle image
 * -splitting of image into pieces
 * -file retrieval and storage
 */
public class Image {

	private BufferedImage img = null;
	private File inFile, outFile  = null;//input, output files
	
	private String imgID; //name of original image, for naming pieces in multi-image file
	private int rows, cols;//number of rows and columns in puzzle
	private int numPieces;//number of pieces in puzzle
	private int width, height;//width, height of image
	private int pieceW, pieceH;//width, height of individual piece
	
	/**
	 * Loads image from file directory
	 * @param imgPath - file directory
	 * FOR PURPOSES OF ANALYZING ENTIRE IMAGE
	 */
	public Image(String imgPath) throws IOException{
		//load image file
		inFile = new File(imgPath);
		img = ImageIO.read(inFile);
		
		//set initial attributes - one piece
		imgID = this.getID(imgPath);
		rows = cols = numPieces = 1;
		width = img.getWidth(); 
		height = img.getHeight();
		pieceW = width;
		pieceH = height;	
	}

	/**
	 * Loads image from file directory
	 * splits into pieces
	 * stores pieces (images) in output directory
	 * @param imgPath - file directory
	 * @param rows - number of rows in puzzle
	 * @param cols - number of columns in puzzle
	 * FOR PURPOSES OF MAKING TESTING DATA
	 * @return 
	 */
	public void makePuzzle(int rows, int cols) throws IOException{
		//sets attributes 
		this.rows = rows;
		this.cols = cols;
		numPieces = rows*cols;
		pieceW = width/cols;
		pieceH = height/rows;
		
		//splits into pieces
		this.makePieces();
	}
	
	/**
	 * returns name of image from file directory
	 * TO DO
	 */
	private String getID(String imgPath) {
		return "Pies";
	}
	
	/**
	 * generates pieces from image
	 * stores images in output directory
	 */
	private void makePieces() throws IOException {
		BufferedImage[] pieces = new BufferedImage[this.numPieces];//array of pieces
		int x, y; //coordinates of top left corner of piece
		int pcCount = 0;//piece number, from 0 -> numPieces-1
		
		//buffers each piece's image, goes along rows
		for (y = 0; y < this.rows; y ++) {
			for(x = 0; x < this.cols; x ++) {
				pieces[pcCount++] = this.img.getSubimage(x*pieceW, y*pieceH, pieceW, pieceH);
			}
		}
		
		//writes to output file
		this.writeToFile(pieces);
		
	}

	//MAKE FOLDER INCLUDE ID
	/**
	 * stores pieces as separate jpeg image files 
	 * (CURRENTLY STORING PIECES IN NAKED DIRECTORY)
	 * @param images - array of pieces to store
	 */
	private void writeToFile(BufferedImage[] images) throws IOException {
		String name;
		
		//creates empty directory
		File dir = new File("Pieces");
		if(!dir.exists()) {//directory did not previously exist
			new File("Pieces").mkdir();
		}
		else {//previously existed -> empty
			File[] files = dir.listFiles(); 
			for (File f : files) {
				f.delete();
			}
		}
		
		//writing each piece to file
		for (int i = 0; i < images.length; i++) {
			name = "Pieces/" + this.imgID + "_" + i + ".jpg";
			this.outFile = new File(name);
			ImageIO.write(images[i], "jpg", outFile);//stores as jpeg file
		}
	}
}
