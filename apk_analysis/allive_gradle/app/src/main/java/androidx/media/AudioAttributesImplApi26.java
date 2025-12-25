package androidx.media;

import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

@RequiresApi(26)
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class AudioAttributesImplApi26 extends AudioAttributesImplApi21 {
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public AudioAttributesImplApi26() {
    }

    @Override // androidx.media.AudioAttributesImplApi21, androidx.media.AudioAttributesImpl
    public int getVolumeControlStream() {
        int volumeControlStream;
        volumeControlStream = this.mAudioAttributes.getVolumeControlStream();
        return volumeControlStream;
    }
}
