#include <cmath>
#include <iostream>
#include <string>

#include "Vector.hpp"
#include "Line.hpp"
#include "Geometry.hpp"
#include "Sphere.hpp"
#include "Image.hpp"
#include "Color.hpp"
#include "Intersection.hpp"
#include "Material.hpp"

#include "Scene.hpp"

using namespace std;
using namespace rt;

double imageToViewPlane(int n, int imgSize, double viewPlaneSize) {
    double u = (double)n*viewPlaneSize / (double)imgSize;
    u -= viewPlaneSize / 2;
    return u;
}

const Intersection findFirstIntersection(const Line& ray, double minDist, double maxDist)
{
    Intersection intersection;
    for (int i = 0; i < geometryCount; i++) {
        Intersection in = scene[i]->getIntersection(ray, minDist, maxDist);
        if (in.valid()) {
            if (!intersection.valid()) {
                intersection = in;
            }
            else if (in.t() < intersection.t()) {
                intersection = in;
            }
        }
    }

    return intersection;
}

int main() {
    Vector viewPoint(0, 0, 0);
    Vector viewDirection(0, 0, 1);
    Vector viewUp(0, -1, 0);

    double frontPlaneDist = 0;
    double backPlaneDist = 1000;

    double viewPlaneDist = 512;
    double viewPlaneWidth = 1024;
    double viewPlaneHeight = 768;

    int imageWidth = 1024;
    int imageHeight = 768;
    

    Vector viewParallel = viewUp^viewDirection;

    viewDirection.normalize();
    viewUp.normalize();
    viewParallel.normalize();

    Image image(imageWidth, imageHeight);

    // ADD CODE HERE
    Vector x0,x1;
    
    
    
    /////WITH LIGHTING
    


    for(int i=0;i<imageWidth;i++)
        for(int j=0;j<imageHeight;j++){
            x0 = viewPoint;
            x1 = viewPoint +
                 viewDirection * viewPlaneDist +
                 viewUp * imageToViewPlane(j,imageHeight,viewPlaneHeight)+
                 viewParallel * imageToViewPlane(i,imageWidth,viewPlaneWidth);
            
            Line line  = Line(x0,x1,false);
            Intersection firstInt = findFirstIntersection(line,frontPlaneDist,backPlaneDist);
            if(firstInt.valid())
            {
                Material material = firstInt.geometry()->material();
                Color color = material.ambient();
                
                //C - camera position vector (view point)
                Vector C = viewPoint;
                
                //V - intersection position vector
                Vector V = firstInt.vec();
                
                //E - vector from the intersection point to the camera
                Vector E = C - V ;
                E.normalize();
                
                //N - normal to the surface at the intersection
                Vector N = firstInt.geometry()->normal(V);
                N.normalize();
                
                for(int k=0; k<lightCount;k++)
                {
                    //L - light position vector
                    Vector L =  lights[k]->position();
                    
                    //T - vector from intersection point to the light
                    Vector T =  L-V;
                    T.normalize();
                    
                    //R - reflextion vector
                    Vector R = N * (N * T) * 2 - T;
                    R.normalize();
                    
                    if(N * T > 0)
                        color += material.diffuse() * lights[k]->diffuse() * (N * T);
                    
                    if(E* R > 0)
                        color += material.specular() * lights[k]->specular() * pow(E * R, material.shininess());
                    
                    color *= lights[k]->intensity() ;
                }
                
                image.setPixel(i, j, color);

            }
            else
                image.setPixel(i, j, Color(0,0,0));
        }

     
    
    
    ////WITHOUT LIGHTING
    
    /*
    for(int i=0;i<imageWidth;i++)
        for(int j=0;j<imageHeight;j++)
        {
            //image.setPixel(i, j, Color(255,0,0));
            x0 = viewPoint;
            x1 = viewPoint +
                 viewDirection * viewPlaneDist +
                 viewUp * imageToViewPlane(j,imageHeight,viewPlaneHeight)+
                 viewParallel * imageToViewPlane(i,imageWidth,viewPlaneWidth);
            Line line  = Line(x0,x1,true);
            Intersection firstInt = findFirstIntersection(line,frontPlaneDist,backPlaneDist);
            if(firstInt.valid())
            {
                Color color = firstInt.geometry()->material().ambient();
                image.setPixel(i, j, color);
            }
            else
                image.setPixel(i, j, Color(0,0,0));
        }
    
    */


    image.store("scene.png");

    for (int i = 0; i < geometryCount; i++) {
        delete scene[i];
    }

    return 0;
}
