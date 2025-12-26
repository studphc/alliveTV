package p000;

import android.media.MediaPlayer;
import androidx.leanback.media.MediaPlayerAdapter;

/* loaded from: classes.dex */
public final class xl1 implements MediaPlayer.OnInfoListener {

    /* renamed from: a */
    public final /* synthetic */ MediaPlayerAdapter f28619a;

    public xl1(MediaPlayerAdapter mediaPlayerAdapter) {
        this.f28619a = mediaPlayerAdapter;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        boolean z;
        MediaPlayerAdapter mediaPlayerAdapter = this.f28619a;
        if (i != 701) {
            if (i != 702) {
                z = false;
                boolean onInfo = mediaPlayerAdapter.onInfo(i, i2);
                if (z && !onInfo) {
                    return false;
                }
            }
            mediaPlayerAdapter.f5401r = false;
            mediaPlayerAdapter.m1356a();
        } else {
            mediaPlayerAdapter.f5401r = true;
            mediaPlayerAdapter.m1356a();
        }
        z = true;
        boolean onInfo2 = mediaPlayerAdapter.onInfo(i, i2);
        return z ? true : true;
    }
}
