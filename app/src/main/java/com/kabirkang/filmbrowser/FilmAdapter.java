package com.kabirkang.filmbrowser;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.kabirkang.filmbrowser.film.Film;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Kabir on 9/26/2016.
 */
public class FilmAdapter extends ArrayAdapter<Film> {
    private static final String LOG_TAG = FilmAdapter.class.getSimpleName();
    public FilmAdapter(Activity context, List<Film> films) {
        super(context, 0, films);
    }

    private static class ViewHolder {
        ImageView filmPoster;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Film film = getItem(position);
        ViewHolder viewHolder;
        String posterUrl = "http://image.tmdb.org/t/p/w185" + film.getPosterPath();

        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.film_item, parent, false);
            viewHolder.filmPoster = (ImageView) convertView.findViewById(R.id.film_poster);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Picasso.with(getContext()).load(posterUrl).into(viewHolder.filmPoster);
        return convertView;
    }
}
