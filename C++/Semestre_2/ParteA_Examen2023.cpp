
/*Los profesores de la escuela de informática dejan distintos tipos de caramelos (bombones, calugas, media hora, etc.)
en un frasco comunitario. El frasco es mágico: sólo puede sacarse de un caramelo a la vez y siempre el último que se puso en el frasco.
Cada lunes los profesores agregan dulces al frasco comunitario
En base a lo anterior se pide:
A. Programe la estructura (definición y atributos) de la clase Frasco que tiene un
atributo un stack<string> caramelos donde cada elemento representa el nombre del caramelo correspondiente.

B. Programe el método map<string, int> queTieneElFrasco(),que devuelve un map cuya llave es el nombre del caramelo
y su contenido la cantidad de dicho caramelo que hay en el frasco. Al terminar este método, el stack‹string>caramelos
debe quedar igual que al inicio.

C. Programe el método map<string, int> anadirCaramelos(queue<string> caramelos), que recibe en una cola la lista de caramelos
que un profesor añade al frasco. El método devuelve un map como él descrito en el punto (B), pero sólo para los caramelos que
acaban de ser añadidos.

D. Programe el método string sacarCaramelo(), que saca un caramelo del frasco y devuelve el nombre del caramelo que se obtuvo.*/

#include <iostream>
#include <map>
#include <vector>
#include <stack>
#include <queue>
using namespace std;

class Frasco
{
private:
    stack<string> Caramelos;

public:
    map<string, int> queTieneElFrasco()
    {
        stack<string> copia = Caramelos;
        map<string, int> contenido;
        map<string, int>::iterator ite;
        ite = contenido.find(copia.top());
        while (!copia.empty())
        {
            if (ite != contenido.end())
            {
                ite->second++;
            }
            else
            {
                contenido[copia.top()] = 1;
                //contenido.insert({copia.top(), 1});
            }

            copia.pop();
        }
        return contenido;
    }

    map<string, int> anadirCaramelos(queue<string> caramelos)
    {
        map<string, int> agregados;
        map<string, int>::iterator ite;
        ite = agregados.find(caramelos.front());
        while (!caramelos.empty())
        {
            if (ite != agregados.end())
            {
                ite->second++;
            }
            else
            {

                agregados[caramelos.front()] = 1;
                //agregados.insert({caramelos.front(), 1});
            }
            Caramelos.push(caramelos.front()); // linea agrega la cola al stack de caramelos del frasco
            caramelos.pop();                   // linea quita el elemnto de la cola para seguir el while sin problemas
        }
        return agregados;
    }
    string sacarCaramelo()
    {
        string aux = Caramelos.top();
        Caramelos.pop();
        return aux;
    }
};

int main()
{
    cout << "hola mundo"<< endl;
    cout << "xao xavales";
}