/*Los estudiantes de informatica de la Univesidad han cerado el evento clasificatoias MundialXFIFA,
que es una mundial de games juego Fifa. En el evento participan
los mismos paises que juegan en las clasificatorias mundial 2026
(Argentina, Bolivia, Brasil, Chile, Colombia, Ecuador, Paraguay, Perú, Uruguay y Venezuela). Cada
país puede mandar más de un equipo o bien no participar.

Usted ayudara a construir el aplicativo que permita registrar el evento. Se le pide:

a) Programe la clase Equipo, que tiene los siguien atributos: nombreEquipo, país.
Solo debe progamar la estructura Clase (atributos), constructor con parametros y un metodo imprimir

b)Programe la esctructura (Solo atributos) de la clase Evento
que tiene como parametro un vector de objetos tipo Equipo llamado listadoParticipantes

c)Programe en la clase Evento la funcion bool participa(string país)
que deuvuelve true si el país como parametro tiene al menos un equipo participando
(esto es, está en el vector listadoParticipantes) y false en caso contrario.

d)Programe en la clase Evento el metodo vector<string> noParticipan()
que devuelve (en un vector de string) el listado de paises que no mandaron ningun equipo al evento*/
#include <iostream>
#include <vector>
using namespace std;

class Equipo
{
    private:
      string nombreEquipo, pais;

    public:
        Equipo(string nombreEquipo, string pais)
        {
            this->nombreEquipo = nombreEquipo;
            this->pais = pais;
        }
        string GetPais()
        {
            return pais;
        }
};

class Evento
{
    private:
        vector<Equipo>listadoParticipantes;
    public:
        bool participa(string pais)
        {
            for(int i = 0; i<listadoParticipantes.size(); i++)
            {
                if(listadoParticipantes[i].GetPais() != pais)
                {
                    false;
                    break;
                }
                else
                {
                    true;
                    break;
                }
            }
        }
        vector<string>no_participan()
        {
            vector<string>noparticipo;
            for(int i=0; i <listadoParticipantes.size(); i++)
            {
                if(listadoParticipantes[i].GetPais() != "Chile")
                {
                    noparticipo.push_back("Chile");
                }
            }
            for(int i=0; i <listadoParticipantes.size(); i++)
            {
                if(listadoParticipantes[i].GetPais() != "Argentina")
                {
                    noparticipo.push_back("Argentina");
                }
            }
            return noparticipo;
        }
};

