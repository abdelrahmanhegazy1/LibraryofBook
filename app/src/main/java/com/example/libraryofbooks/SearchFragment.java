package com.example.libraryofbooks;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SearchFragment extends Fragment {
    @Nullable

    EditText searchText;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            //Ben3rf feh en el layout bet3ha keda
            View view= inflater.inflate(R.layout.search_fragment,container,false);
       // RecyclerView recyclerView=view.findViewById(R.id.recyclerSearch);
       // LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this.getActivity());
       // recyclerView.setLayoutManager(linearLayoutManager);
       // searchText= view.findViewById(R.id.SearchText);

        //SearchMovieAdapter searchMovieAdapter= new SearchMovieAdapter();
        //recyclerView.setAdapter(searchMovieAdapter);
       // JsonParse();


        return  view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //hena ben7ot el views bet3tna 3ady

    }

    public  void JsonParse()
    {
        final String[] Authors= new String[4];


        String name=searchText.getText().toString();
        String link="https://www.googleapis.com/books/v1/volumes?q=artofwar";
        JsonObjectRequest request= new JsonObjectRequest(Request.Method.GET, link, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray itemsJsonArray=response.getJSONArray("items");
                            for(int i=0;i<itemsJsonArray.length();i++)
                            {
                                JSONObject item= itemsJsonArray.getJSONObject(i);
                                JSONObject volumeInfo= item.getJSONObject("volumeInfo");
                                String title= volumeInfo.getString("title");
                                Log.d("here", "onResponse: "+title);



                               /* JSONArray authorsArray=itemsJsonArray.getJSONArray(i);
                                for(int j=0;j<authorsArray.length();j++)
                                {
                                    //JSONObject name= authorsArray.getJSONObject(j);
                                    Authors[j]= authorsArray.getString(j);
                                }

                               */


                            }

                        }

                        catch (JSONException e)
                        {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });



    }



}
