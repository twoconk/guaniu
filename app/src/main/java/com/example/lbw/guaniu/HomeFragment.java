package com.example.lbw.guaniu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.lbw.guaniu.Music.MusicActivity;
import com.example.lbw.guaniu.Poem.PoemActivity;
import com.example.lbw.guaniu.Song.SongActivity;
import com.example.lbw.guaniu.Story.StoryActivity;

/**
 * Created by lbw on 2017/8/2.
 */

public class HomeFragment extends Fragment implements View.OnClickListener {
    private LinearLayout story;
    private LinearLayout song;
    private LinearLayout poem;
    private LinearLayout music;
    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home,container,false);
        initView();
        story.setOnClickListener(this);
        song.setOnClickListener(this);
        poem.setOnClickListener(this);
        music.setOnClickListener(this);
        return view;
    }

    private void initView() {
        story = (LinearLayout) view.findViewById(R.id.story);
        song = (LinearLayout)view.findViewById(R.id.song);
        poem = (LinearLayout)view.findViewById(R.id.poem);
        music = (LinearLayout)view.findViewById(R.id.music);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.story:
                Intent intentStory = new Intent(getContext(),StoryActivity.class);
                startActivity(intentStory);
                break;
            case R.id.song:
                Intent intentSong = new Intent(getContext(),SongActivity.class);
                startActivity(intentSong);
                break;
            case R.id.poem:
                Intent intentPoem = new Intent(getContext(),PoemActivity.class);
                startActivity(intentPoem);
                break;
            case R.id.music:
                Intent intentMusic = new Intent(getContext(),MusicActivity.class);
                startActivity(intentMusic);
                break;
            default:
                break;
        }
    }
}
