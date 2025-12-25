package com.hisona.allive;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.exoplayer2.DeviceInfo;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.ui.StyledPlayerView;
import com.google.android.exoplayer2.upstream.DefaultDataSource;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hisona.allive.Utils;
import com.orhanobut.hawk.Hawk;
import defpackage.b62;
import defpackage.c62;
import defpackage.d62;
import defpackage.e9;
import defpackage.q91;
import defpackage.qj;
import defpackage.u50;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.UUID;

/* loaded from: classes2.dex */
public class PlayerActivity extends FragmentActivity implements Player.Listener, ResultListener {
    public static boolean d0 = false;
    public static ArrayList e0 = null;
    public static ArrayList f0 = null;
    public static String g0 = null;
    public static String h0 = "";
    public PlayerActivity C;
    public StyledPlayerView D;
    public StyledPlayerView E;
    public ExoPlayer F;
    public ExoPlayer G;
    public TvingHttpMediaDrmCallback H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public Date N;
    public SlidingPanel O;
    public VolumePanel P;
    public ProgressBar Q;
    public float R;
    public boolean S;
    public Timer X;
    public int Y;
    public int Z;
    public Boolean a0;
    public FirebaseAnalytics b0;
    public boolean T = false;
    public boolean U = false;
    public boolean V = false;
    public boolean W = false;
    public final e9 c0 = new e9(3, this);

    static {
        System.loadLibrary("allive");
    }

    public static native String[] tvingDecrypt(String str, String str2);

    public final void d() {
        String str;
        String programName;
        String str2;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(calendar.getTimeInMillis() + (32400000 - calendar.getTimeZone().getRawOffset()));
        Date time = calendar.getTime();
        if (this.K < 0) {
            this.N = time;
            return;
        }
        long time2 = (time.getTime() - this.N.getTime()) / 60000;
        if (time2 < 5) {
            this.N = time;
            return;
        }
        ChannelData channelData = (ChannelData) e0.get(this.K);
        ArrayList<EPGData> epg = channelData.getEPG();
        int i = this.I;
        Utils.SiteType siteType = Utils.SiteType.Tving;
        String str3 = "WAVVE";
        if (i == siteType.ordinal()) {
            str = "TVING";
        } else if (this.I == Utils.SiteType.Wavve.ordinal()) {
            str = "WAVVE";
        } else if (this.I != Utils.SiteType.Favorite.ordinal()) {
            str = "";
        } else {
            str = "FAVORITE";
        }
        if (channelData.getSiteType() == siteType.ordinal()) {
            str3 = "TVING";
        } else if (channelData.getSiteType() != Utils.SiteType.Wavve.ordinal()) {
            str3 = "";
        }
        String title = channelData.getTitle();
        this.M = -1;
        int i2 = 0;
        while (true) {
            if (i2 >= epg.size()) {
                break;
            }
            if (this.N.compareTo(epg.get(i2).getEndTime()) < 0) {
                this.M = i2;
                break;
            }
            i2++;
        }
        int i3 = this.M;
        if (i3 >= 0) {
            programName = epg.get(i3).getProgramName();
        } else {
            programName = channelData.getProgramName();
        }
        Bundle bundle = new Bundle();
        calendar.setTime(this.N);
        int i4 = calendar.get(11);
        bundle.putString("menu", str);
        bundle.putString("site", str3);
        bundle.putString("channel", title);
        bundle.putString("program", programName);
        bundle.putString("resolution", channelData.getResolution());
        if (channelData.getFavorite() > 0) {
            str2 = "true";
        } else {
            str2 = "false";
        }
        bundle.putString("favorite", str2);
        bundle.putString("start_hour", Integer.toString(i4));
        bundle.putString("play_time", Long.toString(time2));
        this.N = time;
        this.b0.logEvent("play_channel", bundle);
    }

    public final void e() {
        ArrayList<EPGData> epg = ((ChannelData) e0.get(this.L)).getEPG();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(calendar.getTimeInMillis() + (32400000 - calendar.getTimeZone().getRawOffset()));
        Date time = calendar.getTime();
        this.M = -1;
        int i = 0;
        while (true) {
            if (i >= epg.size()) {
                break;
            }
            if (time.compareTo(epg.get(i).getEndTime()) < 0) {
                this.M = i;
                break;
            }
            i++;
        }
        h(PathInterpolatorCompat.MAX_NUM_POINTS);
    }

    public final void f() {
        Intent intent = new Intent();
        intent.putExtra(i(R.string.CURRENTCHANNEL_STR), this.J);
        if (this.U) {
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finishAfterTransition();
    }

    public final void g() {
        ExoPlayer exoPlayer = this.F;
        if (exoPlayer != null) {
            exoPlayer.stop();
            this.F.release();
            this.F = null;
        }
        ExoPlayer build = new ExoPlayer.Builder(this.C).build();
        this.F = build;
        build.setPlayWhenReady(true);
        this.F.addListener(this);
        this.F.setVolume(this.R);
        this.D.setPlayer(this.F);
        this.D.setUseController(false);
        this.O.setInfoText("");
    }

    public final void h(int i) {
        ChannelData channelData = (ChannelData) e0.get(this.L);
        ArrayList<EPGData> epg = channelData.getEPG();
        this.O.setSiteIcon(channelData.getSiteType());
        String title = channelData.getTitle();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(calendar.getTimeInMillis() + (32400000 - calendar.getTimeZone().getRawOffset()));
        Date time = calendar.getTime();
        Locale locale = Locale.US;
        this.O.setTimeText(new SimpleDateFormat("HH:mm", locale).format(time));
        int i2 = this.M;
        int i3 = 0;
        if (i2 >= 0) {
            String programName = epg.get(i2).getProgramName();
            Date startTime = epg.get(this.M).getStartTime();
            Date endTime = epg.get(this.M).getEndTime();
            String format = new SimpleDateFormat("HH:mm", locale).format(startTime);
            String format2 = new SimpleDateFormat("HH:mm", locale).format(endTime);
            this.O.setInfoText(format + " ~ " + format2 + "\n" + title + " - " + programName + "\n");
            int time2 = (int) (((time.getTime() - startTime.getTime()) * 100) / (endTime.getTime() - startTime.getTime()));
            if (time2 >= 0 && time2 <= 100) {
                i3 = time2;
            }
            this.O.setTimeProgress(i3);
        } else {
            String programName2 = channelData.getProgramName();
            if (programName2 != null && programName2.length() != 0) {
                this.O.setInfoText(title + " - " + programName2);
            } else {
                this.O.setInfoText(title);
            }
            this.O.setTimeProgress(0);
        }
        if (channelData.getFavorite() > 0) {
            this.O.showFavorite();
        } else {
            this.O.hideFavorite();
        }
        this.O.setResText(channelData.getResolution());
        if (i > 0) {
            this.O.closeDelayed(i);
        }
    }

    public final String i(int i) {
        return getResources().getString(i);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.hisona.allive.u, com.hisona.allive.BackgroundTask] */
    public final void j() {
        d();
        PlayerActivity playerActivity = this.C;
        int i = this.J;
        ?? backgroundTask = new BackgroundTask(playerActivity, playerActivity);
        backgroundTask.a = "";
        backgroundTask.b = "";
        backgroundTask.c = "";
        backgroundTask.d = "";
        backgroundTask.e = "";
        backgroundTask.f = null;
        backgroundTask.g = i;
        backgroundTask.execute();
    }

    public final void k() {
        ExoPlayer exoPlayer = this.F;
        if (exoPlayer != null) {
            exoPlayer.stop();
            this.F.release();
            this.F = null;
        }
        ExoPlayer exoPlayer2 = this.G;
        if (exoPlayer2 != null) {
            exoPlayer2.stop();
            this.G.release();
            this.G = null;
        }
    }

    public final void l(int i) {
        int i2 = this.J;
        this.L = i2;
        ChannelData channelData = (ChannelData) e0.get(i2);
        ArrayList<EPGData> epg = channelData.getEPG();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(calendar.getTimeInMillis() + (32400000 - calendar.getTimeZone().getRawOffset()));
        Date time = calendar.getTime();
        this.M = -1;
        int i3 = 0;
        while (true) {
            if (i3 >= epg.size()) {
                break;
            }
            if (time.compareTo(epg.get(i3).getEndTime()) < 0) {
                this.M = i3;
                break;
            }
            i3++;
        }
        h(0);
        if (!this.O.isPanelShow().booleanValue()) {
            this.O.showSlidingPanel(channelData.getSiteType(), i);
        }
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onAudioAttributesChanged(AudioAttributes audioAttributes) {
        b62.a(this, audioAttributes);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onAudioSessionIdChanged(int i) {
        b62.b(this, i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onAvailableCommandsChanged(Player.Commands commands) {
        b62.c(this, commands);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_videoplayer);
        Utils.doFullScreen(this);
        this.C = this;
        this.D = (StyledPlayerView) findViewById(R.id.video_view1);
        this.E = (StyledPlayerView) findViewById(R.id.video_view2);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        this.Q = progressBar;
        progressBar.setVisibility(0);
        this.O = new SlidingPanel(this);
        this.P = new VolumePanel(this);
        this.T = false;
        this.U = false;
        q91 q91Var = new q91(1, this);
        this.D.setOnTouchListener(q91Var);
        this.E.setOnTouchListener(q91Var);
        this.X = new Timer();
        this.a0 = Boolean.FALSE;
        this.O.setInfoText("");
        this.J = getIntent().getIntExtra(i(R.string.CURRENTCHANNEL_STR), 0);
        f0 = getIntent().getStringArrayListExtra(i(R.string.AUTHKEY_STR));
        this.I = getIntent().getIntExtra(i(R.string.SITETYPE_STR), 0);
        this.S = getIntent().getBooleanExtra(i(R.string.VOLUMECONTROL_STR), false);
        if (this.I == Utils.SiteType.Tving.ordinal()) {
            e0 = TvingRowSupportFragment.getChannelList();
        } else if (this.I == Utils.SiteType.Wavve.ordinal()) {
            e0 = WavveRowSupportFragment.getChannelList();
        } else if (this.I == Utils.SiteType.Favorite.ordinal()) {
            e0 = FavoriteRowSupportFragment.getChannelList();
        }
        if (this.S) {
            try {
                this.R = Float.parseFloat((String) Hawk.get(i(R.string.VOLUMECONTROL_STR)));
            } catch (Exception unused) {
                this.R = 1.0f;
            }
        } else {
            this.R = 1.0f;
        }
        this.K = -1;
        String string = Settings.Secure.getString(getContentResolver(), "android_id");
        if (string == null || string.equals("")) {
            string = "allive-android-4.5";
        }
        g0 = UUID.nameUUIDFromBytes(string.getBytes()).toString();
        h0 = "";
        this.b0 = FirebaseAnalytics.getInstance(this);
        j();
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onCues(CueGroup cueGroup) {
        b62.d(this, cueGroup);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.X.cancel();
        this.X.purge();
        this.O.hideSlidingPanel(true);
        this.K = this.J;
        d();
        k();
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onDeviceInfoChanged(DeviceInfo deviceInfo) {
        b62.f(this, deviceInfo);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onDeviceVolumeChanged(int i, boolean z) {
        b62.g(this, i, z);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onEvents(Player player, Player.Events events) {
        b62.h(this, player, events);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onIsLoadingChanged(boolean z) {
        b62.i(this, z);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onIsPlayingChanged(boolean z) {
        int i;
        ExoPlayer exoPlayer;
        ExoPlayer exoPlayer2;
        if (z) {
            this.V = false;
            if (this.W) {
                this.W = false;
                return;
            } else {
                l(1000);
                return;
            }
        }
        if (this.D.getVisibility() == 0 && (exoPlayer2 = this.F) != null) {
            i = exoPlayer2.getPlaybackState();
        } else if (this.E.getVisibility() == 0 && (exoPlayer = this.G) != null) {
            i = exoPlayer.getPlaybackState();
        } else {
            i = 0;
        }
        if (i == 4) {
            this.W = false;
            j();
        } else if (i == 1) {
            this.W = true;
            j();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        int i2;
        int i3 = 0;
        if (i == 23 || i == 66 || i == 109 || i == 160 || i == 29 || i == 126 || i == 165) {
            if (keyEvent.isLongPress()) {
                this.T = true;
                if (!this.O.isPanelShow().booleanValue()) {
                    l(PathInterpolatorCompat.MAX_NUM_POINTS);
                }
                int i4 = this.J;
                if (i4 != this.L) {
                    return false;
                }
                this.U = true;
                ChannelData channelData = (ChannelData) e0.get(i4);
                if (channelData.getFavorite() > 0) {
                    channelData.setFavorite(0);
                    this.O.hideFavorite();
                    Toast.makeText(this.C, i(R.string.favorite_disable), 0).show();
                } else {
                    channelData.setFavorite(1);
                    this.O.showFavorite();
                    Toast.makeText(this.C, i(R.string.favorite_enable), 0).show();
                }
            } else {
                this.O.closeDelayed(PathInterpolatorCompat.MAX_NUM_POINTS);
            }
        } else if (i == 4 || i == 30 || i == 86 || i == 85) {
            if (this.O.isPanelShow().booleanValue()) {
                this.O.hideSlidingPanel(true);
                return false;
            }
            f();
        } else if (i == 19 || i == 166 || i == 87) {
            if (keyEvent.isLongPress()) {
                this.T = true;
                if (this.O.isPanelShow().booleanValue()) {
                    ChannelData channelData2 = (ChannelData) e0.get(this.L);
                    EPGData ePGData = channelData2.getEPG().get(this.M);
                    String title = channelData2.getTitle();
                    Date startTime = ePGData.getStartTime();
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(calendar.getTimeInMillis() + (32400000 - calendar.getTimeZone().getRawOffset()));
                    if (startTime.compareTo(calendar.getTime()) > 0) {
                        String str = title + " 채널이 " + new SimpleDateFormat("HH:mm", Locale.US).format(startTime) + " 에";
                        int length = (str.length() - 10) / 2;
                        String str2 = " 예약 되었습니다.";
                        while (i3 < length) {
                            str2 = qj.C(" ", str2);
                            i3++;
                        }
                        Toast.makeText(this.C, str + "\n" + str2, 1).show();
                        if (this.a0.booleanValue()) {
                            this.X.cancel();
                        }
                        this.Y = this.L;
                        this.Z = this.M;
                        c62 c62Var = new c62(this);
                        Timer timer = new Timer();
                        this.X = timer;
                        timer.schedule(c62Var, startTime);
                        this.a0 = Boolean.TRUE;
                    }
                }
            }
        } else if (i == 20 || i == 167 || i == 88) {
            if (keyEvent.isLongPress()) {
                this.T = true;
                if (this.O.isPanelShow().booleanValue() && this.a0.booleanValue()) {
                    this.a0 = Boolean.FALSE;
                    this.X.cancel();
                    ChannelData channelData3 = (ChannelData) e0.get(this.Y);
                    EPGData ePGData2 = channelData3.getEPG().get(this.Z);
                    String str3 = " 채널( " + channelData3.getTitle() + ":" + new SimpleDateFormat("HH:mm", Locale.US).format(ePGData2.getStartTime()) + ") 예약이";
                    int length2 = (str3.length() - 9) / 2;
                    String str4 = " 취소되었습니다.";
                    while (i3 < length2) {
                        str4 = qj.C(" ", str4);
                        i3++;
                    }
                    Toast.makeText(this.C, str3 + "\n" + str4, 1).show();
                }
            }
        } else if (i == 21) {
            if (this.O.isPanelShow().booleanValue()) {
                int i5 = this.M;
                if (i5 >= 0 && i5 > 0) {
                    this.M = i5 - 1;
                }
                h(PathInterpolatorCompat.MAX_NUM_POINTS);
            } else if (this.S) {
                if (this.D.getVisibility() == 0) {
                    float volume = this.F.getVolume();
                    this.R = volume;
                    if (volume > RecyclerView.F0) {
                        this.R = volume - 0.05f;
                    }
                    this.F.setVolume(this.R);
                } else if (this.E.getVisibility() == 0) {
                    float volume2 = this.G.getVolume();
                    this.R = volume2;
                    if (volume2 > RecyclerView.F0) {
                        this.R = volume2 - 0.05f;
                    }
                    this.G.setVolume(this.R);
                }
                this.P.setVolume((int) (this.R * 100.0f));
                this.P.showVolumePanel(2000);
                Hawk.put(i(R.string.VOLUMECONTROL_STR), Float.toString(this.R));
            } else {
                int i6 = this.K;
                if (i6 != -1) {
                    this.K = this.J;
                    this.J = i6;
                    j();
                }
            }
        } else if (i == 22) {
            if (this.O.isPanelShow().booleanValue()) {
                if (this.M >= 0) {
                    int size = ((ChannelData) e0.get(this.L)).getEPG().size() - 1;
                    int i7 = this.M;
                    if (i7 < size) {
                        this.M = i7 + 1;
                    }
                }
                h(PathInterpolatorCompat.MAX_NUM_POINTS);
            } else if (this.S) {
                if (this.D.getVisibility() == 0) {
                    float volume3 = this.F.getVolume();
                    this.R = volume3;
                    if (volume3 < 1.0f) {
                        this.R = volume3 + 0.05f;
                    }
                    this.F.setVolume(this.R);
                } else if (this.E.getVisibility() == 0) {
                    float volume4 = this.G.getVolume();
                    this.R = volume4;
                    if (volume4 < 1.0f) {
                        this.R = volume4 + 0.05f;
                    }
                    this.G.setVolume(this.R);
                }
                this.P.setVolume((int) (this.R * 100.0f));
                this.P.showVolumePanel(2000);
                Hawk.put(i(R.string.VOLUMECONTROL_STR), Float.toString(this.R));
            }
        } else if ((i == 272 || i == 90 || i == 89) && (i2 = this.K) != -1) {
            this.K = this.J;
            this.J = i2;
            j();
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 23 && i != 66 && i != 109 && i != 160 && i != 29 && i != 126 && i != 165) {
            if (i != 19 && i != 166 && i != 87) {
                if (i == 20 || i == 167 || i == 88) {
                    if (this.T) {
                        this.T = false;
                    } else if (this.V && this.O.isPanelShow().booleanValue()) {
                        int i2 = this.L;
                        if (i2 > 0) {
                            this.L = i2 - 1;
                        } else {
                            this.L = e0.size() - 1;
                        }
                        e();
                    } else {
                        int i3 = this.J;
                        this.K = i3;
                        if (i3 > 0) {
                            this.J = i3 - 1;
                        } else {
                            this.J = e0.size() - 1;
                        }
                        this.O.hideSlidingPanel(true);
                        this.Q.setVisibility(0);
                        j();
                    }
                }
            } else if (this.T) {
                this.T = false;
            } else if (this.V && this.O.isPanelShow().booleanValue()) {
                if (this.L < e0.size() - 1) {
                    this.L++;
                } else {
                    this.L = 0;
                }
                e();
            } else {
                int i4 = this.J;
                this.K = i4;
                if (i4 < e0.size() - 1) {
                    this.J++;
                } else {
                    this.J = 0;
                }
                this.O.hideSlidingPanel(true);
                this.Q.setVisibility(0);
                j();
            }
        } else if (this.O.isPanelShow().booleanValue()) {
            if (this.T) {
                this.T = false;
            } else {
                this.O.hideSlidingPanel(true);
                int i5 = this.J;
                int i6 = this.L;
                if (i5 != i6) {
                    this.K = i5;
                    this.J = i6;
                    this.Q.setVisibility(0);
                    j();
                }
            }
        } else {
            this.V = true;
            l(PathInterpolatorCompat.MAX_NUM_POINTS);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onLoadingChanged(boolean z) {
        b62.k(this, z);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onMaxSeekToPreviousPositionChanged(long j) {
        b62.l(this, j);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onMediaItemTransition(MediaItem mediaItem, int i) {
        b62.m(this, mediaItem, i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
        b62.n(this, mediaMetadata);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onMetadata(Metadata metadata) {
        b62.o(this, metadata);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.I == Utils.SiteType.Tving.ordinal()) {
            e0 = TvingRowSupportFragment.getChannelList();
        } else if (this.I == Utils.SiteType.Wavve.ordinal()) {
            e0 = WavveRowSupportFragment.getChannelList();
        } else if (this.I == Utils.SiteType.Favorite.ordinal()) {
            e0 = FavoriteRowSupportFragment.getChannelList();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (Util.SDK_INT <= 23) {
            k();
        }
        unregisterReceiver(this.c0);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onPlayWhenReadyChanged(boolean z, int i) {
        b62.p(this, z, i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        b62.q(this, playbackParameters);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onPlaybackStateChanged(int i) {
        b62.r(this, i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
        b62.s(this, i);
    }

    public void onPlayerButtonClick(View view) {
        int id = view.getId();
        if (id == R.id.backButton) {
            f();
            return;
        }
        if (id == R.id.upButton) {
            if (this.O.isPanelShow().booleanValue()) {
                if (this.L < e0.size() - 1) {
                    this.L++;
                } else {
                    this.L = 0;
                }
                e();
                return;
            }
            return;
        }
        if (id == R.id.downButton) {
            if (this.O.isPanelShow().booleanValue()) {
                int i = this.L;
                if (i > 0) {
                    this.L = i - 1;
                } else {
                    this.L = e0.size() - 1;
                }
                e();
                return;
            }
            return;
        }
        if (id == R.id.selectButton) {
            if (this.O.isPanelShow().booleanValue()) {
                this.O.hideSlidingPanel(false);
                int i2 = this.J;
                int i3 = this.L;
                if (i2 != i3) {
                    this.K = i2;
                    this.J = i3;
                    this.Q.setVisibility(0);
                    j();
                    return;
                }
                return;
            }
            return;
        }
        if (id == R.id.leftButton) {
            if (this.O.isPanelShow().booleanValue()) {
                int i4 = this.M;
                if (i4 >= 0 && i4 > 0) {
                    this.M = i4 - 1;
                }
                h(PathInterpolatorCompat.MAX_NUM_POINTS);
                return;
            }
            return;
        }
        if (id == R.id.rightButton) {
            if (this.O.isPanelShow().booleanValue()) {
                if (this.M >= 0) {
                    int size = ((ChannelData) e0.get(this.L)).getEPG().size() - 1;
                    int i5 = this.M;
                    if (i5 < size) {
                        this.M = i5 + 1;
                    }
                }
                h(PathInterpolatorCompat.MAX_NUM_POINTS);
                return;
            }
            return;
        }
        if (id == R.id.favoriteButton) {
            if (!this.O.isPanelShow().booleanValue()) {
                l(PathInterpolatorCompat.MAX_NUM_POINTS);
            }
            int i6 = this.J;
            if (i6 != this.L) {
                return;
            }
            ChannelData channelData = (ChannelData) e0.get(i6);
            this.U = true;
            if (channelData.getFavorite() > 0) {
                channelData.setFavorite(0);
                this.O.hideFavorite();
                Toast.makeText(this.C, i(R.string.favorite_disable), 0).show();
                return;
            } else {
                channelData.setFavorite(1);
                this.O.showFavorite();
                Toast.makeText(this.C, i(R.string.favorite_enable), 0).show();
                return;
            }
        }
        if (id == R.id.chdownButton) {
            int i7 = this.J;
            this.K = i7;
            if (i7 > 0) {
                this.J = i7 - 1;
            } else {
                this.J = e0.size() - 1;
            }
            this.O.hideSlidingPanel(false);
            this.Q.setVisibility(0);
            j();
            return;
        }
        if (id == R.id.chupButton) {
            int i8 = this.J;
            this.K = i8;
            if (i8 < e0.size() - 1) {
                this.J++;
            } else {
                this.J = 0;
            }
            this.O.hideSlidingPanel(false);
            this.Q.setVisibility(0);
            j();
        }
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onPlayerError(PlaybackException playbackException) {
        int i = playbackException.errorCode;
        if (i != 2001 && i != 2002 && i != 1003) {
            b62.t(this, playbackException);
            return;
        }
        Log.e("PlayerActivity", "onPlayerError: " + playbackException.errorCode + ", " + playbackException.getErrorCodeName());
        Toast.makeText(this.C, i(R.string.play_error_retry), 0).show();
        j();
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onPlayerErrorChanged(PlaybackException playbackException) {
        b62.u(this, playbackException);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onPlayerStateChanged(boolean z, int i) {
        b62.v(this, z, i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
        b62.w(this, mediaMetadata);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onPositionDiscontinuity(int i) {
        b62.x(this, i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onRenderedFirstFrame() {
        b62.z(this);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onRepeatModeChanged(int i) {
        b62.A(this, i);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.media.action.HDMI_AUDIO_PLUG");
        registerReceiver(this.c0, intentFilter);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            bundle.clear();
        }
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onSeekBackIncrementChanged(long j) {
        b62.B(this, j);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onSeekForwardIncrementChanged(long j) {
        b62.C(this, j);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onSeekProcessed() {
        b62.D(this);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onShuffleModeEnabledChanged(boolean z) {
        b62.E(this, z);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onSkipSilenceEnabledChanged(boolean z) {
        b62.F(this, z);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        d0 = true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (Util.SDK_INT > 23) {
            k();
        }
        d0 = false;
        finish();
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onSurfaceSizeChanged(int i, int i2) {
        b62.G(this, i, i2);
    }

    @Override // com.hisona.allive.ResultListener
    public void onTaskTerminate(int i, int i2, Bundle bundle) {
        Date date;
        this.Q.setVisibility(4);
        String string = bundle.getString(ImagesContract.URL);
        String string2 = bundle.getString("cookie");
        String string3 = bundle.getString("drmserver");
        String string4 = bundle.getString("drmassert");
        if (bundle.getLong("starttime") > 0) {
            date = new Date(bundle.getLong("starttime"));
        } else {
            date = null;
        }
        int i3 = t.a[Utils.Code.values()[i2].ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        if (string.contains("/manifest.mpd")) {
                            ChannelData channelData = (ChannelData) e0.get(this.J);
                            if (channelData.isAudioChannel().booleanValue()) {
                                GlideApp.with((FragmentActivity) this).asDrawable().mo45load(channelData.getStillImageUrl()).fitCenter().diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true).into((GlideRequest<Drawable>) new d62(this, 2));
                            }
                            this.D.setVisibility(8);
                            this.E.setVisibility(0);
                            ExoPlayer exoPlayer = this.F;
                            if (exoPlayer != null) {
                                exoPlayer.stop();
                            }
                            ExoPlayer exoPlayer2 = this.G;
                            if (exoPlayer2 == null) {
                                if (exoPlayer2 != null) {
                                    exoPlayer2.stop();
                                    this.G.release();
                                    this.G = null;
                                }
                                this.G = new ExoPlayer.Builder(this.C).build();
                                TvingHttpMediaDrmCallback tvingHttpMediaDrmCallback = new TvingHttpMediaDrmCallback(string3, new DefaultHttpDataSource.Factory().setUserAgent(i(R.string.USERAGENT)));
                                this.H = tvingHttpMediaDrmCallback;
                                tvingHttpMediaDrmCallback.setDefaultLicenseUrl(string3);
                                this.H.setKeyRequestProperty("AcquireLicenseAssertion", string4);
                                this.G.setPlayWhenReady(true);
                                this.G.addListener(this);
                                this.G.setVolume(this.R);
                                this.E.setPlayer(this.G);
                                this.E.setUseController(false);
                                this.O.setInfoText("");
                            } else {
                                this.H.setDefaultLicenseUrl(string3);
                                this.H.setKeyRequestProperty("AcquireLicenseAssertion", string4);
                            }
                            this.G.setMediaSource(new DashMediaSource.Factory(new DefaultDataSource.Factory(this)).setDrmSessionManagerProvider((DrmSessionManagerProvider) new u50(1, this)).createMediaSource(MediaItem.fromUri(Uri.parse(string))));
                            this.G.prepare();
                            this.G.setVolume(this.R);
                            return;
                        }
                        if (string2 != null && !string2.equals("")) {
                            ChannelData channelData2 = (ChannelData) e0.get(this.J);
                            if (channelData2.isAudioChannel().booleanValue()) {
                                GlideApp.with((FragmentActivity) this).asDrawable().mo45load(channelData2.getStillImageUrl()).fitCenter().diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true).into((GlideRequest<Drawable>) new d62(this, 1));
                            }
                            this.D.setVisibility(0);
                            this.E.setVisibility(8);
                            ExoPlayer exoPlayer3 = this.G;
                            if (exoPlayer3 != null) {
                                exoPlayer3.stop();
                            }
                            if (this.F == null) {
                                g();
                            }
                            DefaultHttpDataSource.Factory userAgent = new DefaultHttpDataSource.Factory().setUserAgent(i(R.string.USERAGENT));
                            if (!string2.equals("")) {
                                HashMap hashMap = new HashMap();
                                hashMap.put(HttpHeaders.COOKIE, string2);
                                userAgent.setDefaultRequestProperties((Map<String, String>) hashMap);
                            }
                            this.F.setMediaSource(new HlsMediaSource.Factory(userAgent).setAllowChunklessPreparation(true).createMediaSource(MediaItem.fromUri(Uri.parse(string))));
                            this.F.prepare();
                            this.F.setVolume(this.R);
                            return;
                        }
                        ChannelData channelData3 = (ChannelData) e0.get(this.J);
                        if (channelData3.isAudioChannel().booleanValue()) {
                            GlideApp.with((FragmentActivity) this).asDrawable().mo45load(channelData3.getStillImageUrl()).fitCenter().diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true).into((GlideRequest<Drawable>) new d62(this, 0));
                        }
                        this.D.setVisibility(0);
                        this.E.setVisibility(8);
                        ExoPlayer exoPlayer4 = this.G;
                        if (exoPlayer4 != null) {
                            exoPlayer4.stop();
                        }
                        if (this.F == null) {
                            g();
                        }
                        this.F.setMediaSource(new HlsMediaSource.Factory(new DefaultDataSource.Factory(this)).setAllowChunklessPreparation(true).createMediaSource(MediaItem.fromUri(Uri.parse(string))));
                        this.F.prepare();
                        this.F.setVolume(this.R);
                        if (date != null) {
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTimeInMillis(calendar.getTimeInMillis() + (32400000 - calendar.getTimeZone().getRawOffset()));
                            long time = (calendar.getTime().getTime() - date.getTime()) - 60000;
                            if (time > 0) {
                                this.F.seekTo(time);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                Utils.showToast(this.C, R.string.noright_error);
                ExoPlayer exoPlayer5 = this.F;
                if (exoPlayer5 != null) {
                    exoPlayer5.stop();
                }
                ExoPlayer exoPlayer6 = this.G;
                if (exoPlayer6 != null) {
                    exoPlayer6.stop();
                    return;
                }
                return;
            }
            Utils.showToast(this.C, R.string.geturl_error);
            ExoPlayer exoPlayer7 = this.F;
            if (exoPlayer7 != null) {
                exoPlayer7.stop();
            }
            ExoPlayer exoPlayer8 = this.G;
            if (exoPlayer8 != null) {
                exoPlayer8.stop();
                return;
            }
            return;
        }
        Utils.showToast(this.C, R.string.login_error_video);
        setResult(0);
        finishAfterTransition();
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onTimelineChanged(Timeline timeline, int i) {
        b62.H(this, timeline, i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
        b62.I(this, trackSelectionParameters);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onTracksChanged(Tracks tracks) {
        b62.J(this, tracks);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onVideoSizeChanged(VideoSize videoSize) {
        b62.K(this, videoSize);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onVolumeChanged(float f) {
        b62.L(this, f);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onCues(List list) {
        b62.e(this, list);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i) {
        b62.y(this, positionInfo, positionInfo2, i);
    }
}
