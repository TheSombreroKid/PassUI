package com.ratusapparatus.passui;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ToggleButton;

public class Server extends Fragment
{
    public Server()
    {
        // Required empty public constructor
    }

   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
   {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_server, container, false);

        String server = PreferenceManager.getDefaultSharedPreferences(getActivity()).getString("Server", "");
        String username = PreferenceManager.getDefaultSharedPreferences(getActivity()).getString("Name", "");
        String password = PreferenceManager.getDefaultSharedPreferences(getActivity()).getString("Pass", "");
        String port = PreferenceManager.getDefaultSharedPreferences(getActivity()).getString("Port", "");
        boolean keyAuth = PreferenceManager.getDefaultSharedPreferences(getActivity()).getBoolean("KeyAuth", false);
        EditText addressEditText = (EditText)view.findViewById(R.id.addressEditText);
        EditText nameEditText = (EditText)view.findViewById(R.id.nameEditText);
        EditText passEditText = (EditText)view.findViewById(R.id.passEditText);
        EditText portEditText = (EditText)view.findViewById(R.id.portEditText);
        ToggleButton keyAuthToggleButton = (ToggleButton)view.findViewById(R.id.keyAuthToggleButton);
        addressEditText.setText(server);
        nameEditText.setText(username);
        passEditText.setText(password);
        portEditText.setText(port);
        keyAuthToggleButton.setChecked(keyAuth);

        return view;
   }

    public void SaveData()
    {
        EditText addressEditText = (EditText)getView().findViewById(R.id.addressEditText);
        EditText nameEditText = (EditText)getView().findViewById(R.id.nameEditText);
        EditText passEditText = (EditText)getView().findViewById(R.id.passEditText);
        EditText portEditText = (EditText)getView().findViewById(R.id.portEditText);
        ToggleButton keyAuthToggleButton = (ToggleButton)getView().findViewById(R.id.keyAuthToggleButton);
        String server = addressEditText.getText().toString();
        String username = nameEditText.getText().toString();
        String password = passEditText.getText().toString();
        String port = portEditText.getText().toString();
        boolean keyAuth = keyAuthToggleButton.isChecked();
        PreferenceManager.getDefaultSharedPreferences(getActivity()).edit().putString("Server", server).commit();
        PreferenceManager.getDefaultSharedPreferences(getActivity()).edit().putString("Name", username).commit();
        PreferenceManager.getDefaultSharedPreferences(getActivity()).edit().putString("Pass", password).commit();
        PreferenceManager.getDefaultSharedPreferences(getActivity()).edit().putString("Port", port).commit();
        PreferenceManager.getDefaultSharedPreferences(getActivity()).edit().putBoolean("KeyAuth", keyAuth).commit();
    }


    public static Server newInstance()
    {
        return new Server();
    }
}
