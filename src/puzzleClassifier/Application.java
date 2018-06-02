package puzzleClassifier;

import java.io.File;
import java.io.IOException;

public class Application {

	public static void main(String[] args) throws IOException {
		//GIVEN FOLDER OF TRAINING DATA EXISTS
		//create folder of training images
		//File trainingData  = makeEmptyDir("training data");
		
		File[] data = new File("training data").listFiles();
		for (File sampleImg : data) {
			Image img = new Image(sampleImg);
			img.makePuzzle(4, 4);//MAKE SURE RESOLUTION PERMITS SUBDIVISIONS 
		}
		

	}
	
	/**
	 * makes empty directory inside Puzzle AI directory
	 * @param name - name of new directory
	 * @return - File of directory
	 */
	//GET RID OF PUZZLE PIECES LEFT OVER IN DIR
	public static File makeEmptyDir(String name) {
		//creates empty directory
		File dir = new File(name);
		if(!dir.exists()) {//directory did not previously exist
			new File(name).mkdirs();
		}
		else {//previously existed -> empty
			File[] files = dir.listFiles(); 
			for (File f : files) {
				f.delete();
			}
		}
		
		return dir;
	}

}
