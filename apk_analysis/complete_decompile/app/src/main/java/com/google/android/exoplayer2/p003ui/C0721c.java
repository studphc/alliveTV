package com.google.android.exoplayer2.p003ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.p003ui.PlayerNotificationManager;

/* renamed from: com.google.android.exoplayer2.ui.c */
/* loaded from: classes.dex */
public final class C0721c extends BroadcastReceiver {

    /* renamed from: a */
    public final /* synthetic */ PlayerNotificationManager f12330a;

    public C0721c(PlayerNotificationManager playerNotificationManager) {
        this.f12330a = playerNotificationManager;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        PlayerNotificationManager.CustomActionReceiver customActionReceiver;
        PlayerNotificationManager playerNotificationManager = this.f12330a;
        Player player = playerNotificationManager.f12141r;
        if (player != null && playerNotificationManager.f12142s) {
            int i = playerNotificationManager.f12138o;
            if (intent.getIntExtra(PlayerNotificationManager.EXTRA_INSTANCE_ID, i) == i) {
                String action = intent.getAction();
                if (PlayerNotificationManager.ACTION_PLAY.equals(action)) {
                    if (player.getPlaybackState() == 1) {
                        player.prepare();
                    } else if (player.getPlaybackState() == 4) {
                        player.seekToDefaultPosition(player.getCurrentMediaItemIndex());
                    }
                    player.play();
                    return;
                }
                if (PlayerNotificationManager.ACTION_PAUSE.equals(action)) {
                    player.pause();
                    return;
                }
                if (PlayerNotificationManager.ACTION_PREVIOUS.equals(action)) {
                    player.seekToPrevious();
                    return;
                }
                if (PlayerNotificationManager.ACTION_REWIND.equals(action)) {
                    player.seekBack();
                    return;
                }
                if (PlayerNotificationManager.ACTION_FAST_FORWARD.equals(action)) {
                    player.seekForward();
                    return;
                }
                if (PlayerNotificationManager.ACTION_NEXT.equals(action)) {
                    player.seekToNext();
                    return;
                }
                if (PlayerNotificationManager.ACTION_STOP.equals(action)) {
                    player.stop(true);
                    return;
                }
                if ("com.google.android.exoplayer.dismiss".equals(action)) {
                    playerNotificationManager.m2913c(true);
                } else if (action != null && (customActionReceiver = playerNotificationManager.f12129f) != null && playerNotificationManager.f12136m.containsKey(action)) {
                    customActionReceiver.onCustomAction(player, action, intent);
                }
            }
        }
    }
}
