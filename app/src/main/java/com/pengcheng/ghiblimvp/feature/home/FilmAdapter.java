package com.pengcheng.ghiblimvp.feature.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pengcheng.ghiblimvp.R;
import com.pengcheng.ghiblimvp.data.http.entity.Film;
import com.pengcheng.ghiblimvp.library.base.BaseRecyclerViewAdapter;

import java.security.InvalidParameterException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.annotations.NonNull;

/**
 * Created by ypc on 2/1/2018.
 */

public class FilmAdapter extends BaseRecyclerViewAdapter<FilmAdapter.FilmViewHolder> {

    class FilmViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.title_view)
        TextView titleTextView;

        @BindView(R.id.director_view)
        TextView directorTextView;

        @BindView(R.id.release_date_view)
        TextView releaseDateTextView;

        @BindView(R.id.score_view)
        TextView scoreTextView;

        @BindView(R.id.description_view)
        TextView descriptionTextView;

        FilmViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    private List<Film> filmList;

    public FilmAdapter(@NonNull List<Film> filmList) {
        this.filmList = filmList;
    }

    @Override public FilmViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_film, viewGroup, false);
        return new FilmViewHolder(view);
    }

    @Override public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        super.onBindViewHolder(viewHolder, i);
        FilmViewHolder vh = (FilmViewHolder) viewHolder;
        Film film = filmList.get(i);
        vh.titleTextView.setText(film.getTitle());
        vh.directorTextView.setText(film.getDirector());
        vh.releaseDateTextView.setText(film.getReleaseDate());
        vh.scoreTextView.setText(film.getRtScore());
        vh.descriptionTextView.setText(film.getDescription());
    }

    @Override public int getItemCount() {
        return filmList.size();
    }

    public void replaceData(List<Film> filmList) {
        this.filmList.clear();
        this.filmList.addAll(filmList);
        notifyDataSetChanged();
    }

    public void addData(Film data) {
        this.filmList.add(data);
        notifyDataSetChanged();
    }

    public Film getItem(int position) {
        if (position < 0 || position >= filmList.size()) {
            throw new InvalidParameterException("Invalid item index");
        }
        return filmList.get(position);
    }

    public void clearData() {
        filmList.clear();
        notifyDataSetChanged();
    }
}
