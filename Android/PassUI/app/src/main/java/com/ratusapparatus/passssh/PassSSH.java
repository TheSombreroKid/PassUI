package com.ratusapparatus.passssh;

import android.app.Dialog;

/**
 * Created by Sombrero on 24/11/2014.
 */
public class PassSSH
{
    public enum AuthType
    {
        AUTH_TYPE_PASSWORD,
        AUTH_TYPE_PRIVATE_KEY
    }

    public PassSSH()
    {
        //System.loadLibrary("sslcrypto");
        //System.loadLibrary("ssl");
        System.loadLibrary("passssh");
        nativeObject = Create();
    }
    long nativeObject;

    private native long Create();

    private long ptr(){return nativeObject;}

    //SSH details to use
    public native boolean Init(String server, int port, String username, String passphrase, String key, String pubkey,   AuthType authType);

    //Fetch
    public native String[] GetPassIDs();
    public native String GetPass(String id, String gpg_password);

    //Set
    public native void InsertPass(String id, String pass);
    public native void GeneratePass(String id, boolean withSymbols, int length);
}
