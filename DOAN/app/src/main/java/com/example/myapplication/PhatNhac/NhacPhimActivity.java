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
import com.example.myapplication.Song.NhacPhimSong;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class NhacPhimActivity extends AppCompatActivity {
    TextView txtTitleNP, txtTimeSongNP, txtTimeTotalNP;
    SeekBar skSongNP;
    ImageView HinhNP;
    ImageButton btnPreNP, btnPlayNP, btnStopNP, btnNextNP, btnMenu, ibBackNP;
    ArrayList<NhacPhimSong> NPSong;

    Animation animation;
    int position =0;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_nhac_phim );
        Anhxa();
        AddNPSong();
        animation = AnimationUtils.loadAnimation(this, R.anim.disc_animation);
        KhoitaoMediaPlayer();
        ibBackNP.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(NhacPhimActivity.this, MainActivity.class);
                startActivity( i );
            }
        } );

        btnNextNP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position++;
                if(position > NPSong.size()-1){
                    position =0;
                }
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                KhoitaoMediaPlayer();
                mediaPlayer.start();
                btnPlayNP.setImageResource(R.drawable.pause);
                SetTimetotal();
                UpdateTimeSong();
                HinhNP.startAnimation(animation);

            }
        });

        btnPreNP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position--;
                if(position < 0){
                    position =NPSong.size()-1;
                }
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                KhoitaoMediaPlayer();
                mediaPlayer.start();
                btnPlayNP.setImageResource(R.drawable.pause);
                SetTimetotal();
                UpdateTimeSong();
                HinhNP.startAnimation(animation);

            }
        });

        btnPlayNP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    //pause --> đổi hình
                    mediaPlayer.pause();
                    btnPlayNP.setImageResource(R.drawable.play);
                } else {
                    mediaPlayer.start();
                    btnPlayNP.setImageResource(R.drawable.pause);
                    HinhNP.startAnimation(animation);
                }
                SetTimetotal();
                UpdateTimeSong();

            }
        });

        skSongNP.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(skSongNP.getProgress());
            }
        });
    }
    private void UpdateTimeSong(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat dinhdangGio = new SimpleDateFormat("mm:ss");
                txtTimeSongNP.setText(dinhdangGio.format(mediaPlayer.getCurrentPosition()));
                //update seek bar cho chạy theo thời gian bài hát
                skSongNP.setProgress(mediaPlayer.getCurrentPosition());
                // bắt thời gian kết thúc của bài để chuyển nhạc
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        position++;
                        if(position > NPSong.size()-1) {
                            position =0;
                        }
                        if(mediaPlayer.isPlaying()){
                            mediaPlayer.stop();
                        }
                        KhoitaoMediaPlayer();
                        mediaPlayer.start();
                        btnPlayNP.setImageResource(R.drawable.pause);
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
        txtTimeTotalNP.setText(dinhdangtime.format(mediaPlayer.getDuration()));
        //gán trị số max của bài hát = time bài hát
        skSongNP.setMax(mediaPlayer.getDuration());
    }
    private void KhoitaoMediaPlayer(){
        mediaPlayer = MediaPlayer.create(NhacPhimActivity.this, NPSong.get(position).getnhacphimFile() );
        txtTitleNP.setText(NPSong.get(position).getnhacphimTitle());
    }
    private void AddNPSong() {
        NPSong = new ArrayList<>();
        NPSong.add(new NhacPhimSong("Sao Cha Không", R.raw.sao_cha_khong));
        NPSong.add(new NhacPhimSong("Sau Lời Từ Khước", R.raw.sau_loi_tu_khuoc));
        NPSong.add(new NhacPhimSong("Cha Già Rồi Đúng Không", R.raw.cha_gia_roi_dung_khong));
        NPSong.add(new NhacPhimSong("Mình Chia Tay Đi", R.raw.minh_chia_tay_di));
        NPSong.add(new NhacPhimSong("Từ Đó", R.raw.tu_do));
    }


    private void Anhxa() {
        txtTimeSongNP = (TextView) findViewById(R.id.textViewTimeSongNP);
        txtTimeTotalNP= (TextView) findViewById(R.id.textviewTimeTotalNP);
        txtTitleNP    = (TextView) findViewById(R.id.textviewTittleNP);
        skSongNP    = (SeekBar) findViewById(R.id.seekBarSongNP);
        btnPreNP     = (ImageButton) findViewById(R.id.imageButtonPrevNP);
        btnPlayNP     = (ImageButton) findViewById(R.id.imageButtonPlayNP);
        btnNextNP    = (ImageButton) findViewById(R.id.imageButtonNextNP);
        HinhNP        = (ImageView) findViewById(R.id.imageViewDisc);
        ibBackNP= findViewById( R.id.ibBackNP );
    }
}