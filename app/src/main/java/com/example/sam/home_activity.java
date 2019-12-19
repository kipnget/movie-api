package com.example.sam;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.internal.Utils;


public class home_activity extends AppCompatActivity{


    RecyclerViewAdapter adapter;
    ArrayList<Integer> Image;
    RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_acticty);


        //getting the toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        //setting the title
        toolbar.setTitle("My Movies");

        //placing toolbar in place of actionbar
        setSupportActionBar(toolbar);


        Image = new ArrayList<>(Arrays.asList(
                R.drawable.image_1,R.drawable.image2,
                R.drawable.image3,R.drawable.image4,
                R.drawable.image5,R.drawable.image6,
                R.drawable.image7,R.drawable.images,
                R.drawable.image9,R.drawable.img10,
                R.drawable.img1,R.drawable.img2,
                R.drawable.img3,R.drawable.img4,
                R.drawable.img5,R.drawable.img6,
                R.drawable.img7,R.drawable.img8,
                R.drawable.img9)
        );
        recyclerView = findViewById(R.id.stagRecyclerView);

        layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerViewAdapter(this, Image);
        recyclerView.setAdapter(adapter);
    }



    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        //getting the search view from the menu
        MenuItem searchViewItem = menu.findItem(R.id.menuSearch);

        //getting search manager from systemservice
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        //getting the search view
        final SearchView searchView = (SearchView) searchViewItem.getActionView();

        //you can put a hint for the search input field
        searchView.setQueryHint("Search Movie");
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        //by setting it true we are making it iconified
        //so the search input will show up after taping the search iconified
        //if you want to make it visible all the time make it false
        searchView.setIconifiedByDefault(true);

        //here we will get the search query
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                //do the search here
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }
}
