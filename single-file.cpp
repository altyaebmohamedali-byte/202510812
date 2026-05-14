#include <iostream>
#include <string>
using namespace std;

void congratulate() {
    string name;
    cout << "Enter your name: ";
    cin >> name;
    cout << "Congratulations, " << name << "!" << endl;
}

int main() {
    congratulate();
    return 0;
}
    
