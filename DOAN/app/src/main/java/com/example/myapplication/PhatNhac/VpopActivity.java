package com.example.myapplication.PhatNhac;

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

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.Song.VpopSong;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class VpopActivity extends AppCompatActivity {
    TextView txtTitleVpop, txtTimeSongVpop, txtTimeTotalVpop;
    SeekBar skSongVpop;
    ImageView HinhVpop;
    ImageButton btnPreVpop, btnPlayVpop, btnStopVpop, btnNextVpop, btnMenu, ibBackVpop;
    ArrayList<VpopSong> vpopSong;

    Animation animation;
    int position =0;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_vpop );
        Anhxa();
        AddVpopSong();
        animation = AnimationUtils.loadAnimation(this, R.anim.disc_animation);
        KhoitaoMediaPlayer();
        ibBackVpop.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(VpopActivity.this, MainActivity.class);
                startActivity( i );
            }
        } );

        btnNextVpop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position++;
                if(position > vpopSong.size()-1){
                    position =0;
                }
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                KhoitaoMediaPlayer();
                mediaPlayer.start();
                btnPlayVpop.setImageResource(R.drawable.pause);
                SetTimetotal();
                UpdateTimeSong();
                HinhVpop.startAnimation(animation);

            }
        });

        btnPreVpop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position--;
                if(position < 0){
                    position =vpopSong.size()-1;
                }
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                KhoitaoMediaPlayer();
                mediaPlayer.start();
                btnPlayVpop.setImageResource(R.drawable.pause);
                SetTimetotal();
                UpdateTimeSong();
                HinhVpop.startAnimation(animation);

            }
        });

        btnPlayVpop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    //pause --> đổi hình
                    mediaPlayer.pause();
                    btnPlayVpop.setImageResource(R.drawable.play);
                } else {
                    mediaPlayer.start();
                    btnPlayVpop.setImageResource(R.drawable.pause);
                    HinhVpop.startAnimation(animation);
                }
                SetTimetotal();
                UpdateTimeSong();

            }
        });

        skSongVpop.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(skSongVpop.getProgress());
            }
        });
    }
    private void UpdateTimeSong(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat dinhdangGio = new SimpleDateFormat("mm:ss");
                txtTimeSongVpop.setText(dinhdangGio.format(mediaPlayer.getCurrentPosition()));
                //update seek bar cho chạy theo thời gian bài hát
                skSongVpop.setProgress(mediaPlayer.getCurrentPosition());
                // bắt thời gian kết thúc của bài để chuyển nhạc
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        position++;
                        if(position > vpopSong.size()-1) {
                            position =0;
                        }
                        if(mediaPlayer.isPlaying()){
                            mediaPlayer.stop();
                        }
                        KhoitaoMediaPlayer();
                        mediaPlayer.start();
                        btnPlayVpop.setImageResource(R.drawable.pause);
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
        txtTimeTotalVpop.setText(dinhdangtime.format(mediaPlayer.getDuration()));
        //gán trị số max của bài hát = time bài hát
        skSongVpop.setMax(mediaPlayer.getDuration());
    }
    private void KhoitaoMediaPlayer(){
        mediaPlayer = MediaPlayer.create(VpopActivity.this, vpopSong.get(position).getVpopFile() );
        txtTitleVpop.setText(vpopSong.get(position).getVpopTitle());
    }
    private void AddVpopSong() {
        vpopSong = new ArrayList<>();
        vpopSong.add(new VpopSong("Chúng Ta Của Hiện Tại", R.raw.chung_ta_cua_hien_tai));
        vpopSong.add(new VpopSong("Có Ai Thương Em Như Anh", R.raw.co_ai_thuong_em_nhu_anh));
        vpopSong.add(new VpopSong("Thích Anh Rồi Đấy", R.raw.thich_anh_roi_day));
        vpopSong.add(new VpopSong("Dành Hết Xuân Thì Để Chờ Nhau", R.raw.danh_het_thanh_xuan_thi_de_cho_nhau));
        vpopSong.add(new VpopSong("Bận Lòng", R.raw.ban_long));
        vpopSong.add(new VpopSong("Hai Mươi Hai", R.raw.hai_muoi_hai));
    }


    private void Anhxa() {
        txtTimeSongVpop = (TextView) findViewById(R.id.textViewTimeSongVpop);
        txtTimeTotalVpop= (TextView) findViewById(R.id.textviewTimeTotalVpop);
        txtTitleVpop    = (TextView) findViewById(R.id.textviewTittleVpop);
        skSongVpop    = (SeekBar) findViewById(R.id.seekBarSongVpop);
        btnPreVpop     = (ImageButton) findViewById(R.id.imageButtonPrevVpop);
        btnPlayVpop     = (ImageButton) findViewById(R.id.imageButtonPlayVpop);
        btnNextVpop    = (ImageButton) findViewById(R.id.imageButtonNextVpop);
        HinhVpop        = (ImageView) findViewById(R.id.imageViewDisc);
        ibBackVpop= findViewById( R.id.ibBackVpop );
    }
}