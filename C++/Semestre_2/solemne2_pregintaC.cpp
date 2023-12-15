/*Se le ha encomendado a usted realizar modificaciones en la clase Deportista y construir la clase Paradeportista, considerando:
a) Programe la clase ParaDeportista considerando como obligatorio el uso de herencia. La clase debe contener un metodo
imprimir que imprima los datos del paradeportista.

b) Considere que todos los deportistas(incluyendo los paradeportistas) quedan registrados en una clase llamada Stgo2023
cuyo unico atibuto es un vector de objetos
tipo Deportista llamado participantes. Programe el metodo void listarPartipantes() en la clase ParticipantesStgo2023 de modo que
imprima todos los particiapntes registrados con todos sus atributos.
Indique si es necesairo realizar algun cambio en algun metodo de la clase Deportista.*/

#include <iostream>
#include <vector>
using namespace std;

class Deportista
{
    protected:
        string nombre, pais, especialidad;
    public:
        Deportista(string nombre, string pais, string especialidad)
        {
            this->nombre = nombre;
            this->pais = pais;
            this->especialidad = especialidad;
        }
    // getters
    string GetPais()
    {
        return pais;
    }
    string GetNombre()
    {
        return nombre;
    }
    string GetEspecialidad()
    {
        return especialidad;
    }

    void imprimir()
    {
        cout << "Nombre " << nombre << endl;
        cout << "pais " << pais << endl;

    }

};

class Paradeportista : private Deportista
{
    private:
        string discapacidad;
    public:
        Paradeportista(string nombre, string pais, string especialidad, string discapacidad) :
        Deportista (nombre, pais, especialidad)
        {
            this->discapacidad = discapacidad;
        }
    void imprimir()
    {
        cout << "Nombre : " << GetNombre() << endl;
        cout << "Pais : " << GetPais() << endl;
        cout << "Especialidad : " << GetEspecialidad() << endl;
        cout << "Discapacidad : " << discapacidad << endl;

    }

};