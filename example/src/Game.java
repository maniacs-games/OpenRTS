import java.awt.event.ActionListener;

import model.Model;
import view.View;

import com.jme3.app.SimpleApplication;
import com.jme3.bullet.BulletAppState;
import com.jme3.math.Vector3f;
import com.jme3.niftygui.NiftyJmeDisplay;

import controller.battlefield.BattlefieldController;
import controller.editor.EditorController;
import controller.ground.GroundController;


public class Game extends SimpleApplication  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello world");
		
		Game app = new Game();
		app.setShowSettings(false);
//		app.setSettings(settings);
		app.start();
	}

	
	 @Override
		public void simpleInitApp() {
			BulletAppState bulletAppState = new BulletAppState();
			stateManager.attach(bulletAppState);
			bulletAppState.getPhysicsSpace().setGravity(new Vector3f(0, 0, -1));
//			stateManager.detach(bulletAppState);

			flyCam.setUpVector(new Vector3f(0, 0, 1));
			flyCam.setEnabled(false);

	       Model model = new Model();
	       View view = new View(rootNode, guiNode, bulletAppState.getPhysicsSpace(), assetManager, viewPort, model);
	        
	        NiftyJmeDisplay niftyDisplay = new NiftyJmeDisplay(assetManager, inputManager, audioRenderer, guiViewPort);

	        BattlefieldController fieldCtrl = new BattlefieldController(model, view, niftyDisplay.getNifty(), inputManager, cam);

	        niftyDisplay.getNifty().setIgnoreKeyboardEvents(true);
	        //TODO: validation is needed to be sure everyting in XML is fine. see http://wiki.jmonkeyengine.org/doku.php/jme3:advanced:nifty_gui_best_practices
//	        niftyDisplay.getNifty().validateXml("interface/screen.xml");
	        niftyDisplay.getNifty().fromXml("interface/screen.xml", "editor");
	        
	        stateManager.attach(fieldCtrl);
	        fieldCtrl.setEnabled(true);

	        view.mapRend.renderTiles();
	        
	        guiViewPort.addProcessor(niftyDisplay);
		}
}