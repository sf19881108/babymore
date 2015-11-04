package com.example.classify;

import com.example.main.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class GroundFragment extends Fragment {
	 @Override  
	    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){  
	        super.onCreateView(inflater, container, savedInstanceState);  
	        View chatView = inflater.inflate(R.layout.ground_activity_tab, container,false);  
	        return chatView;      
	    }  
	    @Override  
	    public void onActivityCreated(Bundle savedInstanceState){  
	        super.onActivityCreated(savedInstanceState);  
	    }
}
