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
import com.google.android.exoplayer2.p003ui.StyledPlayerView;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.upstream.DefaultDataSource;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hisona.allive.Utils;
import com.orhanobut.hawk.Hawk;
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
import p000.AbstractC1726qj;
import p000.C1150e9;
import p000.b62;
import p000.c62;
import p000.d62;
import p000.q91;
import p000.u50;

/* loaded from: classes2.dex */
public class PlayerActivity extends FragmentActivity implements Player.Listener, ResultListener {

    /* renamed from: d0 */
    public static boolean f15869d0 = false;

    /* renamed from: e0 */
    public static ArrayList f15870e0 = null;

    /* renamed from: f0 */
    public static ArrayList f15871f0 = null;

    /* renamed from: g0 */
    public static String f15872g0 = null;

    /* renamed from: h0 */
    public static String f15873h0 = "";

    /* renamed from: C */
    public PlayerActivity f15874C;

    /* renamed from: D */
    public StyledPlayerView f15875D;

    /* renamed from: E */
    public StyledPlayerView f15876E;

    /* renamed from: F */
    public ExoPlayer f15877F;

    /* renamed from: G */
    public ExoPlayer f15878G;

    /* renamed from: H */
    public TvingHttpMediaDrmCallback f15879H;

    /* renamed from: I */
    public int f15880I;

    /* renamed from: J */
    public int f15881J;

    /* renamed from: K */
    public int f15882K;

    /* renamed from: L */
    public int f15883L;

    /* renamed from: M */
    public int f15884M;

    /* renamed from: N */
    public Date f15885N;

    /* renamed from: O */
    public SlidingPanel f15886O;

    /* renamed from: P */
    public VolumePanel f15887P;

    /* renamed from: Q */
    public ProgressBar f15888Q;

    /* renamed from: R */
    public float f15889R;

    /* renamed from: S */
    public boolean f15890S;

    /* renamed from: X */
    public Timer f15895X;

    /* renamed from: Y */
    public int f15896Y;

    /* renamed from: Z */
    public int f15897Z;

    /* renamed from: a0 */
    public Boolean f15898a0;

    /* renamed from: b0 */
    public FirebaseAnalytics f15899b0;

    /* renamed from: T */
    public boolean f15891T = false;

    /* renamed from: U */
    public boolean f15892U = false;

    /* renamed from: V */
    public boolean f15893V = false;

    /* renamed from: W */
    public boolean f15894W = false;

    /* renamed from: c0 */
    public final C1150e9 f15900c0 = new C1150e9(3, this);

    static {
        System.loadLibrary("allive");
    }

    public static native String[] tvingDecrypt(String str, String str2);

    /* renamed from: d */
    public final void m4457d() {
        String str;
        String programName;
        String str2;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(calendar.getTimeInMillis() + (32400000 - calendar.getTimeZone().getRawOffset()));
        Date time = calendar.getTime();
        if (this.f15882K < 0) {
            this.f15885N = time;
            return;
        }
        long time2 = (time.getTime() - this.f15885N.getTime()) / 60000;
        if (time2 < 5) {
            this.f15885N = time;
            return;
        }
        ChannelData channelData = (ChannelData) f15870e0.get(this.f15882K);
        ArrayList<EPGData> epg = channelData.getEPG();
        int i = this.f15880I;
        Utils.SiteType siteType = Utils.SiteType.Tving;
        String str3 = "WAVVE";
        if (i == siteType.ordinal()) {
            str = "TVING";
        } else if (this.f15880I == Utils.SiteType.Wavve.ordinal()) {
            str = "WAVVE";
        } else if (this.f15880I != Utils.SiteType.Favorite.ordinal()) {
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
        this.f15884M = -1;
        int i2 = 0;
        while (true) {
            if (i2 >= epg.size()) {
                break;
            }
            if (this.f15885N.compareTo(epg.get(i2).getEndTime()) < 0) {
                this.f15884M = i2;
                break;
            }
            i2++;
        }
        int i3 = this.f15884M;
        if (i3 >= 0) {
            programName = epg.get(i3).getProgramName();
        } else {
            programName = channelData.getProgramName();
        }
        Bundle bundle = new Bundle();
        calendar.setTime(this.f15885N);
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
        this.f15885N = time;
        this.f15899b0.logEvent("play_channel", bundle);
    }

    /* renamed from: e */
    public final void m4458e() {
        ArrayList<EPGData> epg = ((ChannelData) f15870e0.get(this.f15883L)).getEPG();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(calendar.getTimeInMillis() + (32400000 - calendar.getTimeZone().getRawOffset()));
        Date time = calendar.getTime();
        this.f15884M = -1;
        int i = 0;
        while (true) {
            if (i >= epg.size()) {
                break;
            }
            if (time.compareTo(epg.get(i).getEndTime()) < 0) {
                this.f15884M = i;
                break;
            }
            i++;
        }
        m4461h(PathInterpolatorCompat.MAX_NUM_POINTS);
    }

    /* renamed from: f */
    public final void m4459f() {
        Intent intent = new Intent();
        intent.putExtra(m4462i(R.string.CURRENTCHANNEL_STR), this.f15881J);
        if (this.f15892U) {
            setResult(-1, intent);
        } else {
            setResult(0, intent);
        }
        finishAfterTransition();
    }

    /* renamed from: g */
    public final void m4460g() {
        ExoPlayer exoPlayer = this.f15877F;
        if (exoPlayer != null) {
            exoPlayer.stop();
            this.f15877F.release();
            this.f15877F = null;
        }
        ExoPlayer build = new ExoPlayer.Builder(this.f15874C).build();
        this.f15877F = build;
        build.setPlayWhenReady(true);
        this.f15877F.addListener(this);
        this.f15877F.setVolume(this.f15889R);
        this.f15875D.setPlayer(this.f15877F);
        this.f15875D.setUseController(false);
        this.f15886O.setInfoText("");
    }

    /* renamed from: h */
    public final void m4461h(int i) {
        ChannelData channelData = (ChannelData) f15870e0.get(this.f15883L);
        ArrayList<EPGData> epg = channelData.getEPG();
        this.f15886O.setSiteIcon(channelData.getSiteType());
        String title = channelData.getTitle();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(calendar.getTimeInMillis() + (32400000 - calendar.getTimeZone().getRawOffset()));
        Date time = calendar.getTime();
        Locale locale = Locale.US;
        this.f15886O.setTimeText(new SimpleDateFormat("HH:mm", locale).format(time));
        int i2 = this.f15884M;
        int i3 = 0;
        if (i2 >= 0) {
            String programName = epg.get(i2).getProgramName();
            Date startTime = epg.get(this.f15884M).getStartTime();
            Date endTime = epg.get(this.f15884M).getEndTime();
            String format = new SimpleDateFormat("HH:mm", locale).format(startTime);
            String format2 = new SimpleDateFormat("HH:mm", locale).format(endTime);
            this.f15886O.setInfoText(format + " ~ " + format2 + "\n" + title + " - " + programName + "\n");
            int time2 = (int) (((time.getTime() - startTime.getTime()) * 100) / (endTime.getTime() - startTime.getTime()));
            if (time2 >= 0 && time2 <= 100) {
                i3 = time2;
            }
            this.f15886O.setTimeProgress(i3);
        } else {
            String programName2 = channelData.getProgramName();
            if (programName2 != null && programName2.length() != 0) {
                this.f15886O.setInfoText(title + " - " + programName2);
            } else {
                this.f15886O.setInfoText(title);
            }
            this.f15886O.setTimeProgress(0);
        }
        if (channelData.getFavorite() > 0) {
            this.f15886O.showFavorite();
        } else {
            this.f15886O.hideFavorite();
        }
        this.f15886O.setResText(channelData.getResolution());
        if (i > 0) {
            this.f15886O.closeDelayed(i);
        }
    }

    /* renamed from: i */
    public final String m4462i(int i) {
        return getResources().getString(i);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.hisona.allive.u, com.hisona.allive.BackgroundTask] */
    /* renamed from: j */
    public final void m4463j() {
        m4457d();
        PlayerActivity playerActivity = this.f15874C;
        int i = this.f15881J;
        ?? backgroundTask = new BackgroundTask(playerActivity, playerActivity);
        backgroundTask.f16008a = "";
        backgroundTask.f16009b = "";
        backgroundTask.f16010c = "";
        backgroundTask.f16011d = "";
        backgroundTask.f16012e = "";
        backgroundTask.f16013f = null;
        backgroundTask.f16014g = i;
        backgroundTask.execute();
    }

    /* renamed from: k */
    public final void m4464k() {
        ExoPlayer exoPlayer = this.f15877F;
        if (exoPlayer != null) {
            exoPlayer.stop();
            this.f15877F.release();
            this.f15877F = null;
        }
        ExoPlayer exoPlayer2 = this.f15878G;
        if (exoPlayer2 != null) {
            exoPlayer2.stop();
            this.f15878G.release();
            this.f15878G = null;
        }
    }

    /* renamed from: l */
    public final void m4465l(int i) {
        int i2 = this.f15881J;
        this.f15883L = i2;
        ChannelData channelData = (ChannelData) f15870e0.get(i2);
        ArrayList<EPGData> epg = channelData.getEPG();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(calendar.getTimeInMillis() + (32400000 - calendar.getTimeZone().getRawOffset()));
        Date time = calendar.getTime();
        this.f15884M = -1;
        int i3 = 0;
        while (true) {
            if (i3 >= epg.size()) {
                break;
            }
            if (time.compareTo(epg.get(i3).getEndTime()) < 0) {
                this.f15884M = i3;
                break;
            }
            i3++;
        }
        m4461h(0);
        if (!this.f15886O.isPanelShow().booleanValue()) {
            this.f15886O.showSlidingPanel(channelData.getSiteType(), i);
        }
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onAudioAttributesChanged(AudioAttributes audioAttributes) {
        b62.m2036a(this, audioAttributes);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onAudioSessionIdChanged(int i) {
        b62.m2037b(this, i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onAvailableCommandsChanged(Player.Commands commands) {
        b62.m2038c(this, commands);
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
        this.f15874C = this;
        this.f15875D = (StyledPlayerView) findViewById(R.id.video_view1);
        this.f15876E = (StyledPlayerView) findViewById(R.id.video_view2);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        this.f15888Q = progressBar;
        progressBar.setVisibility(0);
        this.f15886O = new SlidingPanel(this);
        this.f15887P = new VolumePanel(this);
        this.f15891T = false;
        this.f15892U = false;
        q91 q91Var = new q91(1, this);
        this.f15875D.setOnTouchListener(q91Var);
        this.f15876E.setOnTouchListener(q91Var);
        this.f15895X = new Timer();
        this.f15898a0 = Boolean.FALSE;
        this.f15886O.setInfoText("");
        this.f15881J = getIntent().getIntExtra(m4462i(R.string.CURRENTCHANNEL_STR), 0);
        f15871f0 = getIntent().getStringArrayListExtra(m4462i(R.string.AUTHKEY_STR));
        this.f15880I = getIntent().getIntExtra(m4462i(R.string.SITETYPE_STR), 0);
        this.f15890S = getIntent().getBooleanExtra(m4462i(R.string.VOLUMECONTROL_STR), false);
        if (this.f15880I == Utils.SiteType.Tving.ordinal()) {
            f15870e0 = TvingRowSupportFragment.getChannelList();
        } else if (this.f15880I == Utils.SiteType.Wavve.ordinal()) {
            f15870e0 = WavveRowSupportFragment.getChannelList();
        } else if (this.f15880I == Utils.SiteType.Favorite.ordinal()) {
            f15870e0 = FavoriteRowSupportFragment.getChannelList();
        }
        if (this.f15890S) {
            try {
                this.f15889R = Float.parseFloat((String) Hawk.get(m4462i(R.string.VOLUMECONTROL_STR)));
            } catch (Exception unused) {
                this.f15889R = 1.0f;
            }
        } else {
            this.f15889R = 1.0f;
        }
        this.f15882K = -1;
        String string = Settings.Secure.getString(getContentResolver(), "android_id");
        if (string == null || string.equals("")) {
            string = "allive-android-4.5";
        }
        f15872g0 = UUID.nameUUIDFromBytes(string.getBytes()).toString();
        f15873h0 = "";
        this.f15899b0 = FirebaseAnalytics.getInstance(this);
        m4463j();
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onCues(CueGroup cueGroup) {
        b62.m2039d(this, cueGroup);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f15895X.cancel();
        this.f15895X.purge();
        this.f15886O.hideSlidingPanel(true);
        this.f15882K = this.f15881J;
        m4457d();
        m4464k();
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onDeviceInfoChanged(DeviceInfo deviceInfo) {
        b62.m2041f(this, deviceInfo);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onDeviceVolumeChanged(int i, boolean z) {
        b62.m2042g(this, i, z);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onEvents(Player player, Player.Events events) {
        b62.m2043h(this, player, events);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onIsLoadingChanged(boolean z) {
        b62.m2044i(this, z);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onIsPlayingChanged(boolean z) {
        int i;
        ExoPlayer exoPlayer;
        ExoPlayer exoPlayer2;
        if (z) {
            this.f15893V = false;
            if (this.f15894W) {
                this.f15894W = false;
                return;
            } else {
                m4465l(1000);
                return;
            }
        }
        if (this.f15875D.getVisibility() == 0 && (exoPlayer2 = this.f15877F) != null) {
            i = exoPlayer2.getPlaybackState();
        } else if (this.f15876E.getVisibility() == 0 && (exoPlayer = this.f15878G) != null) {
            i = exoPlayer.getPlaybackState();
        } else {
            i = 0;
        }
        if (i == 4) {
            this.f15894W = false;
            m4463j();
        } else if (i == 1) {
            this.f15894W = true;
            m4463j();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        int i2;
        int i3 = 0;
        if (i == 23 || i == 66 || i == 109 || i == 160 || i == 29 || i == 126 || i == 165) {
            if (keyEvent.isLongPress()) {
                this.f15891T = true;
                if (!this.f15886O.isPanelShow().booleanValue()) {
                    m4465l(PathInterpolatorCompat.MAX_NUM_POINTS);
                }
                int i4 = this.f15881J;
                if (i4 != this.f15883L) {
                    return false;
                }
                this.f15892U = true;
                ChannelData channelData = (ChannelData) f15870e0.get(i4);
                if (channelData.getFavorite() > 0) {
                    channelData.setFavorite(0);
                    this.f15886O.hideFavorite();
                    Toast.makeText(this.f15874C, m4462i(R.string.favorite_disable), 0).show();
                } else {
                    channelData.setFavorite(1);
                    this.f15886O.showFavorite();
                    Toast.makeText(this.f15874C, m4462i(R.string.favorite_enable), 0).show();
                }
            } else {
                this.f15886O.closeDelayed(PathInterpolatorCompat.MAX_NUM_POINTS);
            }
        } else if (i == 4 || i == 30 || i == 86 || i == 85) {
            if (this.f15886O.isPanelShow().booleanValue()) {
                this.f15886O.hideSlidingPanel(true);
                return false;
            }
            m4459f();
        } else if (i == 19 || i == 166 || i == 87) {
            if (keyEvent.isLongPress()) {
                this.f15891T = true;
                if (this.f15886O.isPanelShow().booleanValue()) {
                    ChannelData channelData2 = (ChannelData) f15870e0.get(this.f15883L);
                    EPGData ePGData = channelData2.getEPG().get(this.f15884M);
                    String title = channelData2.getTitle();
                    Date startTime = ePGData.getStartTime();
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(calendar.getTimeInMillis() + (32400000 - calendar.getTimeZone().getRawOffset()));
                    if (startTime.compareTo(calendar.getTime()) > 0) {
                        String str = title + " 채널이 " + new SimpleDateFormat("HH:mm", Locale.US).format(startTime) + " 에";
                        int length = (str.length() - 10) / 2;
                        String str2 = " 예약 되었습니다.";
                        while (i3 < length) {
                            str2 = AbstractC1726qj.m7038C(" ", str2);
                            i3++;
                        }
                        Toast.makeText(this.f15874C, str + "\n" + str2, 1).show();
                        if (this.f15898a0.booleanValue()) {
                            this.f15895X.cancel();
                        }
                        this.f15896Y = this.f15883L;
                        this.f15897Z = this.f15884M;
                        c62 c62Var = new c62(this);
                        Timer timer = new Timer();
                        this.f15895X = timer;
                        timer.schedule(c62Var, startTime);
                        this.f15898a0 = Boolean.TRUE;
                    }
                }
            }
        } else if (i == 20 || i == 167 || i == 88) {
            if (keyEvent.isLongPress()) {
                this.f15891T = true;
                if (this.f15886O.isPanelShow().booleanValue() && this.f15898a0.booleanValue()) {
                    this.f15898a0 = Boolean.FALSE;
                    this.f15895X.cancel();
                    ChannelData channelData3 = (ChannelData) f15870e0.get(this.f15896Y);
                    EPGData ePGData2 = channelData3.getEPG().get(this.f15897Z);
                    String str3 = " 채널( " + channelData3.getTitle() + ":" + new SimpleDateFormat("HH:mm", Locale.US).format(ePGData2.getStartTime()) + ") 예약이";
                    int length2 = (str3.length() - 9) / 2;
                    String str4 = " 취소되었습니다.";
                    while (i3 < length2) {
                        str4 = AbstractC1726qj.m7038C(" ", str4);
                        i3++;
                    }
                    Toast.makeText(this.f15874C, str3 + "\n" + str4, 1).show();
                }
            }
        } else if (i == 21) {
            if (this.f15886O.isPanelShow().booleanValue()) {
                int i5 = this.f15884M;
                if (i5 >= 0 && i5 > 0) {
                    this.f15884M = i5 - 1;
                }
                m4461h(PathInterpolatorCompat.MAX_NUM_POINTS);
            } else if (this.f15890S) {
                if (this.f15875D.getVisibility() == 0) {
                    float volume = this.f15877F.getVolume();
                    this.f15889R = volume;
                    if (volume > RecyclerView.f7068F0) {
                        this.f15889R = volume - 0.05f;
                    }
                    this.f15877F.setVolume(this.f15889R);
                } else if (this.f15876E.getVisibility() == 0) {
                    float volume2 = this.f15878G.getVolume();
                    this.f15889R = volume2;
                    if (volume2 > RecyclerView.f7068F0) {
                        this.f15889R = volume2 - 0.05f;
                    }
                    this.f15878G.setVolume(this.f15889R);
                }
                this.f15887P.setVolume((int) (this.f15889R * 100.0f));
                this.f15887P.showVolumePanel(2000);
                Hawk.put(m4462i(R.string.VOLUMECONTROL_STR), Float.toString(this.f15889R));
            } else {
                int i6 = this.f15882K;
                if (i6 != -1) {
                    this.f15882K = this.f15881J;
                    this.f15881J = i6;
                    m4463j();
                }
            }
        } else if (i == 22) {
            if (this.f15886O.isPanelShow().booleanValue()) {
                if (this.f15884M >= 0) {
                    int size = ((ChannelData) f15870e0.get(this.f15883L)).getEPG().size() - 1;
                    int i7 = this.f15884M;
                    if (i7 < size) {
                        this.f15884M = i7 + 1;
                    }
                }
                m4461h(PathInterpolatorCompat.MAX_NUM_POINTS);
            } else if (this.f15890S) {
                if (this.f15875D.getVisibility() == 0) {
                    float volume3 = this.f15877F.getVolume();
                    this.f15889R = volume3;
                    if (volume3 < 1.0f) {
                        this.f15889R = volume3 + 0.05f;
                    }
                    this.f15877F.setVolume(this.f15889R);
                } else if (this.f15876E.getVisibility() == 0) {
                    float volume4 = this.f15878G.getVolume();
                    this.f15889R = volume4;
                    if (volume4 < 1.0f) {
                        this.f15889R = volume4 + 0.05f;
                    }
                    this.f15878G.setVolume(this.f15889R);
                }
                this.f15887P.setVolume((int) (this.f15889R * 100.0f));
                this.f15887P.showVolumePanel(2000);
                Hawk.put(m4462i(R.string.VOLUMECONTROL_STR), Float.toString(this.f15889R));
            }
        } else if ((i == 272 || i == 90 || i == 89) && (i2 = this.f15882K) != -1) {
            this.f15882K = this.f15881J;
            this.f15881J = i2;
            m4463j();
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 23 && i != 66 && i != 109 && i != 160 && i != 29 && i != 126 && i != 165) {
            if (i != 19 && i != 166 && i != 87) {
                if (i == 20 || i == 167 || i == 88) {
                    if (this.f15891T) {
                        this.f15891T = false;
                    } else if (this.f15893V && this.f15886O.isPanelShow().booleanValue()) {
                        int i2 = this.f15883L;
                        if (i2 > 0) {
                            this.f15883L = i2 - 1;
                        } else {
                            this.f15883L = f15870e0.size() - 1;
                        }
                        m4458e();
                    } else {
                        int i3 = this.f15881J;
                        this.f15882K = i3;
                        if (i3 > 0) {
                            this.f15881J = i3 - 1;
                        } else {
                            this.f15881J = f15870e0.size() - 1;
                        }
                        this.f15886O.hideSlidingPanel(true);
                        this.f15888Q.setVisibility(0);
                        m4463j();
                    }
                }
            } else if (this.f15891T) {
                this.f15891T = false;
            } else if (this.f15893V && this.f15886O.isPanelShow().booleanValue()) {
                if (this.f15883L < f15870e0.size() - 1) {
                    this.f15883L++;
                } else {
                    this.f15883L = 0;
                }
                m4458e();
            } else {
                int i4 = this.f15881J;
                this.f15882K = i4;
                if (i4 < f15870e0.size() - 1) {
                    this.f15881J++;
                } else {
                    this.f15881J = 0;
                }
                this.f15886O.hideSlidingPanel(true);
                this.f15888Q.setVisibility(0);
                m4463j();
            }
        } else if (this.f15886O.isPanelShow().booleanValue()) {
            if (this.f15891T) {
                this.f15891T = false;
            } else {
                this.f15886O.hideSlidingPanel(true);
                int i5 = this.f15881J;
                int i6 = this.f15883L;
                if (i5 != i6) {
                    this.f15882K = i5;
                    this.f15881J = i6;
                    this.f15888Q.setVisibility(0);
                    m4463j();
                }
            }
        } else {
            this.f15893V = true;
            m4465l(PathInterpolatorCompat.MAX_NUM_POINTS);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onLoadingChanged(boolean z) {
        b62.m2046k(this, z);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onMaxSeekToPreviousPositionChanged(long j) {
        b62.m2047l(this, j);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onMediaItemTransition(MediaItem mediaItem, int i) {
        b62.m2048m(this, mediaItem, i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
        b62.m2049n(this, mediaMetadata);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onMetadata(Metadata metadata) {
        b62.m2050o(this, metadata);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.f15880I == Utils.SiteType.Tving.ordinal()) {
            f15870e0 = TvingRowSupportFragment.getChannelList();
        } else if (this.f15880I == Utils.SiteType.Wavve.ordinal()) {
            f15870e0 = WavveRowSupportFragment.getChannelList();
        } else if (this.f15880I == Utils.SiteType.Favorite.ordinal()) {
            f15870e0 = FavoriteRowSupportFragment.getChannelList();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (Util.SDK_INT <= 23) {
            m4464k();
        }
        unregisterReceiver(this.f15900c0);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onPlayWhenReadyChanged(boolean z, int i) {
        b62.m2051p(this, z, i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        b62.m2052q(this, playbackParameters);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onPlaybackStateChanged(int i) {
        b62.m2053r(this, i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
        b62.m2054s(this, i);
    }

    public void onPlayerButtonClick(View view) {
        int id = view.getId();
        if (id == R.id.backButton) {
            m4459f();
            return;
        }
        if (id == R.id.upButton) {
            if (this.f15886O.isPanelShow().booleanValue()) {
                if (this.f15883L < f15870e0.size() - 1) {
                    this.f15883L++;
                } else {
                    this.f15883L = 0;
                }
                m4458e();
                return;
            }
            return;
        }
        if (id == R.id.downButton) {
            if (this.f15886O.isPanelShow().booleanValue()) {
                int i = this.f15883L;
                if (i > 0) {
                    this.f15883L = i - 1;
                } else {
                    this.f15883L = f15870e0.size() - 1;
                }
                m4458e();
                return;
            }
            return;
        }
        if (id == R.id.selectButton) {
            if (this.f15886O.isPanelShow().booleanValue()) {
                this.f15886O.hideSlidingPanel(false);
                int i2 = this.f15881J;
                int i3 = this.f15883L;
                if (i2 != i3) {
                    this.f15882K = i2;
                    this.f15881J = i3;
                    this.f15888Q.setVisibility(0);
                    m4463j();
                    return;
                }
                return;
            }
            return;
        }
        if (id == R.id.leftButton) {
            if (this.f15886O.isPanelShow().booleanValue()) {
                int i4 = this.f15884M;
                if (i4 >= 0 && i4 > 0) {
                    this.f15884M = i4 - 1;
                }
                m4461h(PathInterpolatorCompat.MAX_NUM_POINTS);
                return;
            }
            return;
        }
        if (id == R.id.rightButton) {
            if (this.f15886O.isPanelShow().booleanValue()) {
                if (this.f15884M >= 0) {
                    int size = ((ChannelData) f15870e0.get(this.f15883L)).getEPG().size() - 1;
                    int i5 = this.f15884M;
                    if (i5 < size) {
                        this.f15884M = i5 + 1;
                    }
                }
                m4461h(PathInterpolatorCompat.MAX_NUM_POINTS);
                return;
            }
            return;
        }
        if (id == R.id.favoriteButton) {
            if (!this.f15886O.isPanelShow().booleanValue()) {
                m4465l(PathInterpolatorCompat.MAX_NUM_POINTS);
            }
            int i6 = this.f15881J;
            if (i6 != this.f15883L) {
                return;
            }
            ChannelData channelData = (ChannelData) f15870e0.get(i6);
            this.f15892U = true;
            if (channelData.getFavorite() > 0) {
                channelData.setFavorite(0);
                this.f15886O.hideFavorite();
                Toast.makeText(this.f15874C, m4462i(R.string.favorite_disable), 0).show();
                return;
            } else {
                channelData.setFavorite(1);
                this.f15886O.showFavorite();
                Toast.makeText(this.f15874C, m4462i(R.string.favorite_enable), 0).show();
                return;
            }
        }
        if (id == R.id.chdownButton) {
            int i7 = this.f15881J;
            this.f15882K = i7;
            if (i7 > 0) {
                this.f15881J = i7 - 1;
            } else {
                this.f15881J = f15870e0.size() - 1;
            }
            this.f15886O.hideSlidingPanel(false);
            this.f15888Q.setVisibility(0);
            m4463j();
            return;
        }
        if (id == R.id.chupButton) {
            int i8 = this.f15881J;
            this.f15882K = i8;
            if (i8 < f15870e0.size() - 1) {
                this.f15881J++;
            } else {
                this.f15881J = 0;
            }
            this.f15886O.hideSlidingPanel(false);
            this.f15888Q.setVisibility(0);
            m4463j();
        }
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onPlayerError(PlaybackException playbackException) {
        int i = playbackException.errorCode;
        if (i != 2001 && i != 2002 && i != 1003) {
            b62.m2055t(this, playbackException);
            return;
        }
        Log.e("PlayerActivity", "onPlayerError: " + playbackException.errorCode + ", " + playbackException.getErrorCodeName());
        Toast.makeText(this.f15874C, m4462i(R.string.play_error_retry), 0).show();
        m4463j();
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onPlayerErrorChanged(PlaybackException playbackException) {
        b62.m2056u(this, playbackException);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onPlayerStateChanged(boolean z, int i) {
        b62.m2057v(this, z, i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
        b62.m2058w(this, mediaMetadata);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onPositionDiscontinuity(int i) {
        b62.m2059x(this, i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onRenderedFirstFrame() {
        b62.m2061z(this);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onRepeatModeChanged(int i) {
        b62.m2024A(this, i);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.media.action.HDMI_AUDIO_PLUG");
        registerReceiver(this.f15900c0, intentFilter);
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
        b62.m2025B(this, j);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onSeekForwardIncrementChanged(long j) {
        b62.m2026C(this, j);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onSeekProcessed() {
        b62.m2027D(this);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onShuffleModeEnabledChanged(boolean z) {
        b62.m2028E(this, z);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onSkipSilenceEnabledChanged(boolean z) {
        b62.m2029F(this, z);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        f15869d0 = true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (Util.SDK_INT > 23) {
            m4464k();
        }
        f15869d0 = false;
        finish();
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onSurfaceSizeChanged(int i, int i2) {
        b62.m2030G(this, i, i2);
    }

    @Override // com.hisona.allive.ResultListener
    public void onTaskTerminate(int i, int i2, Bundle bundle) {
        Date date;
        this.f15888Q.setVisibility(4);
        String string = bundle.getString(ImagesContract.URL);
        String string2 = bundle.getString("cookie");
        String string3 = bundle.getString("drmserver");
        String string4 = bundle.getString("drmassert");
        if (bundle.getLong("starttime") > 0) {
            date = new Date(bundle.getLong("starttime"));
        } else {
            date = null;
        }
        int i3 = AbstractC1086t.f16005a[Utils.Code.values()[i2].ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        if (string.contains("/manifest.mpd")) {
                            ChannelData channelData = (ChannelData) f15870e0.get(this.f15881J);
                            if (channelData.isAudioChannel().booleanValue()) {
                                GlideApp.with((FragmentActivity) this).asDrawable().mo8492load(channelData.getStillImageUrl()).fitCenter().diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true).into((GlideRequest<Drawable>) new d62(this, 2));
                            }
                            this.f15875D.setVisibility(8);
                            this.f15876E.setVisibility(0);
                            ExoPlayer exoPlayer = this.f15877F;
                            if (exoPlayer != null) {
                                exoPlayer.stop();
                            }
                            ExoPlayer exoPlayer2 = this.f15878G;
                            if (exoPlayer2 == null) {
                                if (exoPlayer2 != null) {
                                    exoPlayer2.stop();
                                    this.f15878G.release();
                                    this.f15878G = null;
                                }
                                this.f15878G = new ExoPlayer.Builder(this.f15874C).build();
                                TvingHttpMediaDrmCallback tvingHttpMediaDrmCallback = new TvingHttpMediaDrmCallback(string3, new DefaultHttpDataSource.Factory().setUserAgent(m4462i(R.string.USERAGENT)));
                                this.f15879H = tvingHttpMediaDrmCallback;
                                tvingHttpMediaDrmCallback.setDefaultLicenseUrl(string3);
                                this.f15879H.setKeyRequestProperty("AcquireLicenseAssertion", string4);
                                this.f15878G.setPlayWhenReady(true);
                                this.f15878G.addListener(this);
                                this.f15878G.setVolume(this.f15889R);
                                this.f15876E.setPlayer(this.f15878G);
                                this.f15876E.setUseController(false);
                                this.f15886O.setInfoText("");
                            } else {
                                this.f15879H.setDefaultLicenseUrl(string3);
                                this.f15879H.setKeyRequestProperty("AcquireLicenseAssertion", string4);
                            }
                            this.f15878G.setMediaSource(new DashMediaSource.Factory(new DefaultDataSource.Factory(this)).setDrmSessionManagerProvider((DrmSessionManagerProvider) new u50(1, this)).createMediaSource(MediaItem.fromUri(Uri.parse(string))));
                            this.f15878G.prepare();
                            this.f15878G.setVolume(this.f15889R);
                            return;
                        }
                        if (string2 != null && !string2.equals("")) {
                            ChannelData channelData2 = (ChannelData) f15870e0.get(this.f15881J);
                            if (channelData2.isAudioChannel().booleanValue()) {
                                GlideApp.with((FragmentActivity) this).asDrawable().mo8492load(channelData2.getStillImageUrl()).fitCenter().diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true).into((GlideRequest<Drawable>) new d62(this, 1));
                            }
                            this.f15875D.setVisibility(0);
                            this.f15876E.setVisibility(8);
                            ExoPlayer exoPlayer3 = this.f15878G;
                            if (exoPlayer3 != null) {
                                exoPlayer3.stop();
                            }
                            if (this.f15877F == null) {
                                m4460g();
                            }
                            DefaultHttpDataSource.Factory userAgent = new DefaultHttpDataSource.Factory().setUserAgent(m4462i(R.string.USERAGENT));
                            if (!string2.equals("")) {
                                HashMap hashMap = new HashMap();
                                hashMap.put(HttpHeaders.COOKIE, string2);
                                userAgent.setDefaultRequestProperties((Map<String, String>) hashMap);
                            }
                            this.f15877F.setMediaSource(new HlsMediaSource.Factory(userAgent).setAllowChunklessPreparation(true).createMediaSource(MediaItem.fromUri(Uri.parse(string))));
                            this.f15877F.prepare();
                            this.f15877F.setVolume(this.f15889R);
                            return;
                        }
                        ChannelData channelData3 = (ChannelData) f15870e0.get(this.f15881J);
                        if (channelData3.isAudioChannel().booleanValue()) {
                            GlideApp.with((FragmentActivity) this).asDrawable().mo8492load(channelData3.getStillImageUrl()).fitCenter().diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true).into((GlideRequest<Drawable>) new d62(this, 0));
                        }
                        this.f15875D.setVisibility(0);
                        this.f15876E.setVisibility(8);
                        ExoPlayer exoPlayer4 = this.f15878G;
                        if (exoPlayer4 != null) {
                            exoPlayer4.stop();
                        }
                        if (this.f15877F == null) {
                            m4460g();
                        }
                        this.f15877F.setMediaSource(new HlsMediaSource.Factory(new DefaultDataSource.Factory(this)).setAllowChunklessPreparation(true).createMediaSource(MediaItem.fromUri(Uri.parse(string))));
                        this.f15877F.prepare();
                        this.f15877F.setVolume(this.f15889R);
                        if (date != null) {
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTimeInMillis(calendar.getTimeInMillis() + (32400000 - calendar.getTimeZone().getRawOffset()));
                            long time = (calendar.getTime().getTime() - date.getTime()) - 60000;
                            if (time > 0) {
                                this.f15877F.seekTo(time);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                Utils.showToast(this.f15874C, R.string.noright_error);
                ExoPlayer exoPlayer5 = this.f15877F;
                if (exoPlayer5 != null) {
                    exoPlayer5.stop();
                }
                ExoPlayer exoPlayer6 = this.f15878G;
                if (exoPlayer6 != null) {
                    exoPlayer6.stop();
                    return;
                }
                return;
            }
            Utils.showToast(this.f15874C, R.string.geturl_error);
            ExoPlayer exoPlayer7 = this.f15877F;
            if (exoPlayer7 != null) {
                exoPlayer7.stop();
            }
            ExoPlayer exoPlayer8 = this.f15878G;
            if (exoPlayer8 != null) {
                exoPlayer8.stop();
                return;
            }
            return;
        }
        Utils.showToast(this.f15874C, R.string.login_error_video);
        setResult(0);
        finishAfterTransition();
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onTimelineChanged(Timeline timeline, int i) {
        b62.m2031H(this, timeline, i);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
        b62.m2032I(this, trackSelectionParameters);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onTracksChanged(Tracks tracks) {
        b62.m2033J(this, tracks);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onVideoSizeChanged(VideoSize videoSize) {
        b62.m2034K(this, videoSize);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onVolumeChanged(float f) {
        b62.m2035L(this, f);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onCues(List list) {
        b62.m2040e(this, list);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public final /* synthetic */ void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i) {
        b62.m2060y(this, positionInfo, positionInfo2, i);
    }
}
