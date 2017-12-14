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
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 * @author normenhansen
 */
public class Main extends SimpleApplication {
    
    Material bodyMaterial;
    Material bodyPartMaterial;
    Material jointsMaterial;
    Node neckNode;
    Node headNode;
    
    Node bodyNode;
    
    Node rightArmJointUpNode;
    Node rightArmUpNode;
    Node rightArmJointDownNode;
    Node rightArmDownNode;
    
    Node leftArmJointUpNode;
    Node leftArmUpNode;
    Node leftArmJointDownNode;
    Node leftArmDownNode;
    
    Node leftLegJointUpNode;
    Node leftLegUpNode;
    Node leftLegJointDownNode;
    Node leftLegDownNode;
    
    Node rightLegJointUpNode;
    Node rightLegUpNode;
    Node rightLegJointDownNode;
    Node rightLegDownNode;
    
    
    protected float alpha = 0.0f;
    

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }
    
     
    @Override
    public void simpleInitApp() {
        flyCam.setDragToRotate(true);
        
        bodyMaterial = new Material (assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        bodyMaterial.setColor("Color",ColorRGBA.Green);
        
        bodyPartMaterial = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        bodyPartMaterial.setColor("Color",ColorRGBA.DarkGray);
                
        jointsMaterial = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        jointsMaterial.setColor("Color",ColorRGBA.Magenta);
        
        
        createBody();
        createHead();
        createRightArm();
        createLeftArm();
        createLeftLeg();
        createRightLeg();
       
    }
    
    public void createBody(){
        
        Box bodyBox = new Box(1,1,1);
        Geometry bodyGeometry = new Geometry("BodyBox",bodyBox);
        bodyGeometry.setMaterial(bodyMaterial);
        
        bodyNode = new Node("BodyNode");
        rootNode.attachChild(bodyNode);
        bodyNode.attachChild(bodyGeometry);
        
        
        //rootNode.rotate(.3f,.3f,.3f);
    }
    
    public void createHead(){
        
        Box neckBox = new Box((float) 0.3, (float) 0.3, (float) 0.3);
        Geometry neckGeometry = new Geometry("NeckBox",neckBox);
        neckGeometry.setMaterial(jointsMaterial);
        
        Sphere headSphere = new Sphere(30,30,1,true,true);
        Geometry headGeometry = new Geometry("HeadSpehere",headSphere);
        headGeometry.setMaterial(bodyPartMaterial);
        
        neckNode = new Node("neckNode");
        neckNode.setLocalTranslation(0, (float) 1.3, 0);
        
        headNode = new Node("headNode");
        headNode.setLocalTranslation(0, (float) 1.3,0);
        
        bodyNode.attachChild(neckNode);
        neckNode.attachChild(neckGeometry);
        neckNode.attachChild(headNode);
        headNode.attachChild(headGeometry);
        
    }
    
    public void createRightArm(){
        
        Sphere rightArmJointUpSphere = new Sphere(30,30, (float) 0.2,true,true);
        Geometry rightArmJointUpGeometry = new Geometry("RightArmJointUpSphere",rightArmJointUpSphere);
        rightArmJointUpGeometry.setMaterial(jointsMaterial);
        
        Box rightArmUpBox = new Box((float) 0.2, (float) 0.4, (float) 0.2);
        Geometry rightArmUpGeometry = new Geometry("RightArmUpBox",rightArmUpBox);
        rightArmUpGeometry.setLocalTranslation(new Vector3f(0, (float) -0.6,0));
        rightArmUpGeometry.setMaterial(bodyPartMaterial);
        
        Sphere rightArmJointDownSphere = new Sphere(30,30, (float) 0.2, true, true);
        Geometry rightArmJointDownGeometry = new Geometry("RightArmJoinDownSphere",rightArmJointDownSphere);
        rightArmJointDownGeometry.setMaterial(jointsMaterial);
        
        Box rightArmDownBox = new Box((float) 0.2, (float) 0.4, (float) 0.2);
        Geometry rightArmDownGeometry = new Geometry("RightArmDownBox",rightArmDownBox);
        rightArmDownGeometry.setLocalTranslation(new Vector3f(0, (float) -0.6,0));
        rightArmDownGeometry.setMaterial(bodyPartMaterial);
        
        rightArmJointUpNode = new Node("rightArmJointUpNode");
        rightArmJointUpNode.setLocalTranslation((float) 1.3,1,0);
        
        rightArmUpNode = new Node("rightArmUpNode");
        
        rightArmJointDownNode = new Node("rightArmJointDownNode");
        rightArmJointDownNode.setLocalTranslation((float) 0, (float) -1.2, 0);
        
        rightArmDownNode = new Node("rightArmNode");
        
        bodyNode.attachChild(rightArmJointUpNode);
        rightArmJointUpNode.attachChild(rightArmJointUpGeometry);
        rightArmJointUpNode.attachChild(rightArmUpNode);
        rightArmUpNode.attachChild(rightArmUpGeometry);
        rightArmUpNode.attachChild(rightArmJointDownNode);
        rightArmJointDownNode.attachChild(rightArmJointDownGeometry);
        rightArmJointDownNode.attachChild(rightArmDownNode);
        rightArmDownNode.attachChild(rightArmDownGeometry);
        rightArmDownNode.rotate(0,0,.4f);
    }
    
    public void createLeftArm(){
        
        Sphere leftArmJointUpSphere = new Sphere(30,30, (float) 0.2,true,true);
        Geometry leftArmJointUpGeometry = new Geometry("LeftArmJointUpSphere",leftArmJointUpSphere);
        leftArmJointUpGeometry.setMaterial(jointsMaterial);
        
        Box leftArmUpBox = new Box((float) 0.2, (float) 0.4, (float) 0.2);
        Geometry leftArmUpGeometry = new Geometry("LeftArmUpBox",leftArmUpBox);
        leftArmUpGeometry.setLocalTranslation(new Vector3f(0, (float) 0.6,0));
        leftArmUpGeometry.setMaterial(bodyPartMaterial);
        
        Sphere leftArmJointDownSphere = new Sphere(30,30, (float) 0.2, true, true);
        Geometry leftArmJointDownGeometry = new Geometry("LeftArmJoinDownSphere",leftArmJointDownSphere);
        leftArmJointDownGeometry.setMaterial(jointsMaterial);
        
        Box leftArmDownBox = new Box((float) 0.2, (float) 0.4, (float) 0.2);
        Geometry leftArmDownGeometry = new Geometry("LeftArmDownBox",leftArmDownBox);
        leftArmDownGeometry.setLocalTranslation(new Vector3f(0, (float) 0.6,0));
        leftArmDownGeometry.setMaterial(bodyPartMaterial);
        
        leftArmJointUpNode = new Node("leftArmJointUpNode");
        leftArmJointUpNode.setLocalTranslation((float) -1.3,1,0);
        
        leftArmUpNode = new Node("leftArmUpNode");
        
        leftArmJointDownNode = new Node("leftArmJointDownNode");
        leftArmJointDownNode.setLocalTranslation((float) 0, (float) 1.2, 0);
        
        leftArmDownNode = new Node("leftArmNode");
        
        bodyNode.attachChild(leftArmJointUpNode);
        leftArmJointUpNode.attachChild(leftArmJointUpGeometry);
        leftArmJointUpNode.attachChild(leftArmUpNode);
        leftArmUpNode.attachChild(leftArmUpGeometry);
        leftArmUpNode.attachChild(leftArmJointDownNode);
        leftArmJointDownNode.attachChild(leftArmJointDownGeometry);
        leftArmJointDownNode.attachChild(leftArmDownNode);
        leftArmDownNode.attachChild(leftArmDownGeometry);
        leftArmDownNode.rotate((float) -2.3,0, (float) 1.2);
        
    }
    
    public void createLeftLeg(){
        Sphere leftLegJointUpSphere = new Sphere(30,30, (float) 0.2,true,true);
        Geometry leftLegJointUpGeometry = new Geometry("LeftLegJointUpSphere",leftLegJointUpSphere);
        leftLegJointUpGeometry.setMaterial(jointsMaterial);
        
        Box leftLegUpBox = new Box((float) 0.2, (float) 0.6, (float) 0.2);
        Geometry leftLegUpGeometry = new Geometry("LeftLegUpBox",leftLegUpBox);
        leftLegUpGeometry.setLocalTranslation(new Vector3f(0, (float) -0.8,0));
        leftLegUpGeometry.setMaterial(bodyPartMaterial);
        
        Sphere leftLegJointDownSphere = new Sphere(30,30, (float) 0.2, true, true);
        Geometry leftLegJointDownGeometry = new Geometry("LeftLegJoinDownSphere",leftLegJointDownSphere);
        leftLegJointDownGeometry.setMaterial(jointsMaterial);
        
        Box leftLegDownBox = new Box((float) 0.2, (float) 0.6, (float) 0.2);
        Geometry leftLegDownGeometry = new Geometry("LeftLegDownBox",leftLegDownBox);
        leftLegDownGeometry.setLocalTranslation(new Vector3f(0, (float) -0.8,0));
        leftLegDownGeometry.setMaterial(bodyPartMaterial);
        
        
        leftLegJointUpNode = new Node("leftLegJointUpNode");
        leftLegJointUpNode.setLocalTranslation((float) -0.7, (float) -1.3,0);
        
        leftLegUpNode = new Node("leftLegUpNode");
        
        leftLegJointDownNode = new Node("leftLegJointDownNode");
        leftLegJointDownNode.setLocalTranslation((float) 0, (float) -1.62, 0);
        
        leftLegDownNode = new Node("leftLegNode");
        
        bodyNode.attachChild(leftLegJointUpNode);
        leftLegJointUpNode.attachChild(leftLegJointUpGeometry);
        leftLegJointUpNode.attachChild(leftLegUpNode);
        leftLegUpNode.attachChild(leftLegUpGeometry);
        leftLegUpNode.rotate(0,0,-.4f);
        leftLegUpNode.attachChild(leftLegJointDownNode);
        leftLegJointDownNode.attachChild(leftLegJointDownGeometry);
        leftLegJointDownNode.attachChild(leftLegDownNode);
        leftLegDownNode.attachChild(leftLegDownGeometry);
        leftLegDownNode.rotate(0,0,.4f);
    }
    
    private void createRightLeg(){
        
        Sphere rightLegJointUpSphere = new Sphere(30,30, (float) 0.2,true,true);
        Geometry rightLegJointUpGeometry = new Geometry("RightLegJointUpSphere",rightLegJointUpSphere);
        rightLegJointUpGeometry.setMaterial(jointsMaterial);
        
        Box rightLegUpBox = new Box((float) 0.2, (float) 0.6, (float) 0.2);
        Geometry rightLegUpGeometry = new Geometry("RightLegUpBox",rightLegUpBox);
        rightLegUpGeometry.setLocalTranslation(new Vector3f(0, (float) -0.8,0));
        rightLegUpGeometry.setMaterial(bodyPartMaterial);
        
        Sphere rightLegJointDownSphere = new Sphere(30,30, (float) 0.2, true, true);
        Geometry rightLegJointDownGeometry = new Geometry("RightLegJoinDownSphere",rightLegJointDownSphere);
        rightLegJointDownGeometry.setMaterial(jointsMaterial);
        
        
        Box rightLegDownBox = new Box((float) 0.2, (float) 0.6, (float) 0.2);
        Geometry rightLegDownGeometry = new Geometry("RightLegDownBox",rightLegDownBox);
        rightLegDownGeometry.setLocalTranslation(new Vector3f(0, (float) -0.8,0));
        rightLegDownGeometry.setMaterial(bodyPartMaterial);
        
        
        rightLegJointUpNode = new Node("rightLegJointUpNode");
        rightLegJointUpNode.setLocalTranslation((float) 0.7, (float) -1.3,0);
        
        rightLegUpNode = new Node("rightLegUpNode");
        
        rightLegJointDownNode = new Node("rightLegJointDownNode");
        rightLegJointDownNode.setLocalTranslation((float) 0, (float) -1.62, 0);
        
        rightLegDownNode = new Node("rightLegNode");
        
        bodyNode.attachChild(rightLegJointUpNode);
        rightLegJointUpNode.attachChild(rightLegJointUpGeometry);
        rightLegJointUpNode.attachChild(rightLegUpNode);
        rightLegUpNode.attachChild(rightLegUpGeometry);
        rightLegUpNode.rotate(0,0,.4f);
        rightLegUpNode.attachChild(rightLegJointDownNode);
        rightLegJointDownNode.attachChild(rightLegJointDownGeometry);
        rightLegJointDownNode.attachChild(rightLegDownNode);
        rightLegDownNode.attachChild(rightLegDownGeometry);
        rightLegDownNode.rotate(0,0,.4f);
        
    }

    @Override
    public void simpleUpdate(float tpf) {
       rightArmUpNode.rotate(tpf,0,0);
       rightArmDownNode.rotate(0,0,tpf);
       leftArmUpNode.rotate(tpf,0,0);
       leftArmDownNode.rotate(0,0,-tpf);
       rightLegUpNode.rotate(0,tpf,tpf);
       rightLegDownNode.rotate(tpf,tpf,0);
       leftLegUpNode.rotate(0,tpf,-tpf);
       leftLegDownNode.rotate(tpf,tpf,0);
       headNode.rotate(tpf,0,tpf);
       bodyNode.rotate(0,tpf,0);

    }

    
}
