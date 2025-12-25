package com.google.android.exoplayer2.p003ui;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.media.app.NotificationCompat;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.NotificationUtil;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p000.C1524lu;
import p000.k62;

/* loaded from: classes.dex */
public class PlayerNotificationManager {
    public static final String ACTION_FAST_FORWARD = "com.google.android.exoplayer.ffwd";
    public static final String ACTION_NEXT = "com.google.android.exoplayer.next";
    public static final String ACTION_PAUSE = "com.google.android.exoplayer.pause";
    public static final String ACTION_PLAY = "com.google.android.exoplayer.play";
    public static final String ACTION_PREVIOUS = "com.google.android.exoplayer.prev";
    public static final String ACTION_REWIND = "com.google.android.exoplayer.rewind";
    public static final String ACTION_STOP = "com.google.android.exoplayer.stop";
    public static final String EXTRA_INSTANCE_ID = "INSTANCE_ID";

    /* renamed from: O */
    public static int f12109O;

    /* renamed from: A */
    public boolean f12110A;

    /* renamed from: B */
    public boolean f12111B;

    /* renamed from: C */
    public boolean f12112C;

    /* renamed from: D */
    public boolean f12113D;

    /* renamed from: E */
    public boolean f12114E;

    /* renamed from: F */
    public int f12115F;

    /* renamed from: G */
    public boolean f12116G;

    /* renamed from: H */
    public int f12117H;

    /* renamed from: I */
    public int f12118I;

    /* renamed from: J */
    public int f12119J;

    /* renamed from: K */
    public int f12120K;

    /* renamed from: L */
    public int f12121L;

    /* renamed from: M */
    public boolean f12122M;

    /* renamed from: N */
    public final String f12123N;

    /* renamed from: a */
    public final Context f12124a;

    /* renamed from: b */
    public final String f12125b;

    /* renamed from: c */
    public final int f12126c;

    /* renamed from: d */
    public final MediaDescriptionAdapter f12127d;

    /* renamed from: e */
    public final NotificationListener f12128e;

    /* renamed from: f */
    public final CustomActionReceiver f12129f;

    /* renamed from: g */
    public final Handler f12130g;

    /* renamed from: h */
    public final NotificationManagerCompat f12131h;

    /* renamed from: i */
    public final IntentFilter f12132i;

    /* renamed from: j */
    public final k62 f12133j;

    /* renamed from: k */
    public final C0721c f12134k;

    /* renamed from: l */
    public final HashMap f12135l;

    /* renamed from: m */
    public final Map f12136m;

    /* renamed from: n */
    public final PendingIntent f12137n;

    /* renamed from: o */
    public final int f12138o;

    /* renamed from: p */
    public NotificationCompat.Builder f12139p;

    /* renamed from: q */
    public ArrayList f12140q;

    /* renamed from: r */
    public Player f12141r;

    /* renamed from: s */
    public boolean f12142s;

    /* renamed from: t */
    public int f12143t;

    /* renamed from: u */
    public MediaSessionCompat.Token f12144u;

    /* renamed from: v */
    public boolean f12145v;

    /* renamed from: w */
    public boolean f12146w;

    /* renamed from: x */
    public boolean f12147x;

    /* renamed from: y */
    public boolean f12148y;

    /* renamed from: z */
    public boolean f12149z;

    /* loaded from: classes.dex */
    public final class BitmapCallback {

        /* renamed from: a */
        public final int f12150a;

        public BitmapCallback(int i) {
            this.f12150a = i;
        }

        public void onBitmap(Bitmap bitmap) {
            if (bitmap != null) {
                PlayerNotificationManager.this.f12130g.obtainMessage(1, this.f12150a, -1, bitmap).sendToTarget();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface CustomActionReceiver {
        Map<String, NotificationCompat.Action> createCustomActions(Context context, int i);

        List<String> getCustomActions(Player player);

        void onCustomAction(Player player, String str, Intent intent);
    }

    /* loaded from: classes.dex */
    public interface MediaDescriptionAdapter {
        @Nullable
        PendingIntent createCurrentContentIntent(Player player);

        @Nullable
        CharSequence getCurrentContentText(Player player);

        CharSequence getCurrentContentTitle(Player player);

        @Nullable
        Bitmap getCurrentLargeIcon(Player player, BitmapCallback bitmapCallback);

        @Nullable
        CharSequence getCurrentSubText(Player player);
    }

    /* loaded from: classes.dex */
    public interface NotificationListener {
        void onNotificationCancelled(int i, boolean z);

        void onNotificationPosted(int i, Notification notification, boolean z);
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Priority {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Visibility {
    }

    public PlayerNotificationManager(Context context, String str, int i, MediaDescriptionAdapter mediaDescriptionAdapter, @Nullable NotificationListener notificationListener, @Nullable CustomActionReceiver customActionReceiver, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, @Nullable String str2) {
        Map<String, NotificationCompat.Action> emptyMap;
        Context applicationContext = context.getApplicationContext();
        this.f12124a = applicationContext;
        this.f12125b = str;
        this.f12126c = i;
        this.f12127d = mediaDescriptionAdapter;
        this.f12128e = notificationListener;
        this.f12129f = customActionReceiver;
        this.f12119J = i2;
        this.f12123N = str2;
        int i10 = f12109O;
        f12109O = i10 + 1;
        this.f12138o = i10;
        this.f12130g = Util.createHandler(Looper.getMainLooper(), new C1524lu(4, this));
        this.f12131h = NotificationManagerCompat.from(applicationContext);
        this.f12133j = new k62(this);
        this.f12134k = new C0721c(this);
        this.f12132i = new IntentFilter();
        this.f12145v = true;
        this.f12146w = true;
        this.f12113D = true;
        this.f12149z = true;
        this.f12110A = true;
        this.f12116G = true;
        this.f12122M = true;
        this.f12118I = 0;
        this.f12117H = 0;
        this.f12121L = -1;
        this.f12115F = 1;
        this.f12120K = 1;
        HashMap hashMap = new HashMap();
        hashMap.put(ACTION_PLAY, new NotificationCompat.Action(i3, applicationContext.getString(R.string.exo_controls_play_description), m2911a(applicationContext, i10, ACTION_PLAY)));
        hashMap.put(ACTION_PAUSE, new NotificationCompat.Action(i4, applicationContext.getString(R.string.exo_controls_pause_description), m2911a(applicationContext, i10, ACTION_PAUSE)));
        hashMap.put(ACTION_STOP, new NotificationCompat.Action(i5, applicationContext.getString(R.string.exo_controls_stop_description), m2911a(applicationContext, i10, ACTION_STOP)));
        hashMap.put(ACTION_REWIND, new NotificationCompat.Action(i6, applicationContext.getString(R.string.exo_controls_rewind_description), m2911a(applicationContext, i10, ACTION_REWIND)));
        hashMap.put(ACTION_FAST_FORWARD, new NotificationCompat.Action(i7, applicationContext.getString(R.string.exo_controls_fastforward_description), m2911a(applicationContext, i10, ACTION_FAST_FORWARD)));
        hashMap.put(ACTION_PREVIOUS, new NotificationCompat.Action(i8, applicationContext.getString(R.string.exo_controls_previous_description), m2911a(applicationContext, i10, ACTION_PREVIOUS)));
        hashMap.put(ACTION_NEXT, new NotificationCompat.Action(i9, applicationContext.getString(R.string.exo_controls_next_description), m2911a(applicationContext, i10, ACTION_NEXT)));
        this.f12135l = hashMap;
        Iterator it = hashMap.keySet().iterator();
        while (it.hasNext()) {
            this.f12132i.addAction((String) it.next());
        }
        if (customActionReceiver != null) {
            emptyMap = customActionReceiver.createCustomActions(applicationContext, this.f12138o);
        } else {
            emptyMap = Collections.emptyMap();
        }
        this.f12136m = emptyMap;
        Iterator<String> it2 = emptyMap.keySet().iterator();
        while (it2.hasNext()) {
            this.f12132i.addAction(it2.next());
        }
        this.f12137n = m2911a(applicationContext, this.f12138o, "com.google.android.exoplayer.dismiss");
        this.f12132i.addAction("com.google.android.exoplayer.dismiss");
    }

    /* renamed from: a */
    public static PendingIntent m2911a(Context context, int i, String str) {
        int i2;
        Intent intent = new Intent(str).setPackage(context.getPackageName());
        intent.putExtra(EXTRA_INSTANCE_ID, i);
        if (Util.SDK_INT >= 23) {
            i2 = 201326592;
        } else {
            i2 = C0643C.BUFFER_FLAG_FIRST_SAMPLE;
        }
        return PendingIntent.getBroadcast(context, i, intent, i2);
    }

    /* renamed from: b */
    public final void m2912b(Player player, Bitmap bitmap) {
        boolean ongoing = getOngoing(player);
        NotificationCompat.Builder createNotification = createNotification(player, this.f12139p, ongoing, bitmap);
        this.f12139p = createNotification;
        boolean z = false;
        if (createNotification == null) {
            m2913c(false);
            return;
        }
        Notification build = createNotification.build();
        NotificationManagerCompat notificationManagerCompat = this.f12131h;
        int i = this.f12126c;
        notificationManagerCompat.notify(i, build);
        if (!this.f12142s) {
            this.f12124a.registerReceiver(this.f12134k, this.f12132i);
        }
        NotificationListener notificationListener = this.f12128e;
        if (notificationListener != null) {
            if (ongoing || !this.f12142s) {
                z = true;
            }
            notificationListener.onNotificationPosted(i, build, z);
        }
        this.f12142s = true;
    }

    /* renamed from: c */
    public final void m2913c(boolean z) {
        if (this.f12142s) {
            this.f12142s = false;
            this.f12130g.removeMessages(0);
            NotificationManagerCompat notificationManagerCompat = this.f12131h;
            int i = this.f12126c;
            notificationManagerCompat.cancel(i);
            this.f12124a.unregisterReceiver(this.f12134k);
            NotificationListener notificationListener = this.f12128e;
            if (notificationListener != null) {
                notificationListener.onNotificationCancelled(i, z);
            }
        }
    }

    @Nullable
    public NotificationCompat.Builder createNotification(Player player, @Nullable NotificationCompat.Builder builder, boolean z, @Nullable Bitmap bitmap) {
        NotificationCompat.Action action;
        if (player.getPlaybackState() == 1 && player.getCurrentTimeline().isEmpty()) {
            this.f12140q = null;
            return null;
        }
        List<String> actions = getActions(player);
        ArrayList arrayList = new ArrayList(actions.size());
        for (int i = 0; i < actions.size(); i++) {
            String str = actions.get(i);
            HashMap hashMap = this.f12135l;
            if (hashMap.containsKey(str)) {
                action = (NotificationCompat.Action) hashMap.get(str);
            } else {
                action = (NotificationCompat.Action) this.f12136m.get(str);
            }
            if (action != null) {
                arrayList.add(action);
            }
        }
        if (builder == null || !arrayList.equals(this.f12140q)) {
            builder = new NotificationCompat.Builder(this.f12124a, this.f12125b);
            this.f12140q = arrayList;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                builder.addAction((NotificationCompat.Action) arrayList.get(i2));
            }
        }
        NotificationCompat.MediaStyle mediaStyle = new NotificationCompat.MediaStyle();
        MediaSessionCompat.Token token = this.f12144u;
        if (token != null) {
            mediaStyle.setMediaSession(token);
        }
        mediaStyle.setShowActionsInCompactView(getActionIndicesForCompactView(actions, player));
        mediaStyle.setShowCancelButton(!z);
        PendingIntent pendingIntent = this.f12137n;
        mediaStyle.setCancelButtonIntent(pendingIntent);
        builder.setStyle(mediaStyle);
        builder.setDeleteIntent(pendingIntent);
        builder.setBadgeIconType(this.f12115F).setOngoing(z).setColor(this.f12118I).setColorized(this.f12116G).setSmallIcon(this.f12119J).setVisibility(this.f12120K).setPriority(this.f12121L).setDefaults(this.f12117H);
        if (Util.SDK_INT >= 21 && this.f12122M && player.isPlaying() && !player.isPlayingAd() && !player.isCurrentMediaItemDynamic() && player.getPlaybackParameters().speed == 1.0f) {
            builder.setWhen(System.currentTimeMillis() - player.getContentPosition()).setShowWhen(true).setUsesChronometer(true);
        } else {
            builder.setShowWhen(false).setUsesChronometer(false);
        }
        MediaDescriptionAdapter mediaDescriptionAdapter = this.f12127d;
        builder.setContentTitle(mediaDescriptionAdapter.getCurrentContentTitle(player));
        builder.setContentText(mediaDescriptionAdapter.getCurrentContentText(player));
        builder.setSubText(mediaDescriptionAdapter.getCurrentSubText(player));
        if (bitmap == null) {
            int i3 = this.f12143t + 1;
            this.f12143t = i3;
            bitmap = mediaDescriptionAdapter.getCurrentLargeIcon(player, new BitmapCallback(i3));
        }
        builder.setLargeIcon(bitmap);
        builder.setContentIntent(mediaDescriptionAdapter.createCurrentContentIntent(player));
        String str2 = this.f12123N;
        if (str2 != null) {
            builder.setGroup(str2);
        }
        builder.setOnlyAlertOnce(true);
        return builder;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int[] getActionIndicesForCompactView(List<String> list, Player player) {
        int i;
        int i2;
        int i3;
        int i4;
        int indexOf = list.indexOf(ACTION_PAUSE);
        int indexOf2 = list.indexOf(ACTION_PLAY);
        if (this.f12147x) {
            i = list.indexOf(ACTION_PREVIOUS);
        } else if (this.f12111B) {
            i = list.indexOf(ACTION_REWIND);
        } else {
            i = -1;
        }
        if (this.f12148y) {
            i2 = list.indexOf(ACTION_NEXT);
        } else if (this.f12112C) {
            i2 = list.indexOf(ACTION_FAST_FORWARD);
        } else {
            i2 = -1;
        }
        int[] iArr = new int[3];
        boolean z = false;
        if (i != -1) {
            iArr[0] = i;
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (player.getPlaybackState() != 4 && player.getPlaybackState() != 1 && player.getPlayWhenReady()) {
            z = true;
        }
        if (indexOf != -1 && z) {
            i4 = i3 + 1;
            iArr[i3] = indexOf;
        } else {
            if (indexOf2 != -1 && !z) {
                i4 = i3 + 1;
                iArr[i3] = indexOf2;
            }
            if (i2 != -1) {
                iArr[i3] = i2;
                i3++;
            }
            return Arrays.copyOf(iArr, i3);
        }
        i3 = i4;
        if (i2 != -1) {
        }
        return Arrays.copyOf(iArr, i3);
    }

    public List<String> getActions(Player player) {
        boolean isCommandAvailable = player.isCommandAvailable(7);
        boolean isCommandAvailable2 = player.isCommandAvailable(11);
        boolean isCommandAvailable3 = player.isCommandAvailable(12);
        boolean isCommandAvailable4 = player.isCommandAvailable(9);
        ArrayList arrayList = new ArrayList();
        if (this.f12145v && isCommandAvailable) {
            arrayList.add(ACTION_PREVIOUS);
        }
        if (this.f12149z && isCommandAvailable2) {
            arrayList.add(ACTION_REWIND);
        }
        if (this.f12113D) {
            if (player.getPlaybackState() != 4 && player.getPlaybackState() != 1 && player.getPlayWhenReady()) {
                arrayList.add(ACTION_PAUSE);
            } else {
                arrayList.add(ACTION_PLAY);
            }
        }
        if (this.f12110A && isCommandAvailable3) {
            arrayList.add(ACTION_FAST_FORWARD);
        }
        if (this.f12146w && isCommandAvailable4) {
            arrayList.add(ACTION_NEXT);
        }
        CustomActionReceiver customActionReceiver = this.f12129f;
        if (customActionReceiver != null) {
            arrayList.addAll(customActionReceiver.getCustomActions(player));
        }
        if (this.f12114E) {
            arrayList.add(ACTION_STOP);
        }
        return arrayList;
    }

    public boolean getOngoing(Player player) {
        int playbackState = player.getPlaybackState();
        if ((playbackState == 2 || playbackState == 3) && player.getPlayWhenReady()) {
            return true;
        }
        return false;
    }

    public final void invalidate() {
        if (this.f12142s) {
            Handler handler = this.f12130g;
            if (!handler.hasMessages(0)) {
                handler.sendEmptyMessage(0);
            }
        }
    }

    public final void setBadgeIconType(int i) {
        if (this.f12115F == i) {
            return;
        }
        if (i != 0 && i != 1 && i != 2) {
            throw new IllegalArgumentException();
        }
        this.f12115F = i;
        invalidate();
    }

    public final void setColor(int i) {
        if (this.f12118I != i) {
            this.f12118I = i;
            invalidate();
        }
    }

    public final void setColorized(boolean z) {
        if (this.f12116G != z) {
            this.f12116G = z;
            invalidate();
        }
    }

    public final void setDefaults(int i) {
        if (this.f12117H != i) {
            this.f12117H = i;
            invalidate();
        }
    }

    public final void setMediaSessionToken(MediaSessionCompat.Token token) {
        if (!Util.areEqual(this.f12144u, token)) {
            this.f12144u = token;
            invalidate();
        }
    }

    public final void setPlayer(@Nullable Player player) {
        boolean z;
        boolean z2 = true;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            z = true;
        } else {
            z = false;
        }
        Assertions.checkState(z);
        if (player != null && player.getApplicationLooper() != Looper.getMainLooper()) {
            z2 = false;
        }
        Assertions.checkArgument(z2);
        Player player2 = this.f12141r;
        if (player2 == player) {
            return;
        }
        k62 k62Var = this.f12133j;
        if (player2 != null) {
            player2.removeListener(k62Var);
            if (player == null) {
                m2913c(false);
            }
        }
        this.f12141r = player;
        if (player != null) {
            player.addListener(k62Var);
            Handler handler = this.f12130g;
            if (!handler.hasMessages(0)) {
                handler.sendEmptyMessage(0);
            }
        }
    }

    public final void setPriority(int i) {
        if (this.f12121L == i) {
            return;
        }
        if (i != -2 && i != -1 && i != 0 && i != 1 && i != 2) {
            throw new IllegalArgumentException();
        }
        this.f12121L = i;
        invalidate();
    }

    public final void setSmallIcon(@DrawableRes int i) {
        if (this.f12119J != i) {
            this.f12119J = i;
            invalidate();
        }
    }

    public final void setUseChronometer(boolean z) {
        if (this.f12122M != z) {
            this.f12122M = z;
            invalidate();
        }
    }

    public final void setUseFastForwardAction(boolean z) {
        if (this.f12110A != z) {
            this.f12110A = z;
            invalidate();
        }
    }

    public final void setUseFastForwardActionInCompactView(boolean z) {
        if (this.f12112C != z) {
            this.f12112C = z;
            if (z) {
                this.f12148y = false;
            }
            invalidate();
        }
    }

    public final void setUseNextAction(boolean z) {
        if (this.f12146w != z) {
            this.f12146w = z;
            invalidate();
        }
    }

    public final void setUseNextActionInCompactView(boolean z) {
        if (this.f12148y != z) {
            this.f12148y = z;
            if (z) {
                this.f12112C = false;
            }
            invalidate();
        }
    }

    public final void setUsePlayPauseActions(boolean z) {
        if (this.f12113D != z) {
            this.f12113D = z;
            invalidate();
        }
    }

    public final void setUsePreviousAction(boolean z) {
        if (this.f12145v != z) {
            this.f12145v = z;
            invalidate();
        }
    }

    public final void setUsePreviousActionInCompactView(boolean z) {
        if (this.f12147x != z) {
            this.f12147x = z;
            if (z) {
                this.f12111B = false;
            }
            invalidate();
        }
    }

    public final void setUseRewindAction(boolean z) {
        if (this.f12149z != z) {
            this.f12149z = z;
            invalidate();
        }
    }

    public final void setUseRewindActionInCompactView(boolean z) {
        if (this.f12111B != z) {
            this.f12111B = z;
            if (z) {
                this.f12147x = false;
            }
            invalidate();
        }
    }

    public final void setUseStopAction(boolean z) {
        if (this.f12114E == z) {
            return;
        }
        this.f12114E = z;
        invalidate();
    }

    public final void setVisibility(int i) {
        if (this.f12120K == i) {
            return;
        }
        if (i != -1 && i != 0 && i != 1) {
            throw new IllegalStateException();
        }
        this.f12120K = i;
        invalidate();
    }

    /* loaded from: classes.dex */
    public static class Builder {
        protected int channelDescriptionResourceId;
        protected final String channelId;
        protected int channelImportance;
        protected int channelNameResourceId;
        protected final Context context;

        @Nullable
        protected CustomActionReceiver customActionReceiver;
        protected int fastForwardActionIconResourceId;

        @Nullable
        protected String groupKey;
        protected MediaDescriptionAdapter mediaDescriptionAdapter;
        protected int nextActionIconResourceId;
        protected final int notificationId;

        @Nullable
        protected NotificationListener notificationListener;
        protected int pauseActionIconResourceId;
        protected int playActionIconResourceId;
        protected int previousActionIconResourceId;
        protected int rewindActionIconResourceId;
        protected int smallIconResourceId;
        protected int stopActionIconResourceId;

        @Deprecated
        public Builder(Context context, int i, String str, MediaDescriptionAdapter mediaDescriptionAdapter) {
            this(context, i, str);
            this.mediaDescriptionAdapter = mediaDescriptionAdapter;
        }

        public PlayerNotificationManager build() {
            int i = this.channelNameResourceId;
            if (i != 0) {
                NotificationUtil.createNotificationChannel(this.context, this.channelId, i, this.channelDescriptionResourceId, this.channelImportance);
            }
            return new PlayerNotificationManager(this.context, this.channelId, this.notificationId, this.mediaDescriptionAdapter, this.notificationListener, this.customActionReceiver, this.smallIconResourceId, this.playActionIconResourceId, this.pauseActionIconResourceId, this.stopActionIconResourceId, this.rewindActionIconResourceId, this.fastForwardActionIconResourceId, this.previousActionIconResourceId, this.nextActionIconResourceId, this.groupKey);
        }

        public Builder setChannelDescriptionResourceId(int i) {
            this.channelDescriptionResourceId = i;
            return this;
        }

        public Builder setChannelImportance(int i) {
            this.channelImportance = i;
            return this;
        }

        public Builder setChannelNameResourceId(int i) {
            this.channelNameResourceId = i;
            return this;
        }

        public Builder setCustomActionReceiver(CustomActionReceiver customActionReceiver) {
            this.customActionReceiver = customActionReceiver;
            return this;
        }

        public Builder setFastForwardActionIconResourceId(int i) {
            this.fastForwardActionIconResourceId = i;
            return this;
        }

        public Builder setGroup(String str) {
            this.groupKey = str;
            return this;
        }

        public Builder setMediaDescriptionAdapter(MediaDescriptionAdapter mediaDescriptionAdapter) {
            this.mediaDescriptionAdapter = mediaDescriptionAdapter;
            return this;
        }

        public Builder setNextActionIconResourceId(int i) {
            this.nextActionIconResourceId = i;
            return this;
        }

        public Builder setNotificationListener(NotificationListener notificationListener) {
            this.notificationListener = notificationListener;
            return this;
        }

        public Builder setPauseActionIconResourceId(int i) {
            this.pauseActionIconResourceId = i;
            return this;
        }

        public Builder setPlayActionIconResourceId(int i) {
            this.playActionIconResourceId = i;
            return this;
        }

        public Builder setPreviousActionIconResourceId(int i) {
            this.previousActionIconResourceId = i;
            return this;
        }

        public Builder setRewindActionIconResourceId(int i) {
            this.rewindActionIconResourceId = i;
            return this;
        }

        public Builder setSmallIconResourceId(int i) {
            this.smallIconResourceId = i;
            return this;
        }

        public Builder setStopActionIconResourceId(int i) {
            this.stopActionIconResourceId = i;
            return this;
        }

        public Builder(Context context, @IntRange(from = 1) int i, String str) {
            Assertions.checkArgument(i > 0);
            this.context = context;
            this.notificationId = i;
            this.channelId = str;
            this.channelImportance = 2;
            this.mediaDescriptionAdapter = new DefaultMediaDescriptionAdapter(null);
            this.smallIconResourceId = R.drawable.exo_notification_small_icon;
            this.playActionIconResourceId = R.drawable.exo_notification_play;
            this.pauseActionIconResourceId = R.drawable.exo_notification_pause;
            this.stopActionIconResourceId = R.drawable.exo_notification_stop;
            this.rewindActionIconResourceId = R.drawable.exo_notification_rewind;
            this.fastForwardActionIconResourceId = R.drawable.exo_notification_fastforward;
            this.previousActionIconResourceId = R.drawable.exo_notification_previous;
            this.nextActionIconResourceId = R.drawable.exo_notification_next;
        }
    }
}
