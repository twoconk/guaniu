package com.example.lbw.guaniu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.lbw.guaniu.Music.MusicActivity;
import com.example.lbw.guaniu.Poem.PoemActivity;
import com.example.lbw.guaniu.Song.SongActivity;
import com.example.lbw.guaniu.Square.SquareActivity;
import com.example.lbw.guaniu.Story.StoryActivity;
import com.example.lbw.guaniu.musicdetail.MuiscDetailActivity;
import com.example.lbw.guaniu.personhome.PersonHome;

/**
 * Created by lbw on 2017/8/2.
 */

public class HomeFragment extends Fragment implements View.OnClickListener {
    private LinearLayout story;
    private LinearLayout song;
    private LinearLayout poem;
    private LinearLayout music;
    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;
    private LinearLayout moerMusic;
    private LinearLayout baby1;
    private LinearLayout baby2;
    private LinearLayout baby3;
    private LinearLayout baby4;
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
        image1.setOnClickListener(this);
        image2.setOnClickListener(this);
        image3.setOnClickListener(this);
        image4.setOnClickListener(this);
        moerMusic.setOnClickListener(this);
        baby1.setOnClickListener(this);
        baby2.setOnClickListener(this);
        baby3.setOnClickListener(this);
        baby4.setOnClickListener(this);
        return view;
    }

    private void initView() {
        story = (LinearLayout) view.findViewById(R.id.story);
        song = (LinearLayout)view.findViewById(R.id.song);
        poem = (LinearLayout)view.findViewById(R.id.poem);
        music = (LinearLayout)view.findViewById(R.id.music);
        image1 = (ImageView)view.findViewById(R.id.music_detail_one);
        image2 = (ImageView)view.findViewById(R.id.music_detail_two);
        image3 = (ImageView)view.findViewById(R.id.music_detail_three);
        image4 = (ImageView)view.findViewById(R.id.music_detail_four);
        moerMusic = (LinearLayout) view.findViewById(R.id.more_music);
        baby1 = (LinearLayout)view.findViewById(R.id.baby1);
        baby2 = (LinearLayout)view.findViewById(R.id.baby2);
        baby3 = (LinearLayout)view.findViewById(R.id.baby3);
        baby4 = (LinearLayout)view.findViewById(R.id.baby4);
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
            case R.id.music_detail_one:
                Intent intentDetailOne = new Intent(getContext(),MusicPlayerActivity.class);
                startActivity(intentDetailOne);
                break;
            case R.id.music_detail_two:
                Intent intentDetailTwo = new Intent(getContext(),MusicPlayerActivity.class);
                startActivity(intentDetailTwo);
                break;
            case R.id.music_detail_three:
                Intent intentDetailThree = new Intent(getContext(),MusicPlayerActivity.class);
                startActivity(intentDetailThree);
                break;
            case R.id.music_detail_four:
                Intent intentDetailFour = new Intent(getContext(),MusicPlayerActivity.class);
                startActivity(intentDetailFour);
                break;
            case R.id.more_music:
                Intent intentSquare = new Intent(getContext(), SquareActivity.class);
                startActivity(intentSquare);
                break;
            case R.id.baby1:
                Intent intentBaby1 = new Intent(getContext(), PersonHome.class);
                startActivity(intentBaby1);
                break;
            case R.id.baby2:
                Intent intentBaby2 = new Intent(getContext(), PersonHome.class);
                startActivity(intentBaby2);
                break;
            case R.id.baby3:
                Intent intentBaby3 = new Intent(getContext(), PersonHome.class);
                startActivity(intentBaby3);
                break;
            case R.id.baby4:
                Intent intentBaby4 = new Intent(getContext(), PersonHome.class);
                startActivity(intentBaby4);
                break;
            default:
                break;
        }
    }
}
