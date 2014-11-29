#pragma once
#include <vector>
#include <string>
using namespace std;

enum AuthType
{
	AUTH_TYPE_PASSWORD,
	AUTH_TYPE_PRIVATE_KEY
};

class PassSSH
{
public:
    //SSH details to use
    bool Init(string server, string username, string passphrase, AuthType authType);

    //Fetch
    vector<string> GetPassIDs();
    string GetPass(string id);

    //Set
    void InsertPass(string id, string pass);
    void GeneratePass(string id, bool withSymbols, int length);
	
private:
	AuthType m_authType;
	string m_server;
	uint16_t m_port;
	string m_username;
	string m_passphrase;
	
	void SessionStart();
};