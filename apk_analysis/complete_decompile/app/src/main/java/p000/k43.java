package p000;

import android.media.VolumeProvider;
import androidx.media.VolumeProviderCompat;

/* loaded from: classes.dex */
public final class k43 extends VolumeProvider {

    /* renamed from: a */
    public final /* synthetic */ VolumeProviderCompat f20746a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k43(VolumeProviderCompat volumeProviderCompat, int i, int i2, int i3) {
        super(i, i2, i3);
        this.f20746a = volumeProviderCompat;
    }

    @Override // android.media.VolumeProvider
    public final void onAdjustVolume(int i) {
        this.f20746a.onAdjustVolume(i);
    }

    @Override // android.media.VolumeProvider
    public final void onSetVolumeTo(int i) {
        this.f20746a.onSetVolumeTo(i);
    }
}
