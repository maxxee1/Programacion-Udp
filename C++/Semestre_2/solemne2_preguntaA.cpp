#include <iostream>
#include <stack>
#include <queue>

using namespace std;

class Encuestas
{
    private:
        queue<string>primera;
        stack<string>segunda;
    public:
        Encuestas()
        {
        }
    void insertarRespuestas(int numeroEncuesta, string respuesta)
    {
        if(numeroEncuesta == 1)
        {
            primera.push(respuesta);
        }
        else if(numeroEncuesta == 2)
        {
            segunda.push(respuesta);
        }
        else
        {
            cout << "Ingrese una encuesta valida" << endl;
        }
    }
    int cantidadCambioRespuesta()
    {
        queue<string>copia = primera;
        stack<string>copia2 = segunda;
        int contador=0;
        if(primera.size() != segunda.size())
        {
            return -1;
        }
        else if(primera.size() == segunda.size())
        {
            while(!primera.size())
            {
                if(primera.front() != segunda.top())
                {
                    contador++;
                    
                }
                primera.pop();
                segunda.pop();
            }
        }
        return contador;
    }
    void imprimeResultadoEncuesta2()
    {
        int favor = 0,contra = 0,indesi = 0,nocontes = 0;
        stack<string>aux = segunda;

        while(!aux.empty())
        {
            if(aux.top() == "favor")
            {
                favor++;
            }
            if(aux.top() == "contra")
            {
                contra++;
            }
            if(aux.top() == "indesiso")
            {
                indesi++;
            }
            if(aux.top() == "nocontesta")
            {
                nocontes++;
            }
            aux.pop();
        }

        cout << "Los resultados son : " << endl;
        cout << "A favor : " << favor << endl;
        cout << "En contra : " << contra << endl;
        cout << "Indesiso : " << indesi << endl;
        cout << "No contesta : " << nocontes << endl;
    }
};

int main()
{
    cout << endl << endl << "Bienvenid@ al registro de preferencias sobre el Plebicito"<< endl << endl;
    int x; cout << "Ingrese la cantidad de encuestados: "; cin >> x; cout << endl;

    for(int i=0 ; i<=x;i++)
    {
        string x;
        cout << "Encuestado " << i << endl;
        cin >> x;
        
    }
}