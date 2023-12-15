#include <vector>
#include <map>
#include <queue>
#include <stack>
#include <iostream>

using namespace std;

class Visita
{
private:
    string nombreAlumno, nombreColegio, curso, nombreComuna, nacionalidad, carreraDeseada;
    int celular;

public:
    Visita()
    {
        // contructor vacio
    }
    // getters
    string GetCurso()
    {
        return curso;
    }
    string GetNombreColegio()
    {
        return nombreColegio;
    }
    string GetCarreraDeseada()
    {
        return carreraDeseada;
    }
    string GetNombreAlumno()
    {
        return nombreAlumno;
    }
};

class Registro
{
private:
    vector<Visita> visitas;

public:
    int cantidadDeVisitas4to()
    {
        int cant = 0;
        for (int i = 0; i < visitas.size(); i++)
        {
            if (visitas[i].GetCurso() == "4to Medio")
            {
                cant++;
            }
        }
        return cant;
    }

    void colegiosVisitante()
    {
        map<string, int> colegios;
        map<string, int>::iterator it;
    
        for (int i = 0; i < visitas.size(); i++)
        {
            it = colegios.find(visitas[i].GetNombreColegio());

            if (it != colegios.end())
            {
                it->second++;
            }
            else
            {
                colegios[visitas[i].GetNombreColegio()] = 1;
                // colegios.insert({visitas[i].GetNombreColegio(),1});
            }
        }
        for (it = colegios.begin(); it != colegios.end(); it++)
        {
            cout << "Nombre Colegio : " << it->first << ", "
                 << "cantidad de alumnos: " << it->second << endl;
        }
    }

    vector<string> listadoCarreraDeseada(string carrera)
    {
        vector<string> alumnoscarrera;
        for (int i = 0; i < visitas.size(); i++)
        {
            if (visitas[i].GetCurso() == "4to medio")
            {
                if (visitas[i].GetCarreraDeseada() == carrera)
                    alumnoscarrera.push_back(visitas[i].GetNombreAlumno());
            }
        }
        return alumnoscarrera; // retorna un vector con todos los nombres de los alumnos que desean esa carrera
    }
    void eliminaCursosinferiores()
    {
        for (int i = visitas.size() - 1; i >= 0; i--)
        {
            if (visitas[i].GetCurso() != "3ro medio" && visitas[i].GetCurso() != "4to medio")
            {
                visitas.erase(visitas.begin() + i);
            }
        }
    }
};

int main()
{
    cout << "Hola Mundo!";
}