package com.google.android.exoplayer2.p003ui;

import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.p003ui.PlayerNotificationManager;
import p000.i62;

/* loaded from: classes.dex */
public final class DefaultMediaDescriptionAdapter implements PlayerNotificationManager.MediaDescriptionAdapter {

    /* renamed from: a */
    public final PendingIntent f12011a;

    public DefaultMediaDescriptionAdapter(@Nullable PendingIntent pendingIntent) {
        this.f12011a = pendingIntent;
    }

    @Override // com.google.android.exoplayer2.ui.PlayerNotificationManager.MediaDescriptionAdapter
    @Nullable
    public PendingIntent createCurrentContentIntent(Player player) {
        return this.f12011a;
    }

    @Override // com.google.android.exoplayer2.ui.PlayerNotificationManager.MediaDescriptionAdapter
    @Nullable
    public CharSequence getCurrentContentText(Player player) {
        CharSequence charSequence = player.getMediaMetadata().artist;
        if (!TextUtils.isEmpty(charSequence)) {
            return charSequence;
        }
        return player.getMediaMetadata().albumArtist;
    }

    @Override // com.google.android.exoplayer2.ui.PlayerNotificationManager.MediaDescriptionAdapter
    public CharSequence getCurrentContentTitle(Player player) {
        CharSequence charSequence = player.getMediaMetadata().displayTitle;
        if (!TextUtils.isEmpty(charSequence)) {
            return charSequence;
        }
        CharSequence charSequence2 = player.getMediaMetadata().title;
        if (charSequence2 == null) {
            return "";
        }
        return charSequence2;
    }

    @Override // com.google.android.exoplayer2.ui.PlayerNotificationManager.MediaDescriptionAdapter
    @Nullable
    public Bitmap getCurrentLargeIcon(Player player, PlayerNotificationManager.BitmapCallback bitmapCallback) {
        byte[] bArr = player.getMediaMetadata().artworkData;
        if (bArr == null) {
            return null;
        }
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
    }

    @Override // com.google.android.exoplayer2.ui.PlayerNotificationManager.MediaDescriptionAdapter
    public final /* synthetic */ CharSequence getCurrentSubText(Player player) {
        return i62.m5168a(this, player);
    }
}
