package p000;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class jl1 extends il1 {
    @Override // android.support.v4.media.session.AbstractC0054j, android.support.v4.media.session.MediaControllerCompat.TransportControls
    public final void setPlaybackSpeed(float f) {
        if (f != RecyclerView.f7068F0) {
            this.f429a.setPlaybackSpeed(f);
            return;
        }
        throw new IllegalArgumentException("speed must not be zero");
    }
}
