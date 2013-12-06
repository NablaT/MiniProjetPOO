package Material;

/**
 * Classe de définition de Camera. Camera hérite de Material.
 * 
 * @author Tom Veniat
 *
 */
public class Camera extends Material {
	
	/**
	 * Variable de classe, correspondant au nombre d'appareils photos existants.
	 * 
	 */
	private static int numberOfCameras=0;
	
	/**
	 * Constructeur de Camera.
	 * 
	 */
	public Camera(){
		type=Type.CAMERA;
		id="CAM"+String.valueOf(numberOfCameras);
		numberOfCameras++;
	}
	
	/**
	 * Getteur de numberOfCameras.
	 * 
	 * @return le nombre de Camera créés.
	 */
	public static int getNumberOfCameras(){
		return numberOfCameras;
	}
	
	/**
	 * Setteur de numberOfCameras.
	 * 
	 * @param number le nombre que l'on veut assigner à numberOfCamera.
	 */
	public static void setNumberOfCamera(int number){
		numberOfCameras=number;
	}
	
	
}
