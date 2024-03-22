#include <iostream>
using namespace std;

int main()
{
    int gr;
    cout << "Bienvenid@, para calcular su IPE ingrese los siguentes datos: \n \n";
    cout << "Total de integrantes en el grupo familiar: "; cin >> gr;
    do
    {
        cout << "INGRESE UN VALOR VALIDO";
    }
        while(gr < 0);
}