/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Sphere;

/**
 *
 * @author alexandraneamtu
 */
public class LeftHand {
    /*
    Box box1 = new Box((float) 0.1, (float) 0.3, (float) 0.1);
        Geometry blue = new Geometry("Box", box1);
        blue.setLocalTranslation(new Vector3f(0, (float) -0.4,0));
        Material mat1 = new Material(assetManager,
                "Common/MatDefs/Misc/Unshaded.j3md");
        mat1.setColor("Color", ColorRGBA.Blue);
        blue.setMaterial(mat1);
        
        Sphere leftElbow = new Sphere(30,30, (float) 0.15,true,true);
        Geometry green = new Geometry("Sphere",leftElbow);
        green.setLocalTranslation(new Vector3f(0,0,0));
        Material mat3 = new Material(assetManager,
                "Common/MatDefs/Misc/Unshaded.j3md");
        mat3.setColor("Color",ColorRGBA.Green);
        green.setMaterial(mat3);

        // create a red box straight above the blue one at (1,3,1) //
        Box box2 = new Box((float) 0.1, (float) 0.3, (float) 0.1);
        Geometry red = new Geometry("Box", box2);
        red.setLocalTranslation(new Vector3f(0, (float) 0.4,0));
        Material mat2 = new Material(assetManager,
                "Common/MatDefs/Misc/Unshaded.j3md");
        mat2.setColor("Color", ColorRGBA.Red);
        red.setMaterial(mat2);

        // Create a pivot node at (0,0,0) and attach it to the root node //
        Node pivot = new Node("pivot");
        rootNode.attachChild(pivot); // put this node in the scene

        Node sphere = new Node("sphere");
        
        // Attach the two boxes to the *pivot* node. (And transitively to the root node.) //
        sphere.attachChild(green);    
        pivot.attachChild(sphere);
        sphere.attachChild(firstbox);
        sphere.attachChild(secondbox);
        firstbox.attachChild(blue);
        secondbox.attachChild(red);
        // Rotate the pivot node: Note that both boxes have rotated! //
        pivot.rotate(.3f,.3f,0f);
        
        */
}

/*
package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Sphere;
*/
///**
// * This is the Main Class of your Game. You should only do initialization here.
// * Move your Logic into AppStates or Controls
// * @author normenhansen
// */
/*
public class Main extends SimpleApplication {

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }
    
    Node secondbox = new Node("second box");
    Node firstbox = new Node("first box");
    Node sphere = new Node("sphere");
    Node sphere2 = new Node("sphere2");
    //Quaternion rotation=(new Quaternion()).fromAngles(0,0, 0);
    //Quaternion rotationVelocity=(new Quaternion()).fromAngles(-0.40f,0, 0);
    //Quaternion rotQuat = new Quaternion();
    //private Vector3f axis = new Vector3f(1, 0, 0).normalizeLocal();

//    @Override
//    public void simpleInitApp() {
//       
//        Box b = new Box(1, 1, 1);
//        Geometry geom = new Geometry("Box", b);
//        
//
//        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
//        mat.setColor("Color", ColorRGBA.Green);
//        geom.setMaterial(mat);
//  
//
//        rootNode.attachChild(geom);
//        
        flyCam.setDragToRotate(true);
        
        Sphere shoulder = new Sphere(30,30, (float) 0.15,true,true);
        Geometry green2 = new Geometry("Sphere",shoulder);
        green2.setLocalTranslation(new Vector3f(0, (float) 0.9,0));
        Material mat3 = new Material(assetManager,
                "Common/MatDefs/Misc/Unshaded.j3md");
        mat3.setColor("Color",ColorRGBA.Pink);
        green2.setMaterial(mat3);
        
        
        Box box2 = new Box((float) 0.1, (float) 0.3, (float) 0.1);
        Geometry red = new Geometry("Box", box2);
        red.setLocalTranslation(new Vector3f(0, (float) 0.45,0));
        Material mat2 = new Material(assetManager,
                "Common/MatDefs/Misc/Unshaded.j3md");
        mat2.setColor("Color", ColorRGBA.Red);
        red.setMaterial(mat2);
        
        
        Sphere leftElbow = new Sphere(30,30, (float) 0.15,true,true);
        Geometry green = new Geometry("Sphere",leftElbow);
        green.setLocalTranslation(new Vector3f(0,0,0));
        Material mat4 = new Material(assetManager,
                "Common/MatDefs/Misc/Unshaded.j3md");
        mat4.setColor("Color",ColorRGBA.Green);
        green.setMaterial(mat4);

        
        
        
        
        Box box1 = new Box((float) 0.1, (float) 0.3, (float) 0.1);
        Geometry blue = new Geometry("Box", box1);
        blue.setLocalTranslation(new Vector3f(0, (float) -0.45,0));
        Material mat1 = new Material(assetManager,
                "Common/MatDefs/Misc/Unshaded.j3md");
        mat1.setColor("Color", ColorRGBA.Blue);
        blue.setMaterial(mat1);

        //Node pivot = new Node("pivot");
        //rootNode.attachChild(pivot); // put this node in the scene        
        
       
        secondbox.attachChild(red);
        sphere.attachChild(green);
        sphere.attachChild(firstbox);
        firstbox.attachChild(blue);
        secondbox.attachChild(sphere);
        
        
        
        sphere2.attachChild(green2);
        sphere2.attachChild(secondbox);
        rootNode.attachChild(sphere2);
        
        
        
   
        
        sphere2.rotate(.3f,.3f,.3f);
        firstbox.rotate((float) -1.0472,0,0);
        
        
        
        //Quaternion roll180 = new Quaternion();
        //roll180.fromAngleAxis(FastMath.PI/4 , new Vector3f(1,0,0) );
        // The rotation is applied: The object rolls by 180 degrees. //
        //firstbox.setLocalRotation( roll180 );
       
       
    }

    @Override
    public void simpleUpdate(float tpf) {
        //Quaternion ROLL045  = new Quaternion().fromAngleAxis(FastMath.PI/4,   new Vector3f(0,0,1));
        //Quaternion PITCH045 = new Quaternion().fromAngleAxis(FastMath.PI/4,   new Vector3f(1,0,0));
        //firstbox.rotate(tpf,0,0);
        //firstbox.rotateUpTo(new Vector3f(1,0,0));
        
        //firstbox.rotate(-tpf, 0, 0);
        //sphere2.rotate(-tpf,0,0);
        
    }

    
}
*/