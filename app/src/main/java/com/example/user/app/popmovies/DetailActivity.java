package com.example.user.app.popmovies;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class DetailActivity extends AppCompatActivity {


    MovieFragment.FetchMovieTask movieTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /**get the movie's Object from the parent activity**/
        Movie movie = getIntent().getParcelableExtra("currentMovie");
        Log.v("######", "received title is " + movie.getTitle());
        Log.v("######", "received overview is " + movie.getOverview());
        Log.v("######", "received voting is " + movie.getRating());
        Log.v("######", "received releaseDate is " + movie.getDate());


        Bundle movieDetails = new Bundle();
        movieDetails.putParcelable("DETAIL_MOVIE", movie);
        Log.v("######", "received movie is " + movie);

        if(savedInstanceState == null){
            DetailFragment defaultMovieFragment = new DetailFragment();
            defaultMovieFragment.setArguments(movieDetails);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.movie_detail_container, defaultMovieFragment)
                    .commit();

        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
