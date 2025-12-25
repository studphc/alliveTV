package p000;

import android.media.VolumeProvider;
import androidx.media.VolumeProviderCompat;

/* loaded from: classes.dex */
public final class j43 extends VolumeProvider {

    /* renamed from: a */
    public final /* synthetic */ VolumeProviderCompat f20370a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j43(VolumeProviderCompat volumeProviderCompat, int i, int i2, int i3, String str) {
        super(i, i2, i3, str);
        this.f20370a = volumeProviderCompat;
    }

    @Override // android.media.VolumeProvider
    public final void onAdjustVolume(int i) {
        this.f20370a.onAdjustVolume(i);
    }

    @Override // android.media.VolumeProvider
    public final void onSetVolumeTo(int i) {
        this.f20370a.onSetVolumeTo(i);
    }
}
