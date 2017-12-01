#include "Sphere.hpp"

using namespace rt;

Intersection Sphere::getIntersection(const Line& line, double minDist, double maxDist)
{
    Intersection intersection;

    double A = (line.dx().x() * line.dx().x()) +
               (line.dx().y() * line.dx().y()) +
               (line.dx().z() * line.dx().z());

    double B = 2 * (line.dx().x() * (line.x0().x() - center().x()) +
                    line.dx().y() * (line.x0().y() - center().y()) +
                    line.dx().z() * (line.x0().z() - center().z()));
    
    double C = (line.x0().x() - center().x())*(line.x0().x() - center().x()) +
               (line.x0().y() - center().y())*(line.x0().y() - center().y()) +
               (line.x0().z() - center().z())*(line.x0().z() - center().z()) -
                radius()*radius();

    double delta = B * B - 4 * A * C;
    double  t0, t1, t;

    if (delta < 0)
        return intersection;

    if (delta == 0)
        t = (-1 * B + sqrt(delta)) / (2 * A);
    else
    {
        t0 = (-1 * B + sqrt(delta)) / (2 * A);
        t1 = (-1 * B - sqrt(delta)) / (2 * A);
        if (t0 < t1)
            t = t0;
        else
            t = t1;
    }

    if (t >= minDist && t <= maxDist)
    {
        Intersection inter(true, this, &line, t);
        return inter;
    }

    return intersection;
}


const Vector Sphere::normal(const Vector& vec) const {
    Vector n = vec - _center;
    n.normalize();
    return n;
}
