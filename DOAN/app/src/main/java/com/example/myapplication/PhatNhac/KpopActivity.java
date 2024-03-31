package com.example.myapplication.PhatNhac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.Song.KpopSong;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class KpopActivity extends AppCompatActivity {
    TextView txtTitleKpop, txtTimeSongKpop, txtTimeTotalKpop;
    SeekBar skSongKpop;
    ImageView HinhKpop;
    ImageButton btnPreKpop, btnPlayKpop, btnStopKpop, btnNextKpop, btnMenu, ibBackKpop;
    ArrayList<KpopSong> kpopSong;

    Animation animation;
    int position =0;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_kpop );
        Anhxa();
        AddKpopSong();
        animation = AnimationUtils.loadAnimation(this, R.anim.disc_animation);
        KhoitaoMediaPlayer();
        ibBackKpop.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(KpopActivity.this, MainActivity.class);
                startActivity( i );
            }
        } );

        btnNextKpop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position++;
                if(position > kpopSong.size()-1){
                    position =0;
                }
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                KhoitaoMediaPlayer();
                mediaPlayer.start();
                btnPlayKpop.setImageResource(R.drawable.pause);
                SetTimetotal();
                UpdateTimeSong();
                HinhKpop.startAnimation(animation);

            }
        });

        btnPreKpop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position--;
                if(position < 0){
                    position =kpopSong.size()-1;
                }
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                KhoitaoMediaPlayer();
                mediaPlayer.start();
                btnPlayKpop.setImageResource(R.drawable.pause);
                SetTimetotal();
                UpdateTimeSong();
                HinhKpop.startAnimation(animation);

            }
        });

        btnPlayKpop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    //pause --> đổi hình
                    mediaPlayer.pause();
                    btnPlayKpop.setImageResource(R.drawable.play);
                } else {
                    mediaPlayer.start();
                    btnPlayKpop.setImageResource(R.drawable.pause);
                    HinhKpop.startAnimation(animation);
                }
                SetTimetotal();
                UpdateTimeSong();

            }
        });

        skSongKpop.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(skSongKpop.getProgress());
            }
        });
    }
    private void UpdateTimeSong(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat dinhdangGio = new SimpleDateFormat("mm:ss");
                txtTimeSongKpop.setText(dinhdangGio.format(mediaPlayer.getCurrentPosition()));
                //update seek bar cho chạy theo thời gian bài hát
                skSongKpop.setProgress(mediaPlayer.getCurrentPosition());
                // bắt thời gian kết thúc của bài để chuyển nhạc
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        position++;
                        if(position > kpopSong.size()-1) {
                            position =0;
                        }
                        if(mediaPlayer.isPlaying()){
                            mediaPlayer.stop();
                        }
                        KhoitaoMediaPlayer();
                        mediaPlayer.start();
                        btnPlayKpop.setImageResource(R.drawable.pause);
                        SetTimetotal();
                        UpdateTimeSong();
                    }
                });
                handler.postDelayed(this,100);
            }
        }, 100);
    }
    private void SetTimetotal(){
        SimpleDateFormat dinhdangtime = new SimpleDateFormat("mm:ss");
        txtTimeTotalKpop.setText(dinhdangtime.format(mediaPlayer.getDuration()));
        //gán trị số max của bài hát = time bài hát
        skSongKpop.setMax(mediaPlayer.getDuration());
    }
    private void KhoitaoMediaPlayer(){
        mediaPlayer = MediaPlayer.create(KpopActivity.this, kpopSong.get(position).getKpopFile() );
        txtTitleKpop.setText(kpopSong.get(position).getKpopTitle());
    }
    private void AddKpopSong() {
        kpopSong = new ArrayList<>();
        kpopSong.add(new KpopSong("DITTO", R.raw.ditto));
        kpopSong.add(new KpopSong("FLOWERS", R.raw.flower));
        kpopSong.add(new KpopSong("Super Shy", R.raw.super_shy));
        kpopSong.add(new KpopSong("How You Like That", R.raw.how_you_like_that));
        kpopSong.add(new KpopSong("OMG", R.raw.omg));
    }


    private void Anhxa() {
        txtTimeSongKpop = (TextView) findViewById(R.id.textViewTimeSongKpop);
        txtTimeTotalKpop= (TextView) findViewById(R.id.textviewTimeTotalKpop);
        txtTitleKpop   = (TextView) findViewById(R.id.textviewTittleKpop);
        skSongKpop   = (SeekBar) findViewById(R.id.seekBarSongKpop);
        btnPreKpop    = (ImageButton) findViewById(R.id.imageButtonPrevKpop);
        btnPlayKpop    = (ImageButton) findViewById(R.id.imageButtonPlayKpop);
        btnNextKpop   = (ImageButton) findViewById(R.id.imageButtonNextKpop);
        HinhKpop      = (ImageView) findViewById(R.id.imageViewDisc);
        ibBackKpop= findViewById( R.id.ibBackKpop );
    }
    }
